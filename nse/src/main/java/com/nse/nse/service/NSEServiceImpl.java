package com.nse.nse.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nse.nse.model.Datum;
import com.nse.nse.model.NSENiftyData;
import com.nse.nse.model.Root;
import com.nse.nse.repository.NSERepository;

@Service
public class NSEServiceImpl implements NSEService {
	double ceSum = 0.0d;
	double peSum = 0.0d;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	Date date = null;

	@Autowired
	NSERepository nseRepository;

//	public static void main1(String[] args) {
//		double d = 19428.3;
//		// =ROUND(A1/50,0)*50
//		System.out.println(Math.round(d / 50.0) * 50);
//	}

	@Autowired
	WebClient.Builder builder;

	@Override
	@Scheduled(fixedRate = 300000)
	public String getNseNiftyData() throws Exception {
		date = new Date();
		ceSum = 0;
		peSum = 0;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String symbols[] = {  "NIFTY" };
		NSENiftyData nse = new NSENiftyData();

		for (String symbol : symbols) {
			nse = new NSENiftyData();
			WebClient client = WebClient.builder().baseUrl(baseUrl)
					.exchangeStrategies(ExchangeStrategies.builder()
							.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
					.build();

			String response = client.get().uri("/api/option-chain-indices?symbol=" + symbol).retrieve()
					.bodyToMono(String.class).block();
			ObjectMapper om = new ObjectMapper();
			Root root = om.readValue(response, Root.class);

			String expiryDate = root.getRecords().getExpiryDates().get(0);
			List<Datum> listOfDataByValidExpiryDate = root.getRecords().getData().stream()
					.filter(x -> x.getExpiryDate().equals(expiryDate)).collect(Collectors.toList());

			double underlyingValue = 0.0d;
			for (Datum datum : listOfDataByValidExpiryDate) {

				underlyingValue = datum.getcE().getUnderlyingValue();
				if (underlyingValue > 0)
					break;
			}
			double nearestFifty = 0.0d;
			double increaseValue=0.0;
			double tempValue=0.0;
			if (symbol.equals("NIFTY")) {
				increaseValue=50;
				tempValue=500;
				nearestFifty = Math.round(underlyingValue / 50.0) * 50;
			}else {
				increaseValue=100;
				tempValue=1000;
				nearestFifty = Math.round(underlyingValue / 100.0) * 100;
			}
			getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, nearestFifty, ceSum, peSum);

			for (double val = nearestFifty +increaseValue; val <= nearestFifty + tempValue; val = val + increaseValue) {
				getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, val, ceSum, peSum);
			}
			for (double val = nearestFifty - increaseValue; val >= nearestFifty - tempValue; val = val - increaseValue) {
				getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, val, ceSum, peSum);
			}

			Timestamp ts = new Timestamp(date.getTime());

			nse.setUnderlyingValue(underlyingValue);
			nse.setCreatedDate(sdf.format(date));
			nse.setCreatedTime(ts.toString());
			nse.setCe(ceSum);
			nse.setPe(peSum);
			nse.setPcr(peSum / ceSum);
			nse.setNearestValue(nearestFifty);
			nse.setValidExpiryDate(expiryDate);
			nse.setSymbol(symbol);
			nseRepository.save(nse);
		}

		return "Exucution success!";
	}

	public void getSumOfCEPE(String expiryDate, List<Datum> listOfDataByValidExpiryDate, double nearestFifty,
			double ceval, double peval) {

		List<Datum> listOfCEPE = listOfDataByValidExpiryDate.stream().filter(x -> x.getStrikePrice() == nearestFifty)
				.filter(x -> x.getExpiryDate().equals(expiryDate)).collect(Collectors.toList());

		for (Datum datum : listOfCEPE) {

			ceSum += datum.getcE().getChangeinOpenInterest();
			peSum += datum.getpE().getChangeinOpenInterest();

		}
	}

	@Scheduled(cron = "0 0 15 * * ?")
	public String generateNseDataExcel() throws FileNotFoundException {
		date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		List<NSENiftyData> listOfNseNifty = nseRepository.findByDate(sdf.format(date));
		String fileName = "NSE_NIFTY_DATA_" + LocalDate.now() + ".csv";
		PrintWriter writer = new PrintWriter(new File("D:\\Jaga\\web data\\Daily backup\\" + fileName));
		StringBuffer csvHeader = new StringBuffer("");
		csvHeader.append(
				"Id, Creation Date, Creation Time, Underlying Value, CE Value, PE Value,PCR=PE/CE, Nearest Actual Value,Expiry Date,Symbols\n");

		writer.write(csvHeader.toString());
		for (NSENiftyData nsedata : listOfNseNifty) {

			writer.write(nsedata.toString() + "\n");
		}

		writer.close();
		return "downloaded sucessfully";
	}

}

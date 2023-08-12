package com.nse.nse.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nse.nse.model.Datum;
import com.nse.nse.model.Root;

@Service
public class NSEServiceImpl implements NSEService {
	int ceSum = 0;
	int peSum = 0;

	public static void main1(String[] args) {
		double d = 19428.3;
		// =ROUND(A1/50,0)*50
		System.out.println(Math.round(d / 50.0) * 50);
	}

	@Autowired
	WebClient.Builder builder;

	@Override
	public String getNseData() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		WebClient client = WebClient.builder().baseUrl(baseUrl)
				.exchangeStrategies(ExchangeStrategies.builder()
						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
				.build();

		String response = client.get().uri("/api/option-chain-indices?symbol=NIFTY").retrieve().bodyToMono(String.class)
				.block();
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
		double nearestFifty = Math.round(underlyingValue / 50.0) * 50;

		getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, nearestFifty, ceSum, peSum);

		for (double val = nearestFifty + 50; val < 19951; val = val + 50) {
			getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, val, ceSum, peSum);
		}
		for (double val = nearestFifty - 50; val > 18949; val = val - 50) {
			getSumOfCEPE(expiryDate, listOfDataByValidExpiryDate, val, ceSum, peSum);
		}

		System.out.println("CE Sum=" + ceSum);
		System.out.println("PE Sum=" + peSum);

		return response;
	}

	public void getSumOfCEPE(String expiryDate, List<Datum> listOfDataByValidExpiryDate, double nearestFifty, int ceval,
			int peval) {

		List<Datum> listOfCEPE = listOfDataByValidExpiryDate.stream().filter(x -> x.getStrikePrice() == nearestFifty)
				.filter(x -> x.getExpiryDate().equals(expiryDate)).collect(Collectors.toList());

		for (Datum datum : listOfCEPE) {

			ceSum += datum.getcE().getChangeinOpenInterest();
			peSum += datum.getpE().getChangeinOpenInterest();
			System.out.println("actual value=" + nearestFifty + "-----" + datum.getcE().getChangeinOpenInterest()
					+ "------" + datum.getpE().getChangeinOpenInterest());

		}
	}

}

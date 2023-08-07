package com.nse.nse.controller;

import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nse.nse.model.Root;

@CrossOrigin(origins = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY")
@RestController
@RequestMapping(value = "nse/indices")
public class NSEController {
	String baseUrl = "https://www.nseindia.com";

	@Autowired
	WebClient.Builder builder;

	@GetMapping("/api")
	public String getNse() throws JsonMappingException, JsonProcessingException {
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
		System.out.println(root.getRecords());
		System.out.println(root.getRecords().getData());
		System.out.println(root.getRecords().getExpiryDates());
		System.out.println(root.getRecords().getStrikePrices());
		System.out.println(root.getFiltered());
		System.out.println(root.getFiltered().getData());
		System.out.println(root.getFiltered().getcE());
		System.out.println(root.getFiltered().getpE());
		return response;
	}

}

package com.nse.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class NseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NseApplication.class, args);
		// getNseResponse();
	}

	@Bean
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

}

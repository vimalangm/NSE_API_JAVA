package com.nse.nse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableScheduling
public class NseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NseApplication.class, args);
	}

	@Bean
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

}

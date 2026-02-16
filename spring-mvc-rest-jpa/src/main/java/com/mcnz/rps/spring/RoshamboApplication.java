package com.mcnz.rps.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication // This is all you need!
public class RoshamboApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoshamboApplication.class, args);
	}

	// Keeping this as a Bean is correct because it's a third-party tool
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
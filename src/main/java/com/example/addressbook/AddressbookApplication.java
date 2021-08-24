package com.example.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.addressbook.model.Users;

@SpringBootApplication
public class AddressbookApplication {
	private static final Logger log = LoggerFactory.getLogger(AddressbookApplication.class);

	@Value("${pagerduty.api.key}")
	private String apikey;
	
	public static void main(String[] args) {
		SpringApplication.run(AddressbookApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	HttpHeaders createHeaders() {
		return new HttpHeaders() {
			{
				set("Authorization", "Token token=" + apikey);
			}
		};
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			ResponseEntity<Users> responseEntity = 
					  restTemplate.exchange(
					    "https://api.pagerduty.com/users",
					    HttpMethod.GET,
					    new HttpEntity<>(createHeaders()),
					    Users.class
					  );

			Users users = responseEntity.getBody();
			log.info(users.toString());
		};
	}

}

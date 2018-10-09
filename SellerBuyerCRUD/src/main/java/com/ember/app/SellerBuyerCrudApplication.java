package com.ember.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SellerBuyerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerBuyerCrudApplication.class, args);
	}
}

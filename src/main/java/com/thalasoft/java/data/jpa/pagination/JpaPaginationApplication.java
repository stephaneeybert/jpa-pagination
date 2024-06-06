package com.thalasoft.java.data.jpa.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class JpaPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPaginationApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}
}

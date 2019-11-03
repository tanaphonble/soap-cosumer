package com.example.consumingsoapservice;

import com.example.consumingwebservice.wsdl.AddResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingSoapServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingSoapServiceApplication.class, args);
    }

    @Bean
	CommandLineRunner testAdd(CalculatorClient client) {
    	return args -> {
			AddResponse response = client.sum(12, 13);
		};
	}
}

package com.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestaurantKioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantKioskApplication.class, args);
	}

}

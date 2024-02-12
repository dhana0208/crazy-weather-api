package com.launchcode.crazyweatherapi;

import com.launchcode.crazyweatherapi.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CrazyWeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyWeatherApiApplication.class, args);
	}

}

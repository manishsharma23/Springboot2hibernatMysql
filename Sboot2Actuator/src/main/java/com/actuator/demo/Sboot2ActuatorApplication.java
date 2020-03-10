package com.actuator.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.actuator.demo")
public class Sboot2ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sboot2ActuatorApplication.class, args);
	}

}

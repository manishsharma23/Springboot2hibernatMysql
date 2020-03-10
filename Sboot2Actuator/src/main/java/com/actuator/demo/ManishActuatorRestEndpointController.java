package com.actuator.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RestControllerEndpoint(id = "rest-controller-endpoint")
public class ManishActuatorRestEndpointController {

	private static final String template = "rest-controller-endpoint, %s!";
	private final AtomicLong id = new AtomicLong();

	@GetMapping("/rest-controller-endpoint")
	public ResponseEntity<ManishPojo> restControllerEndpoint(
			@RequestParam(defaultValue = "rest-controller-endpoint") String name) {
		return new ResponseEntity<ManishPojo>(new ManishPojo(id.incrementAndGet(), String.format(template, name)),
				HttpStatus.OK);
	}

}

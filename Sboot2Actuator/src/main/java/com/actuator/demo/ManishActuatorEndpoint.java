package com.actuator.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.actuator.demo.ManishPojo;

@Component
@Endpoint(id = "manish-actuator-endpoint")
public class ManishActuatorEndpoint {

	
	private static final String template = "Hello manish-actuator-endpoint, %s!";
	private final AtomicLong counter = new AtomicLong();

	@ReadOperation
	public ManishPojo MyMassage(@RequestParam (defaultValue = "name")String name) {
		return new ManishPojo(counter.incrementAndGet(),String.format(template, name));
		// TODO Auto-generated method stub

	}
	
}

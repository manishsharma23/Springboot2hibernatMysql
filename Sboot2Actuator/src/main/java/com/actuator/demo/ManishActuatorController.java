package com.actuator.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ManishActuatorController {

	private static final String template = "Hello, %s!";
	private final AtomicLong id = new AtomicLong();

	@GetMapping("/testactuator")
	@ResponseBody
	public ManishPojo sayHello(@RequestParam(name = "name", required = false, defaultValue = "manish") String name) {
		return new ManishPojo(id.incrementAndGet(), String.format(template, name));

	}
}

package com.actuator.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.actuator.demo.ManishPojo;

@Component
@ControllerEndpoint(id = "manish-actuator-endpoint-controller")

public class ManishActuatorEndpointController {

	private static final String template = "manish-actuator-endpoint-controller, %s!";
	private final AtomicLong id = new AtomicLong();
 

	@ResponseBody
	@GetMapping("/manish-actuator-endpoint-controller")
	private ManishPojo   sayEndpoint(@RequestParam (defaultValue = "endpoint")String endpoint) {
		return new ManishPojo(id.incrementAndGet(),String.format(template, endpoint));
		// TODO Auto-generated method stub

	}
}


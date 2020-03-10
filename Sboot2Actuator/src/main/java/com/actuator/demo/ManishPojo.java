package com.actuator.demo;

import java.util.concurrent.atomic.AtomicLong;

public class ManishPojo {

	long id;
	public ManishPojo(long id, String massage) {
		super();
		this.id = id;
		this.massage = massage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	String massage;
}

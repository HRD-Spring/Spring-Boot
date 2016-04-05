package com.hrd.spring.model;

public class Customer {

	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}

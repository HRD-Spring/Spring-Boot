package com.hrd.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.spring.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	private static List<Customer> list = new ArrayList<Customer>();
	static {
		list.add(new Customer(1l, "kokpheng"));
		list.add(new Customer(2l, "hoing"));
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomer() {
		return list;
	}
}

package com.hrd.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.spring.model.Customer;

import exception.CustomerNotFoundException;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") Long id) {
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		throw new CustomerNotFoundException();
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		list.add(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				c.setName(customer.getName());
			}
		}
		return customer;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") Long id) {
		Customer customer = null;
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				customer = c;
			}
		}

		if (customer == null) {
			throw new CustomerNotFoundException();
		} else {
			list.remove(customer);
		}

	}
}

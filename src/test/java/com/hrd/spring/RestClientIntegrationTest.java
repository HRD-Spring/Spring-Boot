package com.hrd.spring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.hrd.spring.model.Customer;

public class RestClientIntegrationTest extends Assert {

	RestTemplate template = new RestTemplate();

	private static final String BASE_URI = "http://localhost:8080/customers";

	@Test
	public void testGetAllCustomerGetForObject() {
		RestTemplate template = new RestTemplate();
		List<Customer> list = template.getForObject(BASE_URI, List.class);
		assertNotNull(list);
	}
	
	@Test
	public void testGetAllCustomerGetForEntity() {
		ResponseEntity<List> responseEntity = template.getForEntity(BASE_URI,List.class);
		assertEquals(responseEntity.getStatusCode().value(), 200);
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void testDeleteOperationFailedException() {
		ResponseEntity<String> responseEntity = template.exchange(BASE_URI+"/100", HttpMethod.DELETE, null, String.class);
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void testDeleteOperationsuccess() {
		template.delete(BASE_URI+"/1");
		ResponseEntity<Customer> responseEntity = template.getForEntity(BASE_URI+"/1", Customer.class);
		
	}
}

package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.service.CustomerService;
import com.customer.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService custservice;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/customerlist")
	public List<Customer> getCustomerList() {
		return custservice.getCustomerList();
	}
}

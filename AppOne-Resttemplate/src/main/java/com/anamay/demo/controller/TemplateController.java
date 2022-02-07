package com.anamay.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.feignclients.AppOneFeignClient;
import com.anamay.demo.model.Customer;
import com.anamay.demo.model.CustomerDto;
import com.anamay.demo.service.TemplateService;

@RestController
@RequestMapping("/template")
public class TemplateController {

	private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class); 
	@Autowired
	TemplateService templateService;
	@Autowired
	AppOneFeignClient apponefeign;
	
	/*
	 * Post mapping method
	 */
	@PostMapping("/add")
	public ResponseEntity saveCustomer(@RequestBody Customer customer) {
		LOG.info("save Customer called in controller");
		Customer customeradded=templateService.saveCustomer(customer);
		ResponseEntity<Customer> response=new ResponseEntity<Customer>(customeradded,HttpStatus.OK);
		return response;
		
	}
	
	/*
	 * Show mapping method
	 */
	@GetMapping("/get")
	public ResponseEntity showAllCustomers() throws CustomerNotFoundException{
		LOG.info("show all customers called in controller");
		
		List<Customer> customerlist=templateService.showAllEntries();
		
		ResponseEntity<List<Customer>> response=new ResponseEntity<List<Customer>>(customerlist,HttpStatus.OK);
		return response;
		
	}
	
	/*
	 * Health check end point
	 */
	@GetMapping("/healthcheck")
	public ResponseEntity healthCheck() throws HealthCheckFailed {
		LOG.info("healthcheck called in controller");
		
		String status=templateService.healthcheck();
		ResponseEntity<String> response=new ResponseEntity<String>(status, HttpStatus.OK);
		return response;
		
	}
	
	@GetMapping("/getallfeign")
	public ResponseEntity getCustomersFeign() throws CustomerNotFoundException{
		
		List<Customer> list=templateService.getCustomers();
		ResponseEntity<List<Customer>> response=new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		return response;
		
	}
}

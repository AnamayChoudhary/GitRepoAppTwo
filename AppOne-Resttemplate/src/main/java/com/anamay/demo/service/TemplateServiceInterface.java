package com.anamay.demo.service;

import java.util.List;

import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.model.Customer;

public interface TemplateServiceInterface {
	public Customer saveCustomer(Customer customer);
	public List<Customer> showAllEntries() throws CustomerNotFoundException;
	public String healthcheck() throws HealthCheckFailed ;

}

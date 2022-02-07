package com.anamay.demo.resthelper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.anamay.demo.controller.TemplateController;
import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.model.Customer;
import com.anamay.demo.model.CustomerDto;

@Component
public class TemplateRestHelper implements TemplateRestHelperInterface{
	private RestTemplate restTemplate;
	private static final Logger LOG = LoggerFactory.getLogger(TemplateController.class); 
	
	@Autowired
	public TemplateRestHelper(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate=restTemplateBuilder.build();
	}
	
	public CustomerDto saveCustomerRH(CustomerDto customerdto) {
		LOG.info("save Customer in RH");
		HttpEntity<CustomerDto> entity=new HttpEntity<>(customerdto);
		return restTemplate.postForObject("http://localhost:8080/addcustomer",entity, CustomerDto.class);
	}

	public CustomerDto[] showAllCustomerRH() throws CustomerNotFoundException{
		try {
		LOG.info("show Customer in RH");
		ResponseEntity<CustomerDto[]> response=restTemplate.getForEntity("http://localhost:8080/showcustomers", CustomerDto[].class);
		CustomerDto[] list=response.getBody();
		return list;
		}
		catch(Exception e) {
			throw new CustomerNotFoundException();
		}
		
	}

	public String healthcheckRH() throws HealthCheckFailed {
		LOG.info("healthcheck in RH");
		try {
		ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8080/healthcheck", String.class);
		String status=response.getBody();
		return status;
		}
		catch(Exception e) {
			throw new HealthCheckFailed();
		}
	}

}

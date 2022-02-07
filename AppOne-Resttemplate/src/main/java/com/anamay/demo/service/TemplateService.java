package com.anamay.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anamay.demo.businessobject.TemplateBusiness;
import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.feignclients.AppOneFeignClient;
import com.anamay.demo.mapper.CustomerMapper;
import com.anamay.demo.mapper.CustomerMapperImpl;
import com.anamay.demo.model.Customer;
import com.anamay.demo.model.CustomerDto;

@Service
public class TemplateService implements TemplateServiceInterface{
	
	private static CustomerMapper mapper=new CustomerMapperImpl();
	private static final Logger LOG=LoggerFactory.getLogger(TemplateService.class);
	
	@Autowired
	TemplateBusiness templatebusiness;
	@Autowired
	AppOneFeignClient appFeignClient;
	
	public Customer saveCustomer(Customer customer) {
		LOG.info("save customer in service");
		CustomerDto customerdto=mapper.toDto(customer);
		CustomerDto customerdtoadded;
		customerdtoadded=templatebusiness.saveCustomerBusiness(customerdto);
		
		return mapper.fromDto(customerdtoadded);
		
		
	}
	
	public List<Customer> showAllEntries() throws CustomerNotFoundException{
		LOG.info("show customer in service");
		List<CustomerDto> customerdtolist=templatebusiness.showAllEntriesBusiness();
		Iterator<CustomerDto> dtoiterator=customerdtolist.iterator();
		List<Customer> customerlist=new ArrayList<Customer>();
		while(dtoiterator.hasNext()) {
			customerlist.add(mapper.fromDto(dtoiterator.next()));
		}
		return customerlist;
	}
	
	public String healthcheck() throws HealthCheckFailed {
		LOG.info("healthcheck in service");
		String status=templatebusiness.healthcheckbo();
		return status;
	}

	public List<Customer> getCustomers() {
		LOG.info("show customer by feign in service");
		List<CustomerDto> customerdtolist=appFeignClient.getCustomers();
		Iterator<CustomerDto> dtoiterator=customerdtolist.iterator();
		List<Customer> customerlist=new ArrayList<Customer>();
		while(dtoiterator.hasNext()) {
			customerlist.add(mapper.fromDto(dtoiterator.next()));
		}
		return customerlist;
		
	}

}

package com.anamay.demo.businessobject;

import java.util.List;

import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.model.CustomerDto;

public interface TemplateBusinessInterface {
	public CustomerDto saveCustomerBusiness(CustomerDto customerdto) ;
	public List<CustomerDto> showAllEntriesBusiness() throws CustomerNotFoundException;
	public String healthcheckbo() throws HealthCheckFailed ;

}

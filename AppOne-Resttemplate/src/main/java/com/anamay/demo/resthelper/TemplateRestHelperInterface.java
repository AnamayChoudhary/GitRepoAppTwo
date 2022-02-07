package com.anamay.demo.resthelper;

import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.model.CustomerDto;

public interface TemplateRestHelperInterface {

	public CustomerDto saveCustomerRH(CustomerDto customerdto) ;
	public CustomerDto[] showAllCustomerRH() throws CustomerNotFoundException;
	public String healthcheckRH() throws HealthCheckFailed ;
}

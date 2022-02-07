package com.anamay.demo.businessobject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anamay.demo.controller.TemplateController;
import com.anamay.demo.exception.CustomerNotFoundException;
import com.anamay.demo.exception.HealthCheckFailed;
import com.anamay.demo.model.CustomerDto;
import com.anamay.demo.resthelper.TemplateRestHelper;

@Component
public class TemplateBusiness implements TemplateBusinessInterface{
	private static final Logger LOG = LoggerFactory.getLogger(TemplateBusiness.class); 
	
	@Autowired
	TemplateRestHelper templateresthelper;
	
	/*
	 * Post method
	 */
	public CustomerDto saveCustomerBusiness(CustomerDto customerdto) {
		LOG.info("save Customer called in BO");
		CustomerDto customerdtoadded=templateresthelper.saveCustomerRH(customerdto);
		return customerdtoadded;
		
	}

	/*
	 * Show method
	 */
	public List<CustomerDto> showAllEntriesBusiness() throws CustomerNotFoundException{
		LOG.info("show Customer called in BO");
		CustomerDto[] fetchedlist=templateresthelper.showAllCustomerRH();
		List<CustomerDto> dtolist=new ArrayList<CustomerDto>();
		for(CustomerDto customerdto: fetchedlist) {
			dtolist.add(customerdto);
		}
		return dtolist;
	}

	/*
	 * Healthcheck method
	 */
	public String healthcheckbo() throws HealthCheckFailed {
		LOG.info("healthcheck called in BO");
		String status=templateresthelper.healthcheckRH();
		return status;
	}

}

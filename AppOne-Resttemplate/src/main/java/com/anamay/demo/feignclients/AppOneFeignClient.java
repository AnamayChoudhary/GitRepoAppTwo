package com.anamay.demo.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anamay.demo.model.Customer;
import com.anamay.demo.model.CustomerDto;

@FeignClient(value = "appOneDB", url = "http://localhost:8080")
public interface AppOneFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/showcustomers")
    List<CustomerDto> getCustomers();
	
	

}

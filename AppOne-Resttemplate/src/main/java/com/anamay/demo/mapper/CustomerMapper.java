package com.anamay.demo.mapper;

import org.mapstruct.Mapper;

import com.anamay.demo.model.Customer;
import com.anamay.demo.model.CustomerDto;

@Mapper(
	    componentModel = "spring"
		)
public interface CustomerMapper {
	
	CustomerDto toDto(Customer cust);
	
	Customer fromDto(CustomerDto custdto);
}

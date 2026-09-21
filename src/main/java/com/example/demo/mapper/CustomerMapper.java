package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;

@Component
public class CustomerMapper {

	public Customer toRequest(CustomerRequestDto request){
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		customer.setMobileNo(request.getMobileNo());
		customer.setPanNo(request.getPanNo());
		return customer;
		
	}
	
	public CustomerResponseDto toResponse(Customer cust) {
		CustomerResponseDto cusRes = new CustomerResponseDto();
		cusRes.setId(cust.getId());
		cusRes.setName(cust.getName());
		cusRes.setEmail(cust.getEmail());
		cusRes.setMobileNo(cust.getMobileNo());
		cusRes.setStatus(cust.getStatus());
		cusRes.setCreatedAt(cust.getCreateAt());
		cusRes.setUpdatedAt(cust.getUpdatedAt());
		return cusRes;
	}
}

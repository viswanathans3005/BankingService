package com.example.demo.service;



import java.util.List;

import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.entity.Customer;


public interface CustomerService {

	CustomerResponseDto customerResponse(CustomerRequestDto request);
	CustomerResponseDto getCustomerbyId(Long id);
	List<CustomerResponseDto> getAllCustomer();
}

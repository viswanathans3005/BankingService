package com.example.demo.service;



import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;


public interface CustomerService {

	CustomerResponseDto customerResponse(CustomerRequestDto request);
	CustomerResponseDto getCustomerbyId(Long id);
}

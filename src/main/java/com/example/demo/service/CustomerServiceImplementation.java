package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.enums.CustomerStatus;
import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService{

	private final CustomerRepository custRepo;
	private final CustomerMapper cusMap;
	
	public CustomerServiceImplementation(CustomerRepository custRepo, CustomerMapper cusMap) {
		this.custRepo = custRepo;
		this.cusMap = cusMap;
	}

	@Override
	public CustomerResponseDto customerResponse(CustomerRequestDto request) {
		
		if(custRepo.existsByEmail(request.getEmail())) {
			throw new CustomerAlreadyExistsException("Customer already exists "+request.getEmail());
		}
		Customer cust = cusMap.toRequest(request);
		cust.setStatus(CustomerStatus.ACTIVE);
		cust.setCreateAt(LocalDateTime.now());
		cust.setUpdatedAt(LocalDateTime.now());
		Customer save= custRepo.save(cust);
		return cusMap.toResponse(save);
		
				 	
	}

	@Override
	public CustomerResponseDto getCustomerbyId(Long id) {
		Customer cust = custRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer id not Available :"+id));
	return cusMap.toResponse(cust);
	
	}
	
	

}

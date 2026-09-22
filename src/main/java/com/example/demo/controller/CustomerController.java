package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.CustomerRequestDto;
import com.example.demo.dto.response.CustomerResponseDto;

import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService custService;
	
	public CustomerController(CustomerService custService) {
		this.custService = custService;
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponseDto> saveCustomer(@Valid @RequestBody CustomerRequestDto request){
		 CustomerResponseDto response = custService.customerResponse(request);
		 return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome home";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getCustbyId(@PathVariable Long id){
		CustomerResponseDto cust = custService.getCustomerbyId(id);
		return ResponseEntity.ok(cust);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CustomerResponseDto>> getAllCustResp(){
		List<CustomerResponseDto> cus = custService.getAllCustomer();
		return ResponseEntity.ok(cus);
		
	}
	
	
}

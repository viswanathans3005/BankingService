package com.example.demo.dto.response;

import java.time.LocalDateTime;

import com.example.demo.enums.CustomerStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

	
	private Long id;
	private String name;
	private String email;
	private String mobileNo;
	private CustomerStatus status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
}

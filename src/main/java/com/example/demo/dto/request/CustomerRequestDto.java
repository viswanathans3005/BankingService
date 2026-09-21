package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

	@NotBlank(message="Name is manditory")
	private String name;
	@NotBlank(message="email is manditory")
	@Email(message="Invalid Email Format")
	private String email;
	@NotBlank(message="Mobile Number is Required")
	private String mobileNo;
	@NotBlank(message="Pan Number is Required")
	private String panNo;
	
}

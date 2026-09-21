package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.enums.CustomerStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(nullable=false)
	private String name;
	@Email
	@Column(nullable=false,unique = true)
	private String email;
	@NotBlank
	private String mobileNo;
	@NotBlank
	@Column(nullable=false, unique=true)
	private String panNo;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private CustomerStatus status;
	private LocalDateTime createAt;
	private LocalDateTime updatedAt;
	
	
}

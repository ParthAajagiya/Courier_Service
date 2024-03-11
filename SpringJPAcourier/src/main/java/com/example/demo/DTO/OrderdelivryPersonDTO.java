package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class OrderdelivryPersonDTO 
{
	private Long id;
	private String fullname;
	private String address;
	
	private Long phone;
}

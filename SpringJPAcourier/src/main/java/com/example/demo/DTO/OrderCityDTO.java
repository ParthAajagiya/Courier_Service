package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class OrderCityDTO 
{
	private Long Orders;
	private String City_Name;
}

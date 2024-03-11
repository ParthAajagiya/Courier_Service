package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class OrderCityDTO2 
{
	private String cityname;
	private String Country;
}

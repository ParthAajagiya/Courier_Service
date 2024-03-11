package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class OrderdelivryPersonDTOwithCount 
{
	private Long TotalOrders;
	private Long id;
	private String fullname;
	private String address;
	private String panno;
	private Long phone;
}

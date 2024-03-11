package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@Component
@ToString
public class DoneOrdersDTO 
{
	private String panno;
	private String password;
	private Long oid;
}

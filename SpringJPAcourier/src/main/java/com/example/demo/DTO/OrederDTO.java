package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.DelivryPerson;
import com.example.demo.Entity.PersonEntity;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class OrederDTO {

	private String product;
	private PersonEntity person;
	private OrderCityDTO2 city;
	private OrderdelivryPersonDTO dPerson;
	private String cityname;
	private Double price;
	private Double weight;
	private LocalDate orderdate;
	
}

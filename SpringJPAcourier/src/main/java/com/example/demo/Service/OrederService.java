package com.example.demo.Service;

import java.util.List;

import com.example.demo.DTO.OrderCityDTO;
import com.example.demo.DTO.OrderdelivryPersonDTOwithCount;
import com.example.demo.DTO.OrederDTO;
import com.example.demo.Entity.OrderEntity;

public interface OrederService 
{
	OrederDTO insert(OrderEntity r);
	List<OrederDTO> Select();
	String DeleteByid(Long id);
	List<OrderdelivryPersonDTOwithCount> findBydname(String name);
	List<OrderCityDTO>ordersByCity();

}

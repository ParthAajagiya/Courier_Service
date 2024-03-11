package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.OrderCityDTO;
import com.example.demo.DTO.OrderdelivryPersonDTOwithCount;
import com.example.demo.DTO.OrederDTO;
import com.example.demo.Entity.OrderEntity;
import com.example.demo.Service.OrederService;
import com.example.demo.Service.RegisterService;

@RestController
@RequestMapping("/api/order")
public class OrederController 
{
	@Autowired
	private OrederService service;
	
	@PostMapping
	public OrederDTO Insert(@RequestBody OrderEntity r)
	{
		return service.insert(r);
	}
	
	@GetMapping
	public List<OrederDTO> select()
	{
		return service.Select();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		return service.DeleteByid(id);
	}
	
	@GetMapping("/dperson/{name}")
	public List<OrderdelivryPersonDTOwithCount> FindByDname(@PathVariable("name") String name)
	{
		return service.findBydname(name);
	}
	
	@GetMapping("/citydata")
	public List<OrderCityDTO> GetordersByCity()
	{
		return service.ordersByCity();
	}
	
}

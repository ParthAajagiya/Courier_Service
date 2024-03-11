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

import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.CityEntity;
import com.example.demo.Service.CityService;


@RestController
@RequestMapping("/api/city")
public class CityController 
{
	@Autowired
	private CityService service;
	
	@PostMapping
	public CityEntity Insert(@RequestBody CityEntity r)
	{
		return service.insert(r);
	}
	
	@GetMapping
	public List<CityEntity> select()
	{
		return service.Select();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		return service.DeleteByid(id);
	}
}

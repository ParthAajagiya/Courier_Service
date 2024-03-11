package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DoneOrdersDTO;
import com.example.demo.Entity.DelivryPerson;
import com.example.demo.Service.DelivryPersonService;
import com.example.demo.Service.RegisterService;

@RestController
@RequestMapping("/api/delivry")
public class DelivryPersonController 
{
	@Autowired
	private DelivryPersonService service;
	
	@PostMapping
	public DelivryPerson Insert(@RequestBody DelivryPerson r)
	{
		return service.insert(r);
	}	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		return service.DeleteByid(id);
	}
	
	@PutMapping("/delivered")
	public String doneOrder(@RequestBody DoneOrdersDTO d)
	{
		return service.DoneOrders(d);
	}
}

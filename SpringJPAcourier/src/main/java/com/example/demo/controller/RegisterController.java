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

import com.example.demo.Entity.PersonEntity;

import com.example.demo.Service.RegisterService;

@RestController
@RequestMapping("/api/register")
public class RegisterController 
{
	@Autowired
	private RegisterService service;
	
	@PostMapping
	public PersonEntity Insert(@RequestBody PersonEntity r)
	{
		return service.insert(r);
	}
	
	@GetMapping
	public List<PersonEntity> select()
	{
		return service.Select();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		return service.DeleteByid(id);
	}
}

package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.OrderEntity;
import com.example.demo.Entity.PersonEntity;

public interface RegisterService 
{
	PersonEntity insert(PersonEntity p);
	List<PersonEntity> Select();
	String DeleteByid(Long id);

}

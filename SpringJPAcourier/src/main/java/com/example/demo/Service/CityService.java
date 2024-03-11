package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.PersonEntity;

public interface CityService 
{
	CityEntity insert(CityEntity r);
	List<CityEntity> Select();
	String DeleteByid(Long id);

}

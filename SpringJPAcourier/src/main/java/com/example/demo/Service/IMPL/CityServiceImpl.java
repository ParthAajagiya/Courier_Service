package com.example.demo.Service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CityDao;
import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.OrderEntity;
import com.example.demo.Service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao dao;

	@Override
	public CityEntity insert(CityEntity r) {
		// TODO Auto-generated method stub
		return dao.save(r);
	}

	@Override
	public List<CityEntity> Select() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public String DeleteByid(Long id) {
		CityEntity entity = dao.findById(id).get();
		if(entity!=null)
		{
			dao.deleteById(id);
			return "deleted....";
		}
		else
		{
			return "Try again...";
		}

	}
	
	
	
}

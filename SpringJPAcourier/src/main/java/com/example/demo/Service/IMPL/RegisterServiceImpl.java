package com.example.demo.Service.IMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.RegisterDao;
import com.example.demo.Entity.OrderEntity;
import com.example.demo.Entity.PersonEntity;
import com.example.demo.Service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDao dao;
	
	@Override
	public PersonEntity insert(PersonEntity r) {
		
		return dao.save(r);
	}

	@Override
	public List<PersonEntity> Select() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public String DeleteByid(Long id) {
		PersonEntity entity = dao.findById(id).get();
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

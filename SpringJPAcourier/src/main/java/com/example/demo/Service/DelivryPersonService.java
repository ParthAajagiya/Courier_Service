package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.OrderEntity;
import com.example.demo.DTO.DoneOrdersDTO;
import com.example.demo.Entity.DelivryPerson;

public interface DelivryPersonService 
{
	DelivryPerson insert(DelivryPerson p);
	String DeleteByid(Long id);
	String DoneOrders(DoneOrdersDTO d);

}

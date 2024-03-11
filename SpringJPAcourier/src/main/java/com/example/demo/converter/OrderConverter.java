package com.example.demo.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.CityDao;
import com.example.demo.DAO.DelivryDao;
import com.example.demo.DTO.OrderCityDTO2;
import com.example.demo.DTO.OrderdelivryPersonDTO;
import com.example.demo.DTO.OrederDTO;
import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.DelivryPerson;
import com.example.demo.Entity.OrderEntity;
import com.example.demo.Entity.PersonEntity;
@Component
public class OrderConverter 
{
	
//	public OrderEntity DtoToEntity()
//	{
//		
//	}
//	
	@Autowired
	private CityDao citydao;
	@Autowired
	private DelivryDao ddao;
	
	public OrederDTO EntitytoDto(OrderEntity entity)
	{
		CityEntity city = entity.getCity();
		CityEntity cityEntity = citydao.findById(city.getId()).get();
		OrderCityDTO2 dto2= new OrderCityDTO2();
		dto2.setCityname(cityEntity.getCityname());
		dto2.setCountry(cityEntity.getCountry());
		
		DelivryPerson delivryPerson = entity.getDPerson();
		DelivryPerson delivryPerson2 = ddao.findById(delivryPerson.getId()).get();
		OrderdelivryPersonDTO dpdto= new OrderdelivryPersonDTO();
		dpdto.setId(delivryPerson2.getId());
		dpdto.setFullname(delivryPerson2.getFullname());
		dpdto.setAddress(delivryPerson2.getAddress());
		dpdto.setPhone(delivryPerson2.getPhone());
		
		System.out.println(entity.getPerson());
		OrederDTO dto= new OrederDTO();
		dto.setOrderdate(entity.getOrderdate());
		dto.setPrice(entity.getPrice());
		dto.setWeight(entity.getWeight());
		dto.setPerson(entity.getPerson());
		dto.setCityname(entity.getCityname());
		
		dto.setCity(dto2);
		dto.setDPerson(dpdto);    
		dto.setProduct(entity.getProduct());
		
		return dto;
	}

	
}

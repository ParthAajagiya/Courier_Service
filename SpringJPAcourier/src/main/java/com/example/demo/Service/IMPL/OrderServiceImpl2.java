//package com.example.demo.Service.IMPL;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.DAO.CityDao;
//import com.example.demo.DAO.DelivryDao;
//import com.example.demo.DAO.OrderDao;
//import com.example.demo.DAO.RegisterDao;
//import com.example.demo.DTO.OrderCityDTO;
//import com.example.demo.DTO.OrderdelivryPersonDTO;
//import com.example.demo.DTO.OrderdelivryPersonDTOwithCount;
//import com.example.demo.DTO.OrederDTO;
//import com.example.demo.Entity.CityEntity;
//import com.example.demo.Entity.DelivryPerson;
//import com.example.demo.Entity.OrderEntity;
//import com.example.demo.Entity.PersonEntity;
//import com.example.demo.Service.OrederService;
//import com.example.demo.converter.OrderConverter;
//
//@Service
//public class OrderServiceImpl2 implements OrederService {
//
//	@Autowired
//	private OrderDao dao;
//	
//	@Autowired
//	private CityDao citydao;
//	
//	@Autowired
//	private DelivryDao ddao;
//	
//	@Autowired
//	private OrderConverter converter;
//	
//	@Override
//	public OrederDTO insert(OrderEntity r) {
//		r.setPrice(r.getWeight()*50);
//		r.setOrderdate(LocalDate.now());
//		r.setCityname(r.getPerson().getCity());
//		List<CityEntity> cityname = citydao.findByCityname(r.getCity().getCityname());
//		if(cityname.isEmpty())
//		{
//			CityEntity city = new CityEntity();
//			CityEntity entity = citydao.save(r.getCity());
//			r.setCity(entity);
//		}
//		else
//		{
//			r.setCity(cityname.get(0));
//		}
//		
//		Object obj=null;
//		List<Object> list = dao.GetNewDelivryPersondataByCity(r.getCityname());
//		System.out.println("=============="+list);
//		
//		if(list.isEmpty())
//		{
//			
//			list = dao.GetNewDelivryPersondata();	
//			if(!list.isEmpty())
//			{
//				r.setPrice(r.getPrice()+500);
//			}
//			System.out.println("Nowjbddsuifskadb=============>");
//		}
//		
//		
//		if(!list.isEmpty())
//		{
//			obj=list.get(0);}
//		
//		if(obj!=null)
//		{
//			Object[] arr= (Object[])obj;
//			DelivryPerson delivryPerson = ddao.findByPanno(String.valueOf(arr[1])).get(0);
//			
//			r.setDPerson(delivryPerson);
//		}
//		else
//		{
//			List<Object> info = dao.DelivryPersonInfo(r.getPerson().getCity());
//			if(!info.isEmpty())
//			{
//				Object object = dao.DelivryPersonInfo(r.getCityname()).get(0);
//				Object[] arr2 = (Object[])object;
//				DelivryPerson dp = new DelivryPerson();
//				dp.setId(Long.parseLong(String.valueOf(arr2[1])) );
//				r.setDPerson(dp);
//			}
//			else
//			{
//				Object object = dao.getavailablePerson().get(0);
//				Object[] arr2 = (Object[])object;
//				DelivryPerson dp = new DelivryPerson();
//				r .setPrice(r.getPrice()+500);
//				dp.setId(Long.parseLong(String.valueOf(arr2[1])) );
//				r.setDPerson(dp);
//			}		
//		}
//
//		OrederDTO dto = converter.EntitytoDto(r);
//		dao.save(r);
//		return dto;
//	}
//
//	@Override
//	public List<OrederDTO> Select() {
//		
//		List<OrderEntity> list = dao.findAll();
//		List<OrederDTO> dtos= new ArrayList<>();
//		for(OrderEntity entity:list)
//		{
//			entity.getId();
//			entity.getPerson();
//			entity.getCity();
//			entity.getDPerson();
//			entity.getProduct();
//			
//			dtos.add( converter.EntitytoDto(entity));	
//		}
//		
//		return dtos;
//	}
//
//	public String DeleteByid(Long id) {
//		OrderEntity entity = dao.findById(id).get();
//		if(entity!=null)
//		{
//			dao.deleteById(id);
//			return "deleted....";
//		}
//		else
//		{
//			return "Try again...";
//		}
//	}
//
//	@Override
//	public List<OrderdelivryPersonDTOwithCount> findBydname(String name) {
//		// TODO Auto-generated method stub
//		
//		List<Object> list = dao.findByDPerson(name);
//		List<OrderdelivryPersonDTOwithCount> dtos= new ArrayList<>();
//		for(Object o:list)
//		{
//			Object[] array=(Object[])o;
//			
//			OrderdelivryPersonDTOwithCount dto= new OrderdelivryPersonDTOwithCount();
//			dto.setTotalOrders(Long.parseLong(String.valueOf(array[0]) ) );
//			dto.setId(Long.parseLong(String.valueOf(array[1]) ) );
//			dto.setPhone(Long.parseLong(String.valueOf(array[2]) ));
//			dto.setAddress(String.valueOf(array[3]));
//			dto.setFullname(String.valueOf(array[4]));
//			dto.setPanno(String.valueOf(array[5]) );
//			
//			dtos.add(dto);
//		}
//		
//		return dtos;
//	}
//
//	@Override
//	public List<OrderCityDTO> ordersByCity() {
//		List<Object> list = dao.getOrdersByCity();
//		List<OrderCityDTO> cities= new ArrayList<>();
//		for(Object o:list)
//		{
//			Object[] array=(Object[])o;
//			OrderCityDTO dto= new OrderCityDTO();
//			dto.setOrders(Long.parseLong(String.valueOf(array[0])));
//			dto.setCity_Name(String.valueOf(array[1]));
//			cities.add(dto);
//		}
//		return cities;
//	}
//}

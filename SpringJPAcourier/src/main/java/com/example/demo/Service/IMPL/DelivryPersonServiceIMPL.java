package com.example.demo.Service.IMPL;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CityDao;
import com.example.demo.DAO.DelivryDao;
import com.example.demo.DTO.DoneOrdersDTO;
import com.example.demo.Entity.CityEntity;
import com.example.demo.Entity.DelivryPerson;
import com.example.demo.Service.DelivryPersonService;
@Service
public class DelivryPersonServiceIMPL implements DelivryPersonService {

	@Autowired
	private DelivryDao dao;
	
	@Autowired
	private CityDao citydao;
	@Override
	public DelivryPerson insert(DelivryPerson r) {
		
		CityEntity city= new CityEntity();
		city.setCityname(r.getCity());
		city.setCountry(r.getCountry());
		citydao.save(city);
		
		return dao.save(r);
		
	}

	@Override
	public String DeleteByid(Long id) {
		DelivryPerson entity = dao.findById(id).get();
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

	@Override
	public String DoneOrders(DoneOrdersDTO d) {
	
		DelivryPerson delivryPerson = dao.findByPanno(d.getPanno()).get(0);
		
		String pass = dao.GetpassByPan(delivryPerson.getPanno());
		if(pass.equals(d.getPassword()))
		{
			
			if(delivryPerson.getPanno().equals(d.getPanno()))
			{
				dao.GetOrderdata(d.getOid(), delivryPerson.getId());
				return "done";

			}
			else
			{
				return "No";
			}
			
		}
		else
		{
			return "Password is Wrong....";
		}

			}
}

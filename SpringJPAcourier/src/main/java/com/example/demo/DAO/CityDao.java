package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CityEntity;
import java.util.List;





public interface CityDao extends JpaRepository<CityEntity, Long> {
	List<CityEntity> findByCityname(String cityname);
}

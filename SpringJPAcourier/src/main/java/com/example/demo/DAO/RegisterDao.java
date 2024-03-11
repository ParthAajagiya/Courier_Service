package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PersonEntity;

import java.util.List;


public interface RegisterDao extends JpaRepository<PersonEntity, Long> {
	
}

package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.DelivryPerson;

import jakarta.transaction.Transactional;

import java.util.List;


public interface DelivryDao extends JpaRepository<DelivryPerson, Long> {
	List<DelivryPerson> findByFullname(String fullname);
	List<DelivryPerson> findByPanno(String panno);
	@Modifying
	@Transactional
	@Query(value = "delete from orederdata where id=:id and d_person_id=:did",nativeQuery = true)
	void GetOrderdata(@Param(value = "id") Long id,@Param(value = "did") Long did);
	
	@Query(value = "select password from delivry_person where panno=:pan",nativeQuery = true)
	String GetpassByPan(String pan);
	
}

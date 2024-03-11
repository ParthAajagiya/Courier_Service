package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.OrderEntity;
import java.util.List;

public interface OrderDao extends JpaRepository<OrderEntity, Long> {
	@Query(value = "SELECT COUNT(product) as count, delivry_person.*\r\n" + "FROM orederdata\r\n"
			+ "INNER JOIN delivry_person ON orederdata.d_person_id = delivry_person.id\r\n"
			+ "WHERE fullname = :name\r\n" + "GROUP BY delivry_person.id", nativeQuery = true)
	List<Object> findByDPerson(@Param(value = "name") String name);

	@Query(value = "select count(city_id) as orders,cityname from orederdata join city on orederdata.city_id=city.id group by cityname", nativeQuery = true)
	List<Object> getOrdersByCity();

	@Query(value = "SELECT orederdata.d_person_id, delivry_person.panno \r\n" + "FROM orederdata \r\n"
			+ "RIGHT JOIN delivry_person ON orederdata.d_person_id = delivry_person.id \r\n"
			+ "WHERE orederdata.d_person_id IS NULL\r\n" + "", nativeQuery = true)
	List<Object> GetNewDelivryPersondata();
	
	@Query(value = "SELECT orederdata.d_person_id, delivry_person.panno \r\n"
			+ "FROM orederdata\r\n"
			+ "RIGHT JOIN delivry_person ON orederdata.d_person_id = delivry_person.id \r\n"
			+ "WHERE orederdata.d_person_id IS NULL and city=:cityname",nativeQuery = true)
	List<Object>  GetNewDelivryPersondataByCity(@Param(value = "cityname") String name);

	@Query(value = "SELECT COUNT(o.d_person_id) AS order_count, o.d_person_id \r\n"
			+ "FROM orederdata o \r\n"
			+ "JOIN delivry_person d ON o.d_person_id = d.id \r\n"
			+ "WHERE d.city = :city \r\n"
			+ "GROUP BY o.d_person_id \r\n"
			+ "HAVING COUNT(o.d_person_id) = (\r\n"
			+ "    SELECT MIN(order_count)\r\n"
			+ "    FROM (\r\n"
			+ "        SELECT COUNT(d_person_id) AS order_count    \r\n"
			+ "        FROM orederdata\r\n"
			+ "        WHERE d_person_id IN (SELECT id FROM delivry_person WHERE city = :city)\r\n"
			+ "        GROUP BY d_person_id\r\n"
			+ "    ) AS newsubquery\r\n"
			+ ")\r\n"
			, nativeQuery = true)
	List<Object> DelivryPersonInfo(@Param(value = "city") String City);

	@Query(value = "SELECT COUNT(d_person_id) AS order_count, d_person_id  FROM orederdata \r\n"
			+ "GROUP BY d_person_id \r\n" + "HAVING COUNT(d_person_id) = (\r\n" + "    SELECT MIN(order_count) \r\n"
			+ "    FROM (\r\n" + "        SELECT COUNT(d_person_id) AS order_count \r\n"
			+ "        FROM orederdata \r\n" + "        GROUP BY d_person_id\r\n" + "    ) AS subquery\r\n"
			+ ")", nativeQuery = true)
	List<Object> getavailablePerson();
}

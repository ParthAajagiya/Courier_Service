package com.example.demo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class CityEntity 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String cityname;
	private String Area;
	@Column(unique = true)
	private Long pin;
	private String country;

}

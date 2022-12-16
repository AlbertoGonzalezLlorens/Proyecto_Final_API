package com.crud.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Hotel;

public interface IHotelDAO extends JpaRepository<Hotel, Long>{
	
	public List<Hotel> findAllByNombre(String nombre);
	
	Hotel findByNombre(String poblacion);
	
	/*Hotel findByPais(String pais);*/
	
}

package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Hotel;

public interface IHotelDAO extends JpaRepository<Hotel, Long>{

}

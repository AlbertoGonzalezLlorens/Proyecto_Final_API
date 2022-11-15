package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Habitacion;

public interface IHabitacionDAO extends JpaRepository<Habitacion, Long>{

}

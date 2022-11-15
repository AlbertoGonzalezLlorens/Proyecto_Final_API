package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long>{

}

package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Contacto;

public interface IContactoDAO extends JpaRepository<Contacto, Long>{

}

package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Factura;

public interface IFacturaDAO extends JpaRepository<Factura, Long>{

}

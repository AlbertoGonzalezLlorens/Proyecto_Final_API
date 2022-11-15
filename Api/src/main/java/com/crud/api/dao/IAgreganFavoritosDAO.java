package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.AgreganFavoritos;

public interface IAgreganFavoritosDAO extends JpaRepository<AgreganFavoritos, Long>{

}

package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}

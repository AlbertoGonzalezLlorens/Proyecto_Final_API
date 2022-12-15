package com.crud.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.dto.Role;

public interface IRolDAO extends JpaRepository<Role, Long>{

}

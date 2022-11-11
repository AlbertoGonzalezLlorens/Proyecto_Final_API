package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IRolDAO;
import com.crud.api.dto.Rol;



public class RolServiceImpl implements IRolService{
	
	//Utilizamos los metodos de la interface IRolDAO, es como si instaciaramos.
	@Autowired
	IRolDAO iRolDAO;

	@Override
	public List<Rol> listarRol() {
		
		return iRolDAO.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public Rol rolXID(Long id_rol) {
		
		return iRolDAO.findById(id_rol).get();
	}

	@Override
	public Rol actualizarRol(Rol rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public void eliminarRol(Long id_rol) {
		
		iRolDAO.deleteById(id_rol);
		
	}

}
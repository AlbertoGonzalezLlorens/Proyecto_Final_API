package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IRolDAO;
import com.crud.api.dto.Role;


@Service
public class RolServiceImpl implements IRolService{
	
	//Utilizamos los metodos de la interface IRolDAO, es como si instaciaramos.
	@Autowired
	IRolDAO iRolDAO;

	@Override
	public List<Role> listarRol() {
		
		return iRolDAO.findAll();
	}

	@Override
	public Role guardarRol(Role rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public Role rolXID(Long id_rol) {
		
		return iRolDAO.findById(id_rol).get();
	}

	@Override
	public Role actualizarRol(Role rol) {
		
		return iRolDAO.save(rol);
	}

	@Override
	public void eliminarRol(Long id_rol) {
		
		iRolDAO.deleteById(id_rol);
		
	}

}
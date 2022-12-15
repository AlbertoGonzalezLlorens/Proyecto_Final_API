package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Role;

public interface IRolService {
	
	//Metodos del CRUD
	public List<Role> listarRol(); //Listar All 
	
	public Role guardarRol(Role rol);	//Guarda un Rol CREATE
	
	public Role rolXID(Long id_rol); //Leer datos de un Rol READ
	
	public Role actualizarRol(Role rol); //Actualiza datos del Rol UPDATE
	
	public void eliminarRol(Long id_rol);// Elimina el Rol DELETE

}

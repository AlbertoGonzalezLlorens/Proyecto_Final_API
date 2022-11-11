package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Rol;

public interface IRolService {
	
	//Metodos del CRUD
	public List<Rol> listarRol(); //Listar All 
	
	public Rol guardarRol(Rol rol);	//Guarda un Rol CREATE
	
	public Rol rolXID(Long id_rol); //Leer datos de un Rol READ
	
	public Rol actualizarRol(Rol rol); //Actualiza datos del Rol UPDATE
	
	public void eliminarRol(Long id_rol);// Elimina el Rol DELETE

}

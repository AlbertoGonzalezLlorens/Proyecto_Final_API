package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Contacto;

public interface IContactoService {
	
	//Metodos del CRUD
	public List<Contacto> listarContacto(); //Listar All 
	
	public Contacto guardarContacto(Contacto contacto);	//Guarda un Contacto CREATE
	
	public Contacto contactoXID(Long id_contacto); //Leer datos de un Contacto READ
	
	public Contacto actualizarContacto(Contacto contacto); //Actualiza datos del Contacto UPDATE
	
	public void eliminarContacto(Long id_contacto);// Elimina el Contacto DELETE

}

package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Comentan;

public interface IComentanService {
	
		//Metodos del CRUD
		public List<Comentan> listarComentan(); //Listar All 
		
		public Comentan guardarComentan(Comentan comentan);	//Guarda un Comentan CREATE
		
		public Comentan comentanXID(Long id_comentan); //Leer datos de un Comentan READ
		
		public Comentan actualizarComentan(Comentan comentan); //Actualiza datos del Comentan UPDATE
		
		public void eliminarComentan(Long id_comentan);// Elimina el Comentan DELETE

}

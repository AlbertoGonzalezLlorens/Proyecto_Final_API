package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Buscan;

public interface IBuscanService {
	
		//Metodos del CRUD
		public List<Buscan> listarBuscan(); //Listar All 
		
		public Buscan guardarBuscan(Buscan buscan);	//Guarda un Buscan CREATE
		
		public Buscan buscanXID(Long id_busca); //Leer datos de un Buscan READ
		
		public Buscan actualizarBuscan(Buscan buscan); //Actualiza datos del Buscan UPDATE
		
		public void eliminarBuscan(Long id_busca);// Elimina el Buscan DELETE

}

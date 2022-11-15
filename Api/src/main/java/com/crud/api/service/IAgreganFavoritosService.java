package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.AgreganFavoritos;

public interface IAgreganFavoritosService {
	
		//Metodos del CRUD
		public List<AgreganFavoritos> listarAgreganFavoritos(); //Listar All 
		
		public AgreganFavoritos guardarAgreganFavoritos(AgreganFavoritos agregan_favoritos);	//Guarda un AgreganFavoritos CREATE
		
		public AgreganFavoritos agreganFavoritosXID(Long id_agregan_favoritos); //Leer datos de un AgreganFavoritos READ
		
		public AgreganFavoritos actualizarAgreganFavoritos(AgreganFavoritos agregan_favoritos); //Actualiza datos del AgreganFavoritos UPDATE
		
		public void eliminarAgreganFavoritos(Long id_agregan_favoritos);// Elimina el AgreganFavoritos DELETE

}

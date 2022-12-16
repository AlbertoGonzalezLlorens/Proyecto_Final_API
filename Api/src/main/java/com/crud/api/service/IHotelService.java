package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Hotel;

public interface IHotelService {
	
		//Metodos del CRUD
		public List<Hotel> listarHotel(); //Listar All 
		
		public Hotel guardarHotel(Hotel hotel);	//Guarda un Hotel CREATE
		
		public Hotel hotelXID(Long id_hotel); //Leer datos de un Hotel READ
		
		public List<Hotel> hotelXPoblacion (String poblacion); //Leer datos de un Hotel READ
		
		/*public Hotel hotelXPais (String pais); //Leer datos de un Hotel READ*/
		
		public Hotel actualizarHotel(Hotel hotel); //Actualiza datos del Hotel UPDATE
		
		public void eliminarHotel(Long id_hotel);// Elimina el Hotel DELETE

}

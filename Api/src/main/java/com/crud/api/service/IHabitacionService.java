package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Habitacion;

public interface IHabitacionService {
	
		//Metodos del CRUD
		public List<Habitacion> listarHabitacion(); //Listar All 
		
		public Habitacion guardarHabitacion(Habitacion habitacion);	//Guarda un Habitacion CREATE
		
		public Habitacion habitacionXID(Long id_habitacion); //Leer datos de un Habitacion READ
		
		public Habitacion actualizarHabitacion(Habitacion habitacion); //Actualiza datos del Habitacion UPDATE
		
		public void eliminarHabitacion(Long id_habitacion);// Elimina el Habitacion DELETE

}

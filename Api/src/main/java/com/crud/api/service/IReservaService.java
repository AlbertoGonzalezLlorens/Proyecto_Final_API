package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Reserva;

public interface IReservaService {
	
	//Metodos del CRUD
	public List<Reserva> listarReserva(); //Listar All 
	
	public Reserva guardarReserva(Reserva reserva);	//Guarda un Reserva CREATE
	
	public Reserva reservaXID(Long id_reserva); //Leer datos de un Reserva READ
	
	public Reserva actualizarReserva(Reserva reserva); //Actualiza datos del Reserva UPDATE
	
	public void eliminarReserva(Long id_reserva);// Elimina el Reserva DELETE

}

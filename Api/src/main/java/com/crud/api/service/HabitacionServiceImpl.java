package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IHabitacionDAO;
import com.crud.api.dto.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
	
	//Utilizamos los metodos de la interface IHabitacionDAO, es como si instaciaramos.
	@Autowired
	IHabitacionDAO iHabitacionDAO;

	@Override
	public List<Habitacion> listarHabitacion() {
		
		return iHabitacionDAO.findAll();
	}

	@Override
	public Habitacion guardarHabitacion(Habitacion habitacion) {
		
		return iHabitacionDAO.save(habitacion);
	}

	@Override
	public Habitacion habitacionXID(Long id_habitacion) {
		
		return iHabitacionDAO.findById(id_habitacion).get();
	}

	@Override
	public Habitacion actualizarHabitacion(Habitacion habitacion) {
		
		return iHabitacionDAO.save(habitacion);
	}

	@Override
	public void eliminarHabitacion(Long id_habitacion) {
		
		iHabitacionDAO.deleteById(id_habitacion);
		
	}

}
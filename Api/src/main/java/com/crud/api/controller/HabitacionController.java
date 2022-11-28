package com.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.api.dto.Habitacion;
import com.crud.api.service.HabitacionServiceImpl;

@RestController
@RequestMapping("/api")

public class HabitacionController {

	@Autowired
	HabitacionServiceImpl habitacionServiceImpl;
	
	@GetMapping("/habitaciones")
	public List<Habitacion> listarRoles(){
		return habitacionServiceImpl.listarHabitacion();
	}
	
	@PostMapping("/habitaciones")
	public Habitacion salvarHabitacion(@RequestBody Habitacion habitacion) {
		
		return habitacionServiceImpl.guardarHabitacion(habitacion);
	}
	
	@GetMapping("/habitaciones/{id_habitacion}")
	public Habitacion habitacionXID(@PathVariable(name="id_habitacion") Long id_habitacion) {
		
		Habitacion habitacion_xid= new Habitacion();
		
		habitacion_xid=habitacionServiceImpl.habitacionXID(id_habitacion);
		
		System.out.println("Habitacion XID: "+habitacion_xid);
		
		return habitacion_xid;
	}
	
	@PutMapping("/habitaciones/{id_habitacion}")
	public Habitacion actualizarHabitacion(@PathVariable(name="id_habitacion")Long id_habitacion,@RequestBody Habitacion habitacion) {
		
		Habitacion habitacion_seleccionado= new Habitacion();
		Habitacion habitacion_actualizado= new Habitacion();
		
		habitacion_seleccionado= habitacionServiceImpl.habitacionXID(id_habitacion);
		habitacion_seleccionado.setNum_habitacion(habitacion.getNum_habitacion());
		habitacion_seleccionado.setTipo(habitacion.getTipo());
		habitacion_seleccionado.setDescripcion(habitacion.getDescripcion());
		habitacion_seleccionado.setPrecio(habitacion.getPrecio());
		habitacion_seleccionado.setFoto(habitacion.getFoto());
		habitacion_seleccionado.setHotel(habitacion.getHotel());

		habitacion_actualizado = habitacionServiceImpl.actualizarHabitacion(habitacion_seleccionado);
		
		System.out.println("El habitacion actualizado es: "+ habitacion_actualizado);
		
		return habitacion_actualizado;
	}
	
	@DeleteMapping("/habitaciones/{id_habitacion}")
	public void eleiminarHabitacion(@PathVariable(name="id_habitacion")Long id_habitacion) {
		habitacionServiceImpl.eliminarHabitacion(id_habitacion);
	}
	
	
}
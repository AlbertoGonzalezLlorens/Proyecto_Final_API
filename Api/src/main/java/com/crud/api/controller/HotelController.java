package com.crud.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.dto.Contacto;
import com.crud.api.dto.Hotel;
import com.crud.api.service.HotelServiceImpl;
import com.crud.api.service.ContactoServiceImpl;

@RestController
@RequestMapping("/api")

public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;
	
	@Autowired
	ContactoServiceImpl contactoServiceImpl;

	@GetMapping("/hoteles")
	public List<Hotel> listarRoles() {
		return hotelServiceImpl.listarHotel();
	}

	@PostMapping("/hoteles")
	public Hotel salvarHotel(@RequestBody Hotel hotel) {

		return hotelServiceImpl.guardarHotel(hotel);
	}

	@GetMapping("/hoteles/{id_hotel}")
	public Hotel hotelXID(@PathVariable(name = "id_hotel") Long id_hotel) {

		Hotel hotel_xid = new Hotel();

		hotel_xid = hotelServiceImpl.hotelXID(id_hotel);

		System.out.println("Hotel XID: " + hotel_xid);

		return hotel_xid;
	}
	
	@GetMapping("/hoteles/contactos/{id_hotel}")
	public List<Contacto> hotelXContacto(@PathVariable(name = "id_hotel") Long id_hotel) {
		
		Hotel hotel_xid = new Hotel();

		hotel_xid = hotelServiceImpl.hotelXID(id_hotel);
		return hotel_xid.getContacto();
	}
	
	@GetMapping("/hoteles/ciudad/{poblacion}")
	public List<Hotel> hotelXPoblacion(@PathVariable(name="poblacion") String poblacion) {
	    return hotelServiceImpl.hotelXPoblacion(poblacion);
	}

	@PutMapping("/hoteles/{id_hotel}")
	public Hotel actualizarHotel(@PathVariable(name = "id_hotel") Long id_hotel,@RequestBody Hotel hotel) {

		Hotel hotel_seleccionado = new Hotel();
		Hotel hotel_actualizado = new Hotel();

		hotel_seleccionado = hotelServiceImpl.hotelXID(id_hotel);
		hotel_seleccionado.setNombre(hotel.getNombre());
		hotel_seleccionado.setDescripcion(hotel.getDescripcion());
		hotel_seleccionado.setCategoria(hotel.getCategoria());
		hotel_seleccionado.setFoto(hotel.getFoto());
		hotel_seleccionado.setPais(hotel.getPais());
		hotel_seleccionado.setProvincia(hotel.getProvincia());
		hotel_seleccionado.setPoblacion(hotel.getPoblacion());
		hotel_seleccionado.setDireccion(hotel.getDireccion());
		hotel_seleccionado.setCodigo_postal(hotel.getCodigo_postal());
		hotel_seleccionado.setLongitud(hotel.getLongitud());
		hotel_seleccionado.setLatitud(hotel.getLatitud());
		hotel_seleccionado.setId_registrador(hotel.getId_registrador());
		
		hotel_actualizado = hotelServiceImpl.actualizarHotel(hotel_seleccionado);

		System.out.println("El hotel actualizado es: " + hotel_actualizado);

		return hotel_actualizado;
	}

	@DeleteMapping("/hoteles/{id_hotel}")
	public void eleiminarHotel(@PathVariable(name = "id_hotel") Long id_hotel) {
		hotelServiceImpl.eliminarHotel(id_hotel);
	}

}
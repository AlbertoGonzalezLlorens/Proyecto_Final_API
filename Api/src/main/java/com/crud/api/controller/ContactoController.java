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
import com.crud.api.dto.Contacto;
import com.crud.api.service.ContactoServiceImpl;
import com.crud.api.service.HotelServiceImpl;

@RestController
@RequestMapping("/api")

public class ContactoController {

	@Autowired
	ContactoServiceImpl contactoServiceImpl;
	
	@GetMapping("/contactos")
	public List<Contacto> listarRoles() {
		return contactoServiceImpl.listarContacto();
	}

	@PostMapping("/contactos")
	public Contacto salvarContacto(@RequestBody Contacto contacto) {

		return contactoServiceImpl.guardarContacto(contacto);
	}

	@GetMapping("/contactos/{id_contacto}")
	public Contacto contactoXID(@PathVariable(name = "id_contacto") Long id_contacto) {

		Contacto contacto_xid = new Contacto();

		contacto_xid = contactoServiceImpl.contactoXID(id_contacto);

		System.out.println("Contacto XID: " + contacto_xid);

		return contacto_xid;
	}
	

	@PutMapping("/contactos/{id_contacto}")
	public Contacto actualizarContacto(@PathVariable(name = "id_contacto") Long id_contacto,@RequestBody Contacto contacto) {

		Contacto contacto_seleccionado = new Contacto();
		Contacto contacto_actualizado = new Contacto();

		contacto_seleccionado = contactoServiceImpl.contactoXID(id_contacto);
		contacto_seleccionado.setTelefono_contacto(contacto.getTelefono_contacto());
		contacto_seleccionado.setEmail(contacto.getEmail());
		contacto_seleccionado.setId_hotel(contacto.getId_hotel());
		
		
		contacto_actualizado = contactoServiceImpl.actualizarContacto(contacto_seleccionado);

		System.out.println("El contacto actualizado es: " + contacto_actualizado);

		return contacto_actualizado;
	}

	@DeleteMapping("/contactos/{id_contacto}")
	public void eleiminarContacto(@PathVariable(name = "id_contacto") Long id_contacto) {
		contactoServiceImpl.eliminarContacto(id_contacto);
	}

}
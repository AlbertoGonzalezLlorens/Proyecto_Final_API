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
import com.crud.api.dto.Buscan;
import com.crud.api.service.BuscanServiceImpl;

@RestController
@RequestMapping("/api")

public class BuscanController {

	@Autowired
	BuscanServiceImpl buscanServiceImpl;

	@GetMapping("/busquedas")
	public List<Buscan> listarRoles() {
		return buscanServiceImpl.listarBuscan();
	}

	@PostMapping("/busquedas")
	public Buscan salvarBuscan(Buscan buscan) {

		return buscanServiceImpl.guardarBuscan(buscan);
	}

	@GetMapping("/busquedas/{id_buscan}")
	public Buscan buscanXID(@PathVariable(name = "id_buscan") Long id_buscan) {

		Buscan buscan_xid = new Buscan();

		buscan_xid = buscanServiceImpl.buscanXID(id_buscan);

		System.out.println("Buscan XID: " + buscan_xid);

		return buscan_xid;
	}

	@PutMapping("/busquedas/{id_buscan}")
	public Buscan actualizarBuscan(@PathVariable(name = "id_buscan") Long id_buscan, Buscan buscan) {

		Buscan buscan_seleccionado = new Buscan();
		Buscan buscan_actualizado = new Buscan();

		buscan_seleccionado = buscanServiceImpl.buscanXID(id_buscan);
		buscan_seleccionado.setHotel(buscan.getHotel());
		buscan_seleccionado.setUsuario(buscan.getUsuario());		
		
		buscan_actualizado = buscanServiceImpl.actualizarBuscan(buscan_seleccionado);

		System.out.println("El buscan actualizado es: " + buscan_actualizado);

		return buscan_actualizado;
	}

	@DeleteMapping("/busquedas/{id_buscan}")
	public void eleiminarBuscan(@PathVariable(name = "id_buscan") Long id_buscan) {
		buscanServiceImpl.eliminarBuscan(id_buscan);
	}

}
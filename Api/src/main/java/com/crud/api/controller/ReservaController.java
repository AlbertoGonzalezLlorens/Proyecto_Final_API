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
import com.crud.api.dto.Reserva;
import com.crud.api.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")

public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	@GetMapping("/reservas")
	public List<Reserva> listarRoles() {
		return reservaServiceImpl.listarReserva();
	}

	@PostMapping("/reservas")
	public Reserva salvarReserva( Reserva reserva) {

		return reservaServiceImpl.guardarReserva(reserva);
	}

	@GetMapping("/reservas/{id_reserva}")
	public Reserva reservaXID(@PathVariable(name = "id_reserva") Long id_reserva) {

		Reserva reserva_xid = new Reserva();

		reserva_xid = reservaServiceImpl.reservaXID(id_reserva);

		System.out.println("Reserva XID: " + reserva_xid);

		return reserva_xid;
	}

	@PutMapping("/reservas/{id_reserva}")
	public Reserva actualizarReserva(@PathVariable(name = "id_reserva") Long id_reserva, Reserva reserva) {

		Reserva reserva_seleccionado = new Reserva();
		Reserva reserva_actualizado = new Reserva();

		reserva_seleccionado = reservaServiceImpl.reservaXID(id_reserva);
		reserva_seleccionado.setId_factura(reserva.getId_factura());
		reserva_seleccionado.setId_habitacion(reserva.getId_habitacion());
		reserva_seleccionado.setId_reserva(reserva.getId_reserva());
		reserva_seleccionado.setId_usuario(reserva.getId_usuario());
		reserva_seleccionado.setPrecio_final(reserva.getPrecio_final());
		
		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);

		System.out.println("El reserva actualizado es: " + reserva_actualizado);

		return reserva_actualizado;
	}

	@DeleteMapping("/reservas/{id_reserva}")
	public void eleiminarReserva(@PathVariable(name = "id_reserva") Long id_reserva) {
		reservaServiceImpl.eliminarReserva(id_reserva);
	}

}
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
import com.crud.api.dto.Comentan;
import com.crud.api.service.ComentanServiceImpl;

@RestController
@RequestMapping("/api")

public class ComentanController {

	@Autowired
	ComentanServiceImpl comentanServiceImpl;

	@GetMapping("/comentarios")
	public List<Comentan> listarRoles() {
		return comentanServiceImpl.listarComentan();
	}

	@PostMapping("/comentarios")
	public Comentan salvarComentan(@RequestBody Comentan comentan) {

		return comentanServiceImpl.guardarComentan(comentan);
	}

	@GetMapping("/comentarios/{id_comentan}")
	public Comentan comentanXID(@PathVariable(name = "id_comentan") Long id_comentan) {

		Comentan comentan_xid = new Comentan();

		comentan_xid = comentanServiceImpl.comentanXID(id_comentan);

		System.out.println("Comentan XID: " + comentan_xid);

		return comentan_xid;
	}

	@PutMapping("/comentarios/{id_comentan}")
	public Comentan actualizarComentan(@PathVariable(name = "id_comentan") Long id_comentan,@RequestBody Comentan comentan) {

		Comentan comentan_seleccionado = new Comentan();
		Comentan comentan_actualizado = new Comentan();

		comentan_seleccionado = comentanServiceImpl.comentanXID(id_comentan);
		comentan_seleccionado.setValoracion(comentan.getValoracion());
		comentan_seleccionado.setComentario(comentan.getComentario());
		comentan_seleccionado.setUsuario(comentan.getUsuario());
		comentan_seleccionado.setHotel(comentan.getHotel());
		
		
		comentan_actualizado = comentanServiceImpl.actualizarComentan(comentan_seleccionado);

		System.out.println("El comentan actualizado es: " + comentan_actualizado);

		return comentan_actualizado;
	}

	@DeleteMapping("/comentarios/{id_comentan}")
	public void eleiminarComentan(@PathVariable(name = "id_comentan") Long id_comentan) {
		comentanServiceImpl.eliminarComentan(id_comentan);
	}

}
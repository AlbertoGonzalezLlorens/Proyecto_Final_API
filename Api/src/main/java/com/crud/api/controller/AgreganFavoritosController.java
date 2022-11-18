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
import com.crud.api.dto.AgreganFavoritos;
import com.crud.api.service.AgreganFavoritosServiceImpl;

@RestController
@RequestMapping("/api")

public class AgreganFavoritosController {

	@Autowired
	AgreganFavoritosServiceImpl agregan_favoritoServiceImpl;

	@GetMapping("/favoritos")
	public List<AgreganFavoritos> listarRoles() {
		return agregan_favoritoServiceImpl.listarAgreganFavoritos();
	}

	@PostMapping("/favoritos")
	public AgreganFavoritos salvarAgreganFavorito(@RequestBody AgreganFavoritos agregan_favorito) {

		return agregan_favoritoServiceImpl.guardarAgreganFavoritos(agregan_favorito);
	}

	@GetMapping("/favoritos/{id_agregan_favoritos}")
	public AgreganFavoritos agregan_favoritoXID(@PathVariable(name = "id_agregan_favoritos") Long id_agregan_favorito) {

		AgreganFavoritos agregan_favorito_xid = new AgreganFavoritos();

		agregan_favorito_xid = agregan_favoritoServiceImpl.agreganFavoritosXID(id_agregan_favorito);

		System.out.println("AgreganFavorito XID: " + agregan_favorito_xid);

		return agregan_favorito_xid;
	}

	@PutMapping("/favoritos/{id_agregan_favoritos}")
	public AgreganFavoritos actualizarAgreganFavorito(@PathVariable(name = "id_agregan_favoritos") Long id_agregan_favorito,@RequestBody AgreganFavoritos agregan_favorito) {

		AgreganFavoritos agregan_favorito_seleccionado = new AgreganFavoritos();
		AgreganFavoritos agregan_favorito_actualizado = new AgreganFavoritos();

		agregan_favorito_seleccionado = agregan_favoritoServiceImpl.agreganFavoritosXID(id_agregan_favorito);
		agregan_favorito_seleccionado.setUsuario(agregan_favorito.getUsuario());
		agregan_favorito_seleccionado.setHotel(agregan_favorito.getHotel());
		
		agregan_favorito_actualizado = agregan_favoritoServiceImpl.actualizarAgreganFavoritos(agregan_favorito_seleccionado);

		System.out.println("El agregan_favorito actualizado es: " + agregan_favorito_actualizado);

		return agregan_favorito_actualizado;
	}

	@DeleteMapping("/favoritos/{id_agregan_favoritos}")
	public void eleiminarAgreganFavorito(@PathVariable(name = "id_agregan_favoritos") Long id_agregan_favorito) {
		agregan_favoritoServiceImpl.eliminarAgreganFavoritos(id_agregan_favorito);
	}

}
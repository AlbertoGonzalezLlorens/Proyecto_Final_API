package com.crud.api.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.dto.Usuario;
import com.crud.api.service.UsuarioServiceImpl;
import com.crud.api.dao.IUsuarioDAO;


@RestController
@RequestMapping("/api")

public class UsuarioController {

	private IUsuarioDAO iUsuarioDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuarios/")
	public List<Usuario> listarUsuarios() {
		return usuarioServiceImpl.listarUsuario();
	}

	@GetMapping("/usuarios/{id_usuario}")
	public Usuario usuarioXID(@PathVariable(name="id_usuario") Long id_usuario) {
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=usuarioServiceImpl.usuarioXID(id_usuario);
		
		System.out.println("Rol XID: "+id_usuario);
		
		return usuario_xid;
	}
	
	@GetMapping("/usuarios/username/{username}")
	public List<Usuario> usuarioXusername(@PathVariable(name="username") String username) {
		
		List<Usuario> all_users = new ArrayList<Usuario>();
		List<Usuario> users_username = new ArrayList<Usuario>();
		
		all_users=usuarioServiceImpl.listarUsuario();
		
		for(Usuario user : all_users ) {
			if (user.getUsername().equals(username)) {
				users_username.add(user);
			}
		}
		
		return users_username;
	}
	
	@PostMapping("/usuarios/")
	public Usuario saveUsuario(@RequestBody Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		iUsuarioDAO.save(user);
		return user;
	}
	
	@PutMapping("/usuarios/{id_usuario}")
	public Usuario actualizarUsuario(@PathVariable(name="id_usuario")Long id_usuario,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(id_usuario);
		usuario_seleccionado.setUsername(usuario.getUsername());
		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellidos(usuario.getApellidos());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setPassword(usuario.getPassword());
		usuario_seleccionado.setFoto(usuario.getFoto());
		usuario_seleccionado.setTelefono(usuario.getTelefono());
		usuario_seleccionado.setRol(usuario.getRol());

		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);
		
		System.out.println("El usuario actualizado es: "+ usuario_actualizado);
		
		return usuario_actualizado;
	}
		
	
	@DeleteMapping("/usuarios/{id_usuario}")
	public void eleiminarUsuario(@PathVariable(name="id_usuario")Long id_usuario) {
		usuarioServiceImpl.eliminarUsuario(id_usuario);
	}
	
	
}
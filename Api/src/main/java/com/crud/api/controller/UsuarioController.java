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
import com.crud.api.dto.Usuario;
import com.crud.api.service.UsuarioServiceImpl;


@RestController
@RequestMapping("/api")

public class UsuarioController {

	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarRoles(){
		return usuarioServiceImpl.listarUsuario();
	}
	
	@PostMapping("/usuarios")
	public Usuario salvarUsuario(Usuario usuario) {
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	@GetMapping("/usuarios/{id_usuario}")
	public Usuario usuarioXID(@PathVariable(name="id_usuario") Long id_usuario) {
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=usuarioServiceImpl.usuarioXID(id_usuario);
		
		System.out.println("Usuario XID: "+usuario_xid);
		
		return usuario_xid;
	}
	
	@PutMapping("/usuarios/{id_usuario}")
	public Usuario actualizarUsuario(@PathVariable(name="id_usuario")Long id_usuario,Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(id_usuario);
		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellido(usuario.getApellido());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setContraseña(usuario.getContraseña());
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
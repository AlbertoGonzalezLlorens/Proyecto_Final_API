package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Usuario;

public interface IUsuarioService {
	
		//Metodos del CRUD
		public List<Usuario> listarUsuario(); //Listar All 
		
		public Usuario guardarUsuario(Usuario usuario);	//Guarda un Usuario CREATE
		
		public Usuario usuarioXID(Long id_usuario); //Leer datos de un Usuario READ
		
		public Usuario actualizarUsuario(Usuario usuario); //Actualiza datos del Usuario UPDATE
		
		public void eliminarUsuario(Long id_usuario);// Elimina el Usuario DELETE

}

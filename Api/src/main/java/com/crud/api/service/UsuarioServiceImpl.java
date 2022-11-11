package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IUsuarioDAO;
import com.crud.api.dto.Usuario;

public class UsuarioServiceImpl implements IUsuarioService{
	
	//Utilizamos los metodos de la interface IUsuarioDAO, es como si instaciaramos.
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public List<Usuario> listarUsuario() {
		
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXID(Long id_usuario) {
		
		return iUsuarioDAO.findById(id_usuario).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id_usuario) {
		
		iUsuarioDAO.deleteById(id_usuario);
		
	}

}
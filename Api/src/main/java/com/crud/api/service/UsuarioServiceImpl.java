package com.crud.api.service;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IUsuarioDAO;
import com.crud.api.dto.Usuario;
import com.crud.api.dto.Rol;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService{
	
	//Utilizamos los metodos de la interface IUsuarioDAO, es como si instaciaramos.
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	@Autowired
	RolServiceImpl rolService;
	
	public void UsuaioServiceImpl(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombre()));
		return new User(usuario.getUsername(),usuario.getPassword(), authorities);
	}
	
	

}
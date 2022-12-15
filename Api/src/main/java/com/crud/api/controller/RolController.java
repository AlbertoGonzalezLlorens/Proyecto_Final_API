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
import com.crud.api.dto.Role;
import com.crud.api.service.RolServiceImpl;


@RestController
@RequestMapping("/api")

public class RolController {

	
	@Autowired
	RolServiceImpl rolServiceImpl;
	
	@GetMapping("/roles")
	public List<Role> listarRoles(){
		return rolServiceImpl.listarRol();
	}
	
	@PostMapping("/roles")
	public Role salvarRol(@RequestBody Role rol) {
		
		return rolServiceImpl.guardarRol(rol);
	}
	
	@GetMapping("/roles/{id_rol}")
	public Role rolXID(@PathVariable(name="id_rol") Long id_rol) {
		
		Role rol_xid= new Role();
		
		rol_xid=rolServiceImpl.rolXID(id_rol);
		
		System.out.println("Rol XID: "+rol_xid);
		
		return rol_xid;
	}
	
	@PutMapping("/roles/{id_rol}")
	public Role actualizarRol(@PathVariable(name="id_rol")Long id_rol,@RequestBody Role rol) {
		
		Role rol_seleccionado= new Role();
		Role rol_actualizado= new Role();
		
		rol_seleccionado= rolServiceImpl.rolXID(id_rol);
		rol_seleccionado.setNombre(rol.getNombre());

		rol_actualizado = rolServiceImpl.actualizarRol(rol_seleccionado);
		
		System.out.println("El rol actualizado es: "+ rol_actualizado);
		
		return rol_actualizado;
	}
	
	@DeleteMapping("/roles/{id_rol}")
	public void eleiminarRol(@PathVariable(name="id_rol")Long id_rol) {
		rolServiceImpl.eliminarRol(id_rol);
	}
	
	
}


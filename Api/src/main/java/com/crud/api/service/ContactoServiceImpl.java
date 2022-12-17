package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IContactoDAO;
import com.crud.api.dto.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService{
	
	//Utilizamos los metodos de la interface IContactoDAO, es como si instaciaramos.
	@Autowired
	IContactoDAO iContactoDAO;

	@Override
	public List<Contacto> listarContacto() {
		
		return iContactoDAO.findAll();
	}

	@Override
	public Contacto guardarContacto(Contacto contacto) {
		
		return iContactoDAO.save(contacto);
	}

	@Override
	public Contacto contactoXID(Long id_contacto) {
		
		return iContactoDAO.findById(id_contacto).get();
	}
	
	@Override
	public Contacto actualizarContacto(Contacto contacto) {
		
		return iContactoDAO.save(contacto);
	}

	@Override
	public void eliminarContacto(Long id_contacto) {
		
		iContactoDAO.deleteById(id_contacto);
		
	}

}
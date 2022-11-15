package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IComentanDAO;
import com.crud.api.dto.Comentan;


@Service
public class ComentanServiceImpl implements IComentanService{
	
	//Utilizamos los metodos de la interface IComentanDAO, es como si instaciaramos.
	@Autowired
	IComentanDAO iComentanDAO;

	@Override
	public List<Comentan> listarComentan() {
		
		return iComentanDAO.findAll();
	}

	@Override
	public Comentan guardarComentan(Comentan comentan) {
		
		return iComentanDAO.save(comentan);
	}

	@Override
	public Comentan comentanXID(Long id_comentan) {
		
		return iComentanDAO.findById(id_comentan).get();
	}

	@Override
	public Comentan actualizarComentan(Comentan comentan) {
		
		return iComentanDAO.save(comentan);
	}

	@Override
	public void eliminarComentan(Long id_comentan) {
		
		iComentanDAO.deleteById(id_comentan);
		
	}

}
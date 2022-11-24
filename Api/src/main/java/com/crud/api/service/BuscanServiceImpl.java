package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IBuscanDAO;
import com.crud.api.dto.Buscan;


@Service
public class BuscanServiceImpl implements IBuscanService{
	
	//Utilizamos los metodos de la interface IBuscanDAO, es como si instaciaramos.
	@Autowired
	IBuscanDAO iBuscanDAO;

	@Override
	public List<Buscan> listarBuscan() {
		
		return iBuscanDAO.findAll();
	}

	@Override
	public Buscan guardarBuscan(Buscan buscan) {
		
		return iBuscanDAO.save(buscan);
	}

	@Override
	public Buscan buscanXID(Long id_busca) {
		
		return iBuscanDAO.findById(id_busca).get();
	}

	@Override
	public Buscan actualizarBuscan(Buscan buscan) {
		
		return iBuscanDAO.save(buscan);
	}

	@Override
	public void eliminarBuscan(Long id_busca) {
		
		iBuscanDAO.deleteById(id_busca);
		
	}

}
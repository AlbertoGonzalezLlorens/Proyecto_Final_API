package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IFacturaDAO;
import com.crud.api.dto.Factura;


@Service
public class FacturaServiceImpl implements IFacturaService{
	
	//Utilizamos los metodos de la interface IFacturaDAO, es como si instaciaramos.
	@Autowired
	IFacturaDAO iFacturaDAO;

	@Override
	public List<Factura> listarFactura() {
		
		return iFacturaDAO.findAll();
	}

	@Override
	public Factura guardarFactura(Factura factura) {
		
		return iFacturaDAO.save(factura);
	}

	@Override
	public Factura facturaXID(Long id_factura) {
		
		return iFacturaDAO.findById(id_factura).get();
	}

	@Override
	public Factura actualizarFactura(Factura factura) {
		
		return iFacturaDAO.save(factura);
	}

	@Override
	public void eliminarFactura(Long id_factura) {
		
		iFacturaDAO.deleteById(id_factura);
		
	}

}
package com.crud.api.service;

import java.util.List;

import com.crud.api.dto.Factura;

public interface IFacturaService {
	
	//Metodos del CRUD
	public List<Factura> listarFactura(); //Listar All 
	
	public Factura guardarFactura(Factura factura);	//Guarda un Factura CREATE
	
	public Factura facturaXID(Long id_factura); //Leer datos de un Factura READ
	
	public Factura actualizarFactura(Factura factura); //Actualiza datos del Factura UPDATE
	
	public void eliminarFactura(Long id_factura);// Elimina el Factura DELETE

}

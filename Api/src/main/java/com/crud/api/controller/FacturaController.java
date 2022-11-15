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
import com.crud.api.dto.Factura;
import com.crud.api.service.FacturaServiceImpl;


@RestController
@RequestMapping("/api")

public class FacturaController {

	
	@Autowired
	FacturaServiceImpl facturaServiceImpl;
	
	@GetMapping("/facturas")
	public List<Factura> listarFacturaes(){
		return facturaServiceImpl.listarFactura();
	}
	
	@PostMapping("/facturas")
	public Factura salvarFactura(Factura factura) {
		
		return facturaServiceImpl.guardarFactura(factura);
	}
	
	@GetMapping("/facturas/{id_factura}")
	public Factura facturaXID(@PathVariable(name="id_factura") Long id_factura) {
		
		Factura factura_xid= new Factura();
		
		factura_xid=facturaServiceImpl.facturaXID(id_factura);
		
		System.out.println("Factura XID: "+factura_xid);
		
		return factura_xid;
	}
	
	@PutMapping("/facturas/{id_factura}")
	public Factura actualizarFactura(@PathVariable(name="id_factura")Long id_factura,Factura factura) {
		
		Factura factura_seleccionado= new Factura();
		Factura factura_actualizado= new Factura();
		
		factura_seleccionado= facturaServiceImpl.facturaXID(id_factura);
		factura_seleccionado.setFecha_inicio(factura.getFecha_inicio());
		factura_seleccionado.setFecha_fin(factura.getFecha_fin());
		factura_seleccionado.setDesayuno(factura.isDesayuno());
		factura_seleccionado.setNumero_personas(factura.getNumero_personas());
		factura_actualizado = facturaServiceImpl.actualizarFactura(factura_seleccionado);
		
		System.out.println("El factura actualizado es: "+ factura_actualizado);
		
		return factura_actualizado;
	}
	
	@DeleteMapping("/facturas/{id_factura}")
	public void eleiminarFactura(@PathVariable(name="id_factura")Long id_factura) {
		facturaServiceImpl.eliminarFactura(id_factura);
	}
	
	
}


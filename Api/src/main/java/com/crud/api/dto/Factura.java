package com.crud.api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facturas")//en caso que la tabla sea diferente
public class Factura {
	
	//Atributos de entidad hotel
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id_factura;
		@Column(name = "fecha_inicio")//no hace falta si se llama igual
		private Date fecha_inicio;
		@Column(name = "fecha_fin")//no hace falta si se llama igual
		private Date fecha_fin;
		@Column(name = "numero_personas")//no hace falta si se llama igual
		private int numero_personas;
		@Column(name = "desayuno")//no hace falta si se llama igual
		private boolean desayuno;
		
		@OneToMany
	    @JoinColumn(name="id_factura")
	    private List<Reserva> reservas;

	public Factura() {
		
	}

	/**
	 * @param id_factura
	 * @param fecha_inicio
	 * @param fecha_fin
	 * @param numero_personas
	 * @param desayuno
	 * @param reservas
	 */
	public Factura(Long id_factura, Date fecha_inicio, Date fecha_fin, int numero_personas, boolean desayuno, List<Reserva> reservas) {
		super();
		this.id_factura = id_factura;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.numero_personas = numero_personas;
		this.desayuno = desayuno;
		this.reservas = reservas;
	}

	/**
	 * @return the id_factura
	 */
	public Long getId_factura() {
		return id_factura;
	}

	/**
	 * @param id_factura the id_factura to set
	 */
	public void setId_factura(Long id_factura) {
		this.id_factura = id_factura;
	}

	/**
	 * @return the fecha_inicio
	 */
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	/**
	 * @param fecha_inicio the fecha_inicio to set
	 */
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	/**
	 * @return the fecha_fin
	 */
	public Date getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * @param fecha_fin the fecha_fin to set
	 */
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	/**
	 * @return the numero_personas
	 */
	public int getNumero_personas() {
		return numero_personas;
	}

	/**
	 * @param numero_personas the numero_personas to set
	 */
	public void setNumero_personas(int numero_personas) {
		this.numero_personas = numero_personas;
	}

	/**
	 * @return the desayuno
	 */
	public boolean isDesayuno() {
		return desayuno;
	}

	/**
	 * @param desayuno the desayuno to set
	 */
	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
	}
	
	/**
	 * @return the reservas
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reservar")
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	/**
	 * @param the reservas
	 */
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Factura [id_factura=" + id_factura + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
				+ ", numero_personas=" + numero_personas + ", desayuno=" + desayuno +"]";
	}

	

}

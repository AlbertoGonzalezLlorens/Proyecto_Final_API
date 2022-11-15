package com.crud.api.dto;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservas")//en caso que la tabla sea diferente
public class Reserva {
	//Atributos de entidad Reserva
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id_reserva;
		@Column(name = "precio_final")//no hace falta si se llama igual
		private double precio_final;
		
		@ManyToOne
		@JoinColumn(name="id_usuario")
		private Usuario id_usuario;
		@ManyToOne
		@JoinColumn(name="id_habitacion")
		private Habitacion id_habitacion;
		@ManyToOne
		@JoinColumn(name="id_factura")
		private Factura id_factura;
		
	public Reserva() {
		
	}

	/**
	 * @param id_reserva
	 * @param precio_final
	 * @param id_usuario
	 * @param id_habitacion
	 * @param id_factura
	 */
	public Reserva(Long id_reserva, double precio_final, Usuario id_usuario, Habitacion id_habitacion,
			Factura id_factura) {
		super();
		this.id_reserva = id_reserva;
		this.precio_final = precio_final;
		this.id_usuario = id_usuario;
		this.id_habitacion = id_habitacion;
		this.id_factura = id_factura;
	}

	/**
	 * @return the id_reserva
	 */
	public Long getId_reserva() {
		return id_reserva;
	}

	/**
	 * @param id_reserva the id_reserva to set
	 */
	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	/**
	 * @return the precio_final
	 */
	public double getPrecio_final() {
		return precio_final;
	}

	/**
	 * @param precio_final the precio_final to set
	 */
	public void setPrecio_final(double precio_final) {
		this.precio_final = precio_final;
	}

	/**
	 * @return the id_usuario
	 */
	public Usuario getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @return the id_habitacion
	 */
	public Habitacion getId_habitacion() {
		return id_habitacion;
	}

	/**
	 * @param id_habitacion the id_habitacion to set
	 */
	public void setId_habitacion(Habitacion id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	/**
	 * @return the id_factura
	 */
	public Factura getId_factura() {
		return id_factura;
	}

	/**
	 * @param id_factura the id_factura to set
	 */
	public void setId_factura(Factura id_factura) {
		this.id_factura = id_factura;
	}

	@Override
	public String toString() {
		return "Reserva [id_reserva=" + id_reserva + ", precio_final=" + precio_final + ", id_usuario=" + id_usuario
				+ ", id_habitacion=" + id_habitacion + ", id_factura=" + id_factura + "]";
	}
	
	

}

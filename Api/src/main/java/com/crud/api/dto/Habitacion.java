package com.crud.api.dto;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="habitaciones")//en caso que la tabla sea diferente
public class Habitacion {
	 
		//Atributos de entidad cliente
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db

		private Long id_habitacion;
		@Column(name = "num_habitacion")//no hace falta si se llama igual
		private int num_habitacion;
		@Column(name = "tipo")//no hace falta si se llama igual
		private String tipo;
		@Column(name = "descripcion")//no hace falta si se llama igual
		private String descripcion;
		@Column(name = "precio")//no hace falta si se llama igual
		private double precio;
		@Column(name = "foto")//no hace falta si se llama igual
		private Blob foto;
		
	    @ManyToOne
	    @JoinColumn(name="id_hotel")
	    private Hotel hotel;
	    

		@OneToMany
	    @JoinColumn(name="id_habitacion")
	    private List<Reserva> reservas;
		
		//Constructores
		
		public Habitacion() {
		
		}

		/**

		 * @param id_habitacion
		 * @param num_habitacion
		 * @param tipo
		 * @param descripcion
		 * @param precio
		 * @param foto
		 * @param hotel
		 */
		public Habitacion(Long id_habitacion, int num_habitacion, String tipo, String descripcion, double precio,
				Blob foto, Hotel hotel) {
			super();
			this.id_habitacion = id_habitacion;
			this.num_habitacion = num_habitacion;
			this.tipo = tipo;
			this.descripcion = descripcion;
			this.precio = precio;
			this.foto = foto;
			this.hotel = hotel;
		}
    
    
		//Getters y Setters


		/**
		 * @return the id_habitacion
		 */
		public Long getId_habitacion() {
			return id_habitacion;
		}

		/**
		 * @param id_habitacion the id_habitacion to set
		 */
		public void setId_habitacion(Long id_habitacion) {
			this.id_habitacion = id_habitacion;
		}

		/**
		 * @return the num_habitacion
		 */
		public int getNum_habitacion() {
			return num_habitacion;
		}

		/**
		 * @param num_habitacion the num_habitacion to set
		 */
		public void setNum_habitacion(int num_habitacion) {
			this.num_habitacion = num_habitacion;
		}

		/**
		 * @return the tipo
		 */
		public String getTipo() {
			return tipo;
		}

		/**
		 * @param tipo the tipo to set
		 */
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		/**
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * @param descripcion the descripcion to set
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		/**
		 * @return the precio
		 */
		public double getPrecio() {
			return precio;
		}

		/**
		 * @param precio the precio to set
		 */
		public void setPrecio(double precio) {
			this.precio = precio;
		}

		/**
		 * @return the foto
		 */
		public Blob getFoto() {
			return foto;
		}

		/**
		 * @param foto the foto to set
		 */
		public void setFoto(Blob foto) {
			this.foto = foto;
		}

		
		/*
		 * @return hotel
		 */
		public Hotel getHotel() {
			return hotel;
		}

		/**
		 * @param hotel the hotel to set
		 */
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

	

		/**
		 * @return the hotel
		 */
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
		public List<Reserva> getReservas() {
			return reservas;
		}

		/**
		 * @param video the video to set
		 */
		public void setReservas(List<Reserva> reservas) {
			this.reservas = reservas;
		}


		@Override
		public String toString() {
			return "Habitacion [id_habitacion=" + id_habitacion + ", num_habitacion=" + num_habitacion + ", tipo="
					+ tipo + ", descripcion=" + descripcion + ", precio=" + precio + ", foto=" + foto + ", hotel="
					+ hotel + "]";
		}

		
		
		
		
	}
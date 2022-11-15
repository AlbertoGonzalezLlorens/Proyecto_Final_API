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
@Table(name="hoteles")//en caso que la tabla sea diferente
public class Hotel {
	//Atributos de entidad hotel
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_hotel;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "descripcion")//no hace falta si se llama igual
	private String descripcion;
	@Column(name = "categoria")//no hace falta si se llama igual
	private int categoria;
	@Column(name = "foto")//no hace falta si se llama igual
	private Blob foto;

	
	
	
    @ManyToOne
    @JoinColumn(name="id_registrador")
    private Usuario id_registrador;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<Habitacion> habitaciones;
	
	//Constructores
	
	public Hotel() {
	
	}

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param direccion
	 * @param dni
	 * @param fecha
	 */
	public Hotel(Long id_hotel, String nombre, String descripcion, int categoria,  Blob foto, Usuario id_registrador) {
		//super();
		this.id_hotel = id_hotel;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.foto = foto;
		this.id_registrador=id_registrador;
	}

	
	//Getters y Setters

	/**
	 * @return the id_hotel
	 */
	public Long getId_hotel() {
		return id_hotel;
	}

	/**
	 * @param id_hotel the id_hotel to set
	 */
	public void setId_hotel(Long id_hotel) {
		this.id_hotel = id_hotel;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
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

	/**
	 * @return the id_registrador
	 */
	public Usuario getId_registrador() {
		return id_registrador;
	}

	/**
	 * @param id_registrador the id_registrador to set
	 */
	public void setId_registrador(Usuario id_registrador) {
		this.id_registrador = id_registrador;
	}


	
	/**
	 * @return the habitacion
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Habitacion")
	public List<Habitacion> getHabitacion() {
		return habitaciones;
	}

	/**
	 * @param video the video to set
	 */
	public void setHotel(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria="
				+ categoria + ", foto=" + foto + ", id_registrador=" + id_registrador + "]";
	}
	
	
}

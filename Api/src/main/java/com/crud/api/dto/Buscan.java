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
@Table(name="buscan")//en caso que la tabla sea diferente
public class Buscan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_buscan;
	@ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;
	
	public Buscan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_buscan
	 * @param usuario
	 * @param hotel
	 */
	public Buscan(Long id_buscan, Usuario usuario, Hotel hotel) {
		super();
		this.id_buscan = id_buscan;
		this.usuario = usuario;
		this.hotel = hotel;
	}

	/**
	 * @return the id_buscan
	 */
	public Long getId_buscan() {
		return id_buscan;
	}

	/**
	 * @param id_buscan the id_buscan to set
	 */
	public void setId_buscan(Long id_buscan) {
		this.id_buscan = id_buscan;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the hotel
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

	@Override
	public String toString() {
		return "Buscan [id_buscan=" + id_buscan + ", usuario=" + usuario + ", hotel=" + hotel + "]";
	}
	
	

}

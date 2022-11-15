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
@Table(name="agregan_favoritos")//en caso que la tabla sea diferente
public class AgreganFavoritos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_agregan_favoritos;
	@ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;
	
	public AgreganFavoritos() {
		
	}

	/**
	 * @param id_agregan_favoritos
	 * @param usuario
	 * @param hotel
	 */
	public AgreganFavoritos(Long id_agregan_favoritos, Usuario usuario, Hotel hotel) {
		super();
		this.id_agregan_favoritos = id_agregan_favoritos;
		this.usuario = usuario;
		this.hotel = hotel;
	}

	/**
	 * @return the id_agregan_favoritos
	 */
	public Long getId_agregan_favoritos() {
		return id_agregan_favoritos;
	}

	/**
	 * @param id_agregan_favoritos the id_agregan_favoritos to set
	 */
	public void setId_agregan_favoritos(Long id_agregan_favoritos) {
		this.id_agregan_favoritos = id_agregan_favoritos;
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
		return "AgreganFavoritos [id_agregan_favoritos=" + id_agregan_favoritos + ", usuario=" + usuario + ", hotel="
				+ hotel + "]";
	}
	
	

}

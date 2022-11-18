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
@Table(name="comentan")//en caso que la tabla sea diferente
public class Comentan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_comenta;
	@Column(name = "valoracion")//no hace falta si se llama igual
	private int valoracion;
	@Column(name = "comentario")//no hace falta si se llama igual
	private String comentario;
	@ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
	@ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel hotel;
	
	public Comentan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_comentan
	 * @param valoracion
	 * @param comentario
	 * @param usuario
	 * @param hotel
	 */
	public Comentan(Long id_comentan, int valoracion, String comentario, Usuario usuario, Hotel hotel) {
		super();
		this.id_comenta = id_comentan;
		this.valoracion = valoracion;
		this.comentario = comentario;
		this.usuario = usuario;
		this.hotel = hotel;
	}

	/**
	 * @return the id_comentan
	 */
	public Long getId_comentan() {
		return id_comenta;
	}

	/**
	 * @param id_comentan the id_comentan to set
	 */
	public void setId_comentan(Long id_comenta) {
		this.id_comenta = id_comenta;
	}

	/**
	 * @return the valoracion
	 */
	public int getValoracion() {
		return valoracion;
	}

	/**
	 * @param valoracion the valoracion to set
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		return "Comentan [id_comentan=" + id_comenta + ", valoracion=" + valoracion + ", comentario=" + comentario
				+ ", usuario=" + usuario + ", hotel=" + hotel + "]";
	}
	
	

}

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crud.api.dto.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="roles")
public class Rol {

	//Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_rol;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;

	
    @OneToMany
    @JoinColumn(name="id_rol")
    private List<Usuario> usuario;
	
	//Constructores
	
	public Rol() {
		
	}
	

	/**
	 * @param id_rol
	 * @param nombre
	 */
	public Rol(Long id_rol, String nombre) {
		//super();
		this.id_rol = id_rol;
		this.nombre = nombre;

	}

	
	//Getters y Setters
	
	/**
	 * @return the id
	 */
	public Long getIdRol() {
		return id_rol;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdRol(Long id_rol) {
		this.id_rol = id_rol;
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
	 * @return the usuario
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the video to set
	 */
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Cliente [id_rol=" + id_rol + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
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
@Table(name="contactos")//en caso que la tabla sea diferente
public class Contacto {
	//Atributos de entidad hotel
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_contacto;
	@Column(name = "telefono_contacto")//no hace falta si se llama igual
	private int telefono_contacto;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
		
    @ManyToOne
    @JoinColumn(name="id_hotel")
    private Hotel id_hotel;
   
    
	
	//Constructores
	
	public Contacto() {
	
	}



	/**
	 * @param id_contacto
	 * @param telefono_contacto
	 * @param email
	 * @param id_hotel
	 */
	public Contacto(Long id_contacto, int telefono_contacto, String email, Hotel id_hotel) {
		super();
		this.id_contacto = id_contacto;
		this.telefono_contacto = telefono_contacto;
		this.email = email;
		this.id_hotel = id_hotel;
	}


	//Getters y Setters
	
	/**
	 * @return the id_contacto
	 */
	public Long getId_contacto() {
		return id_contacto;
	}



	/**
	 * @param id_contacto the id_contacto to set
	 */
	public void setId_contacto(Long id_contacto) {
		this.id_contacto = id_contacto;
	}



	/**
	 * @return the telefono_contacto
	 */
	public int getTelefono_contacto() {
		return telefono_contacto;
	}



	/**
	 * @param telefono_contacto the telefono_contacto to set
	 */
	public void setTelefono_contacto(int telefono_contacto) {
		this.telefono_contacto = telefono_contacto;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the id_hotel
	 */
	public Hotel getId_hotel() {
		return id_hotel;
	}



	/**
	 * @param id_hotel the id_hotel to set
	 */
	public void setId_hotel(Hotel id_hotel) {
		this.id_hotel = id_hotel;
	}



	@Override
	public String toString() {
		return "Contacto [id_contacto=" + id_contacto + ", telefono_contacto=" + telefono_contacto + ", email=" + email
				+ ", id_hotel=" + id_hotel + "]";
	}

	
	
}

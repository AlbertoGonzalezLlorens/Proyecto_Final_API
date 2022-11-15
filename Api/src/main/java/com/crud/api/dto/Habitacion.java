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
@Table(name="usuarios")//en caso que la tabla sea diferente
public class Habitacion {
	 
		//Atributos de entidad cliente
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id_usuario;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		@Column(name = "apellido")//no hace falta si se llama igual
		private String apellido;
		@Column(name = "email")//no hace falta si se llama igual
		private String email;
		@Column(name = "contraseña")//no hace falta si se llama igual
		private String contraseña;
		@Column(name = "foto")//no hace falta si se llama igual
		private Blob foto;
		@Column(name = "telefono")//no hace falta si se llama igual
		private int telefono;
		
	    @ManyToOne
	    @JoinColumn(name="id_rol")
	    private Rol rol;
	    @OneToMany
	    @JoinColumn(name="id_usuario")
	    private List<Hotel> hotel;
		
		//Constructores
		
		public Usuario() {
		
		}

		/**
		 * @param id
		 * @param nombre
		 * @param apellido
		 * @param direccion
		 * @param dni
		 * @param fecha
		 */
		public Usuario(Long id_usuario, String nombre, String apellido, String email, String contraseña, Blob foto, int telefono, Rol rol) {
			//super();
			this.id_usuario = id_usuario;
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.contraseña = contraseña;
			this.foto = foto;
			this.telefono = telefono;
			this.rol = rol;
		}

		
		//Getters y Setters
		

		
		/**
		 * @return the id_usuario
		 */
		public Long getId_usuario() {
			return id_usuario;
		}

		/**
		 * @param id_usuario the id_usuario to set
		 */
		public void setId_usuario(Long id_usuario) {
			this.id_usuario = id_usuario;
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
		 * @return the apellido
		 */
		public String getApellido() {
			return apellido;
		}

		/**
		 * @param apellido the apellido to set
		 */
		public void setApellido(String apellido) {
			this.apellido = apellido;
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
		 * @return the contraseña
		 */
		public String getContraseña() {
			return contraseña;
		}

		/**
		 * @param contraseña the contraseña to set
		 */
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
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
		 * @return the telefono
		 */
		public int getTelefono() {
			return telefono;
		}

		/**
		 * @param telefono the telefono to set
		 */
		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		/**
		 * @return the rol
		 */
		public Rol getRol() {
			return rol;
		}

		/**
		 * @param rol the rol to set
		 */
		public void setRol(Rol rol) {
			this.rol = rol;
		}

		/**
		 * @return the video
		 */
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Hotel")
		public List<Hotel> getHotel() {
			return hotel;
		}

		/**
		 * @param video the video to set
		 */
		public void setHotel(List<Hotel> hotel) {
			this.hotel = hotel;
		}

		@Override
		public String toString() {
			return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
					+ email + ", contraseña=" + contraseña + ", foto=" + foto + ", telefono=" + telefono + ", rol=" + rol
					+ "]";
		}


		
		
		
		
	}
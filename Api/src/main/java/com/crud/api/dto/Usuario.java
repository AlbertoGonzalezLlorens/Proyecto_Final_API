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
public class Usuario  {
 
	//Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id_usuario;
	@Column(name = "username")//no hace falta si se llama igual
	private String username;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "apellidos")//no hace falta si se llama igual
	private String apellidos;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
	@Column(name = "password")//no hace falta si se llama igual
	private String password;
	@Column(name = "foto")//no hace falta si se llama igual
	private Blob foto;
	@Column(name = "telefono")//no hace falta si se llama igual
	private int telefono;
	
	
    @ManyToOne
    @JoinColumn(name="id_rol")
    private Role rol;
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Hotel> hotel;
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Reserva> reservas;
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<AgreganFavoritos> agregarFavoritos;
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Comentan> comentan;
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Buscan> buscan;
	
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
	
	public Usuario(Long id_usuario,String username, String nombre, String apellidos, String email, String password, Blob foto, int telefono, Role rol) {
		//super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	public String getPassword() {
		return password;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	public Role getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Role rol) {
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
	
	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reservas;
	}

	/**
	 * @param video the video to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reservas = reservas;
	}
	
	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AgreganFavoritos")
	public List<AgreganFavoritos> getAgreganFavoritos() {
		return agregarFavoritos;
	}

	/**
	 * @param video the video to set
	 */
	public void setAgreganFavoritos(List<AgreganFavoritos> agregarFavoritos) {
		this.agregarFavoritos = agregarFavoritos;
	}
	
	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Comentan")
	public List<Comentan> getComentan() {
		return comentan;
	}

	/**
	 * @param video the video to set
	 */
	public void setComentan(List<Comentan> comentan) {
		this.comentan = comentan;
	}
	
	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Buscan")
	public List<Buscan> getBuscan() {
		return buscan;
	}

	/**
	 * @param video the video to set
	 */
	public void setBuscan(List<Buscan> buscan) {
		this.buscan = buscan;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", foto=" + foto + ", telefono=" + telefono + ", rol=" + rol
				+ "]";
	}
}

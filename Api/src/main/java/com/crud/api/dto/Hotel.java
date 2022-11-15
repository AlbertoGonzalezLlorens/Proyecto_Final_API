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
	@Column(name = "pais")//no hace falta si se llama igual
	private String pais;
	@Column(name = "provincia")//no hace falta si se llama igual
	private String provincia;
	@Column(name = "poblacion")//no hace falta si se llama igual
	private String poblacion;
	@Column(name = "direccion")//no hace falta si se llama igual
	private String direccion;
	@Column(name = "codigo_postal")//no hace falta si se llama igual
	private int codigo_postal;
	@Column(name = "longitud")//no hace falta si se llama igual
	private double longitud;
	@Column(name = "latitud")//no hace falta si se llama igual
	private double latitud;
	
    @ManyToOne
    @JoinColumn(name="id_registrador")
    private Usuario id_registrador;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<Habitacion> habitaciones;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<Contacto> contactos;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<AgreganFavoritos> agregarFavoritos;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<Comentan> comentan;
    @OneToMany
    @JoinColumn(name="id_hotel")
    private List<Buscan> buscan;
    
	
	//Constructores
	
	public Hotel() {
	
	}

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param todos los otros
	 */
	public Hotel(Long id_hotel, String nombre, String descripcion, int categoria,  Blob foto, String pais, String provincia, String poblacion, String direccion, int codigo_postal, double longitud, double latitud, Usuario id_registrador) {
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
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigo_postal
	 */
	public int getCodigo_postal() {
		return codigo_postal;
	}

	/**
	 * @param codigo_postal the codigo_postal to set
	 */
	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	/**
	 * @return the longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the latitud
	 */
	public double getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the habitaciones
	 */
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	/**
	 * @param habitaciones the habitaciones to set
	 */
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
	public void setHabitacion(List<Habitacion> habitaciones) {

		this.habitaciones = habitaciones;
	}
	
	/**
	 * @return the contacto
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Contacto")
	public List<Contacto> getContacto() {
		return contactos;
	}

	/**
	 * @param vthe video to set
	 */
	public void setContacto(List<Contacto> contactos) {

		this.contactos = contactos;
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
		return "Hotel [id_hotel=" + id_hotel + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria="
				+ categoria + ", foto=" + foto + ", pais=" + pais + ", provincia=" + provincia + ", poblacion="
				+ poblacion + ", direccion=" + direccion + ", codigo_postal=" + codigo_postal + ", longitud=" + longitud
				+ ", latitud=" + latitud + ", id_registrador=" + id_registrador + ", habitaciones=" 
				+ habitaciones + ", contactos=" + contactos
				+ "]";
	}

	
	
	
}

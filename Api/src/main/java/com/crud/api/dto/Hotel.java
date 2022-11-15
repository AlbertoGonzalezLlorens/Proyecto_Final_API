package com.crud.api.dto;

public class Hotel {

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< Updated upstream
=======
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
	public void setHabitacion(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria="
				+ categoria + ", foto=" + foto + ", id_registrador=" + id_registrador + "]";
	}
	
	
>>>>>>> Stashed changes
}

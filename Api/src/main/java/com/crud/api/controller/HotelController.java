package com.crud.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.dto.Contacto;
import com.crud.api.dto.Habitacion;
import com.crud.api.dto.Hotel;
import com.crud.api.service.HotelServiceImpl;
import com.crud.api.service.ContactoServiceImpl;

@RestController
@RequestMapping("/api")

public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;
	
	@Autowired
	ContactoServiceImpl contactoServiceImpl;

	@GetMapping("/hoteles")
	public List<Hotel> listarRoles() {
		
		return hotelServiceImpl.listarHotel();
	}

	@PostMapping("/hoteles")
	public Hotel salvarHotel(@RequestBody Hotel hotel) {

		return hotelServiceImpl.guardarHotel(hotel);
	}

	@GetMapping("/hoteles/{id_hotel}")
	public Hotel hotelXID(@PathVariable(name = "id_hotel") Long id_hotel) {

		Hotel hotel_xid = new Hotel();

		hotel_xid = hotelServiceImpl.hotelXID(id_hotel);

		System.out.println("Hotel XID: " + hotel_xid);

		return hotel_xid;
	}
	
	@GetMapping("/hoteles/contactos/{id_hotel}")
	public List<Contacto> hotelXContacto(@PathVariable(name = "id_hotel") Long id_hotel) {
		
		Hotel hotel_xid = new Hotel();

		hotel_xid = hotelServiceImpl.hotelXID(id_hotel);
		return hotel_xid.getContacto();
	}
	
	@GetMapping("/hoteles/categoria/{categoria}")
	public List<Hotel> hotelXCategoria(@PathVariable(name = "categoria") int categoria) {
		
		List<Hotel> todohoteles = new ArrayList<Hotel>();
		List<Hotel> hoteles_categoria = new ArrayList<Hotel>();
		
		todohoteles = hotelServiceImpl.listarHotel();
		
		for(Hotel hotel:todohoteles) {
			if(hotel.getCategoria()==categoria) {
				hoteles_categoria.add(hotel);
			}
		}

		return hoteles_categoria;
	}
	
	@GetMapping("/hoteles/desayuno/yes")
	public List<Hotel> hotelXDesayuno() {
		
		List<Hotel> todohoteles = new ArrayList<Hotel>();
		List<Hotel> hoteles_desayuno = new ArrayList<Hotel>();
		
		
		todohoteles = hotelServiceImpl.listarHotel();
		
		for(Hotel hotel:todohoteles) {
			if(hotel.getDesayuno()==true) {
				hoteles_desayuno.add(hotel);
			}
		}

		return hoteles_desayuno;
	}
	
	@GetMapping("/hoteles/desayuno/no")
	public List<Hotel> hotelXDesayunoNo() {
		
		List<Hotel> todohoteles = new ArrayList<Hotel>();
		List<Hotel> hoteles_desayuno = new ArrayList<Hotel>();
		
		
		todohoteles = hotelServiceImpl.listarHotel();
		
		for(Hotel hotel:todohoteles) {
			if(hotel.getDesayuno()==false) {
				hoteles_desayuno.add(hotel);
			}
		}

		return hoteles_desayuno;
	}
	
	@GetMapping("/hoteles/precio/{precio}")
	public List<Hotel> hotelXPrecio(@PathVariable(name = "precio") double precio) {
		
		List<Hotel> todohoteles = new ArrayList<Hotel>();
		List<Hotel> hoteles_precio = new ArrayList<Hotel>();
		
		
		todohoteles = hotelServiceImpl.listarHotel();
		
		for(Hotel hotel:todohoteles) {
			if(hotel.getPrecioMin()<=precio) {
				hoteles_precio.add(hotel);
			}
		}

		return hoteles_precio;
	}
	
	
	@GetMapping("/hoteles/ciudad/{poblacion}")
	public List<Hotel> hotelXPoblacion(@PathVariable(name="poblacion") String poblacion) {
	    return hotelServiceImpl.hotelXPoblacion(poblacion);
	}
	
	@GetMapping("/hoteles/{poblacion}/{pais}/{precio}/{desayuno}/{categoria}")
	public List<Hotel> hotelXFiltro(@PathVariable(name = "poblacion") String poblacion,
			@PathVariable(name = "pais") String pais, @PathVariable(name = "precio") double precio, 
			@PathVariable(name = "desayuno") String desayuno, @PathVariable(name = "categoria") double categoria) {

		List<Hotel> todohoteles = new ArrayList<Hotel>();
		List<Hotel> hoteles_filtrados = new ArrayList<Hotel>();

		todohoteles = hotelServiceImpl.listarHotel();
		
		for(Hotel hotel:todohoteles) {
			//Solo1
			if(poblacion.equals("a") && pais.equals("a") && precio <=0 && desayuno.equals("a") && categoria>0) {
				if(hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio <=0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio <=0 && desayuno.equals("no") &&categoria==0){
				if(hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPrecioMin()<=precio) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPais().equals(pais)) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion)) {
					hoteles_filtrados.add(hotel);
				}
			}
			//2 a
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais)) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//2b
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPais().equals(pais) && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPais().equals(pais) && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//2c
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPrecioMin()<=precio && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//2d
			
			else if(poblacion.equals("a") && pais.equals("a") && precio==0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getCategoria()==categoria && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio==0 && desayuno.equals("no") && categoria>0){
				if(hotel.getCategoria()==categoria && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3a			
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("a") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getCategoria()<=categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3b
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3c
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getCategoria()==categoria && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getCategoria()==categoria && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3d
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3e
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//3f
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//4a
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("no") && categoria==0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("a") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//4b
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio<=0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//4c
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//4d
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			//5
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("yes") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==true && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
			else if(!poblacion.equals("a") && !pais.equals("a") && precio>0 && desayuno.equals("no") && categoria>0){
				if(hotel.getPoblacion().equals(poblacion) && hotel.getPais().equals(pais) && hotel.getPrecioMin()<=precio && hotel.getDesayuno()==false && hotel.getCategoria()==categoria) {
					hoteles_filtrados.add(hotel);
				}
			}
		}

		return hoteles_filtrados;
	}

	@PutMapping("/hoteles/{id_hotel}")
	public Hotel actualizarHotel(@PathVariable(name = "id_hotel") Long id_hotel,@RequestBody Hotel hotel) {

		Hotel hotel_seleccionado = new Hotel();
		Hotel hotel_actualizado = new Hotel();

		hotel_seleccionado = hotelServiceImpl.hotelXID(id_hotel);
		hotel_seleccionado.setNombre(hotel.getNombre());
		hotel_seleccionado.setDescripcion(hotel.getDescripcion());
		hotel_seleccionado.setCategoria(hotel.getCategoria());
		hotel_seleccionado.setFoto(hotel.getFoto());
		hotel_seleccionado.setPais(hotel.getPais());
		hotel_seleccionado.setProvincia(hotel.getProvincia());
		hotel_seleccionado.setPoblacion(hotel.getPoblacion());
		hotel_seleccionado.setDireccion(hotel.getDireccion());
		hotel_seleccionado.setCodigo_postal(hotel.getCodigo_postal());
		hotel_seleccionado.setLongitud(hotel.getLongitud());
		hotel_seleccionado.setLatitud(hotel.getLatitud());
		hotel_seleccionado.setDesayuno(hotel.getDesayuno());
		hotel_seleccionado.setPrecioMin(hotel.getPrecioMin());
		hotel_seleccionado.setId_registrador(hotel.getId_registrador());
		
		hotel_actualizado = hotelServiceImpl.actualizarHotel(hotel_seleccionado);

		System.out.println("El hotel actualizado es: " + hotel_actualizado);

		return hotel_actualizado;
	}

	@DeleteMapping("/hoteles/{id_hotel}")
	public void eleiminarHotel(@PathVariable(name = "id_hotel") Long id_hotel) {
		hotelServiceImpl.eliminarHotel(id_hotel);
	}

}
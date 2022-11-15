package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IHotelDAO;
import com.crud.api.dto.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
	
	//Utilizamos los metodos de la interface IHotelDAO, es como si instaciaramos.
	@Autowired
	IHotelDAO iHotelDAO;

	@Override
	public List<Hotel> listarHotel() {
		
		return iHotelDAO.findAll();
	}

	@Override
	public Hotel guardarHotel(Hotel hotel) {
		
		return iHotelDAO.save(hotel);
	}

	@Override
	public Hotel hotelXID(Long id_hotel) {
		
		return iHotelDAO.findById(id_hotel).get();
	}

	@Override
	public Hotel actualizarHotel(Hotel hotel) {
		
		return iHotelDAO.save(hotel);
	}

	@Override
	public void eliminarHotel(Long id_hotel) {
		
		iHotelDAO.deleteById(id_hotel);
		
	}

}
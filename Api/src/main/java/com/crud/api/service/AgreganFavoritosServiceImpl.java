package com.crud.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.dao.IAgreganFavoritosDAO;
import com.crud.api.dto.AgreganFavoritos;


@Service
public class AgreganFavoritosServiceImpl implements IAgreganFavoritosService{
	
	//Utilizamos los metodos de la interface IAgreganFavoritosDAO, es como si instaciaramos.
	@Autowired
	IAgreganFavoritosDAO iAgreganFavoritosDAO;

	@Override
	public List<AgreganFavoritos> listarAgreganFavoritos() {
		
		return iAgreganFavoritosDAO.findAll();
	}

	@Override
	public AgreganFavoritos guardarAgreganFavoritos(AgreganFavoritos agregan_favoritos) {
		
		return iAgreganFavoritosDAO.save(agregan_favoritos);
	}

	@Override
	public AgreganFavoritos agreganFavoritosXID(Long id_agregan_favoritos) {
		
		return iAgreganFavoritosDAO.findById(id_agregan_favoritos).get();
	}

	@Override
	public AgreganFavoritos actualizarAgreganFavoritos(AgreganFavoritos agregan_favoritos) {
		
		return iAgreganFavoritosDAO.save(agregan_favoritos);
	}

	@Override
	public void eliminarAgreganFavoritos(Long id_agregan_favoritos) {
		
		iAgreganFavoritosDAO.deleteById(id_agregan_favoritos);
		
	}

}
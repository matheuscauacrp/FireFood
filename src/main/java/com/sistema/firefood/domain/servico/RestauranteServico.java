package com.sistema.firefood.domain.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.firefood.domain.modelos.Restaurante;
import com.sistema.firefood.domain.repositorios.RestauranteRepositorio;

@Service
public class RestauranteServico {
	
	@Autowired
	private RestauranteRepositorio restauranteRepositorio;
	
	public List<Restaurante> listar(){
		return restauranteRepositorio.findAll();
	}
	
}

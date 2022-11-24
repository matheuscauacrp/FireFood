package com.sistema.firefood.api.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.modelos.Estado;
import com.sistema.firefood.domain.repositorios.EstadoRepositorio;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {

	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping
	public List<Estado> estados(){
		return estadoRepositorio.findAll();
	}
}

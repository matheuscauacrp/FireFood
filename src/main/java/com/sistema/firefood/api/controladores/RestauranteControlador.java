package com.sistema.firefood.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.servico.RestauranteServico;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteControlador {
	
	@Autowired
	private RestauranteServico restauranteServico;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.status(200).body(restauranteServico.listar());
	}
	
}

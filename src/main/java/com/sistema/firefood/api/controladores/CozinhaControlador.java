package com.sistema.firefood.api.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import com.sistema.firefood.domain.repositorios.CozinhaRepositorio;
import com.sistema.firefood.domain.modelos.Cozinha;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaControlador {

	@Autowired
	private CozinhaRepositorio cozinhaRepositorio;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("id") Long id) {
		
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.add(HttpHeaders.LOCATION, "http://api.firefood.local:8080/cozinhas");
		return ResponseEntity
				.status(HttpStatus.OK)
				.headers(httpHeaders)
				.build();
	}
	
}

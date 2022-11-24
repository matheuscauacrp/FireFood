package com.sistema.firefood.api.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.modelos.Cozinha;
import com.sistema.firefood.domain.servico.CozinhaServico;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaControlador {

	@Autowired
	private CozinhaServico cozinhaServico;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaServico.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("id") Long id) {
		return ResponseEntity
				.status(HttpStatus.OK).body(cozinhaServico.salvar(null));
	}
	
}

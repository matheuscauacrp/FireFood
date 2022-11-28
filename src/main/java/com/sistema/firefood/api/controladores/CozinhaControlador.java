package com.sistema.firefood.api.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
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
	
	@PostMapping("salvar")
	public ResponseEntity<?> salvar(@RequestBody Cozinha cozinha){
		try {
			return ResponseEntity
				.status(HttpStatus.OK).body(cozinhaServico.salvar(cozinha));
		}catch (EntidadeInvalidaException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		try {
		return ResponseEntity
				.status(HttpStatus.OK).body(cozinhaServico.listar());
		}catch (EntidadeInvalidaException e) {
			return ResponseEntity
					.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
		}
	}
	
}

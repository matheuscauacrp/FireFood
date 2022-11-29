package com.sistema.firefood.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
import com.sistema.firefood.domain.exceptions.EntidadeNaoEncontradaException;
import com.sistema.firefood.domain.servico.RestauranteServico;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteControlador {

	@Autowired
	private RestauranteServico restauranteServico;

	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			return ResponseEntity.status(200).body(restauranteServico.listar());
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(204).body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.status(200).body(restauranteServico.buscar(id));
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(204).body(e.getMessage());
		} catch (EntidadeInvalidaException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}
}

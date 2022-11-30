package com.sistema.firefood.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
import com.sistema.firefood.domain.exceptions.EntidadeNaoEncontradaException;
import com.sistema.firefood.domain.modelos.Estado;
import com.sistema.firefood.domain.servico.EstadoServico;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {

	@Autowired
	private EstadoServico estadoServico;
	
	@PostMapping("salvar")
	public ResponseEntity<?> salvar(@RequestBody Estado estado){
		try {
			return ResponseEntity
				.status(HttpStatus.OK).body(estadoServico.salvar(estado));
		}catch (EntidadeInvalidaException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		try {
		return ResponseEntity
				.status(HttpStatus.OK).body(estadoServico.listar());
		}catch (EntidadeInvalidaException e) {
			return ResponseEntity
					.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id){
		try {
			estadoServico.deletar(id);
			return ResponseEntity.status(200).build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(204).body(e.getMessage());
		}
	}
}

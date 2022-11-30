package com.sistema.firefood.domain.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.firefood.domain.exceptions.EntidadeEmUsoException;
import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
import com.sistema.firefood.domain.exceptions.EntidadeNaoEncontradaException;
import com.sistema.firefood.domain.modelos.Estado;
import com.sistema.firefood.domain.repositorios.EstadoRepositorio;

@Service
public class EstadoServico {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	public List<Estado> listar(){
		try {
			return estadoRepositorio.findAll();
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Nada encontrado");
		}
	}
	
	public Estado salvar(Estado estado) {
		try {
			 return estadoRepositorio.save(estado);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeInvalidaException("Entidade inválida");
		}
	}
	
	public void deletar(Long id) {
		try {
			estadoRepositorio.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(
							"Estado de código %d não pode ser removido, pois está em uso!",id
							));
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Estado de código %d não pode ser removido, pois não existe!",id
					));
		}
	}
}

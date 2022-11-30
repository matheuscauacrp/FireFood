package com.sistema.firefood.domain.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
import com.sistema.firefood.domain.exceptions.EntidadeNaoEncontradaException;
import com.sistema.firefood.domain.modelos.Restaurante;
import com.sistema.firefood.domain.repositorios.RestauranteRepositorio;

@Service
public class RestauranteServico {

	@Autowired
	private RestauranteRepositorio restauranteRepositorio;

	
	public Restaurante salvar(Restaurante restaurante) {
		try {
			return restauranteRepositorio.save(restaurante);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeInvalidaException("Entidade inválida!");
		}
	}
	
	
	public List<Restaurante> listar() {
		try {
			return restauranteRepositorio.findAll();
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Lista vazia!");
		}
	}

	public Restaurante buscar(Long id) {
		try {
			return restauranteRepositorio.findById(id).orElseThrow();
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Nada consta com esse id");
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeInvalidaException("ID Inválido!");
		}
	}
	

	public Restaurante atualizar(Restaurante restaurante) {
		try {
			return restauranteRepositorio.save(restaurante);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeInvalidaException("Entidade inválida!");
		}
	}
	

}

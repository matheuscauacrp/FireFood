package com.sistema.firefood.domain.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sistema.firefood.domain.exceptions.EntidadeEmUsoException;
import com.sistema.firefood.domain.exceptions.EntidadeInvalidaException;
import com.sistema.firefood.domain.exceptions.EntidadeNaoEncontradaException;
import com.sistema.firefood.domain.modelos.Cozinha;
import com.sistema.firefood.domain.repositorios.CozinhaRepositorio;

public class CozinhaServico {

	@Autowired
	private CozinhaRepositorio cozinhaRepositorio;
	
	
	public List<Cozinha> listar(){
		try {
			return cozinhaRepositorio.findAll();
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Não há cozinhas cadastradas! ");
		}
	}
	
	public Cozinha salvar(Cozinha cozinha) {
	try {
		return cozinhaRepositorio.save(cozinha);
	}catch (DataIntegrityViolationException e) {
		throw new EntidadeInvalidaException("Não pode ser salvo, entidade inválida!");
	}
	}
	
	public void deletar(Long id) {
		try {
			cozinhaRepositorio.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(
							"Cozinha de código %d não pode ser removida, pois está em uso!",id
							));
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Cozinha de código %d não pode ser removida, pois não existe!",id
					));
		}
	}
}

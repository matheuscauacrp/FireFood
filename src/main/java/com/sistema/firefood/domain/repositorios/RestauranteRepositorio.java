package com.sistema.firefood.domain.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.firefood.domain.modelos.Restaurante;

public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long>{

}

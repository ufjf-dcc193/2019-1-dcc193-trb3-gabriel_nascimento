package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.trab3.demo.model.Vinculo;

/**
 * VinculosRepository
 */
public interface VinculoRepository extends JpaRepository<Vinculo, Long>{

    
}
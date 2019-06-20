package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.trab3.demo.model.Etiqueta;

/**
 * EtiquetaRepository
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long>{

    
}
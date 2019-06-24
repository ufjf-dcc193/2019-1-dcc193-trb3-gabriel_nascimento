package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.trab3.demo.model.Anotacao;

/**
 * AnotacaoRepository
 */
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

    
}
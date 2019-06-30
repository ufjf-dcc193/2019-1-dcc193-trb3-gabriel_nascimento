package br.dcc.trab3.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.trab3.demo.model.Item;
import br.dcc.trab3.demo.model.Vinculo;

/**
 * VinculosRepository
 */
@Repository
public interface VinculoRepository extends JpaRepository<Vinculo, Long>{

    List<Vinculo> findAllByItemOrigemOrItemDestino(Item item,Item item2);
}
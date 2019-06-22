package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.trab3.demo.model.Item;

/**
 * ItemRepository
 */
public interface ItemRepository extends JpaRepository<Item, Long>{

    
}
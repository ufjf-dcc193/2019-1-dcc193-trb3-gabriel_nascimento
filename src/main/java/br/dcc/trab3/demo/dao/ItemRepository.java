package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.trab3.demo.model.Item;

/**
 * ItemRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
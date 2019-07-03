package br.dcc.trab3.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.trab3.demo.model.Etiqueta;
import br.dcc.trab3.demo.model.Item;

/**
 * ItemRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findAllDistinctByTituloContainingAndListaEtiquetaIn(String titulo, List<Etiqueta> etiqueta);

    List<Item> findByListaEtiqueta(List<Etiqueta> listaEtiqueta);
    
}
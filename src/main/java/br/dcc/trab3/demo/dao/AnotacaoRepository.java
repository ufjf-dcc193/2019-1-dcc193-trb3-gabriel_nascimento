package br.dcc.trab3.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.trab3.demo.model.Anotacao;
import br.dcc.trab3.demo.model.Item;
import br.dcc.trab3.demo.model.Usuario;
import br.dcc.trab3.demo.model.Vinculo;

/**
 * AnotacaoRepository
 */
@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

    List<Anotacao> findByUsuario(Usuario usuario);
    List<Anotacao> findAllByItemOrderByDataInclusao(Item item);
    List<Anotacao> findAllByVinculoOrderByDataInclusao(Vinculo vinculo);

}
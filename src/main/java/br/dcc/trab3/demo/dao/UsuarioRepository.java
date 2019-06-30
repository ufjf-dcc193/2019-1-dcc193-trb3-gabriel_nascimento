package br.dcc.trab3.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.trab3.demo.model.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

    Usuario findFirstByEmailAndCodigoAcesso(String email, String codigoAcesso);
    
}
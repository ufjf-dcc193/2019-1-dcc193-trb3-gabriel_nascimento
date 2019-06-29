package br.dcc.trab3.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Usuario
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotBlank(message = "Campo obrigatório")
    private String codigoAcesso;
    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    @NotBlank(message = "Campo obrigatório")
    private String email;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario id(Long id) {
        this.id = id;
        return this;
    }

    public Usuario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario codigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        return this;
    }

    public Usuario descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario() {
    }

    public Usuario(Long id, @NotBlank(message = "Campo obrigatório") String nome,
            @NotBlank(message = "Campo obrigatório") String codigoAcesso,
            @NotBlank(message = "Campo obrigatório") String descricao,
            @NotBlank(message = "Campo obrigatório") String email) {
        this.id = id;
        this.nome = nome;
        this.codigoAcesso = codigoAcesso;
        this.descricao = descricao;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigoAcesso + ", descricao=" + descricao + ", email=" + email + ", id=" + id + ", nome="
                + nome + "]";
    }

}
package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Usuario
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String nome;
    @NotBlank(message = "Campo obrigatório")
    private String codigoAcesso;
    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    @NotBlank(message = "Campo obrigatório")
    private String email;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> listAnotacoes;

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

    public List<Anotacao> getListAnotacoes() {
        return listAnotacoes;
    }

    public void setListAnotacoes(List<Anotacao> listAnotacoes) {
        this.listAnotacoes = listAnotacoes;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigoAcesso + ", descricao=" + descricao + ", email=" + email + ", id=" + id + ", nome="
                + nome + "]";
    }

}
package br.dcc.trab3.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/**
 * Etiqueta
 */
@Entity
@Table(name = "etiqueta")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String titulo;
    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    @NotBlank(message = "Campo obrigatório")
    private String URL;
    
    public Etiqueta(){}

    public Etiqueta(String nome){
        this.titulo = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public Etiqueta(Long id, @NotBlank(message = "Campo obrigatório") String titulo,
            @NotBlank(message = "Campo obrigatório") String descricao,
            @NotBlank(message = "Campo obrigatório") String uRL) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.URL = uRL;
    }

    @Override
    public String toString() {
        return "Etiqueta [descricao=" + descricao + ", id=" + id + ", titulo=" + titulo + ", url=" + URL + "]";
    }

    
}
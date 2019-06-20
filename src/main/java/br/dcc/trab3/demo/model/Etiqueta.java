package br.dcc.trab3.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


/**
 * Etiqueta
 */
@Entity
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String titulo;
    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    @NotBlank(message = "Campo obrigatório")
    private String URL;
    @ManyToOne
    private Vinculo vinculo;

    public Etiqueta(){}

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

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public Etiqueta(Long id, @NotBlank(message = "Campo obrigatório") String titulo,
            @NotBlank(message = "Campo obrigatório") String descricao,
            @NotBlank(message = "Campo obrigatório") String uRL, Vinculo vinculo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        URL = uRL;
        this.vinculo = vinculo;
    }

    
}
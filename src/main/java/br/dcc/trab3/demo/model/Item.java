package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

/**
 * Item
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String titulo;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Etiqueta> listaEtiqueta;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> listaAnotacao;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Vinculo> listaVinculo;

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

    public List<Etiqueta> getListaEtiqueta() {
        return listaEtiqueta;
    }

    public void setListaEtiqueta(List<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }

    public List<Anotacao> getListaAnotacao() {
        return listaAnotacao;
    }

    public void setListaAnotacao(List<Anotacao> listaAnotacao) {
        this.listaAnotacao = listaAnotacao;
    }

    public List<Vinculo> getListaVinculo() {
        return listaVinculo;
    }

    public void setListaVinculo(List<Vinculo> listaVinculo) {
        this.listaVinculo = listaVinculo;
    }

    public Item() {
    }

    public Item(String titulo) {        
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", titulo=" + titulo + ", vínculos=" + listaVinculo + "]";
    }
   
}
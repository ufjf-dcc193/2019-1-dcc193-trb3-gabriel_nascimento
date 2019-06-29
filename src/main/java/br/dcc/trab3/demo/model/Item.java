package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Item
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String titulo;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Etiqueta> listaEtiqueta;
    
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

    public Item() {
    }

    public Item(String titulo) {        
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", titulo=" + titulo + ", etiquetas=" + getListaEtiqueta() + "]";
    }
   
}
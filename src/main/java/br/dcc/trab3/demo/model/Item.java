package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.Entity;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String titulo;
    @OneToMany
    private List<Etiqueta> listaEtiqueta;
    @OneToMany
    private List<Anotacao> listaAnotacao;
    @OneToMany
    private List<Vinculo> listaVinculo;
}
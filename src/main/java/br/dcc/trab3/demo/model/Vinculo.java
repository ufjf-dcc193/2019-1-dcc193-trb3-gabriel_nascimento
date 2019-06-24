package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Vinculo
 */
@Entity
@Table(name = "vinculo")
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@OneToOne(fetch = FetchType.LAZY)
    private Item itemOrigem;
	@OneToOne(fetch = FetchType.LAZY)
	private Item itemDestino;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Etiqueta> listaEtiqueta;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    orphanRemoval = true)
	private List<Anotacao> listaAnotacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItemOrigem() {
		return itemOrigem;
	}
	public void setItemOrigem(Item itemOrigem) {
		this.itemOrigem = itemOrigem;
	}
	public Item getItemDestino() {
		return itemDestino;
	}
	public void setItemDestino(Item itemDestino) {
		this.itemDestino = itemDestino;
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

    public Vinculo() {
    }

    public Vinculo(Long id, Item itemOrigem, Item itemDestino, List<Etiqueta> listaEtiqueta,
            List<Anotacao> listaAnotacao) {
        this.id = id;
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
        this.listaEtiqueta = listaEtiqueta;
        this.listaAnotacao = listaAnotacao;
	}
	
	public Vinculo(Item itemOrigem, Item itemDestino) {
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
	}
	
	@Override
    public String toString() {
        return "Vinculo [id=" + id + ", itemDestino=" + itemDestino + ", itemOrigem=" + itemOrigem + "]";
    }

}
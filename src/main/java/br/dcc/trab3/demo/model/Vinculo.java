package br.dcc.trab3.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Vinculo
 */
@Entity
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
    private Item itemOrigem;
	@OneToOne
	private Item itemDestino;
    @OneToMany
    private List<Etiqueta> listaEtiqueta;
    @OneToMany
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

}
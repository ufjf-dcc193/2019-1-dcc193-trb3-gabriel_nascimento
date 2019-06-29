package br.dcc.trab3.demo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vinculo
 */
@Entity
@Table(name = "vinculo")
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    private Item itemOrigem;
	@ManyToOne(fetch = FetchType.LAZY)
	private Item itemDestino;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Etiqueta> listaEtiqueta;
	
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
	
    public Vinculo() {
    }

	public Vinculo(Item itemOrigem, Item itemDestino) {
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
	}

	public Vinculo(Long id, Item itemOrigem, Item itemDestino, List<Etiqueta> etiqueta) {
        this.id = id;
        this.itemOrigem = itemOrigem;
        this.itemDestino = itemDestino;
        this.listaEtiqueta = etiqueta;
    }
	
	@Override
    public String toString() {
        return "Vinculo [id=" + id + ", itemDestino=" + itemDestino + ", itemOrigem=" + itemOrigem + "]";
    }

}
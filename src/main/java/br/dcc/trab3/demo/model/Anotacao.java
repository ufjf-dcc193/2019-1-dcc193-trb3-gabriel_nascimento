package br.dcc.trab3.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
/**
 * Anotacao
 */
@Entity
@Table(name = "anotacao")
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String titulo;
    @NotBlank(message = "Campo obrigatório")
    private String descricao;
    private String url;
    private String dataInclusao;
    private String dataAlteracao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Vinculo vinculo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return the vinculo
     */
    public Vinculo getVinculo() {
        return vinculo;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }


    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param vinculo the vinculo to set
     */
    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
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
        return url;
    }

    public void setURL(String uRL) {
        this.url = uRL;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return "Anotacao [dataAlteracao=" + dataAlteracao + ", dataInclusao=" + dataInclusao + ", descricao="
                + descricao + ", id=" + id + ", titulo=" + titulo + ", url=" + url + "]";
    }

    public Anotacao(Long id, String titulo, String descricaoTextual, String url, String dtInclusao, String dtAlteracao,
            Usuario usuario, Item item) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricaoTextual;
        this.url = url;
        this.dataInclusao = dtInclusao;
        this.dataAlteracao = dtAlteracao;
        this.usuario = usuario;
        this.item = item;
    }

    public Anotacao(Long id, String titulo, String descricaoTextual, String url, String dtInclusao, String dtAlteracao, Usuario usuario, Item item, Vinculo vinculo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricaoTextual;
        this.url = url;
        this.dataInclusao = dtInclusao;
        this.dataAlteracao = dtAlteracao;
        this.usuario = usuario;
        this.item = item;
        this.vinculo = vinculo;
    }

    public Anotacao(){}
}
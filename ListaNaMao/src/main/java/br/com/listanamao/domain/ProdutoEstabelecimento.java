package br.com.listanamao.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ProdutoEstabelecimento extends GenericDomain{
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@Column(nullable = false)
	@Basic(optional = false)
	private float preco;
	
	@Column(nullable = false)
	@Basic(optional = false)
	private boolean promocao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}

package br.com.listanamao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{
	@Column(length = 100, nullable = false)
	@Basic(optional = false)
	private String descricao;
	
	@Column(length = 50, nullable = false)
	@Basic(optional = false)
	private String unidade;
	
	@Column(nullable = false)
	@Basic(optional = false)
	private int quantidade;
	
	@Column(length = 20)
	@Basic(optional = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Marca marca;
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

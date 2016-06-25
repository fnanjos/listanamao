package br.com.listanamao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Bairro extends GenericDomain{
	@Column(length = 100, nullable = false)
	@Basic(optional = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
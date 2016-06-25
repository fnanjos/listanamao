package br.com.listanamao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Marca extends GenericDomain{
	@Column(length = 100, nullable = false)
	@Basic(optional = false)
	private String descricao;
	
	@Column(length = 18, nullable = false)
	@Basic(optional = false)
	private String CNPJ;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	
}

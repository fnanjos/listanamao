package br.com.listanamao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@SuppressWarnings("serial")
@Entity
public class Estabelecimento extends GenericDomain{
	@Column(length = 100, nullable = false)
	@Basic(optional = false)
	private String descricao;
	
	@Column(length = 18, nullable = false)
	@Basic(optional = false)
	private String CNPJ;
	
	@Column(length= 100, nullable = false)
	@Basic(optional = false)
	private String Rua;
	
	@Column(length = 4, nullable = false)
	@Basic(optional = false)
	private String numero;
	
	@Column(length = 100, nullable = false)
	@Basic(optional = false)
	private String email;
	
	@Column(length = 14, nullable = false)
	@Basic(optional = false)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Bairro bairro;

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

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
}

package br.com.listanamao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.listanamao.dao.BairroDAO;
import br.com.listanamao.dao.EstabelecimentoDAO;
import br.com.listanamao.domain.Bairro;
import br.com.listanamao.domain.Estabelecimento;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstabelecimentoBean implements Serializable{
	private Estabelecimento estabelecimento;

	private List<Estabelecimento> estabelecimentos;
	private List<Bairro> bairros;

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	@PostConstruct
	public void listar() {
		try {
			EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
			setEstabelecimentos(eDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os estabelecimentos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			estabelecimento = new Estabelecimento();

			BairroDAO bDAO = new BairroDAO();
			setBairros(bDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Estabelecimento");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			estabelecimentoDAO.salvar(estabelecimento);
			
			estabelecimento = new Estabelecimento();
			
			BairroDAO bDAO = new BairroDAO();
			setBairros(bDAO.listar());
			
			setEstabelecimentos(estabelecimentoDAO.listar());
			
			Messages.addGlobalInfo("Estabelecimento salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo estabelecimento");
			erro.printStackTrace();
		}
	}

	
}

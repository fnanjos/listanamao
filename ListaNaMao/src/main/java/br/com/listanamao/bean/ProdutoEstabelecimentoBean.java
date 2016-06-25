package br.com.listanamao.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.omnifaces.util.Messages;

import br.com.listanamao.dao.EstabelecimentoDAO;
import br.com.listanamao.dao.ProdutoDAO;
import br.com.listanamao.dao.ProdutoEstabelecimentoDAO;
import br.com.listanamao.domain.Estabelecimento;
import br.com.listanamao.domain.Produto;
import br.com.listanamao.domain.ProdutoEstabelecimento;


public class ProdutoEstabelecimentoBean {
	private ProdutoEstabelecimento produtoEstabelecimento;

	private List<ProdutoEstabelecimento> produtoEstabelecimentos;
	private List<Produto> produtos;
	private List<Estabelecimento> estabelecimentos;

	
	public ProdutoEstabelecimento getProdutoEstabelecimento() {
		return produtoEstabelecimento;
	}

	public void setProdutoEstabelecimento(
			ProdutoEstabelecimento produtoEstabelecimento) {
		this.produtoEstabelecimento = produtoEstabelecimento;
	}

	public List<ProdutoEstabelecimento> getProdutoEstabelecimentos() {
		return produtoEstabelecimentos;
	}

	public void setProdutoEstabelecimentos(
			List<ProdutoEstabelecimento> produtoEstabelecimentos) {
		this.produtoEstabelecimentos = produtoEstabelecimentos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoEstabelecimentoDAO peDAO = new ProdutoEstabelecimentoDAO();
			setProdutoEstabelecimentos(peDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos/Estabelecimentos ");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			produtoEstabelecimento = new ProdutoEstabelecimento();

			ProdutoDAO pDAO = new ProdutoDAO();
			setProdutos(pDAO.listar());
			
			EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
			setEstabelecimentos(eDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Produto/Estabelecimento");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProdutoEstabelecimentoDAO peDAO = new ProdutoEstabelecimentoDAO();
			peDAO.salvar(produtoEstabelecimento);
			
			produtoEstabelecimento = new ProdutoEstabelecimento();
			
			ProdutoDAO pDAO = new ProdutoDAO();
			setProdutos(pDAO.listar());
			
			EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
			setEstabelecimentos(eDAO.listar());
			
			setProdutoEstabelecimentos(peDAO.listar());
			
			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Produto/Estabelecimento");
			erro.printStackTrace();
		}
	}
}

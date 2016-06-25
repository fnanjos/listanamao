package br.com.listanamao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.listanamao.dao.MarcaDAO;
import br.com.listanamao.dao.ProdutoDAO;
import br.com.listanamao.domain.Marca;
import br.com.listanamao.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{
	private Produto produto;

	private List<Produto> produtos;
	private List<Marca> marcas;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO pDAO = new ProdutoDAO();
			setProdutos(pDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Produtos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			produto = new Produto();

			MarcaDAO mDAO = new MarcaDAO();
			setMarcas(mDAO.listar());
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Produto");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
			
			produto = new Produto();
			
			MarcaDAO mDAO = new MarcaDAO();
			setMarcas(mDAO.listar());
			
			setProdutos(produtoDAO.listar());
			
			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Produto");
			erro.printStackTrace();
		}
	}
}

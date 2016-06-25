package br.com.listanamao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.listanamao.domain.Marca;
import br.com.listanamao.domain.Produto;


public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		int codMarca = 2;
		
		MarcaDAO mDAO = new MarcaDAO();
		Marca marca = mDAO.buscar(codMarca);
		
		Produto est = new Produto();
		est.setDescricao("Nutella");
		est.setQuantidade(150);
		est.setUnidade("gramas");
		est.setTipo("geral");
		est.setMarca(marca);
		
		ProdutoDAO estDAO = new ProdutoDAO();
		estDAO.salvar(est);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO estDAO = new ProdutoDAO();
		List<Produto> resultado = estDAO.listar();
		
		for(Produto est : resultado){
			System.out.println("Código do produto: " + est.getCodigo());
			System.out.println("Produto: " + est.getDescricao() + " - " + est.getQuantidade() + " " + est.getUnidade());
			System.out.println("Tipo: " + est.getTipo());
			System.out.println("Marca: "+ est.getMarca().getDescricao());
			System.out.println();
		}		
	}
	
	@Test
	@Ignore
	public void buscar(){
		int cod = 1;
		
		ProdutoDAO eDAO = new ProdutoDAO();
		Produto est = eDAO.buscar(cod);
		
		System.out.println("Código do produto: " + est.getCodigo());
		System.out.println("Produto: " + est.getDescricao() + " - " + est.getQuantidade() + " " + est.getUnidade());
		System.out.println("Tipo: " + est.getTipo());
		System.out.println("Marca: "+ est.getMarca().getDescricao());
		System.out.println();
	}
	
	@Test
	@Ignore
	public void editar(){
		int codEst = 1;
		int codMarca = 2;
		
		MarcaDAO bDAO = new MarcaDAO();
		Marca Marca = bDAO.buscar(codMarca);
		
		System.out.println("Marca: " + Marca.getDescricao());
		
		ProdutoDAO eDAO = new ProdutoDAO();
		Produto est = eDAO.buscar(codEst);
		
		System.out.println("Produto a ser editado: ");
		System.out.println("Código do produto: " + est.getCodigo());
		System.out.println("Produto: " + est.getDescricao() + " - " + est.getQuantidade() + " " + est.getUnidade());
		System.out.println("Tipo: " + est.getTipo());
		System.out.println("Marca: "+ est.getMarca().getDescricao());
		System.out.println();
		
		est.setDescricao("Rocher");
		est.setMarca(Marca);
		est.setQuantidade(300); 
		
		eDAO.editar(est);
		
		System.out.println("Produto já editado: ");
		System.out.println("Código do produto: " + est.getCodigo());
		System.out.println("Produto: " + est.getDescricao() + " - " + est.getQuantidade() + " " + est.getUnidade());
		System.out.println("Tipo: " + est.getTipo());
		System.out.println("Marca: "+ est.getMarca().getDescricao());
		System.out.println();
	}
	
	@Test
	public void excluir(){
		int cod = 2;
		
		ProdutoDAO eDAO = new ProdutoDAO();
		Produto est = eDAO.buscar(cod);
		
		eDAO.excluir(est);
		
		System.out.println("Código do produto: " + est.getCodigo());
		System.out.println("Produto: " + est.getDescricao() + " - " + est.getQuantidade() + " " + est.getUnidade());
		System.out.println("Tipo: " + est.getTipo());
		System.out.println("Marca: "+ est.getMarca().getDescricao());
		System.out.println();
	}
}

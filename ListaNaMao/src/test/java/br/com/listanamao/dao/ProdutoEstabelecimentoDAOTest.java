package br.com.listanamao.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.listanamao.domain.Bairro;
import br.com.listanamao.domain.Estabelecimento;
import br.com.listanamao.domain.Produto;
import br.com.listanamao.domain.ProdutoEstabelecimento;

public class ProdutoEstabelecimentoDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException{
		int codProduto = 1;
		int codEst = 1;
		
		ProdutoDAO ProdutoDAO = new ProdutoDAO();
		Produto produto = ProdutoDAO.buscar(codProduto);
		
		EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
		Estabelecimento est = eDAO.buscar(codEst);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient (false);
		Date data = sdf.parse("27/07/2006");
		
		ProdutoEstabelecimento pest = new ProdutoEstabelecimento();
		pest.setData(data);
		pest.setEstabelecimento(est);
		pest.setPreco((float) 12.2);
		pest.setProduto(produto);
		pest.setPromocao(true);
		
		ProdutoEstabelecimentoDAO pestDAO = new ProdutoEstabelecimentoDAO();
		pestDAO.salvar(pest);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoEstabelecimentoDAO pestDAO = new ProdutoEstabelecimentoDAO();
		List<ProdutoEstabelecimento> resultado = pestDAO.listar();
		
		for(ProdutoEstabelecimento est : resultado){
			System.out.println("Código do ProdutoEstabalecimento: " + est.getCodigo());
			System.out.println("Preço: " + est.getPreco());
			System.out.println("Data: " + est.getData() );
			System.out.println("Estabelecimento: " + est.getEstabelecimento().getDescricao());
			System.out.println("Produto: "+ est.getProduto().getDescricao());
			System.out.println();
		}		
	}
	
	@Test
	@Ignore
	public void buscar(){
		int cod = 1;
		
		ProdutoEstabelecimentoDAO pestDAO = new ProdutoEstabelecimentoDAO();
		ProdutoEstabelecimento pest = pestDAO.buscar(cod);
		
		System.out.println("Código do ProdutoEstabalecimento: " + pest.getCodigo());
		System.out.println("Preço: " + pest.getPreco());
		System.out.println("Data: " + pest.getData() );
		System.out.println("Estabelecimento: " + pest.getEstabelecimento().getDescricao());
		System.out.println("Produto: "+ pest.getProduto().getDescricao());
		System.out.println();
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		int codEst = 1;
		int codBairro = 1;
		int codPest = 1;
		
		BairroDAO bDAO = new BairroDAO();
		Bairro bairro = bDAO.buscar(codBairro);
		
		EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
		Estabelecimento est = eDAO.buscar(codEst);
		
		System.out.println("Bairro: " + bairro.getDescricao());
		
		ProdutoEstabelecimentoDAO pestDAO = new ProdutoEstabelecimentoDAO();
		ProdutoEstabelecimento pest = pestDAO.buscar(codPest);
		
		System.out.println("ProdutoEstabelecimento a ser editado: ");
		System.out.println("Código do ProdutoEstabalecimento: " + pest.getCodigo());
		System.out.println("Preço: " + pest.getPreco());
		System.out.println("Data: " + pest.getData() );
		System.out.println("Estabelecimento: " + pest.getEstabelecimento().getDescricao());
		System.out.println("Produto: "+ pest.getProduto());
		System.out.println();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient (false);
		Date data = sdf.parse("23/06/2016");
		
		pest.setPreco((float) 128.1);
		pest.setData(data); 
		
		eDAO.editar(est);
		
		System.out.println("ProdutoEstabelecimento já editado: ");
		System.out.println("Código do ProdutoEstabalecimento: " + pest.getCodigo());
		System.out.println("Preço: " + pest.getPreco());
		System.out.println("Data: " + pest.getData() );
		System.out.println("Estabelecimento: " + pest.getEstabelecimento().getDescricao());
		System.out.println("Produto: "+ pest.getProduto());
		System.out.println();
	}
	
	@Test
	public void excluir(){
		int cod = 1;
		
		ProdutoEstabelecimentoDAO pestDAO = new ProdutoEstabelecimentoDAO();
		ProdutoEstabelecimento pest = pestDAO.buscar(cod);
		
		pestDAO.excluir(pest);
		
		System.out.println("Código do ProdutoEstabalecimento excluido: " + pest.getCodigo());
		System.out.println("Preço: " + pest.getPreco());
		System.out.println("Data: " + pest.getData() );
		System.out.println("Estabelecimento: " + pest.getEstabelecimento().getDescricao());
		System.out.println("Produto: "+ pest.getProduto().getDescricao());
		System.out.println();
	}
}

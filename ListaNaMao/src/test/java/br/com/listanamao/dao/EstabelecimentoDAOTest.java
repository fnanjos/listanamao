package br.com.listanamao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.listanamao.domain.Bairro;
import br.com.listanamao.domain.Estabelecimento;

public class EstabelecimentoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		int codBairro = 1;
		
		BairroDAO bairroDAO = new BairroDAO();
		Bairro bairro = bairroDAO.buscar(codBairro);
		
		Estabelecimento est = new Estabelecimento();
		est.setCNPJ("55.815.487/0001-52");
		est.setDescricao("Mercadinho União");
		est.setEmail("união@proservnet.com.br");
		est.setNumero("1230");
		est.setRua("Rua Marechal Deodoro");
		est.setTelefone("(46) 3263-7550");
		est.setBairro(bairro);
		
		EstabelecimentoDAO estDAO = new EstabelecimentoDAO();
		estDAO.salvar(est);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstabelecimentoDAO estDAO = new EstabelecimentoDAO();
		List<Estabelecimento> resultado = estDAO.listar();
		
		for(Estabelecimento est : resultado){
			System.out.println("Código do Estabalecimento: " + est.getCodigo());
			System.out.println("Nome do Estabelecimento: " + est.getDescricao());
			System.out.println("CNPJ do Estabelecimento: " + est.getCNPJ() );
			System.out.println("Email: " + est.getEmail());
			System.out.println("Endereço: "+ est.getBairro().getDescricao() + " - " + est.getRua() + "Nº: " + est.getNumero());
			System.out.println("Telefone: " + est.getTelefone());
			System.out.println();
		}		
	}
	
	@Test
	@Ignore
	public void buscar(){
		int cod = 1;
		
		EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
		Estabelecimento est = eDAO.buscar(cod);
		
		System.out.println("Código do Estabalecimento: " + est.getCodigo());
		System.out.println("Nome do Estabelecimento: " + est.getDescricao());
		System.out.println("CNPJ do Estabelecimento: " + est.getCNPJ() );
		System.out.println("Email: " + est.getEmail());
		System.out.println("Endereço: "+ est.getBairro().getDescricao() + " - " + est.getRua() + "Nº: " + est.getNumero());
		System.out.println("Telefone: " + est.getTelefone());
		System.out.println();
	}
	
	@Test
	@Ignore
	public void editar(){
		int codEst = 1;
		int codBairro = 1;
		
		BairroDAO bDAO = new BairroDAO();
		Bairro bairro = bDAO.buscar(codBairro);
		
		System.out.println("Bairro: " + bairro.getDescricao());
		
		EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
		Estabelecimento est = eDAO.buscar(codEst);
		
		System.out.println("Estabelecimento a ser editado: ");
		System.out.println("Código do Estabalecimento: " + est.getCodigo());
		System.out.println("Nome do Estabelecimento: " + est.getDescricao());
		System.out.println("CNPJ do Estabelecimento: " + est.getCNPJ() );
		System.out.println("Email: " + est.getEmail());
		System.out.println("Endereço: "+ est.getBairro().getDescricao() + " - " + est.getRua() + "Nº: " + est.getNumero());
		System.out.println("Telefone: " + est.getTelefone());
		System.out.println();
		
		est.setDescricao("Supermercado União");
		est.setBairro(bairro);
		est.setTelefone("(46) 3263-7575"); 
		
		eDAO.editar(est);
		
		System.out.println("Estabelecimento já editado: ");
		System.out.println("Código do Estabalecimento: " + est.getCodigo());
		System.out.println("Nome do Estabelecimento: " + est.getDescricao());
		System.out.println("CNPJ do Estabelecimento: " + est.getCNPJ() );
		System.out.println("Email: " + est.getEmail());
		System.out.println("Endereço: "+ est.getBairro().getDescricao() + " - " + est.getRua() + "Nº: " + est.getNumero());
		System.out.println("Telefone: " + est.getTelefone());
		System.out.println();
	}
	
	@Test
	@Ignore
	public void excluir(){
		int cod = 1;
		
		EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
		Estabelecimento est = eDAO.buscar(cod);
		
		eDAO.excluir(est);
		
		System.out.println("Estabelecimento já editado: ");
		System.out.println("Código do Estabalecimento: " + est.getCodigo());
		System.out.println("Nome do Estabelecimento: " + est.getDescricao());
		System.out.println("CNPJ do Estabelecimento: " + est.getCNPJ() );
		System.out.println("Email: " + est.getEmail());
		System.out.println("Endereço: "+ est.getBairro().getDescricao() + " - " + est.getRua() + "Nº: " + est.getNumero());
		System.out.println("Telefone: " + est.getTelefone());
		System.out.println();
	}
}

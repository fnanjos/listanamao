package br.com.listanamao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.listanamao.domain.Bairro;


public class BairroDAOTest {
	
	@Test
	public void salvar(){
		//Cria o objeto que ira receber os dados
		Bairro bairro = new Bairro();
		
		//Preenche os atributos dos objeto
		bairro.setDescricao("Divino");
		
		//cria o objeto que permite chamar açõesj do banco de dados
		BairroDAO bdao = new BairroDAO();
		
		//Invoca a operação de salvar
		bdao.salvar(bairro);
	}
	
	@Test
	@Ignore
	public void listar(){
		BairroDAO bairroDAO = new BairroDAO();
		List<Bairro> resultado = bairroDAO.listar();
		
		System.out.println("Total de bairros encontrados: " + resultado.size());
		
		for(Bairro bairro : resultado){
			System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		int codigo = 1;
		
		BairroDAO bairroDAO = new BairroDAO();
		Bairro bairro = bairroDAO.buscar(codigo);
		
		if(bairro == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro Encontrado:");
			System.out.println(bairro.getCodigo() + " - " + bairro.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		int codigo = 2;
		
		BairroDAO bairroDAO = new BairroDAO();
		Bairro bairro = bairroDAO.buscar(codigo);
		
		if(bairro == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			bairroDAO.excluir(bairro);
			System.out.println("Registro Removido: ");
			System.out.print(bairro.getCodigo() + " - " + bairro.getDescricao());
		}
	}
}

package br.com.listanamao.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.listanamao.domain.Marca;


public class MarcaDAOTest {
	@Test
	@Ignore
	public void salvar(){
		//Cria o objeto que ira receber os dados
		Marca marca = new Marca();
		
		//Preenche os atributos dos objeto
		marca.setDescricao("Ferrero");
		marca.setCNPJ("21.717.165/0001-59");
		
		//cria o objeto que permite chamar açõesj do banco de dados
		MarcaDAO bdao = new MarcaDAO();
		
		//Invoca a operação de salvar
		bdao.salvar(marca);
	}
	
	@Test
	@Ignore
	public void listar(){
		MarcaDAO mDAO = new MarcaDAO();
		List<Marca> resultado = mDAO.listar();
		
		System.out.println("Total de Marcas encontrados: " + resultado.size());
		
		for(Marca marca : resultado){
			System.out.println(marca.getCodigo() + " - " + marca.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		int codigo = 1;
		
		MarcaDAO MarcaDAO = new MarcaDAO();
		Marca Marca = MarcaDAO.buscar(codigo);
		
		if(Marca == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro Encontrado:");
			System.out.println(Marca.getCodigo() + " - " + Marca.getDescricao());
		}
	}
	
	
	
	@Test
	@Ignore
	public void excluir(){
		int codigo = 1;
		
		MarcaDAO MarcaDAO = new MarcaDAO();
		Marca Marca = MarcaDAO.buscar(codigo);
		
		if(Marca == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			MarcaDAO.excluir(Marca);
			System.out.println("Registro Removido: ");
			System.out.print(Marca.getCodigo() + " - " + Marca.getDescricao());
		}
	}
}

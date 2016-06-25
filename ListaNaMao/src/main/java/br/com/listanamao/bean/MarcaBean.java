package br.com.listanamao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.listanamao.dao.MarcaDAO;
import br.com.listanamao.domain.Marca;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MarcaBean implements Serializable{
	private Marca marca = new Marca();
	private List<Marca> marcas;
	


	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		marca.setDescricao("talMarca");
		marca.setCodigo(0);
		this.marca = marca;
	}
	
	@PostConstruct
	public void listar(){
		try {
			MarcaDAO marcaDAO = new MarcaDAO();
			marcas = marcaDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao carregar as Marcas");
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		System.out.println(getMarca().getDescricao());
		try {
			MarcaDAO marcaDAO = new MarcaDAO();
			marcaDAO.salvar(marca);
			
			
			marca = new Marca();
			marcas = marcaDAO.listar();
			
			Messages.addGlobalInfo("Marca salva com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		marca = new Marca();
	}
	
	public void editar(ActionEvent evento){
		marca = (Marca) evento.getComponent().getAttributes().get("marcaSelecionada");
	}
	
	public void excluir(ActionEvent evento){
		try{
			marca = (Marca) evento.getComponent().getAttributes().get("marcaSelecionada");
			
			MarcaDAO mDAO = new MarcaDAO();
			mDAO.excluir(marca);
		
			marcas = mDAO.listar();
		
			Messages.addGlobalInfo("Marca removido com sucesso");
		} catch (RuntimeException e){
			Messages.addFlashGlobalError("Houve um erro ao tentar excluir o Marca!");
			e.printStackTrace();
		}
		
	}
}

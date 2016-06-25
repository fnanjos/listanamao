package br.com.listanamao.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.listanamao.dao.BairroDAO;
import br.com.listanamao.domain.Bairro;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BairroBean implements Serializable{
	

	private Bairro bairro = new Bairro();
	private List<Bairro> bairros;
	
	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		bairro.setDescricao("talBairro");
		bairro.setCodigo(0);
		this.bairro = bairro;
	}
	
	@PostConstruct
	public void listar(){
		try {
			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao carregar os bairros");
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		System.out.println(getBairro().getDescricao());
		try {
			BairroDAO bairroDAO = new BairroDAO();
			bairroDAO.salvar(bairro);
			
			
			bairro = new Bairro();
			bairros = bairroDAO.listar();
			
			Messages.addGlobalInfo("Bairro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		bairro = new Bairro();
	}
	
	public void editar(ActionEvent evento){
		bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionado");
	}
	
	public void excluir(ActionEvent evento){
		try{
			bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionado");
			
			BairroDAO bDAO = new BairroDAO();
			bDAO.excluir(bairro);
		
			bairros = bDAO.listar();
		
			Messages.addGlobalInfo("Bairro removido com sucesso");
		} catch (RuntimeException e){
			Messages.addFlashGlobalError("Houve um erro ao tentar excluir o Bairro!");
			e.printStackTrace();
		}
		
	}
}
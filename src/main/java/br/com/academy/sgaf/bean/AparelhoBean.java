package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.AparelhoDAO;
import br.com.academy.sgaf.domain.Aparelho;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class AparelhoBean implements Serializable {
	private Aparelho aparelho; // model
	private List<Aparelho> aparelhos;

	public Aparelho getAparelho() {
		return aparelho;
	}
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	public List<Aparelho> getAparelhos() {
		return aparelhos;
	}
	public void setAparelhos(List<Aparelho> aparelhos) {
		this.aparelhos = aparelhos;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhos = aparelhoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os aparelhos!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		aparelho = new Aparelho();
	}
	
	public void salvar() { //controller
		try {
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhoDAO.merge(aparelho);
		
			novo();
			aparelhos = aparelhoDAO.listar();
		
			Messages.addGlobalInfo("Aparelho salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o aparelho!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			aparelho = (Aparelho) evento.getComponent().getAttributes().get("aparelhoSelecionado");

			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhoDAO.excluir(aparelho);
			
			aparelhos = aparelhoDAO.listar();
			
			Messages.addGlobalInfo("Aparelho removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o aparelho!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		aparelho = (Aparelho) evento.getComponent().getAttributes().get("aparelhoSelecionado");
	}
	
}

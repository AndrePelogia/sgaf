package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.AtividadesDAO;
import br.com.academy.sgaf.dao.QuestionarioDAO;
import br.com.academy.sgaf.domain.Atividades;
import br.com.academy.sgaf.domain.Questionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class AtividadesBean implements Serializable {
	private Atividades atividade;
	private List<Atividades> atividades;
	private List<Questionario> questionarios;
	
	public void setAtividade(Atividades atividade) {
		this.atividade = atividade;
	}
	public Atividades getAtividade() {
		return atividade;
	}
	public void setAtividades(List<Atividades> atividades) {
		this.atividades = atividades;
	}
	public List<Atividades> getAtividades() {
		return atividades;
	}
	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
	}
	public List<Questionario> getQuestionarios() {
		return questionarios;
	}
	
	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			AtividadesDAO atividadesDAO = new AtividadesDAO();
			atividades = atividadesDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o questionário de atividades!!"); //flashglobalerror
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			atividade = new Atividades();
			
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarios = questionarioDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo questionário de atividades!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {	
			AtividadesDAO atividadesDAO = new AtividadesDAO();
			atividadesDAO.merge(atividade);
		
			atividade = new Atividades();
			
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarios = questionarioDAO.listar();
			
			atividades = atividadesDAO.listar();
		
			Messages.addGlobalInfo("Atividades salvas com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o questionário de atividades!!");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			atividade = (Atividades) evento.getComponent().getAttributes().get("atividadeSelecionada");
			
			AtividadesDAO atividadesDAO = new AtividadesDAO();
			atividadesDAO.excluir(atividade);
			
			atividades = atividadesDAO.listar();
			
			Messages.addGlobalInfo("Atividades removidas com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover as atividades!!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			atividade = (Atividades) evento.getComponent().getAttributes().get("atividadeSelecionada");
			
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarios = questionarioDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma atividade!!");
			erro.printStackTrace();
		}
	}

}

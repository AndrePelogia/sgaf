package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.academy.sgaf.domain.Exames;
import br.com.academy.sgaf.domain.Questionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class ExamesBean implements Serializable {
	private Exames exame;
	private List<Exames> exames;
	private List<Questionario> questionarios;
	
	public void setExame(Exames exame) {
		this.exame = exame;
	}
	public Exames getExame() {
		return exame;
	}
	public void setExames(List<Exames> exames) {
		this.exames = exames;
	}
	public List<Exames> getExames() {
		return exames;
	}
	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
	}
	public List<Questionario> getQuestionarios() {
		return questionarios;
	}
	
	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		
	}
	
	public void novo() {
		
	}
	
	public void salvar() {
		
	}
	
	public void excluir(ActionEvent evento) {
		
	}
	
	public void editar(ActionEvent evento) {
		
	}

}

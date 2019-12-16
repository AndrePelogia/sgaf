package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.academy.sgaf.domain.Objetivos;
import br.com.academy.sgaf.domain.Questionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class ObjetivosBean implements Serializable {
	private Objetivos objetivo;
	private List<Objetivos> objetivos;
	private List<Questionario> questionarios;
	
	public void setObjetivo(Objetivos objetivo) {
		this.objetivo = objetivo;
	}
	public Objetivos getObjetivo() {
		return objetivo;
	}
	public void setObjetivos(List<Objetivos> objetivos) {
		this.objetivos = objetivos;
	}
	public List<Objetivos> getObjetivos() {
		return objetivos;
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

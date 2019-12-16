package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.academy.sgaf.domain.Diagnosticos;
import br.com.academy.sgaf.domain.Questionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class DiagnosticosBean implements Serializable {
	private Diagnosticos diagnostico;
	private List<Diagnosticos> diagnosticos;
	private List<Questionario> questionarios;
	
	public void setDiagnostico(Diagnosticos diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Diagnosticos getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnosticos(List<Diagnosticos> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	public List<Diagnosticos> getDiagnosticos() {
		return diagnosticos;
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

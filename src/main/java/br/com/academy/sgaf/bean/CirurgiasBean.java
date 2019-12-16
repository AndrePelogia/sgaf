package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.academy.sgaf.domain.Cirurgias;
import br.com.academy.sgaf.domain.Questionario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class CirurgiasBean implements Serializable {
	private Cirurgias cirurgia;
	private List<Cirurgias> cirurgias;
	private List<Questionario> questionarios;
	
	public void setCirurgia(Cirurgias cirurgia) {
		this.cirurgia = cirurgia;
	}
	public Cirurgias getCirurgia() {
		return cirurgia;
	}
	public void setCirurgias(List<Cirurgias> cirurgias) {
		this.cirurgias = cirurgias;
	}
	public List<Cirurgias> getCirurgias() {
		return cirurgias;
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

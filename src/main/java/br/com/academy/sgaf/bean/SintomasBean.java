package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.academy.sgaf.domain.Questionario;
import br.com.academy.sgaf.domain.Sintomas;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class SintomasBean implements Serializable {
	private Sintomas sintoma;
	private List<Sintomas> sintomas;
	private List<Questionario> questionarios;
	
	public void setSintoma(Sintomas sintoma) {
		this.sintoma = sintoma;
	}
	public Sintomas getSintoma() {
		return sintoma;
	}
	public void setSintomas(List<Sintomas> sintomas) {
		this.sintomas = sintomas;
	}
	public List<Sintomas> getSintomas() {
		return sintomas;
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

package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Questionário é uma entidade, gerando uma tabela
		// posterior
public class Questionario extends GenericDomain {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario; // pega nome do funcionário
	@OneToOne
	@JoinColumn(nullable = false)
	private Aluno aluno; // pega nome do aluno
	@ManyToOne
	private Aluno resp; // pega nome do responsável
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtQuestion;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getResp() {
		return resp;
	}

	public void setResp(Aluno resp) {
		this.resp = resp;
	}

	public Date getDtQuestion() {
		return dtQuestion;
	}

	public void setDtQuestion(Date dtQuestion) {
		this.dtQuestion = dtQuestion;
	}

}

package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que a Frequência é uma entidade, gerando uma tabela posterior
public class Frequencia extends GenericDomain {
	@ManyToOne // verificar se não é o contrário
	@JoinColumn(nullable = false)
	private Aluno aluno;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date diaPresente;

	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Date getDiaPresente() {
		return diaPresente;
	}

	public void setDiaPresente(Date diaPresente) {
		this.diaPresente = diaPresente;
	}

}

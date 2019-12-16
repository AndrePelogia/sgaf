package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Objetivos é uma entidade, gerando uma tabela posterior
public class Objetivos extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column(nullable = false)
	private Boolean estetica;
	@Column(nullable = false)
	private Boolean convivioSocial;
	@Column(nullable = false)
	private Boolean lazer;
	@Column(nullable = false)
	private Boolean emagrecimento;
	@Column(nullable = false)
	private Boolean terapeutico;
	@Column(nullable = false)
	private Boolean condicioFisico;
	@Column(nullable = false)
	private Boolean outros;
	@Column(length = 35)
	private String opcOutros;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Boolean getEstetica() {
		return estetica;
	}

	public void setEstetica(Boolean estetica) {
		this.estetica = estetica;
	}

	public Boolean getConvivioSocial() {
		return convivioSocial;
	}

	public void setConvivioSocial(Boolean convivioSocial) {
		this.convivioSocial = convivioSocial;
	}

	public Boolean getLazer() {
		return lazer;
	}

	public void setLazer(Boolean lazer) {
		this.lazer = lazer;
	}

	public Boolean getEmagrecimento() {
		return emagrecimento;
	}

	public void setEmagrecimento(Boolean emagrecimento) {
		this.emagrecimento = emagrecimento;
	}

	public Boolean getTerapeutico() {
		return terapeutico;
	}

	public void setTerapeutico(Boolean terapeutico) {
		this.terapeutico = terapeutico;
	}

	public Boolean getCondicioFisico() {
		return condicioFisico;
	}

	public void setCondicioFisico(Boolean condicioFisico) {
		this.condicioFisico = condicioFisico;
	}

	public Boolean getOutros() {
		return outros;
	}

	public void setOutros(Boolean outros) {
		this.outros = outros;
	}

	public String getOpcOutros() {
		return opcOutros;
	}

	public void setOpcOutros(String opcOutros) {
		this.opcOutros = opcOutros;
	}

}

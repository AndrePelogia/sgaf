package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Atividades é uma entidade, gerando uma tabela posterior
public class Atividades extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column(nullable = false)
	private Boolean realizaAtivFis;
	@Column(length = 200)
	private String realizaAtivFicOpc;
	@Column(length = 3, nullable = false)
	private Short hrsTrabSemanal;
	@Column(nullable = false)
	private Boolean ativTrabSentar;
	@Column(nullable = false)
	private Boolean ativTrabCaminhar;
	@Column(nullable = false)
	private Boolean ativTrabPeso;
	@Column(nullable = false)
	private Boolean ativTrabDirigir;
	@Column(nullable = false)
	private Boolean ativTrabEmPe;
	@Column(nullable = false)
	private Boolean ativTrabOutros;
	@Column(length = 150)
	private String ativTrabObs;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Boolean getRealizaAtivFis() {
		return realizaAtivFis;
	}

	public void setRealizaAtivFis(Boolean realizaAtivFis) {
		this.realizaAtivFis = realizaAtivFis;
	}

	public String getRealizaAtivFicOpc() {
		return realizaAtivFicOpc;
	}

	public void setRealizaAtivFicOpc(String realizaAtivFicOpc) {
		this.realizaAtivFicOpc = realizaAtivFicOpc;
	}

	public Short getHrsTrabSemanal() {
		return hrsTrabSemanal;
	}

	public void setHrsTrabSemanal(Short hrsTrabSemanal) {
		this.hrsTrabSemanal = hrsTrabSemanal;
	}

	public Boolean getAtivTrabSentar() {
		return ativTrabSentar;
	}

	public void setAtivTrabSentar(Boolean ativTrabSentar) {
		this.ativTrabSentar = ativTrabSentar;
	}

	public Boolean getAtivTrabCaminhar() {
		return ativTrabCaminhar;
	}

	public void setAtivTrabCaminhar(Boolean ativTrabCaminhar) {
		this.ativTrabCaminhar = ativTrabCaminhar;
	}

	public Boolean getAtivTrabPeso() {
		return ativTrabPeso;
	}

	public void setAtivTrabPeso(Boolean ativTrabPeso) {
		this.ativTrabPeso = ativTrabPeso;
	}

	public Boolean getAtivTrabDirigir() {
		return ativTrabDirigir;
	}

	public void setAtivTrabDirigir(Boolean ativTrabDirigir) {
		this.ativTrabDirigir = ativTrabDirigir;
	}

	public Boolean getAtivTrabEmPe() {
		return ativTrabEmPe;
	}

	public void setAtivTrabEmPe(Boolean ativTrabEmPe) {
		this.ativTrabEmPe = ativTrabEmPe;
	}

	public Boolean getAtivTrabOutros() {
		return ativTrabOutros;
	}

	public void setAtivTrabOutros(Boolean ativTrabOutros) {
		this.ativTrabOutros = ativTrabOutros;
	}

	public String getAtivTrabObs() {
		return ativTrabObs;
	}

	public void setAtivTrabObs(String ativTrabObs) {
		this.ativTrabObs = ativTrabObs;
	}

}

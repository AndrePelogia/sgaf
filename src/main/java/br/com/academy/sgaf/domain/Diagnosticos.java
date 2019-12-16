package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Diagnósticos é uma entidade, gerando uma tabela posterior
public class Diagnosticos extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column(nullable = false)
	private Boolean alcool;
	@Column(nullable = false)
	private Boolean artrite;
	@Column(nullable = false)
	private Boolean diabetes;
	@Column(nullable = false)
	private Boolean probMuscular;
	@Column(nullable = false)
	private Boolean probRenal;
	@Column(nullable = false)
	private Boolean probOcular;
	@Column(nullable = false)
	private Boolean probOsseo;
	@Column(nullable = false)
	private Boolean pressaoAlta;
	@Column(nullable = false)
	private Boolean enfisema;
	@Column(nullable = false)
	private Boolean ulcera;
	@Column(nullable = false)
	private Boolean avc;
	@Column(nullable = false)
	private Boolean anemia;
	@Column(nullable = false)
	private Boolean asma;
	@Column(nullable = false)
	private Boolean obesidade;
	@Column(nullable = false)
	private Boolean outros;
	@Column(length = 60)
	private String opcOutros;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Boolean getAlcool() {
		return alcool;
	}

	public void setAlcool(Boolean alcool) {
		this.alcool = alcool;
	}

	public Boolean getArtrite() {
		return artrite;
	}

	public void setArtrite(Boolean artrite) {
		this.artrite = artrite;
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	public Boolean getProbMuscular() {
		return probMuscular;
	}

	public void setProbMuscular(Boolean probMuscular) {
		this.probMuscular = probMuscular;
	}

	public Boolean getProbRenal() {
		return probRenal;
	}

	public void setProbRenal(Boolean probRenal) {
		this.probRenal = probRenal;
	}

	public Boolean getProbOcular() {
		return probOcular;
	}

	public void setProbOcular(Boolean probOcular) {
		this.probOcular = probOcular;
	}

	public Boolean getProbOsseo() {
		return probOsseo;
	}

	public void setProbOsseo(Boolean probOsseo) {
		this.probOsseo = probOsseo;
	}

	public Boolean getPressaoAlta() {
		return pressaoAlta;
	}

	public void setPressaoAlta(Boolean pressaoAlta) {
		this.pressaoAlta = pressaoAlta;
	}

	public Boolean getEnfisema() {
		return enfisema;
	}

	public void setEnfisema(Boolean enfisema) {
		this.enfisema = enfisema;
	}

	public Boolean getUlcera() {
		return ulcera;
	}

	public void setUlcera(Boolean ulcera) {
		this.ulcera = ulcera;
	}

	public Boolean getAvc() {
		return avc;
	}

	public void setAvc(Boolean avc) {
		this.avc = avc;
	}

	public Boolean getAnemia() {
		return anemia;
	}

	public void setAnemia(Boolean anemia) {
		this.anemia = anemia;
	}

	public Boolean getAsma() {
		return asma;
	}

	public void setAsma(Boolean asma) {
		this.asma = asma;
	}

	public Boolean getObesidade() {
		return obesidade;
	}

	public void setObesidade(Boolean obesidade) {
		this.obesidade = obesidade;
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

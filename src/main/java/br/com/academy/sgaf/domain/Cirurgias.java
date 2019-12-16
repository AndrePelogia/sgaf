package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Cirurgias é uma entidade, gerando uma tabela posterior
public class Cirurgias extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column(nullable = false)
	private Boolean coluna;
	@Column(nullable = false)
	private Boolean rim;
	@Column(nullable = false)
	private Boolean coracao;
	@Column(nullable = false)
	private Boolean pulmao;
	@Column(nullable = false)
	private Boolean articulacao;
	@Column(nullable = false)
	private Boolean olhos;
	@Column(nullable = false)
	private Boolean hernia;
	@Column(nullable = false)
	private Boolean outra;
	@Column(length = 20)
	private String opcOutra;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Boolean getColuna() {
		return coluna;
	}

	public void setColuna(Boolean coluna) {
		this.coluna = coluna;
	}

	public Boolean getRim() {
		return rim;
	}

	public void setRim(Boolean rim) {
		this.rim = rim;
	}

	public Boolean getCoracao() {
		return coracao;
	}

	public void setCoracao(Boolean coracao) {
		this.coracao = coracao;
	}

	public Boolean getPulmao() {
		return pulmao;
	}

	public void setPulmao(Boolean pulmao) {
		this.pulmao = pulmao;
	}

	public Boolean getArticulacao() {
		return articulacao;
	}

	public void setArticulacao(Boolean articulacao) {
		this.articulacao = articulacao;
	}

	public Boolean getOlhos() {
		return olhos;
	}

	public void setOlhos(Boolean olhos) {
		this.olhos = olhos;
	}

	public Boolean getHernia() {
		return hernia;
	}

	public void setHernia(Boolean hernia) {
		this.hernia = hernia;
	}

	public Boolean getOutra() {
		return outra;
	}

	public void setOutra(Boolean outra) {
		this.outra = outra;
	}

	public String getOpcOutra() {
		return opcOutra;
	}

	public void setOpcOutra(String opcOutra) {
		this.opcOutra = opcOutra;
	}

}

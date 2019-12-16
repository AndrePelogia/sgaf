package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Sintomas é uma entidade, gerando uma tabela posterior
public class Sintomas extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column(nullable = false, length = 1)
	private Byte tosseSangue;
	@Column(nullable = false, length = 1)
	private Byte dorToraxComAtivFis;
	@Column(nullable = false, length = 1)
	private Byte dorToraxSemAtivFis;
	@Column(nullable = false, length = 1)
	private Byte dorAbdmn;
	@Column(nullable = false, length = 1)
	private Byte dorPernas;
	@Column(nullable = false, length = 1)
	private Byte dorBracos;
	@Column(nullable = false, length = 1)
	private Byte dorCosta;
	@Column(nullable = false, length = 1)
	private Byte dorPescoco;
	@Column(nullable = false, length = 1)
	private Byte dorPeito;
	@Column(nullable = false, length = 1)
	private Byte dorArticular;
	@Column(nullable = false, length = 1)
	private Byte faltaDeAr;
	@Column(nullable = false, length = 1)
	private Byte fraqueza;
	@Column(nullable = false, length = 1)
	private Byte tontura;
	@Column(nullable = false, length = 1)
	private Byte batCardAcelerado;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Byte getTosseSangue() {
		return tosseSangue;
	}

	public void setTosseSangue(Byte tosseSangue) {
		this.tosseSangue = tosseSangue;
	}

	public Byte getDorToraxComAtivFis() {
		return dorToraxComAtivFis;
	}

	public void setDorToraxComAtivFis(Byte dorToraxComAtivFis) {
		this.dorToraxComAtivFis = dorToraxComAtivFis;
	}

	public Byte getDorToraxSemAtivFis() {
		return dorToraxSemAtivFis;
	}

	public void setDorToraxSemAtivFis(Byte dorToraxSemAtivFis) {
		this.dorToraxSemAtivFis = dorToraxSemAtivFis;
	}

	public Byte getDorAbdmn() {
		return dorAbdmn;
	}

	public void setDorAbdmn(Byte dorAbdmn) {
		this.dorAbdmn = dorAbdmn;
	}

	public Byte getDorPernas() {
		return dorPernas;
	}

	public void setDorPernas(Byte dorPernas) {
		this.dorPernas = dorPernas;
	}

	public Byte getDorBracos() {
		return dorBracos;
	}

	public void setDorBracos(Byte dorBracos) {
		this.dorBracos = dorBracos;
	}

	public Byte getDorCosta() {
		return dorCosta;
	}

	public void setDorCosta(Byte dorCosta) {
		this.dorCosta = dorCosta;
	}

	public Byte getDorPescoco() {
		return dorPescoco;
	}

	public void setDorPescoco(Byte dorPescoco) {
		this.dorPescoco = dorPescoco;
	}

	public Byte getDorPeito() {
		return dorPeito;
	}

	public void setDorPeito(Byte dorPeito) {
		this.dorPeito = dorPeito;
	}

	public Byte getDorArticular() {
		return dorArticular;
	}

	public void setDorArticular(Byte dorArticular) {
		this.dorArticular = dorArticular;
	}

	public Byte getFaltaDeAr() {
		return faltaDeAr;
	}

	public void setFaltaDeAr(Byte faltaDeAr) {
		this.faltaDeAr = faltaDeAr;
	}

	public Byte getFraqueza() {
		return fraqueza;
	}

	public void setFraqueza(Byte fraqueza) {
		this.fraqueza = fraqueza;
	}

	public Byte getTontura() {
		return tontura;
	}

	public void setTontura(Byte tontura) {
		this.tontura = tontura;
	}

	public Byte getBatCardAcelerado() {
		return batCardAcelerado;
	}

	public void setBatCardAcelerado(Byte batCardAcelerado) {
		this.batCardAcelerado = batCardAcelerado;
	}

}

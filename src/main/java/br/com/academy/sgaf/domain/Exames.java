package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que Exames é uma entidade, gerando uma tabela posterior
public class Exames extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Questionario questionario;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dtUltimExamFisMed;
	@Column(nullable = false)
	private Boolean prescricaoMed;
	@Column(length = 150)
	private String medicamentos;
	@Column(nullable = false)
	private Boolean cardiopatiaPai;
	@Column(nullable = false)
	private Boolean cardiopatiaMae;
	@Column(nullable = false)
	private Boolean cardiopatiaIrmao;
	@Column(nullable = false)
	private Boolean cardiopatiaAvo;
	@Column(nullable = false)
	private Boolean alergia;
	@Column(length = 30)
	private String alergiaOpc;
	@Column(nullable = false)
	private Boolean lesao;
	@Column(length = 30)
	private String lesaoOpc;
	@Column(nullable = false)
	private Boolean restricao;
	@Column(length = 30)
	private String restricaoOpc;
	@Column(nullable = false)
	private Boolean fumante;
	@Column(length = 2)
	private Byte qtddCigarros;
	@Column(length = 200)
	private String observacao;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Date getDtUltimExamFisMed() {
		return dtUltimExamFisMed;
	}

	public void setDtUltimExamFisMed(Date dtUltimExamFisMed) {
		this.dtUltimExamFisMed = dtUltimExamFisMed;
	}

	public Boolean getPrescricaoMed() {
		return prescricaoMed;
	}

	public void setPrescricaoMed(Boolean prescricaoMed) {
		this.prescricaoMed = prescricaoMed;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Boolean getCardiopatiaPai() {
		return cardiopatiaPai;
	}

	public void setCardiopatiaPai(Boolean cardiopatiaPai) {
		this.cardiopatiaPai = cardiopatiaPai;
	}

	public Boolean getCardiopatiaMae() {
		return cardiopatiaMae;
	}

	public void setCardiopatiaMae(Boolean cardiopatiaMae) {
		this.cardiopatiaMae = cardiopatiaMae;
	}

	public Boolean getCardiopatiaIrmao() {
		return cardiopatiaIrmao;
	}

	public void setCardiopatiaIrmao(Boolean cardiopatiaIrmao) {
		this.cardiopatiaIrmao = cardiopatiaIrmao;
	}

	public Boolean getCardiopatiaAvo() {
		return cardiopatiaAvo;
	}

	public void setCardiopatiaAvo(Boolean cardiopatiaAvo) {
		this.cardiopatiaAvo = cardiopatiaAvo;
	}

	public Boolean getAlergia() {
		return alergia;
	}

	public void setAlergia(Boolean alergia) {
		this.alergia = alergia;
	}

	public String getAlergiaOpc() {
		return alergiaOpc;
	}

	public void setAlergiaOpc(String alergiaOpc) {
		this.alergiaOpc = alergiaOpc;
	}

	public Boolean getLesao() {
		return lesao;
	}

	public void setLesao(Boolean lesao) {
		this.lesao = lesao;
	}

	public String getLesaoOpc() {
		return lesaoOpc;
	}

	public void setLesaoOpc(String lesaoOpc) {
		this.lesaoOpc = lesaoOpc;
	}

	public Boolean getRestricao() {
		return restricao;
	}

	public void setRestricao(Boolean restricao) {
		this.restricao = restricao;
	}

	public String getRestricaoOpc() {
		return restricaoOpc;
	}

	public void setRestricaoOpc(String restricaoOpc) {
		this.restricaoOpc = restricaoOpc;
	}

	public Boolean getFumante() {
		return fumante;
	}

	public void setFumante(Boolean fumante) {
		this.fumante = fumante;
	}

	public Byte getQtddCigarros() {
		return qtddCigarros;
	}

	public void setQtddCigarros(Byte qtddCigarros) {
		this.qtddCigarros = qtddCigarros;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}

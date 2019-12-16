package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que a Avaliação Física é uma entidade, gerando uma tabela
		// posterior
@Table(name = "AvaliacaoFisica")
public class AvaliacaoFisica extends GenericDomain {
	@Column(length = 35, nullable = false)
	private String objetivo;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtAvaFisica;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float peso;
	@Column(nullable = false, precision = 3, scale = 2)
	private Float altura;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float pescoco;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float ombros;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float toraxNormal;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float toraxInspira;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float toraxExpira;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float bracoEsq;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float bracoDir;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float abdmn;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float quadril;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float coxaEsq;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float coxaDir;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float pantuEsq;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float pantuDir;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float antebracoDir;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float antebracoEsq;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float cintura;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno; // buscar id do aluno
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario; // coletar automaticamente o cref do usuário

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getDtAvaFisica() {
		return dtAvaFisica;
	}

	public void setDtAvaFisica(Date dtAvaFisica) {
		this.dtAvaFisica = dtAvaFisica;
	}
	
	public Float getPeso() {
		return peso;
	}
	
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	public Float getAltura() {
		return altura;
	}
	
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	
	public Float getPescoco() {
		return pescoco;
	}

	public void setPescoco(Float pescoco) {
		this.pescoco = pescoco;
	}

	public Float getOmbros() {
		return ombros;
	}

	public void setOmbros(Float ombros) {
		this.ombros = ombros;
	}

	public Float getToraxNormal() {
		return toraxNormal;
	}

	public void setToraxNormal(Float toraxNormal) {
		this.toraxNormal = toraxNormal;
	}

	public Float getToraxInspira() {
		return toraxInspira;
	}

	public void setToraxInspira(Float toraxInspira) {
		this.toraxInspira = toraxInspira;
	}

	public Float getToraxExpira() {
		return toraxExpira;
	}

	public void setToraxExpira(Float toraxExpira) {
		this.toraxExpira = toraxExpira;
	}

	public Float getBracoEsq() {
		return bracoEsq;
	}

	public void setBracoEsq(Float bracoEsq) {
		this.bracoEsq = bracoEsq;
	}

	public Float getBracoDir() {
		return bracoDir;
	}

	public void setBracoDir(Float bracoDir) {
		this.bracoDir = bracoDir;
	}

	public Float getAbdmn() {
		return abdmn;
	}

	public void setAbdmn(Float abdmn) {
		this.abdmn = abdmn;
	}

	public Float getQuadril() {
		return quadril;
	}

	public void setQuadril(Float quadril) {
		this.quadril = quadril;
	}

	public Float getCoxaEsq() {
		return coxaEsq;
	}

	public void setCoxaEsq(Float coxaEsq) {
		this.coxaEsq = coxaEsq;
	}

	public Float getCoxaDir() {
		return coxaDir;
	}

	public void setCoxaDir(Float coxaDir) {
		this.coxaDir = coxaDir;
	}

	public Float getPantuEsq() {
		return pantuEsq;
	}

	public void setPantuEsq(Float pantuEsq) {
		this.pantuEsq = pantuEsq;
	}

	public Float getPantuDir() {
		return pantuDir;
	}

	public void setPantuDir(Float pantuDir) {
		this.pantuDir = pantuDir;
	}

	public Float getAntebracoDir() {
		return antebracoDir;
	}

	public void setAntebracoDir(Float antebracoDir) {
		this.antebracoDir = antebracoDir;
	}

	public Float getAntebracoEsq() {
		return antebracoEsq;
	}

	public void setAntebracoEsq(Float antebracoEsq) {
		this.antebracoEsq = antebracoEsq;
	}

	public Float getCintura() {
		return cintura;
	}

	public void setCintura(Float cintura) {
		this.cintura = cintura;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

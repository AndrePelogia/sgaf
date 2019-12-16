package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que a Treino é uma entidade, gerando uma tabela posterior
public class Treino extends GenericDomain {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario; // estrangeira que coleta o CREF
	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno; // estrangeira responsável pelo ID do Aluno
	@ManyToOne
	@JoinColumn(nullable = false)
	private AvaliacaoFisica af; // estrangeira responsável pela data da
								// Avaliação Física
	@ManyToOne
	@JoinColumn(nullable = false)
	private GrupoMuscular gm; // estrangeira responsável pelo Grupo Muscular
	@ManyToOne
	@JoinColumn(nullable = false)
	private Exercicio exercicio; // estrangeira responsável pelo Exercício
	@ManyToOne
	private Aparelho aparelho; // estrangeira responsável pelo Aparelho
	@Column(precision = 4, scale = 1)
	private Float carga;
	@Column(length = 1)
	private Byte serie;
	@Column(length = 3)
	private Short repeticoes;
	@Column(length = 3)
	private Short descanso;
	@Column(nullable = false, length = 1)
	private Byte diaTreino;

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

	public AvaliacaoFisica getAf() {
		return af;
	}

	public void setAf(AvaliacaoFisica af) {
		this.af = af;
	}

	public GrupoMuscular getGm() {
		return gm;
	}

	public void setGm(GrupoMuscular gm) {
		this.gm = gm;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	public Float getCarga() {
		return carga;
	}

	public void setCarga(Float carga) {
		this.carga = carga;
	}

	public Byte getSerie() {
		return serie;
	}

	public void setSerie(Byte serie) {
		this.serie = serie;
	}

	public Short getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(Short repeticoes) {
		this.repeticoes = repeticoes;
	}

	public Short getDescanso() {
		return descanso;
	}

	public void setDescanso(Short descanso) {
		this.descanso = descanso;
	}

	public Byte getDiaTreino() {
		return diaTreino;
	}

	public void setDiaTreino(Byte diaTreino) {
		this.diaTreino = diaTreino;
	}

}

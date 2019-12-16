package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Exercício é uma entidade, gerando uma tabela posterior
public class Exercicio extends GenericDomain {
	@Column(length = 45, nullable = false)
	private String nomeExerc;

	@ManyToOne
	@JoinColumn(nullable = false)
	private GrupoMuscular grupoMuscular;

	public String getNomeExerc() {
		return nomeExerc;
	}

	public void setNomeExerc(String nomeExerc) {
		this.nomeExerc = nomeExerc;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}

}

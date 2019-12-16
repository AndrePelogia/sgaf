package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Grupo Muscular é uma entidade, gerando uma tabela
		// posterior
public class GrupoMuscular extends GenericDomain {
	@Column(length = 25, nullable = false)
	private String nomeGM;

	public String getNomeGM() {
		return nomeGM;
	}

	public void setNomeGM(String nomeGM) {
		this.nomeGM = nomeGM;
	}

}

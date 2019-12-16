package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Aparelho é uma entidade, gerando uma tabela posterior
public class Aparelho extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nomeApar;
	@Column(nullable = false, precision = 4, scale = 1)
	private Float cgMax;

	public String getNomeApar() {
		return nomeApar;
	}

	public void setNomeApar(String nomeApar) {
		this.nomeApar = nomeApar;
	}

	public Float getCgMax() {
		return cgMax;
	}

	public void setCgMax(Float cgMax) {
		this.cgMax = cgMax;
	}

}

package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Usuário é uma entidade, gerando uma tabela posterior
public class Usuario extends Pessoa {
	@Column(length = 13, nullable = false)
	private String tipo;
	@Column(length = 9)
	private String cref;
	@Column
	@Temporal(TemporalType.DATE)
	private Date validadeCref;
	@Column(length = 10, nullable = false)
	private String login;
	@Column(length = 32, nullable = false)
	private String senha;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public Date getValidadeCref() {
		return validadeCref;
	}

	public void setValidadeCref(Date validadeCref) {
		this.validadeCref = validadeCref;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

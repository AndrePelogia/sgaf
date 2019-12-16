package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@MappedSuperclass // avisa que esta classe não gerará tabela
public class Pessoa extends GenericDomain {
	@Column(length = 60, nullable = false)
	protected String nome;
	@Column(length = 60, nullable = false)
	protected String endereco;
	@Column(length = 10)
	protected String complemento;
	@Column(length = 50, nullable = false)
	protected String bairro;
	@Column(length = 10, nullable = false)
	protected String cep;
	@Column(length = 60, nullable = false)
	protected String cidade;
	@Column(length = 2, nullable = false)
	protected String estado;
	@Column(length = 45)
	protected String email;
	@Column(length = 13)
	protected String telefone;
	@Column(length = 14)
	protected String celular;
	@Column(nullable = false)
	protected Character sexo;
	@Column(length = 14)
	protected String cpf;
	@Column(length = 12, nullable = false)
	protected String rg;
	@Column(length = 6, nullable = false)
	protected String ufrg;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	protected Date dtNasc; // analisa Data de Nascimento para o cálculo de idade

	@Column(length = 15, nullable = false)
	protected String estCivil;
	@Column(length = 10, nullable = false)
	protected String status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUfrg() {
		return ufrg;
	}

	public void setUfrg(String ufrg) {
		this.ufrg = ufrg;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

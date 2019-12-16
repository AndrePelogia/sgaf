package br.com.academy.sgaf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que a Empresa é uma entidade, gerando uma tabela posterior
public class Empresa extends GenericDomain {

	@Column(length = 60, nullable = false) // personaliza atributos (tamanho, não nulo)
	private String rzSocial;
	@Column(length = 60)
	private String nomeFantasia;
	@Column(length = 18, nullable = false)
	private String cnpj;
	@Column(length = 15, nullable = false)
	private String inscrEstadual;
	@Column(length = 60, nullable = false)
	private String endereco;
	@Column(length = 50, nullable = false)
	private String bairro;
	@Column(length = 10, nullable = false)
	private String cep;
	@Column(length = 60, nullable = false)
	private String cidade;
	@Column(length = 2, nullable = false)
	private String estado;
	@Column(length = 45, nullable = false)
	private String email;
	@Column(length = 13)
	private String telefone;
	@Column(length = 14)
	private String celular;

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEstadual() {
		return inscrEstadual;
	}

	public void setInscrEstadual(String inscrEstadual) {
		this.inscrEstadual = inscrEstadual;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

}

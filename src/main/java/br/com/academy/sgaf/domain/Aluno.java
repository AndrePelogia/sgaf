package br.com.academy.sgaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial") // anotation que avisa o compilador para ignorar
							// warning tipo serial desta classe
@Entity // anuncia que o Aluno é uma entidade, gerando uma tabela posterior
public class Aluno extends Pessoa {
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtCad;

	@Column(length = 2, nullable = false)
	private int idade; // calcula a idade

	// criar condição para os campos abaixo ficarem acessíveis
	@Column(length = 60) // obrigatório se menor de 18 anos
	private String nomeResp;
	@Column(length = 60) // obrigatório se menor de 18 anos
	private String endResp;
	@Column(length = 14) // obrigatório se menor de 18 anos
	private String cpfResp;
	@Column(length = 13) // obrigatório se menor de 18 anos
	private String telResp;
	@Column(length = 14) // obrigatório se menor de 18 anos
	private String celResp;

	@Column(length = 100) // criar função para salvar e carregar imagem no
							// computador
	@Transient //guarda informações temporárias não gerando coluna no banco
	private String urlImg;

	public Date getDtCad() {
		return dtCad;
	}

	public void setDtCad(Date dtCad) {
		this.dtCad = dtCad;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNomeResp() {
		return nomeResp;
	}

	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}

	public String getEndResp() {
		return endResp;
	}

	public void setEndResp(String endResp) {
		this.endResp = endResp;
	}

	public String getCpfResp() {
		return cpfResp;
	}

	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}

	public String getTelResp() {
		return telResp;
	}

	public void setTelResp(String telResp) {
		this.telResp = telResp;
	}

	public String getCelResp() {
		return celResp;
	}

	public void setCelResp(String celResp) {
		this.celResp = celResp;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

}

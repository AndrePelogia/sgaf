package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Aluno;

public class AlunoDAOTest {

	@Test
	public void salvar() throws ParseException{
		Aluno aluno = new Aluno();
		
		aluno.setNome("Fagundes Mello");
		aluno.setEndereco("Rua 7 de Setembro, 70");
		aluno.setComplemento(null);
		aluno.setBairro("Vila Sândalo");
		aluno.setCep("89.455-670");
		aluno.setCidade("Barueri");
		aluno.setEstado("SP");
		aluno.setEmail("fam15@hotmail.com");
		aluno.setTelefone(null);
		aluno.setCelular("(11)99536-6070");
		aluno.setSexo('M');
		aluno.setCpf("355.788.217-50");
		aluno.setRg("28.456.158-2");
		aluno.setUfrg("SSP/SP");
		aluno.setDtNasc(new SimpleDateFormat("dd/MM/yyyy").parse("05/04/1983"));
		aluno.setEstCivil("Solteiro");
		aluno.setStatus("Ativo");
		aluno.setDtCad(new Date());
		aluno.setIdade(32); // como fazer o cálculo da idade??

		aluno.setNomeResp(null);
		aluno.setEndResp(null);
		aluno.setCpfResp(null);
		aluno.setTelResp(null);
		aluno.setCelResp(null);
		aluno.setUrlImg(null);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.salvar(aluno);
		System.out.println("Aluno Salvo com Sucesso!!");
	}
	
	@Test
	@Ignore
	public void listar(){
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> resultado = alunoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Aluno aluno : resultado){
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Complemento: " + aluno.getComplemento());
			System.out.println("Bairro: " + aluno.getBairro());
			System.out.println("CEP: " + aluno.getCep());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Estado" + aluno.getEstado());
			System.out.println("E-mail: " + aluno.getEmail());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Celular: " + aluno.getCelular());
			System.out.println("Sexo: " + aluno.getSexo());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("RG: " + aluno.getRg());
			System.out.println("UFRG: " + aluno.getUfrg());
			System.out.println("Data de Nascimento: " + aluno.getDtNasc());
			System.out.println("Estado Civil: " + aluno.getEstCivil());
			System.out.println("Status: " + aluno.getStatus());
			System.out.println("Data do Cadastro: " + aluno.getDtCad());
			System.out.println("Idade do Aluno: " + aluno.getIdade());
			System.out.println("Nome do Responsável: " + aluno.getNomeResp());
			System.out.println("Endereço do Responsável: " + aluno.getEndResp());
			System.out.println("CPF do Responsável: " + aluno.getCpfResp());
			System.out.println("Telefone do Responsável: " + aluno.getTelResp());
			System.out.println("Celular do Responsável: " + aluno.getCelResp());
			System.out.println("Endereço da Foto: " + aluno.getUrlImg());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L; // L de Long
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigo);
		
		if(aluno == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Complemento: " + aluno.getComplemento());
			System.out.println("Bairro: " + aluno.getBairro());
			System.out.println("CEP: " + aluno.getCep());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Estado" + aluno.getEstado());
			System.out.println("E-mail: " + aluno.getEmail());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Celular: " + aluno.getCelular());
			System.out.println("Sexo: " + aluno.getSexo());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("RG: " + aluno.getRg());
			System.out.println("UFRG: " + aluno.getUfrg());
			System.out.println("Data de Nascimento: " + aluno.getDtNasc());
			System.out.println("Estado Civil: " + aluno.getEstCivil());
			System.out.println("Status: " + aluno.getStatus());
			System.out.println("Data do Cadastro: " + aluno.getDtCad());
			System.out.println("Idade do Aluno: " + aluno.getIdade());
			System.out.println("Nome do Responsável: " + aluno.getNomeResp());
			System.out.println("Endereço do Responsável: " + aluno.getEndResp());
			System.out.println("CPF do Responsável: " + aluno.getCpfResp());
			System.out.println("Telefone do Responsável: " + aluno.getTelResp());
			System.out.println("Celular do Responsável: " + aluno.getCelResp());
			System.out.println("Endereço da Foto: " + aluno.getUrlImg());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L; // L de Long
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigo);
		
		if(aluno == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			alunoDAO.excluir(aluno);
			System.out.println("Registro removido: ");
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Complemento: " + aluno.getComplemento());
			System.out.println("Bairro: " + aluno.getBairro());
			System.out.println("CEP: " + aluno.getCep());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Estado" + aluno.getEstado());
			System.out.println("E-mail: " + aluno.getEmail());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Celular: " + aluno.getCelular());
			System.out.println("Sexo: " + aluno.getSexo());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("RG: " + aluno.getRg());
			System.out.println("UFRG: " + aluno.getUfrg());
			System.out.println("Data de Nascimento: " + aluno.getDtNasc());
			System.out.println("Estado Civil: " + aluno.getEstCivil());
			System.out.println("Status: " + aluno.getStatus());
			System.out.println("Data do Cadastro: " + aluno.getDtCad());
			System.out.println("Idade do Aluno: " + aluno.getIdade());
			System.out.println("Nome do Responsável: " + aluno.getNomeResp());
			System.out.println("Endereço do Responsável: " + aluno.getEndResp());
			System.out.println("CPF do Responsável: " + aluno.getCpfResp());
			System.out.println("Telefone do Responsável: " + aluno.getTelResp());
			System.out.println("Celular do Responsável: " + aluno.getCelResp());
			System.out.println("Endereço da Foto: " + aluno.getUrlImg());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L; // L de Long
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigo);
		
		if(aluno == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Complemento: " + aluno.getComplemento());
			System.out.println("Bairro: " + aluno.getBairro());
			System.out.println("CEP: " + aluno.getCep());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Estado" + aluno.getEstado());
			System.out.println("E-mail: " + aluno.getEmail());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Celular: " + aluno.getCelular());
			System.out.println("Sexo: " + aluno.getSexo());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("RG: " + aluno.getRg());
			System.out.println("UFRG: " + aluno.getUfrg());
			System.out.println("Data de Nascimento: " + aluno.getDtNasc());
			System.out.println("Estado Civil: " + aluno.getEstCivil());
			System.out.println("Status: " + aluno.getStatus());
			System.out.println("Data do Cadastro: " + aluno.getDtCad());
			System.out.println("Idade do Aluno: " + aluno.getIdade());
			System.out.println("Nome do Responsável: " + aluno.getNomeResp());
			System.out.println("Endereço do Responsável: " + aluno.getEndResp());
			System.out.println("CPF do Responsável: " + aluno.getCpfResp());
			System.out.println("Telefone do Responsável: " + aluno.getTelResp());
			System.out.println("Celular do Responsável: " + aluno.getCelResp());
			System.out.println("Endereço da Foto: " + aluno.getUrlImg());
			System.out.println();
				
			aluno.setCpfResp("495.368.520-69");
			alunoDAO.editar(aluno);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Complemento: " + aluno.getComplemento());
			System.out.println("Bairro: " + aluno.getBairro());
			System.out.println("CEP: " + aluno.getCep());
			System.out.println("Cidade: " + aluno.getCidade());
			System.out.println("Estado" + aluno.getEstado());
			System.out.println("E-mail: " + aluno.getEmail());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("Celular: " + aluno.getCelular());
			System.out.println("Sexo: " + aluno.getSexo());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("RG: " + aluno.getRg());
			System.out.println("UFRG: " + aluno.getUfrg());
			System.out.println("Data de Nascimento: " + aluno.getDtNasc());
			System.out.println("Estado Civil: " + aluno.getEstCivil());
			System.out.println("Status: " + aluno.getStatus());
			System.out.println("Data do Cadastro: " + aluno.getDtCad());
			System.out.println("Idade do Aluno: " + aluno.getIdade());
			System.out.println("Nome do Responsável: " + aluno.getNomeResp());
			System.out.println("Endereço do Responsável: " + aluno.getEndResp());
			System.out.println("CPF do Responsável: " + aluno.getCpfResp());
			System.out.println("Telefone do Responsável: " + aluno.getTelResp());
			System.out.println("Celular do Responsável: " + aluno.getCelResp());
			System.out.println("Endereço da Foto: " + aluno.getUrlImg());
			System.out.println();			
		}
	
	}
	
}

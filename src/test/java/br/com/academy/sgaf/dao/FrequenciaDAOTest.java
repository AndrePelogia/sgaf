package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.Frequencia;

public class FrequenciaDAOTest {
	
	@Test
	public void salvar() throws ParseException{
		Long codigoAluno = 2L;
		AlunoDAO alunoDAO = new AlunoDAO();
		
		Frequencia frequencia = new Frequencia();
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		
		if(aluno == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			frequencia.setAluno(aluno);
			frequencia.setDiaPresente(new SimpleDateFormat("dd/MM/yyyy").parse("13/09/2015"));
		
			frequenciaDAO.salvar(frequencia);
			System.out.println("Frequência Salva com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		List<Frequencia> resultado = frequenciaDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Frequencia frequencia : resultado){
			System.out.println("Código: " + frequencia.getCodigo());
			System.out.println("Nome: " + frequencia.getAluno().getCodigo());
			System.out.println("Dias frequentados: " + frequencia.getDiaPresente());
			System.out.println("Total de dias frequentados: " + resultado.size());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoFrequencia = 1L; // L de Long
		
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		Frequencia frequencia = frequenciaDAO.buscar(codigoFrequencia);
		
		if(frequencia == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + frequencia.getCodigo());
			System.out.println("Nome: " + frequencia.getAluno().getCodigo());
			System.out.println("Dias frequentados: " + frequencia.getDiaPresente());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoFrequencia = 1L; // L de Long
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		Frequencia frequencia = frequenciaDAO.buscar(codigoFrequencia);
		
		if(frequencia == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			frequenciaDAO.excluir(frequencia);
			System.out.println("Registro removido: ");
			System.out.println("Código: " + frequencia.getCodigo());
			System.out.println("Nome: " + frequencia.getAluno().getCodigo());
			System.out.println("Dias frequentados: " + frequencia.getDiaPresente());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigoFrequencia = 1L; // L de Long
		Long codigoAluno = 1L;
		
		FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
		Frequencia frequencia = frequenciaDAO.buscar(codigoFrequencia);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		
		if(aluno == null){
			System.out.println("Aluno não encontrado!");
		}else{
			if(frequencia == null){
				System.out.println("Aluno Encontrado: ");
				System.out.println("Código: " + aluno.getCodigo());
				System.out.println("Nome do Aluno: " + aluno.getNome());
				System.out.println();
				
				System.out.println("Frequência não encontrada!");
			}else{
				System.out.println("Aluno Encontrado: ");
				System.out.println("Código: " + aluno.getCodigo());
				System.out.println("Nome do Aluno: " + aluno.getNome());
				System.out.println();
				
				System.out.println("Frequência para ser Alterada: ");
				System.out.println("Dia Presente: " + frequencia.getDiaPresente());
				System.out.println();

				frequencia.setDiaPresente(new SimpleDateFormat("dd/MM/yyyy").parse("09/09/2015"));
				frequenciaDAO.editar(frequencia);
				
				System.out.println("Frequência Alterada: ");
				System.out.println("Dia Presente: " + frequencia.getDiaPresente());
				System.out.println();
			}
			
		}
	
	}
	
}

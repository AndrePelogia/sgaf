package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.Usuario;
import br.com.academy.sgaf.domain.Questionario;

public class QuestionarioDAOTest {

	@Test
	public void salvar() throws ParseException{
		Long codigoAluno = 2L;
		Long codigoUsuario = 1L;
		AlunoDAO alunoDAO = new AlunoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Questionario questionario = new Questionario();
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		if(aluno == null){
			System.out.println("Nenhum aluno encontrado!!");
		}else{
			questionario.setAluno(aluno);
			questionario.setResp(aluno);
			questionario.setUsuario(usuario);
			questionario.setDtQuestion(new Date());

			questionarioDAO.salvar(questionario);
			System.out.println("Questionário Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){ 
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		List<Questionario> resultado = questionarioDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Questionario questionario : resultado){
			System.out.println("Código: " + questionario.getCodigo());
			System.out.println("Nome do Funcionário: " + questionario.getUsuario());
			System.out.println("Nome do Aluno: " + questionario.getAluno());
			System.out.println("Nome do Responsável: " + questionario.getResp());
			System.out.println("Data do Questionário: " + questionario.getDtQuestion());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoQuestionario = 1L; // L de Long
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Código: " + questionario.getCodigo());
			System.out.println("Nome do Funcionário: " + questionario.getUsuario());
			System.out.println("Nome do Aluno: " + questionario.getAluno());
			System.out.println("Nome do Responsável: " + questionario.getResp());
			System.out.println("Data do Questionário: " + questionario.getDtQuestion());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoQuestionario = 1L; // L de Long
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			questionarioDAO.excluir(questionario);
			System.out.println("Código: " + questionario.getCodigo());
			System.out.println("Nome do Funcionário: " + questionario.getUsuario());
			System.out.println("Nome do Aluno: " + questionario.getAluno());
			System.out.println("Nome do Responsável: " + questionario.getResp());
			System.out.println("Data do Questionário: " + questionario.getDtQuestion());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigoQuestionario = 1L; // L de Long
		Long codigoAluno = 1L;
		Long codigoUsuario = 1L;
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		if(usuario == null){
			System.out.println("Usuario não encontrado!");
		}else{
			if(aluno == null){
				System.out.println("Aluno não encontrado!");
			}else{
				if(questionario == null){
					System.out.println("Aluno encontrado: ");
					System.out.println("Nome do Aluno: " + aluno.getNome());
					System.out.println();
					
					System.out.println("Questionário não encontrado!!");
				}else{
					System.out.println("Aluno encontrado: ");
					System.out.println("Nome do Aluno: " + aluno.getNome());
					System.out.println();
					
					System.out.println("Questionário para ser alterado: ");
					System.out.println("Código: " + questionario.getCodigo());
					System.out.println("Nome do Funcionário: " + questionario.getUsuario());
					System.out.println("Nome do Aluno: " + questionario.getAluno());
					System.out.println("Nome do Responsável: " + questionario.getResp());
					System.out.println("Data do Questionário: " + questionario.getDtQuestion());
					System.out.println();
					
					questionario.setUsuario(usuario);
					questionarioDAO.editar(questionario);
					
					System.out.println("Questionário alterado: ");
					System.out.println("Código: " + questionario.getCodigo());
					System.out.println("Nome do Funcionário: " + questionario.getUsuario());
					System.out.println("Nome do Aluno: " + questionario.getAluno());
					System.out.println("Nome do Responsável: " + questionario.getResp());
					System.out.println("Data do Questionário: " + questionario.getDtQuestion());
					System.out.println();
				}
				
			}
			
		}
				
	}
	
}

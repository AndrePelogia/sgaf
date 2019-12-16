package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Diagnosticos;
import br.com.academy.sgaf.domain.Questionario;

public class DiagnosticosDAOTest {

	@Test
	public void salvar(){
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Diagnosticos diagnosticos = new Diagnosticos();
		DiagnosticosDAO diagnosticosDAO = new DiagnosticosDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			diagnosticos.setQuestionario(questionario);
			diagnosticos.setAlcool(true);
			diagnosticos.setArtrite(false);
			diagnosticos.setDiabetes(false);
			diagnosticos.setProbMuscular(true);
			diagnosticos.setProbRenal(false);
			diagnosticos.setProbOcular(false);
			diagnosticos.setProbOsseo(false);
			diagnosticos.setPressaoAlta(false);
			diagnosticos.setEnfisema(true);
			diagnosticos.setUlcera(false);
			diagnosticos.setAvc(false);
			diagnosticos.setAnemia(false);
			diagnosticos.setAsma(true);
			diagnosticos.setObesidade(true);
			diagnosticos.setOutros(false);
			diagnosticos.setOpcOutros(null);
			
			diagnosticosDAO.salvar(diagnosticos);
			System.out.println("Registro de Diagnósticos Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		DiagnosticosDAO diagnosticosDAO = new DiagnosticosDAO();
		List<Diagnosticos> resultado = diagnosticosDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Diagnosticos diagnosticos : resultado){
			System.out.println("Ingere bebidas alcoólicas?: " + (diagnosticos.getAlcool()?"Não":"Sim"));
			System.out.println("Tem Artrite?: " + (diagnosticos.getArtrite()?"Não":"Sim"));
			System.out.println("Tem Diabetes?: " + (diagnosticos.getDiabetes()?"Não":"Sim"));
			System.out.println("Tem problema Muscular?: " + (diagnosticos.getProbMuscular()?"Não":"Sim"));
			System.out.println("Tem problema Renal?: " + (diagnosticos.getProbRenal()?"Não":"Sim"));
			System.out.println("Tem problema Ocular?: " + (diagnosticos.getProbOcular()?"Não":"Sim"));
			System.out.println("Tem problema Ósseo?: " + (diagnosticos.getProbOsseo()?"Não":"Sim"));
			System.out.println("Tem Pressão Alta?: " + (diagnosticos.getPressaoAlta()?"Não":"Sim"));
			System.out.println("Sofre de Enfisema?: " + (diagnosticos.getEnfisema()?"Não":"Sim"));
			System.out.println("Sofre de Úlcera?: " + (diagnosticos.getUlcera()?"Não":"Sim"));
			System.out.println("Já teve AVC?: " + (diagnosticos.getAvc()?"Não":"Sim"));
			System.out.println("Tem Anemia?: " + (diagnosticos.getAnemia()?"Não":"Sim"));
			System.out.println("Sofre de Asma?: " + (diagnosticos.getAsma()?"Não":"Sim"));
			System.out.println("Sofre de Obesidade?: " + (diagnosticos.getObesidade()?"Não":"Sim"));
			System.out.println("Possui outra doença?: " + (diagnosticos.getOutros()?"Não":"Sim"));
			System.out.println("Qual doença?: " + (diagnosticos.getOpcOutros()));
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoDiagnosticos = 1L; // L de Long
		
		DiagnosticosDAO diagnosticosDAO = new DiagnosticosDAO();
		Diagnosticos diagnosticos = diagnosticosDAO.buscar(codigoDiagnosticos);

		if(diagnosticos == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Ingere bebidas alcoólicas?: " + (diagnosticos.getAlcool()?"Não":"Sim"));
			System.out.println("Tem Artrite?: " + (diagnosticos.getArtrite()?"Não":"Sim"));
			System.out.println("Tem Diabetes?: " + (diagnosticos.getDiabetes()?"Não":"Sim"));
			System.out.println("Tem problema Muscular?: " + (diagnosticos.getProbMuscular()?"Não":"Sim"));
			System.out.println("Tem problema Renal?: " + (diagnosticos.getProbRenal()?"Não":"Sim"));
			System.out.println("Tem problema Ocular?: " + (diagnosticos.getProbOcular()?"Não":"Sim"));
			System.out.println("Tem problema Ósseo?: " + (diagnosticos.getProbOsseo()?"Não":"Sim"));
			System.out.println("Tem Pressão Alta?: " + (diagnosticos.getPressaoAlta()?"Não":"Sim"));
			System.out.println("Sofre de Enfisema?: " + (diagnosticos.getEnfisema()?"Não":"Sim"));
			System.out.println("Sofre de Úlcera?: " + (diagnosticos.getUlcera()?"Não":"Sim"));
			System.out.println("Já teve AVC?: " + (diagnosticos.getAvc()?"Não":"Sim"));
			System.out.println("Tem Anemia?: " + (diagnosticos.getAnemia()?"Não":"Sim"));
			System.out.println("Sofre de Asma?: " + (diagnosticos.getAsma()?"Não":"Sim"));
			System.out.println("Sofre de Obesidade?: " + (diagnosticos.getObesidade()?"Não":"Sim"));
			System.out.println("Possui outra doença?: " + (diagnosticos.getOutros()?"Não":"Sim"));
			System.out.println("Qual doença?: " + (diagnosticos.getOpcOutros()));
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoDiagnosticos = 1L; // L de Long
		DiagnosticosDAO diagnosticosDAO = new DiagnosticosDAO();
		Diagnosticos diagnosticos = diagnosticosDAO.buscar(codigoDiagnosticos);
		
		if(diagnosticos == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			diagnosticosDAO.excluir(diagnosticos);
			System.out.println("Registro removido: ");
			System.out.println("Ingere bebidas alcoólicas?: " + (diagnosticos.getAlcool()?"Não":"Sim"));
			System.out.println("Tem Artrite?: " + (diagnosticos.getArtrite()?"Não":"Sim"));
			System.out.println("Tem Diabetes?: " + (diagnosticos.getDiabetes()?"Não":"Sim"));
			System.out.println("Tem problema Muscular?: " + (diagnosticos.getProbMuscular()?"Não":"Sim"));
			System.out.println("Tem problema Renal?: " + (diagnosticos.getProbRenal()?"Não":"Sim"));
			System.out.println("Tem problema Ocular?: " + (diagnosticos.getProbOcular()?"Não":"Sim"));
			System.out.println("Tem problema Ósseo?: " + (diagnosticos.getProbOsseo()?"Não":"Sim"));
			System.out.println("Tem Pressão Alta?: " + (diagnosticos.getPressaoAlta()?"Não":"Sim"));
			System.out.println("Sofre de Enfisema?: " + (diagnosticos.getEnfisema()?"Não":"Sim"));
			System.out.println("Sofre de Úlcera?: " + (diagnosticos.getUlcera()?"Não":"Sim"));
			System.out.println("Já teve AVC?: " + (diagnosticos.getAvc()?"Não":"Sim"));
			System.out.println("Tem Anemia?: " + (diagnosticos.getAnemia()?"Não":"Sim"));
			System.out.println("Sofre de Asma?: " + (diagnosticos.getAsma()?"Não":"Sim"));
			System.out.println("Sofre de Obesidade?: " + (diagnosticos.getObesidade()?"Não":"Sim"));
			System.out.println("Possui outra doença?: " + (diagnosticos.getOutros()?"Não":"Sim"));
			System.out.println("Qual doença?: " + (diagnosticos.getOpcOutros()));
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoDiagnosticos = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		DiagnosticosDAO diagnosticosDAO = new DiagnosticosDAO();
		Diagnosticos diagnosticos = diagnosticosDAO.buscar(codigoDiagnosticos);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(diagnosticos == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Diagnóstico não encontrado!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Diagnóstico para ser Alterado: ");
				System.out.println("Ingere bebidas alcoólicas?: " + (diagnosticos.getAlcool()?"Não":"Sim"));
				System.out.println("Tem Artrite?: " + (diagnosticos.getArtrite()?"Não":"Sim"));
				System.out.println("Tem Diabetes?: " + (diagnosticos.getDiabetes()?"Não":"Sim"));
				System.out.println("Tem problema Muscular?: " + (diagnosticos.getProbMuscular()?"Não":"Sim"));
				System.out.println("Tem problema Renal?: " + (diagnosticos.getProbRenal()?"Não":"Sim"));
				System.out.println("Tem problema Ocular?: " + (diagnosticos.getProbOcular()?"Não":"Sim"));
				System.out.println("Tem problema Ósseo?: " + (diagnosticos.getProbOsseo()?"Não":"Sim"));
				System.out.println("Tem Pressão Alta?: " + (diagnosticos.getPressaoAlta()?"Não":"Sim"));
				System.out.println("Sofre de Enfisema?: " + (diagnosticos.getEnfisema()?"Não":"Sim"));
				System.out.println("Sofre de Úlcera?: " + (diagnosticos.getUlcera()?"Não":"Sim"));
				System.out.println("Já teve AVC?: " + (diagnosticos.getAvc()?"Não":"Sim"));
				System.out.println("Tem Anemia?: " + (diagnosticos.getAnemia()?"Não":"Sim"));
				System.out.println("Sofre de Asma?: " + (diagnosticos.getAsma()?"Não":"Sim"));
				System.out.println("Sofre de Obesidade?: " + (diagnosticos.getObesidade()?"Não":"Sim"));
				System.out.println("Possui outra doença?: " + (diagnosticos.getOutros()?"Não":"Sim"));
				System.out.println("Qual doença?: " + (diagnosticos.getOpcOutros()));
				System.out.println();
				
				diagnosticos.setAlcool(true);
				diagnosticos.setArtrite(true);
				diagnosticos.setDiabetes(true);
				diagnosticos.setProbMuscular(false);
				diagnosticos.setProbRenal(true);
				diagnosticos.setProbOcular(true);
				diagnosticos.setProbOsseo(true);
				diagnosticos.setPressaoAlta(true);
				diagnosticos.setEnfisema(false);
				diagnosticos.setUlcera(true);
				diagnosticos.setAvc(true);
				diagnosticos.setAnemia(true);
				diagnosticos.setAsma(false);
				diagnosticos.setObesidade(false);
				diagnosticos.setOutros(false);
				diagnosticos.setOpcOutros(null);
				diagnosticosDAO.editar(diagnosticos);

				System.out.println("Diagnóstico Alterado: ");
				System.out.println("Ingere bebidas alcoólicas?: " + (diagnosticos.getAlcool()?"Não":"Sim"));
				System.out.println("Tem Artrite?: " + (diagnosticos.getArtrite()?"Não":"Sim"));
				System.out.println("Tem Diabetes?: " + (diagnosticos.getDiabetes()?"Não":"Sim"));
				System.out.println("Tem problema Muscular?: " + (diagnosticos.getProbMuscular()?"Não":"Sim"));
				System.out.println("Tem problema Renal?: " + (diagnosticos.getProbRenal()?"Não":"Sim"));
				System.out.println("Tem problema Ocular?: " + (diagnosticos.getProbOcular()?"Não":"Sim"));
				System.out.println("Tem problema Ósseo?: " + (diagnosticos.getProbOsseo()?"Não":"Sim"));
				System.out.println("Tem Pressão Alta?: " + (diagnosticos.getPressaoAlta()?"Não":"Sim"));
				System.out.println("Sofre de Enfisema?: " + (diagnosticos.getEnfisema()?"Não":"Sim"));
				System.out.println("Sofre de Úlcera?: " + (diagnosticos.getUlcera()?"Não":"Sim"));
				System.out.println("Já teve AVC?: " + (diagnosticos.getAvc()?"Não":"Sim"));
				System.out.println("Tem Anemia?: " + (diagnosticos.getAnemia()?"Não":"Sim"));
				System.out.println("Sofre de Asma?: " + (diagnosticos.getAsma()?"Não":"Sim"));
				System.out.println("Sofre de Obesidade?: " + (diagnosticos.getObesidade()?"Não":"Sim"));
				System.out.println("Possui outra doença?: " + (diagnosticos.getOutros()?"Não":"Sim"));
				System.out.println("Qual doença?: " + (diagnosticos.getOpcOutros()));
				System.out.println();
			}
			
		}
	
	}
	
}

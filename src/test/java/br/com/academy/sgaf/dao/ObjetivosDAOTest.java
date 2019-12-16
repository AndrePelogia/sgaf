package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Objetivos;
import br.com.academy.sgaf.domain.Questionario;

public class ObjetivosDAOTest {

	@Test
	public void salvar(){
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Objetivos objetivos = new Objetivos();
		ObjetivosDAO objetivosDAO = new ObjetivosDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			objetivos.setQuestionario(questionario);
			objetivos.setEstetica(true);
			objetivos.setConvivioSocial(true);
			objetivos.setLazer(false);
			objetivos.setEmagrecimento(true);
			objetivos.setTerapeutico(false);
			objetivos.setCondicioFisico(true);
			objetivos.setOutros(true);
			objetivos.setOpcOutros("Saúde");
			
			objetivosDAO.salvar(objetivos);
			System.out.println("Registro de Objetivos Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		ObjetivosDAO objetivosDAO = new ObjetivosDAO();
		List<Objetivos> resultado = objetivosDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Objetivos objetivos : resultado){
			System.out.println("Qual seu objetivo por estar na academia?");
			System.out.println("Estética: " + (objetivos.getEstetica()?"Não":"Sim"));
			System.out.println("Convívio Social: " + (objetivos.getConvivioSocial()?"Não":"Sim"));
			System.out.println("Lazer: " + (objetivos.getLazer()?"Não":"Sim"));
			System.out.println("Emagrecimento: " + (objetivos.getEmagrecimento()?"Não":"Sim"));
			System.out.println("Terapêutico: " + (objetivos.getTerapeutico()?"Não":"Sim"));
			System.out.println("Condicionamento Físico: " + (objetivos.getCondicioFisico()?"Não":"Sim"));
			System.out.println("Outros: " + (objetivos.getOutros()?"Não":"Sim"));
			System.out.println("Quais?: " + objetivos.getOpcOutros());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoObjetivos = 1L; // L de Long
		
		ObjetivosDAO objetivosDAO = new ObjetivosDAO();
		Objetivos objetivos = objetivosDAO.buscar(codigoObjetivos);

		if(objetivos == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Qual seu objetivo por estar na academia?");
			System.out.println("Estética: " + (objetivos.getEstetica()?"Não":"Sim"));
			System.out.println("Convívio Social: " + (objetivos.getConvivioSocial()?"Não":"Sim"));
			System.out.println("Lazer: " + (objetivos.getLazer()?"Não":"Sim"));
			System.out.println("Emagrecimento: " + (objetivos.getEmagrecimento()?"Não":"Sim"));
			System.out.println("Terapêutico: " + (objetivos.getTerapeutico()?"Não":"Sim"));
			System.out.println("Condicionamento Físico: " + (objetivos.getCondicioFisico()?"Não":"Sim"));
			System.out.println("Outros: " + (objetivos.getOutros()?"Não":"Sim"));
			System.out.println("Quais?: " + objetivos.getOpcOutros());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoObjetivos = 1L; // L de Long
		ObjetivosDAO objetivosDAO = new ObjetivosDAO();
		Objetivos objetivos = objetivosDAO.buscar(codigoObjetivos);
		
		if(objetivos == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			objetivosDAO.excluir(objetivos);
			System.out.println("Registro removido: ");
			System.out.println("Qual seu objetivo por estar na academia?");
			System.out.println("Estética: " + (objetivos.getEstetica()?"Não":"Sim"));
			System.out.println("Convívio Social: " + (objetivos.getConvivioSocial()?"Não":"Sim"));
			System.out.println("Lazer: " + (objetivos.getLazer()?"Não":"Sim"));
			System.out.println("Emagrecimento: " + (objetivos.getEmagrecimento()?"Não":"Sim"));
			System.out.println("Terapêutico: " + (objetivos.getTerapeutico()?"Não":"Sim"));
			System.out.println("Condicionamento Físico: " + (objetivos.getCondicioFisico()?"Não":"Sim"));
			System.out.println("Outros: " + (objetivos.getOutros()?"Não":"Sim"));
			System.out.println("Quais?: " + objetivos.getOpcOutros());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoObjetivos = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		ObjetivosDAO objetivosDAO = new ObjetivosDAO();
		Objetivos objetivos = objetivosDAO.buscar(codigoObjetivos);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(objetivos == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Objetivos não encontrados!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Objetivos para ser Alterados: ");
				System.out.println("Qual seu objetivo por estar na academia?");
				System.out.println("Estética: " + (objetivos.getEstetica()?"Não":"Sim"));
				System.out.println("Convívio Social: " + (objetivos.getConvivioSocial()?"Não":"Sim"));
				System.out.println("Lazer: " + (objetivos.getLazer()?"Não":"Sim"));
				System.out.println("Emagrecimento: " + (objetivos.getEmagrecimento()?"Não":"Sim"));
				System.out.println("Terapêutico: " + (objetivos.getTerapeutico()?"Não":"Sim"));
				System.out.println("Condicionamento Físico: " + (objetivos.getCondicioFisico()?"Não":"Sim"));
				System.out.println("Outros: " + (objetivos.getOutros()?"Não":"Sim"));
				System.out.println("Quais?: " + objetivos.getOpcOutros());
				System.out.println();
				
				objetivos.setEstetica(false);
				objetivos.setConvivioSocial(false);
				objetivos.setLazer(true);
				objetivos.setEmagrecimento(false);
				objetivos.setTerapeutico(false);
				objetivos.setCondicioFisico(true);
				objetivos.setOutros(false);
				objetivos.setOpcOutros(null);
				objetivosDAO.editar(objetivos);

				System.out.println("Objetivos Alterados: ");
				System.out.println("Qual seu objetivo por estar na academia?");
				System.out.println("Estética: " + (objetivos.getEstetica()?"Não":"Sim"));
				System.out.println("Convívio Social: " + (objetivos.getConvivioSocial()?"Não":"Sim"));
				System.out.println("Lazer: " + (objetivos.getLazer()?"Não":"Sim"));
				System.out.println("Emagrecimento: " + (objetivos.getEmagrecimento()?"Não":"Sim"));
				System.out.println("Terapêutico: " + (objetivos.getTerapeutico()?"Não":"Sim"));
				System.out.println("Condicionamento Físico: " + (objetivos.getCondicioFisico()?"Não":"Sim"));
				System.out.println("Outros: " + (objetivos.getOutros()?"Não":"Sim"));
				System.out.println("Quais?: " + objetivos.getOpcOutros());
				System.out.println();
			}
			
		}
	
	}
	
}

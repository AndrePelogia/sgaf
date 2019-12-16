package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Questionario;
import br.com.academy.sgaf.domain.Atividades;

public class AtividadesDAOTest {

	@Test
	public void salvar(){
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Atividades atividades = new Atividades();
		AtividadesDAO atividadesDAO = new AtividadesDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			atividades.setQuestionario(questionario);
			atividades.setRealizaAtivFis(false);
			atividades.setRealizaAtivFicOpc(null);
			atividades.setHrsTrabSemanal(new Short("40"));
			atividades.setAtivTrabSentar(true);
			atividades.setAtivTrabCaminhar(true);
			atividades.setAtivTrabPeso(false);
			atividades.setAtivTrabDirigir(true);
			atividades.setAtivTrabEmPe(false);
			atividades.setAtivTrabOutros(false);
			atividades.setAtivTrabObs(null);
			
			atividadesDAO.salvar(atividades);
			System.out.println("Registro de Atividades Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		AtividadesDAO atividadesDAO = new AtividadesDAO();
		List<Atividades> resultado = atividadesDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Atividades atividades : resultado){
			System.out.println("Realiza Atividade Física?: " + (atividades.getRealizaAtivFis()?"Não":"Sim"));
			System.out.println("Atividade: " + atividades.getRealizaAtivFicOpc());
			System.out.println("Horas de Trabalho: " + atividades.getHrsTrabSemanal());
			System.out.println("Trabalha Sentado?: " + (atividades.getAtivTrabSentar()?"Não":"Sim"));
			System.out.println("Trabalha Caminhando?: " + (atividades.getAtivTrabCaminhar()?"Não":"Sim"));
			System.out.println("Trabalha Levantando Peso?: " + (atividades.getAtivTrabPeso()?"Não":"Sim"));
			System.out.println("Trabalha Dirigindo?: " + (atividades.getAtivTrabDirigir()?"Não":"Sim"));
			System.out.println("Trabalha Em Pé?: " + (atividades.getAtivTrabEmPe()?"Não":"Sim"));
			System.out.println("Trabalha de Outra Forma?: " + (atividades.getAtivTrabOutros()?"Não":"Sim"));
			System.out.println("Outra Forma: " + atividades.getAtivTrabObs());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoAtividades = 1L; // L de Long
		
		AtividadesDAO atividadesDAO = new AtividadesDAO();
		Atividades atividades = atividadesDAO.buscar(codigoAtividades);

		if(atividades == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Realiza Atividade Física?: " + (atividades.getRealizaAtivFis()?"Não":"Sim"));
			System.out.println("Atividade: " + atividades.getRealizaAtivFicOpc());
			System.out.println("Horas de Trabalho: " + atividades.getHrsTrabSemanal());
			System.out.println("Trabalha Sentado?: " + (atividades.getAtivTrabSentar()?"Não":"Sim"));
			System.out.println("Trabalha Caminhando?: " + (atividades.getAtivTrabCaminhar()?"Não":"Sim"));
			System.out.println("Trabalha Levantando Peso?: " + (atividades.getAtivTrabPeso()?"Não":"Sim"));
			System.out.println("Trabalha Dirigindo?: " + (atividades.getAtivTrabDirigir()?"Não":"Sim"));
			System.out.println("Trabalha Em Pé?: " + (atividades.getAtivTrabEmPe()?"Não":"Sim"));
			System.out.println("Trabalha de Outra Forma?: " + (atividades.getAtivTrabOutros()?"Não":"Sim"));
			System.out.println("Outra Forma: " + atividades.getAtivTrabObs());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoAtividades = 1L; // L de Long
		AtividadesDAO atividadesDAO = new AtividadesDAO();
		Atividades atividades = atividadesDAO.buscar(codigoAtividades);
		
		if(atividades == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			atividadesDAO.excluir(atividades);
			System.out.println("Registro removido: ");
			System.out.println("Realiza Atividade Física?: " + (atividades.getRealizaAtivFis()?"Não":"Sim"));
			System.out.println("Atividade: " + atividades.getRealizaAtivFicOpc());
			System.out.println("Horas de Trabalho: " + atividades.getHrsTrabSemanal());
			System.out.println("Trabalha Sentado?: " + (atividades.getAtivTrabSentar()?"Não":"Sim"));
			System.out.println("Trabalha Caminhando?: " + (atividades.getAtivTrabCaminhar()?"Não":"Sim"));
			System.out.println("Trabalha Levantando Peso?: " + (atividades.getAtivTrabPeso()?"Não":"Sim"));
			System.out.println("Trabalha Dirigindo?: " + (atividades.getAtivTrabDirigir()?"Não":"Sim"));
			System.out.println("Trabalha Em Pé?: " + (atividades.getAtivTrabEmPe()?"Não":"Sim"));
			System.out.println("Trabalha de Outra Forma?: " + (atividades.getAtivTrabOutros()?"Não":"Sim"));
			System.out.println("Outra Forma: " + atividades.getAtivTrabObs());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoAtividades = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		AtividadesDAO atividadesDAO = new AtividadesDAO();
		Atividades atividades = atividadesDAO.buscar(codigoAtividades);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(atividades == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Atividade não encontrada!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Atividade para ser Alterada: ");
				System.out.println("Realiza Atividade Física?: " + (atividades.getRealizaAtivFis()?"Não":"Sim"));
				System.out.println("Atividade: " + atividades.getRealizaAtivFicOpc());
				System.out.println("Horas de Trabalho: " + atividades.getHrsTrabSemanal());
				System.out.println("Trabalha Sentado?: " + (atividades.getAtivTrabSentar()?"Não":"Sim"));
				System.out.println("Trabalha Caminhando?: " + (atividades.getAtivTrabCaminhar()?"Não":"Sim"));
				System.out.println("Trabalha Levantando Peso?: " + (atividades.getAtivTrabPeso()?"Não":"Sim"));
				System.out.println("Trabalha Dirigindo?: " + (atividades.getAtivTrabDirigir()?"Não":"Sim"));
				System.out.println("Trabalha Em Pé?: " + (atividades.getAtivTrabEmPe()?"Não":"Sim"));
				System.out.println("Trabalha de Outra Forma?: " + (atividades.getAtivTrabOutros()?"Não":"Sim"));
				System.out.println("Outra Forma: " + atividades.getAtivTrabObs());
				System.out.println();
				
				atividades.setAtivTrabCaminhar(true);
				atividades.setAtivTrabDirigir(false);
				atividades.setAtivTrabEmPe(true);
				atividades.setAtivTrabPeso(true);
				atividades.setAtivTrabSentar(false);
				atividadesDAO.editar(atividades);

				System.out.println("Atividade Alterada: ");
				System.out.println("Realiza Atividade Física?: " + (atividades.getRealizaAtivFis()?"Não":"Sim"));
				System.out.println("Atividade: " + atividades.getRealizaAtivFicOpc());
				System.out.println("Horas de Trabalho: " + atividades.getHrsTrabSemanal());
				System.out.println("Trabalha Sentado?: " + (atividades.getAtivTrabSentar()?"Não":"Sim"));
				System.out.println("Trabalha Caminhando?: " + (atividades.getAtivTrabCaminhar()?"Não":"Sim"));
				System.out.println("Trabalha Levantando Peso?: " + (atividades.getAtivTrabPeso()?"Não":"Sim"));
				System.out.println("Trabalha Dirigindo?: " + (atividades.getAtivTrabDirigir()?"Não":"Sim"));
				System.out.println("Trabalha Em Pé?: " + (atividades.getAtivTrabEmPe()?"Não":"Sim"));
				System.out.println("Trabalha de Outra Forma?: " + (atividades.getAtivTrabOutros()?"Não":"Sim"));
				System.out.println("Outra Forma: " + atividades.getAtivTrabObs());
				System.out.println();
			}
			
		}
	
	}
		
}

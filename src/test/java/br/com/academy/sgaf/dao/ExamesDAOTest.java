package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Exames;
import br.com.academy.sgaf.domain.Questionario;

public class ExamesDAOTest {

	@Test
	public void salvar() throws ParseException{
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Exames exames = new Exames();
		ExamesDAO examesDAO = new ExamesDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			exames.setQuestionario(questionario);
			exames.setDtUltimExamFisMed(new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2015"));
			exames.setPrescricaoMed(false);
			exames.setMedicamentos(null);
			exames.setCardiopatiaPai(true);
			exames.setCardiopatiaMae(false);
			exames.setCardiopatiaIrmao(false);
			exames.setCardiopatiaAvo(false);
			exames.setAlergia(true);
			exames.setAlergiaOpc("Picadas de Insetos");
			exames.setLesao(true);
			exames.setLesaoOpc("Mão");
			exames.setRestricao(false);
			exames.setRestricaoOpc(null);
			exames.setFumante(false);
			exames.setQtddCigarros(new Byte("0"));
			exames.setObservacao(null);
			
			examesDAO.salvar(exames);
			System.out.println("Registro de Exames Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		ExamesDAO examesDAO = new ExamesDAO();
		List<Exames> resultado = examesDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Exames exames : resultado){
			System.out.println("Data do último Exame: " + exames.getDtUltimExamFisMed());
			System.out.println("Possui prescrição médica?: " + (exames.getPrescricaoMed()?"Não":"Sim"));
			System.out.println("Medicamentos que toma: " + exames.getMedicamentos());
			System.out.println("Cardiopatia - Pai: " + (exames.getCardiopatiaPai()?"Não":"Sim"));
			System.out.println("Cardiopatia - Mãe: " + (exames.getCardiopatiaMae()?"Não":"Sim"));
			System.out.println("Cardiopatia - Irmão: " + (exames.getCardiopatiaIrmao()?"Não":"Sim"));
			System.out.println("Cardiopatia - Avô: " + (exames.getCardiopatiaAvo()?"Não":"Sim"));
			System.out.println("Possui Alergia?: " + (exames.getAlergia()?"Não":"Sim"));
			System.out.println("Qual Alergia?: " + exames.getAlergiaOpc());
			System.out.println("Possui alguma Lesão?: " + (exames.getLesao()?"Não":"Sim"));
			System.out.println("Lesão onde?: " + exames.getLesaoOpc());
			System.out.println("Possui alguma Restrição?: " + (exames.getRestricao()?"Não":"Sim"));
			System.out.println("Restrição do quê?: " + exames.getRestricaoOpc());
			System.out.println("Você Fuma?: " + exames.getFumante());
			System.out.println("Quantos cigarros por dia?: " + exames.getQtddCigarros());
			System.out.println("Alguma Observação?: " + exames.getObservacao());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoExames = 1L; // L de Long
		
		ExamesDAO examesDAO = new ExamesDAO();
		Exames exames = examesDAO.buscar(codigoExames);

		if(exames == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Data do último Exame: " + exames.getDtUltimExamFisMed());
			System.out.println("Possui prescrição médica?: " + (exames.getPrescricaoMed()?"Não":"Sim"));
			System.out.println("Medicamentos que toma: " + exames.getMedicamentos());
			System.out.println("Cardiopatia - Pai: " + (exames.getCardiopatiaPai()?"Não":"Sim"));
			System.out.println("Cardiopatia - Mãe: " + (exames.getCardiopatiaMae()?"Não":"Sim"));
			System.out.println("Cardiopatia - Irmão: " + (exames.getCardiopatiaIrmao()?"Não":"Sim"));
			System.out.println("Cardiopatia - Avô: " + (exames.getCardiopatiaAvo()?"Não":"Sim"));
			System.out.println("Possui Alergia?: " + (exames.getAlergia()?"Não":"Sim"));
			System.out.println("Qual Alergia?: " + exames.getAlergiaOpc());
			System.out.println("Possui alguma Lesão?: " + (exames.getLesao()?"Não":"Sim"));
			System.out.println("Lesão onde?: " + exames.getLesaoOpc());
			System.out.println("Possui alguma Restrição?: " + (exames.getRestricao()?"Não":"Sim"));
			System.out.println("Restrição do quê?: " + exames.getRestricaoOpc());
			System.out.println("Você Fuma?: " + exames.getFumante());
			System.out.println("Quantos cigarros por dia?: " + exames.getQtddCigarros());
			System.out.println("Alguma Observação?: " + exames.getObservacao());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoExames = 1L; // L de Long
		ExamesDAO examesDAO = new ExamesDAO();
		Exames exames = examesDAO.buscar(codigoExames);
		
		if(exames == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			examesDAO.excluir(exames);
			System.out.println("Registro removido: ");
			System.out.println("Data do último Exame: " + exames.getDtUltimExamFisMed());
			System.out.println("Possui prescrição médica?: " + (exames.getPrescricaoMed()?"Não":"Sim"));
			System.out.println("Medicamentos que toma: " + exames.getMedicamentos());
			System.out.println("Cardiopatia - Pai: " + (exames.getCardiopatiaPai()?"Não":"Sim"));
			System.out.println("Cardiopatia - Mãe: " + (exames.getCardiopatiaMae()?"Não":"Sim"));
			System.out.println("Cardiopatia - Irmão: " + (exames.getCardiopatiaIrmao()?"Não":"Sim"));
			System.out.println("Cardiopatia - Avô: " + (exames.getCardiopatiaAvo()?"Não":"Sim"));
			System.out.println("Possui Alergia?: " + (exames.getAlergia()?"Não":"Sim"));
			System.out.println("Qual Alergia?: " + exames.getAlergiaOpc());
			System.out.println("Possui alguma Lesão?: " + (exames.getLesao()?"Não":"Sim"));
			System.out.println("Lesão onde?: " + exames.getLesaoOpc());
			System.out.println("Possui alguma Restrição?: " + (exames.getRestricao()?"Não":"Sim"));
			System.out.println("Restrição do quê?: " + exames.getRestricaoOpc());
			System.out.println("Você Fuma?: " + exames.getFumante());
			System.out.println("Quantos cigarros por dia?: " + exames.getQtddCigarros());
			System.out.println("Alguma Observação?: " + exames.getObservacao());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigoExames = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		ExamesDAO examesDAO = new ExamesDAO();
		Exames exames = examesDAO.buscar(codigoExames);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(exames == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Exame não encontrado!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Exame para ser Alterado: ");
				System.out.println("Data do último Exame: " + exames.getDtUltimExamFisMed());
				System.out.println("Possui prescrição médica?: " + (exames.getPrescricaoMed()?"Não":"Sim"));
				System.out.println("Medicamentos que toma: " + exames.getMedicamentos());
				System.out.println("Cardiopatia - Pai: " + (exames.getCardiopatiaPai()?"Não":"Sim"));
				System.out.println("Cardiopatia - Mãe: " + (exames.getCardiopatiaMae()?"Não":"Sim"));
				System.out.println("Cardiopatia - Irmão: " + (exames.getCardiopatiaIrmao()?"Não":"Sim"));
				System.out.println("Cardiopatia - Avô: " + (exames.getCardiopatiaAvo()?"Não":"Sim"));
				System.out.println("Possui Alergia?: " + (exames.getAlergia()?"Não":"Sim"));
				System.out.println("Qual Alergia?: " + exames.getAlergiaOpc());
				System.out.println("Possui alguma Lesão?: " + (exames.getLesao()?"Não":"Sim"));
				System.out.println("Lesão onde?: " + exames.getLesaoOpc());
				System.out.println("Possui alguma Restrição?: " + (exames.getRestricao()?"Não":"Sim"));
				System.out.println("Restrição do quê?: " + exames.getRestricaoOpc());
				System.out.println("Você Fuma?: " + exames.getFumante());
				System.out.println("Quantos cigarros por dia?: " + exames.getQtddCigarros());
				System.out.println("Alguma Observação?: " + exames.getObservacao());
				System.out.println();
				
				exames.setDtUltimExamFisMed(new SimpleDateFormat("dd/MM/yyyy").parse("18/09/2014"));
				exames.setPrescricaoMed(true);
				exames.setMedicamentos("Amoxilina");
				exames.setCardiopatiaPai(false);
				exames.setCardiopatiaMae(false);
				exames.setCardiopatiaIrmao(true);
				exames.setCardiopatiaAvo(true);
				exames.setAlergia(true);
				exames.setAlergiaOpc("Água");
				exames.setLesao(false);
				exames.setLesaoOpc(null);
				exames.setRestricao(false);
				exames.setRestricaoOpc(null);
				exames.setFumante(true);
				exames.setQtddCigarros(new Byte("18"));
				exames.setObservacao("Tenho Câncer!!");
				examesDAO.editar(exames);

				System.out.println("Exame Alterado: ");
				System.out.println("Data do último Exame: " + exames.getDtUltimExamFisMed());
				System.out.println("Possui prescrição médica?: " + (exames.getPrescricaoMed()?"Não":"Sim"));
				System.out.println("Medicamentos que toma: " + exames.getMedicamentos());
				System.out.println("Cardiopatia - Pai: " + (exames.getCardiopatiaPai()?"Não":"Sim"));
				System.out.println("Cardiopatia - Mãe: " + (exames.getCardiopatiaMae()?"Não":"Sim"));
				System.out.println("Cardiopatia - Irmão: " + (exames.getCardiopatiaIrmao()?"Não":"Sim"));
				System.out.println("Cardiopatia - Avô: " + (exames.getCardiopatiaAvo()?"Não":"Sim"));
				System.out.println("Possui Alergia?: " + (exames.getAlergia()?"Não":"Sim"));
				System.out.println("Qual Alergia?: " + exames.getAlergiaOpc());
				System.out.println("Possui alguma Lesão?: " + (exames.getLesao()?"Não":"Sim"));
				System.out.println("Lesão onde?: " + exames.getLesaoOpc());
				System.out.println("Possui alguma Restrição?: " + (exames.getRestricao()?"Não":"Sim"));
				System.out.println("Restrição do quê?: " + exames.getRestricaoOpc());
				System.out.println("Você Fuma?: " + exames.getFumante());
				System.out.println("Quantos cigarros por dia?: " + exames.getQtddCigarros());
				System.out.println("Alguma Observação?: " + exames.getObservacao());
				System.out.println();
			}
			
		}
	
	}
	
}

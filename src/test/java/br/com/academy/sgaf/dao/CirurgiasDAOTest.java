package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Cirurgias;
import br.com.academy.sgaf.domain.Questionario;

public class CirurgiasDAOTest {

	@Test
	public void salvar(){
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Cirurgias cirurgias = new Cirurgias();
		CirurgiasDAO cirurgiasDAO = new CirurgiasDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			cirurgias.setQuestionario(questionario);
			cirurgias.setColuna(false);
			cirurgias.setRim(true);
			cirurgias.setCoracao(false);
			cirurgias.setPulmao(true);
			cirurgias.setArticulacao(false);
			cirurgias.setOlhos(false);
			cirurgias.setHernia(false);
			cirurgias.setOutra(false);
			cirurgias.setOpcOutra(null);
			
			cirurgiasDAO.salvar(cirurgias);
			System.out.println("Registro de Cirurgias Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		CirurgiasDAO cirurgiasDAO = new CirurgiasDAO();
		List<Cirurgias> resultado = cirurgiasDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Cirurgias cirurgias : resultado){
			System.out.println("Já fez cirurgia: ");
			System.out.println("Na Coluna? " + (cirurgias.getColuna()?"Não":"Sim"));
			System.out.println("No Rim? " + (cirurgias.getRim()?"Não":"Sim"));
			System.out.println("No Coração? " + (cirurgias.getCoracao()?"Não":"Sim"));
			System.out.println("No Pulmão? " + (cirurgias.getPulmao()?"Não":"Sim"));
			System.out.println("Nas Articulações? " + (cirurgias.getArticulacao()?"Não":"Sim"));
			System.out.println("Nos Olhos? " + (cirurgias.getOlhos()?"Não":"Sim"));
			System.out.println("Da Hérnia? " + (cirurgias.getHernia()?"Não":"Sim"));
			System.out.println("Em outra parte do corpo? " + (cirurgias.getOutra()?"Não":"Sim"));
			System.out.println("Qual parte? " + cirurgias.getOpcOutra());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoCirurgias = 1L; // L de Long
		
		CirurgiasDAO cirurgiasDAO = new CirurgiasDAO();
		Cirurgias cirurgias = cirurgiasDAO.buscar(codigoCirurgias);

		if(cirurgias == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Já fez cirurgia: ");
			System.out.println("Na Coluna? " + (cirurgias.getColuna()?"Não":"Sim"));
			System.out.println("No Rim? " + (cirurgias.getRim()?"Não":"Sim"));
			System.out.println("No Coração? " + (cirurgias.getCoracao()?"Não":"Sim"));
			System.out.println("No Pulmão? " + (cirurgias.getPulmao()?"Não":"Sim"));
			System.out.println("Nas Articulações? " + (cirurgias.getArticulacao()?"Não":"Sim"));
			System.out.println("Nos Olhos? " + (cirurgias.getOlhos()?"Não":"Sim"));
			System.out.println("Da Hérnia? " + (cirurgias.getHernia()?"Não":"Sim"));
			System.out.println("Em outra parte do corpo? " + (cirurgias.getOutra()?"Não":"Sim"));
			System.out.println("Qual parte? " + cirurgias.getOpcOutra());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoCirurgias = 1L; // L de Long
		CirurgiasDAO cirurgiasDAO = new CirurgiasDAO();
		Cirurgias cirurgias = cirurgiasDAO.buscar(codigoCirurgias);
		
		if(cirurgias == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			cirurgiasDAO.excluir(cirurgias);
			System.out.println("Registro removido: ");
			System.out.println("Já fez cirurgia: ");
			System.out.println("Na Coluna? " + (cirurgias.getColuna()?"Não":"Sim"));
			System.out.println("No Rim? " + (cirurgias.getRim()?"Não":"Sim"));
			System.out.println("No Coração? " + (cirurgias.getCoracao()?"Não":"Sim"));
			System.out.println("No Pulmão? " + (cirurgias.getPulmao()?"Não":"Sim"));
			System.out.println("Nas Articulações? " + (cirurgias.getArticulacao()?"Não":"Sim"));
			System.out.println("Nos Olhos? " + (cirurgias.getOlhos()?"Não":"Sim"));
			System.out.println("Da Hérnia? " + (cirurgias.getHernia()?"Não":"Sim"));
			System.out.println("Em outra parte do corpo? " + (cirurgias.getOutra()?"Não":"Sim"));
			System.out.println("Qual parte? " + cirurgias.getOpcOutra());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoCirurgias = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		CirurgiasDAO cirurgiasDAO = new CirurgiasDAO();
		Cirurgias cirurgias = cirurgiasDAO.buscar(codigoCirurgias);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(cirurgias == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Cirurgias não encontradas!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Cirurgias para serem Alteradas: ");
				System.out.println("Já fez cirurgia: ");
				System.out.println("Na Coluna? " + (cirurgias.getColuna()?"Não":"Sim"));
				System.out.println("No Rim? " + (cirurgias.getRim()?"Não":"Sim"));
				System.out.println("No Coração? " + (cirurgias.getCoracao()?"Não":"Sim"));
				System.out.println("No Pulmão? " + (cirurgias.getPulmao()?"Não":"Sim"));
				System.out.println("Nas Articulações? " + (cirurgias.getArticulacao()?"Não":"Sim"));
				System.out.println("Nos Olhos? " + (cirurgias.getOlhos()?"Não":"Sim"));
				System.out.println("Da Hérnia? " + (cirurgias.getHernia()?"Não":"Sim"));
				System.out.println("Em outra parte do corpo? " + (cirurgias.getOutra()?"Não":"Sim"));
				System.out.println("Qual parte? " + cirurgias.getOpcOutra());
				System.out.println();
				
				cirurgias.setColuna(true);
				cirurgias.setRim(false);
				cirurgias.setCoracao(true);
				cirurgias.setPulmao(false);
				cirurgias.setArticulacao(true);
				cirurgias.setOlhos(true);
				cirurgias.setHernia(true);
				cirurgias.setOutra(false);
				cirurgias.setOpcOutra(null);
				cirurgiasDAO.editar(cirurgias);

				System.out.println("Cirurgias Alteradas: ");
				System.out.println("Já fez cirurgia: ");
				System.out.println("Na Coluna? " + (cirurgias.getColuna()?"Não":"Sim"));
				System.out.println("No Rim? " + (cirurgias.getRim()?"Não":"Sim"));
				System.out.println("No Coração? " + (cirurgias.getCoracao()?"Não":"Sim"));
				System.out.println("No Pulmão? " + (cirurgias.getPulmao()?"Não":"Sim"));
				System.out.println("Nas Articulações? " + (cirurgias.getArticulacao()?"Não":"Sim"));
				System.out.println("Nos Olhos? " + (cirurgias.getOlhos()?"Não":"Sim"));
				System.out.println("Da Hérnia? " + (cirurgias.getHernia()?"Não":"Sim"));
				System.out.println("Em outra parte do corpo? " + (cirurgias.getOutra()?"Não":"Sim"));
				System.out.println("Qual parte? " + cirurgias.getOpcOutra());
				System.out.println();
			}
			
		}
	
	}
	
}

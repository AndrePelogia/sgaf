package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Sintomas;
import br.com.academy.sgaf.domain.Questionario;

public class SintomasDAOTest {

	@Test
	public void salvar(){
		Long codigoQuestionario = 1L;
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		Sintomas sintomas = new Sintomas();
		SintomasDAO sintomasDAO = new SintomasDAO();

		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			sintomas.setQuestionario(questionario);
			sintomas.setTosseSangue(new Byte("3")); // 1 - sempre, 2 - algumas vezes, 3 - nunca
			sintomas.setDorToraxComAtivFis(new Byte("2"));
			sintomas.setDorToraxSemAtivFis(new Byte("3"));
			sintomas.setDorAbdmn(new Byte("2"));
			sintomas.setDorPernas(new Byte("2"));
			sintomas.setDorBracos(new Byte("3"));
			sintomas.setDorCosta(new Byte("3"));
			sintomas.setDorPescoco(new Byte("3"));
			sintomas.setDorPeito(new Byte("3"));
			sintomas.setDorArticular(new Byte("2"));
			sintomas.setFaltaDeAr(new Byte("2"));
			sintomas.setFraqueza(new Byte("3"));
			sintomas.setTontura(new Byte("2"));
			sintomas.setBatCardAcelerado(new Byte("2"));
			
			sintomasDAO.salvar(sintomas);
			System.out.println("Registro de Sintomas Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		SintomasDAO sintomasDAO = new SintomasDAO();
		List<Sintomas> resultado = sintomasDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Sintomas sintomas : resultado){
			System.out.println("Tosse com sangue?: " + (sintomas.getTosseSangue()));
			System.out.println("Dor no Tórax com Atividades Físicas?: " + sintomas.getDorToraxComAtivFis());
			System.out.println("Dor no Tórax sem Atividades Físicas?: " + sintomas.getDorToraxSemAtivFis());
			System.out.println("Dor no Abdômen?: " + (sintomas.getDorAbdmn()));
			System.out.println("Dor nas Pernas?: " + (sintomas.getDorPernas()));
			System.out.println("Dor nos Braços?: " + (sintomas.getDorBracos()));
			System.out.println("Dor nas Costas?: " + (sintomas.getDorCosta()));
			System.out.println("Dor no Pescoço?: " + (sintomas.getDorPescoco()));
			System.out.println("Dor no Peito?: " + (sintomas.getDorPeito()));
			System.out.println("Dor na Articulação?: " + sintomas.getDorArticular());
			System.out.println("Falta de Ar?: " + sintomas.getFaltaDeAr());
			System.out.println("Fraqueza?: " + sintomas.getFraqueza());
			System.out.println("Tontura?: " + sintomas.getTontura());
			System.out.println("Batimento Cardíaco Acelerado:? " + sintomas.getBatCardAcelerado());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoSintomas = 1L; // L de Long
		
		SintomasDAO sintomasDAO = new SintomasDAO();
		Sintomas sintomas = sintomasDAO.buscar(codigoSintomas);

		if(sintomas == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Tosse com sangue?: " + (sintomas.getTosseSangue()));
			System.out.println("Dor no Tórax com Atividades Físicas?: " + sintomas.getDorToraxComAtivFis());
			System.out.println("Dor no Tórax sem Atividades Físicas?: " + sintomas.getDorToraxSemAtivFis());
			System.out.println("Dor no Abdômen?: " + (sintomas.getDorAbdmn()));
			System.out.println("Dor nas Pernas?: " + (sintomas.getDorPernas()));
			System.out.println("Dor nos Braços?: " + (sintomas.getDorBracos()));
			System.out.println("Dor nas Costas?: " + (sintomas.getDorCosta()));
			System.out.println("Dor no Pescoço?: " + (sintomas.getDorPescoco()));
			System.out.println("Dor no Peito?: " + (sintomas.getDorPeito()));
			System.out.println("Dor na Articulação?: " + sintomas.getDorArticular());
			System.out.println("Falta de Ar?: " + sintomas.getFaltaDeAr());
			System.out.println("Fraqueza?: " + sintomas.getFraqueza());
			System.out.println("Tontura?: " + sintomas.getTontura());
			System.out.println("Batimento Cardíaco Acelerado:? " + sintomas.getBatCardAcelerado());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoSintomas = 1L; // L de Long
		SintomasDAO sintomasDAO = new SintomasDAO();
		Sintomas sintomas = sintomasDAO.buscar(codigoSintomas);
		
		if(sintomas == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			sintomasDAO.excluir(sintomas);
			System.out.println("Registro removido: ");
			System.out.println("Tosse com sangue?: " + (sintomas.getTosseSangue()));
			System.out.println("Dor no Tórax com Atividades Físicas?: " + sintomas.getDorToraxComAtivFis());
			System.out.println("Dor no Tórax sem Atividades Físicas?: " + sintomas.getDorToraxSemAtivFis());
			System.out.println("Dor no Abdômen?: " + (sintomas.getDorAbdmn()));
			System.out.println("Dor nas Pernas?: " + (sintomas.getDorPernas()));
			System.out.println("Dor nos Braços?: " + (sintomas.getDorBracos()));
			System.out.println("Dor nas Costas?: " + (sintomas.getDorCosta()));
			System.out.println("Dor no Pescoço?: " + (sintomas.getDorPescoco()));
			System.out.println("Dor no Peito?: " + (sintomas.getDorPeito()));
			System.out.println("Dor na Articulação?: " + sintomas.getDorArticular());
			System.out.println("Falta de Ar?: " + sintomas.getFaltaDeAr());
			System.out.println("Fraqueza?: " + sintomas.getFraqueza());
			System.out.println("Tontura?: " + sintomas.getTontura());
			System.out.println("Batimento Cardíaco Acelerado:? " + sintomas.getBatCardAcelerado());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoSintomas = 1L; // L de Long
		Long codigoQuestionario = 1L;
		
		SintomasDAO sintomasDAO = new SintomasDAO();
		Sintomas sintomas = sintomasDAO.buscar(codigoSintomas);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		Questionario questionario = questionarioDAO.buscar(codigoQuestionario);
		
		if(questionario == null){
			System.out.println("Questionário não encontrado!");
		}else{
			if(sintomas == null){
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Sintomas não encontrados!");
			}else{
				System.out.println("Questionário Encontrado: ");
				System.out.println("Código: " + questionario.getCodigo());
				System.out.println("Data do Questionário: " + questionario.getDtQuestion());
				System.out.println();
				
				System.out.println("Sintomas para serem Alterados: ");
				System.out.println("Tosse com sangue?: " + (sintomas.getTosseSangue()));
				System.out.println("Dor no Tórax com Atividades Físicas?: " + sintomas.getDorToraxComAtivFis());
				System.out.println("Dor no Tórax sem Atividades Físicas?: " + sintomas.getDorToraxSemAtivFis());
				System.out.println("Dor no Abdômen?: " + (sintomas.getDorAbdmn()));
				System.out.println("Dor nas Pernas?: " + (sintomas.getDorPernas()));
				System.out.println("Dor nos Braços?: " + (sintomas.getDorBracos()));
				System.out.println("Dor nas Costas?: " + (sintomas.getDorCosta()));
				System.out.println("Dor no Pescoço?: " + (sintomas.getDorPescoco()));
				System.out.println("Dor no Peito?: " + (sintomas.getDorPeito()));
				System.out.println("Dor na Articulação?: " + sintomas.getDorArticular());
				System.out.println("Falta de Ar?: " + sintomas.getFaltaDeAr());
				System.out.println("Fraqueza?: " + sintomas.getFraqueza());
				System.out.println("Tontura?: " + sintomas.getTontura());
				System.out.println("Batimento Cardíaco Acelerado:? " + sintomas.getBatCardAcelerado());
				System.out.println();
				
				sintomas.setTosseSangue(new Byte("2"));
				sintomas.setDorToraxComAtivFis(new Byte("1"));
				sintomas.setDorToraxSemAtivFis(new Byte("3"));
				sintomas.setDorAbdmn(new Byte("2"));
				sintomas.setDorPernas(new Byte("1"));
				sintomas.setDorBracos(new Byte("1"));
				sintomas.setDorCosta(new Byte("3"));
				sintomas.setDorPescoco(new Byte("2"));
				sintomas.setDorPeito(new Byte("2"));
				sintomas.setDorArticular(new Byte("1"));
				sintomas.setFaltaDeAr(new Byte("1"));
				sintomas.setFraqueza(new Byte("2"));
				sintomas.setTontura(new Byte("2"));
				sintomas.setBatCardAcelerado(new Byte("1"));
				sintomasDAO.editar(sintomas);

				System.out.println("Sintomas Alterados: ");
				System.out.println("Tosse com sangue?: " + (sintomas.getTosseSangue()));
				System.out.println("Dor no Tórax com Atividades Físicas?: " + sintomas.getDorToraxComAtivFis());
				System.out.println("Dor no Tórax sem Atividades Físicas?: " + sintomas.getDorToraxSemAtivFis());
				System.out.println("Dor no Abdômen?: " + (sintomas.getDorAbdmn()));
				System.out.println("Dor nas Pernas?: " + (sintomas.getDorPernas()));
				System.out.println("Dor nos Braços?: " + (sintomas.getDorBracos()));
				System.out.println("Dor nas Costas?: " + (sintomas.getDorCosta()));
				System.out.println("Dor no Pescoço?: " + (sintomas.getDorPescoco()));
				System.out.println("Dor no Peito?: " + (sintomas.getDorPeito()));
				System.out.println("Dor na Articulação?: " + sintomas.getDorArticular());
				System.out.println("Falta de Ar?: " + sintomas.getFaltaDeAr());
				System.out.println("Fraqueza?: " + sintomas.getFraqueza());
				System.out.println("Tontura?: " + sintomas.getTontura());
				System.out.println("Batimento Cardíaco Acelerado:? " + sintomas.getBatCardAcelerado());
				System.out.println();
			}
			
		}
	
	}
	
}

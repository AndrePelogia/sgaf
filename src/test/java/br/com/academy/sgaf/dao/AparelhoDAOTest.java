package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Aparelho;

public class AparelhoDAOTest {

	@Test
	public void salvar(){
		Aparelho aparelho = new Aparelho();
		aparelho.setNomeApar("CrossOver");
		aparelho.setCgMax(200.0F);
		
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		aparelhoDAO.salvar(aparelho);
		System.out.println("Aparelho Salvo com Sucesso!!");
	}
	
	@Test
	@Ignore
	public void listar(){
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		List<Aparelho> resultado = aparelhoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Aparelho aparelho : resultado){
			System.out.println("Código: " + aparelho.getCodigo());
			System.out.println("Nome: " + aparelho.getNomeApar());
			System.out.println("Carga Máxima: " + aparelho.getCgMax());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L; // L de Long
		
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		Aparelho aparelho = aparelhoDAO.buscar(codigo);
		
		if(aparelho == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + aparelho.getCodigo());
			System.out.println("Nome: " + aparelho.getNomeApar());
			System.out.println("Carga Máxima: " + aparelho.getCgMax());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L; // L de Long
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		Aparelho aparelho = aparelhoDAO.buscar(codigo);
		
		if(aparelho == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			aparelhoDAO.excluir(aparelho);
			System.out.println("Registro removido: ");
			System.out.println("Código: " + aparelho.getCodigo());
			System.out.println("Nome: " + aparelho.getNomeApar());
			System.out.println("Carga Máxima: " + aparelho.getCgMax());
			System.out.println();
		}
		
	}
	
	@Ignore
	@Test
	public void editar(){
		Long codigo = 1L; // L de Long
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		Aparelho aparelho = aparelhoDAO.buscar(codigo);
		
		if(aparelho == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println("Código: " + aparelho.getCodigo());
			System.out.println("Nome: " + aparelho.getNomeApar());
			System.out.println("Carga Máxima: " + aparelho.getCgMax());
			System.out.println();

			aparelho.setNomeApar("Esteira CLE 20 Premium");
			aparelho.setCgMax(180.0F);
			aparelhoDAO.editar(aparelho);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println("Código: " + aparelho.getCodigo());
			System.out.println("Nome: " + aparelho.getNomeApar());
			System.out.println("Carga Máxima: " + aparelho.getCgMax());
			System.out.println();
		}
		
	}
		
}

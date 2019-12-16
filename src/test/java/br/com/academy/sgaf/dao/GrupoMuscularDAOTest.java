package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.GrupoMuscular;

public class GrupoMuscularDAOTest {

	@Test
	public void salvar(){
		GrupoMuscular grupoMuscular = new GrupoMuscular();
		grupoMuscular.setNomeGM("Esteira");
		
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		grupoMuscularDAO.salvar(grupoMuscular);
		System.out.println("Grupo Muscular Salvo com Sucesso!!");
	}
	
	@Test
	@Ignore
	public void listar(){
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		List<GrupoMuscular> resultado = grupoMuscularDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(GrupoMuscular grupoMuscular : resultado){
			System.out.println("Código: " + grupoMuscular.getCodigo());
			System.out.println("Nome: " + grupoMuscular.getNomeGM());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L; // L de Long
		
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigo);
		
		if(grupoMuscular == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + grupoMuscular.getCodigo());
			System.out.println("Nome: " + grupoMuscular.getNomeGM());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L; // L de Long
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigo);
		
		if(grupoMuscular == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			grupoMuscularDAO.excluir(grupoMuscular);
			System.out.println("Registro removido: ");
			System.out.println("Código: " + grupoMuscular.getCodigo());
			System.out.println("Nome: " + grupoMuscular.getNomeGM());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L; // L de Long
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigo);
		
		if(grupoMuscular == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println("Código: " + grupoMuscular.getCodigo());
			System.out.println("Nome: " + grupoMuscular.getNomeGM());
			System.out.println();
			
			grupoMuscular.setNomeGM("Tríceps Braquial");
			grupoMuscularDAO.editar(grupoMuscular);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println("Código: " + grupoMuscular.getCodigo());
			System.out.println("Nome: " + grupoMuscular.getNomeGM());
			System.out.println();
		}
	
	}
	
}

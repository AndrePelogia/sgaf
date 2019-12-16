package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Exercicio;
import br.com.academy.sgaf.domain.GrupoMuscular;

public class ExercicioDAOTest {

	@Test
	public void salvar(){
		Long codigoGrupoMuscular = 1L;
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		
		Exercicio exercicio = new Exercicio();
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigoGrupoMuscular);
		
		if(grupoMuscular == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			exercicio.setNomeExerc("Caminhada");
			exercicio.setGrupoMuscular(grupoMuscular);
		
			exercicioDAO.salvar(exercicio);
			System.out.println("Exercício Salvo com Sucesso");
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		List<Exercicio> resultado = exercicioDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Exercicio exercicio : resultado){
			System.out.println("Código: " + exercicio.getCodigo());
			System.out.println("Nome: " + exercicio.getNomeExerc());
			System.out.println("GrupoMuscular: " + exercicio.getGrupoMuscular().getNomeGM());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoExercicio = 1L; // L de Long
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		Exercicio exercicio = exercicioDAO.buscar(codigoExercicio);
		
		if(exercicio == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + exercicio.getCodigo());
			System.out.println("Nome: " + exercicio.getNomeExerc());
			System.out.println("GrupoMuscular: " + exercicio.getGrupoMuscular().getNomeGM());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoExercicio = 1L; // L de Long
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		Exercicio exercicio = exercicioDAO.buscar(codigoExercicio);
		
		if(exercicio == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			exercicioDAO.excluir(exercicio);
			System.out.println("Registro removido: ");
			System.out.println("Código: " + exercicio.getCodigo());
			System.out.println("Nome: " + exercicio.getNomeExerc());
			System.out.println("GrupoMuscular: " + exercicio.getGrupoMuscular().getNomeGM());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoExercicio = 1L; // L de Long
		Long codigoGrupoMuscular = 1L;
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		Exercicio exercicio = exercicioDAO.buscar(codigoExercicio);
		
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigoGrupoMuscular);
		
		if(grupoMuscular == null){
			System.out.println("Grupo Muscular não encontrado!");
		}else{
			if(exercicio == null){
				System.out.println("GrupoMuscular Procurado: ");
				System.out.println("Código: " + grupoMuscular.getCodigo());
				System.out.println("Nome: " + grupoMuscular.getNomeGM());
				System.out.println();
				
				System.out.println("Exercício não encontrado!");
			}else{
				System.out.println("GrupoMuscular Procurado: ");
				System.out.println("Código: " + grupoMuscular.getCodigo());
				System.out.println("Nome: " + grupoMuscular.getNomeGM());
				System.out.println();
				
				System.out.println("Registro editado - Antes: ");
				System.out.println("Código: " + exercicio.getCodigo());
				System.out.println("Nome: " + exercicio.getNomeExerc());
				System.out.println("GrupoMuscular: " + exercicio.getGrupoMuscular().getNomeGM());
				System.out.println();
				
				exercicio.setNomeExerc("Alongamento");
				exercicio.setGrupoMuscular(grupoMuscular);
				exercicioDAO.editar(exercicio);
				
				System.out.println("Registro editado - Depois: ");
				System.out.println("Código: " + exercicio.getCodigo());
				System.out.println("Nome: " + exercicio.getNomeExerc());
				System.out.println("GrupoMuscular: " + exercicio.getGrupoMuscular().getNomeGM());
				System.out.println();
			}
			
		}
	
	}
	
}

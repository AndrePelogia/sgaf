package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Treino;
import br.com.academy.sgaf.domain.AvaliacaoFisica;
import br.com.academy.sgaf.domain.GrupoMuscular;
import br.com.academy.sgaf.domain.Exercicio;
import br.com.academy.sgaf.domain.Aparelho;
import br.com.academy.sgaf.domain.Usuario;
import br.com.academy.sgaf.domain.Aluno;

public class TreinoDAOTest {

	@Test
	public void salvar() throws ParseException{
		Long codigoUsuario = 1L; // O usuário tem que ter CREF registrado
		Long codigoAluno = 1L;
		Long codigoAvaliacaoFisica = 1L;
		Long codigoGrupoMuscular = 1L;
		Long codigoExercicio = 1L;
		Long codigoAparelho = 2L;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		
		Treino treino = new Treino();
		TreinoDAO treinoDAO = new TreinoDAO();
		
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		AvaliacaoFisica af = afDAO.buscar(codigoAvaliacaoFisica);
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigoGrupoMuscular);
		Exercicio exercicio = exercicioDAO.buscar(codigoExercicio);
		Aparelho aparelho = aparelhoDAO.buscar(codigoAparelho);
		
		if(usuario.getCref().equals(null)){
			System.out.println("Nenhum CREF encontrado!!");
		}else{
			if(aluno == null){
				System.out.println("Nenhum Aluno encontrado!!");
			}else{
				if(af == null){
					System.out.println("Nenhuma Avaliação Física encontrada!!");
				}else{
					if(grupoMuscular == null){
						System.out.println("Nenhum Grupo Muscular encontrado!!");
					}else{
						if(exercicio == null){
							System.out.println("Nenhum Exercício encontrado!!");
						}else{
							treino.setUsuario(usuario);
							treino.setAluno(aluno);
							treino.setAf(af);
							treino.setGm(grupoMuscular);
							treino.setExercicio(exercicio);
							treino.setAparelho(aparelho);
							treino.setCarga(50F);
							treino.setSerie(new Byte("5"));
							treino.setRepeticoes(new Short("18"));
							treino.setDescanso(new Short("45")); // em segundos
							treino.setDiaTreino(new Byte("2"));
							
							treinoDAO.salvar(treino);
							System.out.println("Treino Salvo com Sucesso");
						}
					}
				}
			}	
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		TreinoDAO treinoDAO = new TreinoDAO();
		List<Treino> resultado = treinoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Treino treino : resultado){
			System.out.println("Código do Treino: " + treino.getCodigo());
			System.out.println("Nome do Usuário: " + treino.getUsuario().getNome());
			System.out.println("Nome do Aluno: " + treino.getAluno().getNome());
			System.out.println("Data da Avaliação Física: " + treino.getAf().getDtAvaFisica());
			System.out.println("Grupo Muscular: " + treino.getGm().getNomeGM());
			System.out.println("Exercício: " + treino.getExercicio().getNomeExerc());
			System.out.println("Aparelho: " + treino.getAparelho().getNomeApar());
			System.out.println("Carga: " + treino.getCarga());
			System.out.println("Série: " + treino.getSerie());
			System.out.println("Repetições: " + treino.getRepeticoes());
			System.out.println("Descanso: " + treino.getDescanso());
			System.out.println("Dia de Treino: " + treino.getDiaTreino());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoTreino = 1L; // L de Long
		
		TreinoDAO treinoDAO = new TreinoDAO();
		Treino treino = treinoDAO.buscar(codigoTreino);
		
		if(treino == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Código do Treino: " + treino.getCodigo());
			System.out.println("Nome do Usuário: " + treino.getUsuario().getNome());
			System.out.println("Nome do Aluno: " + treino.getAluno().getNome());
			System.out.println("Data da Avaliação Física: " + treino.getAf().getDtAvaFisica());
			System.out.println("Grupo Muscular: " + treino.getGm().getNomeGM());
			System.out.println("Exercício: " + treino.getExercicio().getNomeExerc());
			System.out.println("Aparelho: " + treino.getAparelho().getNomeApar());
			System.out.println("Carga: " + treino.getCarga());
			System.out.println("Série: " + treino.getSerie());
			System.out.println("Repetições: " + treino.getRepeticoes());
			System.out.println("Descanso: " + treino.getDescanso());
			System.out.println("Dia de Treino: " + treino.getDiaTreino());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoTreino = 1L; // L de Long
		TreinoDAO treinoDAO = new TreinoDAO();
		Treino treino = treinoDAO.buscar(codigoTreino);
		
		if(treino == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			treinoDAO.excluir(treino);
			System.out.println("Código do Treino: " + treino.getCodigo());
			System.out.println("Nome do Usuário: " + treino.getUsuario().getNome());
			System.out.println("Nome do Aluno: " + treino.getAluno().getNome());
			System.out.println("Data da Avaliação Física: " + treino.getAf().getDtAvaFisica());
			System.out.println("Grupo Muscular: " + treino.getGm().getNomeGM());
			System.out.println("Exercício: " + treino.getExercicio().getNomeExerc());
			System.out.println("Aparelho: " + treino.getAparelho().getNomeApar());
			System.out.println("Carga: " + treino.getCarga());
			System.out.println("Série: " + treino.getSerie());
			System.out.println("Repetições: " + treino.getRepeticoes());
			System.out.println("Descanso: " + treino.getDescanso());
			System.out.println("Dia de Treino: " + treino.getDiaTreino());
			System.out.println();
		}
		
	}
	
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigoAluno = 1L;
		Long codigoUsuario = 1L;
		Long codigoAvaliacaoFisica = 1L;
		Long codigoGrupoMuscular = 1L;
		Long codigoExercicio = 1L;
		Long codigoAparelho = 1L;
		Long codigoTreino = 1L;
		
		TreinoDAO treinoDAO = new TreinoDAO();
		Treino treino = treinoDAO.buscar(codigoTreino);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		AvaliacaoFisica af = afDAO.buscar(codigoAvaliacaoFisica);
		
		GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
		GrupoMuscular grupoMuscular = grupoMuscularDAO.buscar(codigoGrupoMuscular);
		
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		Exercicio exercicio = exercicioDAO.buscar(codigoExercicio);
		
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		Aparelho aparelho = aparelhoDAO.buscar(codigoAparelho);
		
		if(usuario.getCref().equals(null)){
			System.out.println("O usuário não possui CREF!!");
		}else{
			if(aluno == null){
				System.out.println("Aluno não encontrado!!");
			}else{
				if(af == null){
					System.out.println("Avaliação não registrada!!");
				}else{
					if(grupoMuscular == null){
						System.out.println("Grupo Muscular não encontrado!!");
					}else{
						if(exercicio == null){
							System.out.println("Exercício não encontrado!!");
						}else{
							System.out.println("Treino para ser Alterado: ");
							System.out.println("Código do Treino: " + treino.getCodigo());
							System.out.println("Nome do Usuário: " + treino.getUsuario().getNome());
							System.out.println("Nome do Aluno: " + treino.getAluno().getNome());
							System.out.println("Data da Avaliação Física: " + treino.getAf().getDtAvaFisica());
							System.out.println("Grupo Muscular: " + treino.getGm().getNomeGM());
							System.out.println("Exercício: " + treino.getExercicio().getNomeExerc());
							System.out.println("Aparelho: " + treino.getAparelho().getNomeApar());
							System.out.println("Carga: " + treino.getCarga());
							System.out.println("Série: " + treino.getSerie());
							System.out.println("Repetições: " + treino.getRepeticoes());
							System.out.println("Descanso: " + treino.getDescanso());
							System.out.println("Dia de Treino: " + treino.getDiaTreino());
							System.out.println();
							
							treino.setCarga(50F);
							treino.setSerie(new Byte("5"));
							treino.setRepeticoes(new Short("20"));
							treino.setDescanso(new Short("45"));
							treino.setDiaTreino(new Byte("2"));
							treinoDAO.editar(treino);
							
							System.out.println("Treino para ser Alterado: ");
							System.out.println("Código do Treino: " + treino.getCodigo());
							System.out.println("Nome do Usuário: " + treino.getUsuario().getNome());
							System.out.println("Nome do Aluno: " + treino.getAluno().getNome());
							System.out.println("Data da Avaliação Física: " + treino.getAf().getDtAvaFisica());
							System.out.println("Grupo Muscular: " + treino.getGm().getNomeGM());
							System.out.println("Exercício: " + treino.getExercicio().getNomeExerc());
							System.out.println("Aparelho: " + treino.getAparelho().getNomeApar());
							System.out.println("Carga: " + treino.getCarga());
							System.out.println("Série: " + treino.getSerie());
							System.out.println("Repetições: " + treino.getRepeticoes());
							System.out.println("Descanso: " + treino.getDescanso());
							System.out.println("Dia de Treino: " + treino.getDiaTreino());
							System.out.println();
						}
					}
				}
			}				
		}		
	}
}

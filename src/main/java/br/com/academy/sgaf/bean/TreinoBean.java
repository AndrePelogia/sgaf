package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.AlunoDAO;
import br.com.academy.sgaf.dao.AparelhoDAO;
import br.com.academy.sgaf.dao.AvaliacaoFisicaDAO;
import br.com.academy.sgaf.dao.ExercicioDAO;
import br.com.academy.sgaf.dao.GrupoMuscularDAO;
import br.com.academy.sgaf.dao.TreinoDAO;
import br.com.academy.sgaf.dao.UsuarioDAO;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.Aparelho;
import br.com.academy.sgaf.domain.AvaliacaoFisica;
import br.com.academy.sgaf.domain.Exercicio;
import br.com.academy.sgaf.domain.GrupoMuscular;
import br.com.academy.sgaf.domain.Treino;
import br.com.academy.sgaf.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class TreinoBean implements Serializable {
	private Treino treino; // model
	private List<Treino> treinos;
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<AvaliacaoFisica> avaliacoesFisicas;

	private List<Usuario> usuarios;
	private List<GrupoMuscular> gruposMusculares;
	private List<Exercicio> exercicios;
	private List<Aparelho> aparelhos;

	public Treino getTreino() {
		return treino;
	}
	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	public List<Treino> getTreinos() {
		return treinos;
	}
	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}
	public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
	}
	public List<GrupoMuscular> getGruposMusculares() {
		return gruposMusculares;
	}
	public void setGruposMusculares(List<GrupoMuscular> gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}
	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	public List<Aparelho> getAparelhos() {
		return aparelhos;
	}
	public void setAparelhos(List<Aparelho> aparelhos) {
		this.aparelhos = aparelhos;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			TreinoDAO treinoDAO = new TreinoDAO();
			treinos = treinoDAO.listar("aluno");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os treinos!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			treino = new Treino();
			
			aluno = new Aluno();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome");
			
			avaliacoesFisicas = new ArrayList<>();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar("nomeGM");
			
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar("nomeExerc");
			
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhos = aparelhoDAO.listar("nomeApar");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo treino!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() { //controller
		try {
			TreinoDAO treinoDAO = new TreinoDAO();
			treinoDAO.merge(treino);
			
			treinos = treinoDAO.listar("aluno");
			
			treino = new Treino();
			
			aluno = new Aluno();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome");
			
			avaliacoesFisicas = new ArrayList<>();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar("nomeGM");
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar("nomeExerc");
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhos = aparelhoDAO.listar("nomeApar");
					
			Messages.addGlobalInfo("Treino salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o treino!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try { //me
			treino = (Treino) evento.getComponent().getAttributes().get("treinoSelecionado");
			
			TreinoDAO treinoDAO = new TreinoDAO();
			treinoDAO.excluir(treino);
			
			treinos = treinoDAO.listar();
			
			Messages.addGlobalInfo("Treino removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o treino!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		try {
			treino = (Treino) evento.getComponent().getAttributes().get("treinoSelecionado");
			
			aluno = treino.getAf().getAluno();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome");
			
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacoesFisicas = avaliacaoFisicaDAO.buscarPorAluno(aluno.getCodigo());
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar("nomeGM");
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar("nomeExerc");
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhos = aparelhoDAO.listar("nomeApar");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma pessoa");
			erro.printStackTrace();
		}

	}
	
	public void popular() {
		try {
			if(treino != null && treino.getAluno() != null) {
				AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
				avaliacoesFisicas = avaliacaoFisicaDAO.buscarPorAluno(treino.getAluno().getCodigo());
			} else {
				avaliacoesFisicas = new ArrayList<>();
			}
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtrar as datas!!");
			erro.printStackTrace();
		}
	}
	
}

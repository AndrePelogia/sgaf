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
import br.com.academy.sgaf.dao.AvaliacaoFisicaDAO;
import br.com.academy.sgaf.dao.QuestionarioDAO;
import br.com.academy.sgaf.dao.UsuarioDAO;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.AvaliacaoFisica;
import br.com.academy.sgaf.domain.Questionario;
import br.com.academy.sgaf.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class QuestionarioBean implements Serializable {
	private Questionario questionario; // model
	private List<Questionario> questionarios;
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Aluno> alunos1;
	private List<Usuario> usuarios;
	private List<AvaliacaoFisica> avaliacoesFisicas;

	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public List<Questionario> getQuestionarios() {
		return questionarios;
	}
	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
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
	public List<Aluno> getAlunos1() {
		return alunos1;
	}
	public void setAlunos1(List<Aluno> alunos1) {
		this.alunos1 = alunos1;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}
	public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
	}	
	
	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarios = questionarioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os questionários!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			questionario = new Questionario();
			aluno = new Aluno();
			
			//alunos = new ArrayList<>();

			AlunoDAO alunoDAO = new AlunoDAO();
			alunos1 = alunoDAO.listar("nome");
			alunos = alunoDAO.listar();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar("nome");			
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacoesFisicas = avaliacaoFisicaDAO.listar("dtAvaFisica");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo questionário!!");
			erro.printStackTrace();
		}	
	}
	
	public void salvar() { //controller
		try {
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarioDAO.merge(questionario);
		
			questionarios = questionarioDAO.listar();
			
			questionario = new Questionario();
			aluno = new Aluno();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos1 = alunoDAO.listar();
			alunos = new ArrayList<>();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacoesFisicas = avaliacaoFisicaDAO.listar();
			
			Messages.addGlobalInfo("Questionário salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o questionário!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			questionario = (Questionario) evento.getComponent().getAttributes().get("questionarioSelecionado");
			
			QuestionarioDAO questionarioDAO = new QuestionarioDAO();
			questionarioDAO.excluir(questionario);
			
			questionarios = questionarioDAO.listar();
			
			Messages.addGlobalInfo("Questionário removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o questionário!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		try {
			questionario = (Questionario) evento.getComponent().getAttributes().get("questionarioSelecionado");
			
			aluno = questionario.getResp();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos1 = alunoDAO.listar("nome");
			alunos = alunoDAO.buscarPorAluno(aluno.getCodigo());
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
						
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacoesFisicas = avaliacaoFisicaDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Questionário!!");
			erro.printStackTrace();
		}
	}
	
	public void popular() {
		try {
			if(questionario != null && questionario.getAluno().getNomeResp() != null) {
				AlunoDAO alunoDAO = new AlunoDAO();
				alunos = alunoDAO.buscarPorAluno(questionario.getAluno().getCodigo());
			} else {
				alunos = new ArrayList<>();
			}
			
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar filtrar os responsáveis!!");
			erro.printStackTrace();
		}
	}
	
}

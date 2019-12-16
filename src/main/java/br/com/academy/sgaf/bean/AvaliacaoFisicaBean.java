package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.AlunoDAO;
import br.com.academy.sgaf.dao.AvaliacaoFisicaDAO;
import br.com.academy.sgaf.dao.UsuarioDAO;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.AvaliacaoFisica;
import br.com.academy.sgaf.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class AvaliacaoFisicaBean implements Serializable {
	private AvaliacaoFisica avaliacaoFisica; // model
	private List<AvaliacaoFisica> avaliacoesFisicas;
	private List<Usuario> usuarios;
	private List<Aluno> alunos;

	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}
	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}
	public List<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}
	public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacoesFisicas = avaliacaoFisicaDAO.listar("aluno");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as avaliações físicas!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			avaliacaoFisica = new AvaliacaoFisica();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova avaliação física!!");
			erro.printStackTrace();
		}		
	}
	
	public void salvar() { //controller
		try {
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacaoFisicaDAO.merge(avaliacaoFisica);
		
			avaliacaoFisica = new AvaliacaoFisica();
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();
			
			avaliacoesFisicas = avaliacaoFisicaDAO.listar();
		
			Messages.addGlobalInfo("Avaliação física salva com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a avaliação física!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			avaliacaoFisica = (AvaliacaoFisica) evento.getComponent().getAttributes().get("avaliacaoFisicaSelecionada");
			
			AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
			avaliacaoFisicaDAO.excluir(avaliacaoFisica);
			
			avaliacoesFisicas = avaliacaoFisicaDAO.listar();
			
			Messages.addGlobalInfo("Avaliação física removida com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a avaliação física!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		try {
			avaliacaoFisica = (AvaliacaoFisica) evento.getComponent().getAttributes().get("avaliacaoFisicaSelecionada");
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listarProfessor("nome");
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma avaliação física!!");
			erro.printStackTrace();
		}
		
	}
	
}

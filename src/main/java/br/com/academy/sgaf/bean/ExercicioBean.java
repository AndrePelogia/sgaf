package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.ExercicioDAO;
import br.com.academy.sgaf.dao.GrupoMuscularDAO;
import br.com.academy.sgaf.domain.Exercicio;
import br.com.academy.sgaf.domain.GrupoMuscular;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class ExercicioBean implements Serializable {
	private Exercicio exercicio; // model
	private List<Exercicio> exercicios;
	private List<GrupoMuscular> gruposMusculares;

	public Exercicio getExercicio() {
		return exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	public List<GrupoMuscular> getGruposMusculares() {
		return gruposMusculares;
	}
	public void setGruposMusculares(List<GrupoMuscular> gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicios = exercicioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os exercícios!!"); //flashglobalerror
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			exercicio = new Exercicio();
			
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar("nomeGM");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo exercício!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() { //controller
		try {	
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicioDAO.merge(exercicio);
		
			exercicio = new Exercicio();
			
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar();
			
			exercicios = exercicioDAO.listar();
		
			Messages.addGlobalInfo("Exercício salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o exercício!!");
			erro.printStackTrace();
		}		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			exercicio = (Exercicio) evento.getComponent().getAttributes().get("exercicioSelecionado");
			
			ExercicioDAO exercicioDAO = new ExercicioDAO();
			exercicioDAO.excluir(exercicio);
			
			exercicios = exercicioDAO.listar();
			
			Messages.addGlobalInfo("Exercício removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o exercício!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		try {
			exercicio = (Exercicio) evento.getComponent().getAttributes().get("exercicioSelecionado");
			
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar um exercício!!");
			erro.printStackTrace();
		}
		
	}
	
}

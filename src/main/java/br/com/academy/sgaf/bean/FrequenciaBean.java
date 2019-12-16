package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.AlunoDAO;
import br.com.academy.sgaf.dao.FrequenciaDAO;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.Frequencia;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class FrequenciaBean implements Serializable {
	private Frequencia frequencia; //model
	private List<Frequencia> frequencias;
	private List<Aluno> alunos;
	
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}
	public List<Frequencia> getFrequencias() {
		return frequencias;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
			frequencias = frequenciaDAO.listar("aluno");
			//frequencias = frequenciaDAO.listar("aluno.nome"); //listar alterado
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as frequências!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			frequencia = new Frequencia();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome");
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova frequência!!");
			erro.printStackTrace();
		}
	}
	
	public void salvar() { //controller
		try {
			FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
			frequenciaDAO.merge(frequencia);
			
			frequencia = new Frequencia();
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("nome"); //alteração do listar
			
			frequencias = frequenciaDAO.listar();
		
			Messages.addGlobalInfo("Frequência salva com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a frequência!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			frequencia = (Frequencia) evento.getComponent().getAttributes().get("frequenciaSelecionada");

			FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
			frequenciaDAO.excluir(frequencia);

			frequencias = frequenciaDAO.listar();
			
			Messages.addGlobalInfo("Frequência removida com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a frequência!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		try {
			frequencia = (Frequencia) evento.getComponent().getAttributes().get("frequenciaSelecionada");
			
			FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
			frequencias = frequenciaDAO.listar();
		} catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma frequência!!");
			erro.printStackTrace();
		}
		
	}
	
}

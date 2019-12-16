package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.GrupoMuscularDAO;
import br.com.academy.sgaf.domain.GrupoMuscular;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class GrupoMuscularBean implements Serializable {
	private GrupoMuscular grupoMuscular; // model
	private List<GrupoMuscular> gruposMusculares;

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}
	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
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
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			gruposMusculares = grupoMuscularDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os grupos musculares!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		grupoMuscular = new GrupoMuscular();
	}
	
	public void salvar() { //controller
		try {
			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			grupoMuscularDAO.merge(grupoMuscular);
		
			novo();
			gruposMusculares = grupoMuscularDAO.listar();
		
			Messages.addGlobalInfo("Grupo muscular salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o grupo muscular!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			grupoMuscular = (GrupoMuscular) evento.getComponent().getAttributes().get("grupoMuscularSelecionado");

			GrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
			grupoMuscularDAO.excluir(grupoMuscular);

			gruposMusculares = grupoMuscularDAO.listar();
			
			Messages.addGlobalInfo("Grupo muscular removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o grupo muscular!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		grupoMuscular = (GrupoMuscular) evento.getComponent().getAttributes().get("grupoMuscularSelecionado");
	}
	
}


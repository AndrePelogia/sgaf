package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.EmpresaDAO;
import br.com.academy.sgaf.domain.Empresa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class EmpresaBean implements Serializable {
	private Empresa empresa; // model
	private List<Empresa> empresas;

	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresas = empresaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as empresas!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		empresa = new Empresa();
	}
	
	public void salvar() { //controller
		try {	
			//String texto = "Programação Web com Java";
			//FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
			//FacesContext contexto = FacesContext.getCurrentInstance();
			//contexto.addMessage(null, mensagem);	
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresaDAO.merge(empresa);
		
			novo();
			empresas = empresaDAO.listar();
		
			Messages.addGlobalInfo("Empresa salva com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a empresa!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("empresaSelecionada");
			
			EmpresaDAO empresaDAO = new EmpresaDAO();
			empresaDAO.excluir(empresa);
			
			empresas = empresaDAO.listar();
			
			Messages.addGlobalInfo("Empresa removida com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a empresa!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		empresa = (Empresa) evento.getComponent().getAttributes().get("empresaSelecionada");
	}
	
}

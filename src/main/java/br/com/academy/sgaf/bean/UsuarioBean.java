package br.com.academy.sgaf.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.academy.sgaf.dao.UsuarioDAO;
import br.com.academy.sgaf.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class UsuarioBean implements Serializable {
	private Usuario usuario; // model
	private List<Usuario> usuarios;

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		usuario = new Usuario();
	}
	
	public void salvar() { //controller
		try {	
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
		
			novo();
			usuarios = usuarioDAO.listar();
		
			Messages.addGlobalInfo("Usuário salvo com sucesso!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			usuarios = usuarioDAO.listar();
			
			Messages.addGlobalInfo("Usuário removido com sucesso!!");
		} catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o usuário!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
	}
	
}

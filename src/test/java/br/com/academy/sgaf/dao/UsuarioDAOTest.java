package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	public void salvar() throws ParseException{
		Usuario usuario = new Usuario();
		
		usuario.setNome("Jonelson Pinto");
		usuario.setEndereco("Rua Brasil, 69");
		usuario.setComplemento(null);
		usuario.setBairro("Jardim Pitangas");
		usuario.setCep("25.486-000");
		usuario.setCidade("Sei lá");
		usuario.setEstado("GO");
		usuario.setEmail("jojopi69@hotmail.com");
		usuario.setTelefone("(88)4531-5798");
		usuario.setCelular("(88)99155-4387");
		usuario.setSexo('M');
		usuario.setCpf("543.544.687-23");
		usuario.setRg("35.533.458-X");
		usuario.setUfrg("SSP/GO");
		usuario.setDtNasc(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1991"));
		usuario.setEstCivil("Solteiro");
		usuario.setStatus("Ativo");

		usuario.setTipo("Administrador");
		usuario.setCref(null);
		usuario.setValidadeCref(new SimpleDateFormat("dd/MM/yyyy").parse("23/05/2016"));
		usuario.setLogin("J987");
		usuario.setSenha("45628");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		System.out.println("Usuário Salvo com Sucesso!!");
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Usuario usuario : resultado){
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Complemento: " + usuario.getComplemento());
			System.out.println("Bairro: " + usuario.getBairro());
			System.out.println("CEP: " + usuario.getCep());
			System.out.println("Cidade: " + usuario.getCidade());
			System.out.println("Estado" + usuario.getEstado());
			System.out.println("E-mail: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Celular: " + usuario.getCelular());
			System.out.println("Sexo: " + usuario.getSexo());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("UFRG: " + usuario.getUfrg());
			System.out.println("Data de Nascimento: " + usuario.getDtNasc());
			System.out.println("Estado Civil: " + usuario.getEstCivil());
			System.out.println("Status: " + usuario.getStatus());
			System.out.println("Tipo do Usuário: " + usuario.getTipo());
			System.out.println("CREF: " + usuario.getCref());
			System.out.println("Validade do CREF: " + usuario.getValidadeCref());
			System.out.println("Login do Usuário: " + usuario.getLogin());
			System.out.println("Senha do Usuário: " + usuario.getSenha());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L; // L de Long
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		if(usuario == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Complemento: " + usuario.getComplemento());
			System.out.println("Bairro: " + usuario.getBairro());
			System.out.println("CEP: " + usuario.getCep());
			System.out.println("Cidade: " + usuario.getCidade());
			System.out.println("Estado" + usuario.getEstado());
			System.out.println("E-mail: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Celular: " + usuario.getCelular());
			System.out.println("Sexo: " + usuario.getSexo());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("UFRG: " + usuario.getUfrg());
			System.out.println("Data de Nascimento: " + usuario.getDtNasc());
			System.out.println("Estado Civil: " + usuario.getEstCivil());
			System.out.println("Status: " + usuario.getStatus());
			System.out.println("Tipo do Usuário: " + usuario.getTipo());
			System.out.println("CREF: " + usuario.getCref());
			System.out.println("Validade do CREF: " + usuario.getValidadeCref());
			System.out.println("Login do Usuário: " + usuario.getLogin());
			System.out.println("Senha do Usuário: " + usuario.getSenha());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L; // L de Long
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		if(usuario == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			usuarioDAO.excluir(usuario);
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Complemento: " + usuario.getComplemento());
			System.out.println("Bairro: " + usuario.getBairro());
			System.out.println("CEP: " + usuario.getCep());
			System.out.println("Cidade: " + usuario.getCidade());
			System.out.println("Estado" + usuario.getEstado());
			System.out.println("E-mail: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Celular: " + usuario.getCelular());
			System.out.println("Sexo: " + usuario.getSexo());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("UFRG: " + usuario.getUfrg());
			System.out.println("Data de Nascimento: " + usuario.getDtNasc());
			System.out.println("Estado Civil: " + usuario.getEstCivil());
			System.out.println("Status: " + usuario.getStatus());
			System.out.println("Tipo do Usuário: " + usuario.getTipo());
			System.out.println("CREF: " + usuario.getCref());
			System.out.println("Validade do CREF: " + usuario.getValidadeCref());
			System.out.println("Login do Usuário: " + usuario.getLogin());
			System.out.println("Senha do Usuário: " + usuario.getSenha());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigo = 1L; // L de Long
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		if(usuario == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Complemento: " + usuario.getComplemento());
			System.out.println("Bairro: " + usuario.getBairro());
			System.out.println("CEP: " + usuario.getCep());
			System.out.println("Cidade: " + usuario.getCidade());
			System.out.println("Estado" + usuario.getEstado());
			System.out.println("E-mail: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Celular: " + usuario.getCelular());
			System.out.println("Sexo: " + usuario.getSexo());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("UFRG: " + usuario.getUfrg());
			System.out.println("Data de Nascimento: " + usuario.getDtNasc());
			System.out.println("Estado Civil: " + usuario.getEstCivil());
			System.out.println("Status: " + usuario.getStatus());
			System.out.println("Tipo do Usuário: " + usuario.getTipo());
			System.out.println("CREF: " + usuario.getCref());
			System.out.println("Validade do CREF: " + usuario.getValidadeCref());
			System.out.println("Login do Usuário: " + usuario.getLogin());
			System.out.println("Senha do Usuário: " + usuario.getSenha());
			System.out.println();
				
			usuario.setValidadeCref(new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2016"));
			usuarioDAO.editar(usuario);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Endereço: " + usuario.getEndereco());
			System.out.println("Complemento: " + usuario.getComplemento());
			System.out.println("Bairro: " + usuario.getBairro());
			System.out.println("CEP: " + usuario.getCep());
			System.out.println("Cidade: " + usuario.getCidade());
			System.out.println("Estado" + usuario.getEstado());
			System.out.println("E-mail: " + usuario.getEmail());
			System.out.println("Telefone: " + usuario.getTelefone());
			System.out.println("Celular: " + usuario.getCelular());
			System.out.println("Sexo: " + usuario.getSexo());
			System.out.println("CPF: " + usuario.getCpf());
			System.out.println("RG: " + usuario.getRg());
			System.out.println("UFRG: " + usuario.getUfrg());
			System.out.println("Data de Nascimento: " + usuario.getDtNasc());
			System.out.println("Estado Civil: " + usuario.getEstCivil());
			System.out.println("Status: " + usuario.getStatus());
			System.out.println("Tipo do Usuário: " + usuario.getTipo());
			System.out.println("CREF: " + usuario.getCref());
			System.out.println("Validade do CREF: " + usuario.getValidadeCref());
			System.out.println("Login do Usuário: " + usuario.getLogin());
			System.out.println("Senha do Usuário: " + usuario.getSenha());
			System.out.println();
		}
	
	}
	
}

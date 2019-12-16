package br.com.academy.sgaf.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Empresa;

public class EmpresaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Empresa empresa = new Empresa();
		empresa.setRzSocial("São Felix");
		empresa.setNomeFantasia("KeepFitness");
		empresa.setCnpj("56.531.352/0004-25");
		empresa.setInscrEstadual("352.536.891.401");
		empresa.setEndereco("Rua Delmiro Silva, 23");
		empresa.setBairro("Jardim das Rosas");
		empresa.setCep("19.900-000");
		empresa.setCidade("São Paulo");
		empresa.setEstado("SP");
		empresa.setEmail("keepfitness@bol.com.br");
		empresa.setTelefone("(11)4332-2144");
		empresa.setCelular("(11)99723-4428");
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.salvar(empresa);
		System.out.println("Empresa Salva com Sucesso!!");
	}
	
	@Test
	@Ignore
	public void listar(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		List<Empresa> resultado = empresaDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(Empresa empresa : resultado){
			System.out.println("Código: " +	empresa.getCodigo());
			System.out.println("Razão Social: " +	empresa.getRzSocial());
			System.out.println("Nome Fantasia: " +	empresa.getNomeFantasia());
			System.out.println("CNPJ: " +	empresa.getCnpj());
			System.out.println("Incrição Estadual: " +	empresa.getInscrEstadual());
			System.out.println("Endereço: " +	empresa.getEndereco());
			System.out.println("Bairro: " +	empresa.getBairro());
			System.out.println("CEP: " +	empresa.getCep());
			System.out.println("Cidade: " +	empresa.getCidade());
			System.out.println("Estado: " +	empresa.getEstado());
			System.out.println("Email: " +	empresa.getEmail());
			System.out.println("Telefone: " +	empresa.getTelefone());
			System.out.println("Celular: " +	empresa.getCelular());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L; // L de Long
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar(codigo);
		
		if(empresa == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código: " +	empresa.getCodigo());
			System.out.println("Razão Social: " +	empresa.getRzSocial());
			System.out.println("Nome Fantasia: " +	empresa.getNomeFantasia());
			System.out.println("CNPJ: " +	empresa.getCnpj());
			System.out.println("Incrição Estadual: " +	empresa.getInscrEstadual());
			System.out.println("Endereço: " +	empresa.getEndereco());
			System.out.println("Bairro: " +	empresa.getBairro());
			System.out.println("CEP: " +	empresa.getCep());
			System.out.println("Cidade: " +	empresa.getCidade());
			System.out.println("Estado: " +	empresa.getEstado());
			System.out.println("Email: " +	empresa.getEmail());
			System.out.println("Telefone: " +	empresa.getTelefone());
			System.out.println("Celular: " +	empresa.getCelular());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L; // L de Long
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar(codigo);
		
		if(empresa == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			empresaDAO.excluir(empresa);
			System.out.println("Registro removido: ");
			System.out.println("Código: " +	empresa.getCodigo());
			System.out.println("Razão Social: " +	empresa.getRzSocial());
			System.out.println("Nome Fantasia: " +	empresa.getNomeFantasia());
			System.out.println("CNPJ: " +	empresa.getCnpj());
			System.out.println("Incrição Estadual: " +	empresa.getInscrEstadual());
			System.out.println("Endereço: " +	empresa.getEndereco());
			System.out.println("Bairro: " +	empresa.getBairro());
			System.out.println("CEP: " +	empresa.getCep());
			System.out.println("Cidade: " +	empresa.getCidade());
			System.out.println("Estado: " +	empresa.getEstado());
			System.out.println("Email: " +	empresa.getEmail());
			System.out.println("Telefone: " +	empresa.getTelefone());
			System.out.println("Celular: " +	empresa.getCelular());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L; // L de Long
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar(codigo);
		
		if(empresa == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println("Código: " +	empresa.getCodigo());
			System.out.println("Razão Social: " +	empresa.getRzSocial());
			System.out.println("Nome Fantasia: " +	empresa.getNomeFantasia());
			System.out.println("CNPJ: " +	empresa.getCnpj());
			System.out.println("Incrição Estadual: " +	empresa.getInscrEstadual());
			System.out.println("Endereço: " +	empresa.getEndereco());
			System.out.println("Bairro: " +	empresa.getBairro());
			System.out.println("CEP: " +	empresa.getCep());
			System.out.println("Cidade: " +	empresa.getCidade());
			System.out.println("Estado: " +	empresa.getEstado());
			System.out.println("Email: " +	empresa.getEmail());
			System.out.println("Telefone: " +	empresa.getTelefone());
			System.out.println("Celular: " +	empresa.getCelular());
			System.out.println();
			
			empresa.setRzSocial("Projeto SGAF, 5 ADS Noturno 2-2015");
			empresaDAO.editar(empresa);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println("Código: " +	empresa.getCodigo());
			System.out.println("Razão Social: " +	empresa.getRzSocial());
			System.out.println("Nome Fantasia: " +	empresa.getNomeFantasia());
			System.out.println("CNPJ: " +	empresa.getCnpj());
			System.out.println("Incrição Estadual: " +	empresa.getInscrEstadual());
			System.out.println("Endereço: " +	empresa.getEndereco());
			System.out.println("Bairro: " +	empresa.getBairro());
			System.out.println("CEP: " +	empresa.getCep());
			System.out.println("Cidade: " +	empresa.getCidade());
			System.out.println("Estado: " +	empresa.getEstado());
			System.out.println("Email: " +	empresa.getEmail());
			System.out.println("Telefone: " +	empresa.getTelefone());
			System.out.println("Celular: " +	empresa.getCelular());
			System.out.println();
		}
	
	}
	
	@Test
	public void merge(){
		/*Empresa empresa = new Empresa();
		empresa.setRzSocial("Judas Afonso Tadeu");
		empresa.setNomeFantasia("São Judas Tadeu");
		empresa.setCnpj("28.631.532/0002-01");
		empresa.setInscrEstadual("353.546.153.012");
		empresa.setEndereco("Av. Nações Unidas, 328");
		empresa.setBairro("Jardim 3 Corações");
		empresa.setCep("15.230-970");
		empresa.setCidade("Indaiatuba");
		empresa.setEstado("SP");
		empresa.setEmail("sac.indaiatuba@sjudastadeu.com.br");
		empresa.setTelefone("(16)3223-4454");
		empresa.setCelular("(16)99745-9548");
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.merge(empresa);
		System.out.println("Empresa Salva com Sucesso!!");
		*/
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscar(2L);
		empresa.setBairro("Jardim Três Corações");
		empresaDAO.merge(empresa);
	}
	
}

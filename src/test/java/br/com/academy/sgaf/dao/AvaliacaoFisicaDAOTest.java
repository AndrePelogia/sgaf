package br.com.academy.sgaf.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.academy.sgaf.domain.Usuario;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.domain.AvaliacaoFisica;

public class AvaliacaoFisicaDAOTest {
	
	@Test
	public void salvar() throws ParseException{
		Long codigoAluno = 2L;
		Long codigoUsuario = 2L;
		AlunoDAO alunoDAO = new AlunoDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		AvaliacaoFisica af = new AvaliacaoFisica();
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		
		Aluno aluno = alunoDAO.buscar(codigoAluno);
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		if(usuario == null){
			System.out.println("Nenhum usuário encontrado");
		}else{
			if(usuario.getCref().equals(null)){
				System.out.println("Usuário não possui CREF");
			}else{
				af.setUsuario(usuario);
				af.setAluno(aluno);
				af.setObjetivo("Hipertrofia");
				af.setDtAvaFisica(new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2001"));
				af.setPeso(125.5F);
				af.setAltura(1.80F);
				af.setPescoco(12.2F);
				af.setOmbros(33.9F);
				af.setToraxNormal(166F);
				af.setToraxInspira(142.8F);
				af.setToraxExpira(178.5F);
				af.setBracoEsq(198.5F);
				af.setBracoDir(197.5F);
				af.setAbdmn(115F);
				af.setQuadril(157.3F);
				af.setCoxaEsq(98F);
				af.setCoxaDir(98F);
				af.setPantuEsq(47F);
				af.setPantuDir(47F);
				af.setAntebracoEsq(38.9F);
				af.setAntebracoDir(38.6F);
				af.setCintura(135.3F);
				
				afDAO.salvar(af);
				System.out.println("Avaliação Física Salva com Sucesso");
			}
		}
	}
	
	@Test
	@Ignore
	public void listar(){
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		List<AvaliacaoFisica> resultado = afDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(AvaliacaoFisica af : resultado){
			System.out.println("Código da Avaliação: " + af.getCodigo());
			System.out.println("CREF do Professor: " + af.getUsuario().getCref());
			System.out.println("Nome do Aluno: " + af.getAluno().getNome());
			System.out.println("Objetivo: " + af.getObjetivo());
			System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
			System.out.println("Peso: " + af.getPeso());
			System.out.println("Altura: " + af.getAltura());
			System.out.println("Medidas em Centímetros: ");
			System.out.println("Pescoço: " + af.getPescoco());
			System.out.println("Ombros: " + af.getOmbros());
			System.out.println("Tórax Normal: " + af.getToraxNormal());
			System.out.println("Tórax Inspirado: " + af.getToraxInspira());
			System.out.println("Tórax Expirado: " + af.getToraxExpira());
			System.out.println("Braço Esquerdo: " + af.getBracoEsq());
			System.out.println("Braço Direito: " + af.getBracoDir());
			System.out.println("Abdômen: " + af.getAbdmn());
			System.out.println("Quadril: " + af.getQuadril());
			System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
			System.out.println("Coxa Direita: " + af.getCoxaDir());
			System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
			System.out.println("Panturrilha Direita: " + af.getPantuDir());
			System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
			System.out.println("Antibraço Direito: " + af.getAntebracoDir());
			System.out.println("Cintura: " + af.getCintura());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoAvaliacaoFisica = 1L; // L de Long
		
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		AvaliacaoFisica af = afDAO.buscar(codigoAvaliacaoFisica);
		
		if(af == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Registro encontrado: ");
			System.out.println("Código da Avaliação: " + af.getCodigo());
			System.out.println("CREF do Professor: " + af.getUsuario().getCref());
			System.out.println("Nome do Aluno: " + af.getAluno().getNome());
			System.out.println("Objetivo: " + af.getObjetivo());
			System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
			System.out.println("Peso: " + af.getPeso());
			System.out.println("Altura: " + af.getAltura());
			System.out.println("Medidas em Centímetros: ");
			System.out.println("Pescoço: " + af.getPescoco());
			System.out.println("Ombros: " + af.getOmbros());
			System.out.println("Tórax Normal: " + af.getToraxNormal());
			System.out.println("Tórax Inspirado: " + af.getToraxInspira());
			System.out.println("Tórax Expirado: " + af.getToraxExpira());
			System.out.println("Braço Esquerdo: " + af.getBracoEsq());
			System.out.println("Braço Direito: " + af.getBracoDir());
			System.out.println("Abdômen: " + af.getAbdmn());
			System.out.println("Quadril: " + af.getQuadril());
			System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
			System.out.println("Coxa Direita: " + af.getCoxaDir());
			System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
			System.out.println("Panturrilha Direita: " + af.getPantuDir());
			System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
			System.out.println("Antibraço Direito: " + af.getAntebracoDir());
			System.out.println("Cintura: " + af.getCintura());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigoAvaliacaoFisica = 1L; // L de Long
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		AvaliacaoFisica af = afDAO.buscar(codigoAvaliacaoFisica);
		
		if(af == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			afDAO.excluir(af);
			System.out.println("Registro removido: ");
			System.out.println("Código da Avaliação: " + af.getCodigo());
			System.out.println("CREF do Professor: " + af.getUsuario().getCref());
			System.out.println("Nome do Aluno: " + af.getAluno().getNome());
			System.out.println("Objetivo: " + af.getObjetivo());
			System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
			System.out.println("Peso: " + af.getPeso());
			System.out.println("Altura: " + af.getAltura());
			System.out.println("Medidas em Centímetros: ");
			System.out.println("Pescoço: " + af.getPescoco());
			System.out.println("Ombros: " + af.getOmbros());
			System.out.println("Tórax Normal: " + af.getToraxNormal());
			System.out.println("Tórax Inspirado: " + af.getToraxInspira());
			System.out.println("Tórax Expirado: " + af.getToraxExpira());
			System.out.println("Braço Esquerdo: " + af.getBracoEsq());
			System.out.println("Braço Direito: " + af.getBracoDir());
			System.out.println("Abdômen: " + af.getAbdmn());
			System.out.println("Quadril: " + af.getQuadril());
			System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
			System.out.println("Coxa Direita: " + af.getCoxaDir());
			System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
			System.out.println("Panturrilha Direita: " + af.getPantuDir());
			System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
			System.out.println("Antibraço Direito: " + af.getAntebracoDir());
			System.out.println("Cintura: " + af.getCintura());
			System.out.println();
		}
		
	}
	
	@Test
	@Ignore
	public void editar() throws ParseException{
		Long codigoAvaliacaoFisica = 1L; // L de Long
		Long codigoAluno = 1L;
		Long codigoUsuario = 1L;
		
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		AvaliacaoFisica af = afDAO.buscar(codigoAvaliacaoFisica);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar(codigoAluno);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		if(usuario.getCref().equals(null)){
			System.out.println("Usuário não tem permissão para fazer alterações!!");
		}else{
			if(aluno == null){
				System.out.println("Aluno não encontrado!");
			}else{
				if(af == null){
					System.out.println("Aluno Encontrado: ");
					System.out.println("Código: " + aluno.getCodigo());
					System.out.println("Nome do Aluno: " + aluno.getNome());
					
					System.out.println("Avaliação Física não encontrada!");
				}else{
					System.out.println("Aluno Encontrado: ");
					System.out.println("Código: " + aluno.getCodigo());
					System.out.println("Nome do Aluno: " + aluno.getNome());
					
					System.out.println("Avaliação Física para ser Alterada: ");
					System.out.println("Código da Avaliação: " + af.getCodigo());
					System.out.println("CREF do Professor: " + af.getUsuario().getCref());
					System.out.println("Nome do Aluno: " + af.getAluno().getNome());
					System.out.println("Objetivo: " + af.getObjetivo());
					System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
					System.out.println("Peso: " + af.getPeso());
					System.out.println("Altura: " + af.getAltura());
					System.out.println("Medidas em Centímetros: ");
					System.out.println("Pescoço: " + af.getPescoco());
					System.out.println("Ombros: " + af.getOmbros());
					System.out.println("Tórax Normal: " + af.getToraxNormal());
					System.out.println("Tórax Inspirado: " + af.getToraxInspira());
					System.out.println("Tórax Expirado: " + af.getToraxExpira());
					System.out.println("Braço Esquerdo: " + af.getBracoEsq());
					System.out.println("Braço Direito: " + af.getBracoDir());
					System.out.println("Abdômen: " + af.getAbdmn());
					System.out.println("Quadril: " + af.getQuadril());
					System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
					System.out.println("Coxa Direita: " + af.getCoxaDir());
					System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
					System.out.println("Panturrilha Direita: " + af.getPantuDir());
					System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
					System.out.println("Antibraço Direito: " + af.getAntebracoDir());
					System.out.println("Cintura: " + af.getCintura());
					System.out.println();
					
					af.setDtAvaFisica(new SimpleDateFormat("dd/MM/yyyy").parse("09/09/2015"));
					af.setUsuario(usuario);
					
					System.out.println("Avaliação Física Alterada: ");
					System.out.println("Código da Avaliação: " + af.getCodigo());
					System.out.println("CREF do Professor: " + af.getUsuario().getCref());
					System.out.println("Nome do Aluno: " + af.getAluno().getNome());
					System.out.println("Objetivo: " + af.getObjetivo());
					System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
					System.out.println("Peso: " + af.getPeso());
					System.out.println("Altura: " + af.getAltura());
					System.out.println("Medidas em Centímetros: ");
					System.out.println("Pescoço: " + af.getPescoco());
					System.out.println("Ombros: " + af.getOmbros());
					System.out.println("Tórax Normal: " + af.getToraxNormal());
					System.out.println("Tórax Inspirado: " + af.getToraxInspira());
					System.out.println("Tórax Expirado: " + af.getToraxExpira());
					System.out.println("Braço Esquerdo: " + af.getBracoEsq());
					System.out.println("Braço Direito: " + af.getBracoDir());
					System.out.println("Abdômen: " + af.getAbdmn());
					System.out.println("Quadril: " + af.getQuadril());
					System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
					System.out.println("Coxa Direita: " + af.getCoxaDir());
					System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
					System.out.println("Panturrilha Direita: " + af.getPantuDir());
					System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
					System.out.println("Antibraço Direito: " + af.getAntebracoDir());
					System.out.println("Cintura: " + af.getCintura());
					System.out.println();
				}
			}
		}	
	}	
	
	@Test
	@Ignore
	public void buscarPorAluno(){
		Long alunoCodigo = 1L;
		
		AvaliacaoFisicaDAO afDAO = new AvaliacaoFisicaDAO();
		List<AvaliacaoFisica> resultado = afDAO.buscarPorAluno(alunoCodigo);
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for(AvaliacaoFisica af : resultado){
			System.out.println("Código da Avaliação: " + af.getCodigo());
			System.out.println("CREF do Professor: " + af.getUsuario().getCref());
			System.out.println("Nome do Aluno: " + af.getAluno().getNome());
			System.out.println("Objetivo: " + af.getObjetivo());
			System.out.println("Data da Avaliação: " + af.getDtAvaFisica());
			System.out.println("Peso: " + af.getPeso());
			System.out.println("Altura: " + af.getAltura());
			System.out.println("Medidas em Centímetros: ");
			System.out.println("Pescoço: " + af.getPescoco());
			System.out.println("Ombros: " + af.getOmbros());
			System.out.println("Tórax Normal: " + af.getToraxNormal());
			System.out.println("Tórax Inspirado: " + af.getToraxInspira());
			System.out.println("Tórax Expirado: " + af.getToraxExpira());
			System.out.println("Braço Esquerdo: " + af.getBracoEsq());
			System.out.println("Braço Direito: " + af.getBracoDir());
			System.out.println("Abdômen: " + af.getAbdmn());
			System.out.println("Quadril: " + af.getQuadril());
			System.out.println("Coxa Esquerda: " + af.getCoxaEsq());
			System.out.println("Coxa Direita: " + af.getCoxaDir());
			System.out.println("Panturrilha Esquerda: " + af.getPantuEsq());
			System.out.println("Panturrilha Direita: " + af.getPantuDir());
			System.out.println("Antibraço Esquerdo: " + af.getAntebracoEsq());
			System.out.println("Antibraço Direito: " + af.getAntebracoDir());
			System.out.println("Cintura: " + af.getCintura());
			System.out.println();
		}
	}
}

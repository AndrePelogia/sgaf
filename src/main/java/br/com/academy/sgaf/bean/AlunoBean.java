package br.com.academy.sgaf.bean;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.academy.sgaf.dao.AlunoDAO;
import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import br.com.academy.sgaf.bean.RelogioBean;

@SuppressWarnings({ "serial", "unused" })
@ManagedBean
@ViewScoped // tempos de vida Request, View e Section
public class AlunoBean implements Serializable {
	private Aluno aluno; // model
	private List<Aluno> alunos;
	private String caminho;
	public Integer idade;
	
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
		
	@PostConstruct //Como efeito de construtor, é chamado logo quando o ManagedBean é criado
	public void listar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os alunos!!");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		aluno = new Aluno();
	}
	
	public void salvar() { //controller
		try {
			if(aluno.getUrlImg() == null) {
				Messages.addGlobalError("O campo Foto é obrigatório!!");
				return;
			}
			
			AlunoDAO alunoDAO = new AlunoDAO();
			Aluno alunoRetorno = alunoDAO.merge(aluno);
			
			Path origem = Paths.get(aluno.getUrlImg());
			//mudar sempre o caminho quando for trocar de computador
			// Caminho no pc do Clóvis: "D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/"
			// Caminho no pc do João: 
			// Caminho no pc do Fernando:
			Path destino = Paths.get("D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/" + alunoRetorno.getCodigo() + ".png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
		
			novo();
			alunos = alunoDAO.listar();
		
			Messages.addGlobalInfo("Aluno salvo com sucesso!!");
		} catch (RuntimeException | IOException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o aluno!!");
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			aluno = (Aluno) evento.getComponent().getAttributes().get("alunoSelecionado");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.excluir(aluno);
			
			//mudar sempre o caminho quando for trocar de computador
			// Caminho no pc do Clóvis: "D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/"
			// Caminho no pc do João: 
			// Caminho no pc do Fernando: 
			Path arquivo = Paths.get("D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/" + aluno.getCodigo() + ".png");
			Files.deleteIfExists(arquivo);

			alunos = alunoDAO.listar();
			
			Messages.addGlobalInfo("Aluno removido com sucesso!!");
		} catch(RuntimeException | IOException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o aluno!!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		aluno = (Aluno) evento.getComponent().getAttributes().get("alunoSelecionado");
		//mudar sempre o caminho quando for mudar de computador
		// Caminho no pc do Clóvis: "D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/"
		// Caminho no pc do João: 
		// Caminho no pc do Fernando:
		aluno.setUrlImg("D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/" + aluno.getCodigo() + ".png");
	}
	
	public void visualizar(ActionEvent evento) {
		aluno = (Aluno) evento.getComponent().getAttributes().get("alunoSelecionado");
		//mudar sempre o caminho quando for mudar de computador
		// Caminho no pc do Clóvis: "D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/"
		// Caminho no pc do João: 
		// Caminho no pc do Fernando:
		aluno.setUrlImg("D:/eclipse-jee-mars-2-win32-x86_64/uploads/alunos/" + aluno.getCodigo() + ".png");
	}
	
	public Integer calcularIdade(Date data) {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		Calendar dataAtual = Calendar.getInstance();
		System.out.println("Data de nascimento: " + data);
		
		Integer diferencaMes = dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
		Integer diferencaDia = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);
		idade = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));
		
		if(diferencaMes < 0 || (diferencaMes == 0 && diferencaDia < 0)) {
			idade --;
		}
		
		return idade;
	}
	
	public int calcularIdade2(Date dtNasc) {
		Date hoje = new Date();
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(hoje);
		int dia1 = cal.get(Calendar.DAY_OF_YEAR);
		int ano1 = cal.get(Calendar.YEAR);
		
		cal.setTime(dtNasc);
		int dia2 = cal.get(Calendar.DAY_OF_YEAR);
		int ano2 = cal.get(Calendar.YEAR);
		
		int nAno = ano1 - ano2;
		
		if(dia1 < dia2)
			nAno--; //Ainda não completou aniversário este ano.
		
		return nAno;
	}
	
	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null); //nome e extensão
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING); //origem, destino e formato de cópia
			aluno.setUrlImg(arquivoTemp.toString());
			
			Messages.addGlobalInfo("Upload realizado com sucesso!");
		} catch(IOException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar realizar o upload de arquivo");
			erro.printStackTrace();
		}
		
	}
	
	public void imprimir() {
		try {
			String caminho = Faces.getRealPath("/reports/alunos.jasper");
		
			Map<String, Object> parametros = new HashMap<>();
		
			Connection conexao = HibernateUtil.getConexao();
		
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);

			JasperPrintManager.printReport(relatorio, true); 
		} catch(JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
	
}

package br.com.academy.sgaf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.academy.sgaf.domain.Aluno;
import br.com.academy.sgaf.util.HibernateUtil;

public class AlunoDAO extends GenericDAO<Aluno>{

	@SuppressWarnings("unchecked")
	public List<Aluno> buscarPorAluno(Long alunoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Aluno.class);
			consulta.add(Restrictions.eq("aluno.codigo", alunoCodigo));
			consulta.addOrder(Order.desc("nomeResp"));
			List<Aluno> resultado = consulta.list();
			return resultado;
		} catch(RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listarOrdenado(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Aluno.class);
			consulta.createAlias("aluno", "a");
			consulta.addOrder(Order.asc("a.nome"));
			List<Aluno> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}

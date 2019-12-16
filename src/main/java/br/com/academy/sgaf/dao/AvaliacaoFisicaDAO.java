package br.com.academy.sgaf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.academy.sgaf.domain.AvaliacaoFisica;
import br.com.academy.sgaf.util.HibernateUtil;

public class AvaliacaoFisicaDAO extends GenericDAO<AvaliacaoFisica> {
	@SuppressWarnings("unchecked")
	public List<AvaliacaoFisica> buscarPorAluno(Long alunoCodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(AvaliacaoFisica.class);
			consulta.add(Restrictions.eq("aluno.codigo", alunoCodigo));
			consulta.addOrder(Order.desc("dtAvaFisica"));
			List<AvaliacaoFisica> resultado = consulta.list();
			return resultado;
		} catch(RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}

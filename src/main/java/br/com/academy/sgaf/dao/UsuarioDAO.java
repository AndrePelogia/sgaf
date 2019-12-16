package br.com.academy.sgaf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.academy.sgaf.domain.Usuario;
import br.com.academy.sgaf.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{

	@SuppressWarnings("unchecked")
	public List<Usuario> listarProfessor(String campoOrdenado){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.ne("cref",""));
			consulta.addOrder(Order.asc(campoOrdenado));
			List<Usuario> resultado = consulta.list();
			return resultado;			
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}

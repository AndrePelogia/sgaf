package br.com.academy.sgaf.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.academy.sgaf.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked") // o sistema ainda desconhece o tipo
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null; // garante que uma transação seja completa

		try {
			transacao = sessao.beginTransaction(); // início da transação
			sessao.save(entidade);
			transacao.commit(); // fim da transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação se tiver erro
			}
			throw erro;
		} finally {
			sessao.close(); // fecha a sessão
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campoOrdenacao){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult(); // retorna somente um
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null; // garante que uma transação seja completa

		try {
			transacao = sessao.beginTransaction(); // início da transação
			sessao.delete(entidade);
			transacao.commit(); // fim da transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação se tiver erro
			}
			throw erro;
		} finally {
			sessao.close(); // fecha a sessão
		}
	}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null; // garante que uma transação seja completa

		try {
			transacao = sessao.beginTransaction(); // início da transação
			sessao.update(entidade);
			transacao.commit(); // fim da transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação se tiver erro
			}
			throw erro;
		} finally {
			sessao.close(); // fecha a sessão
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade merge(Entidade entidade) { //incluir e salvar ao mesmo tempo
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null; // garante que uma transação seja completa

		try {
			transacao = sessao.beginTransaction(); // início da transação
			Entidade retorno = (Entidade) sessao.merge(entidade);
			transacao.commit(); // fim da transação
			return retorno;
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação se tiver erro
			}
			throw erro;
		} finally {
			sessao.close(); // fecha a sessão
		}
	}
	
}

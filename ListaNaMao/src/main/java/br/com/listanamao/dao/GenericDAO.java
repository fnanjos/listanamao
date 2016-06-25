package br.com.listanamao.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.listanamao.util.HibernateUtil;

public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	// implementação da api reflection
	// captura a classe em tempo de execução pegando o tipo de entidade que será
	// utlizada
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		// inicia uma sessao capturada da nossa fabrica de sessoes
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		// cria a transação que ocorrerá
		Transaction transacao = null;
		try {
			// inicia a transacao
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		// acessa fabrica de sessoes
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(int codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;
		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}

	public void excluir(Entidade entidade) {
		// inicia uma sessao capturada da nossa fabrica de sessoes
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		// cria a transação que ocorrerá
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		// inicia uma sessao capturada da nossa fabrica de sessoes
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		// cria a transação que ocorrerá
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}
}

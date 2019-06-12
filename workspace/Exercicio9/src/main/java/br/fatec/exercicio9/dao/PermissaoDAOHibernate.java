package br.fatec.exercicio9.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.exercicio9.model.Permissao;
import br.fatec.exercicio9.util.HibernateUtil;

public class PermissaoDAOHibernate implements PermissaoDAO {

	// obrigatório para classe hibernate
	// por meio da Session as operacoes do Hibernate chegam ao Banco de Dados

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Permissao permissao) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(permissao);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir a permissao. Erro: " + e.getMessage());
		}
	}

	public void atualizar(Permissao permissao) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(permissao);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar a permissao. Erro: " + e.getMessage());
		}
	}

	public void excluir(Permissao permissao) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(permissao);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir a permissao. Erro: " + e.getMessage());
		}
	}

	// como se fosse o select, busca pela chave, se nao existir retorna null
	// se usar load ao inves de get será gerada uma excecao

	public Permissao carregar(Integer codigo) {
		    Permissao p = new Permissao();
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria c = session.createCriteria(Permissao.class);
			c.add(Restrictions.eq("id", codigo));
	        p = (Permissao)c.uniqueResult();
			return p;
		}

	public List<Permissao> listar() {
		// this.session.getSessionFactory().openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Permissao";
		@SuppressWarnings("unchecked")
		List<Permissao> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("nao passou nada");
			return null;
		}
	}

	// usando hibernate query sql (parecida com sql)
	// busca outros campos

	public Permissao buscarPorUsuarioOpcao(Integer codigo, String opcao) {
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select u from Permissao u where u.codigousuario=:codigo and u.opcaomenu=:opcao";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo); // parametro
		consulta.setString("opcao", opcao); // parametro

		return (Permissao) consulta.uniqueResult(); 
	}
	
}

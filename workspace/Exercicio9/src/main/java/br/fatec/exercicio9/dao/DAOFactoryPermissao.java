package br.fatec.exercicio9.dao;

import br.fatec.exercicio9.util.HibernateUtil;

public class DAOFactoryPermissao {

	
	public static PermissaoDAO criaPermissaoDAO() {
		PermissaoDAOHibernate permissaoDAO = new PermissaoDAOHibernate();
			      permissaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return permissaoDAO;
		}


}

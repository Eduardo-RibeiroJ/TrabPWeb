package br.fatec.exercicio9.dao;

import br.fatec.exercicio9.util.HibernateUtil;

public class DAOFactory {

	
	public static UsuarioDAO criaUsuarioDAO() {
	UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		      usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}

package br.fatec.ra1721024.dao;

import br.fatec.ra1721024.util.HibernateUtil;

public class DAOFactoryEvento {

	
	public static EventoDAO criaEventoDAO() {
		EventoDAOHibernate eventoDAO = new EventoDAOHibernate();
			      eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return eventoDAO;
		}


}

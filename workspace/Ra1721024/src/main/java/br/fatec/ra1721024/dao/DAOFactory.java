package br.fatec.ra1721024.dao;

import br.fatec.ra1721024.util.HibernateUtil;

public class DAOFactory {

	
	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		      participanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return participanteDAO;
	}

}

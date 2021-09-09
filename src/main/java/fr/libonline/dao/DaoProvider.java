package fr.libonline.dao;

import fr.libonline.dao.jpa.ClientDaoJpaImpl;
import fr.libonline.dao.jpa.CommandeDaoJpaImpl;
import fr.libonline.dao.jpa.LivreDaoJpaImpl;

public class DaoProvider {
	
	public static ClientDaoJpaImpl getClientDao() {
		return new ClientDaoJpaImpl();
	}
	
	public static LivreDaoJpaImpl getLivreDao() {
		return new LivreDaoJpaImpl();
	}
	
	public static CommandeDaoJpaImpl getCommandeDao() {
		return new CommandeDaoJpaImpl();
	}
}

package fr.libonline.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoJpa {
	protected static EntityManagerFactory emf;
	protected EntityManager em;
	
	public DaoJpa() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("LibOnlineUnit");
		}
		em = emf.createEntityManager();
	}
}

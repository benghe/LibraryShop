package fr.libonline.dao.jpa;

import static java.util.Collections.emptyList;

import java.util.List;

import javax.persistence.Query;

import fr.libonline.dao.ClientDao;
import fr.libonline.model.Client;

public class ClientDaoJpaImpl extends DaoJpa implements ClientDao {
	
	private static final String SELECT_ALL = "SELECT c FROM Client c";
	
	private static final String SELECT_BY_ID = "SELECT c FROM Client c WHERE c.id = :id";
	
	private static final String SELECT_BY_LOGIN = 	"SELECT c FROM Client c " //
													+ "WHERE c.login = :login"; //
	
	private static final String SELECT_BY_LOGIN_AND_PASSWORD = 	"SELECT c FROM Client c " //
																+ "WHERE c.login = :login AND c.password = :password"; //
	
	private static final String DELETE = "DELETE FROM Client c WHERE c.id = :id";

	@Override
	public List<Client> findAll() {
		try {
			return em
					.createQuery(SELECT_ALL, Client.class)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emptyList();
	}

	@Override
	public Client findById(int id) {
		try {
			return em
					.createQuery(SELECT_BY_ID, Client.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Client findByLogin(String login) {
		try {
			return em
					.createQuery(SELECT_BY_LOGIN, Client.class)
					.setParameter("login", login)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Client findByLoginAndPassword(String login, String password) {
		try {
			Query query = em.createQuery(SELECT_BY_LOGIN_AND_PASSWORD);
			query.setParameter("login", login);
			query.setParameter("password", password);
			return (Client) query
								.setMaxResults(1)
								.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client add(Client entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client save(Client entity) {
		try {
			em.getTransaction().begin();
			if (entity.getId() > 0) {
				// Si l'entity a un id, on fait un update
				entity = em.merge(entity);
			} else {
				// Sinon on fait un insert
				em.persist(entity);
			}
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			em.getTransaction().begin();
			em
				.createQuery(DELETE)
				.setParameter("id", id)
				.executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

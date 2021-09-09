package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.DaoProvider;
import fr.libonline.model.Commande;

public class CommandeService implements IService<Commande> {

	@Override
	public List<Commande> findAll() {
		return DaoProvider.getCommandeDao().findAll();
	}

	@Override
	public Commande findById(int id) {
		return DaoProvider.getCommandeDao().findById(id);
	}
	
	@Override
	public Commande add(Commande entity) {
		return DaoProvider.getCommandeDao().add(entity);
	}

	@Override
	public Commande save(Commande entity) {
		return DaoProvider.getCommandeDao().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return DaoProvider.getCommandeDao().deleteById(id);
	}

	public List<Commande> findByClientId(int id) {
		return DaoProvider.getCommandeDao().findByClientId(id);
	}

}
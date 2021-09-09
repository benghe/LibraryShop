package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.DaoProvider;
import fr.libonline.model.Livre;

public class LivreService implements IService<Livre>{

	@Override
	public List<Livre> findAll() {
		return DaoProvider.getLivreDao().findAll();
	}

	@Override
	public Livre findById(int id) {
		return DaoProvider.getLivreDao().findById(id);
	}

	public Livre findByAuteur(String auteur) {
		return DaoProvider.getLivreDao().findByAuthor(auteur);
	}
	
	public Livre findByTitre(String titre) {
		return DaoProvider.getLivreDao().findByTitle(titre);
	}
	
	@Override
	public Livre add(Livre entity) {
		return DaoProvider.getLivreDao().add(entity);
	}

	@Override
	public Livre save(Livre entity) {
		return DaoProvider.getLivreDao().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return DaoProvider.getLivreDao().deleteById(id);
	}

}

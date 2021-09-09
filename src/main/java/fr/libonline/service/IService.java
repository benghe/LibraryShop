package fr.libonline.service;

import java.util.List;

public interface IService<T> {
	public List<T> findAll();
	public T findById(int id);
	public T add(T entity);
	public T save(T entity);
	public boolean deleteById(int id);
}

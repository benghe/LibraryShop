package fr.libonline.dao;


import java.util.List;

public interface IDao<T> {
	public List<T> findAll();
	public T findById(int id);
	public T add(T entity);
	public T save(T entity);
	public boolean deleteById(int id);
}
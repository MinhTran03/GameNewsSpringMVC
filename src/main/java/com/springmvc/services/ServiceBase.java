package com.springmvc.services;

import java.util.List;

public interface ServiceBase<T> {

	public List<T> getAll();
	public T getById(int id);
	public boolean save(T entity);
	public boolean update(T entity);
	public boolean delete(T entity);
	
}

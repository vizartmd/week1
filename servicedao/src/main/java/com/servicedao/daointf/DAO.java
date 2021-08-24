package com.servicedao.daointf;

import java.util.List;

public interface DAO<T> {
	
	public void insert(T t);

	public T getById(int id); 

	public void update(T t, int id);

	public void deleteById(int id);
	
	List<T> getAll();
}

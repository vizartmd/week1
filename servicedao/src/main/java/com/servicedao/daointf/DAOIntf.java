package com.servicedao.daointf;

import java.util.List;

public interface DAOIntf<T> {
	
	public void insert(T t);

	public T getById(int id); 

	public void update(T t);

	public void deleteById(int id);
	
	List<T> getAll();
}

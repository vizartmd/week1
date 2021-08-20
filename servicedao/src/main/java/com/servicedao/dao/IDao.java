package com.servicedao.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
	
	void create(T t);
	Optional <T> findById(int id);
	public void update(T t);
	public void delete(int id);
	List<T> getAll();
}


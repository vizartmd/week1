package com.servicedao.dao;

import java.util.List;

public interface DAO<T> {

	public void insert(T t);

	public T getById(int id); 

	public void update(T t);

	public void deleteById(int id);

	public List<T> getAll();
}

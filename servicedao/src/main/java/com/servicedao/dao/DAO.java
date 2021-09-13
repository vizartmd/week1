package com.servicedao.dao;

import java.util.List;

public interface DAO<T> {

	public void insert(T t);

	public T getById(int id, T t); 

	public void update(T t);

	public void deleteById(int id, T t);

	public List<T> getAll(T t);
}

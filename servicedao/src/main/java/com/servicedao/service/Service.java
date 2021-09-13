package com.servicedao.service;

import java.util.List;

public interface Service<T, DatabaseTypes> {

	void insert(T t, DatabaseTypes databaseType);

	T getById(int id,  T t, DatabaseTypes databaseType);

	void update(T t, DatabaseTypes databaseType);

	void deleteById(int id,  T t, DatabaseTypes databaseType);

	public List<T> getAll(T t, DatabaseTypes databaseType);
}

package com.servicedao.service;

import java.util.Set;

public interface Service<T> {

	void insert(T t);

	T findById(int id);

	void update(T t);

	void deleteById(int id);

	public Set<T> getAll();
}

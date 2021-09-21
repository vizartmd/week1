package com.servicedao.service;

import java.util.List;

public interface Service<T> {

	void insert(T t);

	T findById(int id);

	void update(T t);

	void deleteById(int id);

	public List<T> getAll();
}

package com.servicedao.dao;

import java.util.List;

public interface DAO<T> {

	T findById(int id);

	List<T> getAll();

	void insert(T t);

	void update(T t);

	void deleteById(int id);
}

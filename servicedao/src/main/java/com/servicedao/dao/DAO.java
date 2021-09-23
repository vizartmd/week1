package com.servicedao.dao;

import java.util.Set;

/**
 * generic DAO<T> interface
 * @author vrobu1
 * @version 1.0
 */
public interface DAO<T> {

	T findById(int id);

	Set<T> getAll();

	void insert(T t);

	void update(T t);

	void delete(T t);
	
	void deleteById(int id);
}

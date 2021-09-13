package com.main.command;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;
import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.impl.ServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with T class
 * It has a single method "execute()" that calls the "insert()" method on
 * the ServiceImpl class from the service layer and send a new T as a parameter.
 * @param <T>
 */
public class InsertCommand<T> implements Command {
	
	private ServiceImpl serviceImpl;
	private DatabaseTypes databaseType;
	private int id;
	T t;

	public InsertCommand(DatabaseTypes databaseType, T t) {
		this.databaseType = databaseType;
		this.t = t;
	}

	public void execute() {
		serviceImpl = new ServiceImpl();
		serviceImpl.insert(t, databaseType);
	}
}

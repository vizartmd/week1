package com.main.command;

import java.util.List;
import com.servicedao.enums.DatabaseTypes;
import com.servicedao.service.impl.ServiceImpl;

/**
 * This class is a part of Command Design Pattern and operating with T class
 * It has a single method "execute()" that calls the "getAll()" method on
 * the ServiceImpl class from the service layer
 */
public class GetAllCommand<T> implements Command {

	private ServiceImpl serviceImpl;
	private DatabaseTypes databaseType;
	T t;
	private List<T> list;
	
	public GetAllCommand(DatabaseTypes databaseType, T t) {
		this.databaseType = databaseType;
		this.t = t;
	}

	public List<T> getAll() {
		return list;
	}

	@Override
	public void execute() {
		serviceImpl = new ServiceImpl();
		this.list = serviceImpl.getAll(t, databaseType);
	}
}

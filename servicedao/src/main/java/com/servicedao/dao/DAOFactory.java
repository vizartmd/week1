package com.servicedao.dao;

import com.servicedao.dao.impl.UserDaoImpl;
import com.servicedao.dao.impl.TaskDaoImpl;

public class DAOFactory {
	
	private static DAO<?> dao;
	
	private enum DaoType {
		TASKDAO, USERDAO;
	}
	
	private DAOFactory() {};
	
	private final static class SingletonHolder {
		private final static DAOFactory INSTANCE = new DAOFactory();
	}

	public static DAOFactory getInstance() {
		DAOFactory daoFactory = SingletonHolder.INSTANCE;
		return daoFactory;
	}
	
	public static DAO<?> getDao(DaoType type) {
		switch (type) {
			case TASKDAO:
				System.out.println("TASKDAO has been selected!");
				dao = TaskDaoImpl.getInstance();
				return dao;
			case USERDAO:
				System.out.println("USERDAO has been selected!");
				dao = UserDaoImpl.getInstance();
				return dao;
		}
		return dao;
	}
}
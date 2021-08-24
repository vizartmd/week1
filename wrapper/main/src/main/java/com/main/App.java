package com.main;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

import com.servicedao.dao.DAOFactory;
import com.servicedao.daointf.TaskDAO;
import com.servicedao.daointf.UserDAO;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class App {
	public static void main(String[] args) throws SQLException {

		BasicConfigurator.configure();
		DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
		TaskDAO taskDao = daoFactory.getTaskDAO();
		UserDAO userDao = daoFactory.getUserDAO();
//		userDao.insert(new User("Vasea", "Potoran"));
//		userDao.insert(new User("Florin", "Piersic"));
//		userDao.insert(new User("Galina", "Olaru"));
//		userDao.insert(new User("Viorel", "Popusoi"));
//		userDao.insert(new User("Tolea", "Cucu"));
//		userDao.insert(new User("Andrei", "Ichim"));
//		userDao.insert(new User("Ion", "Nita"));
//	    userDao.deleteById(14);

//	    Task task = new Task(13, "Task tytle1002", "Task description1002");
//	    Task task1 = new Task(11, "Task tytle1002", "Task description1002");
//	    Task task2 = new Task(12, "Task tytle1002", "Task description1002");
//		taskDao.insert(task);
//		taskDao.insert(task1);
//		taskDao.insert(task2);
		taskDao.deleteById(14);
		
		List<Task> tasks= taskDao.getAll();
		for (Task t : tasks) {
			System.out.println(t);
		}
		

		List<User> users = userDao.getAll();
		for (User u : users) {
			System.out.println(u);
		}

	}
}

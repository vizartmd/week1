package com.servicedao.service.impl;

import org.apache.log4j.Logger;
import com.servicedao.dao.DAOFactory;
import com.servicedao.dao.DAOFactory.DaoType;
import com.servicedao.service.TaskService;
import java.util.Set;
import com.servicedao.dao.impl.TaskDaoImpl;
import com.servicedao.domain.Task;

public class TaskServiceImpl implements TaskService {

	private Logger logger;
	private TaskDaoImpl taskDaoImpl;
	private static DAOFactory dAOFactory;

	private final static class SingletonHolder {
		private final static TaskServiceImpl INSTANCE = new TaskServiceImpl();
	}

	public static TaskServiceImpl getInstance() {
		TaskServiceImpl taskService = SingletonHolder.INSTANCE;
		dAOFactory = DAOFactory.getInstance();
		
		if (taskService.logger == null) {
			taskService.logger = Logger.getLogger(TaskService.class);
		}
		if (taskService.taskDaoImpl == null) {
			taskService.taskDaoImpl = (TaskDaoImpl) dAOFactory.getDao(DaoType.TASKDAO);
		}
		return taskService;
	}

	@Override
	public void insert(Task task) {
		taskDaoImpl.insert(task);
		logger.info("TaskService.insert() method called");
	}

	@Override
	public Task findById(int id) {
		logger.info("TaskService.getById() method called");
		return taskDaoImpl.findById(id);
	}

	@Override
	public void update(Task task) {
		logger.info("TaskService.update() method called");
		taskDaoImpl.update(task);
	}

	@Override
	public void deleteById(int id) {
		logger.info("TaskService.deleteById() method called");
		taskDaoImpl.deleteById(id);		
	}

	@Override
	public Set<Task> getAll() {
		logger.info("TaskService.getAll() method called");
		return taskDaoImpl.getAll();
	}

}

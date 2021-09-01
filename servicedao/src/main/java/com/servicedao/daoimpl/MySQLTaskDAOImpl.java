package com.servicedao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.servicedao.daointf.TaskDAOIntf;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;

/**
 * @inheritDoc
 */
public class MySQLTaskDAOImpl implements TaskDAOIntf{
	/**
	 * @param "ds" is an instance of "DataSource" Object from which we receive 
	 * the connection to the database
	 */
	DataSource ds;
	
	static Logger log = Logger.getLogger(MySQLTaskDAOImpl.class.getName());
	
	/**
	 * @inheritDoc
	 */
	@Override
	public void insert(Task task) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.error("Instance of DataSource in MySQLTaskDAO class insert() method was not created!");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		int userId = task.getUserId();
		String tytle = task.getTitle();
		String description = task.getDescription();
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLTaskDAO class insert() method.");
			stmt = con.prepareStatement("INSERT INTO mytasks (user_id, title, description) values(?,?,?)");
			stmt.setInt(1, userId);
			stmt.setString(2, tytle);
			stmt.setString(3, description);
			int i = stmt.executeUpdate();
			if (i == 0) {
				log.info("Task was not inserted!");
			} else {
				log.info("Task was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Task was not inserted! " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Task getById(int id) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLTaskDAO class getById() method was not created!");
			return null;
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Task task = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLTaskDAO class getById() method.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM mytasks WHERE id =" + id);
			while (rs.next()) {
			    task = new Task(); 
			    task.setId(id);
			    task.setUserId(rs.getInt("user_id"));
			    task.setTitle(rs.getString("title"));
			    task.setDescription(rs.getString("description"));
			    log.info("Task with id: "+ id + " was found successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Task User not found! " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return task;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void update(Task task) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLTaskDAO class update() method was not created!");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLTaskDAO class update() method.");
			stmt = con.prepareStatement("UPDATE mytasks SET user_id=?, title=?, description=? where id=?");
			stmt.setInt(4, task.getId());
			stmt.setInt(1, task.getUserId());
			stmt.setString(2, task.getTitle());
			stmt.setString(3, task.getDescription());
			int i = stmt.executeUpdate();
			if (i == 0) {
				log.info("Task was not updated!");
			} else {
				log.info("Task was updated successfully!");
			}
		} catch (SQLException e) {
			log.warn("Task was not updated! " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void deleteById(int id) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLTaskDAO class deleteById(int id) method was not created!");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		Task task = getById(id);
		if (task != null) {
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLTaskDAO class deleteById(int id) method.");
			stmt = con.prepareStatement("DELETE FROM mytasks WHERE id=?");
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			if (i == 0) {
				log.info("Task was not deleted!");
			} else {
				log.info("Task with id:" + id + " was deleted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Task wasn't deleted! " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		} else {
			log.warn("Task with id: " + id + " does not exist");
		}
		
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<Task> getAll() {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLTaskDAO class getAll() method was not created!");
			return null;
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Task task = null;
		List<Task> tasksList = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLTaskDAO class getAll() method.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM mytasks");
			tasksList = new ArrayList<>();
			while (rs.next()) {
				task = new Task(rs.getInt("id"),rs.getInt("user_id"), rs.getString("title"), rs.getString("description"));
				tasksList.add(task);
			}
			if (tasksList.size() > 0) {
				log.info("Task list received successfully with 'getAll()' method!");
			} else {
				log.info("Task list is empty!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Task list was not received successfully! " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tasksList;
	}

}

package com.servicedao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.servicedao.daointf.UserDAOIntf;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.User;

/**
 * @inheritDoc
 */
public class MySQLUserDAOImpl implements UserDAOIntf {
	/**
	 * @param "ds" is an instance of "DataSource" Object from which we receive the
	 * connection to the database
	 */
	DataSource ds;
	static Logger log = Logger.getLogger(MySQLUserDAOImpl.class.getName());

	/**
	 * @inheritDoc
	 */
	@Override
	public void insert(User user) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLUserDAO insert() method was not created");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String userName = user.getUserName();
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLUserDAO insert() method.");
			stmt = con.prepareStatement("INSERT INTO myusers (first_name,last_name, user_name) values(?,?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, userName);
			int i = stmt.executeUpdate();
			if (i == 0) {
				log.info("Task was not inserted!");
			} else {
				log.info("User was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.info("User was not inserted! " + e.getMessage());
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					log.info("Prepared statement was closed successfully!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.info("Exception during close of prepared statement: " + e);
				}
		}

	}

	/**
	 * @inheritDoc
	 */
	@Override
	public User getById(int id) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLUserDAO getById() method was not created");
			return null;
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLUserDAO getById() method.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM myusers WHERE id =" + id);
			while (rs.next()) {
				user = new User();
				user.setId(id);
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setUserName(rs.getString("user_name"));
				log.info("User with id: " + id + " was found successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.info("User not found! " + e.getMessage());
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
		return user;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void update(User user) {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLUserDAO update() method was not created");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLUserDAO update() method.");
			stmt = con.prepareStatement("UPDATE myusers SET first_name=?, last_name=?, user_name=? where id=?");
			stmt.setInt(4, user.getId());
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUserName());
			int i = stmt.executeUpdate();
			if (i == 0) {
				log.info("User was not updated!");
			} else {
				log.info("User was updated successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User was not updated! " + e.getMessage());
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
			log.warn("Instance of DataSource in MySQLUserDAO deleteById() method was not created");
			return;
		}
		Connection con = null;
		PreparedStatement stmt = null;
		User user = getById(id);
		if (user != null) {
			try {
				con = ds.getConnection();
				log.info("Connection established in MySQLUserDAO deleteById() method.");
				stmt = con.prepareStatement("DELETE FROM myusers WHERE id=?");
				stmt.setInt(1, id);
				int i = stmt.executeUpdate();
				if (i == 0) {
					log.info("Task was not deleted!");
				} else {
					log.info("User with id:" + id + " was deleted successfully!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("User wasn't deleted! " + e.getMessage());
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			log.warn("User with id: " + id + " does not exist");
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public List<User> getAll() {
		ds = DataSource.getInstance();
		if (ds == null) {
			log.warn("Instance of DataSource in MySQLUserDAO getAll() method was not created");
			return null;
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> usersList = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in in MySQLUserDAO getAll() method.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM myusers");
			usersList = new ArrayList<>();
			while (rs.next()) {
				user = new User();

				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setUserName(rs.getString("user_name"));
				usersList.add(user);
			}
			if (usersList.size() > 0) {
				log.info("User list received successfully with 'getAll()' method!");
			} else {
				log.info("User list is empty!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User list was not received successfully! " + e.getMessage());
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
		return usersList;
	}
}

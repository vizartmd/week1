package com.servicedao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.servicedao.daointf.UserDAO;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.User;

public class MySQLUserDAO implements UserDAO {
	/**
	 * @param "ds" is an instance of "DataSource" Object from which we receive 
	 * the connection to the database
	 */
	DataSource ds;
	static Logger log = Logger.getLogger(MySQLUserDAO.class.getName());

	/**
	 * method "insert()" allows to insert a new User Object in database
	 * @param user the User Object to be inserted in database
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
		try {
			con = ds.getConnection();
			log.info("Connection established in MySQLUserDAO insert() method.");
			stmt = con.prepareStatement("INSERT INTO myusers (first_name,last_name) values(?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.executeUpdate();
			log.info("User was inserted successfully!");
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
						log.info("Exception in prepared statement: " + e);
					}
		}

	}

	/**
	 * method "getById()" allows to get a User Object from the database by id
	 * @param id to find a User Object from the database by unique id
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
				log.info("User with id: " + id + " was finded successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.info("User was not finded! " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * method "update()" allows to update a User Object in the database
	 * @param user the User Object to be updated in database
	 * @param id to find a User Object from the database by unique id
	 */
	@Override
	public void update(User user, int id) {
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
			stmt = con.prepareStatement("UPDATE myusers SET first_name=?, last_name=? where id=?");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setInt(3, id);
			stmt.executeUpdate();
			log.info("User was updated with successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User was not updated! " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * method "deleteById()" allows to delete a User Object from the database by id
	 * @param id to find a User Object from the database by unique id
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
				stmt.executeUpdate();
				log.info("User with id:" + id + " was deleted successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("User wasn't deleted! " + e.getMessage());
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			log.warn("User with id: " + id + " does not exist");
		}
	}

	/**
	 * method "getAll()" allows to get all of the  User Objects from the database
	 * @return {@link List} of all of the User Objects 
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
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usersList;
	}
}

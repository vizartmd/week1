package com.servicedao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import com.servicedao.daointf.UserDAO;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.User;

public class MySQLUserDAO implements UserDAO {
	DataSource ds;
	static Logger log = Logger.getLogger(MySQLUserDAO.class.getName()); 

	@Override
	public void insert(User user) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		try {
			con = ds.getConnection();
			log.info("Connection established in (user's) 'insert()' method.");
			stmt = con.prepareStatement("INSERT INTO myusers (first_name,last_name) values(?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.executeUpdate();
			log.info("User was inserted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User was not inserted! " + e.getMessage());
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

	}

	@Override
	public User getById(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in (user's) 'getById()' method.");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM myusers WHERE id =" + id);
			while (rs.next()) {
				user = new User();
				user.setId(id);
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
			}
			log.info("User was finded with 'getById()' method successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User was not finded! " + e.getMessage());
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

	@Override
	public void update(User user, int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in (user's) 'update()' method.");
			stmt = con.prepareStatement("UPDATE myusers SET first_name=?, last_name=? where id=?");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setInt(3, id);
			int i = stmt.executeUpdate();
			log.info("User was updated with 'update()' method successfully!");
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

	@Override
	public void deleteById(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in (user's) 'deleteById()' method.");
			stmt = con.prepareStatement("DELETE FROM myusers WHERE id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			log.info("User with id:" + id + " was deleted with 'deleteById()' method successfully!");
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
	}

	@Override
	public List<User> getAll() {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> usersList = null;
		try {
			con = ds.getConnection();
			log.info("Connection established in (user's) 'getAll()' method.");
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
			log.info("User list received successfully with 'getAll()' method!");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("User list not received successfully! " + e.getMessage());
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

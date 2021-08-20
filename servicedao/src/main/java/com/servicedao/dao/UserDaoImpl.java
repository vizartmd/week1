package com.servicedao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servicedao.datasource.DataSource;
import com.servicedao.domain.User;

public class UserDaoImpl implements UserDaoIntf {
	DataSource ds;

	@Override
	public void createUser(User user) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		int id = user.getId();
		String userName = user.getUserName();
		String password = user.getPassword();
		try {
			con = ds.getConnection();
			stmt=con.prepareStatement("INSERT INTO myusers values(?,?,?)");  
			stmt.setInt(1,id);
			stmt.setString(2,userName);  
			stmt.setString(3,password); 
			stmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
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
	public User findUserById(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM myusers WHERE id =" + id);
			while (rs.next()) {
				user = new User();
				user.setId(id);
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void updateUser(User user) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id = user.getId();
		String userName = user.getUserName();
		String password = user.getPassword();
		try {
			con = ds.getConnection();
			stmt=con.prepareStatement("UPDATE myusers SET user_name=? where id=?");   
			stmt.setString(1,user.getUserName());
			stmt.setInt(2,user.getId());  
			int i=stmt.executeUpdate();  
			System.out.println(i+" records updated");  
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void deleteUser(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("DELETE FROM myusers WHERE id=?");  
			stmt.setInt(1,id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public List<User> getAllUsers() {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		List<User> usersList = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM myusers");
			usersList = new ArrayList<>();
			while (rs.next()) {
				user = new User();

				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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


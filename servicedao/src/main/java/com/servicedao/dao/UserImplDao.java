package com.servicedao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.servicedao.datasource.DataSource;
import com.servicedao.domain.User;

public class UserImplDao implements IDao {

	DataSource ds;

	@Override
	public void create(Object t) {
		if (t instanceof User) {
			User user = (User) t;
			ds = DataSource.getInstance();
			Connection con = null;
			PreparedStatement stmt = null;
			int id = user.getId();
			String userName = user.getUserName();
			String password = user.getPassword();
			try {
				con = ds.getConnection();
				stmt = con.prepareStatement("INSERT INTO myusers values(?,?,?)");
				stmt.setInt(1, id);
				stmt.setString(2, userName);
				stmt.setString(3, password);
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
		} else return;
	}

	@Override
	public Optional findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object t) {
		if (t instanceof User) {
			User user = (User) t;
			ds = DataSource.getInstance();
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			int id = user.getId();
			String userName = user.getUserName();
			String password = user.getPassword();
			try {
				con = ds.getConnection();
				stmt = con.prepareStatement("UPDATE myusers SET user_name=? where id=?");
				stmt.setString(1, user.getUserName());
				stmt.setInt(2, user.getId());
				int i = stmt.executeUpdate();
				System.out.println(i + " records updated");
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
		} else
			return;
	}

	@Override
	public void delete(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("DELETE FROM myusers WHERE id=?");
			stmt.setInt(1, id);
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
	public List getAll() {
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


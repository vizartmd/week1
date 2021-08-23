package com.servicedao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servicedao.daointf.TaskDAO;
import com.servicedao.datasource.DataSource;
import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class MySQLTaskDAO implements TaskDAO{
	DataSource ds;

	@Override
	public void insert(Task task) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		int userId = task.getUserId();
		String tytle = task.getTytle();
		String description = task.getDescription();
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("INSERT INTO mytasks (user_id, tytle, description) values(?,?,?)");
			stmt.setInt(1, userId);
			stmt.setString(2, tytle);
			stmt.setString(3, description);
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
	public Task getById(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Task task = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM mytasks WHERE id =" + id);
			while (rs.next()) {
			    task = new Task(); 
			    task.setId(id);
			    task.setUserId(rs.getInt("user_id"));
			    task.setTytle(rs.getString("tytle"));
			    task.setDescription(rs.getString("description"));
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
		return task;
	}

	@Override
	public void update(Task task, int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("UPDATE mytasks SET user_id=?, tytle=?, description=? where id=?");
			stmt.setInt(1, task.getUserId());
			stmt.setString(2, task.getTytle());
			stmt.setString(3, task.getDescription());
			stmt.setInt(4, id);
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
		
	}

	@Override
	public void deleteById(int id) {
		ds = DataSource.getInstance();
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("DELETE FROM mytasks WHERE id=?");
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
	public List<Task> getAll() {
		ds = DataSource.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Task task = null;
		List<Task> tasksList = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM mytasks");
			tasksList = new ArrayList<>();
			while (rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				task.setUserId(rs.getInt("user_id"));
				task.setTytle(rs.getString("tytle"));
				task.setDescription(rs.getString("description"));
				tasksList.add(task);
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
		return tasksList;
	}

}

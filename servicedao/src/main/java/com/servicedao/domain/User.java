package com.servicedao.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;

	@Column(name = "first_name", unique = false, nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", unique = false, nullable = false, length = 50)
	private String lastName;

	@Column(name = "user_name", unique = true, nullable = false, length = 50)
	private String userName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Task> tasks;

	public User() {
	}

	public User(String firstName, String lastName, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}
	
	public void addTaskToUser(Task task) {
		if (tasks == null) {
			tasks = new HashSet<>();
		}
		tasks.add(task);
		task.setUser(this);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [userId =" + userId + ", firstName =" + firstName + ", lastName =" + lastName + ", userName ="
				+ userName + "]";
	}

}

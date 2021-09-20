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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;

	@Column(name = "firstName", unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name = "lastName", unique = false, nullable = false, length = 100)
	private String lastName;

	@Column(name = "userName", unique = true, nullable = false, length = 100)
	private String userName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_tasks", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
	private Set<Task> tasks = new HashSet<>();

	public User() {
	}

	public User(String firstName, String lastName, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public User(String firstName, String lastName, String userName, Set<Task> tasks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.tasks = tasks;
	}

	public User(int userId, String firstName, String lastName, String userName, Set<Task> tasks) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.tasks = tasks;
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

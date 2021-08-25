package com.main;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.servicedao.hibernate.HibernateUtil;

public class App {
	public static void main(String[] args) {

		SomeClass someClass = new SomeClass();
		Class clss = someClass.getClass();
		SomeClass someClass1 = (SomeClass)clss.newInstance();
	}
}

class SomeClass {
	private int age;
	private String name = "Vasea";

	public SomeClass() {
	}

	public SomeClass(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
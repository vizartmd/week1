package com.main;

import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.servicedao.domain.User;
import com.servicedao.hibernate.HibernateUtil;

public class App {
	public static void main(String[] args) {

		BasicConfigurator.configure();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
	}
} 
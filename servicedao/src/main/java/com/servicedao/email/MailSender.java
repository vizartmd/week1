package com.servicedao.email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.hibernate.cfg.Configuration;

public class MailSender {

//	final static String fromEmail = "vizart.md@gmail.com";
//	final static String password = "duvxalrpoiamdeoy";
//	final static String toEmail = "vizart.md@gmail.com";

	public static void sendEmail(String mail, String userName) throws IOException {
		System.out.println("Email with saved user started...");
//		Configuration configuration = new Configuration();

		Properties settings = new Properties();
		settings.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
//		settings.put("mail.smtp.host", "smtp.gmail.com");
//		settings.put("mail.smtp.port", "587");
//		settings.put("mail.smtp.auth", "true");
//		settings.put("mail.smtp.starttls.enable", "true");
//		configuration.setProperties(settings);
		String fromEmail = settings.getProperty("mail.username"); 
		String password = settings.getProperty("mail.password"); 
		String toEmail = settings.getProperty("mail.username"); 
		System.out.println("fromEmail: " + fromEmail);
		System.out.println("password: " + password);
		System.out.println("toEmail: " + toEmail);
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(settings, auth);
		EmailUtil.sendEmail(session, toEmail,"User with username \"" + userName + "\" has been saved successfully!", mail);
		
	}
}

//Configuration configuration = new Configuration();
//Properties settings = new Properties();
//settings.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
//configuration.setProperties(settings);
//String fromEmail = settings.getProperty("mail.username"); 
//String password = settings.getProperty("mail.password"); 
//String toEmail = settings.getProperty("mail.username"); 
//System.out.println("fromEmail: " + fromEmail);
//System.out.println("password: " + password);
//System.out.println("toEmail: " + toEmail);
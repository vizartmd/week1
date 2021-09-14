package com.servicedao.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailSender {

	final static String fromEmail = "vizart.md@gmail.com";
	final static String password = "duvxalrpoiamdeoy";
	final static String toEmail = "vizart.md@gmail.com";

	public static void sendEmail(String mail, String userName) {
		System.out.println("Email with saved user started...");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		EmailUtil.sendEmail(session, toEmail,"User with username \"" + userName + "\" has been saved successfully!", mail);
		
	}
}
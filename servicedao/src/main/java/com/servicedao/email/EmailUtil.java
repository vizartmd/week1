package com.servicedao.email;

import java.util.Date;
import java.util.Set;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.servicedao.domain.Task;
import com.servicedao.domain.User;

public class EmailUtil {

	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("vizart.md@gmail.com", "NoReply"));

	      msg.setReplyTo(InternetAddress.parse("vizart.md@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("Email Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	public static String UserStringFormatter(User user) {

		String stringForEail = "User { first name: " + user.getFirstName() + " } / {last name: " + user.getLastName()
				+ " } identified by { user name: " + user.getUserName() + " } has been created\n\n";

		Set<Task> tasks = user.getTasks();
		StringBuilder sb = new StringBuilder();
		for (Task task : tasks) {
			sb.append("Task { task title: " + task.getTitle() + " } { task description: " + task.getDescription()
					+ " } has been assigned to { user name: " + user.getUserName() + " }\n\n");
		}
		return stringForEail + sb.toString();
	}
	
}

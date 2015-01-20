package com.epam.travelup.sender;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailActivationSender {
	private final static String ADMIN_EMAIL = "travelup.ua@gmail.com";
	private final static String ADMIN_EMAIL_PASS = "root1234";
	private final static String SUBJECT = "This is Subject";

	private String userName;
	private String userEmail;
	private String userLogin;
	private Properties props;

	public MailActivationSender (String userName, String userEmail, String userLogin) {
		System.out.println("2.5");
		this.userName = userName;
		this.userEmail = userEmail;

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		System.out.println("3");
	}

	public void send () {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_EMAIL_PASS);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ADMIN_EMAIL));
			System.out.println("3.1");
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userEmail));
			System.out.println("3.2");
			message.setSubject(SUBJECT);
			System.out.println("3.3");
			message.setText(getText());
			System.out.println("3.4");
			Transport.send(message);
			System.out.println("3.5");
		} catch (Exception e) {
			System.out.println("4");
			throw new RuntimeException(e);
		}
	}

	private String getText() {
		return "Hello dear " + userName + "! Now you have registrated on portal TravelUp. Your login is " + userLogin;
	}
}



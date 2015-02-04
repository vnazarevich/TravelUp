package com.epam.travelup.sender;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailActivationSender {
	private final static String ADMIN_EMAIL = "travelup.ua@gmail.com";
	private final static String ADMIN_EMAIL_PASS = "root1234";
	private final static String ACTIVATION_URL = "http://localhost:8080/TravelUp/activationaccount";
	private final static String SIGNUP_URL = "http://localhost:8080/TravelUp/signup";
	private final static Logger LOGGER = Logger.getLogger("MailActivationSender ::");

	private String userName;
	private String userEmail;
	private String userLogin;
	private Properties props;

	public MailActivationSender(String userName, String userEmail,
			String userLogin) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userLogin = userLogin;

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	}

	public void sendActivationAccount() {
		send(getTextForActivationAccount(), getSubjectForActivationAccount());
	}

	public void sendRegistrationCompleted() {
		send(getTextForRegistrationCompleted(),
				getSubjectForRegistrationCompleted());
	}

	public void sendRegistrationFailed() {
		send(getTextForRegistrationFailed(), getSubjectForRegistrationFailed());
	}
	
	public void sendToUserGid(String text, String subject){
		send(text, subject);
	}

	private String getTextForUserGid() {
		// TODO Auto-generated method stub
		return null;
	}

	private void send(String text, String subject) {
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_EMAIL_PASS);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ADMIN_EMAIL));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userEmail));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
			System.out.println("send mail");
		} catch (Exception e) {
			LOGGER.warning("from send()" + e);
			throw new RuntimeException(e);
		}
	}

	private String getTextForRegistrationCompleted() {
		return "Hello "
				+ userName
				+ "!!! Congratulations, your TravelUp account created with success and we are pleased to count you among our community."
				+ "We recommend you keep this email to store your identifiers."
				+ "our identifiers:" + "	username: " + userName
				+ ", email address: " + userEmail
				+ "Thank you for your trust in our solutions, "
				+ "TravelUp Team ";
	}

	private String getSubjectForRegistrationCompleted() {
		return "Registration completed ! ";
	}

	private String getTextForActivationAccount() {
		return "Hello "
				+ userName
				+ "! Please use the link below to activate your account on portal TravelUp:  "
				+ (ACTIVATION_URL + "?" + "login=" + userLogin + "&" + "hash=" + userEmail); // .charAt(0)
	}

	private String getSubjectForActivationAccount() {
		return "Welcome to TravelUp";
	}

	private String getSubjectForRegistrationFailed() {
		return "Registration failed";
	}

	private String getTextForRegistrationFailed() {
		return "Try to create an account on TrevelUp once more" + SIGNUP_URL;
	}
}

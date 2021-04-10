package com.example.demo.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//Java Mail API
//A platform and protocol independent framework to  build mail and messaging applications.
//activation jar and mail jar but in maven we use  javax.mail
//javax.mai.Message to send a message
public class EmailApi {

	public static void main(String[] args) throws MessagingException {

		System.out.println("Prepairing to send emails");
		String messge = "Hello ,Dear this is message for secuirity check";
		String subject = "Confirmation";
		String to = "turna.prink@gmail.com";
		String from = "turna.prink54@gmail.com";

		sendEmail(messge, subject, to, from);

	}

	private static void sendEmail(String messge, String subject, String to, String from) throws MessagingException {

		// Variable for gmail host
		String host = "smtp.gmail.com";

		// get system properties
		Properties properties = System.getProperties();
		System.out.println("Properties" + properties);

		// setting im information to property object

		// host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1 : tog et sesion object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("turna.prink54@gmail.com", "Kewal.Prink54");
			}

		});

		session.setDebug(true);

//Step 2 :Compose the message

		MimeMessage message = new MimeMessage(session);

//from
		message.setFrom(from);
//adding ecepite	nt to message
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//addig subject to message
		message.setSubject(subject);
//adding text to message
		message.setText(messge);

//send Step : 3

		Transport.send(message);

		System.out.println("sent");

	}
}

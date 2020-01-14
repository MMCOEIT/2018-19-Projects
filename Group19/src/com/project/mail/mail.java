package com.project.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

	public static int  sendMailOtp(String userEmail,String userOtp)
	{
		int n=1;

	    String host = "smtp.gmail.com";
	    String from = "optimalcoding769769@gmail.com";
		String pass = "OptimalCoding1234567";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");

	    String[] to = {userEmail}; // added this line

	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    try {
			message.setFrom(new InternetAddress(from));
			
			 InternetAddress[] toAddress = new InternetAddress[to.length];

			    // To get the array of addresses
			    for( int i=0; i < to.length; i++ ) { // changed from a while loop
			        toAddress[i] = new InternetAddress(to[i]);
			    }
			    System.out.println(Message.RecipientType.TO);
			    
			    
			    

			    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
			        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			    }
			    message.setSubject("Efficient Algorithms for Mining Top-K High Utility Item sets ");
			    message.setText("Your One Time Password is : "  +  userOtp);
			   
			    Transport transport = session.getTransport("smtp");
			    transport.connect(host, from, pass);
			    transport.sendMessage(message, message.getAllRecipients());
			    transport.close();
			  
			
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;

	   
	}
	
	public static int sendMailPassword(String userEmail,String userPassword){
		int n=1;
		  String host = "smtp.gmail.com";
		    String from = "optimalcoding769769@gmail.com";
			String pass = "OptimalCoding1234567";
		    Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {userEmail}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    try {
				message.setFrom(new InternetAddress(from));
				
				 InternetAddress[] toAddress = new InternetAddress[to.length];

				    // To get the array of addresses
				    for( int i=0; i < to.length; i++ ) { // changed from a while loop
				        toAddress[i] = new InternetAddress(to[i]);
				    }
				    System.out.println(Message.RecipientType.TO);

				    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
				        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
				    }
				    message.setSubject("Efficient Algorithms for Mining Top-K High Utility Item sets ");
				    message.setText("Your Application password  : "  +  userPassword);
				   
				    Transport transport = session.getTransport("smtp");
				    transport.connect(host, from, pass);
				    transport.sendMessage(message, message.getAllRecipients());
				    transport.close();
				  
				
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return n;
		
	}
	
	public static int mailSendNewPassword(String userEmail,String userNewPassword)
	{
		int n=1;
		  String host = "smtp.gmail.com";
		    String from = "optimalcoding769769@gmail.com";
			String pass = "OptimalCoding1234567";
		    Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {userEmail}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    try {
				message.setFrom(new InternetAddress(from));
				
				 InternetAddress[] toAddress = new InternetAddress[to.length];

				    // To get the array of addresses
				    for( int i=0; i < to.length; i++ ) { // changed from a while loop
				        toAddress[i] = new InternetAddress(to[i]);
				    }
				    System.out.println(Message.RecipientType.TO);

				    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
				        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
				    }
				    message.setSubject("Efficient Algorithms for Mining Top-K High Utility Item sets ");
				    message.setText("Your new password is   : "  +  userNewPassword);
				   
				    Transport transport = session.getTransport("smtp");
				    transport.connect(host, from, pass);
				    transport.sendMessage(message, message.getAllRecipients());
				    transport.close();
				  
				
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return n;
		
		
	}
	
	public static int mailConatctUs(String userEmail)
	{
		int n=1;
		  String host = "smtp.gmail.com";
		    String from = "optimalcoding769769@gmail.com";
			String pass = "OptimalCoding1234567";
		    Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {userEmail}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    try {
				message.setFrom(new InternetAddress(from));
				
				 InternetAddress[] toAddress = new InternetAddress[to.length];

				    // To get the array of addresses
				    for( int i=0; i < to.length; i++ ) { // changed from a while loop
				        toAddress[i] = new InternetAddress(to[i]);
				    }
				    System.out.println(Message.RecipientType.TO);

				    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
				        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
				    }
				    message.setSubject("Efficient Algorithms for Mining Top-K High Utility Item sets ");
				    message.setText("Thanks ! for Runnning Application As soon as Poosible we will Contact");
				   
				    Transport transport = session.getTransport("smtp");
				    transport.connect(host, from, pass);
				    transport.sendMessage(message, message.getAllRecipients());
				    transport.close();
				  
				
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return n;
		
		
	}
	
	
}

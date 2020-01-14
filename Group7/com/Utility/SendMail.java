package com.Utility;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	final static String host="smtp.gmail.com";
	final static String port="587";
	final static String userName="Project.varification@gmail.com";
	final static String password="Email@123";
	
	public static void sendEmail(String toAddress, String code) throws AddressException, MessagingException 
	{
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		    Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		
		msg.setSubject("New Qestion");
		msg.setText("Hello Expert.... New Qestion Found Is :  " + code);
        Transport.send(msg);

	}
	
	public static void sendReward(String toAddress, String expertname) throws AddressException, MessagingException 
	{
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		    Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		
		msg.setSubject("Congratulation!!!! You Are Winning Rewards....!!!");
		
		msg.setText(" Dear Expert" +" "+  expertname +","+"\n"
				
			+"\n"	
	   +"Through this recognition program your efforts in the workplace are rewarded with beautifully crafted awards from which you can select."+"\n"

    + "People are  always be our greatest asset. Your abilities and contributions are  important key to the success of our entire operation. Take a moment to reflect upon your accomplishments and take pride in knowing that you are an important member of our team."+"\n"

    +" Thank you again for your loyal support."+"\n"
    +"\n 1.Movie Ticket"
    +"\n 2.Coupan"	
    +"\n"	
    +"\n"	
    
    
     + "Thanks & Regards,"+"\n"

    +"\n"	
      +"CQA family"+"\n"
     +"(Director Of CQA)"
				
				);
       
		Transport.send(msg);

	}
	
	
	
	
}

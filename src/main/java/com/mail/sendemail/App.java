package com.mail.sendemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
String to="anirudhraj123@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",  
	            "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465"); 
		  
		  Session session = Session.getDefaultInstance(props,  
				   new javax.mail.Authenticator() {  
				   protected PasswordAuthentication getPasswordAuthentication() {  
				   return new PasswordAuthentication("YourEmail","YourPassword");
				   }});
		  try {  
			   MimeMessage message = new MimeMessage(session);  
			   message.setFrom(new InternetAddress("YourEmail"));
			   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
			   message.setSubject("Hello From Java API - Anirudh");  
			   message.setText("<center><h1>Hello,This Mail Body....</h1></center><br/> Have a Good Day<br/><br/> <i>Thank you,</i><br/><b>Aniurdh</b>","utf-8", "html");  
			     
			   //send message  
			   Transport.send(message);  
			  
			   System.out.println("Email sent successfully");  
			   
			  } 
		  catch (MessagingException mex) 
		  		{
				 mex.printStackTrace();
				}

	}
}


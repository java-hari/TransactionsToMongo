package com.app.mongo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.app.mongo.entity.MasterSource;


public class Util {
	
	

	

	public String getSystemDateTime() {
		
		Date trnDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return formatter.format(trnDate);
	}
	 public static void main(String[] args)  {
		 
		 Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	        
			/*Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("bwseaport", "(Nov2024)");
			    }
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bwseaport@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bwseaport@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Hello, this is a test email!");
			
			Transport.send(message);*/

			
		 Date currentDate = new Date();
		 LocalDateTime currentDateTime = LocalDateTime.now();	
		 System.out.println(currentDateTime);
			/*
			 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 * String formattedDate = formatter.format(date);
			 * System.out.println(formattedDate); LocalDateTime lo = LocalDateTime.now();
			 * lo.get System.out.println(lo.format(""));
			 */
	    }
}

/**
 * 
 */
package org.business.service.email;

import java.util.Properties;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author iliyasm
 *
 */
public class CrunchifyJavaMailExample {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void generateAndSendEmail() throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		//mailServerProperties.put("mail.smtp.port", "587");smtp.gmail.com
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.connectiontimeout", "5000");
		mailServerProperties.put("mail.smtp.timeout", "5000");
		
	/*	mailServerProperties.put("mail.transport.protocol", "smtp");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.auth", "true");*/
		
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setFrom(new InternetAddress("iliyasm@tarangtech.com"));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("iliyasm@tarangtech.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("iliyasm@tarangtech.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		//
		//Transport transport = getMailSession.getTransport("smtp");
 try {
		Transport.send(generateMailMessage);
 }
 catch (Throwable  asc){
	 
	 System.out.println(asc);
	 
 }
/* catch (NoClassDefFoundError as){
	 
	 System.out.println(as);
	 
	 
 }
	*/	// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		//transport.connect("smtp.gmail.com", "omnypaytest@gmail.com", "tarang1234");
		//transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		//Transport.close();
	}
}
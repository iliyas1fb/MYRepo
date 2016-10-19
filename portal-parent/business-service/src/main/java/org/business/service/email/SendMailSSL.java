/**
 * 
 */
package org.business.service.email;




import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author iliyasm
 *
 */
public class SendMailSSL {
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
		Properties props = new Properties();
		  props.put("mail.transport.protocol", "smtps");
          props.put("mail.smtp.starttls.enable", "false");
          props.put("mail.smtp.host", "172.30.65.4");
          props.put("mail.smtp.port", "587");
          props.put("mail.smtp.auth", "true");
          props.put("mail.debug", "true");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("pspupi@tarangtech.com","Psp@upi123q");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pspupi@tarangtech.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("iliyasm@tarangtech.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}*/	
	
	
	private static  class SMTPAuthenticator extends javax.mail.Authenticator {
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.mail.Authenticator#getPasswordAuthentication()
		 */
		public PasswordAuthentication getPasswordAuthentication() {
			String username = "pspupi@tarangtech.com";
			String password = "Psp@upi123q";
			return new PasswordAuthentication(username, password);
		}
	}
	
	
	
	
	public static void main(String as []) {
	
		try {
           // EmailMessage emailMsg = (EmailMessage)emailObj;
           // System.out.println("sendEmail " + emailMsg.getToEmail() + "on " + new Date());
           // LOGGER.info(emailMsg.getToEmail());
            boolean debug = false;
            // Set the SMTP Properties
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", "172.30.65.4");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            // Check the SMTP Authenticator
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(true);
            Message msg = new MimeMessage(session);
            // set the from and to address
            InternetAddress addressFrom = new InternetAddress("pspupi@tarangtech.com");
            msg.setFrom(addressFrom);
            
            String[] recipients = new String[1];
            recipients[0] ="iliyasm@tarangtech.com";
            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                  if (recipients[i] != null) {
                         addressTo[i] = new InternetAddress(recipients[i]);
                  }
            }

            msg.setRecipients(Message.RecipientType.TO, addressTo);
            // Setting the Subject and Content Type
            msg.setSubject("Subject");
            msg.setContent("My body", "text/html");

            Transport.send(msg);
          //  LOGGER.info(emailMsg.getToEmail());
           // return true;
     } 
     catch (Exception e) {
           // LOGGER.error("Exceprion is Occurred: Mail Sending Failed : {} ", e);
           // return false;
     }

	}
}
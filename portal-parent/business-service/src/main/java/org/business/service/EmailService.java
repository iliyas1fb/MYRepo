package org.business.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*import com.omnypay.framework.common.util.OMNYPAYConstants;
import com.omnypay.framework.common.util.PropertiesUtil;
import com.omnypay.webui.log.utils.Log4jAdapter;*/

public class EmailService {
	//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

	/** The CLAS s_ name. */
	private static String CLASSNAME = EmailService.class.getName();
	
	
	 String SMTP_HOST_NAME = "smtp.gmail.com";
	 String EMAIL_FROM_ADDRESS = "pspupi@tarangtech.com";
	 String SMTP_AUTH_USER = "pspupi@tarangtech.com";
	 String SMTP_AUTH_PWD = "Psp@upi123q";
	 
	public void postMail(String recipients[], String subject, String message) {
		//LOGGER.debug(CLASSNAME);
		try {
			boolean debug = false;
			Properties props = new Properties();
			//props.put("mail.transport.protocol", "smtp");
			props.put("mail.transport.protocol", "smtps");
			//props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.starttls.enable", "false");
			props.put("mail.smtp.host", "172.30.65.4");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);
			// set the from and to address
			InternetAddress addressFrom = new InternetAddress(EMAIL_FROM_ADDRESS);
			msg.setFrom(addressFrom);
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++){
				if (null != recipients[i]){
					addressTo[i] = new InternetAddress(recipients[i]);
				}
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			// Setting the Subject and Content Type
			msg.setSubject(subject);
			msg.setText(message);
			Transport.send(msg);
		} catch (Exception e) {
			//LOGGER.info("Exception :",e);
		}
	}
	
	public void postMail(String recipients[], String subject, String message, String language) {
		//LOGGER.debug(CLASSNAME);
		try {
			boolean debug = false;
		    Properties props = new Properties();
            props.put("mail.transport.protocol", "smtps");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", "172.30.65.4");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(props, auth);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);
			// set the from and to address
			InternetAddress addressFrom = new InternetAddress(EMAIL_FROM_ADDRESS);
			msg.setFrom(addressFrom);
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++){
				if (null != recipients[i]){
					addressTo[i] = new InternetAddress(recipients[i]);
				}
			}
			
			MimeMultipart multipart = new MimeMultipart();
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(message, "text/html; charset=UTF-8");
			multipart.addBodyPart(bodyPart);
			
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			msg.setSubject(subject, "UTF-8");
			msg.setContent(multipart);
			Transport.send(msg);
			
			
			
		} catch (Throwable e) {
			
			System.out.println("Exception:ji"+e);
			e.fillInStackTrace();
			//LOGGER.info("Exception :",e);
		}
	}

	/**
	 * The Class SMTPAuthenticator.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.mail.Authenticator#getPasswordAuthentication()
		 */
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}
}

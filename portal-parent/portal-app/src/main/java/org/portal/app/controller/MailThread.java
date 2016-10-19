package org.portal.app.controller;

import javax.annotation.Resource;

import org.business.service.EmailService;
import org.common.service.MailVO;
import org.springframework.beans.factory.annotation.Autowired;

public class MailThread extends Thread{

	@Autowired
	private EmailService emailService;

	private MailVO mailVO;
	
	boolean stopFlag = false;
	
	/** The LOGGER. */
	//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();
	
	public MailThread(EmailService emailService, MailVO mailVO) {
		this.emailService = emailService;
		this.mailVO = mailVO;
	}
	
	@Override
	public void run() {

		try {
			String [] recipients = mailVO.getRecipients();
			String subject = mailVO.getSubject();
			String message = mailVO.getMessage();
			String language = mailVO.getLanguage();
			if(null != language){
				emailService.postMail(recipients, subject, message, language);
			}else{
				emailService.postMail(recipients, subject, message);
			}
		} catch (Exception e) {
			//LOGGER.info("getStackTraceAsString",e);
		}
	}
}

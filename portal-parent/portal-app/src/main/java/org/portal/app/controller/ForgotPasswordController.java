package org.portal.app.controller;

import java.util.Locale;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.business.service.EmailService;
import org.business.service.UserService;
import org.business.service.email.MessageUtil;
import org.business.service.email.SendMailSSL;
import org.business.service.validator.ForgotPasswordValidator;
import org.common.service.ForgotPassword;
import org.common.service.MailVO;
import org.common.service.NewRandomPwd;
import org.common.service.util.PortalConstants;
import org.common.service.util.PortalUtil;
import org.common.service.util.PropertiesUtil;
import org.exception.service.PortalServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/password")
public class ForgotPasswordController {

	private final String className = this.getClass().getName();
	
	@Autowired
	ForgotPasswordValidator forgotPasswordValidator;
	
	@Autowired
	MessageUtil messageUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	/*@Resource(name = "resetNewPasswordService")
	private ResetNewPasswordService resetNewPasswordService;
	*//**
	 * Instantiates a new forgot password controller.
	 * 
	 * @param forgotPasswordValidator
	 *            the forgot password validator
	 *//*
	@Autowired
	public ForgotPasswordController(ForgotPasswordValidator forgotPasswordValidator) {
		this.forgotPasswordValidator = forgotPasswordValidator;
	}*/

	/**
	 * Process submit.
	 * 
	 * @param forgotPasswordVO
	 *            the forgot password vo
	 * @param result
	 *            the result
	 * @param status
	 *            the status
	 * @return the string
	 */
	@RequestMapping(value = "/forgotSubmit", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("forgotPassword") ForgotPassword forgotPasswordVO, BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		
		String methodName = "processSubmit";
		
		StringBuilder sb = new StringBuilder();
		
	/*	forgotPasswordValidator.validate(forgotPasswordVO, result);

		if (result.hasErrors()) {
		
			return "forgotPassword";
		
		} else {*/
			
			
			status.setComplete();
			
			//String forgotType = MessageUtil.getMessage("label.ForgotPasswordType");
			NewRandomPwd randomTO = null;
			
			try {
				
				//randomTO = userService.getNewRandomPassword(forgotType, forgotPasswordVO.getUserName(), forgotPasswordVO.getEmail());
				String newPass = PortalUtil.genPwd();
				//String userName = randomTO.getUserName();
				//String email = randomTO.getEmailId();
				randomTO = new NewRandomPwd();
				randomTO.setUserName(forgotPasswordVO.getUserName());
				randomTO.setEmailId(forgotPasswordVO.getEmail());
				randomTO.setUserFirstName("iliyas");
				randomTO.setUserLastName("Khan");
				//SendMailSSL.mainly();
				
				String language = "en";
				Locale locale = new Locale(language);
				String[] recipients = new String[] { randomTO.getEmailId() };
				
				String programName = PropertiesUtil.getPropertyValue(PortalConstants.PROGRAM_NAME);
				String programSupportEmail = PropertiesUtil.getPropertyValue(PortalConstants.PROGRAM_SUPPORT_EMAIL);
				String programSupportPhone = PropertiesUtil.getPropertyValue(PortalConstants.PROGRAM_SUPPORT_PHONE);
				String signature = PropertiesUtil.getPropertyValue(PortalConstants.SIGNATURE);
				String programWebsite = PropertiesUtil.getPropertyValue(PortalConstants.PROGRAM_WEBSITE);
				String url = PropertiesUtil.getPropertyValue(PortalConstants.MAIL_URL);
				String userNameFull = randomTO.getUserFirstName()+" "+randomTO.getUserLastName();
				String messageValue[] = {userNameFull, programName, url, url, newPass, programSupportEmail, programSupportEmail, programSupportPhone, signature, programWebsite};
				String subject = "forgetpassword";// messageUtil.getMessage("mail.ResetPasswordSubject", locale);
				String message = "My message of password ";//messageUtil.getDynamicMessage("mail.UserMailForgotPassword", messageValue, locale);;
				MailVO mailVO = new MailVO(recipients, subject, message, language);
				new MailThread(emailService, mailVO).start();
				randomTO.setUserName("");
				randomTO.setEmailId("");
				randomTO.setUserFirstName("");
				randomTO.setUserLastName("");
				req.setAttribute("Success", "1");
				
			} /*catch (PortalServiceException pse) {
			
				StringBuilder errorBuffer = new StringBuilder();
			
				result.rejectValue("email", pse.getErrorCode());
			
			}*/ catch (Exception ex) {
				
				StringBuilder errorBuffer = new StringBuilder();
				
			//	result.rejectValue("email", ErrorCodeConstants.OMNYPAY_SYSTEM_ERROR);
			}
			
			return "forgotPassword";
		//}
	}
	
	/*@RequestMapping(value = "/forgotSubmit", method = RequestMethod.GET)
	public String getProcessSubmit(@ModelAttribute("forgotPassword") ForgotPasswordVO forgotPasswordVO, BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		return "login/password/forgotPasswordForm";
	}*/


	
	
	
	
	
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String initForm(@ModelAttribute("forgotPassword") ForgotPassword forgotPasswordVO, BindingResult result, ModelMap model) {
		
		String methodName = "initForm";
		
		return "forgotPassword";
	}
	

	
	/*@RequestMapping(value = "/getnewpassword", method = RequestMethod.GET)
	public String getNewResetPasswordPage(@ModelAttribute("forgotPassword") ForgotPasswordVO forgotPasswordVO, 
			BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		String methodName = "processSubmit";
		StringBuilder sb = new StringBuilder();
		sb.append(OMNYPAYConstants.LOG_USER_NAME).append(forgotPasswordVO.getUserName()).append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		forgotPasswordVO.setResetPassValString(req.getParameter("resetPassValString"));
		forgotPasswordVO.setValForReset("validation");
		return "login/password/resetingNewPassword";
	}
	
	@RequestMapping(value = "/getnewpasswordSubmit", method = RequestMethod.POST)
	public String getNewResetPasswordPageSubmit(@ModelAttribute("forgotPassword") ForgotPasswordVO forgotPasswordVO, 
			BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		String methodName = "processSubmit";
		StringBuilder sb = new StringBuilder();
		sb.append(OMNYPAYConstants.LOG_USER_NAME).append(forgotPasswordVO.getUserName()).append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		forgotPasswordValidator.validate(forgotPasswordVO, result);
		if (result.hasErrors()) {
			return "login/password/resetingNewPassword";
		} else {
			status.setComplete();
			try {
				resetNewPasswordService.resetNewPassword(forgotPasswordVO.getResetPassValString(), forgotPasswordVO.getPhoneNumber(),
						forgotPasswordVO.getEmail(), ShaHashEncoder.encodeShaHash(forgotPasswordVO.getPassword()));
				req.setAttribute("Success", "1");
			} catch (OMNYPAYServiceException pdae) {
				StringBuilder errorBuffer = new StringBuilder();
				errorBuffer.append("Exception occured while reseting new password").append(OMNYPAYConstants.COMMA).append(sb);
				LOGGER.error(className, methodName, pdae, errorBuffer);
				req.setAttribute("Success", "2");
				if(ErrorCodeConstants.PASSWORD_LINKED_GOT_EXPIRED_ERC.equals(pdae.getErrorCode())){
					return "login/password/passwordLinkExpired";
				}
				result.rejectValue("email", pdae.getErrorCode());
				return "login/password/resetingNewPassword";
			} catch (Exception ex) {
				StringBuilder errorBuffer = new StringBuilder();
				errorBuffer.append("Exception occured while reseting new password").append(OMNYPAYConstants.COMMA).append(sb);
				LOGGER.error(className, methodName, ex, errorBuffer);
				req.setAttribute("Success", "2");
				result.rejectValue("email", ErrorCodeConstants.GET_NEW_PASSWORD);
				return "login/password/forgotPasswordForm";
			}
			LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
			return "login/password/resetingNewPassword";
		}
	}
	

	
	@RequestMapping(value = "/helpdeskdrecovery", method = RequestMethod.GET)
	public String getNewPassWithHelpDesk(@ModelAttribute("forgotPassword") ForgotPasswordVO forgotPasswordVO, 
			BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		forgotPasswordVO.setValForReset("validation");
		return "login/password/getnewpasswithhelpdesk";
	}
	
	@RequestMapping(value = "/helpdeskdrecoverysubmit", method = RequestMethod.POST)
	public String getNewPassWithHelpDeskSubmit(@ModelAttribute("forgotPassword") ForgotPasswordVO forgotPasswordVO, 
			BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		String METHOD_NAME = "getNewPassWithHelpDeskSubmit";
		StringBuilder sb = new StringBuilder();
		sb.append(OMNYPAYConstants.LOG_USER_NAME).append(forgotPasswordVO.getUserName()).append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		forgotPasswordValidator.validate(forgotPasswordVO, result);
		
		if (result.hasErrors()) {
			return "login/password/getnewpasswithhelpdesk";
		} else {
			status.setComplete();
			try {
				String resetValueString = PickingRandomNumbers(15);
				//ChangePwdSpTO changeTO = userService.forgotPasswordChanged(forgotType, userName, newPass, email);
				resetNewPasswordService.getNewPassWithHelpDesk(resetValueString, forgotPasswordVO.getPhoneNumber(),
						forgotPasswordVO.getEmail());
				req.setAttribute("Success", "1");

				//mail sending logic
				String[] recipients = new String[] { forgotPasswordVO.getEmail() };
				
				int languageId = 0;
				String languageValue;
				String language="en";
				
				switch(languageId){
					case 2:
						languageValue = "de";
						break;
					case 3:
						languageValue = "es";
						break;
					case 4:
						languageValue = "fr";
						break;
					case 5:
						languageValue = "it";
						break;
					case 6:
						languageValue = "nl";
						break;
					case 7:
						languageValue = "pt";
						break;
					default:
						languageValue = "en";
						break;
				}
				
				Locale locale = new Locale(languageValue.toString());
				
				String subjectValue[] = {};
				String subject = MessageUtil.getDynamicMessage("mail.GetNewPasswithhelpdeskSubject", subjectValue, locale);
				
				String configured_URL = PropertiesUtil.getPropertyValue(OMNYPAYConstants.MAIL_GETNEWPASSWITHHELPDESK) + "=" +resetValueString;
				
				String messageValues[] = {configured_URL, configured_URL};
				String message = MessageUtil.getDynamicMessage("mail.GetNewPasswithhelpdesk", messageValues, locale);
				
				MailVO mailVO1 = new MailVO(recipients, subject, message, language);
				new MailThread(emailService, mailVO1).start();

			} catch (OMNYPAYServiceException pdae) {
				StringBuilder errorBuffer = new StringBuilder();
				errorBuffer.append("Exception occured while reseting new password").append(OMNYPAYConstants.COMMA).append(sb);
				LOGGER.error(className, METHOD_NAME, pdae, errorBuffer);
				req.setAttribute("Success", "2");
				result.rejectValue("email", pdae.getErrorCode());
				return "login/password/getnewpasswithhelpdesk";
			} catch (Exception ex) {
				StringBuilder errorBuffer = new StringBuilder();
				errorBuffer.append("Exception occured while reseting new password").append(OMNYPAYConstants.COMMA).append(sb);
				LOGGER.error(className, METHOD_NAME, ex, errorBuffer);
				req.setAttribute("Success", "2");
				result.rejectValue("email", ErrorCodeConstants.GET_NEW_PASSWORD_WITH_HELP_DESK);
				return "login/password/getnewpasswithhelpdesk";
			}
			LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
			return "login/password/getnewpasswithhelpdesk";
		}
	}

	public String PickingRandomNumbers(long len) {

		long tLen = (long) Math.pow(10, len - 1) * 9;

		long number = (long) (Math.random() * tLen)
				+ (long) Math.pow(10, len - 1) * 1;

		String tVal = number + "";
		return tVal;
	}*/
	
}

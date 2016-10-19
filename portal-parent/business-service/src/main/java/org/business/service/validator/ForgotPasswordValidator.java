
package org.business.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.business.service.UserService;
import org.business.service.email.MessageUtil;
import org.common.service.ForgotPassword;
import org.common.service.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



/**
 * The Class ForgotPasswordValidator.
 */
public class ForgotPasswordValidator implements Validator {
	/** The user service. */
	//@Resource(name = "userService")
	private UserService userService;

	/** The valid email pattern. */
	private static String validEmailPattern = "[^.@]+([.][^.@]+)*[@][^.@]+[.][^.@]+([.][^.@]+)*";
	
	/** The invali chars. */
	private static String invaliChars = "[\\(\\)\\\\;:\\[\\]\"<>,\\s]";

	/** The LOGGER. */
	//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

	/** The CLAS s_ name. */
	private final String className = this.getClass().getName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		// just validate the Customer instances
		return ForgotPasswordValidator.class.isAssignableFrom(clazz);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		String methodName = "validate";
		
		try {
			ForgotPassword forgotVO = (ForgotPassword) target;
			
			if(forgotVO.getValForReset() != null){
				return;
			}
			
			String userName = forgotVO.getUserName().trim();
			String emailId = forgotVO.getEmail();
			
			String emptyUsername = MessageUtil.getMessage("error.required.UserName");
			String emptyEmail = MessageUtil.getMessage("error.required.email");
			
			if ("".equals(userName)) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", emptyUsername);
			} else if ("".equals(emailId)) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailId", emptyEmail);
			} else if (!(null == emailId || !"".equals(emailId)) && (!isValidEmail(emailId)) ) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", "error.UserNotExist");
			} else {
				if (!"".equals(userName) && !"".equals(emailId)) {
					User usrVO = userService.getUserInfoForgot(userName,emailId);
					String emailDb = usrVO.getEmail();
					String userNameDB = usrVO.getLoginName();
					if (!forgotVO.getEmail().equals(emailDb) &&(!isValidEmail(emailId)) ) {
						errors.rejectValue("email", "error.UserNotExist");
					} else if(null != forgotVO.getUserName() && forgotVO.getUserName().length()>0 && !forgotVO.getUserName().equals(userNameDB)) {
						errors.rejectValue("userName", "error.UserNotExist");
					}
				}
			}
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder("");
		
		
		}
		
	}

	/**
	 * Checks if is valid email.
	 *
	 * @param emailId the email id
	 * @return true, if is valid email
	 */
	public static boolean isValidEmail(String emailId) {
		boolean result = false;
		Pattern emailPattern = Pattern.compile(validEmailPattern);
		Matcher emailMatcher = emailPattern.matcher(emailId);
		result = emailMatcher.matches();
		return result;
	}

	/**
	 * Check email for special chars.
	 *
	 * @param emailId the email id
	 * @return true, if successful
	 */
	public static boolean checkEmailForSpecialChars(String emailId) {
		Pattern invalidCharPattern = Pattern.compile(invaliChars);
		Matcher invalidCharMatcher = invalidCharPattern.matcher(emailId);
		if (invalidCharMatcher.find()) {
			return false;
		} else {
			return true;
		}
	}
}
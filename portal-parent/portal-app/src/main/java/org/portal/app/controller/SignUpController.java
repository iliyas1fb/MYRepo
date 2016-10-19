/**
 * 
 */
package org.portal.app.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.business.service.UserService;
import org.common.service.MailVO;
import org.common.service.NewRandomPwd;
import org.common.service.SignUp;
import org.common.service.ForgotPassword;
import org.common.service.util.PortalConstants;
import org.common.service.util.PortalUtil;
import org.common.service.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author iliyasm
 *
 */

@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String initForm(@ModelAttribute("signUp") SignUp signUp, BindingResult result, ModelMap model) {
		
		String methodName = "initForm";
		
		return "signup";
	}
	
	
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
	@RequestMapping(value = "/customerSubmit", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("signUp") SignUp signUp, BindingResult result, SessionStatus status,
			HttpServletRequest req, HttpServletResponse resp) {
		
		String methodName = "processSubmit";
		
		StringBuilder sb = new StringBuilder();

			
			try {
				
				
				SignUp sup = new SignUp();
				sup.setUserName(signUp.getUserName());
				sup.setEmail(signUp.getEmail());
				sup.setFirstName(signUp.getFirstName());
				sup.setLastName(signUp.getLastName());
				sup.setPassword(signUp.getPassword());
				sup.setPhoneNumber(signUp.getPhoneNumber());
				
				userService.signUpSystem(sup);
				
				req.setAttribute("Success", "1");
				
			} /*catch (PortalServiceException pse) {
			
				StringBuilder errorBuffer = new StringBuilder();
			
				result.rejectValue("email", pse.getErrorCode());
			
			}*/ catch (Exception ex) {
				
				StringBuilder errorBuffer = new StringBuilder();
				
			//	result.rejectValue("email", ErrorCodeConstants.OMNYPAY_SYSTEM_ERROR);
			}
			
			return "signup";
		//}
	}

}

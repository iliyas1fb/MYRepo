package org.business.service;

import java.util.List;
import java.util.Map;

import org.common.service.NewRandomPwd;
import org.common.service.Permission;
import org.common.service.SignUp;
import org.common.service.User;
import org.exception.service.PortalServiceException;





/**
 * The Interface UserService.
 */
public interface UserService {


	

	/**
	 * Gets the user info forgot.
	 *
	 * @param userName the user name
	 * @param emailId the email id
	 * @return the user info forgot
	 * @throws PortalServiceException
	 */
	 User getUserInfoForgot(String userName,String emailId) throws PortalServiceException;

	
	 
	 
	 /**
		 * Gets the new random password.
		 *
		 * @param type the type
		 * @param userName the user name
		 * @param email the email
		 * @return the new random password
		 * @throws PortalServiceException
		 */
	NewRandomPwd getNewRandomPassword(String type, String userName,String email) throws PortalServiceException;
	
	
	
	/**
	 * Gets the user info.
	 *
	 * @param userName the user name
	 * @return the user info
	 * @throws PortalServiceException
	 */
	User getUserInfo(String userName) throws PortalServiceException;
	
	
	
	
	
	/* * Gets the permission vo list.
	 *
	 * @param userName the user name
	 * @return the permission vo list
	 * @throws PortalServiceException
	 */
	 List<Permission> getPermissionVOList(String userName) throws PortalServiceException;
	 
	 
	 
	 
	 /**
	   * Gets the permission vo list.
		 *
		 * @param userName the user name
		 * @return the permission vo list
		 * @throws OMNYPAYServiceException
		 */
	 	List<Permission> getPermissionBaseOnHeriarchy(Long herType) throws PortalServiceException;

		
	 
	 	/**
		 * Gets the user info forgot.
		 *
		 * @param userName the user name
		 * @param emailId the email id
		 * @return the user info forgot
		 * @throws PortalServiceException
		 */
	
	 Integer signUpSystem(SignUp SignUp) throws PortalServiceException;
	 
	 
	

}

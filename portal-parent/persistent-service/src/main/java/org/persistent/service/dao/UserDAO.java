package org.persistent.service.dao;


import java.util.List;

import org.common.service.NewRandomPwd;
import org.common.service.Permission;
import org.common.service.SignUp;
import org.common.service.User;
import org.exception.service.PortalDAException;
import org.persistent.service.pojo.PortalSvrUserAccount;
import org.persistent.service.pojo.PortalSvrUserPermission;





/**
 * The Interface UserDAO handles the functionalities for User.
 */
 public interface UserDAO {
	
	/**
	 * Gets the new random password.
	 *
	 * @param type the type
	 * @param userName the user name
	 * @param email the email
	 * @return the new random password
	 * @throws PortalDAException
	 */
	 NewRandomPwd getNewRandomPassword(String type, String userName,String email) throws PortalDAException;

	/**
	 * Change pwd.
	 *
	 * @param type the type
	 * @param userName the user name
	 * @param encPwd the enc pwd
	 * @return the change pwd sp to
	 * @throws PortalDAException
	 */
	 //ChangePwdSpTO changePwd(String type, String userName, String encPwd)
		//	throws DCSDAException;

	/**
	 * Update last login date.
	 *
	 * @param userName the user name
	 * @return the update last login date to
	 * @throws PortalDAException
	 */
	 //UpdateLastLoginDateTO updateLastLoginDate(String userName)
		//	throws DCSDAException;

	/**
	 * Gets the user info.
	 *
	 * @param userName the user name
	 * @return the user info
	 * @throws PortalDAException
	 */
	 PortalSvrUserAccount getUserInfo(String userName) throws PortalDAException;
	
	/**
	 * Gets the user info.
	 *
	 * @param userName the user name
	 * @return the user info
	 * @throws PortalDAException
	 */
	// SecUserRequestObject getUserInfoStatus(String userName) throws PortalDAException;
	
	
	/**
	 * Gets the user info forgot.
	 *
	 * @param userName the user name
	 * @param emailId the email id
	 * @return the user info forgot
	 * @throws PortalDAException
	 */
	 User getUserInfoForgot(String userName,String emailId) throws PortalDAException;

	/**
	 * Gets the group list.
	 *
	 * @param userName the user name
	 * @return the group list
	 * @throws PortalDAException
	 */
	 //List<GroupVO> getGroupList(String userName) throws DCSDAException;
	
	/**
	 * Reset bad login count.
	 *
	 * @param count the count
	 * @param loginName the login name
	 * @return the int
	 * @throws PortalDAException
	 */
	 //int resetBadLoginCount(int count, String loginName)
		//	throws DCSDAException;
	
	/**
	 * Gets the permission vo list.
	 *
	 * @param userName the user name
	 * @return the permission vo list
	 * @throws PortalDAException
	 */
	 List<PortalSvrUserPermission> getPermissionVOList(String userName) throws PortalDAException;
	
	/**
	 * Gets the permission vo list.
	 *
	 * @param herType the her type
	 * @return the permission vo list
	 * @throws PortalDAException
	 */
	 List<PortalSvrUserPermission> getPermissionBaseOnHeriarchy(Long herType) throws PortalDAException;
	
	/**
	 * Gets the UserVO list.
	 *
	 * @param userVO the user vo
	 * @return the UserVO list
	 * @throws PortalDAException
	 */
	// List<UserRequestObject> getUserInfoList(UserRequestObject userVO) throws PortalDAException;
	
	/**
	 * Gets the UserVO list.
	 *
	 * @param userVO the user vo
	 * @return the UserVO
	 * @throws PortalDAException
	 */
	 //UserRequestObject createUser(UserRequestObject userVO) throws PortalDAException;
	
	/**
	 * Gets the UserVO list.
	 *
	 * @param userVO the user vo
	 * @return the UserVO
	 * @throws PortalDAException
	 */
	 //UserVO updateUser(UserVO userVO) throws DCSDAException;
	
	
	/**
	 * Gets the UserVO list.
	 *
	 * @param heirarchyId the heirarchy id
	 * @return the Map<String, Object>
	 * @throws PortalDAException
	 */
	// Map<String, Object> getHeirrcyRolesEntities(Long heirarchyId,String function) throws PortalDAException;
	
	/**
	 * @param userName
	 * @param email
	 * @param encPwd
	 * @param type
	 * @return
	 * @throws PortalDAException
	 */
	 //ChangePwdSpTO forgotPassword(String userName,String email,String encPwd,String type) throws DCSDAException;
	 
	/**
		 * @param userName
		 * @param email
		 * @param encPwd
		 * @param type
		 * @return
		 * @throws PortalDAException
		 */
	 Integer signUpSystem(PortalSvrUserAccount portalSvrUserAccount) throws PortalDAException;
}
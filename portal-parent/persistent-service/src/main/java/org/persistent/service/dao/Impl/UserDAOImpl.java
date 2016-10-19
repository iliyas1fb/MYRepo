package org.persistent.service.dao.Impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.common.service.Group;
import org.common.service.NewRandomPwd;
import org.common.service.Permission;
import org.common.service.User;
import org.exception.service.PortalDAException;
import org.hibernate.SessionFactory;
import org.persistent.service.dao.UserDAO;
import org.persistent.service.pojo.PortalSvrUserAccount;
import org.persistent.service.pojo.PortalSvrUserPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;







/**
 * The Class UserDAOImpl handles the functionalities for User.
 */
public class UserDAOImpl implements UserDAO {

	/** The LOGGER. */
	//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

	/** The CLAS s_ name. */
	private final String className = this.getClass().getName();

	/** The HibernateTemplate. */
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	
	
	

	/** The reset bad count. */
	private String resetBadCount;

	/**
	 * Gets the reset bad count.
	 *
	 * @return the reset bad count
	 */
	public String getResetBadCount() {
		return resetBadCount;
	}

	/**
	 * Sets the reset bad count.
	 *
	 * @param resetBadCount the new reset bad count
	 */
	public void setResetBadCount(String resetBadCount) {
		this.resetBadCount = resetBadCount;
	}

/*	*//**
	 * Gets the jdbc template.
	 *
	 * @return the jdbc template
	 */
/*	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	*//**
	 * Sets the jdbc template.
	 *
	 * @param jdbcTemplate the new jdbc template
	 *//*
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.DCS.webui.security.dao.UserDAO#getNewRandomPassword(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	public NewRandomPwd getNewRandomPassword(String type, String userName,
			String email) throws PortalDAException {
		String methodName = "getNewRandomPassword";
		NewRandomPwd pwdTO = new NewRandomPwd();
		//@SuppressWarnings("unused")
		//ChangePwdSpTO pwdSpTO = new ChangePwdSpTO();
		try {
			//hibernateTemplate.find(queryString);
			///GetNewRandomPwdSP procedure = new GetNewRandomPwdSP(jdbcTemplate);
			//pwdTO = procedure.execute(userName, email);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			

		} /*catch (PortalDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			

		}*/ catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			
		}
		

		return pwdTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#changePwd(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	/*public ChangePwdSpTO changePwd(String type, String userName, String encPwd)
			throws DCSDAException {

		String methodName = "changePwd";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("type=").append(type).append(DCSConstants.COMMA)
				.append("Arg userName=").append(userName).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));
		ChangePwdSpTO spTO = new ChangePwdSpTO();
		String encryptedPwd = null;
		try {

			encryptedPwd = ShaHashEncoder.encodeShaHash(encPwd);
			ChangePwdSP procedure = new ChangePwdSP(jdbcTemplate);
			spTO = procedure.execute(type, userName, encryptedPwd);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.CHANGE_PASSWORD).append(DCSConstants.COMMA)
					.append("Error Message : ").append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.CHANGE_PASSWORD,edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DCSDAException occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
					.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.CHANGE_PASSWORD).append(DCSConstants.COMMA)
					.append("Error Message : ").append(ex.getMessage());

			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.CHANGE_PASSWORD,ex.getMessage());
		}
		sb.append("ChangePwdSpTO : ").append(spTO.toString()).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));

		return spTO;
	}*/
	
	/*public ChangePwdSpTO forgotPassword(String userName,String email,String encPwd,String type)
			throws DCSDAException {

		String methodName = "forgotPassword";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("type=").append(type).append(DCSConstants.COMMA)
				.append("Arg userName=").append(userName).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));
		ChangePwdSpTO spTO = new ChangePwdSpTO();
		String encryptedPwd = null;
		try {

			encryptedPwd = ShaHashEncoder.encodeShaHash(encPwd);
			ForgorPasswordChangedSP procedure = new ForgorPasswordChangedSP(jdbcTemplate);
			spTO = procedure.execute(userName,email,encryptedPwd,type);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.CHANGE_PASSWORD).append(DCSConstants.COMMA)
					.append("Error Message : ").append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.CHANGE_PASSWORD,edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DCSDAException occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
					.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the ChangePwdSpTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.CHANGE_PASSWORD).append(DCSConstants.COMMA)
					.append("Error Message : ").append(ex.getMessage());

			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.CHANGE_PASSWORD,ex.getMessage());

		}
		sb.append("ChangePwdSpTO : ").append(spTO.toString()).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));

		return spTO;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.DCS.webui.security.dao.UserDAO#updateLastLoginDate(java.lang.String
	 * )
	 */
	/*public UpdateLastLoginDateTO updateLastLoginDate(String userName)
			throws DCSDAException {
		String methodName = "updateLastLoginDate";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("userName=").append(userName).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));

		UpdateLastLoginDateTO infoTO = new UpdateLastLoginDateTO();
		try {

			UpdateLoginDateSP procedure = new UpdateLoginDateSP(jdbcTemplate);
			infoTO = procedure.execute(userName);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while getting the UpdateLastLoginDateTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.UPDATE_LOGIN_DATE).append(DCSConstants.COMMA)
					.append("Error Message : ").append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.UPDATE_LOGIN_DATE,edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DCSDAException occurred while getting the UpdateLastLoginDateTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
					.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the UpdateLastLoginDateTO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.UPDATE_LOGIN_DATE).append(DCSConstants.COMMA)
					.append("Error Message : ").append(ex.getMessage());

			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.UPDATE_LOGIN_DATE,ex.getMessage());
		}
		sb.append("UpdateLastLoginDateTO : ").append(infoTO.toString())
				.append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return infoTO;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfo(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public PortalSvrUserAccount getUserInfo(String userName) throws PortalDAException {

		String methodName = "getUserInfo";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
		//		.append("userName=").append(userName).append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));
		PortalSvrUserAccount userVO = null;
		List<Group> groupList = new ArrayList<Group>();
		String groupName = null;
		List<String> groups = new ArrayList<String>();
		List<PortalSvrUserAccount> accountList  = new  ArrayList<PortalSvrUserAccount>();
		try {
			
			StringBuilder queryString = new StringBuilder("from PortalSvrUserAccount c where c.loginname= '").append(userName).append("'");
			
			 accountList = (List<PortalSvrUserAccount>)hibernateTemplate.find(queryString.toString());
			
			 if (accountList != null && accountList.size()!=0 ){
				 
				 userVO = accountList.get(0);
			 } 
			
			
			/*UserInfoSP procedure = new UserInfoSP(jdbcTemplate);
			userVO = procedure.execute(userName);
			GroupListSP groupListSP = new GroupListSP(jdbcTemplate);
			groupList = groupListSP.execute(userName);
			for (GroupRequestObject vo : groupList) {
				groupName = vo.getGroupName();
				groups.add(groupName);
			}
			userVO.setGroups(groups);*/

		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("DataAccessException occurred while getting the SecUserVO")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.USER_INFO).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.USER_INFO,edae.getMessage());

		} /*catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("DCSDAException occurred while getting the SecUserVO")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			//throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		}*/ catch (Exception ex) {
			//StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("Exception occurred while getting the SecUserVO")
				//	.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
				//	.append(ErrorCodeConstants.USER_INFO).append(DCSConstants.COMMA)
				//	.append("Error Message : ").append(ex.getMessage());

			//LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.USER_INFO,ex.getMessage());
		}
		//sb.append("SecUserVO : ").append(userVO.toString()).append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return userVO;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfo(java.lang.String)
	 */
	/*public SecUserRequestObject getUserInfoStatus(String userName) throws DCSDAException {
		
		String methodName = "getUserInfoStatus";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
							  .append("userName=").append(userName)
							  .append(DCSConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));
		SecUserRequestObject userVO = null;
		try {
			UserInfoStatusSP procedure = new UserInfoStatusSP(jdbcTemplate);
			userVO = procedure.execute(userName);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("DataAccessException occurred while getting the SecUserVO")
			//		   .append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		   .append(ErrorCodeConstants.USER_INFO).append(DCSConstants.COMMA)
			//		   .append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.USER_INFO,edae.getMessage());
		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("DCSDAException occurred while getting the SecUserVO")
			//.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
			//.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer.append("Exception occurred while getting the SecUserVO")
			//		   .append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		   .append(ErrorCodeConstants.USER_INFO).append(DCSConstants.COMMA)
			//		   .append("Error Message : ").append(ex.getMessage());
		//	LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.USER_INFO,ex.getMessage());
		}
		//sb.append("SecUserVO : ").append(userVO.toString()).append(DCSConstants.COMMA);
		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return userVO;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfo(java.lang.String)
	 */
	public User getUserInfoForgot(String userName,String emailId) throws PortalDAException {

		String methodName = "getUserInfoForgot";
		
		User userVO = null;
		try {
			//GetUserInfoForGotSP procedure = new GetUserInfoForGotSP(jdbcTemplate);
			//userVO = procedure.execute(userName,emailId);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			
		}/* catch (PortalDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			
		}*/ catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			
		}
		
		return userVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#resetBadLoginCount(int,
	 * java.lang.String)
	 */
/*	public int resetBadLoginCount(int count, String loginName)
			throws DCSDAException {

		String methodName = "resetBadLoginCount";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("count=").append(count).append(DCSConstants.COMMA)
				.append("loginName=").append(loginName).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));

		int updateCount = 0;
		Object[] parameters = new Object[] { Integer.valueOf(count), loginName };

		try {
			updateCount = jdbcTemplate.update(resetBadCount, parameters);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while getting the resetBadLoginCount")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.RESET_BADLOGIN_COUNT)
					.append(DCSConstants.COMMA).append("Error Message : ")
					.append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.RESET_BADLOGIN_COUNT,edae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the resetBadLoginCount")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.RESET_BADLOGIN_COUNT)
					.append(DCSConstants.COMMA).append("Error Message : ")
					.append(ex.getMessage());

			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.RESET_BADLOGIN_COUNT,ex.getMessage());

		}
		sb.append("List<BankInfo> : ").append(updateCount).append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));

		return updateCount;
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.DCS.webui.security.dao.UserDAO#getGroupList(java.lang.String)
	 */
	/*public List<GroupVO> getGroupList(String userName) throws DCSDAException {

		String methodName = "resetBadLoginCount";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("userName=").append(userName).append(DCSConstants.COMMA);

		List<GroupVO> groupList = null;
		try {
			GroupListSP procedure = new GroupListSP(jdbcTemplate);
			groupList = procedure.execute(userName);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while getting the  List<GroupVO>")
					.append(DCSConstants.COMMA).append(sb);
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(DCSDAErrorCodes.TXNUSER_INSERT,
					edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DCSDAException occurred while getting the  List<GroupVO>")
					.append(DCSConstants.COMMA).append(sb);
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the  List<GroupVO>")
					.append(DCSConstants.COMMA).append(sb);
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(DCSDAErrorCodes.TXNUSER_INSERT,
					ex.getMessage());

		}
		sb.append(" List<GroupVO> : size").append(groupList.size())
				.append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));

		return groupList;
	}*/

	/* (non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getPermissionVOList(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<PortalSvrUserPermission> getPermissionVOList(String userName)
			throws PortalDAException {

		String methodName = "getPermissionList";
		//LogDetails logDetails = LogDetails.getInstance();
		//StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
		//		.append("userName=").append(userName).append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));

		List<PortalSvrUserPermission> permissionList = null;
		try {
			
			
			StringBuilder queryString = new StringBuilder("from PortalSvrUserPermission c ");
			
			permissionList = (List<PortalSvrUserPermission>)hibernateTemplate.find(queryString.toString());
			
		/**/
		
		
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DataAccessException occurred while getting the List<PermissionVO>")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.PERMISSION_LIST).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.PERMISSION_LIST,edae.getMessage());

		}/* catch (PortalDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DCSDAException occurred while getting the List<PermissionVO>")
			///		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new PortalDAException(pdae.getErrorCode(), pdae.getMessage());

		}*/ catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("Exception occurred while getting the List<PermissionVO>")
		//			.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.PERMISSION_LIST).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(ex.getMessage());

			//LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.PERMISSION_LIST,ex.getMessage());

		}
		//sb.append("List<PermissionVO> : ").append(permissionList.toString())
		//		.append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return permissionList;
	}

	
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getPermissionVOList(java.lang.String)
	 */
	
	public Integer signUpSystem(PortalSvrUserAccount portalSvrUserAccount) throws PortalDAException {
		// TODO Auto-generated method stub
		String methodName = "signUpSystem";
		Integer entityId = 0;
		
		try {
			portalSvrUserAccount.setCreateddate(new Timestamp(System.currentTimeMillis()));
			portalSvrUserAccount.setIsloggedin("N");
			//for customer
			portalSvrUserAccount.setHeirarcytype(420L);
			hibernateTemplate.save(portalSvrUserAccount);
			entityId =  1;
			}catch (DataAccessException edae) {
		
			} /*catch (PortalDAException pdae) {
			
			}*/ catch (Exception ex) {
			
			}		
		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));		
		return entityId;
	}
	
	
	 
	public List<PortalSvrUserPermission> getPermissionBaseOnHeriarchy(Long herType)
			throws PortalDAException {

		String methodName = "getPermissionBaseOnHeriarchy";
	

		List<PortalSvrUserPermission> permissionList = new ArrayList<PortalSvrUserPermission>();
		try {
			
			
			StringBuilder queryString = new StringBuilder("from PortalSvrUserPermission c where c.hierarchyType= ").append(herType);
			
			permissionList = (List<PortalSvrUserPermission>)hibernateTemplate.find(queryString.toString());
			
			
			//GetPermissionBaseOnHiarchySP procedure = new GetPermissionBaseOnHiarchySP(jdbcTemplate);
			//permissionList = procedure.execute(herType);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			

		}/* catch (PortalDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			

		}*/ catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			
		}
		
		return permissionList;
	}

	 /*(non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfoList(UserVO)
	 
	public List<UserRequestObject> getUserInfoList(UserRequestObject userVO)
			throws DCSDAException {

		String methodName = "getUserInfoList";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
		//		.append("UserVO=").append(userVO).append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));

		List<UserRequestObject> userVOList = new ArrayList<UserRequestObject>();
		try {
			GetUserInfosp procedure = new GetUserInfosp(jdbcTemplate);
			userVOList = procedure.execute(userVO);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DataAccessException occurred while getting the List<UserVO>")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.GET_USER_INFO).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.GET_USER_INFO,edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DCSDAException occurred while getting the List<UserVO>")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			//throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("Exception occurred while getting the List<UserVO>")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.GET_USER_INFO).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(ex.getMessage());

			//LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.GET_USER_INFO,
			//		ex.getMessage());

		}
		//sb.append("List<UserVO> : ").append(userVO.toString()).append(DCSConstants.COMMA);
		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return userVOList;
	}

	 (non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfoList(UserVO)
	 

	public UserRequestObject createUser(UserRequestObject userVO)
			throws DCSDAException {


		String methodName = "createUser";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();

		///sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		//		.append("UserVO=").append(userVO).append(OMNYPAYConstants.COMMA);

	

		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));


		UserRequestObject userVO2 = null;
		try {
			AddUserSP procedure = new AddUserSP(jdbcTemplate);
			userVO2 = procedure.execute(userVO);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DataAccessException occurred while inserting the UserVO")
			//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.CREATE_USER_INFO).append(OMNYPAYConstants.COMMA)
			//		.append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new OMNYPAYDAException(ErrorCodeConstants.CREATE_USER_INFO,
			//		edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();

			//errorBuffer
			////		.append("OMNYPAYDAException occurred while inserting the UserVO")
			//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			//		.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			//throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());


		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();

			//errorBuffer
			//		.append("Exception occurred while inserting the UserVO")
			//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.CREATE_USER_INFO).append(OMNYPAYConstants.COMMA)
			//		.append("Error Message : ").append(ex.getMessage());

			//LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new OMNYPAYDAException(ErrorCodeConstants.CREATE_USER_INFO,
			//		ex.getMessage());


		}

		//sb.append("List<UserVO> : ").append(userVO.toString())
		//		.append(OMNYPAYConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));

		return userVO2;
	}
		
	 (non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getUserInfoList(UserVO)
	 
	public UserVO updateUser(UserVO userVO)
			throws DCSDAException {
		String methodName = "updateUser";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
				.append("UserVO=").append(userVO).append(DCSConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));
		UserVO userVO2 = null;
		try {
			UpdateUserSP procedure = new UpdateUserSP(jdbcTemplate);
			userVO2 = procedure.execute(userVO);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DataAccessException occurred while updating the UserVO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.UPDATE_USER_INFO).append(DCSConstants.COMMA)
					.append("Error Message : ").append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.UPDATE_USER_INFO,
					edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("DCSDAException occurred while updating the UserVO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
					.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while updating the UserVO")
					.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.UPDATE_USER_INFO).append(DCSConstants.COMMA)
					.append("Error Message : ").append(ex.getMessage());

			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new DCSDAException(ErrorCodeConstants.UPDATE_USER_INFO,
	 			ex.getMessage());

		}
		sb.append("UserVO : ").append(userVO.toString())
				.append(DCSConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return userVO2;
	}
	
	 (non-Javadoc)
	 * @see com.DCS.webui.security.dao.UserDAO#getHeirrcyRolesEntities(Long)
	 
	public Map<String, Object> getHeirrcyRolesEntities(Long heirarchyId,String function)
			throws DCSDAException{

		String methodName = "getHeirrcyRolesEntities";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(DCSConstants.COMMA)
		//		.append("heirarchyId=").append(heirarchyId).append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_ENTRY));

		Map<String, Object> heirrcyRolesEntitieMap= null;
		try {
			GetHeirrcyRolesEntitiesSP procedure = new GetHeirrcyRolesEntitiesSP(jdbcTemplate);
			heirrcyRolesEntitieMap = procedure.execute(heirarchyId, function);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("DataAccessException occurred while getting  the HeirrcyRolesEntities")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.GET_HR_ENTITY).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(edae.getMessage());
			//LOGGER.error(className, methodName, edae, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.GET_HR_ENTITY,edae.getMessage());

		} catch (DCSDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//.append("DCSDAException occurred while getting  the HeirrcyRolesEntities")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(pdae.getErrorCode()).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(pdae.getMessage());
			//LOGGER.error(className, methodName, pdae, errorBuffer);
			//throw new DCSDAException(pdae.getErrorCode(), pdae.getMessage());

		}catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			//errorBuffer
			//		.append("Exception occurred while getting the HeirrcyRolesEntities")
			//		.append(DCSConstants.COMMA).append(sb).append("Error Code : ")
			//		.append(ErrorCodeConstants.GET_HR_ENTITY).append(DCSConstants.COMMA)
			//		.append("Error Message : ").append(ex.getMessage());

			//LOGGER.error(className, methodName, ex, errorBuffer);
			//throw new DCSDAException(ErrorCodeConstants.GET_HR_ENTITY,	ex.getMessage());

		}
		//sb.append("heirrcyRolesEntitieMap: size ").append(heirrcyRolesEntitieMap.size())
		//		.append(DCSConstants.COMMA);

		//LOGGER.debug(className, methodName, sb.toString().concat(DCSConstants.LOG_EXIT));
		return heirrcyRolesEntitieMap;
	}
	*/
	
	
	
	
	
}
package org.common.service;

import java.io.Serializable;

/**
 * The Class NewRandomPwdTO.
 */
public class NewRandomPwd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8247988919683745467L;

	/** The new pwd. */
	private String newPwd;

	/** The error code. */
	private String errorCode;

	/** The error msg. */
	private String errorMsg;
	
	private String userName;
	
	private String emailId;
	
	private String userFirstName;
	private String userLastName;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the new pwd.
	 *
	 * @return the new pwd
	 */
	public String getNewPwd() {
		return newPwd;
	}

	/**
	 * Sets the new pwd.
	 *
	 * @param newPwd the new new pwd
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Sets the error msg.
	 *
	 * @param errorMsg the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}

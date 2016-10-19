package org.common.service;

import java.io.Serializable;

/**
 * The Class ForgotPasswordVO.
 */
public class ForgotPassword implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8848645005458489155L;

	/** The user name. */
	private String userName;

	/** The email. */
	private String email;
	
	private String phoneNumber;
	
	private String password;
	
	private String confirmPassword;
	
	private String valForReset;
	
	String resetPassValString;

	/**
	 * Sets the user name.
	 * 
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getValForReset() {
		return valForReset;
	}

	public void setValForReset(String valForReset) {
		this.valForReset = valForReset;
	}

	public String getResetPassValString() {
		return resetPassValString;
	}

	public void setResetPassValString(String resetPassValString) {
		this.resetPassValString = resetPassValString;
	}
	
	

}
package org.common.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class SecUserVO.
 */
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8443234918260997954L;

	/** The rights. */
	private List<String> rights = null;

	/** The groups. */
	private List<String> groups = null;
	
	/** The perm vo list. */
	private List<Permission> permVOList;

	/** The user id. */
	private String userId;

	/** The login name. */
	private String loginName;
	
	/** The original login name. */
	private String originalLoginName;

	/** The last name. */
	private String lastName;

	/** The first name. */
	private String firstName;

	/** The email. */
	private String email;

	/** The local. */
	private String local;

	/** The status. */
	private String status;
	/** The isLoggedIn. */
	private String isLoggedIn;

	
	/** The account expired. */
	private String accountExpired;

	/** The credentials expired. */
	private String credentialsExpired;

	/** The is internal. */
	private String isInternal;

	/** The account locked. */
	private String accountLocked;

	/** The last bad login. */
	private String lastBadLogin;

	/** The bad login count. */
	private int badLoginCount;

	/** The pass change date. */
	private Timestamp passChangeDate;

	/** The last login date. */
	private Timestamp lastLoginDate;

	/** The reports to. */
	private int reportsTo;

	/** The phone number. */
	private String phoneNumber;

	/** The sec question id. */
	private int secQuestionId;

	/** The sec question answer. */
	private String secQuestionAnswer;

	/** The created by. */
	private Long createdBy;

	/** The created date. */
	private Timestamp createdDate;

	/** The modified by. */
	private int modifiedBy;

	/** The modified date. */
	private Timestamp modifiedDate;

	/** The password. */
	private String password;

	/** The role name. */
	private String roleName;

	/** The permission name. */
	private String permissionName;

	/** The pass type. */
	private String passType;

	/** The error msg. */
	private String errorMsg;

	/** The error code. */
	private String errorCode;

	/** The sub role name. */
	private String subRoleName;
	
	private String ipAddress;

	private String sponsorBank;
	
	private String isActive;
	
	/**
	 * Instantiates a new sec user vo.
	 */
	public User() {
		setRights(new ArrayList<String>());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecUserVO [rights=" + rights + ", groups=" + groups
				+ ", permVOList=" + permVOList + ", userId=" + userId
				+ ", loginName=" + loginName + ", originalLoginName="
				+ originalLoginName + ", lastName=" + lastName + ", firstName="
				+ firstName + ", email=" + email + ", local=" + local
				+ ", status=" + status + ", accountExpired=" + accountExpired
				+ ", credentialsExpired=" + credentialsExpired
				+ ", isInternal=" + isInternal + ", accountLocked="
				+ accountLocked + ", lastBadLogin=" + lastBadLogin
				+ ", badLoginCount=" + badLoginCount + ", passChangeDate="
				+ passChangeDate + ", lastLoginDate=" + lastLoginDate
				+ ", reportsTo=" + reportsTo + ", phoneNumber=" + phoneNumber
				+ ", secQuestionId=" + secQuestionId + ", secQuestionAnswer="
				+ secQuestionAnswer + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", password=" + password
				+ ", roleName=" + roleName + ", permissionName="
				+ permissionName + ", passType=" + passType + ", errorMsg="
				+ errorMsg + ", errorCode=" + errorCode + ", subRoleName="
				+ subRoleName + ", isLoggedIn="
				+ isLoggedIn + "]";
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the sub role name.
	 *
	 * @return the sub role name
	 */
	public String getSubRoleName() {
		return subRoleName;
	}

	/**
	 * Sets the sub role name.
	 *
	 * @param subRoleName the new sub role name
	 */
	public void setSubRoleName(String subRoleName) {
		this.subRoleName = subRoleName;
	}

	/**
	 * @return the sponsorBank
	 */
	public String getSponsorBank() {
		return sponsorBank;
	}

	/**
	 * @param sponsorBank the sponsorBank to set
	 */
	public void setSponsorBank(String sponsorBank) {
		this.sponsorBank = sponsorBank;
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
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the login name.
	 *
	 * @return the login name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * Sets the login name.
	 *
	 * @param loginName the new login name
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the local.
	 *
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Sets the local.
	 *
	 * @param local the new local
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the account expired.
	 *
	 * @return the account expired
	 */
	public String getAccountExpired() {
		return accountExpired;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	/**
	 * Sets the account expired.
	 *
	 * @param accountExpired the new account expired
	 */
	public void setAccountExpired(String accountExpired) {
		this.accountExpired = accountExpired;
	}

	/**
	 * Gets the credentials expired.
	 *
	 * @return the credentials expired
	 */
	public String getCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * Sets the credentials expired.
	 *
	 * @param credentialsExpired the new credentials expired
	 */
	public void setCredentialsExpired(String credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	/**
	 * Gets the checks if is internal.
	 *
	 * @return the checks if is internal
	 */
	public String getIsInternal() {
		return isInternal;
	}

	/**
	 * Sets the checks if is internal.
	 *
	 * @param isInternal the new checks if is internal
	 */
	public void setIsInternal(String isInternal) {
		this.isInternal = isInternal;
	}

	/**
	 * Gets the account locked.
	 *
	 * @return the account locked
	 */
	public String getAccountLocked() {
		return accountLocked;
	}

	/**
	 * Sets the account locked.
	 *
	 * @param accountLocked the new account locked
	 */
	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}

	/**
	 * Gets the last bad login.
	 *
	 * @return the last bad login
	 */
	public String getLastBadLogin() {
		return lastBadLogin;
	}

	/**
	 * Sets the last bad login.
	 *
	 * @param lastBadLogin the new last bad login
	 */
	public void setLastBadLogin(String lastBadLogin) {
		this.lastBadLogin = lastBadLogin;
	}

	/**
	 * Gets the bad login count.
	 *
	 * @return the bad login count
	 */
	public int getBadLoginCount() {
		return badLoginCount;
	}

	/**
	 * Sets the bad login count.
	 *
	 * @param badLoginCount the new bad login count
	 */
	public void setBadLoginCount(int badLoginCount) {
		this.badLoginCount = badLoginCount;
	}

	/**
	 * Gets the pass change date.
	 *
	 * @return the pass change date
	 */
	public Timestamp getPassChangeDate() {
		return passChangeDate;
	}

	/**
	 * Sets the pass change date.
	 *
	 * @param passChangeDate the new pass change date
	 */
	public void setPassChangeDate(Timestamp passChangeDate) {
		this.passChangeDate = passChangeDate;
	}

	/**
	 * Gets the last login date.
	 *
	 * @return the last login date
	 */
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * Sets the last login date.
	 *
	 * @param lastLoginDate the new last login date
	 */
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * Gets the reports to.
	 *
	 * @return the reports to
	 */
	public int getReportsTo() {
		return reportsTo;
	}

	/**
	 * Sets the reports to.
	 *
	 * @param reportsTo the new reports to
	 */
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the sec question id.
	 *
	 * @return the sec question id
	 */
	public int getSecQuestionId() {
		return secQuestionId;
	}

	/**
	 * Sets the sec question id.
	 *
	 * @param secQuestionId the new sec question id
	 */
	public void setSecQuestionId(int secQuestionId) {
		this.secQuestionId = secQuestionId;
	}

	/**
	 * Gets the sec question answer.
	 *
	 * @return the sec question answer
	 */
	public String getSecQuestionAnswer() {
		return secQuestionAnswer;
	}

	/**
	 * Sets the sec question answer.
	 *
	 * @param secQuestionAnswer the new sec question answer
	 */
	public void setSecQuestionAnswer(String secQuestionAnswer) {
		this.secQuestionAnswer = secQuestionAnswer;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public int getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified date.
	 *
	 * @return the modified date
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modified date.
	 *
	 * @param modifiedDate the new modified date
	 */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Sets the permission name.
	 *
	 * @param permissionName the new permission name
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * Gets the permission name.
	 *
	 * @return the permission name
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * Sets the rights.
	 *
	 * @param rights the new rights
	 */
	public void setRights(List<String> rights) {
		this.rights = rights;
	}

	/**
	 * Gets the rights.
	 *
	 * @return the rights
	 */
	public List<String> getRights() {
		return rights;
	}

	/**
	 * Sets the pass type.
	 *
	 * @param passType the new pass type
	 */
	public void setPassType(String passType) {
		this.passType = passType;
	}

	/**
	 * Gets the pass type.
	 *
	 * @return the pass type
	 */
	public String getPassType() {
		return passType;
	}

	/**
	 * Sets the groups.
	 *
	 * @param groups the new groups
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/**
	 * Gets the groups.
	 *
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * Sets the perm vo list.
	 *
	 * @param permVOList the new perm vo list
	 */	
	public void setPermVOList(List<Permission> permVOList) {
		this.permVOList = permVOList;
	}

	/**
	 * Gets the perm vo list.
	 *
	 * @return the perm vo list
	 */
	public List<Permission> getPermVOList() {
		return permVOList;
	}

	/**
	 * Sets the original login name.
	 *
	 * @param originalLoginName the new original login name
	 */
	public void setOriginalLoginName(String originalLoginName) {
		this.originalLoginName = originalLoginName;
	}

	/**
	 * Gets the original login name.
	 *
	 * @return the original login name
	 */
	public String getOriginalLoginName() {
		return originalLoginName;
	}

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}

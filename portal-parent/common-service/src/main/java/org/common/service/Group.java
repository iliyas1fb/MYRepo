package org.common.service;

import java.io.Serializable;

/**
 * The Class GroupVO.
 */
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5529278676221807430L;

	/** The group name. */
	private String groupName;

	/** The error msg. */
	private String errorMsg;

	/** The error code. */
	private String errorCode;

	/**
	 * Gets the group name.
	 *
	 * @return the group name
	 */
	public String getGroupName() {
		return groupName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GroupVO [groupName=" + groupName + ", errorMsg=" + errorMsg
				+ ", errorCode=" + errorCode + "]";
	}

	/**
	 * Sets the group name.
	 *
	 * @param groupName the new group name
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

}

package org.common.service;

import java.io.Serializable;
import java.util.List;


/**
 * The Class Permission.
 */
public class Permission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7266732638237733776L;

	/** The permission type. */
	private Long permissionId;
	
	/** The permission type. */
	private String permissionType;
	
	/** The permission desc. */
	private String permissionDesc;
	
	/** The permission name. */
	private String permissionName;
	
	/** The PermissionFunctionalityVO. */
	private List<PermissionFunctionality> permissionFunctionalityVO;
	/** The error msg. */
	private String errorMsg;

	/** The error code. */
	private Long errorCode;

	/**
	 * @return the permissionId
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * @return the permissionType
	 */
	public String getPermissionType() {
		return permissionType;
	}

	/**
	 * @param permissionType the permissionType to set
	 */
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	/**
	 * @return the permissionDesc
	 */
	public String getPermissionDesc() {
		return permissionDesc;
	}

	/**
	 * @param permissionDesc the permissionDesc to set
	 */
	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * @return the permissionFunctionalityVO
	 */
	public List<PermissionFunctionality> getPermissionFunctionalityVO() {
		return permissionFunctionalityVO;
	}

	/**
	 * @param permissionFunctionalityVO the permissionFunctionalityVO to set
	 */
	public void setPermissionFunctionalityVO(
			List<PermissionFunctionality> permissionFunctionalityVO) {
		this.permissionFunctionalityVO = permissionFunctionalityVO;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the errorCode
	 */
	public Long getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorCode == null) ? 0 : errorCode.hashCode());
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result
				+ ((permissionDesc == null) ? 0 : permissionDesc.hashCode());
		result = prime
				* result
				+ ((permissionFunctionalityVO == null) ? 0
						: permissionFunctionalityVO.hashCode());
		result = prime * result
				+ ((permissionId == null) ? 0 : permissionId.hashCode());
		result = prime * result
				+ ((permissionName == null) ? 0 : permissionName.hashCode());
		result = prime * result
				+ ((permissionType == null) ? 0 : permissionType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Permission)) {
			return false;
		}
		Permission other = (Permission) obj;
		if (errorCode == null) {
			if (other.errorCode != null) {
				return false;
			}
		} else if (!errorCode.equals(other.errorCode)) {
			return false;
		}
		if (errorMsg == null) {
			if (other.errorMsg != null) {
				return false;
			}
		} else if (!errorMsg.equals(other.errorMsg)) {
			return false;
		}
		if (permissionDesc == null) {
			if (other.permissionDesc != null) {
				return false;
			}
		} else if (!permissionDesc.equals(other.permissionDesc)) {
			return false;
		}
		if (permissionFunctionalityVO == null) {
			if (other.permissionFunctionalityVO != null) {
				return false;
			}
		} else if (!permissionFunctionalityVO
				.equals(other.permissionFunctionalityVO)) {
			return false;
		}
		if (permissionId == null) {
			if (other.permissionId != null) {
				return false;
			}
		} else if (!permissionId.equals(other.permissionId)) {
			return false;
		}
		if (permissionName == null) {
			if (other.permissionName != null) {
				return false;
			}
		} else if (!permissionName.equals(other.permissionName)) {
			return false;
		}
		if (permissionType == null) {
			if (other.permissionType != null) {
				return false;
			}
		} else if (!permissionType.equals(other.permissionType)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmnypayPermissionVO [permissionId=");
		builder.append(permissionId);
		builder.append(", permissionType=");
		builder.append(permissionType);
		builder.append(", permissionDesc=");
		builder.append(permissionDesc);
		builder.append(", permissionName=");
		builder.append(permissionName);
		builder.append(", permissionFunctionalityVO=");
		builder.append(permissionFunctionalityVO);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append(", errorCode=");
		builder.append(errorCode);
		builder.append("]");
		return builder.toString();
	}

	
}

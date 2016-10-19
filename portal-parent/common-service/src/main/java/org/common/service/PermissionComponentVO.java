package org.common.service;

import java.io.Serializable;

/**
 * The Class PermissionComponent.
 */
public class PermissionComponentVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5235552282503643405L;

	/** The permission type. */
	private Long permissionId;
	
	/** The permission type. */
	private String permissionType;
	
	/** The permission desc. */
	private String permissionDesc;
	
	/** The permission name. */
	private String permissionName;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((permissionDesc == null) ? 0 : permissionDesc.hashCode());
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
		if (!(obj instanceof PermissionComponentVO)) {
			return false;
		}
		PermissionComponentVO other = (PermissionComponentVO) obj;
		if (permissionDesc == null) {
			if (other.permissionDesc != null) {
				return false;
			}
		} else if (!permissionDesc.equals(other.permissionDesc)) {
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
		builder.append("PermissionComponentVO [permissionId=");
		builder.append(permissionId);
		builder.append(", permissionType=");
		builder.append(permissionType);
		builder.append(", permissionDesc=");
		builder.append(permissionDesc);
		builder.append(", permissionName=");
		builder.append(permissionName);
		builder.append("]");
		return builder.toString();
	}
	
	
}

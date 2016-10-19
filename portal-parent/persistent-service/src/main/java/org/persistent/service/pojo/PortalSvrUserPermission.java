/**
 * 
 */
package org.persistent.service.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author iliyasm
 *
 */

@Entity
@Table(name="PORTAL_SVR_USERPERMISSION")
public class PortalSvrUserPermission  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="permission_id")
	private long pId;
	
	@Column(name="permission_type")
	private String pType;
	
	@Column(name="permission_name")
	private String pName;
	
	@Column(name="status")
	private long status;
	
	@Column(name="created_by")
	private long createdBy;
	
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	
	
	@Column(name="permission_description")
	private String pDescription;
	
	
	
	@Column(name="seq")
	private long seq;
	
	@Column(name="hierarchy_type")
	private long hierarchyType;
	
	/*@Column(name="parent_id" ,nullable = true )
	@Null
	private long parentId;
	*/
	
	//constructor
	public PortalSvrUserPermission() {
	}


	/**
	 * @return the pId
	 */
	public long getpId() {
		return pId;
	}


	/**
	 * @param pId the pId to set
	 */
	public void setpId(long pId) {
		this.pId = pId;
	}


	/**
	 * @return the pType
	 */
	public String getpType() {
		return pType;
	}


	/**
	 * @param pType the pType to set
	 */
	public void setpType(String pType) {
		this.pType = pType;
	}


	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}


	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}


	/**
	 * @return the status
	 */
	public long getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(long status) {
		this.status = status;
	}


	/**
	 * @return the createdBy
	 */
	public long getCreatedBy() {
		return createdBy;
	}


	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}


	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	

	/**
	 * @return the pDescription
	 */
	public String getpDescription() {
		return pDescription;
	}


	/**
	 * @param pDescription the pDescription to set
	 */
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}


	/**
	 * @return the seq
	 */
	public long getSeq() {
		return seq;
	}


	/**
	 * @param seq the seq to set
	 */
	public void setSeq(long seq) {
		this.seq = seq;
	}


	/**
	 * @return the hierarchyType
	 */
	public long getHierarchyType() {
		return hierarchyType;
	}


	/**
	 * @param hierarchyType the hierarchyType to set
	 */
	public void setHierarchyType(long hierarchyType) {
		this.hierarchyType = hierarchyType;
	}


/*	*//**
	 * @return the parentId
	 *//*
	public long getParentId() {
		return parentId;
	}


	*//**
	 * @param parentId the parentId to set
	 *//*
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}*/
	
	
	

}

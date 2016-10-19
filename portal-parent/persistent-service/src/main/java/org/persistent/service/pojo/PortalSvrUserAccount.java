package org.persistent.service.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author iliyasm
 *
 */
@Entity
@Table(name="PORTAL_SVR_USERACCOUNT")
public class PortalSvrUserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MyAccount", sequenceName = "USERACCOUNT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MyAccount")
	@Column(name="usr_id")
	private long usrId;
	
	@Column(name="usr_loginname")
	private String loginname;
	
	@Column(name="usr_firstname")
	private String firstname;
	
	@Column(name="usr_lastname")
	private String lastname;
	
	@Column(name="usr_email")
	private String email;
	
		
	@Column(name="badlogincount")
	private long badlogincount;
	
	@Column(name="phone_number")
	private String phonenumber;
	
	
	@Column(name="created_by")
	private long createdby;
	
		
	@Column(name="created_date")
	private Timestamp createddate;
	
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="heirarcy_type")
	private Long heirarcytype;
	
	
	@Column(name="isloggedin")
	private String isloggedin;
	
	
	//constructor
	public PortalSvrUserAccount() {
	}


	/**
	 * @return the usrId
	 */
	public long getUsrId() {
		return usrId;
	}


	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(long usrId) {
		this.usrId = usrId;
	}


	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}


	/**
	 * @param loginname the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}


	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the badlogincount
	 */
	public long getBadlogincount() {
		return badlogincount;
	}


	/**
	 * @param badlogincount the badlogincount to set
	 */
	public void setBadlogincount(long badlogincount) {
		this.badlogincount = badlogincount;
	}


	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}


	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	/**
	 * @return the createdby
	 */
	public long getCreatedby() {
		return createdby;
	}


	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}


	/**
	 * @return the createddate
	 */
	public Timestamp getCreateddate() {
		return createddate;
	}


	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the heirarcytype
	 */
	public Long getHeirarcytype() {
		return heirarcytype;
	}


	/**
	 * @param heirarcytype the heirarcytype to set
	 */
	public void setHeirarcytype(Long heirarcytype) {
		this.heirarcytype = heirarcytype;
	}


	/**
	 * @return the isloggedin
	 */
	public String getIsloggedin() {
		return isloggedin;
	}


	/**
	 * @param isloggedin the isloggedin to set
	 */
	public void setIsloggedin(String isloggedin) {
		this.isloggedin = isloggedin;
	}

	
	
	
	
	
	


	
	
	
	
}

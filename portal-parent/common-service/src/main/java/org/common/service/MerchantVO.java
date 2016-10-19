package org.common.service;

import java.io.Serializable;
import java.util.Date;

public class MerchantVO implements Serializable {
	
	/**
 * 
 */
private static final long serialVersionUID = -7919985697432469756L;


private String businessName;
private String dispalyName;
private String midGenerated;
private String custom;
private String cntctTitle;
private String cntctFirstName;
private String cntctLastName;
private String cntctUserName;
private String cntctPhoneNo;
private String cntctMobileNo;
private String cntctPrimaryEmail;
private String cntctSecondaryEmail;
private String countryAreaCode;
private String mobileCountryAreaCode;
private String areaCode;
private String address1;
private String city;
private String country;
private String state;
private String zipcode;
//private String status;

//private DemographicsVO demographics;


private Long merchantId;
private Long bankId;
private Long currencyId;
private Long languageId;
private Long entityId;
private Long merchantTimeZoneId;
private String autoRenew;

private String webSiteURL;
private String mid;
private Date validFrom;
private Date validTo;


private String levelOneName;
private String levelOneEmailAddress;
private String levelOneContactNo;
private String levelTwoName;
private String levelTwoEmailAddress;
private String levelTwoContactNo;

private String status;
private String contactPerson;

private String levelOneareaCode;
private String levelTwoareaCode;
private String mcpoption;
private String createdBy;
private String modifiedBy;
private Date modifiedDate;
private Date createdDate;
private String responseURL;
private String licenseValidFrom;
private String licenseValidTo;
private Long id;

private String levelOneCountryAreaCode;
private String levelTwoCountryAreaCode;
private String accountNumber;
private String parentMerchant;
private String childMerchant;
private String parentMid;
private String loginUser;
private String merchantStoreId;
private String merchantStoreName;
private String merchantStoreCode;
private String softDesriptorType;
private String softDesriptorValue;
private Long softDesriptorId;
private String[] creditCardList;
private String[] debitCardList;
private String[] privateLabelList;
private String[] storeCardList;
private String[] giftCardList;
private String privateLabel;
private String storeCards;
private String giftCards;
private String creditCard;
private String debitCard;
private String merchantAccessKey;
private String comments;
private String externalMerchant;



/**
 * @param levelOneName
 * @param levelOneEmailAddress
 * @param levelOneContactNo
 *//*
public MerchantVO(String levelTwoName, String levelTwoEmailAddress,
		String levelTwoContactNo) {
	this.levelTwoName = levelTwoName;
	this.levelTwoEmailAddress = levelTwoEmailAddress;
	this.levelTwoContactNo = levelTwoContactNo;

}

*//**
 * @param demographics
 */

public MerchantVO() {
	//demographics = new DemographicsVO();
}


/**
 * @param levelOneName
 * @param levelOneEmailAddress
 * @param levelOneContactNo
 * @param country
 */
public MerchantVO(String levelOneName, String levelOneEmailAddress,
		String levelOneContactNo, String flag) {
	this.levelOneName = levelOneName;
	this.levelOneEmailAddress = levelOneEmailAddress;
	this.levelOneContactNo = levelOneContactNo;

}

public MerchantVO(Long entityId, String mid, String custom, String status,
		String businessName, String dispalyName, Long bankId,String accountNumber,
		 Long currencyId, Long languageId,
		 Long merchantTimeZoneId,
		 String cntctTitle,
		String cntctFirstName, String cntctLastName, String cntctMobileNo,
		String cntctPhoneNo, String cntctPrimaryEmail,
		String cntctSecondaryEmail,
		String cntctUserName,/* DemographicsVO demographics,*/String parentMerchant,String parentMid,String merchantAccessKey , String externalMerchant) {
	this.entityId = entityId;
	this.mid = mid;
	this.custom = custom;
	this.status = status;
	this.businessName = businessName;
	this.dispalyName = dispalyName;
	this.bankId = bankId;
	this.currencyId = currencyId;
	this.languageId = languageId;
	this.merchantTimeZoneId = merchantTimeZoneId;
	this.cntctTitle = cntctTitle;
	this.cntctFirstName = cntctFirstName;
	this.cntctLastName = cntctLastName;
	this.cntctMobileNo = cntctMobileNo;
	this.cntctPrimaryEmail = cntctPrimaryEmail;
	this.cntctPhoneNo = cntctPhoneNo;
	this.cntctSecondaryEmail = cntctSecondaryEmail;
	this.cntctUserName = cntctUserName;
	//this.demographics = demographics;
	this.accountNumber = accountNumber;
	this.parentMerchant = parentMerchant;
	this.parentMid = parentMid;
	this.merchantAccessKey = merchantAccessKey;
	this.externalMerchant = externalMerchant;
}

/**
 * @param softDesriptorType
 * @param softDesriptorValue
 */
public MerchantVO(String softDesriptorType, String softDesriptorValue) {
	this.softDesriptorType = softDesriptorType;
	this.softDesriptorValue = softDesriptorValue;
}

public MerchantVO(Long entityId, String mid, String custom, String status,
		String businessName, String dispalyName, Long bankId,String accountNumber,
		Long currencyId, Long languageId,
		 Long merchantTimeZoneId,
		Date validFrom, Date validTo, String cntctTitle,
		String cntctFirstName, String cntctLastName, String cntctUserName,
		String cntctMobileNo, String cntctPhoneNo,
		String cntctPrimaryEmail, String cntctSecondaryEmail,
		String softDesriptorType, String softDesriptorValue,
		/* DemographicsVO demographics,*/
		String midGenerated, String autoRenew, String levelOneName,
		String levelOneEmailAddress, String levelOneContactNo,
		String levelOneareaCode, String levelTwoName,
		String levelTwoEmailAddress, String levelTwoContactNo,
		String levelTwoareaCode,String countryAreaCode,String mobileCountryAreaCode,
		String levelOneCountryAreaCode,String levelTwoCountryAreaCode,String parentMerchant,String parentMid,String[] creditCardList, String[] debitCardList,
		/*String[] privateLabelList, String[] storeCardList,
		String[] giftCardList,*/ String privateLabel, String storeCards,
		String giftCards, String creditCard, String debitCard,String merchantAccessKey,String externalMerchant) {
	this.entityId = entityId;
	this.mid = mid;
	this.custom = custom;
	this.status = status;
	this.businessName = businessName;
	this.dispalyName = dispalyName;
	this.bankId = bankId;
	this.accountNumber = accountNumber;
	this.currencyId = currencyId;
	this.languageId = languageId;
	this.merchantTimeZoneId = merchantTimeZoneId;
	this.validFrom = validFrom;
	this.validTo = validTo;
	this.cntctTitle = cntctTitle;
	this.cntctFirstName = cntctFirstName;
	this.cntctLastName = cntctLastName;
	this.cntctUserName = cntctUserName;
	this.cntctMobileNo = cntctMobileNo;
	this.cntctPhoneNo = cntctPhoneNo;
	this.cntctPrimaryEmail = cntctPrimaryEmail;
	this.cntctSecondaryEmail = cntctSecondaryEmail;
	//this.demographics = demographics;
	this.midGenerated = midGenerated;
	this.autoRenew = autoRenew;
	this.levelOneName = levelOneName;
	this.levelOneEmailAddress = levelOneEmailAddress;
	this.levelOneContactNo = levelOneContactNo;
	this.levelOneareaCode = levelOneareaCode;
	this.levelTwoName = levelTwoName;
	this.levelTwoEmailAddress = levelTwoEmailAddress;
	this.levelTwoContactNo = levelTwoContactNo;
	this.levelTwoareaCode = levelTwoareaCode;
	this.countryAreaCode=countryAreaCode;
	this.mobileCountryAreaCode=mobileCountryAreaCode;
	this.levelOneCountryAreaCode=levelOneCountryAreaCode;
	this.levelTwoCountryAreaCode=levelTwoCountryAreaCode;
	this.parentMerchant = parentMerchant;
	this.parentMid = parentMid;
	this.creditCardList = creditCardList;
	    this.debitCardList = debitCardList;
	   /* this.privateLabelList = privateLabelList;
	    this.storeCardList = storeCardList;
	    this.giftCardList = giftCardList;*/
	    this.privateLabel = privateLabel;
	    this.storeCards = storeCards;
	    this.giftCards = giftCards;
	    this.creditCard = creditCard;
	    this.debitCard = debitCard;
	    this.merchantAccessKey = merchantAccessKey;
	    this.externalMerchant = externalMerchant;
}

public MerchantVO(String mid, String businessName, String contactPerson,
		String contactNumber, String status, String country) {
	this.mid = mid;
	this.businessName = businessName;
	this.contactPerson = contactPerson;
	this.cntctPhoneNo = contactNumber;
	this.status = status;
	//this.demographics = new DemographicsVO(null, country);
}

public MerchantVO(String mid, String businessName, String contactPerson,
		String contactNumber, String status, String country,
		 Long id) {
	this.mid = mid;
	this.businessName = businessName;
	this.contactPerson = contactPerson;
	this.cntctPhoneNo = contactNumber;
	this.status = status;
	//this.demographics = new DemographicsVO(null, country);
	this.merchantId = id;
}

/**
 * @param creditCardList
 * @param debitCardList
 * @param privateLabelList
 * @param storeCardList
 * @param giftCardList
 * @param privateLabel
 * @param storeCards
 * @param giftCards
 * @param creditCard
 * @param debitCard
 */
public MerchantVO(String[] creditCardList, String[] debitCardList,
	/*String[] privateLabelList, String[] storeCardList,
	String[] giftCardList,*/ String privateLabel, String storeCards,
	String giftCards, String creditCard, String debitCard) {
    this.creditCardList = creditCardList;
    this.debitCardList = debitCardList;
   /* this.privateLabelList = privateLabelList;
    this.storeCardList = storeCardList;
    this.giftCardList = giftCardList;*/
    this.privateLabel = privateLabel;
    this.storeCards = storeCards;
    this.giftCards = giftCards;
    this.creditCard = creditCard;
    this.debitCard = debitCard;
    //this.externalMerchant = externalMerchant;
}


public MerchantVO(String mid, String businessName, String contactPerson,
	String contactNumber, String status, String comments,Date createdDate,
	 Long id) {
this.mid = mid;
this.businessName = businessName;
this.contactPerson = contactPerson;
this.cntctPhoneNo = contactNumber;
this.status = status;
this.comments = comments;
this.createdDate = createdDate;
this.merchantId = id;
}

/**
 * @return the id
 */
public Long getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}

/**
 * @return the mcpoption
 */
public String getMcpoption() {
	return mcpoption;
}

/**
 * @param mcpoption
 *            the mcpoption to set
 */
public void setMcpoption(String mcpoption) {
	this.mcpoption = mcpoption;
}

/**
 * @return the levelOneareaCode
 */
public String getLevelOneareaCode() {
	return levelOneareaCode;
}

/**
 * @param levelOneareaCode
 *            the levelOneareaCode to set
 */
public void setLevelOneareaCode(String levelOneareaCode) {
	this.levelOneareaCode = levelOneareaCode;
}

/**
 * @return the levelTwoareaCode
 */
public String getLevelTwoareaCode() {
	return levelTwoareaCode;
}

/**
 * @param levelTwoareaCode
 *            the levelTwoareaCode to set
 */
public void setLevelTwoareaCode(String levelTwoareaCode) {
	this.levelTwoareaCode = levelTwoareaCode;
}

/**
 * @return the areaCode
 */
public String getAreaCode() {
	return areaCode;
}

/**
 * @param areaCode
 *            the areaCode to set
 */
public void setAreaCode(String areaCode) {
	this.areaCode = areaCode;
}

/**
 * @return the contactPerson
 */
public String getContactPerson() {
	return contactPerson;
}

/**
 * @param contactPerson
 *            the contactPerson to set
 */
public void setContactPerson(String contactPerson) {
	this.contactPerson = contactPerson;
}

/**
 * @return the merchantId
 */
public Long getMerchantId() {
	return merchantId;
}

/**
 * @param merchantId
 *            the merchantId to set
 */
public void setMerchantId(Long merchantId) {
	this.merchantId = merchantId;
}

/**
 * @return the bankId
 */
public Long getBankId() {
	return bankId;
}

/**
 * @param bankId
 *            the bankId to set
 */
public void setBankId(Long bankId) {
	this.bankId = bankId;
}

/**
 * @return the currencyId
 */
public Long getCurrencyId() {
	return currencyId;
}

/**
 * @param currencyId
 *            the currencyId to set
 */
public void setCurrencyId(Long currencyId) {
	this.currencyId = currencyId;
}

/**
 * @return the languageId
 */
public Long getLanguageId() {
	return languageId;
}

/**
 * @param languageId
 *            the languageId to set
 */
public void setLanguageId(Long languageId) {
	this.languageId = languageId;
}

/**
 * @return the entityId
 */
public Long getEntityId() {
	return entityId;
}

/**
 * @param entityId
 *            the entityId to set
 */
public void setEntityId(Long entityId) {
	this.entityId = entityId;
}

/**
 * @return the merchantTimeZoneId
 */
public Long getMerchantTimeZoneId() {
	return merchantTimeZoneId;
}

/**
 * @param merchantTimeZoneId
 *            the merchantTimeZoneId to set
 */
public void setMerchantTimeZoneId(Long merchantTimeZoneId) {
	this.merchantTimeZoneId = merchantTimeZoneId;
}

/**
 * @return the businessName
 */
public String getBusinessName() {
	return businessName;
}

/**
 * @param businessName
 *            the businessName to set
 */
public void setBusinessName(String businessName) {
	this.businessName = businessName;
}

/**
 * @return the dispalyName
 */
public String getDispalyName() {
	return dispalyName;
}

/**
 * @param dispalyName
 *            the dispalyName to set
 */
public void setDispalyName(String dispalyName) {
	this.dispalyName = dispalyName;
}

/**
 * @return the webSiteURL
 */
public String getWebSiteURL() {
	return webSiteURL;
}

/**
 * @param webSiteURL
 *            the webSiteURL to set
 */
public void setWebSiteURL(String webSiteURL) {
	this.webSiteURL = webSiteURL;
}

/**
 * @return the mid
 */
public String getMid() {
	return mid;
}

/**
 * @param mid
 *            the mid to set
 */
public void setMid(String mid) {
	this.mid = mid;
}

/**
 * @return the validFrom
 */
public Date getValidFrom() {
	return validFrom;
}

/**
 * @param validFrom
 *            the validFrom to set
 */
public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
}

/**
 * @return the validTo
 */
public Date getValidTo() {
	return validTo;
}

/**
 * @param validTo
 *            the validTo to set
 */
public void setValidTo(Date validTo) {
	this.validTo = validTo;
}

/**
 * @return the midGenerated
 */
public String getMidGenerated() {
	return midGenerated;
}

/**
 * @param midGenerated
 *            the midGenerated to set
 */
public void setMidGenerated(String midGenerated) {
	this.midGenerated = midGenerated;
}

/**
 * @return the autoRenew
 */
public String getAutoRenew() {
	return autoRenew;
}

/**
 * @param autoRenew
 *            the autoRenew to set
 */
public void setAutoRenew(String autoRenew) {
	this.autoRenew = autoRenew;
}

/**
 * @return the custom
 */
public String getCustom() {
	return custom;
}

/**
 * @param custom
 *            the custom to set
 */
public void setCustom(String custom) {
	this.custom = custom;
}

/**
 * @return the cntctTitle
 */
public String getCntctTitle() {
	return cntctTitle;
}

/**
 * @param cntctTitle
 *            the cntctTitle to set
 */
public void setCntctTitle(String cntctTitle) {
	this.cntctTitle = cntctTitle;
}

/**
 * @return the cntctFirstName
 */
public String getCntctFirstName() {
	return cntctFirstName;
}

/**
 * @param cntctFirstName
 *            the cntctFirstName to set
 */
public void setCntctFirstName(String cntctFirstName) {
	this.cntctFirstName = cntctFirstName;
}

/**
 * @return the cntctLastName
 */
public String getCntctLastName() {
	return cntctLastName;
}

/**
 * @param cntctLastName
 *            the cntctLastName to set
 */
public void setCntctLastName(String cntctLastName) {
	this.cntctLastName = cntctLastName;
}

/**
 * @return the cntctUserName
 */
public String getCntctUserName() {
	return cntctUserName;
}

/**
 * @param cntctUserName
 *            the cntctUserName to set
 */
public void setCntctUserName(String cntctUserName) {
	this.cntctUserName = cntctUserName;
}

/**
 * @return the cntctPhoneNo
 */
public String getCntctPhoneNo() {
	return cntctPhoneNo;
}

/**
 * @param cntctPhoneNo
 *            the cntctPhoneNo to set
 */
public void setCntctPhoneNo(String cntctPhoneNo) {
	this.cntctPhoneNo = cntctPhoneNo;
}

/**
 * @return the cntctMobileNo
 */
public String getCntctMobileNo() {
	return cntctMobileNo;
}

/**
 * @param cntctMobileNo
 *            the cntctMobileNo to set
 */
public void setCntctMobileNo(String cntctMobileNo) {
	this.cntctMobileNo = cntctMobileNo;
}

/**
 * @return the cntctPrimaryEmail
 */
public String getCntctPrimaryEmail() {
	return cntctPrimaryEmail;
}

/**
 * @param cntctPrimaryEmail
 *            the cntctPrimaryEmail to set
 */
public void setCntctPrimaryEmail(String cntctPrimaryEmail) {
	this.cntctPrimaryEmail = cntctPrimaryEmail;
}

/**
 * @return the cntctSecondaryEmail
 */
public String getCntctSecondaryEmail() {
	return cntctSecondaryEmail;
}

/**
 * @param cntctSecondaryEmail
 *            the cntctSecondaryEmail to set
 */
public void setCntctSecondaryEmail(String cntctSecondaryEmail) {
	this.cntctSecondaryEmail = cntctSecondaryEmail;
}

/**
 * @return the levelOneName
 */
public String getLevelOneName() {
	return levelOneName;
}

/**
 * @param levelOneName
 *            the levelOneName to set
 */
public void setLevelOneName(String levelOneName) {
	this.levelOneName = levelOneName;
}

/**
 * @return the levelOneEmailAddress
 */
public String getLevelOneEmailAddress() {
	return levelOneEmailAddress;
}

/**
 * @param levelOneEmailAddress
 *            the levelOneEmailAddress to set
 */
public void setLevelOneEmailAddress(String levelOneEmailAddress) {
	this.levelOneEmailAddress = levelOneEmailAddress;
}

/**
 * @return the levelOneContactNo
 */
public String getLevelOneContactNo() {
	return levelOneContactNo;
}

/**
 * @param levelOneContactNo
 *            the levelOneContactNo to set
 */
public void setLevelOneContactNo(String levelOneContactNo) {
	this.levelOneContactNo = levelOneContactNo;
}

/**
 * @return the levelTwoName
 */
public String getLevelTwoName() {
	return levelTwoName;
}

/**
 * @param levelTwoName
 *            the levelTwoName to set
 */
public void setLevelTwoName(String levelTwoName) {
	this.levelTwoName = levelTwoName;
}

/**
 * @return the levelTwoEmailAddress
 */
public String getLevelTwoEmailAddress() {
	return levelTwoEmailAddress;
}

/**
 * @param levelTwoEmailAddress
 *            the levelTwoEmailAddress to set
 */
public void setLevelTwoEmailAddress(String levelTwoEmailAddress) {
	this.levelTwoEmailAddress = levelTwoEmailAddress;
}

/**
 * @return the levelTwoContactNo
 */
public String getLevelTwoContactNo() {
	return levelTwoContactNo;
}

/**
 * @param levelTwoContactNo
 *            the levelTwoContactNo to set
 */
public void setLevelTwoContactNo(String levelTwoContactNo) {
	this.levelTwoContactNo = levelTwoContactNo;
}

/**
 * @return the demographics
 *//*
public DemographicsVO getDemographics() {
	return demographics;
}

*//**
 * @param demographics
 *            the demographics to set
 *//*
public void setDemographics(DemographicsVO demographics) {
	this.demographics = demographics;
}
*/
/**
 * @return the status
 */
public String getStatus() {
	return status;
}

/**
 * @param status
 *            the status to set
 */
public void setStatus(String status) {
	this.status = status;
}

/**
 * @return the createdBy
 */
public String getCreatedBy() {
	return createdBy;
}

/**
 * @param createdBy
 *            the createdBy to set
 */
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

/**
 * @return the modifiedBy
 */
public String getModifiedBy() {
	return modifiedBy;
}

/**
 * @param modifiedBy
 *            the modifiedBy to set
 */
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}

/**
 * @return the modifiedDate
 */
public Date getModifiedDate() {
	return modifiedDate;
}

/**
 * @param modifiedDate
 *            the modifiedDate to set
 */
public void setModifiedDate(Date modifiedDate) {
	this.modifiedDate = modifiedDate;
}

/**
 * @return the createdDate
 */
public Date getCreatedDate() {
	return createdDate;
}

/**
 * @param createdDate
 *            the createdDate to set
 */
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public String getResponseURL() {
	return responseURL;
}

public void setResponseURL(String responseURL) {
	this.responseURL = responseURL;
}

/**
 * @return the licenseValidFrom
 */
public String getLicenseValidFrom() {
	return licenseValidFrom;
}

/**
 * @param licenseValidFrom the licenseValidFrom to set
 */
public void setLicenseValidFrom(String licenseValidFrom) {
	this.licenseValidFrom = licenseValidFrom;
}

/**
 * @return the licenseValidTo
 */
public String getLicenseValidTo() {
	return licenseValidTo;
}

/**
 * @param licenseValidTo the licenseValidTo to set
 */
public void setLicenseValidTo(String licenseValidTo) {
	this.licenseValidTo = licenseValidTo;
}

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("MerchantVO [merchantId=");
	builder.append(merchantId);
	builder.append(", bankId=");
	builder.append(bankId);
	builder.append(", currencyId=");
	builder.append(currencyId);
	builder.append(", languageId=");
	builder.append(languageId);
	builder.append(", entityId=");
	builder.append(entityId);
	builder.append(", merchantTimeZoneId=");
	builder.append(merchantTimeZoneId);
	builder.append(", businessName=");
	builder.append(businessName);
	builder.append(", dispalyName=");
	builder.append(dispalyName);
	builder.append(", webSiteURL=");
	builder.append(webSiteURL);
	builder.append(", mid=");
	builder.append(mid);
	builder.append(", validFrom=");
	builder.append(validFrom);
	builder.append(", validTo=");
	builder.append(validTo);
	builder.append(", midGenerated=");
	builder.append(midGenerated);
	builder.append(", autoRenew=");
	builder.append(autoRenew);
	builder.append(", custom=");
	builder.append(custom);
	builder.append(", cntctTitle=");
	builder.append(cntctTitle);
	builder.append(", cntctFirstName=");
	builder.append(cntctFirstName);
	builder.append(", cntctLastName=");
	builder.append(cntctLastName);
	builder.append(", cntctUserName=");
	builder.append(cntctUserName);
	builder.append(", cntctPhoneNo=");
	builder.append(cntctPhoneNo);
	builder.append(", cntctMobileNo=");
	builder.append(cntctMobileNo);
	builder.append(", cntctPrimaryEmail=");
	builder.append(cntctPrimaryEmail);
	builder.append(", cntctSecondaryEmail=");
	builder.append(cntctSecondaryEmail);
	builder.append(", levelOneName=");
	builder.append(levelOneName);
	builder.append(", levelOneEmailAddress=");
	builder.append(levelOneEmailAddress);
	builder.append(", levelOneContactNo=");
	builder.append(levelOneContactNo);
	builder.append(", levelTwoName=");
	builder.append(levelTwoName);
	builder.append(", levelTwoEmailAddress=");
	builder.append(levelTwoEmailAddress);
	builder.append(", levelTwoContactNo=");
	builder.append(levelTwoContactNo);
	//builder.append(", demographics=");
	//builder.append(demographics);
	builder.append(", status=");
	builder.append(status);
	builder.append(", contactPerson=");
	builder.append(contactPerson);
	builder.append(", areaCode=");
	builder.append(areaCode);
	builder.append(", levelOneareaCode=");
	builder.append(levelOneareaCode);
	builder.append(", levelTwoareaCode=");
	builder.append(levelTwoareaCode);
	builder.append(", mcpoption=");
	builder.append(mcpoption);
	builder.append(", createdBy=");
	builder.append(createdBy);
	builder.append(", modifiedBy=");
	builder.append(modifiedBy);
	builder.append(", modifiedDate=");
	builder.append(modifiedDate);
	builder.append(", createdDate=");
	builder.append(createdDate);
	builder.append(", countryAreaCode=");
	builder.append(countryAreaCode);
	builder.append(", mobileCountryAreaCode=");
	builder.append(mobileCountryAreaCode);
	builder.append(", levelOneCountryAreaCode=");
	builder.append(levelOneCountryAreaCode);
	builder.append(", levelTwoCountryAreaCode=");
	builder.append(levelTwoCountryAreaCode);
	builder.append("]");
	return builder.toString();
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
	result = prime * result
			+ ((areaCode == null) ? 0 : areaCode.hashCode());
	result = prime * result
			+ ((autoRenew == null) ? 0 : autoRenew.hashCode());
	result = prime * result + ((bankId == null) ? 0 : bankId.hashCode());
	result = prime * result
			+ ((businessName == null) ? 0 : businessName.hashCode());
	result = prime * result
			+ ((cntctFirstName == null) ? 0 : cntctFirstName.hashCode());
	result = prime * result
			+ ((cntctLastName == null) ? 0 : cntctLastName.hashCode());
	result = prime * result
			+ ((cntctMobileNo == null) ? 0 : cntctMobileNo.hashCode());
	result = prime * result
			+ ((cntctPhoneNo == null) ? 0 : cntctPhoneNo.hashCode());
	result = prime
			* result
			+ ((cntctPrimaryEmail == null) ? 0 : cntctPrimaryEmail
					.hashCode());
	result = prime
			* result
			+ ((cntctSecondaryEmail == null) ? 0 : cntctSecondaryEmail
					.hashCode());
	result = prime * result
			+ ((cntctTitle == null) ? 0 : cntctTitle.hashCode());
	result = prime * result
			+ ((cntctUserName == null) ? 0 : cntctUserName.hashCode());
	result = prime * result
			+ ((contactPerson == null) ? 0 : contactPerson.hashCode());
	result = prime * result
			+ ((countryAreaCode == null) ? 0 : countryAreaCode.hashCode());
	result = prime * result
			+ ((createdBy == null) ? 0 : createdBy.hashCode());
	result = prime * result
			+ ((createdDate == null) ? 0 : createdDate.hashCode());
	result = prime * result
			+ ((currencyId == null) ? 0 : currencyId.hashCode());
	result = prime * result + ((custom == null) ? 0 : custom.hashCode());
	/*result = prime * result
			+ ((demographics == null) ? 0 : demographics.hashCode());*/
	result = prime * result
			+ ((dispalyName == null) ? 0 : dispalyName.hashCode());
	result = prime * result
			+ ((entityId == null) ? 0 : entityId.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result
			+ ((languageId == null) ? 0 : languageId.hashCode());
	result = prime
			* result
			+ ((levelOneContactNo == null) ? 0 : levelOneContactNo
					.hashCode());
	result = prime
			* result
			+ ((levelOneCountryAreaCode == null) ? 0
					: levelOneCountryAreaCode.hashCode());
	result = prime
			* result
			+ ((levelOneEmailAddress == null) ? 0 : levelOneEmailAddress
					.hashCode());
	result = prime * result
			+ ((levelOneName == null) ? 0 : levelOneName.hashCode());
	result = prime
			* result
			+ ((levelOneareaCode == null) ? 0 : levelOneareaCode.hashCode());
	result = prime
			* result
			+ ((levelTwoContactNo == null) ? 0 : levelTwoContactNo
					.hashCode());
	result = prime
			* result
			+ ((levelTwoCountryAreaCode == null) ? 0
					: levelTwoCountryAreaCode.hashCode());
	result = prime
			* result
			+ ((levelTwoEmailAddress == null) ? 0 : levelTwoEmailAddress
					.hashCode());
	result = prime * result
			+ ((levelTwoName == null) ? 0 : levelTwoName.hashCode());
	result = prime
			* result
			+ ((levelTwoareaCode == null) ? 0 : levelTwoareaCode.hashCode());
	result = prime
			* result
			+ ((licenseValidFrom == null) ? 0 : licenseValidFrom.hashCode());
	result = prime * result
			+ ((licenseValidTo == null) ? 0 : licenseValidTo.hashCode());
	result = prime * result
			+ ((mcpoption == null) ? 0 : mcpoption.hashCode());
	result = prime * result
			+ ((merchantId == null) ? 0 : merchantId.hashCode());
	result = prime
			* result
			+ ((merchantTimeZoneId == null) ? 0 : merchantTimeZoneId
					.hashCode());
	result = prime * result + ((mid == null) ? 0 : mid.hashCode());
	result = prime * result
			+ ((midGenerated == null) ? 0 : midGenerated.hashCode());
	result = prime
			* result
			+ ((mobileCountryAreaCode == null) ? 0 : mobileCountryAreaCode
					.hashCode());
	result = prime * result
			+ ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
	result = prime * result
			+ ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
	result = prime * result
			+ ((responseURL == null) ? 0 : responseURL.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	
	result = prime * result
			+ ((validFrom == null) ? 0 : validFrom.hashCode());
	result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
	result = prime * result
			+ ((webSiteURL == null) ? 0 : webSiteURL.hashCode());
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
	if (obj == null){
		return false;
	}
	if (getClass() != obj.getClass()){
		return false;
	}
	MerchantVO other = (MerchantVO) obj;
	if (accountNumber == null) {
		if (other.accountNumber != null){
			return false;
		}
	} else if (!accountNumber.equals(other.accountNumber)){
		return false;
	}
	if (areaCode == null) {
		if (other.areaCode != null){
			return false;
		}
	} else if (!areaCode.equals(other.areaCode)){
		return false;
	}
	if (autoRenew == null) {
		if (other.autoRenew != null){
			return false;
		}
	} else if (!autoRenew.equals(other.autoRenew)) {
		return false;
	}
	if (bankId == null) {
		if (other.bankId != null){
			return false;
		}
	} else if (!bankId.equals(other.bankId)) {
		return false;
	}
	if (businessName == null) {
		if (other.businessName != null){
			return false;
		}
	} else if (!businessName.equals(other.businessName)){
		return false;
	}
	if (cntctFirstName == null) {
		if (other.cntctFirstName != null){
			return false;
		}
	} else if (!cntctFirstName.equals(other.cntctFirstName)){
		return false;
	}
	if (cntctLastName == null) {
		if (other.cntctLastName != null){
			return false;
		}
	} else if (!cntctLastName.equals(other.cntctLastName)){
		return false;
	}
	if (cntctMobileNo == null) {
		if (other.cntctMobileNo != null){
			return false;
		}
	} else if (!cntctMobileNo.equals(other.cntctMobileNo)){
		return false;
	}
	if (cntctPhoneNo == null) {
		if (other.cntctPhoneNo != null){
			return false;
		}
	} else if (!cntctPhoneNo.equals(other.cntctPhoneNo)){
		return false;
	}
	if (cntctPrimaryEmail == null) {
		if (other.cntctPrimaryEmail != null){
			return false;
		}
	} else if (!cntctPrimaryEmail.equals(other.cntctPrimaryEmail)){
		return false;
	}
	if (cntctSecondaryEmail == null) {
		if (other.cntctSecondaryEmail != null){
			return false;
		}
	} else if (!cntctSecondaryEmail.equals(other.cntctSecondaryEmail)){
		return false;
	}
	if (cntctTitle == null) {
		if (other.cntctTitle != null){
			return false;
		}
	} else if (!cntctTitle.equals(other.cntctTitle)){
		return false;
	}
	if (cntctUserName == null) {
		if (other.cntctUserName != null){
			return false;
		}
	} else if (!cntctUserName.equals(other.cntctUserName)){
		return false;
	}
	if (contactPerson == null) {
		if (other.contactPerson != null){
			return false;
		}
	} else if (!contactPerson.equals(other.contactPerson)){
		return false;
	}
	
	if (countryAreaCode == null) {
		if (other.countryAreaCode != null){
			return false;
		}
	} else if (!countryAreaCode.equals(other.countryAreaCode)){
		return false;
	}
	if (createdBy == null) {
		if (other.createdBy != null){
			return false;
		}
	} else if (!createdBy.equals(other.createdBy)){
		return false;
	}
	if (createdDate == null) {
		if (other.createdDate != null){
			return false;
		}
	} else if (!createdDate.equals(other.createdDate)){
		return false;
	}
	
	if (currencyId == null) {
		if (other.currencyId != null){
			return false;
		}
	} else if (!currencyId.equals(other.currencyId)){
		return false;
	}
	if (custom == null) {
		if (other.custom != null){
			return false;
		}
	} else if (!custom.equals(other.custom)){
		return false;
	}
/*	if (demographics == null) {
		if (other.demographics != null){
			return false;
		}
	} else if (!demographics.equals(other.demographics)){
		return false;
	}*/
	if (dispalyName == null) {
		if (other.dispalyName != null){
			return false;
		}
	} else if (!dispalyName.equals(other.dispalyName)){
		return false;
	}
	
	if (entityId == null) {
		if (other.entityId != null) {
			return false;
		}
	} else if (!entityId.equals(other.entityId)){
		return false;
	}
	if (id == null) {
		if (other.id != null){
			return false;
		}
	} else if (!id.equals(other.id)){
		return false;
	}
	if (languageId == null) {
		if (other.languageId != null){
			return false;
		}
	} else if (!languageId.equals(other.languageId)){
		return false;
	}
	if (levelOneContactNo == null) {
		if (other.levelOneContactNo != null){
			return false;
		}
	} else if (!levelOneContactNo.equals(other.levelOneContactNo)){
		return false;
	}
	if (levelOneCountryAreaCode == null) {
		if (other.levelOneCountryAreaCode != null){
			return false;
		}
	} else if (!levelOneCountryAreaCode.equals(other.levelOneCountryAreaCode)){
		return false;
	}
	if (levelOneEmailAddress == null) {
		if (other.levelOneEmailAddress != null){
			return false;
		}
	} else if (!levelOneEmailAddress.equals(other.levelOneEmailAddress)){
		return false;
	}
	if (levelOneName == null) {
		if (other.levelOneName != null){
			return false;
		}
	} else if (!levelOneName.equals(other.levelOneName)){
		return false;
	}
	if (levelOneareaCode == null) {
		if (other.levelOneareaCode != null){
			return false;
		}
	} else if (!levelOneareaCode.equals(other.levelOneareaCode)){
		return false;
	}
	if (levelTwoContactNo == null) {
		if (other.levelTwoContactNo != null){
			return false;
		}
	} else if (!levelTwoContactNo.equals(other.levelTwoContactNo)){
		return false;
	}
	if (levelTwoCountryAreaCode == null) {
		if (other.levelTwoCountryAreaCode != null){
			return false;
		}
	} else if (!levelTwoCountryAreaCode.equals(other.levelTwoCountryAreaCode)){
		return false;
	}
	if (levelTwoEmailAddress == null) {
		if (other.levelTwoEmailAddress != null){
			return false;
		}
	} else if (!levelTwoEmailAddress.equals(other.levelTwoEmailAddress)){
		return false;
	}
	if (levelTwoName == null) {
		if (other.levelTwoName != null){
			return false;
		}
	} else if (!levelTwoName.equals(other.levelTwoName)){
		return false;
	}
	
	if (levelTwoareaCode == null) {
		if (other.levelTwoareaCode != null){
			return false;
		}
	} else if (!levelTwoareaCode.equals(other.levelTwoareaCode)){
		return false;
	}
	if (licenseValidFrom == null) {
		if (other.licenseValidFrom != null){
			return false;
		}
	} else if (!licenseValidFrom.equals(other.licenseValidFrom)){
		return false;
	}
	if (licenseValidTo == null) {
		if (other.licenseValidTo != null){
			return false;
		}
	} else if (!licenseValidTo.equals(other.licenseValidTo)){
		return false;
	}
	
	if (mcpoption == null) {
		if (other.mcpoption != null){
			return false;
		}
	} else if (!mcpoption.equals(other.mcpoption)){
		return false;
	}
	
	if (merchantId == null) {
		if (other.merchantId != null){
			return false;
		}
	} else if (!merchantId.equals(other.merchantId)){
		return false;
	}
	if (merchantTimeZoneId == null) {
		if (other.merchantTimeZoneId != null){
			return false;
		}
	} else if (!merchantTimeZoneId.equals(other.merchantTimeZoneId)){
		return false;
	}
	if (mid == null) {
		if (other.mid != null){
			return false;
		}
	} else if (!mid.equals(other.mid)){
		return false;
	}
	if (midGenerated == null) {
		if (other.midGenerated != null){
			return false;
		}
	} else if (!midGenerated.equals(other.midGenerated)){
		return false;
	}
	if (mobileCountryAreaCode == null) {
		if (other.mobileCountryAreaCode != null){
			return false;
		}
	} else if (!mobileCountryAreaCode.equals(other.mobileCountryAreaCode)){
		return false;
	}
	if (modifiedBy == null) {
		if (other.modifiedBy != null){
			return false;
		}
	} else if (!modifiedBy.equals(other.modifiedBy)){
		return false;
	}
	if (modifiedDate == null) {
		if (other.modifiedDate != null){
			return false;
		}
	} else if (!modifiedDate.equals(other.modifiedDate)){
		return false;
	}
	if (responseURL == null) {
		if (other.responseURL != null){
			return false;
		}
	} else if (!responseURL.equals(other.responseURL)){
		return false;
	}
	if (status == null) {
		if (other.status != null){
			return false;
		}
	} else if (!status.equals(other.status)){
		return false;
	}
	if (validFrom == null) {
		if (other.validFrom != null){
			return false;
		}
	} else if (!validFrom.equals(other.validFrom)){
		return false;
	}
	if (validTo == null) {
		if (other.validTo != null){
			return false;
		}
	} else if (!validTo.equals(other.validTo)){
		return false;
	}
	
	if (webSiteURL == null) {
		if (other.webSiteURL != null){
			return false;
		}
	} else if (!webSiteURL.equals(other.webSiteURL)){
		return false;
	}
	return true;
}

/**
 * @return the countryAreaCode
 */
public String getCountryAreaCode() {
	return countryAreaCode;
}

/**
 * @param countryAreaCode the countryAreaCode to set
 */
public void setCountryAreaCode(String countryAreaCode) {
	this.countryAreaCode = countryAreaCode;
}

/**
 * @return the mobileCountryAreaCode
 */
public String getMobileCountryAreaCode() {
	return mobileCountryAreaCode;
}

/**
 * @param mobileCountryAreaCode the mobileCountryAreaCode to set
 */
public void setMobileCountryAreaCode(String mobileCountryAreaCode) {
	this.mobileCountryAreaCode = mobileCountryAreaCode;
}

/**
 * @return the levelOneCountryAreaCode
 */
public String getLevelOneCountryAreaCode() {
	return levelOneCountryAreaCode;
}

/**
 * @param levelOneCountryAreaCode the levelOneCountryAreaCode to set
 */
public void setLevelOneCountryAreaCode(String levelOneCountryAreaCode) {
	this.levelOneCountryAreaCode = levelOneCountryAreaCode;
}

/**
 * @return the levelTwoCountryAreaCode
 */
public String getLevelTwoCountryAreaCode() {
	return levelTwoCountryAreaCode;
}

/**
 * @param levelTwoCountryAreaCode the levelTwoCountryAreaCode to set
 */
public void setLevelTwoCountryAreaCode(String levelTwoCountryAreaCode) {
	this.levelTwoCountryAreaCode = levelTwoCountryAreaCode;
}

/**
 * @return the accountNumber
 */
public String getAccountNumber() {
	return accountNumber;
}

/**
 * @param accountNumber the accountNumber to set
 */
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

/**
 * @return the parentMerchant
 */
public String getParentMerchant() {
	return parentMerchant;
}

/**
 * @param parentMerchant the parentMerchant to set
 */
public void setParentMerchant(String parentMerchant) {
	this.parentMerchant = parentMerchant;
}

/**
 * @return the childMerchant
 */
public String getChildMerchant() {
	return childMerchant;
}

/**
 * @param childMerchant the childMerchant to set
 */
public void setChildMerchant(String childMerchant) {
	this.childMerchant = childMerchant;
}

/**
 * @return the parentMid
 */
public String getParentMid() {
	return parentMid;
}

/**
 * @param parentMid the parentMid to set
 */
public void setParentMid(String parentMid) {
	this.parentMid = parentMid;
}

/**
 * @return the loginUser
 */
public String getLoginUser() {
	return loginUser;
}

/**
 * @param loginUser the loginUser to set
 */
public void setLoginUser(String loginUser) {
	this.loginUser = loginUser;
}

/**
 * @return the merchantStoreId
 */
public String getMerchantStoreId() {
	return merchantStoreId;
}

/**
 * @param merchantStoreId the merchantStoreId to set
 */
public void setMerchantStoreId(String merchantStoreId) {
	this.merchantStoreId = merchantStoreId;
}

/**
 * @return the merchantStoreName
 */
public String getMerchantStoreName() {
	return merchantStoreName;
}

/**
 * @param merchantStoreName the merchantStoreName to set
 */
public void setMerchantStoreName(String merchantStoreName) {
	this.merchantStoreName = merchantStoreName;
}

/**
 * @return the merchantStoreCode
 */
public String getMerchantStoreCode() {
	return merchantStoreCode;
}

/**
 * @param merchantStoreCode the merchantStoreCode to set
 */
public void setMerchantStoreCode(String merchantStoreCode) {
	this.merchantStoreCode = merchantStoreCode;
}

/**
 * @return the softDesriptorType
 */
public String getSoftDesriptorType() {
	return softDesriptorType;
}

/**
 * @param softDesriptorType the softDesriptorType to set
 */
public void setSoftDesriptorType(String softDesriptorType) {
	this.softDesriptorType = softDesriptorType;
}

/**
 * @return the softDesriptorValue
 */
public String getSoftDesriptorValue() {
	return softDesriptorValue;
}

/**
 * @param softDesriptorValue the softDesriptorValue to set
 */
public void setSoftDesriptorValue(String softDesriptorValue) {
	this.softDesriptorValue = softDesriptorValue;
}

/**
 * @return the softDesriptorId
 */
public Long getSoftDesriptorId() {
	return softDesriptorId;
}

/**
 * @param softDesriptorId the softDesriptorId to set
 */
	public void setSoftDesriptorId(Long softDesriptorId) {
		this.softDesriptorId = softDesriptorId;
	}

/**
 * @return the debitCardList
 */
public String[] getDebitCardList() {
    return debitCardList;
}

/**
 * @param debitCardList the debitCardList to set
 */
public void setDebitCardList(String[] debitCardList) {
    this.debitCardList = debitCardList;
}

/**
 * @return the privateLabelList
 */
public String[] getPrivateLabelList() {
    return privateLabelList;
}

/**
 * @param privateLabelList the privateLabelList to set
 */
public void setPrivateLabelList(String[] privateLabelList) {
    this.privateLabelList = privateLabelList;
}

/**
 * @return the storeCardList
 */
public String[] getStoreCardList() {
    return storeCardList;
}

/**
 * @param storeCardList the storeCardList to set
 */
public void setStoreCardList(String[] storeCardList) {
    this.storeCardList = storeCardList;
}

/**
 * @return the giftCardList
 */
public String[] getGiftCardList() {
    return giftCardList;
}

/**
 * @param giftCardList the giftCardList to set
 */
public void setGiftCardList(String[] giftCardList) {
    this.giftCardList = giftCardList;
}

/**
 * @return the privateLabel
 */
public String getPrivateLabel() {
    return privateLabel;
}

/**
 * @param privateLabel the privateLabel to set
 */
public void setPrivateLabel(String privateLabel) {
    this.privateLabel = privateLabel;
}

/**
 * @return the storeCards
 */
public String getStoreCards() {
    return storeCards;
}

/**
 * @param storeCards the storeCards to set
 */
public void setStoreCards(String storeCards) {
    this.storeCards = storeCards;
}

/**
 * @return the giftCards
 */
public String getGiftCards() {
    return giftCards;
}

/**
 * @param giftCards the giftCards to set
 */
public void setGiftCards(String giftCards) {
    this.giftCards = giftCards;
}

/**
 * @return the creditCard
 */
public String getCreditCard() {
    return creditCard;
}

/**
 * @param creditCard the creditCard to set
 */
public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
}

/**
 * @return the debitCard
 */
public String getDebitCard() {
    return debitCard;
}

/**
 * @param debitCard the debitCard to set
 */
public void setDebitCard(String debitCard) {
    this.debitCard = debitCard;
}

/**
 * @return the creditCardList
 */
public String[] getCreditCardList() {
    return creditCardList;
}

/**
 * @param creditCardList the creditCardList to set
 */
public void setCreditCardList(String[] creditCardList) {
    this.creditCardList = creditCardList;
}

/**
 * @return the merchantAccessKey
 */
public String getMerchantAccessKey() {
    return merchantAccessKey;
}

/**
 * @param merchantAccessKey the merchantAccessKey to set
 */
public void setMerchantAccessKey(String merchantAccessKey) {
    this.merchantAccessKey = merchantAccessKey;
}

/**
 * @return the comments
 */
public String getComments() {
    return comments;
}

/**
 * @param comments the comments to set
 */
public void setComments(String comments) {
    this.comments = comments;
}

/**
 * @return the externalMerchant
 */
public String getExternalMerchant() {
	return externalMerchant;
}

/**
 * @param externalMerchant the externalMerchant to set
 */
public void setExternalMerchant(String externalMerchant) {
	this.externalMerchant = externalMerchant;
}


public String getAddress1() {
	return address1;
}


public void setAddress1(String address1) {
	this.address1 = address1;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getCountry() {
	return country;
}


public void setCountry(String country) {
	this.country = country;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public String getZipcode() {
	return zipcode;
}


public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}




}

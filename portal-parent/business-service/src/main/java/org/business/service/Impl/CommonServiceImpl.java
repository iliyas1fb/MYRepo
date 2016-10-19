package org.business.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.business.service.CommonService;
import org.persistent.service.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * The Class CommonUtilService handles all the functionalities
 * CommonUtilService.
 */
//@Service("commonUtilService")
@Transactional
public class CommonServiceImpl implements CommonService {
	
	/** The LOGGER. */
//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

/** The CLAS s_ name. */
private final String className = this.getClass().getName();

/** The system dao. */
@Autowired
private CommonDAO commonsDAO;





/*public List<CountryVO> getCountry(CountryVO countryVO) throws DCSServiceException {
	String methodName = "getCountry";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
//	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
//	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<CountryVO> countryList = null;
	try {
		countryList = commonsDAO.getCountry(countryVO);
	} catch (DCSServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer
			//	.append("OMNYPAYDAException occured while getting the List<CountryVO>")
			//	.append(DCSServiceException.COMMA).append(sb)
			//	.append("Error Code : ").append(pdae.getErrorCode())
			//	.append(",").append("Error Message : ")
			//	.append(pdae.getMessage());
		//LOGGER.error(className, methodName, pdae, errorBuffer);
		//throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("Exception occured while getting the List<CountryVO>")
		//		.append(OMNYPAYConstants.COMMA).append(sb)
		//		.append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_COUNTRY).append(",")
		//		.append("Error Message : ").append(ex.getMessage());
		//LOGGER.error(className, methodName, ex, errorBuffer);
		//throw new OMNYPAYServiceException(ErrorCodeConstants.GET_COUNTRY, ex.getMessage());
	}
	///sb.append("List<CountryVO> Size : ").append(countryList.size()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return countryList;
}

public List<StateVO> getState(StateVO stateVO) throws DCSServiceException {
	String methodName = "getState";
	//LogDetails logDetails = LogDetails.getInstance();
	//StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<StateVO> stateList = null;
	try {
		stateList = commonsDAO.getState(stateVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting the List<StateVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting the List<StateVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.GET_STATE).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.GET_STATE, ex.getMessage());
	}
	//sb.append("List<StateVO> Size : ").append(stateList.size()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName,sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return stateList;
}*/
/*
public List<LanguageVO> getLanguage(LanguageVO languageVO) throws OMNYPAYServiceException {
	String methodName = "getLanguage";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<LanguageVO> languageList;
	try {
		languageList = commonsDAO.getLanguage(languageVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting the List<LanguageVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting the List<LanguageVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.GET_LANGUAGE).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.GET_LANGUAGE, ex.getMessage());
	}
	sb.append("List<LanguageVO> Size : ").append(languageList.size()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return languageList;
}

public List<CurrencyVO> getCurrency(CurrencyVO currencyVO) throws OMNYPAYServiceException {
	String methodName = "getCurrency";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<CurrencyVO> currencyList;
	try {
		currencyList = commonsDAO.getCurrency(currencyVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting the List<CurrencyVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting the List<CurrencyVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.GET_CURRENCY).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.GET_CURRENCY, ex.getMessage());
	}
	sb.append("List<CurrencyVO> Size : ").append(currencyList.size()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return currencyList;
}

public List<TimeZoneVO> getTimeZone(TimeZoneVO timeZoneVO) throws OMNYPAYServiceException {
	String methodName = "getTimeZone";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<TimeZoneVO> timeZoneList;
	try {
		timeZoneList = commonsDAO.getTimeZone(timeZoneVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting the List<CountryVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting the List<TimeZoneVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.GET_SYS_TZ).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.GET_SYS_TZ,ex.getMessage());
	}
	sb.append("List<TimeZoneVO> Size : ").append(timeZoneList.size()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return timeZoneList;
}
*/
/*public List<HierachyRequestObject> getHierarchyInfo() throws DCSServiceException {
	String methodName = "getHierarchyInfo";
	//LogDetails logDetails = LogDetails.getInstance();
	//StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<HierachyRequestObject> hierachyVOList = null;
	try {
		hierachyVOList = commonsDAO.getHierarchyInfo();
	} catch (DCSServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("OMNYPAYDAException occured while getting the List<HierachyVO>")
		//		.append(OMNYPAYConstants.COMMA).append(sb)
		//		.append("Error Code : ").append(pdae.getErrorCode())
		//		.append(",").append("Error Message : ")
		//		.append(pdae.getMessage());
		//LOGGER.error(className, methodName, pdae, errorBuffer);
		//throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("Exception occured while getting the List<HierachyVO>")
		//		.append(OMNYPAYConstants.COMMA).append(sb)
		//		.append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_HIERARCHY).append(",")
		//		.append("Error Message : ").append(ex.getMessage());
		//LOGGER.error(className, methodName, ex, errorBuffer);
		//throw new OMNYPAYServiceException(ErrorCodeConstants.GET_HIERARCHY, ex.getMessage());
	}
	//sb.append("List<hierachyVOList> Size : ").append(hierachyVOList.size()).append(OMNYPAYConstants.COMMA);
	//	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return hierachyVOList;
	}*/


/*public Map<String,List<DashboradMerchantVO>> getYearTransactionvalues()
		throws OMNYPAYServiceException {
	String METHOD_NAME = "getYearTransactionvalues";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
			.append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	Map<String,List<DashboradMerchantVO>> list = new HashMap<String, List<DashboradMerchantVO>>();
	try {
		list = commonsDAO.getYearTransactionvalues();
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("APCDAException occurred while getting getYearTransactionvalues type data:")
				.append(OMNYPAYConstants.COMMA).append(sb).append(OMNYPAYConstants.ERROR_CODE_STR)
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append(OMNYPAYConstants.ERROR_MSG_STR).append(pdae.getMessage());

		LOGGER.error(className, METHOD_NAME, pdae, errorBuffer);

		throw new OMNYPAYServiceException(ErrorCodeConstants.CREATE_BANK,pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting getYearTransactionvalues type  data:")
				.append(OMNYPAYConstants.COMMA).append(sb).append(OMNYPAYConstants.ERROR_CODE_STR)
				.append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.ERROR_MSG_STR)
				.append(ex.getMessage());

		LOGGER.error(className, METHOD_NAME, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.CREATE_BANK,ex.getMessage());

	}
	LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));

	return list;
}

//for charts
 public Map<String, List<AccountAdminChartVO>> getSalesDashBoard(String userName)throws OMNYPAYServiceException {

		String methodName = "getSalesDashBoard";
		StringBuilder sb = new StringBuilder();
		LogDetails logDetails = LogDetails.getInstance();
		sb.append(logDetails.getUserName()).append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
				.append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		Map<String, List<AccountAdminChartVO>> resultsMap = null;
		try {
			resultsMap = commonsDAO.getSalesDashBoard(userName);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("OMNYPAYDAException occured while getting the List<AccountAdminChartVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ").append(pdae.getErrorCode())
					.append(",").append("Error Message : ")
					.append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occured while getting the List<AccountAdminChartVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ")
					.append(ErrorCodeConstants.GET_BAR_CHART_1).append(",")
					.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_BAR_CHART_1, ex.getMessage());
		}
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return resultsMap;
	}
 
 public List<CouponVO> getMerchantStoreNameList(CouponVO userCouponVo) throws OMNYPAYServiceException {
		String methodName = "getMerchantStoreNameList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

		List<CouponVO> userCouponVoList;
		try {
			userCouponVoList = commonsDAO.getMerchantStoreNameList(userCouponVo);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("OMNYPAYDAException occured while getting the List<UserCouponVo>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ").append(pdae.getErrorCode())
					.append(",").append("Error Message : ")
					.append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occured while getting the List<UserCouponVo>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ")
					.append(ErrorCodeConstants.GET_COUNTRY).append(",")
					.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_COUNTRY, ex.getMessage());
		}
		sb.append("List<UserCouponVo> Size : ").append(userCouponVoList.size()).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return userCouponVoList;
	}

 
public List<CouponExceptionVO> getCouponExceptionDescList(CouponExceptionVO couponExceptionVO)
		throws OMNYPAYServiceException {
	String methodName = "getCouponExceptionDescList";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<CouponExceptionVO> couponExceptionList;
	try {
		couponExceptionList = commonsDAO.getCouponExceptionDescList(couponExceptionVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer
				.append("OMNYPAYDAException occured while getting coupon exception list <CouponExcpetionVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting coupon exception list <CouponExcpetionVo>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.DATA_BASE_ERROR).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.DATA_BASE_ERROR, ex.getMessage());
	}
	sb.append("List<CouponExceptionVO> Size : ").append(couponExceptionList.size()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return couponExceptionList;
}




public List<DiscountTypeVO> getDiscountDescList(DiscountTypeVO discountTypeVO)
		throws OMNYPAYServiceException {
	String methodName = "getDiscountDescList";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	List<DiscountTypeVO> discountDescList;
	try {
		discountDescList = commonsDAO.getDiscountDescList(discountTypeVO);
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer
				.append("OMNYPAYDAException occured while getting discount description  list <DiscountTypeVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ").append(pdae.getErrorCode())
				.append(",").append("Error Message : ")
				.append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting description  list <DiscountTypeVO>")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append("Error Code : ")
				.append(ErrorCodeConstants.DATA_BASE_ERROR).append(",")
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYServiceException(ErrorCodeConstants.DATA_BASE_ERROR, ex.getMessage());
	}
	sb.append("List<DiscountTypeVO> Size : ").append(discountDescList.size()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return discountDescList;
}
	
	*/
 	
 
 
 
 
}

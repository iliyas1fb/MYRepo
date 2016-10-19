
package org.persistent.service.dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.persistent.service.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class CommonDAOImpl implements CommonDAO {
	/** The LOGGER. */
//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

/** The CLAS s_ name. */
private final String className = this.getClass().getName();

/** The jdbc template. */
@Autowired
private HibernateTemplate hibernateTemplate;


/*public List<CountryVO> getCountry(CountryVO countryVO) throws DCSDAException {
	String methodName = "getCountry";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<CountryVO> list = new ArrayList<CountryVO>();
	try {
		GetCountrySP proc = new GetCountrySP(jdbcTemplate);
		//list = proc.execute(countryVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("DataAccessException occured while getting the Country")
		//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_COUNTRY).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(edae.getMessage());
		//LOGGER.error(className, methodName, edae, errorBuffer);
		//throw new OMNYPAYDAException(ErrorCodeConstants.GET_COUNTRY, edae.getMessage());
	} catch (DCSDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("OMNYPAYDAException occured while getting the Country")
		//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(pdae.getMessage());
		//LOGGER.error(className, methodName, pdae, errorBuffer);
		//throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		///errorBuffer.append("Exception occured while getting the Country")
		///		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_COUNTRY).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(ex.getMessage());
		//LOGGER.error(className, methodName, ex, errorBuffer);
		//throw new OMNYPAYDAException(ErrorCodeConstants.GET_COUNTRY, ex.getMessage());
	}
	//sb.append("List<RoutingParamVO> Size : ").append(list.size()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<StateVO> getState(StateVO stateVO) throws DCSDAException {
	String methodName = "getState";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<StateVO> list = new ArrayList<StateVO>();
	try {
		GetStateSP proc = new GetStateSP(jdbcTemplate);
		list = proc.execute(stateVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting State")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_STATE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_STATE, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting State")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting State")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_STATE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_STATE, ex.getMessage());
	}
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<LanguageVO> getLanguage(LanguageVO languageVO) throws OMNYPAYDAException {
	String methodName = "getLanguage";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<LanguageVO> list = new ArrayList<LanguageVO>();
	try {
		GetLanguageSP proc = new GetLanguageSP(jdbcTemplate);
		list = proc.execute(languageVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting Language")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_LANGUAGE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_LANGUAGE, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting Language")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting Language")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_LANGUAGE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_LANGUAGE, ex.getMessage());
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<CurrencyVO> getCurrency(CurrencyVO currencyVO) throws OMNYPAYDAException {
	String methodName = "getCurrency";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<CurrencyVO> list = new ArrayList<CurrencyVO>();
	try {
		GetCurrencySP proc = new GetCurrencySP(jdbcTemplate);
		list = proc.execute(currencyVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting Currency")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_CURRENCY).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_CURRENCY, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting Currency")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting Currency")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_CURRENCY).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_CURRENCY, ex.getMessage());
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<TimeZoneVO> getTimeZone(TimeZoneVO timeZoneVO) throws OMNYPAYDAException {
	String methodName = "getTimeZone";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<TimeZoneVO> list = new ArrayList<TimeZoneVO>();
	try {
		GetTimeZoneSP proc = new GetTimeZoneSP(jdbcTemplate);
		list = proc.execute(timeZoneVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting TimeZone")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_SYS_TZ).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_SYS_TZ, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured while getting TimeZone")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured while getting TimeZone")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_SYS_TZ).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_SYS_TZ, ex.getMessage());
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<HierachyRequestObject> getHierarchyInfo() throws DCSDAException {
	
	String methodName = "getHierarchyInfo";
	
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<HierachyRequestObject> list = null;
	try {
		
		GetHierarchyInfoSP proc = new GetHierarchyInfoSP(jdbcTemplate);
		
		//list = proc.execute();
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("DataAccessException occured while getting HierachyVO List")
		//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_HIERARCHY).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(edae.getMessage());
		//LOGGER.error(className, methodName, edae, errorBuffer);
		//throw new OMNYPAYDAException(ErrorCodeConstants.GET_HIERARCHY, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("OMNYPAYDAException occured while getting HierachyVO List")
		//		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(pdae.getMessage());
		//LOGGER.error(className, methodName, pdae, errorBuffer);
		//throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		//errorBuffer.append("Exception occured while getting HierachyVO List")
		///		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		//		.append(ErrorCodeConstants.GET_HIERARCHY).append(OMNYPAYConstants.COMMA)
		//		.append("Error Message : ").append(ex.getMessage());
		//	LOGGER.error(className, methodName, ex, errorBuffer);
		//	throw new OMNYPAYDAException(ErrorCodeConstants.GET_HIERARCHY, ex.getMessage());
		}
		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return list;
	}

public Map<String, List<DashboradMerchantVO>> getYearTransactionvalues() throws OMNYPAYDAException
{
	String METHOD_NAME = "getYearTransactionvalues";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));

	Map<String, List<DashboradMerchantVO>> accList = new HashMap<String, List<DashboradMerchantVO>>();
	try
	{
		GetpaymentGraphReportSP proc = new GetpaymentGraphReportSP(jdbcTemplate);
		accList = (Map<String, List<DashboradMerchantVO>>) proc.execute();
	}
	catch (DataAccessException e)
	{
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer
				.append("Exception occurred while getting the getYearTransactionvalues type data")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append(OMNYPAYConstants.ERROR_CODE_STR)
				.append(OMNYPAYConstants.COMMA)
				.append(OMNYPAYConstants.ERROR_MSG_STR).append(e.getMessage());
		LOGGER.error(className, METHOD_NAME, e, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_HIERARCHY, e.getMessage());
	}
	catch (OMNYPAYDAException pdae)
	{
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer
				.append("APCDAException occurred while getting the getYearTransactionvalues type  data:")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append(OMNYPAYConstants.ERROR_CODE_STR)
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append(OMNYPAYConstants.ERROR_MSG_STR)
				.append(pdae.getMessage());
		LOGGER.error(className, METHOD_NAME, pdae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_HIERARCHY, pdae.getMessage());
	}
	catch (Exception ex)
	{
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer
				.append("Exception occurred while getting the getYearTransactionvalues type  data:")
				.append(OMNYPAYConstants.COMMA).append(sb)
				.append(OMNYPAYConstants.ERROR_CODE_STR)
				.append(OMNYPAYConstants.COMMA)
				.append(OMNYPAYConstants.ERROR_MSG_STR).append(ex.getMessage());
		LOGGER.error(className, METHOD_NAME, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_HIERARCHY, ex.getMessage());
	}
	LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return accList;
}

public Map<String, List<AccountAdminChartVO>> getSalesDashBoard(String userName) throws OMNYPAYDAException {

	String METHOD_NAME = "getSalesDashBoard";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	Map<String, List<AccountAdminChartVO>> resultsMap = null;
	try {
		MerchantTransactioChartSP boardCalcSP = new MerchantTransactioChartSP(jdbcTemplate);
		resultsMap =boardCalcSP.execute(userName);

	}catch (OMNYPAYDAException pdae)
		{
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("APCDAException occurred while getting the getSalesDashBoard type  data:")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append(OMNYPAYConstants.ERROR_CODE_STR)
					.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
					.append(OMNYPAYConstants.ERROR_MSG_STR)
					.append(pdae.getMessage());
			LOGGER.error(className, METHOD_NAME, pdae, errorBuffer);
			throw new OMNYPAYDAException(ErrorCodeConstants.GET_BAR_CHART_1, pdae.getMessage());
		}
		catch (Exception ex)
		{
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("Exception occurred while getting the getSalesDashBoard type  data:")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append(OMNYPAYConstants.ERROR_CODE_STR)
					.append(OMNYPAYConstants.COMMA)
					.append(OMNYPAYConstants.ERROR_MSG_STR).append(ex.getMessage());
			LOGGER.error(className, METHOD_NAME, ex, errorBuffer);
			throw new OMNYPAYDAException(ErrorCodeConstants.GET_BAR_CHART_1, ex.getMessage());
		}
		LOGGER.debug(className, METHOD_NAME, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return resultsMap;

	}

public List<CouponVO> getMerchantStoreNameList(CouponVO userCouponVo) throws OMNYPAYDAException {
	String methodName = "getMerchantStoreNameList";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<CouponVO> list = new ArrayList<CouponVO>();
	try {
		GetCouponFilterStoreNameSP proc = new GetCouponFilterStoreNameSP(jdbcTemplate);
		list = proc.execute(userCouponVo);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting merchant store name")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_LANGUAGE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_LANGUAGE, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured getting merchant store name")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured getting merchant store name")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_LANGUAGE).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.GET_LANGUAGE, ex.getMessage());
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<CouponExceptionVO> getCouponExceptionDescList(
		CouponExceptionVO couponExceptionVO) throws OMNYPAYDAException {
	String methodName = "getCouponExceptionDescList";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<CouponExceptionVO> list = new ArrayList<CouponExceptionVO>();
	try {
		GetExceptionDescSP proc = new GetExceptionDescSP(jdbcTemplate);
		list = proc.execute(couponExceptionVO);
	} catch (DataAccessException edae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("DataAccessException occured while getting coupon exception description ")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.DATA_BASE_ERROR).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(edae.getMessage());
		LOGGER.error(className, methodName, edae, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.DATA_BASE_ERROR, edae.getMessage());
	} catch (OMNYPAYDAException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYDAException occured getting coupon exception description")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occured getting coupon exception description")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.DATA_BASE_ERROR).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		throw new OMNYPAYDAException(ErrorCodeConstants.DATA_BASE_ERROR, ex.getMessage());
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return list;
}

public List<DiscountTypeVO> getDiscountDescList(DiscountTypeVO discontTypeVO)
		throws OMNYPAYDAException {
	
		String methodName = "getDiscountDescList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		List<DiscountTypeVO> list = new ArrayList<DiscountTypeVO>();
		try {
			GetDiscountDescSP proc = new GetDiscountDescSP(jdbcTemplate);
			list = proc.execute(discontTypeVO);
		} catch (DataAccessException edae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("DataAccessException occured while getting discount description  ")
					.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.DATA_BASE_ERROR).append(OMNYPAYConstants.COMMA)
					.append("Error Message : ").append(edae.getMessage());
			LOGGER.error(className, methodName, edae, errorBuffer);
			throw new OMNYPAYDAException(ErrorCodeConstants.DATA_BASE_ERROR, edae.getMessage());
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("OMNYPAYDAException occured  getting discount description")
					.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
					.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
					.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYDAException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occured getting  getting discount description")
					.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
					.append(ErrorCodeConstants.DATA_BASE_ERROR).append(OMNYPAYConstants.COMMA)
					.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYDAException(ErrorCodeConstants.DATA_BASE_ERROR, ex.getMessage());
		}
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return list;
	}


*/



}

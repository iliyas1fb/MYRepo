package org.portal.app.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import org.apache.commons.lang.RandomStringUtils;
import org.business.service.CommonService;
import org.business.service.MerchantService;
import org.common.service.GridListResponse;
import org.common.service.MerchantVO;
import org.common.service.User;
import org.common.service.util.PortalConstants;
import org.exception.service.PortalServiceException;
/*import org.apache.commons.lang.RandomStringUtils;
import org.business.service.CommonService;
import org.business.service.MerchantService;
import org.business.service.exception.DCSServiceException;
import org.common.service.CityVO;
import org.common.service.util.CountryVO;
import org.common.service.util.DemographicsVO;
import org.common.service.util.GridListResponse;
import org.common.service.util.MerchantVO;
import org.common.service.util.OMNYPAYConstants;
import org.common.service.util.StateVO;*/
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;






















import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/manageMerchant")
public class ManageMerchantController  {

/** The LOGGER. */
//private static final  Log4jAdapter LOGGER = Log4jAdapter.getInstance();

/** The CLAS s_ name. */
private final String className = this.getClass().getName();

private static final String ADDMERCHANTPAGE = "system/addMerchant";
private static final String ADDMERCHANTKYCPAGE = "system/kycCheckList";
private static final String EDITMERCHANTCPAGE = "system/editMerchant";
private static final String EDITMERCHANTKYCPAGE = "system/editKycCheckList";
private static final String APPROVEMERCHANTPAGE = "system/approveRejectMerchant";
private static final String APPROVEMERCHANKYCTPAGE = "system/approveRejectkycCheckList";
private static final String VIEWKYCCHECKLISTPAGE = "system/viewKYCCheckList";
private static final String VIEWMERCHANTDETAIL = "system/viewMerchantDetail";
private static final String BANKIDLIST = "bankIdList";
private static final String LANGUAGELIST = "languageList";
private static final String CURRENCYLIST = "currencyList";
private static final String COUNTRYLIST = "countryList";
private static final String COUNTRYAREALIST = "countryAreaList";
private static final String MIDLIST = "midList";
private static final String STATELIST = "stateList";
private static final String STATUS = "status";
private static final String ADDMERCHANT = "addMerchant";
private static final String EDITMERCHANT = "editMerchant";
private static final String UTF8 = "UTF-8";
private static final String STATEID = "stateId";
private static final String DOCUMENTLIST = "documentList";
private static final String MERCHANTKYC = "merchantKyc";
private static final String MERCHANTKYCEDIT = "merchantKycEdit";
private static final String APPROVEREJECTMERCHANT = "approveRejectMerchant";
private static final String UPDATEAPPROVEREJECTKYCCHECKLIST = "updateApproveRejectkycCheckList";
private static final String VIEWMERCHANT = "viewMerchant";
private static final String VIEWKYCCHECKLIST = "viewKYCCheckList";
private static final String MANAGEMERCHANTPAGE = "system/manageMerchant";  // Compliant
private static final String MERCHANTSCREDITCARDLIST = "merchantsCreditCardList";
private static final String MERCHANTSDEBITCARDLIST = "merchantsDebitCardList";
private static final String MERCHANTSPRIVATELABElLIST = "merchantsPrivateLabelList";
private static final String MERCHANTSSTORELIST = "merchantsStoreList";
private static final String MERCHANTSGIFTLIST = "merchantsGiftList";
private static final String CREDIT = "CREDIT";
private static final String DEBIT = "DEBIT";
private static final String PRIBATELABEL = "PRIBATE LABEL";
private static final String STORE = "STORE";
private static final String GIFT = "GIFT";

/** The system service. */
//@Resource(name = "commonUtilService")
@Autowired
private CommonService commonService;

/** The system service. */
//@Resource(name = "merchantService")
@Autowired
private MerchantService merchantService;

@RequestMapping(value = "/manageMerchantPage", method = RequestMethod.GET)
public String getManageMerchantPage() {
	String methodName = "getmanagemerchantpage";
	//LOGGER.debug(className, methodName, "Entering into getManageMerchantPage");
	return MANAGEMERCHANTPAGE;
}

//Merchant Listing.......
@RequestMapping(value = "/getList", method = RequestMethod.GET)
public @ResponseBody GridListResponse get(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws PortalServiceException {
	//LogDetails logDetails = LogDetails.getInstance();
	User user =  (User) req.getSession().getAttribute("secUserVO");
	
	String userName = user.getLoginName();
	
	String name = null;
	if(StringUtils.hasLength(req.getParameter("name"))) {
		name = req.getParameter("name");
	}
	Long countryId = null;
	if(StringUtils.hasLength(req.getParameter(COUNTRYLIST))) {
		countryId = Long.parseLong(req.getParameter(COUNTRYLIST));
	}
	String status = null;
	if(StringUtils.hasLength(req.getParameter(STATUS))) {
		status = req.getParameter(STATUS);
	}
	String coperateCode = null;
	String mid = null;
	//List<MerchantVO> list = merchantService.getList(name, countryId, status, coperateCode,mid, logDetails.getUserName());
	List<MerchantVO> list = merchantService.getList(name, countryId, status, coperateCode,mid, userName);
	GridListResponse response = new GridListResponse();
	response.setRows(list);
	response.setRecords(String.valueOf(list.size()));
	response.setPage(PortalConstants.PAGE);
	response.setTotal(PortalConstants.TOTAL);
	return response;
}



//Add Merchant details page
@RequestMapping(value = "/addMerchant", method = RequestMethod.GET)
public String init(ModelMap model, Principal principal) throws PortalServiceException {
	String methodName = "Init";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		//model.addAttribute(BANKIDLIST, getBankIdList(null));
		//model.addAttribute(LANGUAGELIST, getLanguageList());
		//model.addAttribute(CURRENCYLIST, getcurrencyList());
		//model.addAttribute(COUNTRYLIST, this.getCountryList());
		//model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		//model.addAttribute(MIDLIST,geMidList());
		//model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		//model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		//model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		//model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		//model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(ADDMERCHANT, merchantVO);
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder("");
		//errorBuffer.append("Exception occurred while getting the Merchant List").append(OMNYPAYConstants.COMMA).append(sb);
		//LOGGER.error(className, methodName, ex, errorBuffer);
	}
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return ADDMERCHANTPAGE;
}




//After adding the detail for the merchant save method will be called
@RequestMapping(value = "/saveMerchant", method = RequestMethod.POST)
public String postSaveMerchant(@ModelAttribute(ADDMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, ModelMap model,HttpSession session) throws PortalServiceException, ParseException, IOException {
	String methodName = "postSaveMerchant";
	 User user =  (User) request.getSession().getAttribute("secUserVO");
	
	String userName = user.getLoginName();
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	BigDecimal entityId = null;
	String view =null;
	try {
		merchantVO.setCntctFirstName(URLDecoder.decode(merchantVO.getCntctFirstName(), UTF8));
		merchantVO.setCntctLastName(URLDecoder.decode(merchantVO.getCntctLastName(), UTF8));
		merchantVO.setAddress1(URLDecoder.decode(merchantVO.getAddress1(), UTF8));
		merchantVO.setCity(URLDecoder.decode(merchantVO.getCity(), UTF8));
		
		//DemographicsVO demographicsVO = merchantVO.getDemographics();
		//CityVO cityVO = demographicsVO.getCity();
		

		//settingMerchantVo(merchantVO);
		String mid = settingMid(merchantVO);
		merchantVO.setCreatedBy(userName);
		merchantVO.setMid(mid);
		//String newMerchantKey = getMerchantKey(OMNYPAYConstants.ALGTHM_TYPE_AES,merchantVO.getMid());
		//merchantVO.setMerchantAccessKey(newMerchantKey);
	
		request.setAttribute(STATEID, merchantVO.getState());
		entityId = merchantService.createMerchant(merchantVO);
/*		session.setAttribute(ADDMERCHANT, merchantVO);
		request.setAttribute("mid", merchantVO.getMid());
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO.setEntityId(entityId);
		model.addAttribute(DOCUMENTLIST, getDocumentList());
		model.addAttribute(MERCHANTKYC, merchantKYCVO);*/
		view = MANAGEMERCHANTPAGE;
	} catch(PortalServiceException	 pdae) {
		StringBuilder errorBuffer = new StringBuilder();
/*		errorBuffer.append("OMNYPAYServiceException occurred while saving(post) the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		
		revertingMerchant(merchantVO);
		extracted(merchantVO,model);*/
		view = ADDMERCHANTPAGE;
	} catch(Exception ex) {
	/*	StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while saving the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.CREATE_MERCHANT).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.CREATE_MERCHANT));
		revertingMerchant(merchantVO);
		extracted(merchantVO,model);*/
		view = ADDMERCHANTPAGE;
	}
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	model.addAttribute(ADDMERCHANT, merchantVO);
	return view;
}


/*@SuppressWarnings("unchecked")
@RequestMapping(value = "/stateListByCountry", method = RequestMethod.GET)
public @ResponseBody
JSONObject getStateListByCountry(@RequestParam("countryId") Long countryId) throws DCSServiceException{
	String methodName = "getStateListByCountry";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	StateVO stateVO = new StateVO();
	CountryVO countryVO =new CountryVO();
	countryVO.setCountryId(countryId);
	stateVO.setCountry(countryVO);
	JSONObject object = new JSONObject();
	try {
		List<StateVO> list = commonService.getState(stateVO);
		object.put("response", list);		
		
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder("");
		errorBuffer.append("OMNYPAYServiceException occurred while getting the State List by Country")
				   .append(OMNYPAYConstants.COMMA).append(sb);
		LOGGER.error(className, methodName, pdae, errorBuffer);
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder("");
		errorBuffer.append("Exception occurred while getting the State List by Country")
				   .append(OMNYPAYConstants.COMMA).append(sb);
		LOGGER.error(className, methodName, ex, errorBuffer);
	}
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return object;
}*/








/*/**
 * @param model
 * @throws OMNYPAYServiceException 
 *//*
private void extracted(MerchantVO merchantVO,ModelMap model) throws OMNYPAYServiceException {
	if (merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
		model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
	}
	Map<String, String> list = getBankIdList(null);
	model.addAttribute(BANKIDLIST, list);
	model.addAttribute(LANGUAGELIST, getLanguageList());
	model.addAttribute(CURRENCYLIST, getcurrencyList());
	model.addAttribute(COUNTRYLIST, getcountryList());
	model.addAttribute(MIDLIST,geMidList());
	model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
	model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
	model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
	model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
	model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
	model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
	model.addAttribute(EDITMERCHANT, merchantVO);
}
*/


/*
//After adding the detail for the merchant save method will be called
@RequestMapping(value = "/saveMerchant", method = RequestMethod.GET)
public String saveMerchant(@ModelAttribute(ADDMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, ModelMap model,HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "SaveMerchant";
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	BigDecimal entityId = null;
	String view =null;
	merchantVO = (MerchantVO) session.getAttribute(ADDMERCHANT);
	try {
		merchantVO.setCntctFirstName(URLDecoder.decode(merchantVO.getCntctFirstName(), UTF8));
		merchantVO.setCntctLastName(URLDecoder.decode(merchantVO.getCntctLastName(), UTF8));
		
		DemographicsVO demographicsVO = merchantVO.getDemographics();
		CityVO cityVO = demographicsVO.getCity();
		
		demographicsVO.setAddress1(URLDecoder.decode(merchantVO.getDemographics().getAddress1(), UTF8));
		if(null!=merchantVO.getDemographics().getAddress2()){
			demographicsVO.setAddress2(URLDecoder.decode(merchantVO.getDemographics().getAddress2(), UTF8));
		}
		cityVO.setCityName(URLDecoder.decode(merchantVO.getDemographics().getCity().getCityName(), UTF8));
		
		demographicsVO.setCity(cityVO);
		merchantVO.setDemographics(demographicsVO);
		
		if(null == merchantVO.getAccountNumber() || "".equals(merchantVO.getAccountNumber())){
			merchantVO.setAccountNumber(null);
		}
		if(OmnypayUtil.emptyStringCheck(merchantVO.getDemographics().getAddress2())) {
			DemographicsVO demographics = merchantVO.getDemographics();
			demographics.setAddress2(null);
			merchantVO.setDemographics(demographics);
		}
		settingMerchantVo(merchantVO);
		String mid = settingMid(merchantVO);
		merchantVO.setCreatedBy(userName);
		merchantVO.setMid(mid);
		String newMerchantKey = getMerchantKey(OMNYPAYConstants.ALGTHM_TYPE_AES,merchantVO.getMid());
		merchantVO.setMerchantAccessKey(newMerchantKey);
		
		
		if (merchantVO.getExternalMerchant()!=null){
			
			merchantVO.setExternalMerchant("true");
			
		} else {
			
			merchantVO.setExternalMerchant("false");
		}
		
		request.setAttribute(STATEID, merchantVO.getDemographics().getState().getStateId());
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO.setEntityId(entityId);
		model.addAttribute(DOCUMENTLIST, getDocumentList());
		model.addAttribute(MERCHANTKYC, merchantKYCVO);
		view = ADDMERCHANTKYCPAGE;
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while saving the Merchant")
				   .append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				   .append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				   .append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		revertingMerchant(merchantVO);
		extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);extracted(merchantVO,model);
		view = ADDMERCHANTPAGE;
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while saving the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.CREATE_MERCHANT).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.CREATE_MERCHANT));
		revertingMerchant(merchantVO);
		extracted(merchantVO,model);
		view = ADDMERCHANTPAGE;
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	model.addAttribute(ADDMERCHANT, merchantVO);
	return view;
 }
//After adding the detail for the merchant kyc saveKycCheckList method will be called
@RequestMapping(value = "/saveKycCheckList", method = RequestMethod.POST)
public String saveKycCheckList(@ModelAttribute(MERCHANTKYC) MerchantKYCVO merchantKYCVO,BindingResult result, Principal principal,
		HttpServletRequest req, HttpServletResponse res, ModelMap model) throws OMNYPAYServiceException {
	String methodName = "SaveKycCheckList";
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	String view =MANAGEMERCHANTPAGE;
	try {
		merchantKYCVO.setBeneficialOwnerAddress(URLDecoder.decode(merchantKYCVO.getBeneficialOwnerAddress(), UTF8));
		settingMerchantKYCVO(merchantKYCVO);
		merchantKYCVO.setLoginUser(userName);
		merchantService.createMerchantKYC(merchantKYCVO);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while creating the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		model.addAttribute(DOCUMENTLIST, getDocumentList());
		view = ADDMERCHANTKYCPAGE;
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while creating the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.CREATE_MERCHANT_KYC)
				.append(OMNYPAYConstants.COMMA).append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.CREATE_MERCHANT_KYC));
		model.addAttribute(DOCUMENTLIST, getDocumentList());
		view = ADDMERCHANTKYCPAGE;
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	try {
		res.sendRedirect(req.getContextPath()+"/app/manageMerchant/manageMerchantPage");
	} catch (IOException e) {
		LOGGER.info("IOException :",e);
	}
	return view;
}

//Getting the detail for the Edit merchant page using the POST
@RequestMapping(value = "/getEditMerchant", method = RequestMethod.POST)
public String editMerchant(@RequestParam("mid") String mid, ModelMap model,Principal principal, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = EDITMERCHANT;
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitMobileNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
	
		if(merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		
		if (merchantVO.getExternalMerchant().equalsIgnoreCase("true")){
			
			merchantVO.setExternalMerchant("YES");
			
		} else {
			
			merchantVO.setExternalMerchant("NO");
		}
		
		
		
		Map<String, String> list = getBankIdList(null);
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(EDITMERCHANT, merchantVO);
		
		
		
		session.setAttribute("mid", mid);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return EDITMERCHANTCPAGE;
}

//Getting the detail for the Edit merchant page using the GET
@RequestMapping(value = "/getEditMerchant", method = RequestMethod.GET)
public String getEditMerchant(ModelMap model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = "GetEditMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {	
		String mid = req.getParameter("mid");
		if(null == mid){
			mid = (String) session.getAttribute("mid");
			req.setAttribute("mid", mid);
		}
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
		splitMobileNo(merchantVO);
		if(merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		Map<String, String> list = getBankIdList(null);
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(EDITMERCHANT, merchantVO);		
		
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return EDITMERCHANTCPAGE;
}
*

public Map<String, String> getStateCountry(Long countryId) {
	String methodName = "GetStateCountry";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	List<StateVO> list = null;
	try {
		StateVO stateVO = new StateVO();
		stateVO.getCountry().setCountryId(countryId);
		list = commonUtilService.getState(stateVO);
	} catch(OMNYPAYServiceException e) {
		StringBuilder errorBuffer = new StringBuilder("");
		errorBuffer.append("OMNYPAYServiceException occurred while getting State List by Country")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_STATE)
			.append(OMNYPAYConstants.COMMA).append("Error Message : ")
			.append(e.getMessage());
		LOGGER.error(className, methodName, e, errorBuffer);
	}
	Map<String, String> bankList = new LinkedHashMap<String, String>();
	for (StateVO s : list) {
		bankList.put(String.valueOf(s.getStateId()), s.getStateName());
	}
	return bankList;
}
/*
//Get the detail for the Edit merchant KYC page using POST
@RequestMapping(value = "/updateMerchant", method = RequestMethod.POST)
public String postUpdateMerchant(@ModelAttribute(EDITMERCHANT) MerchantVO merchantVO, BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "postUpdateMerchant";
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	String view = "";
	try {
		merchantVO.setCntctFirstName(URLDecoder.decode(merchantVO.getCntctFirstName(), UTF8));
		merchantVO.setCntctLastName(URLDecoder.decode(merchantVO.getCntctLastName(), UTF8));
		
		DemographicsVO demographicsVO = merchantVO.getDemographics();
		CityVO cityVO = demographicsVO.getCity();
		
		demographicsVO.setAddress1(URLDecoder.decode(merchantVO.getDemographics().getAddress1(), UTF8));
		demographicsVO.setAddress2(URLDecoder.decode(merchantVO.getDemographics().getAddress2(), UTF8));
		cityVO.setCityName(URLDecoder.decode(merchantVO.getDemographics().getCity().getCityName(), UTF8));
		
		demographicsVO.setCity(cityVO);
		merchantVO.setDemographics(demographicsVO);
		
		if(null == merchantVO.getAccountNumber() || "".equals(merchantVO.getAccountNumber())){
			merchantVO.setAccountNumber(null);
		}
		
		if(OmnypayUtil.emptyStringCheck(merchantVO.getDemographics().getAddress2())) {
			DemographicsVO demographics = merchantVO.getDemographics();
			demographics.setAddress2(null);
			merchantVO.setDemographics(demographics);
		}
		settingMerchantVo(merchantVO);
		merchantVO.setModifiedBy(userName);
		merchantService.updateMerchant(merchantVO);
		MerchantKYCVO merchantKYCVO;
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		session.setAttribute(EDITMERCHANT, merchantVO);
		request.setAttribute("mid", merchantVO.getMid());
		if(null != merchantKYCVO) {
			// Calling for update KYC
			Long entityId = merchantVO.getEntityId();
			merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
			merchantKYCVO.setMid(merchantVO.getMid());
			map.addAttribute(DOCUMENTLIST, getDocumentList());
			map.addAttribute(MERCHANTKYCEDIT, merchantKYCVO);
			view = EDITMERCHANTKYCPAGE;
		} else {
			// Calling for add KYC
			merchantKYCVO = new MerchantKYCVO();
			Long entityId = merchantVO.getEntityId();
			merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
			merchantKYCVO.setMid(merchantVO.getMid());
			map.addAttribute(DOCUMENTLIST, getDocumentList());
			map.addAttribute(MERCHANTKYC, merchantKYCVO);
			view = ADDMERCHANTKYCPAGE;
		}
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while updating the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		revertingEditMerchant(merchantVO);
		extracted(merchantVO, map);
		view = EDITMERCHANTCPAGE;
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while updating the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.UPDATE_MERCHANT));
		revertingEditMerchant(merchantVO);
		extracted(merchantVO, map);
		view = EDITMERCHANTCPAGE;
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	map.addAttribute(EDITMERCHANT, merchantVO);
	return view;
}

//Get the detail for the Edit merchant KYC page using GET
@RequestMapping(value = "/updateMerchant", method = RequestMethod.GET)
public String updateMerchant(@ModelAttribute(EDITMERCHANT) MerchantVO merchantVO, BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "UpdateMerchant";
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	String view = "";
	merchantVO = (MerchantVO) session.getAttribute(EDITMERCHANT);
	try {
		merchantVO.setCntctFirstName(URLDecoder.decode(merchantVO.getCntctFirstName(), UTF8));
		merchantVO.setCntctLastName(URLDecoder.decode(merchantVO.getCntctLastName(), UTF8));
		
		DemographicsVO demographicsVO = merchantVO.getDemographics();
		CityVO cityVO = demographicsVO.getCity();
		
		demographicsVO.setAddress1(URLDecoder.decode(merchantVO.getDemographics().getAddress1(), UTF8));
		if(null!=merchantVO.getDemographics().getAddress2()){
			demographicsVO.setAddress2(URLDecoder.decode(merchantVO.getDemographics().getAddress2(), UTF8));
		}
		cityVO.setCityName(URLDecoder.decode(merchantVO.getDemographics().getCity().getCityName(), UTF8));
		
		demographicsVO.setCity(cityVO);
		merchantVO.setDemographics(demographicsVO);
		
		if(null == merchantVO.getAccountNumber() || "".equals(merchantVO.getAccountNumber())){
			merchantVO.setAccountNumber(null);
		}
		if(OmnypayUtil.emptyStringCheck(merchantVO.getDemographics().getAddress2())) {
			DemographicsVO demographics = merchantVO.getDemographics();
			demographics.setAddress2(null);
			merchantVO.setDemographics(demographics);
		}
		settingMerchantVo(merchantVO);
		merchantVO.setModifiedBy(userName);
		merchantService.updateMerchant(merchantVO);
		MerchantKYCVO merchantKYCVO;
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		request.setAttribute("mid", merchantVO.getMid());
		if(null != merchantKYCVO) {
			// Calling for update KYC
			Long entityId = merchantVO.getEntityId();
			merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
			merchantKYCVO.setMid(merchantVO.getMid());
			map.addAttribute(DOCUMENTLIST, getDocumentList());
			map.addAttribute(MERCHANTKYCEDIT, merchantKYCVO);
			view = EDITMERCHANTKYCPAGE;
		} else {
			// Calling for add KYC
			merchantKYCVO = new MerchantKYCVO();
			Long entityId = merchantVO.getEntityId();
			merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
			merchantKYCVO.setMid(merchantVO.getMid());
			map.addAttribute(DOCUMENTLIST, getDocumentList());
			map.addAttribute(MERCHANTKYC, merchantKYCVO);
			view = ADDMERCHANTKYCPAGE;
		}
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while updating the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		revertingEditMerchant(merchantVO);
		extracted(merchantVO, map);
		view = EDITMERCHANTCPAGE;
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while updating the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.UPDATE_MERCHANT));
		revertingEditMerchant(merchantVO);
		extracted(merchantVO, map);
		view = EDITMERCHANTCPAGE;
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	map.addAttribute(EDITMERCHANT, merchantVO);
	return view;
	}

//Update the detail for the Edit merchant KYC page
@RequestMapping(value = "/updateKycCheckList", method = RequestMethod.POST)
public String updateKycCheckList(@ModelAttribute(MERCHANTKYCEDIT) MerchantKYCVO merchantKYCVO, BindingResult result, Principal principal,
		HttpServletRequest req, HttpServletResponse res,ModelMap map) throws OMNYPAYServiceException {
	String methodName = "UpdateKycCheckList";
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	String view = MANAGEMERCHANTPAGE;
	try {
		merchantKYCVO.setBeneficialOwnerAddress(URLDecoder.decode(merchantKYCVO.getBeneficialOwnerAddress(), UTF8));
		settingMerchantKYCVO(merchantKYCVO);
		merchantKYCVO.setModifiedBy(userName);
		merchantKYCVO.setLoginUser(userName);
		merchantService.updateMerchantKYC(merchantKYCVO);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while updating the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		view  = EDITMERCHANTKYCPAGE;
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while updating the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.UPDATE_MERCHANT_KYC)
				.append(OMNYPAYConstants.COMMA).append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.UPDATE_MERCHANT_KYC));
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		view = EDITMERCHANTKYCPAGE;
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	try {
		res.sendRedirect(req.getContextPath()+"/app/manageMerchant/manageMerchantPage");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOGGER.info("IOException :",e);
	}
	return view;
}

//Getting the detail for the merchant 
@RequestMapping(value = "/getApproveRejectMerchant", method = RequestMethod.POST)
public String approveRejectMerchant(@RequestParam("mid") String mid, ModelMap model, Principal principal, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = APPROVEREJECTMERCHANT;
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		req.setAttribute("mid", mid);
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
		splitMobileNo(merchantVO);
		if(merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		Map<String, String> list = getBankIdList(null);
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(APPROVEREJECTMERCHANT, merchantVO);
		
		if (merchantVO.getExternalMerchant().equalsIgnoreCase("true")){
			
			merchantVO.setExternalMerchant("YES");
			
		} else {
			
			merchantVO.setExternalMerchant("NO");
		}
		
		
		session.setAttribute("mid", mid);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return APPROVEMERCHANTPAGE;
}

//Getting the detail for the merchant GET for approve&reject
@RequestMapping(value = "/getApproveRejectMerchant", method = RequestMethod.GET)
public String getApproveRejectMerchant(ModelMap model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = "GetApproveRejectMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		String mid = req.getParameter("mid");
		if(null == mid){
			mid = (String) session.getAttribute("mid");
			req.setAttribute("mid", mid);
		}
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
		splitMobileNo(merchantVO);
		if(merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		Map<String, String> list = getBankIdList(null);
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(APPROVEREJECTMERCHANT, merchantVO);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return APPROVEMERCHANTPAGE;
}

//Getting the detail for the merchant KYC GET for approve&reject using POST
@RequestMapping(value = "/approveRejectMerchant", method = RequestMethod.POST)
public String postUpdateApproveRejectMerchant(@ModelAttribute(APPROVEREJECTMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, Model map, HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "PostUpdateApproveRejectMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		Long entityId = merchantVO.getEntityId();
		merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
		merchantKYCVO.setMid(merchantVO.getMid());
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		map.addAttribute(UPDATEAPPROVEREJECTKYCCHECKLIST, merchantKYCVO);
		session.setAttribute(APPROVEREJECTMERCHANT, merchantVO);
		request.setAttribute("mid", merchantVO.getMid());
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT_KYC));
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return APPROVEMERCHANKYCTPAGE;
}

//Getting the detail for the merchant KYC GET for approve&reject using GET
@RequestMapping(value = "/approveRejectMerchant", method = RequestMethod.GET)
public String updateApproveRejectMerchant(@ModelAttribute(APPROVEREJECTMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, Model map, HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "UpdateApproveRejectMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		merchantVO = (MerchantVO) session.getAttribute(APPROVEREJECTMERCHANT);
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		Long entityId = merchantVO.getEntityId();
		merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
		merchantKYCVO.setMid(merchantVO.getMid());
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		map.addAttribute(UPDATEAPPROVEREJECTKYCCHECKLIST, merchantKYCVO);
		session.setAttribute(APPROVEREJECTMERCHANT, merchantVO);
		request.setAttribute("mid", merchantVO.getMid());
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT_KYC));
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return APPROVEMERCHANKYCTPAGE;
}

//Save the comment for the APPROVE&REJECT after merchantKYC
@RequestMapping(value = "/updateApproveRejectkycCheckList", method = RequestMethod.POST)
public String updateApproveRejectkycCheckList(@ModelAttribute(UPDATEAPPROVEREJECTKYCCHECKLIST) MerchantKYCVO merchantKYCVO, BindingResult result,
		Principal principal, HttpServletRequest req, HttpServletResponse res) throws OMNYPAYServiceException {
	String methodName = UPDATEAPPROVEREJECTKYCCHECKLIST;
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		merchantKYCVO.setModifiedBy(userName);
		merchantService.updateMerchantApproveReject(merchantKYCVO);
	} catch(OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while updating the Merchant Approve/Reject")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch(Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while updating the Merchant Approve/Reject")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.UPDATE_MERCHANT_KYC)
				.append(OMNYPAYConstants.COMMA).append("Error Message : ")
				.append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.APPROVE_REJECT));
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	try {
		res.sendRedirect(req.getContextPath()+"/app/manageMerchant/manageMerchantPage");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		LOGGER.info("IOException :",e);
	}
	return MANAGEMERCHANTPAGE;
}

*//**
 * @param merchantKYCVO
 *//*
private void settingMerchantKYCVO(MerchantKYCVO merchantKYCVO) { 
	if (merchantKYCVO.getIsPublicQuotedCompany() == null) {
		merchantKYCVO.setIsPublicQuotedCompany("NO");
	}
	if (merchantKYCVO.getBeneficialOwnerIdentifier() == null) {
		merchantKYCVO.setBeneficialOwnerIdentifier("NO");
	}
	if (merchantKYCVO.getVerified() == null) {
		merchantKYCVO.setVerified("NO");
	}
	if (merchantKYCVO.getDirectorsNameAndAddress() == null) {
		merchantKYCVO.setDirectorsNameAndAddress("NO");
	}
	if (merchantKYCVO.getIsKyvByBank() != null) {
			if ("YES".equals(merchantKYCVO.getIsKyvByBank())  ) {
				merchantKYCVO.setIsKyvByBank("YES");
			} else {
				merchantKYCVO.setIsKyvByBank("NO");
			}
	}
}

*//**
 * @param merchantVO
 *//*
private void splitLevelTwoContactNo(MerchantVO merchantVO) {
	if(merchantVO.getLevelTwoContactNo()!=null){
		if (StringUtils.hasLength(merchantVO.getLevelTwoContactNo())) {
			String[] contactNoLevelTwo = merchantVO.getLevelTwoContactNo().split("-");
			if(contactNoLevelTwo.length != 0){
				merchantVO.setLevelTwoCountryAreaCode(contactNoLevelTwo[0]);
				merchantVO.setLevelTwoareaCode(contactNoLevelTwo[1]);
				merchantVO.setLevelTwoContactNo(contactNoLevelTwo[2]);
			}else{
				merchantVO.setLevelTwoareaCode(null);
				merchantVO.setLevelTwoContactNo(null);
				merchantVO.setLevelTwoCountryAreaCode(null);
			}
		}
	}
	
}

*//**
 * @param merchantVO
 *//*
private void splitLevelOneContactNo(MerchantVO merchantVO) {
	if(merchantVO.getLevelOneContactNo()!=null){
		if (StringUtils.hasLength(merchantVO.getLevelOneContactNo())) {
			String[] contactNoLevelOne = merchantVO.getLevelOneContactNo().split("-");
			merchantVO.setLevelOneCountryAreaCode(contactNoLevelOne[0]);
			merchantVO.setLevelOneareaCode(contactNoLevelOne[1]);
			merchantVO.setLevelOneContactNo(contactNoLevelOne[2]);
		}
	}
	
}

*//**
 * @param merchantVO
 *//*
private void splitContactNo(MerchantVO merchantVO) {
	if (StringUtils.hasLength(merchantVO.getCntctPhoneNo())) {
		String[] contactNo = merchantVO.getCntctPhoneNo().split("-");
		merchantVO.setCountryAreaCode(contactNo[0]);
		merchantVO.setAreaCode(contactNo[1]);
		merchantVO.setCntctPhoneNo(contactNo[2]);
	}
}


*//**
 * @param merchantVO
 *//*
private void splitMobileNo(MerchantVO merchantVO) {
	if(merchantVO.getCntctMobileNo()!=null){
		if (StringUtils.hasLength(merchantVO.getCntctMobileNo())) {
			String[] contactMobileNo = merchantVO.getCntctMobileNo().split("-");
			if(contactMobileNo.length != 1){
				merchantVO.setMobileCountryAreaCode(contactMobileNo[0]);
				merchantVO.setCntctMobileNo(contactMobileNo[1]);
			}else{
				merchantVO.setMobileCountryAreaCode(null);
				merchantVO.setCntctMobileNo(null);
			}
		}
	}
}



/**
 * @param merchantVO
 */
/*private void settingMerchantVo(MerchantVO merchantVO) {

if (merchantVO.getAutoRenew() == null) {
		merchantVO.setAutoRenew("NO");
	}
	if (merchantVO.getCreditCard() == null) {
		merchantVO.setCreditCard("NO");
	}
	if (merchantVO.getDebitCard() == null) {
		merchantVO.setDebitCard("NO");
	}
	if (merchantVO.getPrivateLabel() == null) {
		merchantVO.setPrivateLabel("NO");
	}
	if (merchantVO.getStoreCards() == null) {
		merchantVO.setStoreCards("NO");
	}
	if (merchantVO.getGiftCards() == null) {
		merchantVO.setGiftCards("NO");
	}
	if (merchantVO.getExternalMerchant() == null) {
		
		merchantVO.setExternalMerchant("false");
	} else if (merchantVO.getExternalMerchant().equalsIgnoreCase("YES")){
		
		merchantVO.setExternalMerchant("true");
	}
	

	
	StringBuilder mobileNumber = new StringBuilder();
	if(!"".equals(merchantVO.getMobileCountryAreaCode()) && !"".equals(merchantVO.getCntctMobileNo()) && !merchantVO.getCntctMobileNo().contains("-")){
		mobileNumber =mobileNumber.append(merchantVO.getMobileCountryAreaCode()).append("-").append(merchantVO.getCntctMobileNo());
		merchantVO.setCntctMobileNo(mobileNumber.toString());
	}
	
	
	StringBuilder contactNumber = new StringBuilder();
	if(!merchantVO.getCntctPhoneNo().contains("-")){
		contactNumber =contactNumber.append(merchantVO.getCountryAreaCode()).append("-").append(merchantVO.getAreaCode()).append("-").append(merchantVO.getCntctPhoneNo());
		merchantVO.setCntctPhoneNo(contactNumber.toString());
	}

	StringBuilder levelOnecontactNo = new StringBuilder();
	if(!merchantVO.getLevelOneContactNo().contains("-")){
		levelOnecontactNo = levelOnecontactNo.append(merchantVO.getLevelOneCountryAreaCode()).append("-").append(merchantVO.getLevelOneareaCode()).append("-").append(merchantVO.getLevelOneContactNo());
		merchantVO.setLevelOneContactNo(levelOnecontactNo.toString());
	}		

	StringBuilder levelTwocontactNo = new StringBuilder();
	if(!"".equals(merchantVO.getLevelTwoareaCode()) && !"".equals(merchantVO.getLevelTwoContactNo()) && !merchantVO.getLevelTwoContactNo().contains("-")){
		levelTwocontactNo = levelTwocontactNo.append(merchantVO.getLevelTwoCountryAreaCode()).append("-").append(merchantVO.getLevelTwoareaCode()).append("-").append(merchantVO.getLevelTwoContactNo());
		merchantVO.setLevelTwoContactNo(levelTwocontactNo.toString());
	}
	if(null != merchantVO.getValidTo()){
		merchantVO.setValidTo(changeValidTo(merchantVO.getValidTo()));
	}
}*/

private String settingMid(MerchantVO merchantVO) throws PortalServiceException {
	String whichType = merchantVO.getMidGenerated();
	String mid = null;
	String midStr = null;
	String midNum = null;
	boolean isMidPresent = true;
	//while (isMidPresent) {
		if (whichType != null && "SYSTEM".equals(whichType)) {
			// System generated
			midStr = RandomStringUtils.random(6, true, false);
			midNum = RandomStringUtils.random(9, false, true);
			mid = midStr + midNum;
			//long count = merchantService.isMidCount(mid);
			/*if (count > 0) {
				isMidPresent = true;
			} else {
				isMidPresent = false;
			}*/
		} else {
			// Custom generated
			midStr = merchantVO.getCustom();
			midNum = RandomStringUtils.random(9, false, true);
			mid = midStr + midNum;
			/*long count = merchantService.isMidCount(mid);
			if (count > 0) {
				isMidPresent = true;
			} else {
				isMidPresent = false;
			}*/
		}
	//}
	return mid;
}
/*
public static String getMerchantKey(String algorithmType,String mid) throws SecurityException
{
	String randomString = null;
	if (OMNYPAYConstants.ALGTHM_TYPE_AES.equals(algorithmType))
	{
		randomString = generateRandomString(OMNYPAYConstants.KEY_SIZE_AES);
	}
	else if (OMNYPAYConstants.ALGTHM_TYPE_3DES.equals(algorithmType))
	{
		randomString = generateRandomString(OMNYPAYConstants.KEY_SIZE_3DES);
	}
//	Encryption encryption = EncryptionFactory.getEncryptionInstance(algorithmType);
//	return encryption.encrypt(randomString,mid.substring(0,16));
	return randomString;
}

*//**
 * This method will generate random string based on given length.
 * 
 * @param length
 *            - length of the String.
 * @return the string
 *//*
public static String generateRandomString(int length)
{
	String ALPHA_NUM = "9876543210abcdefghijklmnopqrstuvwxyz-";
	StringBuffer sb = new StringBuffer(length);
	for (int i = 0; i < length; i++)
	{
		int ndx = (int) (Math.random() * ALPHA_NUM.length());
		sb.append(ALPHA_NUM.charAt(ndx));
	}
	return sb.toString();
}

*/
/*@SuppressWarnings("unchecked")
@RequestMapping(value = "/countryList", method = RequestMethod.GET)
public @ResponseBody JSONObject getCountryList() {
	String methodName = "getCountryList";
	//LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	CountryVO countryVO = new CountryVO();
	JSONObject object = new JSONObject();
	try {
		List<CountryVO> list = commonService.getCountry(countryVO);
		object.put("response", list);
	} catch (DCSServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder("");
		//errorBuffer.append("OMNYPAYServiceException occurred while maxPAmtOptionPerUserList").append(OMNYPAYConstants.COMMA).append(sb);
		//LOGGER.error(className, methodName, pdae, errorBuffer);
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder("");
		//errorBuffer.append("Exception occurred while maxPAmtOptionPerUserList").append(OMNYPAYConstants.COMMA).append(sb);
		//LOGGER.error(className, methodName, ex, errorBuffer);
	}
	//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return object;
}*/
/*
public void revertingEditMerchant(MerchantVO merchantVO) {
	
	if ("NO".equals(merchantVO.getAutoRenew())) {
		merchantVO.setAutoRenew(null);
	} else{
		merchantVO.setAutoRenew("YES");
	}
	
	if ("NO".equals(merchantVO.getCreditCard())) {
		merchantVO.setCreditCard(null);
	} else{
		merchantVO.setCreditCard("YES");
	}
	if ("NO".equals(merchantVO.getDebitCard())) {
		merchantVO.setDebitCard(null);
	} else{
		merchantVO.setDebitCard("YES");
	}
	if ("NO".equals(merchantVO.getPrivateLabel())) {
		merchantVO.setPrivateLabel(null);
	} else{
		merchantVO.setPrivateLabel("YES");
	}
	if ("NO".equals(merchantVO.getStoreCards())) {
		merchantVO.setStoreCards(null);
	} else{
		merchantVO.setStoreCards("YES");
	}
	if ("NO".equals(merchantVO.getGiftCards())) {
		merchantVO.setGiftCards(null);
	} else{
		merchantVO.setGiftCards("YES");
	}
	if ("false".equals(merchantVO.getExternalMerchant())) {
		merchantVO.setExternalMerchant(null);
	} else{
		merchantVO.setExternalMerchant("YES");
	}
	
	if (null != merchantVO.getCustom()&& !merchantVO.getCustom().isEmpty()) {
		merchantVO.setMidGenerated("CUSTOM");
	} else{			
		merchantVO.setMidGenerated("SYSTEM");
	}
	
	String contactNumber = merchantVO.getCntctPhoneNo().split("-")[2];
	merchantVO.setCntctPhoneNo(contactNumber);
	
	if(null != merchantVO.getCntctMobileNo() && (merchantVO.getCntctMobileNo().split("-")).length > 1){
	String mobileNumber = merchantVO.getCntctMobileNo().split("-")[1];
	merchantVO.setCntctMobileNo(mobileNumber);
	}
	String levelOnecontactNo = merchantVO.getLevelOneContactNo().split("-")[2];
	merchantVO.setLevelOneContactNo(levelOnecontactNo);

	if(null != merchantVO.getLevelTwoContactNo() && (merchantVO.getLevelTwoContactNo().split("-")).length > 2){
		String levelTwocontactNo = merchantVO.getLevelTwoContactNo().split("-")[2];
		merchantVO.setLevelTwoContactNo(levelTwocontactNo);
	}
}

public void revertingMerchant(MerchantVO merchantVO) {
	
	if ("YES".equals(merchantVO.getParentMerchant())) {
		merchantVO.setParentMerchant("YES");
	} else{
		merchantVO.setParentMerchant("NO");
	}
	if ("NO".equals(merchantVO.getCreditCard())) {
		merchantVO.setCreditCard(null);
	} else{
		merchantVO.setCreditCard("NO");
	}
	if ("NO".equals(merchantVO.getDebitCard())) {
		merchantVO.setDebitCard(null);
	} else{
		merchantVO.setDebitCard("NO");
	}
	if ("NO".equals(merchantVO.getPrivateLabel())) {
		merchantVO.setPrivateLabel(null);
	} else{
		merchantVO.setPrivateLabel("NO");
	}
	if ("NO".equals(merchantVO.getStoreCards())) {
		merchantVO.setStoreCards(null);
	} else{
		merchantVO.setStoreCards("NO");
	}
	if ("NO".equals(merchantVO.getGiftCards())) {
		merchantVO.setGiftCards(null);
	} else{
		merchantVO.setGiftCards("NO");
	}
	if ("false".equals(merchantVO.getExternalMerchant())) {
		merchantVO.setExternalMerchant(null);
	} else{
		merchantVO.setExternalMerchant("YES");
	}
	
	
	if(null != merchantVO.getCntctMobileNo() && (merchantVO.getCntctMobileNo().split("-")).length > 1){
	String mobileNumber = merchantVO.getCntctMobileNo().split("-")[1];
	merchantVO.setCntctMobileNo(mobileNumber);
	}
	String contactNumber = merchantVO.getCntctPhoneNo().split("-")[2];
	merchantVO.setCntctPhoneNo(contactNumber);

	String levelOnecontactNo = merchantVO.getLevelOneContactNo().split("-")[2];
	merchantVO.setLevelOneContactNo(levelOnecontactNo);
	if(null != merchantVO.getLevelTwoContactNo() && (merchantVO.getLevelTwoContactNo().split("-")).length > 2){
		String levelTwocontactNo = merchantVO.getLevelTwoContactNo().split("-")[2];
		merchantVO.setLevelTwoContactNo(levelTwocontactNo);
	}
}

@InitBinder
protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat(dbDateFormatVal);
	CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	binder.registerCustomEditor(Date.class, editor);
}

@RequestMapping(value = "/getViewMerchant", method = RequestMethod.POST)
public String postViewMerchant(@RequestParam("mid")	String mid, @RequestParam(STATUS) String status, ModelMap model, Principal principal,
		HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = "PostViewMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
		splitMobileNo(merchantVO);
		if (merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		
		if (merchantVO.getExternalMerchant().equalsIgnoreCase("true")){
			
			merchantVO.setExternalMerchant("YES");
			
		} else {
			
			merchantVO.setExternalMerchant("NO");
		}
		
		
		Map<String, String> list = getBankIdList(merchantVO.getBankId());
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(VIEWMERCHANT, merchantVO);
		model.addAttribute(STATUS, status);
		session.setAttribute("mid", mid);
		session.setAttribute(STATUS, status);
		
		
		req.setAttribute("mid", mid);
		req.setAttribute(STATUS, status);
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return VIEWMERCHANTDETAIL;
}
@RequestMapping(value = "/getViewMerchant", method = RequestMethod.GET)
public String getViewMerchant(ModelMap model, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws GenericException {
	String methodName = "GetViewMerchant";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	MerchantVO merchantVO = new MerchantVO();
	try {
		String mid = req.getParameter("mid");
		String status = req.getParameter(STATUS);
		if(null == mid && null == status){
			mid = (String) session.getAttribute("mid");
			status = (String) session.getAttribute(STATUS);
			req.setAttribute("mid", mid);
			req.setAttribute(STATUS, status);
		}
		merchantVO = merchantService.getMerchant(mid);
		splitContactNo(merchantVO);
		splitLevelOneContactNo(merchantVO);
		splitLevelTwoContactNo(merchantVO);
		splitMobileNo(merchantVO);
		if (merchantVO.getDemographics() != null && merchantVO.getDemographics().getCountry() != null) {
			model.addAttribute(STATELIST, getStateCountry(merchantVO.getDemographics().getCountry().getCountryId()));
		}
		Map<String, String> list = getBankIdList(merchantVO.getBankId());
		model.addAttribute(BANKIDLIST, list);
		model.addAttribute(LANGUAGELIST, getLanguageList());
		model.addAttribute(CURRENCYLIST, getcurrencyList());
		model.addAttribute(COUNTRYLIST, getcountryList());
		model.addAttribute(COUNTRYAREALIST, getCountryAreaList());
		model.addAttribute(MIDLIST,geMidList());
		model.addAttribute(MERCHANTSCREDITCARDLIST,getMerchantsCardList(CREDIT));
		model.addAttribute(MERCHANTSDEBITCARDLIST,getMerchantsCardList(DEBIT));
		model.addAttribute(MERCHANTSPRIVATELABElLIST,getMerchantsCardList(PRIBATELABEL));
		model.addAttribute(MERCHANTSSTORELIST,getMerchantsCardList(STORE));
		model.addAttribute(MERCHANTSGIFTLIST,getMerchantsCardList(GIFT));
		model.addAttribute(VIEWMERCHANT, merchantVO);
		model.addAttribute(STATUS, status);		
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT));
	}
	return VIEWMERCHANTDETAIL;
}
@RequestMapping(value = "/viewMerchant", method = RequestMethod.POST)
public String viewMerchant(@ModelAttribute(VIEWMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, Model map,HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = VIEWMERCHANT;
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		Long entityId = merchantVO.getEntityId();
		merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
		merchantKYCVO.setMid(merchantVO.getMid());
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		map.addAttribute(VIEWKYCCHECKLIST, merchantKYCVO);
		session.setAttribute(VIEWMERCHANT, merchantVO);
		request.setAttribute("mid", merchantVO.getMid());
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant KYC")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT_KYC));
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return VIEWKYCCHECKLISTPAGE;
}

//View for the Merchant KYC using GET
@RequestMapping(value = "/viewMerchant", method = RequestMethod.GET)
public String getViewMerchant(@ModelAttribute(VIEWMERCHANT) MerchantVO merchantVO,BindingResult result, Principal principal,
		HttpServletRequest request, HttpServletResponse response, Model map, HttpSession session) throws OMNYPAYServiceException, ParseException, IOException {
	String methodName = "GetViewMerchant1";
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		merchantVO = (MerchantVO) session.getAttribute(VIEWMERCHANT);		
		MerchantKYCVO merchantKYCVO = new MerchantKYCVO();
		merchantKYCVO = merchantService.getMerchantKYC(merchantVO.getMid());
		Long entityId = merchantVO.getEntityId();
		merchantKYCVO.setEntityId(BigDecimal.valueOf(entityId));
		merchantKYCVO.setMid(merchantVO.getMid());
		map.addAttribute(DOCUMENTLIST, getDocumentList());
		map.addAttribute(VIEWKYCCHECKLIST, merchantKYCVO);
		request.setAttribute("mid", merchantVO.getMid());
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while getting the Merchant KYC")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while getting the Merchant KYC")
		.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
		.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
		.append("Error Message : ").append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		request.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.GET_MERCHANT_KYC));
	}
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	return VIEWKYCCHECKLISTPAGE;
}

@RequestMapping(value = "/viewKYCCheckList", method = RequestMethod.POST)
public String postViewKYCCheckList(@ModelAttribute(VIEWKYCCHECKLIST) MerchantKYCVO merchantKYCVO,BindingResult result, Principal principal,
		HttpServletRequest req, HttpServletResponse res) throws OMNYPAYServiceException {
	String methodName = VIEWKYCCHECKLIST;
	String userName = principal.getName();
	LogDetails logDetails = LogDetails.getInstance();
	StringBuilder sb = new StringBuilder();
	sb.append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
	LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
	try {
		merchantKYCVO.setModifiedBy(userName);
		merchantService.updateMerchantApproveReject(merchantKYCVO);
	} catch (OMNYPAYServiceException pdae) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("OMNYPAYServiceException occurred while updating the Merchant Approve/Reject")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
				.append("Error Message : ").append(pdae.getMessage());
		LOGGER.error(className, methodName, pdae, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(pdae.getErrorCode()));
	} catch (Exception ex) {
		StringBuilder errorBuffer = new StringBuilder();
		errorBuffer.append("Exception occurred while updating the Merchant Approve/Reject")
				.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
				.append(ErrorCodeConstants.UPDATE_MERCHANT_KYC)
				.append(OMNYPAYConstants.COMMA).append("Error Message : ")
				.append(ex.getMessage());
		LOGGER.error(className, methodName, ex, errorBuffer);
		req.setAttribute("errorMessage", MessageUtil.getMessage(ErrorCodeConstants.APPROVE_REJECT));
		}
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return MANAGEMERCHANTPAGE;
	}

//Merchant Listing.......
@RequestMapping(value = "/getActiveMerchantDashBoardList", method = RequestMethod.GET)
public @ResponseBody GridListResponse getMerchatnAcitiveDashBoardList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws OMNYPAYServiceException {
	LogDetails logDetails = LogDetails.getInstance();
	String status=null;
	List<MerchantVO> list = merchantService.getActiveMerchantDashBoardList(logDetails.getUserName(),status);
	GridListResponse response = new GridListResponse();
	response.setRows(list);
	response.setRecords(String.valueOf(list.size()));
	response.setPage(OMNYPAYConstants.PAGE);
	response.setTotal(OMNYPAYConstants.TOTAL);
	return response;
}

//Merchant Listing.......
@RequestMapping(value = "/getPendingMerchantDashBoardList", method = RequestMethod.GET)
public @ResponseBody GridListResponse getMerchatnPendingDashBoardList(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws OMNYPAYServiceException {
	LogDetails logDetails = LogDetails.getInstance();
	String status=null;
	List<MerchantVO> list = merchantService.getPendingMerchantDashBoardList(logDetails.getUserName(),status);
	GridListResponse response = new GridListResponse();
	response.setRows(list);
	response.setRecords(String.valueOf(list.size()));
	response.setPage(OMNYPAYConstants.PAGE);
	response.setTotal(OMNYPAYConstants.TOTAL);
	return response;
}

	
	private Date changeValidTo(Date validTo){
		Calendar calendar = Calendar.getInstance();
		if (validTo != null){
			calendar.setTime(validTo);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND,0);
		java.util.Date newValidTo = calendar.getTime();
		return newValidTo;
	}*/
}
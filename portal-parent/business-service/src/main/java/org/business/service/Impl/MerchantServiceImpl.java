
package org.business.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.business.service.MerchantService;
import org.common.service.MerchantVO;
import org.exception.service.PortalServiceException;
import org.persistent.service.dao.MerchantDAO;
import org.persistent.service.pojo.PortalSvrMerchantAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * The Class MerchantService handles all the functionalities MerchantService.
 */
@Service("merchantService")
@Transactional
public class MerchantServiceImpl implements MerchantService {
	
	/** The LOGGER. */
//	private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();

	/** The CLAS s_ name. */
	private final String className = this.getClass().getName();

	/** The system dao. */
	@Autowired
	private MerchantDAO merchantDAO;	

	/**
	 * @return the merchantDAO
	 */
/*	public MerchantDAO getMerchantDAO() {
		return merchantDAO;
	}

	*//**
	 * @param merchantDAO the merchantDAO to set
	 *//*
	public void setMerchantDAO(MerchantDAO merchantDAO) {
		this.merchantDAO = merchantDAO;
	}*/
	public List<MerchantVO> getList(String name, Long countryId, String status,String coperateCode,String mid,String loginUser) throws PortalServiceException {
		String methodName = "getList";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
	//	.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		List<MerchantVO> merchantList = new ArrayList<MerchantVO>();;
		
		List<PortalSvrMerchantAccount> merchantListDb= null;
		
		try {
			
			merchantListDb = merchantDAO.getList(name,countryId,status,coperateCode,mid,loginUser);
		
			
			for (PortalSvrMerchantAccount merchantAccount:merchantListDb){
				
				MerchantVO merchantVO = new MerchantVO();
				
				merchantVO.setMid(merchantAccount.getMerchantId());
				merchantVO.setBusinessName(merchantAccount.getBusinessName());
				merchantVO.setDispalyName(merchantAccount.getDisplayName());
				merchantVO.setContactPerson(merchantAccount.getFirstname());
				merchantVO.setCountry("USA");
				merchantVO.setId(merchantAccount.getId());
				merchantVO.setMerchantId(Long.valueOf(merchantAccount.getId()));
				merchantList.add(merchantVO);
			}
			
		
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			/*errorBuffer.append("Exception occurred while getting the List<MerchantVO>")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_MERCHANT_LIST).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_MERCHANT_LIST,ex.getMessage());*/
		}
		/*sb.append("List<MerchantVO> Size : ").append(merchantList.size())
		.append(OMNYPAYConstants.COMMA);*/

		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantList;
	}

	/*public MerchantVO getMerchant(String mid) throws OMNYPAYServiceException {
		String methodName = "getMerchant";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		MerchantVO merchantVO;
		try {
			merchantVO = merchantDAO.getMerchant(mid);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_MERCHANT).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_MERCHANT,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantVO;
	}

	public MerchantKYCVO getMerchantKYC(String mid) throws OMNYPAYServiceException {
		String methodName = "getMerchantKYC";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		MerchantKYCVO merchantKYCVO;
		try {
			merchantKYCVO = merchantDAO.getMerchantKYC(mid);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_MERCHANT_KYC,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantKYCVO;
	}
*/
	public BigDecimal createMerchant(MerchantVO merchantVO)throws PortalServiceException {
		String methodName = "createMerchant";
		//LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		//sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		//.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		BigDecimal entityId = null;
		try {
			
			PortalSvrMerchantAccount portalSvrMerchantAccount = new PortalSvrMerchantAccount();
			
			portalSvrMerchantAccount.setFirstname(merchantVO.getCntctFirstName());
			portalSvrMerchantAccount.setLastname(merchantVO.getCntctLastName());
			portalSvrMerchantAccount.setBusinessName(merchantVO.getBusinessName());
			portalSvrMerchantAccount.setDisplayName(merchantVO.getDispalyName());
			portalSvrMerchantAccount.setEmail(merchantVO.getCntctPrimaryEmail());
			portalSvrMerchantAccount.setMerchantId(merchantVO.getMid());	
			portalSvrMerchantAccount.setContactNumber(merchantVO.getCntctPrimaryEmail());
			portalSvrMerchantAccount.setCountry(0l);
			portalSvrMerchantAccount.setState(0l);
			portalSvrMerchantAccount.setTitle(merchantVO.getCntctTitle());
			portalSvrMerchantAccount.setAddress(merchantVO.getAddress1());
			portalSvrMerchantAccount.setZipcode(merchantVO.getZipcode());
				
				entityId	= merchantDAO.createMerchant(portalSvrMerchantAccount);
				
				
			} /*catch (DCSServiceException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while creating the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		}*/ catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			/*errorBuffer.append("Exception occurred while creating the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.CREATE_MERCHANT).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.CREATE_MERCHANT,ex.getMessage());*/
		}		
		//LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));		
		return entityId;
	}

	/*public void createMerchantKYC(MerchantKYCVO merchantKYCVO)throws OMNYPAYServiceException {
		String methodName = "createMerchantKYC";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		try {
			merchantDAO.createMerchantKYC(merchantKYCVO);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while creating the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while creating the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.CREATE_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.CREATE_MERCHANT_KYC,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));			
	}

	public void updateMerchant(MerchantVO merchantVO)throws OMNYPAYServiceException {
		String methodName = "updateMerchant";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		try {
			merchantDAO.updateMerchant(merchantVO);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while updating the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while updating the MerchantVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.UPDATE_MERCHANT).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.UPDATE_MERCHANT,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));		
		
	}

	public void updateMerchantKYC(MerchantKYCVO merchantKYCVO)throws OMNYPAYServiceException {
		String methodName = "updateMerchantKYC";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		try {
			merchantDAO.updateMerchantKYC(merchantKYCVO);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while updating the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while updating the MerchantKYCVO")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.UPDATE_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.UPDATE_MERCHANT_KYC,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		
	}

	public Long isMidCount(String mid) throws OMNYPAYServiceException {
		String methodName = "isMidCount";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		Long long1 = null;
		try {
			long1 = merchantDAO.isMidCount(mid);
		}catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the MIDCOUNT")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the MIDCOUNT")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.MID_COUNT).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.MID_COUNT,ex.getMessage());
		}			
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return long1;
	}
	public void updateMerchantApproveReject(MerchantKYCVO merchantKYCVO)throws OMNYPAYServiceException {
		String methodName = "updateMerchantApproveReject";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		try {
			merchantDAO.updateMerchantApproveReject(merchantKYCVO);
		
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while updating the MerchantApproveReject")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while updating the MerchantApproveReject")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.UPDATE_MERCHANT_KYC).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.UPDATE_MERCHANT_KYC,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
	}

	public List<MerchantKYCVO> getKycDocTypes() throws OMNYPAYServiceException {
		String methodName = "getKycDocTypes";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		List<MerchantKYCVO> merchantKycVOList=null;
		try {
			merchantKycVOList = merchantDAO.getKycDocTypes();
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the KycDocTypes")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the KycDocTypes")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.KYCDOCMNTTYPESSP).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.KYCDOCMNTTYPESSP,ex.getMessage());
		}		
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantKycVOList;
	}

	public List<MerchantIDVO> getMerchantIdList(MerchantIDVO merchantIdVO) throws OMNYPAYServiceException {
		String methodName = "getMerchantIdList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		
		List<MerchantIDVO> merchantIdList = null;
		
		try{
			merchantIdList = merchantDAO.getMerchantIdList(merchantIdVO);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("OMNYPAYDAException occured while getting the List<merchantIdVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ").append(pdae.getErrorCode())
					.append(",").append("Error Message : ")
					.append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occured while getting the List<merchantIdVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ")
					.append(ErrorCodeConstants.GET_MERCHANT).append(",")
					.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_MERCHANT, ex.getMessage());
		}
		sb.append("List<CountryVO> Size : ").append(merchantIdList.size()).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantIdList;
	}
	
	public List<MerchantIDVO> getMerchantsCardList(MerchantIDVO merchantIdVO) throws OMNYPAYServiceException {
		String methodName = "getMerchantsCardList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA).append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		
		List<MerchantIDVO> merchantIdList = null;
		
		try{
			merchantIdList = merchantDAO.getMerchantsCardList(merchantIdVO);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
					.append("OMNYPAYDAException occured while getting the List<merchantIdVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ").append(pdae.getErrorCode())
					.append(",").append("Error Message : ")
					.append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occured while getting the List<merchantIdVO>")
					.append(OMNYPAYConstants.COMMA).append(sb)
					.append("Error Code : ")
					.append(ErrorCodeConstants.GET_MERCHANT).append(",")
					.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_MERCHANT, ex.getMessage());
		}
		sb.append("List<CountryVO> Size : ").append(merchantIdList.size()).append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantIdList;
	}
	
	public List<MerchantVO> getActiveMerchantDashBoardList(String loginUser,String status) throws OMNYPAYServiceException {
		String methodName = "getActiveMerchantDashBoardList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		List<MerchantVO> merchantList;
		try {
			merchantList = merchantDAO.getActiveMerchantDashBoardList(loginUser,status);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the List<MerchantVO>")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the List<MerchantVO>")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_ACTIVE_MERCHANT_LIST).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_ACTIVE_MERCHANT_LIST,ex.getMessage());
		}
		sb.append("List<MerchantVO> Size : ").append(merchantList.size())
		.append(OMNYPAYConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantList;
	}
	
	public List<MerchantVO> getPendingMerchantDashBoardList(String loginUser,String status) throws OMNYPAYServiceException {
		String methodName = "getPendingMerchantDashBoardList";
		LogDetails logDetails = LogDetails.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append("userName=").append(logDetails.getUserName()).append(OMNYPAYConstants.COMMA)
		.append("Arg userName=").append("").append(OMNYPAYConstants.COMMA);
		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_ENTRY));
		List<MerchantVO> merchantList;
		try {
			merchantList = merchantDAO.getPendingMerchantDashBoardList(loginUser,status);
		} catch (OMNYPAYDAException pdae) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer
			.append("OMNYPAYDAException occurred while getting the List<MerchantVO>")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(pdae.getErrorCode()).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(pdae.getMessage());
			LOGGER.error(className, methodName, pdae, errorBuffer);
			throw new OMNYPAYServiceException(pdae.getErrorCode(), pdae.getMessage());
		} catch (Exception ex) {
			StringBuilder errorBuffer = new StringBuilder();
			errorBuffer.append("Exception occurred while getting the List<MerchantVO>")
			.append(OMNYPAYConstants.COMMA).append(sb).append("Error Code : ")
			.append(ErrorCodeConstants.GET_PENDING_MERCHANT_LIST).append(OMNYPAYConstants.COMMA)
			.append("Error Message : ").append(ex.getMessage());
			LOGGER.error(className, methodName, ex, errorBuffer);
			throw new OMNYPAYServiceException(ErrorCodeConstants.GET_PENDING_MERCHANT_LIST,ex.getMessage());
		}
		sb.append("List<MerchantVO> Size : ").append(merchantList.size())
		.append(OMNYPAYConstants.COMMA);

		LOGGER.debug(className, methodName, sb.toString().concat(OMNYPAYConstants.LOG_EXIT));
		return merchantList;
	}	*/
}

package org.persistent.service.dao;

import java.math.BigDecimal;
import java.util.List;

import org.common.service.MerchantVO;
import org.exception.service.PortalDAException;
import org.persistent.service.pojo.PortalSvrMerchantAccount;





/**
 * The Interface MerchantDAO.
 */
public interface MerchantDAO{
	/**
	 * Gets MerchantVO list.
	 * @return List<MerchantVO>
	 * @throws OMNYPAYDAException
	 */
	List<PortalSvrMerchantAccount> getList(String name,Long countryId, String status,String coperateCode,String mid,String loginUser) throws PortalDAException;
	/**
	 * Get MerchantVO.
	 * @return MerchantVO
	 * @throws OMNYPAYDAException
	 */
	// MerchantVO getMerchant(String mid) throws OMNYPAYDAException;
	/**
	 * Get MerchantKYCVO.
	 * @return MerchantKYCVO
	 * @throws OMNYPAYDAException
	 */
	// MerchantKYCVO getMerchantKYC(String mid) throws OMNYPAYDAException;
	/**
	 * CreateMerchant MerchantVO.
	 * @throws OMNYPAYDAException
	 */
	 BigDecimal createMerchant(PortalSvrMerchantAccount merchantVO) throws PortalDAException;
	/**
	 * CreateMerchantKYC MerchantKYCVO.
	 * @throws OMNYPAYDAException
	 */
	
	
}

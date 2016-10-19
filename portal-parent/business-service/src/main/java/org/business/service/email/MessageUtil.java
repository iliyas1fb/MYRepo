
package org.business.service.email;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

//import com.omnypay.framework.common.util.SpringBeanLocator;

/**
 * This class handles MessageUtil.
 */
public class MessageUtil {
	/** The Constant MESSAGE_RESOURCE_KEY. */
	public static final String MESSAGE_RESOURCE_KEY = "messageSource";
	
	//@Autowired
	//SpringBeanLocator springBeanLocator;

	/**
	 * Instantiates a new message util.
	 */
	public MessageUtil() {
		
	}

	/**
	 * Gets the message.
	 * 
	 * @param messageKey
	 *            the message key
	 * @return the message
	 */
	public static String getMessage(String messageKey) {
		String message = null;
		Locale locale = LocaleContextHolder.getLocale();
		ReloadableResourceBundleMessageSource rb = (ReloadableResourceBundleMessageSource) SpringBeanLocator.getBean(MESSAGE_RESOURCE_KEY);
		if (null != rb){
			message = rb.getMessage(messageKey, null, locale);
		}
		return message;
	}
	
	public static String getMessage(String messageKey, Locale locale) {
		String message = null;
		ReloadableResourceBundleMessageSource rb = (ReloadableResourceBundleMessageSource) SpringBeanLocator.getBean(MESSAGE_RESOURCE_KEY);
		if (null != rb){
			message = rb.getMessage(messageKey, null, locale);
		}
		return message;
	}
	
	public static String getDynamicMessage(String messageKey, String[] value, Locale locale) {
		String message = null;
		ReloadableResourceBundleMessageSource rb = (ReloadableResourceBundleMessageSource) SpringBeanLocator.getBean(MESSAGE_RESOURCE_KEY);
		if (null != rb){
			message = rb.getMessage(messageKey, value, locale);
		}
		return message;
	}

}

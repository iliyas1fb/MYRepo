package org.common.service.util;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.SqlParameter;



/**
 * This Interface handles displays the PortalConstants functionality.
 */
public interface PortalConstants {
	/** The Constant LOG_ENTRY. */
	 String LOG_ENTRY = "Entering in to ";
	 
	 	/** The Constant COMMA. */
	 String COMMA = ",";
	 
	 	/** The Constant LOG_EXIT. */
	 String LOG_EXIT = "Exiting from ";
	 
	 	/** The Constant DEFAULT_USER. */
	 String DEFAULT_USER = "DEFAULT_USER";
	 
	 String STR_EMPTY = "";
	 	/** The Constant ERROR_MSG_STR. */
	 String ERROR_MSG_STR = "Error Message : ";
	 
	 	/** The line separator. */
	 String LINESEPARATOR = System.getProperty("line.separator");
	 	/** The log repeater. */
	 String LOGREPEATER = "#";
	 
	 String DATE_TIME_FORMAT = "date.time.format";
	 
	 String LOG_USER_NAME = "UserName :";
	 	/** The Constant ERROR_CODE_STR. */
	 String ERROR_CODE_STR = "Error Code : ";
	 	/** The Constant COMMA. */
	 String UNKNOWN_ERROR = "UNKNOWN_ERROR";
	 
	 String O_ERROR_CODE = "O_ERROR_CODE";
	 String O_ERROR_MSG = "O_ERROR_MSG";
	 
	 String GRID_DATE_FORMAT = "grid.date.format";
	 String GRID_DATE_TIME_FORMAT = "grid.datetime.format";
	 String JAVA_DATE_FORMAT = "dd-MMM-yyyy";
	 String JAVA_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm";
	 String JAVA_DATE_TIME_FORMAT_FULL = "dd-MM-yyyy HH:mm:ss";
	 
	 String PROGRAM_NAME="programme.name";
	 String PROGRAM_SUPPORT_EMAIL="program.support.email";
	 String PROGRAM_SUPPORT_PHONE="program.support.phone";
	 String SIGNATURE = "signature";
	 String PROGRAM_WEBSITE ="program.website";
	 String MAIL_URL = "MAIL_URL";
	 String SMTP_HOST_NAME = "SMTP_HOST_NAME";
	 String EMAIL_FROM_ADDRESS = "EMAIL_FROM_ADDRESS";
	 String SMTP_AUTH_USER = "SMTP_AUTH_USER";
	 String SMTP_AUTH_PWD = "SMTP_AUTH_PWD";
	 
	 String MAIL_GETNEWPASSWITHHELPDESK = "mail.getnewpasswithhelpdesk";
	 
	 public static final String PORTAL_CONFIG_PROPERTIES ="/Portal.properties";
	 public static final String PROPFILEPATH="propfilepath";
	 public static final String CLOUD_SERVER_URL="CLOUD_SERVER_URL";
	 public static final String ECOMERCE_RESPONSE_URL="ECOMERCE_RESPONSE_URL";
	 public static final String MERCHANT_NAME="MERCHANT_NAME";
	 public static final String CLOUD_SERVER_ECOMERC_RES_URL="CLOUD_SERVER_ECOMERC_RES_URL";
	 public static final String THREAD_SLEEP_TIME="THREAD_SLEEP_TIME";
	 public static final String ECOMERCE_RESPONSE_TIME="ECOMERCE_RESPONSE_TIME";
	 public static final String FILE_PATH="FILE_PATH";
	 public static final String PORTAL_QRCODE_FILE_PATH="PORTAL_QRCODE_FILE_PATH";
	 public static final String MERCHNAT_ACCESS_KEY="MERCHNAT_ACCESS_KEY";
	 
	 
		String I_FIRST_NAME = "I_FIRST_NAME";
		String I_LAST_NAME = "I_LAST_NAME";
		String I_ROLEGROUP_ID = "I_ROLEGROUP_ID";
		String I_EMAIL_ID = "I_EMAIL_ID";
		String I_USER_NAME = "I_USER_NAME";
		String I_HIERARCHY_ID = "I_HIERARCHY_ID";
		String I_ENTITY_ID = "I_ENTITY_ID";
		String I_PHONE_NUMBER = "I_PHONE_NUMBER";
		String I_LOGIN_USER = "I_LOGIN_USER";
		String I_PASSWORD = "I_PASSWORD";
		String O_USR_ID = "O_USR_ID";
		String R_ID = "RD_ID";
		 String I_HEIRACY_ID = "I_HEIRACY_ID";
		 String I_FUNCTION = "I_FUNCTION";
		 String O_ROLE_INFO = "O_ROLE_INFO";
		 String O_ENTITY_INFO = "O_ENTITY_INFO";
		 String ROLE_ID = "ROLE_ID";
		 String SUBROLE_NAME = "SUBROLE_NAME";
		 String ENT_ID = "ENT_ID";
		 String ENT_NAME = "ENT_NAME";
		 String CARD_NAME = "CARD_NAME";
		 String ENT_CODE = "ent_code";
		 
		 String I_ACC_NO = "I_ACC_NO";
		 String I_TOKEN = "I_TOKEN";
		 String O_TOKEN_VALUE = "O_TOKEN_VALUE";
		 String GET_TOKEN = "PG_GET_TOKEN";
		  String I_POS_ID = "I_POS_ID";
		 String I_POS_TYPE = "I_POS_TYPE";
		 String I_SOFT_VERSION = "I_SOFT_VERSION";
		 String I_SOFT_NAME = "I_SOFT_NAME";
		 String I_BRAND_NAME = "I_BRAND_NAME";
		 String I_TERMINAL_ID = "I_TERMINAL_ID";
		 String I_MID_LIST = "I_MID_LIST";
		 String O_PASS_INFO_LIST = "O_PASS_INFO_LIST";
		 String I_ID = "I_ID";
		 String GET_POS_CONFIG = "PG_GET_POS_CONFIG";
		 String I_MOBILE = "I_MOBILE";
		 String I_STATUS = "I_STATUS";
		 String PAGE = "1";
		 String TOTAL = "10";
		 
		 String I_MERCHANT_STORE_ID = "I_MERCHANT_STORE_ID";
		 String I_STORE_NAME = "I_STORE_NAME";
		 String I_STORE_CODE = "I_STORE_CODE";
		 String I_QR_CODE = "I_QR_CODE";
		 String I_QR_CODE_IMAGE_NAME = "I_QR_CODE_IMAGE_NAME";
		 String I_QR_CODE_IMAGE_CONTENT = "I_QR_CODE_IMAGE_CONTENT";
		 String O_QRCODE_INFO_LIST = "O_QRCODE_INFO_LIST";
		 String O_MANAGE_STORE_INFO_LIST = "O_MANAGE_STORE_INFO_LIST";
		 String PG_GET_STOREINFO = "PG_GET_STOREINFO";
		 String GET_REWARD_POINT_INFO = "GET_REWARD_POINT_INFO";
		 //String GET_REWARDS =  "GET_REWARDS";
		 String GET_REWARDS =  "GET_REWARDS";
		 String STORE_NAME = "STORE_NAME";
		 String STORE_CODE = "STORE_CODE";
		 String QR_CODE = "QR_CODE";
		 String MERCHANT_STORE_ID = "STORE_MASTER_ID";
		 String INSERT_MERCHANT_STORE = "PG_INSERT_STORE";
		 String UPDATE_MERCHANT_STORE = "PG_UPDATE_STORE";
		 String O_STORE_ID = "O_STORE_ID";
		 String I_STORE_ID = "i_store_id";
		 String POS_ID = "POS_ID";
		 String I_TRANSACTION = "i_transaction";
		 String I_QRCODE_ID = "I_QRCODE_ID";
		 String PG_GET_QRCODE_CONFIG = "PG_GET_QRCODE_CONFIG";
		 String GETCOUNTRYLIST = "PG_GETCOUNTRYLIST";
		 String GETSTATELIST = "PG_GETSTATELIST";
		 String GETCURRENCYLIST = "PG_GETCURRENCYLIST";
		 String GETLANGUAGELIST = "PG_GETLANGUAGELIST";
		 
		 String I_COUNTRY_ID = "I_COUNTRY_ID";
		 String I_COUNTRY_NAME = "I_COUNTRY_NAME";
		 String O_COUNTRY_INFO = "O_COUNTRY_INFO";
		 String COUNTRY_ID = "COUNTRY_ID";
		 String COUNTRY_NAME = "COUNTRY_NAME";
		 String COUNTRY_CODE = "COUNTRY_CODE";
		 String COUNTRY_AREA_CODE = "COUNTRY_AREA_CODE";
		 
		 String I_CURRENCY_ID = "I_CURRENCY_ID";
		 String I_CHAR_CODE = "I_CHAR_CODE";
		 String O_CURRENCY_INFO = "O_CURRENCY_INFO";
		 String CURRENCY_ID = "CURRENCY_ID";
		 String CHAR_CODE = "CHAR_CODE";
		 String STATUS = "STATUS";
		 
		 String I_USERNAME = "I_USERNAME";
		 String O_HIERARCHY_INFO_LIST = "O_HIERARCHY_INFO_LIST";
		 String GROUP_ID = "GROUP_ID";
		 String GROUP_DESCRIPTION = "GROUP_DESCRIPTION";
		 
		 String I_USER_ID = "I_USER_ID";
		 String I_ROLE_NAME = "I_ROLE_NAME";
		 String I_ROLE_ID = "I_ROLE_ID";
		 String I_CONTACT_NO = "I_CONTACT_NO";
		 String I_ENTITY_ID1 = "i_entity_id";
		 String O_USER_INFO_LIST = "O_USER_INFO_LIST";
		 String GROUP_NAME = "GROUP_NAME";
		 String SUBROLE_DESCRIPTION = "SUBROLE_DESCRIPTION";
			String USR_EMAIL = "USR_EMAIL";
			String PHONE_NUMBER = "PHONE_NUMBER";
			String HIERARCHY_ID = "HIERARCHY_ID";
			String HIERARCHY_TYPE = "HIERARCHY_TYPE";
			String USR_FIRSTNAME = "USR_FIRSTNAME";
			String USR_LASTNAME = "USR_LASTNAME";
			String USR_LOCALE = "USR_LOCALE";
			String ADDRESS_1 = "ADDRESS_1";
			String ADDRESS_2 = "ADDRESS_2";
			String CITY = "CITY";
			String COUNTRY = "COUNTRY";
			String STATE = "STATE";
			String ROLE_GROUP_ID = "ROLE_GROUP_ID";
			String USERID = "USER_ID";
			String ENTITY_ID = "ENTITY_ID";
			String ENTITY_NAME = "ENTITY_NAME";
			String ENTITY_STATUS = "ENTITY_STATUS";
			String API_USR_ID = "API_USER_ID";
			 String ZIPCODE = "ZIPCODE";
			 String TIMEZONE = "TIMEZONE";
			 String USR_LOGINNAME = "USR_LOGINNAME";
			 
			 String PG_GET_UPDATE_USER_PASS = "PG_GET_UPDATE_USER_PASS";
			 String I_USER_NEW_PASSWORD = "I_USER_NEW_PASSWORD";
			 String I_RESET_PASS_VAL_STRING = "I_RESET_PASS_VAL_STRING";
			 String I_EMAIL = "I_EMAIL";
			 
			 String PG_GET_NEW_PASS_HELPDESK = "PG_GET_NEW_PASS_HELPDESK";
			 
			 String I_LANGUAGE_ID = "I_LANGUAGE_ID";
			 String I_LANGUAGE_CODE = "I_LANGUAGE_CODE";
			 String O_LANGUAGE_INFO = "O_LANGUAGE_INFO";
			 String LANGUAGE_ID = "LANGUAGE_ID";
			 String LANGUAGE_CODE = "LANGUAGE_CODE";
			 String LANGUAGE_DESCRIPTION = "LANGUAGE_DESCRIPTION";
			 String ACCESS_FLAG = "ACCESS_FLAG";
			 
			 String I_STATE_ID = "I_STATE_ID";
			 String I_STATE_NAME = "I_STATE_NAME";
			 String O_STATE_INFO = "O_STATE_INFO";
			 String STATE_ID = "STATE_ID";
			 String STATE_NAME = "STATE_NAME";
			 String STATE_CODE = "STATE_CODE";
			 
			 String I_TIMEZONE_ID = "I_TIMEZONE_ID";
			 String I_TIMEZONE_N = "I_TIMEZONE_N";
			 String O_TIMEZONE_INFO_LIST = "O_TIMEZONE_INFO_LIST";
			 String ID = "ID";
			 String TIMEZONE_CODE = "TIMEZONE_CODE";
			 String OFFSET_UTC = "OFFSET_UTC";
			 String TIMEZONE_VALUE = "TIMEZONE_VALUE";
			 String I_LOGGEDIN_USER = "I_LOGGEDIN_USER";
			 String O_ERROR_CODE1 = "o_error_code";
			 String O_ERROR_MSG1 = "o_error_msg";
			 
			 String GET_MERCHANT_MID = "PG_GET_MERCHANT_MIDLIST";
			 String I_ENTITYID = "i_entityid";
			 String I_MID = "i_mid";
			 String O_MID_INFO = "o_mid_info";
			 
			 String I_CONTACT_PERSON = "I_CONTACT_PERSON";
			 String I_CONTACT_NUMBER = "I_CONTACT_NUMBER";
			 String I_ADDRESS1 = "I_ADDRESS1";
			 String I_ADDRESS2 = "I_ADDRESS2";
			 String I_ZIPCODE = "I_ZIPCODE";
			 String I_TIMEZONE = "I_TIMEZONE";
			 String I_STATE = "I_STATE";
			 String I_CITY = "I_CITY";
			 String I_CURRENCY = "I_CURRENCY";
			 String I_COUNTRY = "I_COUNTRY";
			 String CONTACT_PERSON = "CONTACT_PERSON";
			 String CONTACT_NUMBER = "CONTACT_NUMBER";
			 String EMAIL = "EMAIL";
			 String DEMOGRAPHICS_ID = "DEMOGRAPHICS_ID";
			 String CITY_NAME = "CITY_NAME";
			 String TIMEZONE_N = "TIMEZONE_N";
			 
			 String I_IS_KYC_VALIDATED_BY_BANK = "I_IS_KYC_VALIDATED_BY_BANK";
			 String I_IS_PUBLIC_QUOTED_COMPANY = "I_IS_PUBLIC_QUOTED_COMPANY";
			 String I_STOCK_SYMBOL = "I_STOCK_SYMBOL";
			 String I_STOCK_EXCHANGE = "I_STOCK_EXCHANGE";
			 String I_COMPANY_REGISTRATION_NUMBER = "I_COMPANY_REGISTRATION_NUMBER";
			 String I_VAT_REGISTRATION_NO = "I_VAT_REGISTRATION_NO";
			 String I_DIRECTOR1_NAME = "I_DIRECTOR1_NAME";
			 String I_DIRECTOR1_DOCUMENT_TYPE = "I_DIRECTOR1_DOCUMENT_TYPE";
			 String I_DIRECTOR1_DESCRIPTION = "I_DIRECTOR1_DESCRIPTION";
			 String I_DIRECTOR2_NAME = "I_DIRECTOR2_NAME";
			 String I_DIRECTOR2_DOCUMENT_TYPE = "I_DIRECTOR2_DOCUMENT_TYPE";
			 String I_DIRECTOR2_DESCRIPTION = "I_DIRECTOR2_DESCRIPTION";
			 String I_BENEFICIAL_OWNER_NAME = "I_BENEFICIAL_OWNER_NAME";
			 String I_BENEFICIAL_OWNER_ADDRESS = "I_BENEFICIAL_OWNER_ADDRESS";
			 String I_KYC_DOCUMENT_LOCATION = "I_KYC_DOCUMENT_LOCATION";
			 String I_KYC_REMARKS = "I_KYC_REMARKS";
			 String I_CREATED_BY = "I_CREATED_BY";
			 String O_ENTITY_ID = "O_ENTITY_ID";
			 
			 String ADD_MERCHANT_KYC_INFO = "PG_ADD_MERCHANT_KYC_INFO";
			 String GET_KYC_DCMNT_TYPES = "PG_GET_KYC_DCMNT_TYPES";
			 String GET_MERCHANT = "PG_GET_MERCHANT";
			 String GET_MERCHANT_KYC = "PG_GET_MERCHANT_KYC";
			 String UPDATE_MERCHANT_INFO = "PG_UPDATE_MERCHANT";
			 String UPDATE_MERCHANT_KYC = "PG_UPDATE_MERCHANT_KYC";
			 String APPROVE_REJECT_MERCHANT = "PG_APPROVE_REJECT_MERCHANT";
			 
			 String I_BUSINESS_NAME = "I_BUSINESS_NAME";
			 String I_DISPLAY_NAME = "I_DISPLAY_NAME";
			 String I_BANK_ID = "I_BANK_ID";
			 
			 String I_LANGUAGE = "I_LANGUAGE";
			  String I_MERCHANT_TIMEZONE = "I_MERCHANT_TIMEZONE";
			  String I_VALID_FROM = "I_VALID_FROM";
				 String I_MID_GENERATED = "I_MID_GENERATED";
				 String I_AUTO_RENEW = "I_AUTO_RENEW";
				 String I_VALID_TO = "I_VALID_TO";
				 String I_CUSTOM = "I_CUSTOM";
				 String I_CNTCT_TITLE = "I_CNTCT_TITLE";
				 String I_CNTCT_FIRST_NAME = "I_CNTCT_FIRST_NAME";
				 String I_CNTCT_LAST_NAME = "I_CNTCT_LAST_NAME";
				 String I_CNTCT_USERNAME = "I_CNTCT_USERNAME";
				 String I_CNTCT_PHONE_NO = "I_CNTCT_PHONE_NO";
				 String I_CNTCT_MOBILE_NUMBER = "I_CNTCT_MOBILE_NUMBER";
				 String I_CNTCT_PRIMARY_EMAIL = "I_CNTCT_PRIMARY_EMAIL";
				 String I_CNTCT_SECONDARY_EMAIL = "I_CNTCT_SECONDARY_EMAIL";
				 String I_CNTCT_ADDRESS1 = "I_CNTCT_ADDRESS1";
				 String I_CNTCT_ADDRESS2 = "I_CNTCT_ADDRESS2";
				 String I_CNTCT_COUNTRY = "I_CNTCT_COUNTRY";
				 String I_CNTCT_STATE_PROVINCE = "I_CNTCT_STATE_PROVINCE";
				 String I_CNTCT_CITY = "I_CNTCT_CITY";
				 String I_CNTCT_POSTAL_CODE = "I_CNTCT_POSTAL_CODE";
				 String I_LEVEL1_NAME = "I_LEVEL1_NAME";
				 String I_LEVEL1_EMAIL_ADDRESS = "I_LEVEL1_EMAIL_ADDRESS";
				 String I_LEVEL1_CONTACT_NO = "I_LEVEL1_CONTACT_NO";
				 String I_LEVEL2_NAME = "I_LEVEL2_NAME";
				 String I_LEVEL2_EMAIL_ADDRESS = "I_LEVEL2_EMAIL_ADDRESS";
				 String I_LEVEL2_CONTACT_NO = "I_LEVEL2_CONTACT_NO";
				 String I_PARENT_MID = "I_PARENT_MID";
				 String I_PARENT_MERCHANT = "I_PARENT_MERCHANT";
				 String ADD_MERCHANT = "PG_ADD_MERCHANT";
				 
				 String O_KYC_DCMNT_TYPES = "O_KYC_DCMNT_TYPES";
				 String O_MERCHANT_KYC = "O_MERCHANT_KYC";
				 
				 String O_APPROVE_KYC = "O_APPROVE_KYC";
				 String VERIFIED = "Verified";
				 String DIRECTORNAMEANDADDRESS = "Director's Name and Address";
				 String BENEFICIALOWNERSIDENTIFIED = "Beneficial Owners Identified";
				 String O_MID = "O_MID";
				 String GET_MERCHANTS_LIST = "PG_GET_MERCHANTS_LIST";
				 String I_NAME = "i_name";
				 String I_CORPORATE_CODE = "I_CORPORATE_CODE";
				 String O_MERCHANTS_LIST = "O_MERCHANTS_LIST";
				 
				 String O_MERCHANT_INFO = "O_MERCHANT_INFO";
				 String O_MERCHANT_PREF_INFO = "O_MERCHANT_PREF_INFO";
				 String O_MERCHANT_TECH_INFO = "O_MERCHANT_TECH_INFO";
				 String GET_MID_LIST = "PG_GET_MIDLIST";
				 String GET_MERCHANT_CARD_LIST = "PG_GET_CARDLIST";
				 String O_MID_LIST_INFO = "o_mid_list_info";
				 String O_CARD_LIST_INFO = "o_card_list_info";
				 String IS_MID_PRESENT_SP = "PG_MID_PRESENT_SP";
				 
				 String I_VERIFIED = "I_VERIFIED";
				 String I_DIRECTOR_DETAILS = "I_DIRECTOR_DETAILS";
				 String I_BENIFICIAR_DETAILS = "I_BENIFICIAR_DETAILS";
				 String I_APPROVE_REJECT = "I_APPROVE_REJECT";
				 String I_COMMENTS = "I_COMMENTS";
				 String I_ENTITY_KEY = "I_ENTITY_KEY";
				 
				 String INSERT_SALES_CHANNEL_BANK = "PG_INSERT_BANK";
				 String UPDATE_SALES_CHANNEL_BANK = "PG_UPDATE_BANK";
				 String GET_ALL_SALES_CH_BANK_INFO = "PG_GET_BANKINFO";
				 
				 String I_BANK_NAME = "I_BANK_NAME";
				 String I_BANK_CODE = "I_BANK_CODE";
				 String I_ROUTINGNUMBER = "I_ROUTING_NUMBER";
				 String I_BANKSETTLEDAYS = "I_BANK_SETTLE_DAYS";
				 String BANK_SETTLE_DAYS = "BANK_SETTLE_DAYS";
				 String BANK_NAME_ROUTING = "BANK_NAME_ROUTING"; 
				 String I_SALE_CHANNEL_BANK_ID = "I_SALE_CHANNEL_BANK_ID";
				 String O_SALE_CH_BANK_INFO_LIST = "O_SALE_CH_BANK_INFO_LIST";
				 String SALES_CH_BANK_MASTER_ID = "SALES_CH_BANK_MASTER_ID";
				 String O_SALE_CHANNEL_BANK_ID = "O_SALE_CHANNEL_BANK_ID";	
				 String BANK_NAME = "BANK_NAME";
				 String BANK_CODE = "BANK_CODE";
				 
				 String GET_TRANSACTION_LIST = "TRANSACTION_SEARCH";
				 String I_USERNAME_TS = "i_username";
				 String I_STARTDATE = "i_startdate";
				 String I_ENDDATE = "i_enddate";
				 String I_TXN_ID = "i_txn_id";
				 String I_CARDNUM="i_cardNum";
				 String O_TXNHIST = "O_TXNHIST";
				 String STR_DAY_YESTERDAY = "YESTERDAY";
				 String STR_DAY_TODAY = "TODAY";
				 String STR_WEEKLY = "WEEKLY";
				 String STR_MONTHLY = "MONTHLY";
				 
				 String I_DESCRIPTION = "I_DESCRIPTION";
				 String I_GROUP_ID = "I_GROUP_ID";
				 String I_PERMISSION_ID_LIST = "I_PERMISSION_ID_LIST";
				 String O_ROLE_LIST = "O_ROLE_LIST";
				 String O_ROLE_INFO_LIST = "O_ROLE_INFO_LIST";
				 String O_PERMISSIONS_LIST = "O_PERMISSIONS_LIST";
				 
				 String ROLE_NAME = "ROLE_NAME";
				 String ROLE_DESCRIPTION = "ROLE_DESCRIPTION";
				 String CREATED_BY = "CREATED_BY";
				 String CREATED_DATE = "CREATED_DATE";
				 String PERMISSION_ID = "PERMISSION_ID";
				 String O_ROLE_HIERARCHY_INFO_LIST = "O_ROLE_HIERARCHY_INFO_LIST";
				 String MODIFIED_BY = "MODIFIED_BY";
				 String MODIFIED_DATE = "MODIFIED_DATE";
				 String I_ROLE_DESC = "I_ROLE_DESC";
				 String I_MODIFIED_BY = "I_MODIFIED_BY";
				 
				 String I_USER_LOGNAME="I_USER_LOGNAME";
				 String X_ID= "X_ID";
				 String X_LOGINNAME= "X_LOGINNAME";
				 String X_LASTNAME= "X_LASTNAME";
				 String X_FIRSTNAME= "X_FIRSTNAME";
				 String X_EMAIL= "X_EMAIL";
				 String X_LOCALE= "X_LOCALE";
				 String X_STATUS= "X_STATUS";
				 String X_ACCT_EXPIRED= "X_ACCT_EXPIRED";
				 String X_CREDENTIALS_EXPIRED= "X_CREDENTIALS_EXPIRED";
				 String X_IISINTERNAL= "X_IISINTERNAL";
				 String X_ACCT_LOCKED= "X_ACCT_LOCKED";
				 String X_LASTBADLOGIN= "X_LASTBADLOGIN";
				 String X_BADLOGINCOUNT= "X_BADLOGINCOUNT";
				 String X_PASSWORDCHANGEDDATE= "X_PASSWORDCHANGEDDATE";
				 String X_LASTLOGINDATE= "X_LASTLOGINDATE";
				 String X_PHONENUMBER= "X_PHONENUMBER";
				 String X_QUESTION_ID= "X_QUESTION_ID";
				 String X_QUESTION_ANSWER= "X_QUESTION_ANSWER";
				 String X_CREATED_BY= "X_CREATED_BY";
				 String X_CREATED_DATE= "X_CREATED_DATE";
				 String X_MODIFIED_BY= "X_MODIFIED_BY";
				 String X_MODIFIED_DATE= "X_MODIFIED_DATE";
				 String X_PASSWORD= "X_PASSWORD";
				 String x_PWD_CHANGE_TYPE= "x_PWD_CHANGE_TYPE";
				 String x_ENTITY_ID= "x_ENTITY_ID";
				 String X_ROLE_NAME= "X_ROLE_NAME";
				 String X_SUBROLE_NAME= "X_SUBROLE_NAME";
				 String IS_SPONSOR_FLAG= "IS_SPONSOR_FLAG";
				 String X_IS_LOGGED_IN= "X_IS_LOGGED_IN";
				 String X_ERROR_CODE= "X_ERROR_CODE";
				 String X_ERROR_MSG= "X_ERROR_MSG";
				 String X_REPORTSTO= "X_REPORTSTO";
				 String SUCCESS= "SUCCESS";
				 String I_USER_EMAIL="I_USER_EMAIL";
				 String x_error_msg="x_error_msg";
				 String errorCode="errorCode";
				 String X_ERROR_COD="X_ERROR_COD";
				 String O_COUNT="O_COUNT";
				 String LABELSCHEME = "label.scheme";
				 String LABELIP = "label.ip";
				 String LABELPORT = "label.port";
				 String LABELCONTEXT = "label.context";
				 String LABLEAPPPATH = "lable.appPath";
				 String LABELDISPLAY = "label.display";
				 String MAILUSERNAME = "mail.username";
				 String MAILPASSWORD = "mail.password";
				 String STARTDATE = "startDate";
				 String ENDDATE = "endDate";
				 String MID = "mid";
				 String TRANSACTIONID = "transactionID";
				 String STOREID = "storeId";
				 String POSID = "posId";
				 String CARDLAST4DIGITS = "cardLast4Digits";
				 String LABLEMID = "label.MID";
				 String LABELTXNID="label.TxnID";
				 String LABELTXNDATETIMESTAMP="label.TxnDateTimestamp";
				 String LABELTXNAMOUNT="label.TxnAmount";
				 String LABELSTAN_NUMBER="label.Stan_Number";
				 String LABELCARDTYPE="label.CardType";
				 String LABELLAST4DIGITS="label.Last4Digits";
				 String LABELTXNTYPE="label.TxnType";
				 String LABELCURRENCY="label.Currency";
				 String LABELTXNSTATUS="label.TxnStatus";
				 String LABELSTOREID="label.StoreId";
				 String LABELPOSID="label.PosId";
				 String I_PWD="I_PWD";
				 String I_TYPE="I_TYPE";
				 String ERROR_CODE="ERROR_CODE";
				 String ERROR_MSG="ERROR_MSG";
				 String O_RANDOM_PWD="O_RANDOM_PWD";
				 String O_USER_EMAIL="O_USER_EMAIL";
				 String O_USER_ID="O_USER_ID";
				 String O_USR_FIRSTNAME="O_USR_FIRSTNAME";
				 String O_USR_LASTNAME="O_USR_LASTNAME";
				 String emesg="emesg";
				 String ECODE="ECODE";
				 String OPEN_ANCHOR_LINK_FOR_FILE = "<a class=\"morebutton\" href=\"./downloadQrcode?fileName=";
				 String BACK_SLASH = "\">";
				 String CLOSE_ANCHOR_LINK_FOR_FILE = "</a>";
				 
				 String CALL_FIRE_SMS_USER_NAME = "callFireSMSUserName";
					
				 String CALL_FIRE_SMS_PASSWORD = "callFireSMSPassword";

				String SEND_MESSAGE_CONTENT = "sendMessageContent";
					
				String SEND_SMS_URL = "sendSMSURL";

				String CONTENT_TYPE_FOR_SMS = "application/x-www-form-urlencoded";
				
				 String I_CREDITCARDLIST = "I_CREDIT_CARDLIST";
				 String I_DEBITCARDLIST = "I_DEBIT_CARDLIST";
				 String I_PRIVATELABELLIST = "I_PRIVATELABEL_LIST";
				 String I_STORECARDLIST = "I_STORE_CARDLIST"; 
				 String I_GIFTCARDLIST = "I_GIFT_CARDLIST";
				 String I_CREDTCARD="I_CREDITCARD";
				 String I_DEBITCARD="I_DEBITCARD";
				 String I_PRIVATELABEL="I_PRIVATELABEL";
				 String I_STORECARD="I_STORECARD";
				 String I_GIFTCARD="I_GIFTCARD";
				 String O_MERCHANT_CONFIG_INFO = "O_MERCHANT_CONFIG_INFO";
				 String I_MERCHANT_KEY = "I_MERCHANT_KEY";
				 String I_EXTERNAL_MERCHANT = "I_EXTERNAL_MERCHANT";
				 String ALGTHM_TYPE_AES = "AES";
				 int KEY_SIZE_3DES = 24;
				 int KEY_SIZE_AES = 32;
				 String ALGTHM_TYPE_3DES = "DESede";
				 String O_DAY_TXN_CALC = "O_DAY_TXN_CALC";
				 String O_WEEK_TXN_CALC = "O_WEEK_TXN_CALC";
				 String O_MONTH_TXN_CALC = "O_MONTH_TXN_CALC";
				 String O_DAY_SETTLED_CALC = "O_DAY_SETTLED_CALC";
				 String O_WEEK_SETTLED_CALC = "O_WEEK_SETTLED_CALC";
				 String O_MONTH_SETTLED_CALC = "O_MONTH_SETTLED_CALC";
				 String GET_MERCHANTS_DADHBOARD_LIST = "PG_GET_ACTIVE_MER_LIST";
				 String GET_PENDIG_MER_LIST = "PG_GET_PENDIG_MER_LIST";
				 String O_MERCHANTS_DASHBOARD_LIST = "O_MERCHANTS_DASHBOARD_LIST";
				 String AccountAdminGroupName="Account Admin - Manager";
				 String MerchantSalesAdminGroupName="Merchant Sales Admin - Manager";
				 			 
				 String RD_ID = "RD_ID";
				 String USER_ID = "userId";
				 String UID = "u_id";				 				 
				 String REWARD_AMOUNT = "rd_min_amount";
				 String REWARD_MERCHANT_CURRENCY= "rd_reward_currency";
				 String REWARD_MERCHANT_ID = "rd_merchant_id";		
				 			 
				 String REWARD_ID = "rd_id";
				 String REWARD_POINT_TOTAL = "rd_Point_Total";
				 String REWARD_POINT_PENDING = "rd_point_pending";
				 String REWARD_POINT_ACTIVE = "rd_point_active";
				 String REWARD_POINT_EXPIRE="rd_point_expire";
				 String REWARD_POINT_CONVERTED = "rd_point_converted";
				 String REWARD_POINT_CANCELLED = "rd_point_cancelled";
				 String ACTIVE_DATE = "active_date";
				 String EXPIRY_DATE = "ex_date";			
				 String REWARD_IDD = "REWARD_ID";
				 String RD_POINT_TOTAL = "REWARD_POINT_TOTAL";
				 String RD_POINT_PENDING = "REWARD_POINT_PENDING";
				 String RD_POINT_ACTIVE = "REWARD_POINT_ACTIVE";
				 String RD_POINT_EXPIRE="REWARD_POINT_EXPIRE";
				 String RD_POINT_CONVERTED = "REWARD_POINT_CONVERTED";
				 String RD_POINT_CANCELLED = "REWARD_POINT_CANCELLED";
				 String ACTIVE_DT = "ACTIVATION_DATE";
				 String EXPIRY_DT = "EXPIRE_DATE";
				 String O_REWARD_POINT_INFO_LIST = "O_REWARD_POINT_INFO_LIST";
				 String I_COUPON_TITLE = "I_COUPON_TITLE";
				 String I_COUPON_ISSUER_NAME = "I_COUPON_ISSUER_NAME";
				 String I_COUPON_ISSUER_ID  = "I_COUPON_ISSUER_ID";
				 String I_MERCHANT_ID  = "I_MERCHANT_ID";
				 String I_VALIDITY_START_DATE  = "I_VALIDITY_START_DATE";
				 String I_VALIDITY_END_DATE = "I_VALIDITY_END_DATE";
				 String I_CATEGORY_NAME = "I_CATEGORY_NAME";
				 String I_SUB_CATEGORY = "I_SUB_CATEGORY";
				 String I_COUPON_DESCRIPTION = "I_COUPON_DESCRIPTION";
				 String I_MAX_REDEMPTION = "I_MAX_REDEMPTION";
				 String I_TERM_AND_CONDITIONS = "I_TERM_AND_CONDITIONS";
				 String I_DISCOUNT_ID = "I_DISCOUNT_ID";
				 String I_REDEMPTION_CHANNEL = "I_REDEMPTION_CHANNEL";
				 String I_COUNTRY_CODE = "I_COUNTRY_CODE";
				 String I_URL_IDENTIFIER = "I_URL_IDENTIFIER";
				 String I_SKU_ID = "I_SKU_ID";
			     String I_EXCEPTION_ID = "I_EXCEPTION_ID";
			     String I_EXCEPTION_DESC = "I_EXCEPTION_DESC";
			     String CREATE_COUPON = "CREATE_COUPON";
				 String I_COUPON_ID = "I_COUPON_ID";
				 String GET_PRODUCT_OFFER = "GET_PRODUCT_OFFER";
				 String O_PRODUCT_OFFER_LIST = "O_PRODUCT_OFFER_LIST";
				 String I_IS_OFFER =  "I_IS_OFFER";
				 String GET_EXCEPTION_DESC="GET_EXCEPTION_DESC";
				 String O_EXCEPTION_DESC_LIST =  "O_EXCEPTION_DESC_LIST";
				 String O_DISCOUNT_DESC_LIST =  "O_DISCOUNT_DESC_LIST";
				 String GET_DISCOUNT_DESC="GET_DISCOUNT_DESC";
				 String ACTION_PATH="ActionPath";
				 public static final String DATE_FORMAT = "dd-MM-yyyy";
					
				public static final String DATE_FORMAT_MMM = "dd-MMM-yy";
				
				 String FLAT =  "FLAT";
				 String PERCENATGE="PERCENTAGE";
				
				 
				
				
				
				
	 
}

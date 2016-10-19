package org.common.service.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


/**
 * This class handles the OmnypayUtil .
 */
public class PortalUtil {

	/** The LOGGER. */
	//private static final Log4jAdapter LOGGER = Log4jAdapter.getInstance();
	
    private static final String XFORWARDEDFOR = "X-Forwarded-For";
    private static final String PROXYCLIENTIP = "Proxy-Client-IP";
    private static final String WLPROXYCLIENTIP = "WL-Proxy-Client-IP";
    private static final String HTTPCLIENTIP = "HTTP_CLIENT_IP";
    private static final String HTTPXFORWARDEDFOR = "HTTP_X_FORWARDED_FOR";
    
	/**
	 * Split.
	 * 
	 * @param input
	 *            the input
	 * @param regex
	 *            the regex
	 * @return the string[]
	 */
	public static String[] split(String input, String regex) {
		String[] returnValue = new String[0];
		if (input == null){
			return null;
		}
		List<String> list = new ArrayList<String>();
		int preIndex = 0;
		int postIndex = 0;
		int length = input.length();
		int lastInd = input.lastIndexOf(regex);
		boolean flag = false;

		if (lastInd == -1) {
			list.add(input);
			return list.toArray(returnValue);
		}
		for (; true;) {
			if (preIndex == lastInd) {
				list.add(input.substring(++preIndex, length));
				break;
			}
			if (flag) {
				++preIndex;
			}
			postIndex = input.indexOf(regex, preIndex);
			list.add(input.substring(preIndex, postIndex));
			preIndex = postIndex;
			flag = true;
		}
		return list.toArray(returnValue);
	}

	/**
	 * Gets the stack trace as string.
	 * 
	 * @param exception
	 *            the exception
	 * @return the stack trace as string
	 */
	public static String getStackTraceAsString(Exception exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try{
			pw.print(exception.getMessage());
		}catch(Exception e){
			//LOGGER.info("getStackTraceAsString",e);
		}
		return sw.toString();
		
		
	}

	/**
	 * Validate alpha numeric.
	 * 
	 * @param text
	 *            the text
	 * @return true, if successful
	 */
	public static boolean validateAlphaNumeric(String text) {
		String regex = "^[a-zA-Z0-9 ]*$";
		return text.matches(regex);
	}

	/**
	 * Validate numeric.
	 * 
	 * @param param
	 *            the param
	 * @return true, if successful
	 */
	public static boolean validateNumeric(String param) {
		String regex = "^[0-9]*$";
		return param.matches(regex);
	}

	/**
	 * Validate alpha.
	 * 
	 * @param text
	 *            the text
	 * @return true, if successful
	 */
	public static boolean validateAlpha(String text) {
		String regex = "^[a-zA-Z ]*$";
		return text.matches(regex);
	}

	/**
	 * Validate email id.
	 * 
	 * @param param
	 *            the param
	 * @return true, if successful
	 */
	public static boolean validateEmailId(String param) {
		String regex = "^[a-z]+[._]?[a-z0-9]+@([a-z]+\\.)+(\\w{2,3})$";
		return param.matches(regex);
	}

	/**
	 * Checks if is valid date str.
	 * 
	 * @param strDate
	 *            the str date
	 * @return true, if is valid date str
	 */
	public static boolean isValidDateStr(String strDate) {
		String pattern = "dd/MM/yy";
		boolean isValid = false;
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			sdf.applyPattern(pattern);
			isValid = true;
		} catch (Exception e) {
			//LOGGER.info("Security Error Msg :",e);
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Gets the time stamp from str date.
	 * 
	 * @param dateWithTime
	 *            the date with time
	 * @return the time stamp from str date
	 */
	public static Timestamp getTimeStampFromStrDate(String dateWithTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String strTodays = String.valueOf(dateWithTime);
		String[] dateTimeValues = strTodays.split(" ");
		String[] dateValues = dateTimeValues[0].split("-");
		String hour = "";
		String min = "";
		String sec = "";
		String date = dateValues[0];
		if (date.length() == 1) {
			date = "0" + date;
		}
		String month = dateValues[1];
		if (month.length() == 1) {
			month = "0" + month;
		}
		String year = dateValues[2];
		if (year.length() == 2) {
			year = "20" + year;
		}
		String[] timeValues = null;
		if (dateTimeValues.length == 2) {
			timeValues = dateTimeValues[1].split(":");
		} else {
			timeValues = getCurrentTime().split(":");
		}
		hour = timeValues[0];
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		min = "" + (Integer.parseInt(timeValues[1]) + 2);
		if (min.length() == 1) {
			min = "0" + min;
		}
		if (timeValues.length != 2) {
			sec = timeValues[2];
			if (sec.length() == 1) {
				sec = "0" + sec;
			}
		} else {
			sec = "00";
		}
		Date convertedDateFormat = null;
		try {
			convertedDateFormat = formatter.parse(date + "-" + month + "-" + year + " " + hour + ":" + min + ":" + sec);
		} catch (ParseException e) {
			//LOGGER.info("ParseException :",e);
			convertedDateFormat = null;
		}
		Long dateLong = null != convertedDateFormat ? convertedDateFormat.getTime() : 0l;
		return new Timestamp(dateLong);
	}

	/**
	 * Gets the time stamp.
	 * 
	 * @param dateWithTime
	 *            the date with time
	 * @return the time stamp
	 */
	public static Timestamp getTimeStamp(String dateWithTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strTodays = String.valueOf(dateWithTime);
		String[] dateTimeValues = strTodays.split(" ");
		String[] dateValues = dateTimeValues[0].split("/");
		String date = dateValues[0];
		if (date.length() == 1) {
			date = "0" + date;
		}
		String month = dateValues[1];
		if (month.length() == 1) {
			month = "0" + month;
		}
		String year = dateValues[2];
		if (year.length() == 2) {
			year = "20" + year;
		}
		
		Date convertedDateFormat = null;
		try {
			convertedDateFormat = formatter.parse(date + "/" + month + "/" + year);
		} catch (ParseException e) {
			//LOGGER.info("getTimeStamp(method):ParseException :",e);
			convertedDateFormat = null;
		}
		Long dateLong = null != convertedDateFormat ? convertedDateFormat.getTime() : 0l;
		return new Timestamp(dateLong);
	}

	/**
	 * Gets the sql date from string.
	 * 
	 * @param strDate
	 *            the str date
	 * @return the sql date from string
	 * @throws ParseException the parse exception
	 */
/*	public static java.util.Date getSqlDateFromString(String strDate) throws ParseException {
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		java.util.Date date = sdf.parse(strDate);
		return date;
	}*/

	public static String getCurrentTime() {
		String currenDateTime = formatTimeStamp(new Timestamp(System.currentTimeMillis()));
		String[] dtTimeArray = currenDateTime.split(" ");
		return dtTimeArray[1];
	}

	/**
	 * Format time stamp.
	 * 
	 * @param ts
	 *            the ts
	 * @return the string
	 */
	public static String formatTimeStamp(Timestamp ts) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(ts);
	}

	/**
	 * Gets the date string.
	 * 
	 * @param date
	 *            the date
	 * @return the date string
	 */
	public static String getDateString(java.util.Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}

	/**
	 * This method will encode the given data.
	 * 
	 * @param data
	 *            the data
	 * @param encodedFormat
	 *            the encoded format
	 * @return the string
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 */
	public static String encodeData(String data, String encodedFormat) throws UnsupportedEncodingException {
		String encodedData = URLEncoder.encode(data, encodedFormat);
		return encodedData;
	}
	
	public static String getDateTimeStamp(String dateValue) {
		String datestr = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S").parse(dateValue);
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss"); 
			datestr = sdf.format(new Date(date.getTime()));
		} catch (ParseException e) {
			//LOGGER.info("getDateTimeStamp :",e);
		}
		return datestr;  
	}
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyyHHmmss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
	/*public static String getDateMDY(Object dateValue ){
		String datestr = null;
		
		if(null == dateValue) {
			return null;
		}
		
		Date date;
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
		
		} catch (ParseException e) {
			//LOGGER.info("getDateMDY :",e);
		}
		return datestr;
	}*/
	
	/*public static String getDateMDY1(Object dateValue ){
		String datestr = null;
		
		if(null == dateValue){
			return null;
		}
		
		Date date;
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("dd-MMM-yyyy").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
		} catch (ParseException e) {
			LOGGER.info("getDateMDY1 :",e);
		}
		return datestr;
	}*/
	
	/*public static String getDateMDY2(Object dateValue ){
		String datestr = null;
		
		if(null == dateValue) {
			return null;
		}
		
		Date date;
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("yyyy-MM-dd").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
			
		} catch (ParseException e) {
			LOGGER.info("getDateMDY2 :",e);
		}
		return datestr;
	}*/
	
	/*public static String getDateMDY3(Object dateValue ){
		String datestr = null;
		
		if(null == dateValue){
			return null;
		}
		
		Date date;
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("MM/dd/yyyy").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
			
		} catch (ParseException e) {
			LOGGER.info("getDateMDY3 :",e);
		}
		return datestr;
	}*/
	
	/*public static String getDateTimeMDY(Object dateValue ){
		String datestr = null;
		
		if(null == dateValue) {
			return null;
		}
		
		Date date;
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_TIME_FORMAT);
		
		SimpleDateFormat sdf = new SimpleDateFormat(dbDateFormatVal);
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
			
		} catch (ParseException e) {
			LOGGER.info("getDateTimeMDY :",e);
		}
		return datestr;
	}*/
	
	/*public static Date getStringDate(String dateStr) {
		Date date = null;
		
		try {
			date = new SimpleDateFormat("MM-dd-yyyy").parse((String)dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.info("getStringDate :",e);
		}
		return date;
	 }
	*/
	/**
	 * Change the date format from JSP to DB pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	/*public static String changeDateFormat(String date) throws ParseException{
		
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_FORMAT);
		
		SimpleDateFormat destFormat = new SimpleDateFormat(OMNYPAYConstants.JAVA_DATE_FORMAT); 
		DateFormat dateFormat=new SimpleDateFormat(dbDateFormatVal);	
		String changedDate = null != date && !"".equals(date) ? destFormat.format(dateFormat.parse(date)):null;
		
		return changedDate;
	}*/
	/*public static String changeDateTimeFormat(String date) throws ParseException{
		
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.DATE_TIME_FORMAT);
		
		SimpleDateFormat destFormat = new SimpleDateFormat(OMNYPAYConstants.JAVA_DATE_TIME_FORMAT); 
		DateFormat dateFormat=new SimpleDateFormat(dbDateFormatVal);	
		String changedDate = null != date && !"".equals(date) ? destFormat.format(dateFormat.parse(date)):null;
		
		return changedDate;
	}*/
	/*public static String changeDateTimeFormatFull(String date) throws ParseException{
		
		String dbDateFormatVal = PropertiesUtil.getPropertyValue(OMNYPAYConstants.GRID_DATE_TIME_FORMAT);
		
		SimpleDateFormat destFormat = new SimpleDateFormat(OMNYPAYConstants.JAVA_DATE_TIME_FORMAT_FULL); 
		DateFormat dateFormat=new SimpleDateFormat(dbDateFormatVal);	
		String changedDate = null != date && !"".equals(date) ? destFormat.format(dateFormat.parse(date)):null;
		
		return changedDate;
	}*/
    public static String getClientIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader(XFORWARDEDFOR);  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader(PROXYCLIENTIP);  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader(WLPROXYCLIENTIP);  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader(HTTPCLIENTIP);  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader(HTTPXFORWARDEDFOR);  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
    public static void getClientIpAddr1(HttpServletRequest request) {
    	//LOGGER.info("X-Forwarded-For==== :",request.getHeader(XFORWARDEDFOR),"");
    	//LOGGER.info("Proxy-Client-IP==== :",request.getHeader(PROXYCLIENTIP),"");
    	//LOGGER.info("WL-Proxy-Client-IP==== :",request.getHeader(WLPROXYCLIENTIP),"");
    	//LOGGER.info("HTTP_CLIENT_IP==== :",request.getHeader(HTTPCLIENTIP),"");
    	//LOGGER.info("HTTP_X_FORWARDED_FOR==== :",request.getHeader(HTTPXFORWARDEDFOR),"");
    	//LOGGER.info("request.getRemoteAddr()==== :",request.getRemoteAddr(),"");
    }
    public static String genPwd() {
    	// Generate alpha numeric password of length 8

        String randomPassword = genRanPass();
        if(!(randomPassword.contains("!") || randomPassword.contains("@") || randomPassword.contains("#") || randomPassword.contains("$") || randomPassword.contains("_") || randomPassword.contains("-"))){
        	randomPassword = genRanPass();
        }else{
        	return randomPassword;
        }
        return null;
    }
	
	private static String genRanPass(){
		int length = 8;
		char[] pw = new char[length];
        int c ='A';
        int  r1 = 0;
        String randomPassword = "";
        for (int i=0; i < length; i++) {
            r1 = (int)(Math.random() * 3);
            // pick a random upper case or lower case letter or a digit
            if(i != 4){
	            switch(r1) {
	            case 0: c = '0' +  (int)(Math.random() * 10); 
	            break;
	            case 1: c = 'a' +  (int)(Math.random() * 26); 
	            break;
	            case 2: c = 'A' +  (int)(Math.random() * 26);
	            break;
	            default:
	            	c = 'A';
	            	break;
	            }
	            pw[i] = (char)c;
            }else{
            	pw[i] = (char) spclChar();
            }
            randomPassword += pw[i];
        }
		
		return randomPassword;
	}
	private static int spclChar(){
		int n = (int)(Math.random() * 6);
		int r = 0;
		switch(n){
			case 0: r = '!'; 
			break;
	        case 1: r = '@';
	        break;
	        case 2: r = '#'; 
	        break;
	        case 3: r = '$'; 
	        break;
	        case 4: r = '_'; 
	        break;
	        case 5: r = '-'; 
	        break;
	        default:  
	        	r=0;
	        	break;
		}
		return r;
	}
	
	public static String getStringDateMDYHMTz(String dateValue ){
		Date date1 ;
		String datestr = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateValue);
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
			
			datestr= sdf.format(new Date(date1.getTime()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//LOGGER.info("getStringDateMDYHMTz :",e);
		}
		return datestr;
	}
	
	public static String getDateMDY4(Object dateValue ){
		String datestr = null;
		if(null == dateValue) {
			return null;
		}
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("yyyy-MM-dd").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
		} catch (ParseException e) {
			//LOGGER.info("getDateMDY4 :",e);
		}
		return datestr;
	}
	
	public static String getDateMDY5(Object dateValue ){
		String datestr = null;
		if(null == dateValue) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		try {
			if(dateValue instanceof String){
				date = new SimpleDateFormat("yyyy-MM-dd").parse((String)dateValue);
				datestr = sdf.format(new Date(date.getTime()));
			}else{
				datestr = sdf.format(((Date)dateValue).getTime());
			}
		} catch (ParseException e) {
			//LOGGER.info("getDateMDY5 :",e);
		}
		return datestr;
	}

	public static Date getDateMDY6(String dateValue ){
		if(null == dateValue) {
			return null;
		}
		Date date = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		try {
			date = sdf.parse((String)dateValue);
		} catch (ParseException e) {
			//LOGGER.info("getDateMDY6 :",e);
		}
		return date;
	}
	
	
	public static  String timeStampToDate(Timestamp timestamp) {
	
		String formateDate = null;
		
		if (timestamp!=null)
	 {
        // S is the millisecond
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

       formateDate =simpleDateFormat.format(timestamp).toString();
	 }
	 else
	 {
	 formateDate = "00/00/0000";
	 }
        return formateDate;
     
    }
}

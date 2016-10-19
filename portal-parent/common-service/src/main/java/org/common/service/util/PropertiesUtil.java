package org.common.service.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * This Class will load all the Properties file.
 */
public class PropertiesUtil {
	private static Properties properties=null;
	private static String propfilepath=null;
	//private static Log4jAdapter logger = Log4jAdapter.getInstance();
	private static final String className = PropertiesUtil.class.getName();
	/**
	 * Load all project properties.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void loadAllProjectProperties() throws IOException {
		String methodName = "loadAllProjectProperties";
		//Log4jAdapter logger = Log4jAdapter.getInstance();
		String className = "com.omnypay.common.util.PropertiesUtil";
		
	}
	
	/**
	 * Gets the properties.
	 *
	 * @param filePath the file path
	 * @return the properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties getProperties(String filePath)  {

		String methodName = "getProperties";
				
		if (properties == null) {
			
			StringBuilder sb = new StringBuilder("FilePath :");
			sb.append(filePath);
	        properties = new Properties();
			
			try {
				InputStream is = new FileInputStream(filePath);
				properties.load(is);
				is.close();
			} catch (IOException e) {
				
				throw new RuntimeException("Internal server error",e);
				
			} 
			return properties;
		} else {
			
			return properties;
		}
	}
	
	 public static String getPropertyValue(String key) {
		String methodName = "getPropertyValu";
		
		String value = getProperties(getPropFilePath()).getProperty(key);
		return value;
	}
	
	public static String getPropFilePath() {
		if (propfilepath == null) {
			
			StringBuilder propFileBuilder = new StringBuilder(System.getProperty(PortalConstants.PROPFILEPATH));
			
			propFileBuilder.append(PortalConstants.PORTAL_CONFIG_PROPERTIES);
			
			propfilepath = propFileBuilder.toString();
			
			return propfilepath;

		} else {
			return propfilepath;
		}
	}
	
}

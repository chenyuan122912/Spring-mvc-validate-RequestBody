package com.cloudeport.utils;

import java.util.ResourceBundle;

public class PropertiesHelper {

	private static ResourceBundle rb1 = ResourceBundle
			.getBundle("properties.serviceurl");
	private static ResourceBundle rb2 = ResourceBundle.getBundle("struts");

	public static String getResourceService(String key) {
		return rb1.getString(key);
	}

	public static String getStrutsPropertyValue(String key) {
		return rb2.getString(key);
	}

	/**
	 * 原ImageCreditServer中的方法实现
	 * 
	 */
	private static final String loginUrl = "loginURL";
	private static final String tranUrl = "tranURL";

	/**
	 * 根据KEY获取相应的Value
	 * 
	 * 
	 * @param key
	 * @return
	 */
	public static String getWebServicePropertyValue(String key) {

		ResourceBundle rb = ResourceBundle.getBundle("properties.webservice");
		String value = rb.getString(key);

		return value;
	}

	public static String getLoginUrl() {

		ResourceBundle rb = ResourceBundle.getBundle("properties.login");
		String value = rb.getString(loginUrl);
		return value;
	}

	public static String getTranUrl() {

		ResourceBundle rb = ResourceBundle.getBundle("properties.login");
		String value = rb.getString(tranUrl);
		return value;
	}

	public static String getDmsDownload() {
		ResourceBundle rb = ResourceBundle.getBundle("properties.webservice");
		String value = rb.getString("dmsDownload");
		return value;
	}

	public static String getApplication() {
		ResourceBundle rb = ResourceBundle.getBundle("properties.webservice");
		String value = rb.getString("application");
		return value;
	}

	public static String getZipFilePath() {
		ResourceBundle rb = ResourceBundle.getBundle("properties.webservice");
		String value = rb.getString("zipFilePath");
		return value;
	}
}

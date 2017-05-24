package com.cloudeport.utils;

import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogFactory {

	private static Logger webserviceLogger;
	private static Logger actionLogger;
	private static Logger serviceLogger;
	private static Logger daoLogger;
	private static Logger consoleLogger;

	static {
		webserviceLogger = getLogger("WEBSERVICE");
		serviceLogger = getLogger("SERVICE");
		actionLogger = getLogger("ACTION");
		daoLogger = getLogger("DAO");
		consoleLogger = getLogger("CONSOLE");
	}

	private static Logger getLogger(String level) {

		URL url = getClassLoader().getResource("properties/log4j.properties");
		if (url != null) {
			PropertyConfigurator.configure(url);
			return Logger.getLogger(level);
		} else {
			return null;
		}
	}

	private static ClassLoader getClassLoader() {

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = LogFactory.class.getClassLoader();
		}
		return classLoader;
	}

	// WEBSERVICE层日志方法
	public static void webserviceDebug(String message) {
		webserviceLogger.log(Level.DEBUG, message, null);
	}

	public static void webserviceInfo(String message) {
		webserviceLogger.log(Level.INFO, message, null);
	}

	public static void webserviceWarn(String message) {
		webserviceLogger.log(Level.WARN, message, null);
	}

	public static void webserviceError(String message, Throwable t) {
		webserviceLogger.log(Level.ERROR, message, t);
	}

	// ACTION层日志方法
	public static void actionDebug(String message) {

		actionLogger.log(Level.DEBUG, message, null);
	}

	public static void actionInfo(String message) {

		actionLogger.log(Level.INFO, message, null);
	}

	public static void actionWarn(String message) {
		actionLogger.log(Level.WARN, message, null);
	}

	public static void actionError(String message, Throwable t) {
		actionLogger.log(Level.ERROR, message, t);
	}

	// SERVICE层日志方法
	public static void serviceDebug(String message) {
		serviceLogger.log(Level.DEBUG, message, null);
	}

	public static void serviceInfo(String message) {
		serviceLogger.log(Level.INFO, message, null);
	}

	public static void serviceWarn(String message) {
		serviceLogger.log(Level.WARN, message, null);
	}

	public static void serviceError(String message, Throwable t) {
		serviceLogger.log(Level.ERROR, message, t);
	}

	// DAO层日志方法
	public static void daoDebug(String message) {
		daoLogger.log(Level.DEBUG, message, null);
	}

	public static void daoInfo(String message) {
		daoLogger.log(Level.INFO, message, null);
	}

	public static void daoWarn(String message) {
		daoLogger.log(Level.WARN, message, null);
	}

	public static void daoError(String message, Throwable t) {
		daoLogger.log(Level.ERROR, message, t);
	}

	// 控制台日志方法
	public static void consoleDebug(String message) {
		consoleLogger.log(Level.DEBUG, message, null);
	}

	public static void consoleInfo(String message) {
		consoleLogger.log(Level.INFO, message, null);
	}

	public static void consoleWarn(String message) {
		consoleLogger.log(Level.WARN, message, null);
	}

	public static void consoleError(String message, Throwable t) {
		consoleLogger.log(Level.ERROR, message, t);
	}

	public static void main(String[] args) {
		/*PropertyConfigurator
				.configure("D:/Work/workspaces/ImageCreditServer/Resources/properties/log4j.properties");
		LogFactory.consoleDebug("Test message");*/
		PropertyConfigurator
		.configure("C:/Documents and Settings/Administrator/桌面/整合代码/ImageAdminPortal/Resources/properties/log4j.properties");
LogFactory.consoleDebug("Test message");
	}
}

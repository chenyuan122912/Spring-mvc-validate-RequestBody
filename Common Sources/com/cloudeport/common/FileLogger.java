package com.cloudeport.common;

import java.net.URL;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 需要改写 适应可配置级别的日志输出方式,已完成。 新增 Error,Scheduler日志分类。CONSOLE 控制台输出弱化。
 * 
 * @author kang
 * 
 */
public class FileLogger {
//
//	// Action层日志输出器
//	private static Logger logger_action = getLogger("Action");

	// Service层日志输出器
	private static Logger logger_service = getLogger("SERVICE");

	// Dao层日志输出器
	private static Logger logger_dao = getLogger("DAO");

	// WebService层日志输出器
	private static Logger logger_webservice = getLogger("WEBSERVICE");

//	// 控制台日志输出器
//	private static Logger logger_console = getLogger("CONSOLE");

	// #Error
	private static Logger logger_error = getLogger("ERROR");
	// SCHEDULER
	private static Logger logger_scheduler = getLogger("SCHEDULER");
	
	//TFS
	private static Logger logger_TFS = getLogger("TFS");

	private static String caller = FileLogger.class.getName();

	// 初始化日志器
	private static Logger getLogger(String level) {

		boolean flag = initConfigure();
		if (flag) {
			return Logger.getLogger(level);
		} else {
			return null;
		}
	}

	// 加载日志配置文件
	private static boolean initConfigure() {

		URL url = getClassLoader().getResource("properties/athenalog4j.properties");

		if (url != null) {
			PropertyConfigurator.configure(url);
			return true;
		} else {
			return false;
		}
	}

	// 获取本地资源加载器
	private static ClassLoader getClassLoader() {

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		if (classLoader == null) {
			classLoader = FileLogger.class.getClassLoader();
		}
		return classLoader;
	}

//	// Action层日志输出方法
//	public static void debugAction(String msg) {
//
//		logger_action.log(caller, Level.DEBUG, msg, null);
//	}
//
//	public static void debugAction(String msg, Throwable cause) {
//
//		logger_action.log(caller, Level.DEBUG, msg, cause);
//	}
//
//	public static void debugAction(String msg, Map<String, Object> map) {
//
//		logger_action.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
//	}
//
//	public static void infoAction(String msg) {
//
//		logger_action.log(caller, Level.INFO, msg, null);
//	}
//
//	public static void infoAction(String msg, Throwable cause) {
//
//		logger_action.log(caller, Level.INFO, msg, cause);
//	}
//
//	public static void infoAction(String msg, Map<String, Object> map) {
//
//		logger_action.log(caller, Level.INFO, msg + "\n\t" + map, null);
//	}
//
//	public static void warnAction(String msg) {
//
//		logger_action.log(caller, Level.WARN, msg, null);
//	}
//
//	public static void warnAction(String msg, Throwable cause) {
//
//		logger_action.log(caller, Level.WARN, msg, cause);
//	}
//
//	public static void warnAction(String msg, Map<String, Object> map) {
//
//		logger_action.log(caller, Level.WARN, msg + "\n\t" + map, null);
//	}
//
//	public static void errorAction(String msg) {
//
//		logger_action.log(caller, Level.ERROR, msg, null);
//	}
//
//	public static void errorAction(String msg, Throwable cause) {
//
//		logger_action.log(caller, Level.ERROR, msg, cause);
//	}
//
//	public static void errorAction(String msg, Map<String, Object> map) {
//
//		logger_action.log(caller, Level.ERROR, msg + "\n\t" + map, null);
//	}

	// Service层日志输出方法
	public static void debugService(String msg) {

		logger_service.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugService(String msg, Throwable cause) {

		logger_service.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugService(String msg, Map<String, Object> map) {

		logger_service.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoService(String msg) {

		logger_service.log(caller, Level.INFO, msg, null);
	}

	public static void infoService(String msg, Throwable cause) {

		logger_service.log(caller, Level.INFO, msg, cause);
	}

	public static void infoService(String msg, Map<String, Object> map) {

		logger_service.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnService(String msg) {

		logger_service.log(caller, Level.WARN, msg, null);
	}

	public static void warnService(String msg, Throwable cause) {

		logger_service.log(caller, Level.WARN, msg, cause);
	}

	public static void warnService(String msg, Map<String, Object> map) {

		logger_service.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorService(String msg) {

		logger_service.log(caller, Level.ERROR, msg, null);
	}

	public static void errorService(String msg, Throwable cause) {

		logger_service.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorService(String msg, Map<String, Object> map) {

		logger_service.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}

	// Dao层日志输出方法
	public static void debugDao(String msg) {

		logger_dao.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugDao(String msg, Throwable cause) {

		logger_dao.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugDao(String msg, Map<String, Object> map) {

		logger_dao.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoDao(String msg) {

		logger_dao.log(caller, Level.INFO, msg, null);
	}

	public static void infoDao(String msg, Throwable cause) {

		logger_dao.log(caller, Level.INFO, msg, cause);
	}

	public static void infoDao(String msg, Map<String, Object> map) {

		logger_dao.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnDao(String msg) {

		logger_dao.log(caller, Level.WARN, msg, null);
	}

	public static void warnDao(String msg, Throwable cause) {

		logger_dao.log(caller, Level.WARN, msg, cause);
	}

	public static void warnDao(String msg, Map<String, Object> map) {

		logger_dao.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorDao(String msg) {

		logger_dao.log(caller, Level.ERROR, msg, null);
	}

	public static void errorDao(String msg, Throwable cause) {

		logger_dao.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorDao(String msg, Map<String, Object> map) {

		logger_dao.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}

	// WebService层日志输出方法
	public static void debugWebService(String msg) {

		logger_webservice.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugWebService(String msg, Throwable cause) {

		logger_webservice.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugWebService(String msg, Map<String, Object> map) {

		logger_webservice.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoWebService(String msg) {

		logger_webservice.log(caller, Level.INFO, msg, null);
	}

	public static void infoWebService(String msg, Throwable cause) {

		logger_webservice.log(caller, Level.INFO, msg, cause);
	}

	public static void infoWebService(String msg, Map<String, Object> map) {

		logger_webservice.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnWebService(String msg) {

		logger_webservice.log(caller, Level.WARN, msg, null);
	}

	public static void warnWebService(String msg, Throwable cause) {

		logger_webservice.log(caller, Level.WARN, msg, cause);
	}

	public static void warnWebService(String msg, Map<String, Object> map) {

		logger_webservice.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorWebService(String msg) {

		logger_webservice.log(caller, Level.ERROR, msg, null);
	}

	public static void errorWebService(String msg, Throwable cause) {

		logger_webservice.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorWebService(String msg, Map<String, Object> map) {

		logger_webservice.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}

//	// 控制台日志输出方法
//	public static void debugConsole(String msg) {
//
//		logger_console.log(caller, Level.DEBUG, msg, null);
//	}
//
//	public static void debugConsole(String msg, Throwable cause) {
//
//		logger_console.log(caller, Level.DEBUG, msg, cause);
//	}
//
//	public static void debugConsole(String msg, Map<String, Object> map) {
//
//		logger_console.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
//	}

	// Error层日志输出方法
	public static void debugError(String msg) {

		logger_error.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugError(String msg, Throwable cause) {

		logger_error.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugError(String msg, Map<String, Object> map) {

		logger_error.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoError(String msg) {

		logger_error.log(caller, Level.INFO, msg, null);
	}

	public static void infoError(String msg, Throwable cause) {

		logger_error.log(caller, Level.INFO, msg, cause);
	}

	public static void infoError(String msg, Map<String, Object> map) {

		logger_error.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnError(String msg) {

		logger_error.log(caller, Level.WARN, msg, null);
	}

	public static void warnError(String msg, Throwable cause) {

		logger_error.log(caller, Level.WARN, msg, cause);
	}

	public static void warnError(String msg, Map<String, Object> map) {

		logger_error.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorError(String msg) {

		logger_error.log(caller, Level.ERROR, msg, null);
	}

	public static void errorError(String msg, Throwable cause) {

		logger_error.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorError(String msg, Map<String, Object> map) {

		logger_error.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}

	// Scheduler层日志输出方法
	public static void debugScheduler(String msg) {

		logger_scheduler.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugScheduler(String msg, Throwable cause) {

		logger_scheduler.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugScheduler(String msg, Map<String, Object> map) {

		logger_scheduler.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoScheduler(String msg) {

		logger_scheduler.log(caller, Level.INFO, msg, null);
	}

	public static void infoScheduler(String msg, Throwable cause) {

		logger_scheduler.log(caller, Level.INFO, msg, cause);
	}

	public static void infoScheduler(String msg, Map<String, Object> map) {

		logger_scheduler.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnScheduler(String msg) {

		logger_scheduler.log(caller, Level.WARN, msg, null);
	}

	public static void warnScheduler(String msg, Throwable cause) {

		logger_scheduler.log(caller, Level.WARN, msg, cause);
	}

	public static void warnScheduler(String msg, Map<String, Object> map) {

		logger_scheduler.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorScheduler(String msg) {

		logger_scheduler.log(caller, Level.ERROR, msg, null);
	}

	public static void errorScheduler(String msg, Throwable cause) {

		logger_scheduler.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorScheduler(String msg, Map<String, Object> map) {

		logger_scheduler.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}
	
	// TFS层日志输出方法
	public static void debugTFS(String msg) {

		logger_TFS.log(caller, Level.DEBUG, msg, null);
	}

	public static void debugTFS(String msg, Throwable cause) {

		logger_TFS.log(caller, Level.DEBUG, msg, cause);
	}

	public static void debugTFS(String msg, Map<String, Object> map) {

		logger_TFS.log(caller, Level.DEBUG, msg + "\n\t" + map, null);
	}

	public static void infoTFS(String msg) {

		logger_TFS.log(caller, Level.INFO, msg, null);
	}

	public static void infoTFS(String msg, Throwable cause) {

		logger_TFS.log(caller, Level.INFO, msg, cause);
	}

	public static void infoTFS(String msg, Map<String, Object> map) {

		logger_TFS.log(caller, Level.INFO, msg + "\n\t" + map, null);
	}

	public static void warnTFS(String msg) {

		logger_TFS.log(caller, Level.WARN, msg, null);
	}

	public static void warnTFS(String msg, Throwable cause) {

		logger_TFS.log(caller, Level.WARN, msg, cause);
	}

	public static void warnTFS(String msg, Map<String, Object> map) {

		logger_TFS.log(caller, Level.WARN, msg + "\n\t" + map, null);
	}

	public static void errorTFS(String msg) {

		logger_TFS.log(caller, Level.ERROR, msg, null);
	}

	public static void errorTFS(String msg, Throwable cause) {

		logger_TFS.log(caller, Level.ERROR, msg, cause);
	}

	public static void errorTFS(String msg, Map<String, Object> map) {

		logger_TFS.log(caller, Level.ERROR, msg + "\n\t" + map, null);
	}
	
	public static void main(String[] args) {
		FileLogger.errorDao("errorDao");
		FileLogger.errorWebService("errorWebService");
		FileLogger.errorTFS("errorTFS");
	}
}

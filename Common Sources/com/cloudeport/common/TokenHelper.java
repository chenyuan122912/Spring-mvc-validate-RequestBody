package com.cloudeport.common;

import org.dom4j.Document;
import org.dom4j.Element;

import com.cloudeport.utils.MD5Util;
import com.cloudeport.utils.StringUtil;

/**
 * 用户Token认证辅助类

 * 
 * @author wyq
 * 
 */
public class TokenHelper {

	/**
	 * 获取Token认证字符串

	 * 
	 * @param userId
	 * @param deptId
	 * @return
	 */
	public static String getTokenString(String userId, String deptId) {

		String srcString = StringUtil.null2String(userId).trim() + StringUtil.null2String(deptId).trim();

		return MD5Util.md5Hex(srcString);
	}

	/**
	 * 进行Token认证
	 * 
	 * @param userId
	 * @param deptId
	 * @param loginToken
	 * @return
	 */
	public static boolean tokenValidate(String userId, String deptId, String loginToken) {

		String srcString = userId.trim() + deptId.trim();

		return MD5Util.validateData(srcString, loginToken);
	}

	/**
	 * 进行Token认证
	 * 
	 * @param userElement
	 * @return
	 */
	public static boolean tokenValidate(Element userElement) {

		String userId = StringUtil.null2String(userElement.attributeValue("userId")).trim();
		String deptId = StringUtil.null2String(userElement.attributeValue("deptId")).trim();
		String loginToken = StringUtil.null2String(userElement.attributeValue("loginToken")).trim();

		return tokenValidate(userId, deptId, loginToken);
	}

	/**
	 * 进行Token认证
	 * 
	 * @param doc
	 * @return
	 */
	public static boolean tokenValidate(Document doc) {

		Element userElement = (Element) doc.selectSingleNode("/Service/User");
		return tokenValidate(userElement);
	}

	public static void main(String[] args) {

		String userId = "test";
		String deptId = "11004";

		String loginToken = getTokenString(userId, deptId);
		System.out.println("loginToken is " + loginToken);

		boolean returnValue = tokenValidate(userId, deptId,
				loginToken);
		System.out.println("tokenValidate is " + returnValue);
	}
}

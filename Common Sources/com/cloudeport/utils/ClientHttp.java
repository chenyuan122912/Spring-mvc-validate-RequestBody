package com.cloudeport.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientHttp {
	/**
	 * strUrl = http://32.126.152.136:9080/DocumentManageServer/servlet/download
	 * appId = Credit
	 * fileId = 81
	 */
	public static byte[] call(String strUrl, String appId, String fileId ) throws Exception{
	
			HttpURLConnection conn = null;
			BufferedInputStream in = null;
			ByteArrayOutputStream byteArray = null;
	
			// 创建HTTP连接
			StringBuffer urlBuffer = new StringBuffer(strUrl);
			urlBuffer.append("?appId=" + appId);
			urlBuffer.append("&fileId=" + fileId);
	
			URL url = new URL(urlBuffer.toString());
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			in = new BufferedInputStream(conn.getInputStream());
			// 下载影像数据
			byteArray = new ByteArrayOutputStream();
			int length = 0;
			byte[] tempData = new byte[4096];
			while ((length = in.read(tempData)) > 0) {
				byteArray.write(tempData, 0, length);
			}
			in.close();
			conn.disconnect();
			return byteArray.toByteArray();
	}
}

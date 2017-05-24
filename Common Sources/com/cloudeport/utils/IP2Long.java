package com.cloudeport.utils;

public class IP2Long {
	
	public static long ipToLong(String strIp){// 将IP地址转为整数
		long[] ip=new long[4];
		int position1=strIp.indexOf(".");
		int position2=strIp.indexOf(".",position1+1);
		int position3=strIp.indexOf(".",position2+1);
		
		ip[0]=Long.parseLong(strIp.substring(0, position1));
		ip[1]=Long.parseLong(strIp.substring(position1+1, position2));
		ip[2]=Long.parseLong(strIp.substring(position2+1, position3));
		ip[3]=Long.parseLong(strIp.substring(position3+1));
		return (ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8)+ip[3];
	}
	public static String longToIP(long longIP){// 将整数转为IP地址
		StringBuffer sb=new StringBuffer("");
		sb.append(String.valueOf((longIP>>>24)));
		sb.append(".");
		sb.append(String.valueOf((longIP&0x00FFFFFF)>>>16));
		sb.append(".");
		sb.append(String.valueOf((longIP&0x00FFFF)>>>8));
		sb.append(".");
		sb.append(String.valueOf((longIP&0x00FF)));
		return sb.toString();
		
	}
	public static long ip3ToLong(String strIp){//将IP地址的前三位转为整数
		long[] ip=new long[4];
		int position1=strIp.indexOf(".");
		int position2=strIp.indexOf(".",position1+1);
		int position3=strIp.indexOf(".",position2+1);
		ip[0]=Long.parseLong(strIp.substring(0, position1));
		ip[1]=Long.parseLong(strIp.substring(position1+1, position2));
		ip[2]=Long.parseLong(strIp.substring(position2+1, position3));
		return (ip[0]<<24)+(ip[1]<<16)+(ip[2]<<8);
	}
	public static long getIP4(String strIp){//获取IP地址的第四位
		long[] ip=new long[4];
		int position1=strIp.indexOf(".");
		int position2=strIp.indexOf(".",position1+1);
		int position3=strIp.indexOf(".",position2+1);
		ip[3]=Long.parseLong(strIp.substring(position3+1));
		return ip[3];
	}
	
	public static void main(String args[]){
		String ipStr="8.88.88.5";
		long longIP=ipToLong(ipStr);
		long longIP3=ip3ToLong(ipStr);
		long longIP4=getIP4(ipStr);
		System.out.println(longIP);
		System.out.println(longIP3);
		System.out.println(longIP4);
		System.out.println(longToIP(longIP));
	}
}

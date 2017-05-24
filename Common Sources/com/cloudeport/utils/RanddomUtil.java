package com.cloudeport.utils;

import java.util.Random;

public class RanddomUtil {
	
	public static int getRanddom(int min,int max){

		int interval = max-min+1;
		
		Random ran = new Random();
		
		int returnValue = ran.nextInt(interval)+min;

		return returnValue;
	}
}

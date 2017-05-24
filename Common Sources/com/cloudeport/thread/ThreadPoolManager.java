package com.cloudeport.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class ThreadPoolManager {
	private static ThreadPoolExecutor pool = getExecutorService();
	private static synchronized ThreadPoolExecutor getExecutorService() {
		if (pool == null) {

			pool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		}
		return pool;
	} 
	
	public static void execute(Runnable r){
		pool.execute(r);
	}
	

}

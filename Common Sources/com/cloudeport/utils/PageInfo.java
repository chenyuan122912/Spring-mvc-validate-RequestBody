package com.cloudeport.utils;

public class PageInfo {
  
	private String pageBegin = "";
	private String pageLen = "";
	private String pageCount = "-1";
	
	public PageInfo(String pageBegin, String pageLen) {
		
		this.pageBegin = pageBegin;
		this.pageLen = pageLen;
		
		initPageInfo();
		
	}
	
	private void initPageInfo(){
		
		if(this.pageLen.equals("")){
			 this.pageLen = "10"; 
		}
		if(this.pageBegin.equals("")){
			 this.pageBegin = "0";
		}
	}

	public String getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(String pageBegin) {
		this.pageBegin = pageBegin;
	}
	public String getPageLen() {
		return pageLen;
	}
	public void setPageLen(String pageLen) {
		this.pageLen = pageLen;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	
}

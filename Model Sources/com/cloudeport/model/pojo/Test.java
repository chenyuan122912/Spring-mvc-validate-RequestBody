package com.cloudeport.model.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Test {
	//@NotBlank(message="mId 不能为空")
	private String mId;
	@NotBlank(message="idCard不能为空")
	private String idCard;
	private String realName;
	@Range(min=1,max=10,message="范围在1-10之间")
	private Integer status;

	public String getMId() {
		return mId;
	}
	public void setMId(String mId) {
		this.mId = mId;
	}
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPkString() {
	return this.getClass().getSimpleName()
				+"_"+mId
				;
	}
	
}
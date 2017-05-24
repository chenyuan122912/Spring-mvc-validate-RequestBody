package com.cloudeport.model.base;

/**
 * 消息提示类
 * 
 * @author z
 *
 */
public class Message {

	private String msg;// 消息提示
	private String username;// 用户名
	private int Code;// 状态码 0失败，1成功

	public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

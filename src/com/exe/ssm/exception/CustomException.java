package com.exe.ssm.exception;
/**
 * 系统自定义异常，针对 预期的 异常，需要在程序中抛出此类异常
 * @author Administrator
 *
 */
public class CustomException extends Exception{
	
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

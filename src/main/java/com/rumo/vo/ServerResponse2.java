package com.rumo.vo;


/**
 * 
 * {
 *   data:
 *   status/code:
 *   msg:
 *   
 * }
 * 
 * 统一返回值
 * @author Administrator
 * @param 
 */
public class ServerResponse2 {
	
	private int status;
	private String msg;
	private Object data;
	
	//私有构造函数
	private ServerResponse2(int status) {
		this.status = status;
	}
	
	//私有构造函数
	private ServerResponse2(int status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	//私有构造函数
	private ServerResponse2(int status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	//私有构造函数
	private ServerResponse2(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	// 使之不在json序列化结果当中
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}
	

	//正确返回
	public static  ServerResponse2 createBySuccess() {
		return new ServerResponse2(ResponseCode.SUCCESS.getCode());
	}

	public static  ServerResponse2 createBySuccessMessage(String msg) {
		return new ServerResponse2(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static  ServerResponse2 createBySuccess(Object data) {
		return new ServerResponse2(ResponseCode.SUCCESS.getCode(), data);
	}

	public static  ServerResponse2 createBySuccess(String msg, Object data) {
		return new ServerResponse2(ResponseCode.SUCCESS.getCode(), msg, data);
	}
	
	
	//error返回
	public static  ServerResponse2 createByError() {
		return new ServerResponse2(500, ResponseCode.ERROR.getDesc());
	}

	public static  ServerResponse2 createByErrorMessage(String errorMessage) {
		return new ServerResponse2(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static  ServerResponse2 createByErrorCodeMessage(int errorCode, String errorMessage) {
		return new ServerResponse2(errorCode, errorMessage);
	}

}

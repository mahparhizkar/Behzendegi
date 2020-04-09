package com.toranjinotec.behzendegi.common_module.responses;

import java.io.Serializable;

public class HomeResponse implements Serializable {
	
	private static final long serialVersionUID = 6025398828266564953L;

	public HomeResponse(String Message,int Code) {
		this.code = Code;
		this.message = Message;
	}
	
	private String message;
	
	private int code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}

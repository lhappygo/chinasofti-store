package com.chinasofti.app.handler;

public class MyException extends Exception {
	
	private static final long serialVersionUID = 98967561L;
	
	private String code;
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MyException(String code,String message) {
        super(message);
        this.code=code;
    }

}

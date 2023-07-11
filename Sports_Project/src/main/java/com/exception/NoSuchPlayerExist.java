package com.exception;

public class NoSuchPlayerExist extends RuntimeException{
	
	String msg;

	public NoSuchPlayerExist() {
		super();
	}

	public NoSuchPlayerExist(String msg) {
		super();
		this.msg = msg;
	}

}

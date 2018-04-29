package com.parttime.util;

import java.io.Serializable;

public class Result<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 0;
	public static final int FAILED = 1;
	private int status;
	private String msg;
	private T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Result(int status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public Result() {
		super();
	}
}

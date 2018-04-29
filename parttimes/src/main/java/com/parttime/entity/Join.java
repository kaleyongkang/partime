package com.parttime.entity;

import java.util.Date;

public class Join {
	private Integer id;
	private Integer jobId;
	private String userName;
	private String status;
	private Date joinTime;
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Join(Integer id, Integer jobId, String userName, String status) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.userName = userName;
		this.status = status;
	}
	public Join() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Join [id=" + id + ", jobId=" + jobId + ", userName=" + userName + ", status=" + status + "]";
	}
	
}

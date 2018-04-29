package com.parttime.entity;

public class FilterFind {
	private String user;
	private String title;
	private String orderBy;
	private String type;
	private String part;
	private String city;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "FilterFind [user=" + user + ", title=" + title + ", orderBy=" + orderBy + ", type=" + type + ", part="
				+ part + ", city=" + city + "]";
	}
	public FilterFind(String user, String title, String orderBy, String type, String part, String city) {
		super();
		this.user = user;
		this.title = title;
		this.orderBy = orderBy;
		this.type = type;
		this.part = part;
		this.city = city;
	}
	public FilterFind() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

package com.parttime.entity;

public class Company {
	private Integer id;
	private String username;
	private String password;
	private String companyName;
	private String companyIntroduce;
	private String email;
	private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyIntroduce() {
		return companyIntroduce;
	}
	public void setCompanyIntroduce(String companyIntroduce) {
		this.companyIntroduce = companyIntroduce;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Company(Integer id, String username, String password, String companyName, String companyIntroduce,
			String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.companyName = companyName;
		this.companyIntroduce = companyIntroduce;
		this.email = email;
		this.phone = phone;
	}
	public Company() {
		super();
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", username=" + username + ", password=" + password + ", companyName="
				+ companyName + ", companyIntroduce=" + companyIntroduce + ", email=" + email + ", phone=" + phone
				+ "]";
	}
}

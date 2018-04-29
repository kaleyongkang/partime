package com.parttime.entity;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String file;
	private String Picture;
	private String advantage;
	private String skill;
	private String introduce;
	private String role;
	private String phone;
	private String email;
	private String schoolName;
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getAdvantage() {
		return advantage;
	}
	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, String password, String file, String picture, String advantage,
			String skill, String introduce, String role, String phone, String email, String schoolName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.file = file;
		Picture = picture;
		this.advantage = advantage;
		this.skill = skill;
		this.introduce = introduce;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", file=" + file + ", Picture="
				+ Picture + ", advantage=" + advantage + ", skill=" + skill + ", introduce=" + introduce + ", role="
				+ role + ", phone=" + phone + ", email=" + email + ", schoolName=" + schoolName + "]";
	}
	
	
	

}

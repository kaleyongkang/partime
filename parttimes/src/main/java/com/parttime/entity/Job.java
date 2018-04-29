package com.parttime.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Job {
	private Integer id;
	private String title;
	private String type;
	private Date createtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endtime;
	private Integer needcount;
	private String slarry;
	private String description;
	private String site;
	private String city;
	private String part;
	private String phone;
	private String createBy;
	public Job(Integer id, String title, String type, Date createtime, Date startTime, Date endtime, Integer needcount,
			String slarry, String tYPE2, String description, String site, String city, String part, String phone,
			String createBy) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.createtime = createtime;
		this.startTime = startTime;
		this.endtime = endtime;
		this.needcount = needcount;
		this.slarry = slarry;
		this.description = description;
		this.site = site;
		this.city = city;
		this.part = part;
		this.phone = phone;
		this.createBy = createBy;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getNeedcount() {
		return needcount;
	}
	public void setNeedcount(Integer needcount) {
		this.needcount = needcount;
	}
	public String getSlarry() {
		return slarry;
	}
	public void setSlarry(String slarry) {
		this.slarry = slarry;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", type=" + type + ", createtime=" + createtime + ", startTime="
				+ startTime + ", endtime=" + endtime + ", needcount=" + needcount + ", slarry=" + slarry
				+ ", description=" + description + ", site=" + site + ", city=" + city + ", part=" + part + ", phone="
				+ phone + ", createBy=" + createBy + "]";
	}
	
}

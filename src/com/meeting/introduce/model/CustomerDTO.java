package com.meeting.introduce.model;

public class CustomerDTO {

	private String rownum; //rownum
	private String customerSeq; //user seq
	private String customerName; //user name
	private String cntGood; //count of point
	private String image; //profile image name
	
	private String nickname;
	private String age;
	private String job;
	
	public String getCustomerSeq() {
		return customerSeq;
	}
	public void setCustomerSeq(String customerSeq) {
		this.customerSeq = customerSeq;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCntGood() {
		return cntGood;
	}
	public void setCntGood(String cntGood) {
		this.cntGood = cntGood;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}	
}

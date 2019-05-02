package com.meeting.introduce.model;

public class IntroduceDTO {
	private String seq;
	private String id;
	private String name;
	private String regdate;
	private String managerInfo;
	private String ssn; //매니저 주민등록 번호 -> 나이 
	private int age; //매니저 나이 저장
	private String image;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getManagerInfo() {
		return managerInfo;
	}
	public void setManagerInfo(String managerInfo) {
		this.managerInfo = managerInfo;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}

package com.meeting.mypage.model;

/**
 * tblManager DTO
 * @author 김석현
 *
 */
public class ManagerDTO {

	private String seq;
	private String id;
	private String pw;
	private String ssn;
	private String name; 
	private String age;
	private String regdate;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "ManagerDTO [seq=" + seq + ", id=" + id + ", pw=" + pw + ", ssn=" + ssn + ", name=" + name + ", age="
				+ age + ", regdate=" + regdate + "]";
	}
	
	
	
}

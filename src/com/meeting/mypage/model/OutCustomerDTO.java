package com.meeting.mypage.model;

/**
 * tblOutCustomer DTO
 * @author 김석현
 *
 */
public class OutCustomerDTO {
	private String seq;
	private String name;
	private String gender;
	private String age;
	private String tel;
	private String regdate;
	private String reason;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "OutCustomerDTO [seq=" + seq + ", name=" + name + ", gender=" + gender + ", age=" + age + ", tel=" + tel
				+ ", regdate=" + regdate + ", reason=" + reason + "]";
	}
	
	
	
	
	
}

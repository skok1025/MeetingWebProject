package com.meeting.mypage.model;

/**
 * tblCustomer DTO 
 * @author 김석현
 *
 */
public class CustomerDTO {
	private String seq;
	private String id;
	private String name;
	private String nick;
	private String gender;
	private String mseq;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	@Override
	public String toString() {
		return "CustomerDTO [seq=" + seq + ", id=" + id + ", name=" + name + ", nick=" + nick + ", gender=" + gender
				+ ", mseq=" + mseq + "]";
	}
	
	

}

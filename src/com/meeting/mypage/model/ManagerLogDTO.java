package com.meeting.mypage.model;

/**
 * tblManagerLog DTO
 * @author 김석현
 *
 */
public class ManagerLogDTO {
	private String seq;
	private String logindate;
	private String logoutdate;
	private String mseq;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public String getLogoutdate() {
		return logoutdate;
	}
	public void setLogoutdate(String logoutdate) {
		this.logoutdate = logoutdate;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	@Override
	public String toString() {
		return "ManagerLogDTO [seq=" + seq + ", logindate=" + logindate + ", logoutdate=" + logoutdate + ", mseq="
				+ mseq + "]";
	}
	
	
	
	
}

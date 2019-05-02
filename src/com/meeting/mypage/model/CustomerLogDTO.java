package com.meeting.mypage.model;

/**
 * tblCustomerLog DTO
 * @author sist40
 *
 */
public class CustomerLogDTO {
	private String seq;
	private String logindate;
	private String logoutdate;
	private String cseq;
	
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
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	@Override
	public String toString() {
		return "CustomerLogDTO [seq=" + seq + ", logindate=" + logindate + ", logoutdate=" + logoutdate + ", cseq="
				+ cseq + "]";
	}
	
	
	
	
}

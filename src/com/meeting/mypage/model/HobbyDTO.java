package com.meeting.mypage.model;

/**
 * tblHobby DTO 
 * @author 김석현
 *
 */
public class HobbyDTO {
	private String	seq;
	private String tdseq;
	private String shseq;
	private String cdseq;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTdseq() {
		return tdseq;
	}
	public void setTdseq(String tdseq) {
		this.tdseq = tdseq;
	}
	public String getShseq() {
		return shseq;
	}
	public void setShseq(String shseq) {
		this.shseq = shseq;
	}
	public String getCdseq() {
		return cdseq;
	}
	public void setCdseq(String cdseq) {
		this.cdseq = cdseq;
	}
	
	@Override
	public String toString() {
		return "HobbyDTO [seq=" + seq + ", tdseq=" + tdseq + ", shseq=" + shseq + ", cdseq=" + cdseq + "]";
	}
	
	
	

}

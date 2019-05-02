package com.meeting.mypage.model;


/**
 * tblSmallHobby DTO
 * @author 김석현
 *
 */
public class SmallHobbyDTO {
	
	private String seq;
	private String smallhobby;
	private String bhseq;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSmallhobby() {
		return smallhobby;
	}
	public void setSmallhobby(String smallhobby) {
		this.smallhobby = smallhobby;
	}
	public String getBhseq() {
		return bhseq;
	}
	public void setBhseq(String bhseq) {
		this.bhseq = bhseq;
	}
	@Override
	public String toString() {
		return "SmallHobbyDTO [seq=" + seq + ", smallhobby=" + smallhobby + ", bhseq=" + bhseq + "]";
	}
	
	
	
	

}

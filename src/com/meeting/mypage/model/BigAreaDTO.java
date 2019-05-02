package com.meeting.mypage.model;
/**
 * tblBigArea DTO 
 * @author 김석현
 *
 */
public class BigAreaDTO {
	private String seq;
	private String bigarea;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getBigarea() {
		return bigarea;
	}
	public void setBigarea(String bigarea) {
		this.bigarea = bigarea;
	}
	@Override
	public String toString() {
		return "BigAreaDTO [seq=" + seq + ", bigarea=" + bigarea + "]";
	}
	
	
	
	
	
}

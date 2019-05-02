package com.meeting.mypage.model;

/**
 * tblSmallArea DTO
 * @author 김석현
 *
 */
public class SmallAreaDTO {
	private String seq;
	private String smallarea;
	private String baseq;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSmallarea() {
		return smallarea;
	}
	public void setSmallarea(String smallarea) {
		this.smallarea = smallarea;
	}
	public String getBaseq() {
		return baseq;
	}
	public void setBaseq(String baseq) {
		this.baseq = baseq;
	}
	@Override
	public String toString() {
		return "SmallAreaDTO [seq=" + seq + ", smallarea=" + smallarea + ", baseq=" + baseq + "]";
	}
	
	
	
	
	
}

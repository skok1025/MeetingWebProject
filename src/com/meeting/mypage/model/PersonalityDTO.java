package com.meeting.mypage.model;

/**
 * tblPersonality DTO
 * @author 김석현
 *
 */
public class PersonalityDTO {
	private String seq;
	private String type;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PersonalityDTO [seq=" + seq + ", type=" + type + "]";
	}
	
	
	

}

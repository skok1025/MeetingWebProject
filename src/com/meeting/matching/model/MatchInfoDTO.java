package com.meeting.matching.model;

/**
 * tblMatchInfo DTO
 * 
 * @author 한상민
 *
 */
public class MatchInfoDTO {
	private String seq;
	private String kind;
	private String description;
	
	
	@Override
	public String toString() {
		return "MatchInfoDTO [seq=" + seq + ", kind=" + kind + ", description=" + description + "]";
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

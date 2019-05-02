package com.meeting.matching.model;

/**
 * tbldateGrade DTO
 * 
 * @author 한상민
 *
 */

public class DateGradeDTO {
	private String seq;
	private String content;
	private String score;
	private String cseq;
	private String mrseq;
	private String dcseq;
	
	
	@Override
	public String toString() {
		return "DateGradeDTO [seq=" + seq + ", content=" + content + ", score=" + score + ", cseq=" + cseq + ", mrseq="
				+ mrseq + ", dcseq=" + dcseq + "]";
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getMrseq() {
		return mrseq;
	}
	public void setMrseq(String mrseq) {
		this.mrseq = mrseq;
	}
	public String getDcseq() {
		return dcseq;
	}
	public void setDcseq(String dcseq) {
		this.dcseq = dcseq;
	}
	
	
}

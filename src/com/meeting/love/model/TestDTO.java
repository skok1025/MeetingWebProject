package com.meeting.love.model;

/**
 * tblTest DTO
 * 
 * @author 임광민
 *
 */

public class TestDTO {
	private String seq;
	private String pnumber;
	private String content;
	private String score;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
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
	
	@Override
	public String toString() {
		return "TestDTO [seq=" + seq + ", pnumber=" + pnumber + ", content=" + content + ", score=" + score + "]";
	}
}

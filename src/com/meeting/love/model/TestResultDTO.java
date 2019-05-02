package com.meeting.love.model;

/**
 * tblTestResult DTO
 * 
 * @author 임광민
 *
 */

public class TestResultDTO {
	private String seq;
	private int pnumber;
	private String content;
	private int score;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "TestResultDTO [seq=" + seq + ", pnumber=" + pnumber + ", content=" + content + ", score=" + score + "]";
	}
}

package com.meeting.matching.model;

/**
 * tblGrade DTO
 * 
 * @author 한상민
 *
 */
public class GradeDTO {
	
	private String seq;
	private String minscore;
	private String maxscore;
	private String grade;
	
	
	@Override
	public String toString() {
		return "GradeDTO [seq=" + seq + ", minscore=" + minscore + ", maxscore=" + maxscore + ", grade=" + grade + "]";
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMinscore() {
		return minscore;
	}
	public void setMinscore(String minscore) {
		this.minscore = minscore;
	}
	public String getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(String maxscore) {
		this.maxscore = maxscore;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}

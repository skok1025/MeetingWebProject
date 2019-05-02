package com.meeting.main;

public class ExamDTO {
	private String seq;
	private String pnumber;
	private String score;
	private String content;
	private String panswer;
	private String kind;
	
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPanswer() {
		return panswer;
	}
	public void setPanswer(String panswer) {
		this.panswer = panswer;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "ExamDTO [seq=" + seq + ", pnumber=" + pnumber + ", score=" + score + ", content=" + content
				+ ", panswer=" + panswer + ", kind=" + kind + "]";
	}

	
	
}

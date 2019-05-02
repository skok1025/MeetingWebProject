/**
 * 
 * tblDateRecommendComment DTO
 * @author 송미령
 * 
 */
package com.meeting.community.model;


public class DateRecommendCommentDTO {

	private String seq;
	private String content;
	private String regdate;
	private String drseq;
	private String cseq;
	private String name;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getDrseq() {
		return drseq;
	}

	public void setDrseq(String drseq) {
		this.drseq = drseq;
	}

	public String getCseq() {
		return cseq;
	}

	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	@Override
	public String toString() {
		return "DateRecommendCommentDTO [seq=" + seq + ", content=" + content + ", regdate=" + regdate + ", drseq="
				+ drseq + ", cseq=" + cseq + ", name=" + name + ", id=" + id + "]";
	}

	
	
}

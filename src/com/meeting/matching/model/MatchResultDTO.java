package com.meeting.matching.model;

/**
 * tblMatchResult DTO
 * 
 * @author 한상민
 *
 */
public class MatchResultDTO {
	private String seq;
	private String cseq;
	private String pcseq;
	private String accept;
	private String cofirm;
	private String sendseq;
	private String content;
	
	
	@Override
	public String toString() {
		return "MatchResultDTO [seq=" + seq + ", cseq=" + cseq + ", pcseq=" + pcseq + ", accept=" + accept + ", cofirm="
				+ cofirm + ", sendseq=" + sendseq + ", content=" + content + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCofirm() {
		return cofirm;
	}
	public void setCofirm(String cofirm) {
		this.cofirm = cofirm;
	}
	public String getSendseq() {
		return sendseq;
	}
	public void setSendseq(String sendseq) {
		this.sendseq = sendseq;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getPcseq() {
		return pcseq;
	}
	public void setPcseq(String pcseq) {
		this.pcseq = pcseq;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	
}

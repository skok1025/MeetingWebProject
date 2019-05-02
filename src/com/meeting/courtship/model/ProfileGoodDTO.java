/**
 * tblProfileGood DTO
 * @author 이인열
 */

package com.meeting.courtship.model;

public class ProfileGoodDTO {

	private String seq;
	private String good;
	private String cseq;
	private String pseq;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getCseq() {
		return cseq;
	}

	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	public String getPseq() {
		return pseq;
	}

	public void setPseq(String pseq) {
		this.pseq = pseq;
	}

	@Override
	public String toString() {
		return "ProfileGoodDTO [seq=" + seq + ", good=" + good + ", cseq=" + cseq + ", pseq=" + pseq + "]";
	}

}

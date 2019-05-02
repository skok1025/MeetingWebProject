/**
 * tblProfile DTO
 * @author 이인열
 */
package com.meeting.courtship.model;

public class ProfileDTO {

	private String seq;
	private String cseq;

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

	@Override
	public String toString() {
		return "ProfileDTO [seq=" + seq + ", cseq=" + cseq + "]";
	}

}

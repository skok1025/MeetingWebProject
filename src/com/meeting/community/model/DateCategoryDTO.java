/**
 * 
 * tblDateCategory DTO
 * @author 송미령
 * 
 */

package com.meeting.community.model;

public class DateCategoryDTO {

	private String seq;
	private String cate;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	@Override
	public String toString() {
		return "DateCategoryDTO [seq=" + seq + ", cate=" + cate + "]";
	}
}

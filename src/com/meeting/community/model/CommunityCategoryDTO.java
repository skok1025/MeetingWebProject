/**
 * 
 * tblCommunityCategory DTO
 * @author 송미령
 * 
 */


package com.meeting.community.model;

public class CommunityCategoryDTO {

	private String seq;
	private String category;

	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CommunityCategoryDTO [seq=" + seq + ", category=" + category + "]";
	}
}

package com.meeting.mypage.model;

public class CategoryCntDTO {
	private String category;
	private int cnt;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CategoryCntDTO [category=" + category + ", cnt=" + cnt + "]";
	}
	
	
	
}

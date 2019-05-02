package com.meeting.community.model;

public class DateListDTO {

	private String seq;
	private String area;
	private String title;
	private String content;
	private String category;
	private String dcseq;
	private String mseq;
	private String name;
	private String lat;
	private String lng;
	
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDcseq() {
		return dcseq;
	}
	public void setDcseq(String dcseq) {
		this.dcseq = dcseq;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

	@Override
	public String toString() {
		return "DateListDTO [seq=" + seq + ", area=" + area + ", title=" + title + ", content=" + content
				+ ", category=" + category + ", dcseq=" + dcseq + ", mseq=" + mseq + ", name=" + name + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}
	
}

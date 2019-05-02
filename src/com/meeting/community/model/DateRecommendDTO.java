/**
 * 
 * tblDateRecommend DTO
 * @author 송미령
 * 
 */
package com.meeting.community.model;

public class DateRecommendDTO {

	private String seq;
	private String area;
	private String title;
	private String content;
	private String dcseq;
	private String mseq;
	private String category;
	private String categorynum;
	private String managernum;
	private String lng;
	private String lat;
	private String managername;
	private String id;
	private String location;
	
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategorynum() {
		return categorynum;
	}
	public void setCategorynum(String categorynum) {
		this.categorynum = categorynum;
	}
	public String getManagernum() {
		return managernum;
	}
	public void setManagernum(String managernum) {
		this.managernum = managernum;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "DateRecommendDTO [seq=" + seq + ", area=" + area + ", title=" + title + ", content=" + content
				+ ", dcseq=" + dcseq + ", mseq=" + mseq + ", category=" + category + ", categorynum=" + categorynum
				+ ", managernum=" + managernum + ", lng=" + lng + ", lat=" + lat + ", managername=" + managername
				+ ", id=" + id + ", location=" + location + "]";
	}

	
}

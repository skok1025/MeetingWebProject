package com.meeting.mypage.model;

public class MyMeetingDTO {

	private String seq;
	private String myname;
	private String myid;
	private String pname;
	private String pid;
	private String accept;
	private String mycontent;
	private String pcontent;
	private String category;
	private String myscore;
	private String pscore;
	private String myimg;
	private String pimg;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMyid() {
		return myid;
	}
	public void setMyid(String myid) {
		this.myid = myid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMyscore() {
		return myscore;
	}
	public void setMyscore(String myscore) {
		this.myscore = myscore;
	}
	public String getPscore() {
		return pscore;
	}
	public void setPscore(String pscore) {
		this.pscore = pscore;
	}
	public String getMyimg() {
		return myimg;
	}
	public void setMyimg(String myimg) {
		this.myimg = myimg;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	@Override
	public String toString() {
		return "MyMeetingDTO [seq=" + seq + ", myname=" + myname + ", myid=" + myid + ", pname=" + pname + ", pid="
				+ pid + ", accept=" + accept + ", mycontent=" + mycontent + ", pcontent=" + pcontent + ", category="
				+ category + ", myscore=" + myscore + ", pscore=" + pscore + ", myimg=" + myimg + ", pimg=" + pimg
				+ "]";
	}
	
	
}

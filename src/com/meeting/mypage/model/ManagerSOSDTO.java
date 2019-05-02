package com.meeting.mypage.model;

/**
 * tblManagerSOS DTO
 */
public class ManagerSOSDTO {
	
	private String seq;
	private String content;
	private String status;
	private String statuscontent;
	private String regdate;
	private String statusregdate;
	private String cseq;
	private String mseq;
	
	private String id; // 작성자 아이디
	private String name; // 작성자 이름
	private String mid; // 매니저 아이디
	private String mname;
	
	private String image;
	
	private String nick;
	private String gender;
	private String pw;
	private String userregdate;
	private String tel;
	private String grade;
	private String badge;
	private String age;
	private String ability;
	private String height;
	
	private int plan;
	private int humor;
	private int alacrity;
	private int sense;
	private int extrovert;
	private int style;
	
	private String introduce;
	
	private String maxheight;
	private String minheight;
	private String pjob;
	
	
	
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserregdate() {
		return userregdate;
	}
	public void setUserregdate(String userregdate) {
		this.userregdate = userregdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public int getHumor() {
		return humor;
	}
	public void setHumor(int humor) {
		this.humor = humor;
	}
	public int getAlacrity() {
		return alacrity;
	}
	public void setAlacrity(int alacrity) {
		this.alacrity = alacrity;
	}
	public int getSense() {
		return sense;
	}
	public void setSense(int sense) {
		this.sense = sense;
	}
	public int getExtrovert() {
		return extrovert;
	}
	public void setExtrovert(int extrovert) {
		this.extrovert = extrovert;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMaxheight() {
		return maxheight;
	}
	public void setMaxheight(String maxheight) {
		this.maxheight = maxheight;
	}
	public String getMinheight() {
		return minheight;
	}
	public void setMinheight(String minheight) {
		this.minheight = minheight;
	}
	public String getPjob() {
		return pjob;
	}
	public void setPjob(String pjob) {
		this.pjob = pjob;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatuscontent() {
		return statuscontent;
	}
	public void setStatuscontent(String statuscontent) {
		this.statuscontent = statuscontent;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getStatusregdate() {
		return statusregdate;
	}
	public void setStatusregdate(String statusregdate) {
		this.statusregdate = statusregdate;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	@Override
	public String toString() {
		return "ManagerSOSDTO [seq=" + seq + ", content=" + content + ", status=" + status + ", statuscontent="
				+ statuscontent + ", regdate=" + regdate + ", statusregdate=" + statusregdate + ", cseq=" + cseq
				+ ", mseq=" + mseq + "]";
	}
	
	

}

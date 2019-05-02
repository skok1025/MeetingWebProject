package com.meeting.mypage.model;

/**
 * tblCustomerDetail DTO 
 * @author 김석현
 *
 */
public class CustomerDetailDTO {

	private String seq;
	private String pw;
	private String date;
	private String image;
	private String tel;
	private String grade;
	private String age;
	private String ability;
	private String height;
	private String job;
	private int plan;
	private int humor;
	private int alacrity;
	private int sense;
	private int extrovert;
	private int style;
	private String cseq;
	private String ltseq;
	private String saseq;
	private String pseq;
	private String introduce;
	
	private String id;
	private String mid;
	private String name;
	private String nick;
	private String gender;
	private String regdate;
	private String content; // 러브 테스트 결과
	
	private String maxHeight;
	private String minHeight;
	private String smallhobby;
	private String smallarea;
	private String bigarea;
	
	private String ptype;
	
	
	
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}
	public String getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}
	public String getSmallhobby() {
		return smallhobby;
	}
	public void setSmallhobby(String smallhobby) {
		this.smallhobby = smallhobby;
	}
	public String getSmallarea() {
		return smallarea;
	}
	public void setSmallarea(String smallarea) {
		this.smallarea = smallarea;
	}
	public String getBigarea() {
		return bigarea;
	}
	public void setBigarea(String bigarea) {
		this.bigarea = bigarea;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getLtseq() {
		return ltseq;
	}
	public void setLtseq(String ltseq) {
		this.ltseq = ltseq;
	}
	public String getSaseq() {
		return saseq;
	}
	public void setSaseq(String saseq) {
		this.saseq = saseq;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "CustomerDetailDTO [seq=" + seq + ", pw=" + pw + ", date=" + date + ", image=" + image + ", tel=" + tel
				+ ", grade=" + grade + ", age=" + age + ", ability=" + ability + ", height=" + height + ", job=" + job
				+ ", plan=" + plan + ", humor=" + humor + ", alacrity=" + alacrity + ", sense=" + sense + ", extrovert="
				+ extrovert + ", style=" + style + ", cseq=" + cseq + ", ltseq=" + ltseq + ", saseq=" + saseq
				+ ", pseq=" + pseq + ", introduce=" + introduce + ", mid=" + mid + "]";
	}

	
}

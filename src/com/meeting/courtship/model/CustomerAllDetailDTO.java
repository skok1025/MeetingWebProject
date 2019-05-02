package com.meeting.courtship.model;

public class CustomerAllDetailDTO {
	private String seq;
	private String id;
	private String name;
	private String nick;
	private String image;
	private String grade;
	private String age;
	private String ability;
	private String height;
	private String job;
	private String introduce;
	private String cplan;
	private String chumor;
	private String calacrity;
	private String csense;
	private String cextrovert;
	private String cstyle;
	private String lplan;
	private String lhumor;
	private String lalacrity;
	private String lsense;
	private String lextrovert;
	private String lstyle;
	
	//상민이 추가(지역,컨텐트)
	private String bigarea;
	private String smallarea;
	private String content;
	private String managerName;
	private String managerImage;
	
	

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerImage() {
		return managerImage;
	}

	public void setManagerImage(String managerImage) {
		this.managerImage = managerImage;
	}

	public String getBigarea() {
		return bigarea;
	}

	public void setBigarea(String bigarea) {
		this.bigarea = bigarea;
	}

	public String getSmallarea() {
		return smallarea;
	}

	public void setSmallarea(String smallarea) {
		this.smallarea = smallarea;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCplan() {
		return cplan;
	}

	public void setCplan(String cplan) {
		this.cplan = cplan;
	}

	public String getChumor() {
		return chumor;
	}

	public void setChumor(String chumor) {
		this.chumor = chumor;
	}

	public String getCalacrity() {
		return calacrity;
	}

	public void setCalacrity(String calacrity) {
		this.calacrity = calacrity;
	}

	public String getCsense() {
		return csense;
	}

	public void setCsense(String csense) {
		this.csense = csense;
	}

	public String getCextrovert() {
		return cextrovert;
	}

	public void setCextrovert(String cextrovert) {
		this.cextrovert = cextrovert;
	}

	public String getCstyle() {
		return cstyle;
	}

	public void setCstyle(String cstyle) {
		this.cstyle = cstyle;
	}

	public String getLplan() {
		return lplan;
	}

	public void setLplan(String lplan) {
		this.lplan = lplan;
	}

	public String getLhumor() {
		return lhumor;
	}

	public void setLhumor(String lhumor) {
		this.lhumor = lhumor;
	}

	public String getLalacrity() {
		return lalacrity;
	}

	public void setLalacrity(String lalacrity) {
		this.lalacrity = lalacrity;
	}

	public String getLsense() {
		return lsense;
	}

	public void setLsense(String lsense) {
		this.lsense = lsense;
	}

	public String getLextrovert() {
		return lextrovert;
	}

	public void setLextrovert(String lextrovert) {
		this.lextrovert = lextrovert;
	}

	public String getLstyle() {
		return lstyle;
	}

	public void setLstyle(String lstyle) {
		this.lstyle = lstyle;
	}

	@Override
	public String toString() {
		return "CustomerAllDetailDTO [seq=" + seq + ", id=" + id + ", name=" + name + ", nick=" + nick + ", image="
				+ image + ", grade=" + grade + ", age=" + age + ", ability=" + ability + ", height=" + height + ", job="
				+ job + ", introduce=" + introduce + ", cplan=" + cplan + ", chumor=" + chumor + ", calacrity="
				+ calacrity + ", csense=" + csense + ", cextrovert=" + cextrovert + ", cstyle=" + cstyle + ", lplan="
				+ lplan + ", lhumor=" + lhumor + ", lalacrity=" + lalacrity + ", lsense=" + lsense + ", lextrovert="
				+ lextrovert + ", lstyle=" + lstyle + ", bigarea=" + bigarea + ", smallarea=" + smallarea + ", content="
				+ content + ", managerName=" + managerName + ", managerImage=" + managerImage + "]";
	}

	

	
}

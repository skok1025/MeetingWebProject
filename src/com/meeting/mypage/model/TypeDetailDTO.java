package com.meeting.mypage.model;

/**
 * tblTypeDetail DTO
 * @author 김석현
 *
 */
public class TypeDetailDTO {
	private String seq;
	private int age;
	private String ability;
	private int maxHeight;
	private int minHeight;
	private String job;
	private String plan;
	private int humor;
	private int alacrity;
	private int sense;
	private int extrovert;
	private int style;
	private String saseq;
	private String cseq;
	private String pseq;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
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
	public String getSaseq() {
		return saseq;
	}
	public void setSaseq(String saseq) {
		this.saseq = saseq;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	@Override
	public String toString() {
		return "TypeDetailDTO [seq=" + seq + ", age=" + age + ", ability=" + ability + ", maxHeight=" + maxHeight
				+ ", minHeight=" + minHeight + ", job=" + job + ", plan=" + plan + ", humor=" + humor + ", alacrity="
				+ alacrity + ", sense=" + sense + ", extrovert=" + extrovert + ", style=" + style + ", saseq=" + saseq
				+ ", cseq=" + cseq + ", pseq=" + pseq + "]";
	}
	
	
	
}

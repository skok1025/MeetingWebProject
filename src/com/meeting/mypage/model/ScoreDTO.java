package com.meeting.mypage.model;

public class ScoreDTO {
	private int plan;
	private int humor;
	private int alacrity;
	private int sense;
	private int extrovert;
	private int style;
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
	@Override
	public String toString() {
		return "ScoreDTO [plan=" + plan + ", humor=" + humor + ", alacrity=" + alacrity + ", sense=" + sense
				+ ", extrovert=" + extrovert + ", style=" + style + "]";
	}
	
	

}

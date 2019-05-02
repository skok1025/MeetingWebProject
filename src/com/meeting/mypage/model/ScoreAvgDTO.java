package com.meeting.mypage.model;

public class ScoreAvgDTO {
	private double plan;
	private double humor;
	private double alacrity;
	private double sense;
	private double extrovert;
	private double style;
	public double getPlan() {
		return plan;
	}
	public void setPlan(double plan) {
		this.plan = plan;
	}
	public double getHumor() {
		return humor;
	}
	public void setHumor(double humor) {
		this.humor = humor;
	}
	public double getAlacrity() {
		return alacrity;
	}
	public void setAlacrity(double alacrity) {
		this.alacrity = alacrity;
	}
	public double getSense() {
		return sense;
	}
	public void setSense(double sense) {
		this.sense = sense;
	}
	public double getExtrovert() {
		return extrovert;
	}
	public void setExtrovert(double extrovert) {
		this.extrovert = extrovert;
	}
	public double getStyle() {
		return style;
	}
	public void setStyle(double style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "ScoreAvgDTO [plan=" + plan + ", humor=" + humor + ", alacrity=" + alacrity + ", sense=" + sense
				+ ", extrovert=" + extrovert + ", style=" + style + "]";
	}
	
	
}

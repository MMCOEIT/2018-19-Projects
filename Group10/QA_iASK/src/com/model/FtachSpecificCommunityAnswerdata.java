package com.model;

public class FtachSpecificCommunityAnswerdata {
	String qestion, answer, expertname;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExpertname() {
		return expertname;
	}
	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}
	public String getQestion() {
		return qestion;
	}
	
	public void setQestion(String qestion) {
		this.qestion = qestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	int aid;
}

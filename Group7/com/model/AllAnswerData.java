package com.model;

import java.util.List;

public class AllAnswerData {

	int id;
	String qestion, answer, expertname;
	public String getExpertname() {
		return expertname;
	}
	public void setExpertname(String expertname) {
		this.expertname = expertname;
	}
	int aid	;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}

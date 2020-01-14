package com.model;

public class ratingadd {
	int answerid;
	
	String expertrname;
	
	public String getExpertrname() {
		return expertrname;
	}
	public void setExpertrname(String expertrname) {
		this.expertrname = expertrname;
	}
	public int getAnswerid() {
		return answerid;
	}
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	int qestionid;
	public int getQestionid() {
		return qestionid;
	}
	public void setQestionid(int qestionid) {
		this.qestionid = qestionid;
	}
	
	String username;
	int rating;
	String qestion, answer;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}

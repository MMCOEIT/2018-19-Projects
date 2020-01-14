package com.bean;

public class ReviewsBean {
	
	private String userEmail,locationid,rating,review,bayesResult,bayesProb;
private int userId;
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getBayesResult() {
		return bayesResult;
	}

	public void setBayesResult(String bayesResult) {
		this.bayesResult = bayesResult;
	}

	public String getBayesProb() {
		return bayesProb;
	}

	public void setBayesProb(String bayesProb) {
		this.bayesProb = bayesProb;
	}
	
	

}

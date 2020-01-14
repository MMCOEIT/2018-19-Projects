package com.project.beans;

import java.io.Serializable;

public class UserBeans implements Serializable {

	//id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
	
	
	
	int id,user_time;

	

	

	String user_name, user_email, user_password, user_contact_number, user_otp,user_new_password,user_Category,user_address;

	public int getId() {
		return id;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_time() {
		return user_time;
	}

	public String getUser_new_password() {
		return user_new_password;
	}

	public void setUser_new_password(String user_new_password) {
		this.user_new_password = user_new_password;
	}

	public void setUser_time(int user_time) {
		this.user_time = user_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_Category() {
		return user_Category;
	}

	public void setUser_Category(String user_Category) {
		this.user_Category = user_Category;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_contact_number() {
		return user_contact_number;
	}

	public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
	}

	public String getUser_otp() {
		return user_otp;
	}

	public void setUser_otp(String user_otp) {
		this.user_otp = user_otp;
	}
	
	
	
}

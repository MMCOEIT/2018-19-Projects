package com.project.beans;

import java.io.Serializable;

public class AdminBeans  implements Serializable{
	
	//id, admin_name, admin_password
	
	//id, admin_name, admin_password
	
	
	int id;
	
	String admin_name, admin_password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	

}

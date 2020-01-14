package com.project.beans;

import java.io.Serializable;

public class UserSearchBookBeans implements Serializable {
	
	// user_top_k_value,user_category, table_name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int user_top_k_value;
	
	String user_category,table_name,user_paramertre,user_Algorithms;

	public String getUser_paramertre() {
		return user_paramertre;
	}

	public String getUser_Algorithms() {
		return user_Algorithms;
	}

	public void setUser_Algorithms(String user_Algorithms) {
		this.user_Algorithms = user_Algorithms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUser_paramertre(String user_paramertre) {
		this.user_paramertre = user_paramertre;
	}

	public int getUser_top_k_value() {
		return user_top_k_value;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public void setUser_top_k_value(int user_top_k_value) {
		this.user_top_k_value = user_top_k_value;
	}

	public String getUser_category() {
		return user_category;
	}

	public void setUser_category(String user_category) {
		this.user_category = user_category;
	}
	
	

}

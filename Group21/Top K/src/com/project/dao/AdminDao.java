package com.project.dao;

import java.sql.ResultSet;

import com.project.beans.AdminBeans;

public interface AdminDao  {

	// Admin 
	
	ResultSet adminLogin(AdminBeans adminBeans);
	
	ResultSet adminSelectBookCategory();
	
	ResultSet adminGetResult();
	
	ResultSet adminCheckRecords();
	
	int adminTruncateTable();
	
	int adminInsertRecords(long tkoTime,long tkuTime,long tkoWithTkuTime);
	
	ResultSet adminGetResultTKU();
	
	ResultSet adminGetResultmain();
	
}

package com.project.dao;

import java.sql.ResultSet;

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.beans.UserSearchBookBeans;

public interface BookDao {

	ResultSet getBookInfromation(BookBeans bookBeans);
	
	int bookInsertUpgrowth(BookBeans bookBeans,String tableName);
	
	ResultSet bookCheckUpgrowth(BookBeans bookBeans,String tableName);
	
	int bookUpGrowthCount(BookBeans bookBeans,int count,String tableName);
	
	int bookUpGrowthCountBuy(BookBeans bookBeans,int count,String tableName);
	
	int bookInsertUpGrowthBuy(BookBeans bookBeans,String tableName);
	
	ResultSet bookGetRecordFromSearching(UserSearchBookBeans userSearchBookBeans);
	
   int bookSearchRecordInsert(UserBeans userBeans,UserSearchBookBeans userSearchBookBeans);
   
   ResultSet bookInfomationGet(String bookName,String bookCategory);
   
	
	
}

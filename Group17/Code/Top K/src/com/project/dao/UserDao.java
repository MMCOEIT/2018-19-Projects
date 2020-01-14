package com.project.dao;

import java.sql.ResultSet;

import org.apache.catalina.User;

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.beans.UserSearchBookBeans;

public interface UserDao {

	ResultSet isAlreadyRegister(UserBeans userBeans);
	
	int userRegistration(UserBeans userBeans);
	
	ResultSet userLoginCheck(UserBeans userBeans);
	
	int userUpdateUserTime(UserBeans userBeans);
	
	ResultSet userLoginCheckWithOtp(UserBeans userBeans);
	
	ResultSet userSelectBookCategory();
	
	int userChangesPassword(UserBeans userBeans);
	
	ResultSet userGetBookInfomation(UserBeans userBeans);
	
	int userInsertViewBook(BookBeans bookBeans,UserBeans userBeans,int userHitBook);
	
    ResultSet userCheckAddToCard(UserBeans userBeans,BookBeans bookBeans);
    
    int userInsertAddToCard(UserBeans userBeans,BookBeans bookBeans);
    
    int userCalculatedCountBooksInCard(UserBeans userBeans);
    
    int userGetlastCount();
    
    ResultSet userGetInfomation(int max_id);

    ResultSet userCheckBookViewDetails(UserBeans userBeans,BookBeans bookBeans);
    
    int userChangestheViewCount(BookBeans bookBeans,UserBeans userBeans,int userHitBook);
    
    int userGetlastCountView();
    
    ResultSet usergetViewDeatislBooks(int max_id,UserBeans userBeans);
    
    ResultSet userBuyBooks(UserBeans userBeans,BookBeans bookBeans);
    
    int userBuyBooksInsert(UserBeans userBeans,BookBeans bookBeans,int userBuyBooksCount);
    
    int userUpdateBookBuyFormat(UserBeans userBeans,BookBeans bookBeans,int userFinalBuyCount);
    
	int userInsertOrderPlaced(UserBeans userBeans,BookBeans bookBeans);
	
	ResultSet userViewProfile(UserBeans userBeans);
	
	ResultSet userCheckHitCount(BookBeans bookBeans);
	
	int userInsertHitCount(BookBeans bookBeans);
	
	int userUpdateHitCount(BookBeans bookBeans,int userHitCountFinal);
	
	int userInsertBuyCount(BookBeans bookBeans);
	
	int userUpdateBuyCount(BookBeans bookBeans,int userBuyCountFinal);
	
    ResultSet userGetRecordsTable(UserSearchBookBeans userSearchBookBeans);
    
    ResultSet userGetRandamValues();
    
    int userInsertTkoResult(ResultSet rs,String finalResult,String columeName);
   
    ResultSet userCheckTKOResultTable(ResultSet rs,int columeIndex);
    
    int userDeleteTKOTablerecord(String userCategory);
    
    ResultSet userGetTKOValue(UserSearchBookBeans userSearchBookBeans);
    
    ResultSet userGetTKUValueHit(UserSearchBookBeans userSearchBookBeans);
    
   int userInsertGraphTable(int topk,long tkuTime,long tkoTime,long totalTime,String bookCategory);
    
    ResultSet userCheckREcommdationProcess(UserBeans userBeans);
    
    int userChangePassword(UserBeans userBeans);
    
    int userConatctUs(String userName,String userEmail,String userPhone,String userMsg);
    
    ResultSet userGetInfomationFinal(int productId);
    
    
    int userTkoResultGraph(String bookCategory,int topk,long tkoValue  );
    
    int userTKUResultGrpah(String bookCategory,int topk,long tkuValue );
    
	int userMainResult(String bookCategory,int topk,long MainValue);
	
	
	
	
}

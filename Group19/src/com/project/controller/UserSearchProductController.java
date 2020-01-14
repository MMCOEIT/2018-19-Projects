package com.project.controller;

import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Methods.TKO_Algorithms_MainMethods;
import com.project.Methods.UpGrowth;
import com.project.beans.UserBeans;
import com.project.beans.UserSearchBookBeans;
import com.project.dao.BookDao;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserSearchBookController
 */
@WebServlet("/UserSearchProductController")
public class UserSearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// object
		
		UserSearchBookBeans userSearchBookBeans=new UserSearchBookBeans();
		
		UserBeans userBeans=new UserBeans();
		
		String category="Category",tableResult=null,ColumeName=null,finalResult=null;
		
		String tableName=null;
		
		UpGrowth upGrowthObject=new UpGrowth();
		
		ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null;
		
		UserDao userDao=DaoFactory.getInstances();
		
		BookDao bookDao=DaoFactory.getInstancesBook();
		
		HttpSession session=request.getSession(),session2=request.getSession(),session3=request.getSession(),seesion3=request.getSession();
		
		HttpSession session1=request.getSession();
		
		HttpSession userSession=request.getSession();
		
		ArrayList<String> results = new ArrayList<String>();
	
	    Random randomGenerator = new Random();
	    
	    int ColumeIndex=0;
	    
		long timeTko=System.currentTimeMillis();
		
		System.out.println("tko Time is "+timeTko);
		
		session3.setAttribute("tkoTime1Session", timeTko);
		
		
		
		// user Session 
		
		userBeans=(UserBeans)userSession.getAttribute("userSessionInfomation");
		
		 long time1TKU=System.currentTimeMillis();
			
			System.out.println("time 1 of TKU"+time1TKU);
			
			HttpSession session4=request.getSession();
			
			session4.setAttribute("TKUTimeSession", time1TKU);	
		
		// logice 
		
		userSearchBookBeans.setUser_top_k_value(Integer.parseInt(request.getParameter("user_Top_k_value")));
		
		userSearchBookBeans.setUser_category(request.getParameter("user_book_category"));
		
		userSearchBookBeans.setUser_paramertre(request.getParameter("user_parametre"));
		
		userSearchBookBeans.setUser_Algorithms(request.getParameter("user_Algorithms"));
		
		System.out.println("parameter is ........................"+request.getParameter("user_parametre"));
		
		
		session3.setAttribute("userSearchInputForTKU",userSearchBookBeans);
		
		
		if(userSearchBookBeans.getUser_top_k_value()==0){
			
			System.out.println("Value of topk value is Zero");
			
			tableName=category+"_"+userSearchBookBeans.getUser_category();

			System.out.println("TableName is "+tableName);
			
			userSearchBookBeans.setTable_name(tableName);
			
			rs=upGrowthObject.table_exits(tableName);
			
			try {
				if(rs.next()){
					
					System.out.println("rs have some Value ");
					
					rs1=bookDao.bookGetRecordFromSearching(userSearchBookBeans);
					
				    session.setAttribute("topkSessionResult", rs1);
				    
				    session1.setAttribute("UserCategoryBooks", userSearchBookBeans);
				    
				    int n=bookDao.bookSearchRecordInsert(userBeans, userSearchBookBeans);
				    
				    if(n>0){
				    	
				    	
				    	
				    	
				    	RequestDispatcher rd=request.getRequestDispatcher("userTopkResult.jsp");
						    
						rd.forward(request, response);
						    
				    }
				    
				    
				  
					
				}
				
				// top value is not zero then code is writer here 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		else
		{
			System.out.println("Not zero topk value ");
			
			System.out.println("Top k Value is "+userSearchBookBeans.getUser_top_k_value());
			
			System.out.println("user Category is "+userSearchBookBeans.getUser_category());
			
			rs2=userDao.userGetRandamValues();
			
			//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count, product_price
			
			try {
				System.out.println("rs2 row count is "+rs2.getRow());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				while(rs2.next()){
					
					results.add(rs2.getString(1));
					
				
			        
				
					
				}
				
				int index = randomGenerator.nextInt(results.size());
		         ColumeName = results.get(index);
		        
		        System.out.println("colume is "+ColumeName);
		        
		    	rs3=userDao.userGetRecordsTable(userSearchBookBeans);
		    	
		    	while(rs3.next()){
		    		
		    		System.out.println("ColumeName is rs 3 set  "+ColumeName);
		    		
		    		tableResult=rs3.getString(ColumeName);
		    		
		    		System.out.println("tableResult is "+tableResult);
		    		
		    		//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count, product_price
		    		
		    		System.out.println("result set value is 1 ...."+rs3.getInt(1));
		    		
		    		System.out.println("result set value is  2 ...."+rs3.getInt(2));
		    		
		    		System.out.println("result set value is 3 ...."+rs3.getString(3));
		    		
		    		System.out.println("result set value is  4 ...."+rs3.getString(4));
		    		
		    		System.out.println("result set value is 5  ...."+rs3.getString(5));
		    		
		    		System.out.println("result set value is 6 ...."+rs3.getInt(6));
		    		
		    		System.out.println("result set value is  7...."+rs3.getInt(7));
		    		
		    		System.out.println("result set value is 8 ...."+rs3.getString(8));
		    		
	               System.out.println("result set value is 9...."+rs3.getString(9));
	               
	               System.out.println("result set value is 10...."+rs3.getString(10));
	               
	               System.out.println("result set value is 11 ...."+rs3.getString(11));
		    		
	               System.out.println("result set value is 12 ...."+rs3.getString(12));
	               
		    		TKO_Algorithms_MainMethods TKOAlgorithmsMainObject=new TKO_Algorithms_MainMethods();  // call the main Methods 
			    	
			    	finalResult=TKOAlgorithmsMainObject.RunMethods(tableResult);
			    	
			    	System.out.println("Colume Name is "+ColumeName);
			    				    	
			    	System.out.println("in User Search Controller 1111111.........");
			    	
			    	int n=userDao.userInsertTkoResult(rs3, finalResult, ColumeName);
			    	
			    	System.out.println("in User Search Controller 2222222222222.........");
			    	
				    System.out.println("Value of n is ..... "+n);
				    
				    	    	
			    	    	
			    		
		    	}
		    	
		    	
		    	//id, user_id, user_email, user_name, book_category, top_k_value, table_name
		    	
		    	session2.setAttribute("userSearchBookBeansSession", userSearchBookBeans);
		    	
		    	if(userSearchBookBeans.getUser_Algorithms().equalsIgnoreCase("TKO")){
		    		
		    		
		    		long timeTko1=System.currentTimeMillis();
			    	
		    		
		    		RequestDispatcher rd=request.getRequestDispatcher("TkuImplementationAlgorithmResutlController");
					 rd.forward(request, response);
		    	}
		    	
		    	
		    	else
		    	{
		    		
		    		if(userSearchBookBeans.getUser_Algorithms().equalsIgnoreCase("TKU"))
		    			
		    		{
		    			
		    			RequestDispatcher rd=request.getRequestDispatcher("TkuImplementationAlgorithmTKUResutlController");
						 rd.forward(request, response);
		    			
		    		}
		    		
		    		else
		    		{
		    			System.out.println("Main Algorithms ");
		    			
		    			RequestDispatcher rd=request.getRequestDispatcher("TkuImplementationAlgorithmMainResutlController");
						 rd.forward(request, response);
		    			
		    		}
		    		
		    	}
		    	
		    	
		    	
		    	/*  RequestDispatcher rd=request.getRequestDispatcher("TkuImplementationAlgorithmController");
				   rd.forward(request, response);*/
		    	
		    	
		    	/* RequestDispatcher rd=request.getRequestDispatcher("CheckAlgorithmResultController");
				   rd.forward(request, response);*/
		    	
		    
		    	
		    	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}

}

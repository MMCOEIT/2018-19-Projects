package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.project.Methods.UpGrowthAlgorithms;
import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.dao.BookDao;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserBooksOrderController
 */
@WebServlet("/UserProductOrderController")
public class UserProductOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductOrderController() {
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
		
		// object and varible 
		
				
		System.out.println("User Book Order Controller pages 222222222222222222222");
		
		
		System.out.println("User Book Order Controller pages 44444444444444444444444444444444444 ");
		
		
		UserBeans userBeans=new UserBeans();
		
		BookBeans bookBeans=new BookBeans();
		
		BookDao bookDao=DaoFactory.getInstancesBook();
		
		ResultSet rs=null,rs1=null,rs4=null;
		
		UserDao userDoa=DaoFactory.getInstances();
		
		int userBuyCount=1;
		
		String bookprice=null;
		
		String category="category";
		
		String tableName=null;
		
		int book_buy_count=0;
		
		int userTotalBuyCount=0,userTotalBuyCountFinal=0;
		
		HashSet<String> hashSet=new HashSet<String>();   // hash set object
		
						
				
		/*// logice 
		
		HashSet<String> hashSet=new HashSet<String>();   // hash set object
		
		userBeans.setId(Integer.parseInt(request.getParameter("userId")));
		
		bookBeans.setBook_id(Integer.parseInt(request.getParameter("bookId")));
		
		bookBeans.setBrand_name(request.getParameter("bookCategory"));
		
			
		HttpSession session1=request.getSession();
		
		session1.setAttribute("bookBeansSession",bookBeans);*/
		
		HttpSession session1=request.getSession();
		
		bookBeans=(BookBeans)session1.getAttribute("bookBeansSession");
		
		UpGrowthAlgorithms upGrowthAlgorithms=new UpGrowthAlgorithms();
		
		
	// logice
		
		userBeans.setUser_name(request.getParameter("userName"));
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_address(request.getParameter("userAddress"));
		
		// how to get the book Id 
		
		
		HttpSession session2=request.getSession();
		
		bookBeans=(BookBeans)session2.getAttribute("bookBeansSession");
		
		int bookId=bookBeans.getBook_id();
		
		System.out.println("Book Id is "+bookId);
		
		
		// user session 
		
		HttpSession session=request.getSession();
		
		userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
		
		// get the Session of Book Id 
		
		rs=bookDao.getBookInfromation(bookBeans);
		
		try {
			while(rs.next()){
				
//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
				
				bookBeans.setBook_id(rs.getInt(1));
				
				bookBeans.setBrand_name(rs.getString(2));
				
			    bookBeans.setProduct_name(rs.getString(3));
			   
			    bookBeans.setSKU(rs.getString(4));
			    
			    bookBeans.setSRP(rs.getString(5));
			    
			    bookBeans.setGross_weirth(rs.getString(6));
			    
			    bookBeans.setNet_weigth(rs.getString(7));
			    
			    bookBeans.setRecylared(rs.getString(8));
			    
			    bookBeans.setLow_fat(rs.getString(9));
			    
			    bookBeans.setUnits_pre(rs.getString(10));
			    
			    bookBeans.setCase_pre(rs.getString(11));
			    
			    bookBeans.setShelf_heigth(rs.getString(12));
			    
			    bookBeans.setShelf_width(rs.getString(13));
			    
			    bookBeans.setShelf_depth(rs.getString(14));
			    
			    bookBeans.setProduct_price(rs.getString(15));
				System.out.println("In rs values are ");
				
				
                   bookprice=rs.getString(15);
				
				HttpSession session3=request.getSession();
				
				session3.setAttribute("bookPricesSession", bookprice);
				
				
			}
			
			

			System.out.println("book Id is order placed contrroller "+ bookBeans.getBook_id());
			
			
			
			System.out.println("Product Name  placed contrroller is "+ bookBeans.getProduct_name());
			
		
			
			System.out.println("book title order placed contrroller is "+ bookBeans.getRecylared());
			
		
			
			System.out.println("Product Book Id  order placed contrroller is "+ bookBeans.getBook_id());
			
			rs1=userDoa.userBuyBooks(userBeans, bookBeans);
			
			if(rs1.next()){
				
				//id, user_id, user_name, user_email, book_id, product_name, product_Brands, product_SKU, product_SPR, gross_weigth, net_weight, recyclable_package, low_fat, units_pre_case, cases_pre_pallet, shelf_width, shelf_heigth, shelf_depth, user_hit_count
				System.out.println("Value is not null");
				
				userBuyCount=rs1.getInt(18);
				
				System.out.println("user but count is "+userBuyCount);
				
				userBuyCount+=userBuyCount;
				
				System.out.println("user but count is Table ................. "+userBuyCount);
				
				int up=userDoa.userUpdateBookBuyFormat(userBeans, bookBeans, userBuyCount);
				
				System.out.println("Value of up is"+up);
				
				
				
				
				
				
				// up growth implementation 
				
				tableName=category+"_"+bookBeans.getBrand_name();
				
				System.out.println("table name is "+tableName);
				
				
				
				// Hash Set
				
                 HttpSession session6=request.getSession();
				
				hashSet=(HashSet<String>)session6.getAttribute("AllCategorySession");
				
				
                int result=upGrowthAlgorithms.UpGrowthMethods(bookBeans.getBrand_name(), hashSet);
				
				System.out.println("result is "+result);
				
				
                System.out.println("result is "+result);
				
				System.out.println("table found and insert into table in user book order Controller ");
				
				System.out.println("Value of table name is "+tableName);
				
				System.out.println("table Name is if part is "+tableName);
				
				rs1=bookDao.bookCheckUpgrowth(bookBeans, tableName);
				
				if(rs1.next()){
				
					System.out.println("User Book Order controller condition 11111111111111111111111");

					System.out.println("rs1 has not null value");
					
					book_buy_count=rs1.getInt(17);
																	
					System.out.println("book buy cout is "+book_buy_count);
					
					book_buy_count=book_buy_count+1;
					
					System.out.println("book court is "+book_buy_count);
					
					int t1=bookDao.bookUpGrowthCountBuy(bookBeans, book_buy_count, tableName);
					
					System.out.println("value of t1 is "+t1);
					
					System.out.println("Table Name is User Book Order controller ..................");
					
					
					HttpSession sessionTableName=request.getSession();
					sessionTableName.setAttribute("tableNameSessionFinal", tableName);
					
					System.out.println("In User Book order Controller while used In Buy Count 1111111111111111111111111111111 ");
					
					rs4=userDoa.userCheckHitCount(bookBeans);
					
					if(rs4.next())
					{
						System.out.println("rs value have not null ");
						
						//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
						
						userTotalBuyCount=rs4.getInt(7);
						
						System.out.println("userTotalHitCount value is "+userTotalBuyCount);
						
						userTotalBuyCountFinal=userTotalBuyCount+1;
						
						System.out.println("userTotalHitCountFinal value is "+userTotalBuyCountFinal);
						
	                    int up1=userDoa.userUpdateBuyCount(bookBeans, userTotalBuyCountFinal); 
						
						System.out.println("Value of up is ........"+up1);
						
						
					}
					
					else
					{
						System.out.println("Nahi hai Impossible condition insert 111111111111111111111111111111 ");
						
						int m1=userDoa.userInsertBuyCount(bookBeans);
						
						System.out.println("Value of m is "+m1);
						
						request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
						
						RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
						rd.forward(request, response);
					}
					
				
					/*RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
					rd.forward(request, response);*/
					
				/*	RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);*/
					
					/*RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);*/
					
				}
				
				else
				{
					System.out.println("User Book Order controller condition  else parts 11111111111111111111111");
					
                   System.out.println("insert into up growth upare wala rs1 condition true..........");
					
					int r=bookDao.bookInsertUpgrowth(bookBeans, tableName);
					
					System.out.println("r values of r "+r);
					
					
					HttpSession sessionTableName=request.getSession();
					sessionTableName.setAttribute("tableNameSessionFinal", tableName);
					
		        System.out.println("In User Book order Controller while used In Buy Count 2222222222222222222222222222222");
					
					rs4=userDoa.userCheckHitCount(bookBeans);
					
					if(rs4.next())
					{
						System.out.println("rs value have not null ");
						
						//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
						
						userTotalBuyCount=rs4.getInt(7);
						
						System.out.println("userTotalHitCount value is "+userTotalBuyCount);
						
						userTotalBuyCountFinal=userTotalBuyCount+1;
						
						System.out.println("userTotalHitCountFinal value is "+userTotalBuyCountFinal);
						
						int up1=userDoa.userUpdateBuyCount(bookBeans, userTotalBuyCountFinal); 
						
						System.out.println("Value of up is ........"+up1);
						
						request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
						/*RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
						rd.forward(request, response);*/
						
						RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
						rd.forward(request, response);
						
						
						
					}
					
					else
					{
						System.out.println("Nahi hai Impossible condition insert 2222222222222222222222222222 ");
						
						int m1=userDoa.userInsertBuyCount(bookBeans);
						
						System.out.println("Value of m is "+m1);
						
						request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
						/*RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
						rd.forward(request, response);*/
						
						RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
						rd.forward(request, response);
						
					}
					
					
					/*request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
					RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
					rd.forward(request, response);
					
					RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);
					
					RequestDispatcher rd=request.getRequestDispatcher("userShowparticuleBooks.jsp");
					rd.forward(request, response);*/
					
					RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);
				}
				
				
								
				/*RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
				rd.forward(request, response);
				*/
				
				
			}
			
			else
			{
				int m=userDoa.userBuyBooksInsert(userBeans, bookBeans, userBuyCount);
				
				System.out.println("Value of m is "+m);
				
				bookprice=bookBeans.getBrand_name();
				
                HttpSession session3=request.getSession();
				
				session3.setAttribute("bookPricesSession", bookprice);
				
				
             // up growth implementation 
				
				System.out.println("In else part of user Book Order Controller ..................");
				
				tableName=category+"_"+bookBeans.getBrand_name();
				
				System.out.println("table name is "+tableName);
				
				
				
				
				// Hash Set
				
                 HttpSession session6=request.getSession();
				
				hashSet=(HashSet<String>)session6.getAttribute("AllCategorySession");
				
				
                int result=upGrowthAlgorithms.UpGrowthMethods(bookBeans.getBrand_name(), hashSet);
				
				System.out.println("result is "+result);
				
				System.out.println("table found and insert into table in User Book Order controller ");
				
				System.out.println("Value of table name is "+tableName);
				
				rs1=bookDao.bookCheckUpgrowth(bookBeans, tableName);
				
				if(rs1.next()){
				

					System.out.println("rs1 has not null value");
					
					book_buy_count=rs1.getInt(17);
																	
					System.out.println("book buy cout is "+book_buy_count);
					
					book_buy_count=book_buy_count+1;
					
					System.out.println("book court is "+book_buy_count);
					
					int t1=bookDao.bookUpGrowthCountBuy(bookBeans, book_buy_count, tableName);
					
					System.out.println("value of t1 is "+t1);
					
					System.out.println("Table Name is user book order controller ..................");
					
					
					HttpSession sessionTableName=request.getSession();
					sessionTableName.setAttribute("tableNameSessionFinal", tableName);
					
		       System.out.println("In User Book order Controller while used In Buy Count 333333333333333333333333333 ");
					
					rs4=userDoa.userCheckHitCount(bookBeans);
					
					if(rs4.next())
					{
						System.out.println("rs value have not null ");
						
						//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
						
						userTotalBuyCount=rs4.getInt(7);
						
						System.out.println("userTotalHitCount value is "+userTotalBuyCount);
						
						userTotalBuyCountFinal=userTotalBuyCount+1;
						
						System.out.println("userTotalHitCountFinal value is "+userTotalBuyCountFinal);
						
						int up1=userDoa.userUpdateBuyCount(bookBeans, userTotalBuyCountFinal); 
						
						System.out.println("Value of up is ........"+up1);
						
						
					}
					
					else
					{
						System.out.println("Nahi hai Impossible condition insert 3333333333333333333  ");
						
						int m1=userDoa.userInsertBuyCount(bookBeans);
						
						System.out.println("Value of m is "+m1);
					}
					
					
				/*	RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
					rd.forward(request, response);*/
					
					/*RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);*/
					
					request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
					
					RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);
					
				}
				
				
				else
				{
                     
					
					System.out.println("insert into up growth..........");
					
					int r=bookDao.bookInsertUpgrowth(bookBeans, tableName);
					
					System.out.println("r values of r "+r);
					
					
					HttpSession sessionTableName=request.getSession();
					sessionTableName.setAttribute("tableNameSessionFinal", tableName);
					
					
		System.out.println("In User Book order Controller while used In Buy Count  4444444444444444444444444");
					
					rs4=userDoa.userCheckHitCount(bookBeans);
					
					if(rs4.next())
					{
						System.out.println("rs value have not null ");
						
						//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
						
						userTotalBuyCount=rs4.getInt(7);
						
						System.out.println("userTotalHitCount value is "+userTotalBuyCount);
						
						userTotalBuyCountFinal=userTotalBuyCount+1;
						
						System.out.println("userTotalHitCountFinal value is "+userTotalBuyCountFinal);
						
						int up1=userDoa.userUpdateBuyCount(bookBeans, userTotalBuyCountFinal); 
						
						System.out.println("Value of up is ........"+up1);
						
						
					}
					
					else
					{
						System.out.println("Nahi hai Impossible condition insert 444444444444444 ");
						
						int m1=userDoa.userInsertBuyCount(bookBeans);
						
						System.out.println("Value of m is "+m1);
					}
					
					
					/*RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
					rd.forward(request, response);*/
					
					/*RequestDispatcher rd=request.getRequestDispatcher("userShowparticuleBooks.jsp");
					rd.forward(request, response);*/
					
					request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
					
					
					RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);
				}
				
				
				/*
				RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
				rd.forward(request, response);*/
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		
	}

}

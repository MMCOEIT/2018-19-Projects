package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Methods.UpGrowth;
import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.dao.BookDao;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class OrderPlacedBookController
 */
@WebServlet("/OrderPlacedProductController")
public class OrderPlacedProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlacedProductController() {
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
		
		System.out.println("Order placed book controller 333333333333333333333333333");
		
		UserBeans userBeans=new UserBeans();
		
		UserDao dao=DaoFactory.getInstances();
		
		BookBeans bookBeans=new BookBeans();
		
		BookDao bookDao=DaoFactory.getInstancesBook();
		
		ResultSet rs=null,rs1=null;
		
		UpGrowth upGrowth=new UpGrowth();
		
		String category="Category";
		
		int book_buy_count=0;
		
		int book_buy_count_final=0;
		
		String tableName=null;
		
	  
					
		// logice
		
		userBeans.setUser_name(request.getParameter("userName"));
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_address(request.getParameter("userAddress"));
		
		// how to get the book Id 
		
		
		HttpSession session1=request.getSession();
		
		bookBeans=(BookBeans)session1.getAttribute("bookBeansSession");
		
		int bookId=bookBeans.getBook_id();
		
		System.out.println("Book Id is "+bookId);
		
		rs=bookDao.getBookInfromation(bookBeans);
		
		System.out.println("order Placed Book Controller....................................");
		

			try {
				while(rs.next()){ 
					
				// book_title, book_category, book_author, book_price, id

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
				System.out.println("In rs values are ");
				}//
				HttpSession session2=request.getSession();
				
				bookBeans=(BookBeans)session2.getAttribute("bookBeansSession");
				
				System.out.println("Session for table name is ");
				
				HttpSession tableNameSession=request.getSession();
				
				tableName=(String)tableNameSession.getAttribute("tableNameSessionFinal");
				
				System.out.println("table Name in order Placed controller  "+tableName);
				
				System.out.println("Call hogyiiiiii");
				
				//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
							
				System.out.println("book Id is order placed contrroller "+ bookBeans.getBook_id());	
			
				System.out.println("book Authore order placed contrroller is "+ bookBeans.getBrand_name());
				
				System.out.println("book title order placed contrroller is "+ bookBeans.getProduct_name());	
						
				System.out.println("book Category order placed contrroller is "+ bookBeans.getCase_pre());
				
				rs1=bookDao.bookCheckUpgrowth(bookBeans, tableName);
				
				if(rs1.next()){
					
					//id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
					
					
					//id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit, product_Buy
									
					System.out.println("rs1 has not null value");
					
					book_buy_count=rs1.getInt(17);
					
					System.out.println("Value in Order Placed Controller is "+rs1.getInt(6));
					
					System.out.println("Value in Order Placed Controller is "+rs1.getInt(17));
																	
					System.out.println("book buy cout is table wala  "+book_buy_count);
					
					book_buy_count_final=book_buy_count+1;
					
					System.out.println("book_buy_count_final  is final for updating "+book_buy_count);
					
				/*	int t1=bookDao.bookUpGrowthCountBuy(bookBeans, book_buy_count, tableName);*/
					
					/*System.out.println("value of t1 is "+t1);*/
					
					System.out.println("Table Name is order placed Controller..................");
					
					request.setAttribute("succesMsg", "Thanks! your Order Placed successfully");
					
					RequestDispatcher rd=request.getRequestDispatcher("orderSucessfulyPlaced.jsp");
					rd.forward(request, response);
					
				
				} 
				
				else
				{
					System.out.println("insert are not allowed");
					
				}
				
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

}

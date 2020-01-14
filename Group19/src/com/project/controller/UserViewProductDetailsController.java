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

import com.project.Methods.UpGrowth;
import com.project.Methods.UpGrowthAlgorithms;
import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.dao.BookDao;
import com.project.dao.BookDaoImpl;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserViewBookDetailsController
 */
@WebServlet("/UserViewProductDetailsController")
public class UserViewProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewProductDetailsController() {
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
		
		System.out.println("in controller User view Details controller ");
		
		// objects 
		
		System.out.println("In view Book Details controller 9999999999999999999999999999999999");
		
		UserBeans userBeans=new UserBeans();
		
		BookBeans bookBeans=new BookBeans();
		
		UserDao dao=DaoFactory.getInstances();
		
		BookDao dao1=DaoFactory.getInstancesBook();
		
		ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null;
		
		int userHitBooks=1;
		
		int userHitBookFinal=0;
					
		String bookCategory=null;
		
		String tableName=null;
		
		String category="category";
		
		int book_hit_count=0;
		
		int userTotalHitCount=0,userTotalHitCountFinal=0;
					
		HashSet<String> hashSet=new HashSet<String>();   // hash set object
		
		UpGrowthAlgorithms upGrowthAlgorithms=new UpGrowthAlgorithms();
		
		// logice
		
		bookBeans.setBook_id(Integer.parseInt(request.getParameter("ProductId")));
		
		// user session 
		
		HttpSession session=request.getSession();
		
		userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
		
		System.out.println("userId is "+userBeans.getId());
		
		System.out.println("username is "+userBeans.getUser_name());
		
		System.out.println("userEmail is "+userBeans.getUser_email());
		
		rs=dao1.getBookInfromation(bookBeans);
		
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
				
				System.out.println("In view Book Details controller 1111111111111111111111111111");
							
			}
			
			HttpSession session1=request.getSession();
			
			session1.setAttribute("bookBeansSession",bookBeans );
			
			
			
			rs1=dao.userCheckBookViewDetails(userBeans, bookBeans);
			
			if(rs1.next()){
				
				System.out.println("rs value is not null");
				
				userHitBookFinal=rs1.getInt(10);
				
				System.out.println("User Hit books are in table  "+userHitBookFinal);
				
				userHitBookFinal+=userHitBookFinal;
				
				System.out.println("User Hit books are in final  "+userHitBookFinal);
				
				int m1=dao.userChangestheViewCount(bookBeans, userBeans, userHitBookFinal);
				
				System.out.println("Value of m is "+m1);
				
			/*	int last=dao.userGetlastCountView();*/
				
				System.out.println("In view Book Details controller 22222222222222222222222222");
				
				rs2=dao.usergetViewDeatislBooks(bookBeans.getBook_id(),userBeans);
				
				
				
				HttpSession session2=request.getSession();
				
				session2.setAttribute("usershowBookViewSession",rs2);
				
				
				// up growth implementation 
				
				bookCategory=bookBeans.getBrand_name();
				
				System.out.println("category is "+bookCategory);
				
				tableName=category+"_"+bookCategory;
				
				System.out.println("table Name is "+tableName);
				
				bookBeans.setTablename(tableName);
				
				
				System.out.println("In view Book Details controller 333333333333333333333333");
				
				// get the session of table 
				
				HttpSession tableNameSession=request.getSession();
				
				tableName=(String)tableNameSession.getAttribute("bookTableNameSession");
				
				System.out.println("table Name is "+tableName);
				
								
				HttpSession session3=request.getSession();
				
				hashSet=(HashSet<String>)session3.getAttribute("AllCategorySession");
				
				int result=upGrowthAlgorithms.UpGrowthMethods(bookCategory, hashSet);
				
				System.out.println("result is "+result);
				
				System.out.println("In view Book Details controller 4444444444444444444444444444444");
				
				HttpSession session4=request.getSession();
				
				session4.setAttribute("resultValueSession", result);
				
				HttpSession session5=request.getSession();
				
				session5.setAttribute("bookBeansSession",bookBeans);
				
				System.out.println("In If parts ");
				
				rs4=dao.userCheckHitCount(bookBeans);
				
				if(rs4.next())
				{
					
					System.out.println("In view Book Details controller 555555555555555555555555555555555555555");
			
					System.out.println("rs value have not null ");
					
					//id, book_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, user_hit_count, user_buy_count
					
					userTotalHitCount=rs4.getInt(16);
					
					System.out.println("userTotalHitCount value is "+userTotalHitCount);
					
					userTotalHitCountFinal=userTotalHitCount+1;
					
					System.out.println("userTotalHitCountFinal value is "+userTotalHitCountFinal);
					
                    int up=dao.userUpdateHitCount(bookBeans, userTotalHitCountFinal); 
					
					System.out.println("Value of up is ........"+up);
					
					
				}
				
				else
				{
					System.out.println("In view Book Details controller 6666666666666666666666");
					
					int m=dao.userInsertHitCount(bookBeans);  // book Details 
					
					System.out.println("Value of m is "+m);
				}
				
				System.out.println("In view Book Details controller 77777777777777777777777777");
								
				RequestDispatcher rd=request.getRequestDispatcher("UpGrowthImplemenationController");
				rd.forward(request, response);
				
				
				
				
				
				
				
				// end of up gowth 
				
				
				
									
				
				
				
							
				
			}
			
			else
			{
				System.out.println("In view Book Details controller 888888888888888888888888888888888888888888888");
				
				int m=dao.userInsertViewBook(bookBeans,userBeans,userHitBooks);
				
				System.out.println("Value of m is m"+m);
				
                /* int last=dao.userGetlastCountView();*/
				
				rs2=dao.usergetViewDeatislBooks(bookBeans.getBook_id(),userBeans); 
				
				HttpSession session2=request.getSession();
				
				session2.setAttribute("usershowBookViewSession",rs2);
				
				// up growth implemenatation 
				
				System.out.println("In view Book Details controller 9999999999999999999999999999");
				
				bookCategory=bookBeans.getBrand_name();
				
				System.out.println("category is "+bookCategory);
				
				tableName=category+"_"+bookCategory;
				
				System.out.println("table Name is "+tableName);
				
				bookBeans.setTablename(tableName);
				
				HttpSession session3=request.getSession();
				
				hashSet=(HashSet<String>)session3.getAttribute("AllCategorySession");
				
				int result=upGrowthAlgorithms.UpGrowthMethods(bookCategory, hashSet);
				
				System.out.println("result is "+result);
				
		        HttpSession session4=request.getSession();
				
				session4.setAttribute("resultValueSession", result);
				
               HttpSession session5=request.getSession();
				
				session5.setAttribute("bookBeansSession",bookBeans);
				
				System.out.println("In Else Parts  ");
				
               rs4=dao.userCheckHitCount(bookBeans);
               
               System.out.println("In view Book Details controller 10000000000000000000000000000000000000000");
				
				if(rs4.next())
				{
					System.out.println("rs value have not null ");
					
					//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
					
					userTotalHitCount=rs4.getInt(16);
					
					System.out.println("userTotalHitCount value is "+userTotalHitCount);
					
					userTotalHitCountFinal=userTotalHitCount+1;
					
					System.out.println("userTotalHitCountFinal value is "+userTotalHitCountFinal);
					
					int up=dao.userUpdateHitCount(bookBeans, userTotalHitCountFinal); 
					
					System.out.println("In view Book Details controller 11111111111111111111111111111111111111111");
					
					System.out.println("Value of up is ........"+up);
					
					
				}
				
				else
				{
					System.out.println("In view Book Details controller 1222222222222222222222222222222");
					
					int m1=dao.userInsertHitCount(bookBeans);
					
					System.out.println("Value of m is "+m1);
				}
				
						
				System.out.println("In view Book Details controller 133333333333333333333333333333333333333333333333333");
								
				RequestDispatcher rd=request.getRequestDispatcher("UpGrowthImplemenationController");
				rd.forward(request, response);
				
				// end of up gowth 
				
						
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}

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

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.dao.BookDao;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class BookAddToCardController
 */
@WebServlet("/BookAddToCardController")
public class BookAddToCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddToCardController() {
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
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// object and Varible 
		
		System.out.println("Book Add to Card Controller 555555555555555555555555555555");
		
		BookBeans bookBeans=new BookBeans();
		
		BookDao bookDao=DaoFactory.getInstancesBook();
		
		ResultSet rs1=null,rs2=null,rs3=null,rs4=null;
		
		UserDao userDao=DaoFactory.getInstances();
		
		int m=1;
		
		int lastRow=0;
		
		int count=0;
		
		int userTotalHitCount=0,userTotalHitCountFinal=0;
		
		
		
		// logice 
		
		System.out.println("book Id is "+request.getParameter("book_id"));
		
		bookBeans.setBook_id(Integer.parseInt(request.getParameter("book_id")));
		
		rs1=bookDao.getBookInfromation(bookBeans);
		
		try {
			while(rs1.next()){
				
				//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth
				
				bookBeans.setBook_id(rs1.getInt(1));
				
				bookBeans.setBrand_name(rs1.getString(2));
				
			    bookBeans.setProduct_name(rs1.getString(3));
			   
			    bookBeans.setSKU(rs1.getString(4));
			    
			    bookBeans.setSRP(rs1.getString(5));
			    
			    bookBeans.setGross_weirth(rs1.getString(6));
			    
			    bookBeans.setNet_weigth(rs1.getString(7));
			    
			    bookBeans.setRecylared(rs1.getString(8));
			    
			    bookBeans.setLow_fat(rs1.getString(9));
			    
			    bookBeans.setUnits_pre(rs1.getString(10));
			    
			    bookBeans.setCase_pre(rs1.getString(11));
			    
			    bookBeans.setShelf_heigth(rs1.getString(12));
			    
			    bookBeans.setShelf_width(rs1.getString(13));
			    
			    bookBeans.setShelf_depth(rs1.getString(14));
			    
			    bookBeans.setProduct_price(rs1.getString(15));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// user session 
		
		HttpSession session=request.getSession();

		UserBeans userBeans=(UserBeans)session.getAttribute("userSessionInfomation");

        rs2=userDao.userCheckAddToCard(userBeans, bookBeans);
        
        try {
			if(rs2.next()){
				
				System.out.println("rs2 is not null");
				
				count=userDao.userCalculatedCountBooksInCard(userBeans);
				
				System.out.println("Count is "+count);
				
				HttpSession session1=request.getSession();
				
				session1.setAttribute("userCountSessionInfomation",count);
				
				
				/*rs3=bookDao.getBookInfromation(bookBeans);*/
				
                /*lastRow=userDao.userGetlastCount();
				
				System.out.println("last row is count value is in rs2 value  "+lastRow);
				
					*/
				
	            rs3=userDao.userGetInfomation(bookBeans.getBook_id());
			
				HttpSession session12=request.getSession();
				
				session12.setAttribute("BooksSessionInfomation",rs3 );
				
				System.out.println("only increments in counts");
				
				
                rs4=userDao.userCheckHitCount(bookBeans);
                
                System.out.println("In Book Add to Card Section in If parts  ");
				
				if(rs4.next())
				{
					System.out.println("rs value have not null ");
					
					//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
					
					userTotalHitCount=rs4.getInt(6);
					
					System.out.println("userTotalHitCount value is "+userTotalHitCount);
					
					userTotalHitCountFinal=userTotalHitCount+1;
					
					System.out.println("userTotalHitCountFinal value is "+userTotalHitCountFinal);
					
                    int up=userDao.userUpdateHitCount(bookBeans, userTotalHitCountFinal); 
					
					System.out.println("Value of up is ........"+up);
					
					
				}
				
				else
				{
					int m1=userDao.userInsertHitCount(bookBeans);
					
					System.out.println("Value of m is "+m1);
				}
				
								
				RequestDispatcher rd=request.getRequestDispatcher("userShowProductInAdd.jsp");
				rd.forward(request, response);
				
				
				
				
			}
			
			else
			{
				m=userDao.userInsertAddToCard(userBeans, bookBeans);
				
				System.out.println("Value of m is "+m);
				
	      			
	            count=userDao.userCalculatedCountBooksInCard(userBeans);
				
				System.out.println("Count is "+count);
				
  	            HttpSession session1=request.getSession();
				
				session1.setAttribute("userCountSessionInfomation",count);
				
				/*lastRow=userDao.userGetlastCount();
				
				System.out.println("last row is count value is "+lastRow);*/
				
				rs3=userDao.userGetInfomation(bookBeans.getBook_id());
				
				HttpSession session12=request.getSession();
				
				session12.setAttribute("BooksSessionInfomation",rs3 );
				
				System.out.println("only  insert into table ");
				
				System.out.println("In Book Add to Card Section in Esle parts  ");
				
                rs4=userDao.userCheckHitCount(bookBeans);
				
				if(rs4.next())
				{
					System.out.println("rs value have not null ");
					
					//id, book_id, book_name, book_author, book_price, book_hit_count, book_buy_count
					
					userTotalHitCount=rs4.getInt(6);
					
					System.out.println("userTotalHitCount value is "+userTotalHitCount);
					
					userTotalHitCountFinal=userTotalHitCount+1;
					
					System.out.println("userTotalHitCountFinal value is "+userTotalHitCountFinal);
					
                    int up=userDao.userUpdateHitCount(bookBeans, userTotalHitCountFinal); 
					
					System.out.println("Value of up is ........"+up);
					
					
				}
				
				else
				{
					int m1=userDao.userInsertHitCount(bookBeans);
					
					System.out.println("Value of m is "+m1);
				}
				
				
				RequestDispatcher rd=request.getRequestDispatcher("userShowProductInAdd.jsp");
				rd.forward(request, response);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

		
	}

}

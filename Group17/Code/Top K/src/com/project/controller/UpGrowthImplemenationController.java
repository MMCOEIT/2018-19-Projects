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
import com.project.dao.BookDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UpGrowthImplemenationController
 */
@WebServlet("/UpGrowthImplemenationController")
public class UpGrowthImplemenationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpGrowthImplemenationController() {
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
		
		System.out.println("Up growth Implemnattaion Controller 111111111111111111111");
		
		int result=0;
		
		ResultSet rs1=null;
		
		int book_hit_count=0;
		
		BookDao bookDao=DaoFactory.getInstancesBook();
		
		BookBeans bookBeans=new BookBeans();
		
		String tableName=null;
		
		
		// logice 
		
		HttpSession session=request.getSession();
		
		result=(Integer)session.getAttribute("resultValueSession");
		
		HttpSession session1=request.getSession();
		
		bookBeans=(BookBeans)session1.getAttribute("bookBeansSession");
		
		System.out.println("Get the session of bookBeans is "+bookBeans.getTablename());
		
		tableName=bookBeans.getTablename();
		
		System.out.println("table Name im Up implematation is "+tableName);
		
		// final session 
		
		HttpSession tableNameSession=request.getSession();
		
		tableNameSession.setAttribute("tableNameSessionFinal", tableName);
		
		System.out.println("table Name is "+tableName);
		
		
		System.out.println("In Up growth Implematation controller");
				
		if(result==100){
			System.out.println("table found and insert into table ");
			
			System.out.println("Value of table name is "+bookBeans.getTablename());
			
			rs1=bookDao.bookCheckUpgrowth(bookBeans, bookBeans.getTablename());
			
			try {
				if(rs1.next()){
					
				//id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit, product_Buy
					
					System.out.println("value is not null.............");
					
					book_hit_count=rs1.getInt(16);
					
					System.out.println("Value of book_hit is "+book_hit_count);
					
					book_hit_count=book_hit_count+1;
					
					System.out.println("book hit count is "+book_hit_count);
					
					int t1=bookDao.bookUpGrowthCount(bookBeans, book_hit_count, bookBeans.getTablename());
					
					System.out.println("Update hua buy abhi nahi hona chaiya "+t1);
					
					
					RequestDispatcher rd=request.getRequestDispatcher("userShowparticuleProduct.jsp");
					rd.forward(request, response);
					
					
					
					
				}
				
				else{
					
					System.out.println("insert into up growth..........");
					
					
					
					int r=bookDao.bookInsertUpgrowth(bookBeans, bookBeans.getTablename());
					
					System.out.println("r values of r "+r);
					
					RequestDispatcher rd=request.getRequestDispatcher("userShowparticuleProduct.jsp");
					rd.forward(request, response);
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} // end of if block of result 
		
		else
		{
			System.out.println("insert into up growth while table was created ..........");
			
			int r=bookDao.bookInsertUpgrowth(bookBeans, bookBeans.getTablename());
			
			System.out.println("r values of r "+r);
			
			RequestDispatcher rd=request.getRequestDispatcher("userShowparticuleProduct.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
	}

}

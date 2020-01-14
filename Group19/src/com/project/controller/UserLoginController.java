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

import com.project.beans.UserBeans;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
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
		
		// objects
		
		
		UserBeans userBeans=new UserBeans();
		
		UserDao doa=DaoFactory.getInstances();
		
		ResultSet rs=null,rs1=null;
		
		String userCategory=null;
		
		int userTime=0;
		
		// logices
		
		userBeans.setUser_email(request.getParameter("userEmail")); /// yash@gmail.com	
		
		userBeans.setUser_password(request.getParameter("userPassword")); // Swapnil123 // yash123 
		
		rs=doa.userLoginCheck(userBeans);
		
		try {
			if(!rs.next()){
				
				System.out.println("rs is null values");
				
				request.setAttribute("errorMsg", "your email id and Password is wrong");
				
				RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
				rd.forward(request, response);
				
			}
			
			else
			{
				
				userTime=rs.getInt(7);
				
				if(userTime==0){
					
					int n=doa.userUpdateUserTime(userBeans);
					
					System.out.println("Value of n is "+n);
					
					RequestDispatcher rd=request.getRequestDispatcher("userLoginWithOtp.jsp");
					rd.forward(request, response); // Show page Redirect 
					 
					
				}
				
				else
				{
				
				
				System.out.println("rs have no null values ");
				//id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
				
				userBeans.setId(rs.getInt(1));
				
				userBeans.setUser_name(rs.getString(2));
				
				userBeans.setUser_email(rs.getString(3));
				
				userBeans.setUser_password(rs.getString(4));
				
				userBeans.setUser_contact_number(rs.getString(5));
				
				HttpSession session=request.getSession();
				
				session.setAttribute("userSessionInfomation", userBeans);
				
				System.out.println("Session done ");
				
			   RequestDispatcher rd=request.getRequestDispatcher("welcomeToUser.jsp");
				rd.forward(request, response);
				
				
				/*rs1=doa.userCheckREcommdationProcess(userBeans);
				
				if(rs1.next()){
					
					System.out.println("rs1 have value ");
					
					userCategory=rs1.get
					
					session2.setAttribute("recommdationProductSession", rs1);
					
					RequestDispatcher rd=request.getRequestDispatcher("recommdationUser.jsp");
					rd.forward(request, response);
				}
				
				else
				{
					System.out.println("No Values ");
					
					RequestDispatcher rd=request.getRequestDispatcher("welcomeToUser.jsp");
					rd.forward(request, response);
				}
				*/
				
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

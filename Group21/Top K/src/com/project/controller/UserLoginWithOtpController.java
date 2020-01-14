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
 * Servlet implementation class UserLoginWithOtpController
 */
@WebServlet("/UserLoginWithOtpController")
public class UserLoginWithOtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginWithOtpController() {
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
		
		UserBeans userBeans=new UserBeans();
		
		UserDao dao=DaoFactory.getInstances();
		
		ResultSet rs=null;
						
		// logice 
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userPassword"));
		
		userBeans.setUser_otp(request.getParameter("userOTP"));
		
		rs=dao.userLoginCheckWithOtp(userBeans);
		
		try {
			if(!rs.next()){
			
				
				request.setAttribute("errorMsg", "your email id and Password is wrong");
				
				RequestDispatcher rd=request.getRequestDispatcher("userLoginWithOtp.jsp");
				rd.forward(request, response);
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

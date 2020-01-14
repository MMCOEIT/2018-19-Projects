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

import com.project.beans.UserBeans;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;
import com.project.mail.mail;

/**
 * Servlet implementation class UserChangesPasswordController
 */
@WebServlet("/UserChangesPasswordController")
public class UserChangesPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserChangesPasswordController() {
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
		
		int n=1;
		
		mail mail=new mail();
		
				
		// Logice
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_password(request.getParameter("userOldPassword"));
		
		userBeans.setUser_new_password(request.getParameter("userNewPassword"));
		
		rs=dao.isAlreadyRegister(userBeans);
		
		try {
			if(rs.next()){
				System.out.println("Value of result prsesnt ");
				
				n=dao.userChangePassword(userBeans);
				
				System.out.println("Value of n is "+n);
				
				mail.mailSendNewPassword(userBeans.getUser_email(), userBeans.getUser_new_password());
				
				RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
				rd.forward(request, response);
				
				
			}
			
			else
			{
	              System.out.println("rs is null values");
				
				request.setAttribute("errorMsg", "your email id and Password is wrong");
				
				RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

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
import com.project.smsFinal.sms;

/**
 * Servlet implementation class UserForgotPasswordController
 */
@WebServlet("/UserForgotPasswordController")
public class UserForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserForgotPasswordController() {
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
		
		 String userPassword=null;
		 
		 mail mail=new mail();
		 
		 sms smsObject=new sms();
		
		// logice
		 
		 userBeans.setUser_email(request.getParameter("userEmail"));
		 
		 rs=dao.isAlreadyRegister(userBeans);
		 
		 try {
			if(!rs.next()){
				 
				request.setAttribute("errorMsg", "Email id not exist .....");
				
				RequestDispatcher rd=request.getRequestDispatcher("userForgotPassword.jsp");
				rd.forward(request, response);
				
			 }
			 
			 else
			 {
				 
				 //id, user_name, user_email, user_password, user_contact_number, user_otp, user_time
				 
				 userPassword=rs.getString(4);
				 
				 smsObject.Sms_user(rs.getString(5), userPassword);
				 
				 
				 mail.sendMailPassword(userBeans.getUser_email(), userPassword);
				 
				 System.out.println("mail send");
				 
				 RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
			     rd.forward(request, response);
				 
				 
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}

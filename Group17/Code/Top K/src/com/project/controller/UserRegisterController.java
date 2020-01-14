package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

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
 * Servlet implementation class UserRegisterController
 */
@WebServlet("/UserRegisterController")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
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
		
		UserDao doa=DaoFactory.getInstances();
		
		mail mail=new mail();
		
		ResultSet rs=null;
		
		int userTime=0;
	
		int n=1;
		
		sms smsObject=new sms();
		
		//logice
		
		// random class
		
		Random r = new Random();
		int ii = r.nextInt(10000000 - 500000) + 500000;
	    String userOtp = ii + "";
		String l = "1";
		
		
		
		userBeans.setUser_name(request.getParameter("userName"));
		
		userBeans.setUser_password(request.getParameter("userPassword"));
		
		userBeans.setUser_email(request.getParameter("userEmail"));
		
		userBeans.setUser_contact_number(request.getParameter("userContactNumber"));
		
		userBeans.setUser_otp(userOtp);
		
		userBeans.setUser_time(userTime);
		
		rs=doa.isAlreadyRegister(userBeans);
		
		try {
			if(!rs.next()){
				
				n=doa.userRegistration(userBeans);
				
				if(n>0){
					
					mail.sendMailOtp(userBeans.getUser_email(), userOtp);
					
					 smsObject.Sms_user(userBeans.getUser_contact_number(), userOtp);
					
					RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
					rd.forward(request, response);
					
									
				}
				
								
			}
			
			else
			{
				request.setAttribute("errorMsg", "your already registrated in Application  ");
				
				RequestDispatcher rd=request.getRequestDispatcher("userRegistration.jsp");
				rd.forward(request, response);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}

package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;
import com.project.mail.mail;

/**
 * Servlet implementation class ContactUsController
 */
@WebServlet("/ContactUsController")
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// objects 
		
		UserDao userDao=DaoFactory.getInstances();
		
		int n=1;
		
		mail mail=new mail();
		
		
		String userName=request.getParameter("userName");
		
		String userEmail=request.getParameter("userEmail");
		
		String userPhone=request.getParameter("userPhone");
		
		String userMsg=request.getParameter("userMsg");
		
		n=userDao.userConatctUs(userName, userEmail, userPhone, userMsg);
		
		if(n==1){
			
			mail.mailConatctUs(userEmail);
			
			System.out.println("mail Send!");
			
			request.setAttribute("successMsg", "Thanks! your Message Submit successfully");
			
			RequestDispatcher rd=request.getRequestDispatcher("contactUs.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		
		
	}

}

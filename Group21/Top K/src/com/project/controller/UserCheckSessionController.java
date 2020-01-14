package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserCheckSessionController
 */
@WebServlet("/UserCheckSessionController")
public class UserCheckSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCheckSessionController() {
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
		
		// http session
		
		HttpSession session=request.getSession();
		
		
		
		  if (session.getAttribute("userSessionInfomation").equals("")) {
			  
			  System.out.println("Yes session is nulll");
			  
			  RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
				rd.forward(request, response);
			  
		  }
		  
		  else
		  {
			    System.out.println("Session is not null");
			  
				RequestDispatcher rd=request.getRequestDispatcher("welcomeToUser.jsp");
				rd.forward(request, response);
		  }
		  
		  
	}

}

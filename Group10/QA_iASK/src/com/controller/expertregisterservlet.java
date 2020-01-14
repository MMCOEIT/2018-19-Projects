package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class expertregisterservlet
 */
@WebServlet("/expertregisterservlet")
public class expertregisterservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public expertregisterservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		
		int  Community = Integer.parseInt(request.getParameter("Community"));
		
		String cpassword = request.getParameter("cpassword");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		//HttpSession session2 = request.getSession();
		session.setAttribute("password", password);
		
		//HttpSession session3 = request.getSession();
		session.setAttribute("email", email);
		
		//HttpSession session4 = request.getSession();
		session.setAttribute("Community", Community);
		
		//HttpSession session5 = request.getSession();
		session.setAttribute("cpassword", cpassword);
		
		
		
		System.out.println("username------>"+username);
		
		System.out.println("password------>"+password);
		
		System.out.println("email------>"+email);
		
		System.out.println("Community------>"+Community);
		
		System.out.println("cpassword------>"+cpassword);
		
		
		try {
			
			
			if(Community==1)
			{
				response.sendRedirect("javatest.jsp");
				System.out.println("javatest.jsp");
			}
			
			if(Community==2)
			{
				response.sendRedirect("musictest.jsp");
				System.out.println("musictest.jsp");
			}
			
			
			  if(Community==3)
			{
				  response.sendRedirect("sportstest.jsp");
				  System.out.println("sportstest.jsp");
			}
			
			else
			
			{
				
				System.out.println("Best of Luck !!!!!!!!!!!!!");
				
			}
			
		} catch (Exception e) {
			e.getMessage();
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}

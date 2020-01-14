package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DataAccessLayer;
import com.model.admindata;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		//doGet(request, response);
		String loginname = request.getParameter("username");
		String loginpassword = request.getParameter("password");
		PrintWriter out = response.getWriter();
	  
		System.out.println(loginname);
		System.out.println(loginpassword);
		
		
		admindata ad = new admindata();
		
		ad.setName(loginname);
		ad.setPassword(loginpassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", loginname);
		
		int i=DataAccessLayer.adminLogin(ad);
		
		System.out.println("id---->"+ i);
		
		if(i!=0)
			
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Logged in successfully');");
			out.println("location='admin.jsp';");
			out.println("</script>");
		}
		else
		  {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Log in unsuccessful');");
			out.println("location='index.jsp';");
			out.println("</script>");
		}

	}

}

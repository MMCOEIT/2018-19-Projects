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

import com.model.adduserdata;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		adduserdata ad = new adduserdata();
		
		ad.setName(loginname);
		ad.setPassword(loginpassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", loginname);
		
		
		
	int communityid =	 DataAccessLayer.authenticateAdmin(ad);
		
	System.out.println("communityid--->"+communityid);
	try {
		
		if(communityid==1)
		{
		    out.println("<script type=\"text/javascript\">");
	        out.println("alert('Logged in successfully');");
	        out.println("location='java.jsp';");
	        out.println("</script>");
			//response.sendRedirect("java.jsp");
			 
		}
		
		if(communityid==2)
		{
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('Logged in successfully');");
	        out.println("location='music.jsp';");
	        out.println("</script>");
			//response.sendRedirect("music.jsp");
		}
		
		if(communityid==3)
		{
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('Logged in successfully');");
	        out.println("location='sports.jsp';");
	        out.println("</script>");// response.sendRedirect("sports.jsp");
		}
		
		else
		{
			out.println("<script type=\"text/javascript\">");
	        out.println("alert('Log in unsuccessful');");
	       out.println("location='index.jsp';");
	        out.println("</script>");
			//response.sendRedirect("error.jsp");	
			
		}
		
		}
	catch (Exception e) {
		
		e.printStackTrace();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
	}

		
		
		
		
	}



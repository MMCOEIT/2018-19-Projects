package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectCommunity
 */
@WebServlet("/SelectCommunity")
public class SelectCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCommunity() {
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
	
	int commid=Integer.parseInt(request.getParameter("Community"));
	
	System.out.println("CommunityID----->"+commid);
	
	
	if(commid==1)
	{
		
		response.sendRedirect("java1.jsp");
		
		
	}
	if(commid==2)
	{
		
		response.sendRedirect("music1.jsp");
		
	}
	if(commid==3)
	{
		
		response.sendRedirect("sports1.jsp");
		
	}
	else
	{
		
		System.out.println("Defult Community");
	}
	
	
	
	
	}

}

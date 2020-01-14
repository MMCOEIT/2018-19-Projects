package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAccessLayer;

/**
 * Servlet implementation class updateratingcontl
 */
@WebServlet("/updateratingcontl")
public class updateratingcontl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateratingcontl() {
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
	
	int id = (Integer.parseInt(request.getParameter("id"))); 
	int id1 = (Integer.parseInt(request.getParameter("expertid")));
	int ratingupdate = (Integer.parseInt(request.getParameter("ratingupdate"))); 
			
	     DataAccessLayer.updateRating(id,ratingupdate);
	 
	     response.sendRedirect("msg.jsp");
	
	}

}

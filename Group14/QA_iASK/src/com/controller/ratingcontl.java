package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DataAccessLayer;

import com.model.ratingadd;

/**
 * Servlet implementation class ratingcontl
 */
@WebServlet("/ratingcontl")
public class ratingcontl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ratingcontl() {
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
		
		int id  = (Integer.parseInt(request.getParameter("aid")));
		
		String expertrname = request.getParameter("expertrname");
		
		String name = request.getParameter("expertname");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String qestion = request.getParameter("qestion");
		String answer = request.getParameter("answer");
		int answerid = (Integer.parseInt(request.getParameter("id")));
		
		
		System.out.println("answerid--->"+answerid);
	
	    //int check = DataAccessLayer.validexpertaddrating(name,id,answerid);
		
	    int check = DataAccessLayer.validexpertaddrating(expertrname,id,answerid);
		
		if(check!=0)
		
		{
			
			 HttpSession session5 = request.getSession();
		     session5.setAttribute("check", check);
			 response.sendRedirect("updateRating.jsp");
		
			
		}
		
		else
		
		{
			
		
			ratingadd ad = new ratingadd();
			
			ad.setExpertrname(expertrname);
			ad.setAnswerid(answerid);
			ad.setQestionid(id);
			ad.setUsername(name);
			ad.setRating(rating);
			ad.setQestion(qestion);
			ad.setAnswer(answer);
			
			
			 DataAccessLayer.ratingadd(ad);
			
			response.sendRedirect("msg.jsp");
			
			
		}
		
		
	
		
		
		
		
	}

}

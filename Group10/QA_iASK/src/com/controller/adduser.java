package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAccessLayer;
import com.model.adduserdata;


/**
 * Servlet implementation class adduser
 */
@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduser() {
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
		
		/*String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");*/
       int community = Integer.parseInt(request.getParameter("Community"));
		
		
		/*System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(cpassword);*/
		System.out.println(community);
		
		adduserdata add = new adduserdata();
		
		/*add.setName(name);
		add.setEmail(email);
		add.setPassword(password);
		add.setCpassword(cpassword);*/
		add.setCommunity(community);
		
		
		
		DataAccessLayer.adduser(add);
		response.sendRedirect("index.jsp");
	}

	
		
	}
	 


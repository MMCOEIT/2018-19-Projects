package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.beans.UserBeans;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class UserShowAllBooksController
 */
@WebServlet("/UserShowAllProductController")
public class UserShowAllProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserShowAllProductController() {
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
		
		// object and varible 
		
		UserBeans userBeans=new UserBeans();
		
		UserDao dao=DaoFactory.getInstances();
		
		ResultSet rs=null;
		
			
		// logice
		
		userBeans.setUser_Category(request.getParameter("user_category"));
		
		System.out.println("user_category is "+userBeans.getUser_Category());
		
		HttpSession session1=request.getSession();
		
		session1.setAttribute("userCategorySession", userBeans.getUser_Category());
			
		rs=dao.userGetBookInfomation(userBeans);
		
		HttpSession session =request.getSession();
		
		session.setAttribute("userShowAllBooksSession", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("showAllProductInfomation.jsp");
		
		rd.forward(request, response);
		
		
		
	}

}

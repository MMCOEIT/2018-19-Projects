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
 * Servlet implementation class UserContinueToBasketController
 */
@WebServlet("/UserContinueToBasketController")
public class UserContinueToBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserContinueToBasketController() {
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
		
		// object and varibles
		
		HttpSession session=request.getSession();
		
		String userCategory=null;
		
		ResultSet rs=null;
		
		UserBeans userbeans =new UserBeans();
		
		UserDao userDao=DaoFactory.getInstances();
				
		
		// logice 
		
		userCategory=(String)session.getAttribute("userCategorySession");
		
		userbeans.setUser_Category(userCategory);	
		
        rs=userDao.userGetBookInfomation(userbeans);
		
		HttpSession session1 =request.getSession();
		
		session.setAttribute("userShowAllBooksSession", rs);
		
		RequestDispatcher rd=request.getRequestDispatcher("showAllProductInfomation.jsp");
		
		rd.forward(request, response);
		
		
	}

}
package com.project.controller;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;

/**
 * Servlet implementation class UserProductFinalOrderController
 */
@WebServlet("/UserProductFinalOrderController")
public class UserProductFinalOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductFinalOrderController() {
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
		
		UserBeans userBeans=new UserBeans();
		
		BookBeans bookBeans=new BookBeans();
         
		HashSet<String> hashSet=new HashSet<String>();   // hash set object
		
		userBeans.setId(Integer.parseInt(request.getParameter("userId")));
		
		bookBeans.setBook_id(Integer.parseInt(request.getParameter("bookId")));
		
		bookBeans.setBrand_name(request.getParameter("bookCategory"));
		
        HttpSession session1=request.getSession();
		
		session1.setAttribute("bookBeansSession",bookBeans);
		
		RequestDispatcher rd=request.getRequestDispatcher("productPlacedOrder.jsp");
		rd.forward(request, response);
		
		
	}

}

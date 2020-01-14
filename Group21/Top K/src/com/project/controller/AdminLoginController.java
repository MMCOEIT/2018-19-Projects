package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.beans.AdminBeans;
import com.project.dao.AdminDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
		
		// varible and objects 
		
		AdminBeans adminBeans=new AdminBeans();
		
		AdminDao dao=DaoFactory.getInstanceAdmin();
		
		ResultSet rs=null;
		
				
		// logice 
		
		adminBeans.setAdmin_name(request.getParameter("adminName"));
		
		adminBeans.setAdmin_password(request.getParameter("adminPassword"));
		
		rs=dao.adminLogin(adminBeans);
		
		try {
			if(rs.next()){
				
				System.out.println("rs value is not null");
				
				adminBeans.setAdmin_name(rs.getString(2));
				
				adminBeans.setAdmin_password(rs.getString(3));
				
				HttpSession session=request.getSession();
				
				session.setAttribute("adminSessionInfomation",adminBeans);
				
				RequestDispatcher rd=request.getRequestDispatcher("welcomeToAdmin.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				request.setAttribute("errorMsg","Sorry! your Name and Password is wrong");
				
				RequestDispatcher rd=request.getRequestDispatcher("adminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

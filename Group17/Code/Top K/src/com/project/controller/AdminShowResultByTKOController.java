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

import com.project.dao.AdminDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class AdminShowResultByTKOController
 */
@WebServlet("/AdminShowResultByTKOController")
public class AdminShowResultByTKOController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowResultByTKOController() {
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
		
		// object
		
		AdminDao adminDao=DaoFactory.getInstanceAdmin();
		
		ResultSet rs=null;
		
		HttpSession session=request.getSession();
		
		// logic
		
		rs=adminDao.adminGetResult();
		
		session.setAttribute("ResultTKOSession",rs);
		
		System.out.println("In controller parts ");
		
		RequestDispatcher rd=request.getRequestDispatcher("graph.jsp");
		rd.forward(request, response);
		
	}

}

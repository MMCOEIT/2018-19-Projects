package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAccessLayer;
import com.model.addkeyworddata;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class keyword
 */
@WebServlet("/keyword")
public class keyword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public keyword() {
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
		
		String keyword = request.getParameter("keyword");
		
		int Cid = Integer.parseInt(request.getParameter("Community"));
		
		
		System.out.println("keyword----->"+keyword);
		System.out.println("Cid----->"+Cid);
		
		
		addkeyworddata ad = new addkeyworddata();
		ad.setCid(Cid);
		
		ad.setKeyword(keyword);
		
		DataAccessLayer.addkeyword(ad);
		
		response.sendRedirect("addkeyword.jsp?value=Keyword Add Sucessfully!!!!!!!");
		
		
	}

}

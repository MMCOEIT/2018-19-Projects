package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAccessLayer;
import com.model.Qestionstoredatabase;

/**
 * Servlet implementation class changecommunity
 */
@WebServlet("/changecommunity")
public class changecommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changecommunity() {
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
	
	int cid = Integer.parseInt(request.getParameter("communityid"));
	String qestion = request.getParameter("qestion");

	System.out.println("cid-->"+cid);
	System.out.println("qestion--->"+qestion);
	
	Qestionstoredatabase qd = new Qestionstoredatabase();
	
	qd.setQid(cid);
	qd.setQestion(qestion);
	
    DataAccessLayer.QestionStoreDatabase(qd);
	
	response.sendRedirect("Notification.jsp");
}

}

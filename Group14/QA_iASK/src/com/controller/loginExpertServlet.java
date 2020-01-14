package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DataAccessLayer;
import com.model.expert;

/**
 * Servlet implementation class ExpertServlet
 */
@WebServlet("/ExpertServlet")
public class loginExpertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginExpertServlet() {
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
		
		
		String expertusername = request.getParameter("username");
		
		String expertpassword = request.getParameter("password");
		
		System.out.println("Expert username--->"+expertusername);
		
		System.out.println("Expert password--->"+expertpassword);
		
		
		expert expert = new expert();
		
		expert.setUsername(expertusername);
		expert.setPassword(expertpassword);
		
		
		int expertid = DataAccessLayer.authenticateexpert(expert);
		
		System.out.println("expertid---->"+expertid);
		
		if(expertid!=0)
		
		{
		
        HttpSession ses = request.getSession();
        
        ses.setAttribute("expertid", expertid);
        
		ses.setAttribute("expertusername", expertusername);
		ses.setAttribute("expertpassword", expertpassword);
		
		response.sendRedirect("expertautority.jsp");
		
		}
		
		else
		
		{
			
	     response.sendRedirect("indexexpert.jsp?msg=You Are Not Authorised Expert....Please Goto The Exam Section And Match The Expert Score....  ");
		
		}
		
		
		
		
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;


@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserDeleteController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		UserDao dao=new UserDao();
		
		if(dao.DeleteUser(id))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Delete User Successfully');");
			out.println("location='ViewUsers.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Fail.......');");
			out.println("location='ViewUsers.jsp';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

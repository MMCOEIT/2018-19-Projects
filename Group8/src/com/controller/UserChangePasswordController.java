package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;


@WebServlet("/UserChangePasswordController")
public class UserChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserChangePasswordController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String oldpass=request.getParameter("oldpass");
		String newpass=request.getParameter("newpass");
		
		UserDao dao=new UserDao();
		
		if(dao.UpdateUserPassword(oldpass,newpass))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('password change successfully')");
			out.println("location='UserHome.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Fail..........')");
			out.println("location='UserHome.jsp';");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.mail.ForgotPassword;

@WebServlet("/AdminForgotPasswordController")
public class AdminForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminForgotPasswordController() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		
		UserDao user=new UserDao();
		
		UserBean bean=user.SelectUserPassword(email);
		
		if(bean.getPassword()!=null && bean.getPassword()!=""){
			ForgotPassword forgotPass=new ForgotPassword();
			forgotPass.forgotPassEmailSend(email, bean.getPassword());
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password Send Successfully');");
			out.println("location='UserLogin.jsp';");
			out.println("</script>");
			
		}else{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password not send');");
			out.println("location='UserForgotPassword.jsp';");
			out.println("</script>");
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

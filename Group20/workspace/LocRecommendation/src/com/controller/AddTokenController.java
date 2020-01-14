package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.algorithm.Main;
import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/AddTokenController")
public class AddTokenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddTokenController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in token submit button");
		PrintWriter out=response.getWriter();
		String token=request.getParameter("token");

		HttpSession session=request.getSession();
		String Name=(String) session.getAttribute("email");
		System.out.println("Email ID>>>>>>>>"+Name);
		
		
	   UserBean bean=new UserBean();
	  UserDao dao=new UserDao();
	   ResultSet rs=dao.search(Name);
	  
		try {
			while(rs.next())
			   {
				   int id=rs.getInt(1);
				   String UserName=rs.getString(4);
				   
				   bean.setId(id);
				   bean.setName(UserName);
				      
			   }
		
	
	   bean.setEmail(Name);
	   bean.setToken(token);



	   int i=dao.insertTokenData(bean);
	  

	if(i>0)
	{
		Main ma=new Main();
		
			ma.getdata(token, Name);
		
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Token Entered Successfully')");
			out.println("location='FBLocation.jsp';");
			out.println("</script>");
	
	}
	else {
		//JOptionPane.showMessageDialog(null, "Invalid Token");
		//request.getRequestDispatcher("userhome.jsp").forward(request, response);

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Token')");
		out.println("location='UserHome.jsp';");
		out.println("</script>");
	}} catch (SQLException e) {
		
		e.printStackTrace();
	}
}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

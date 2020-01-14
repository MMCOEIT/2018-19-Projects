package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithms.HashCodeGenerator;
import com.bean.TitleBean;
import com.connection.DBConnection;

@WebServlet("/AddTitleController")
public class AddTitleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbName="mixedgenerative";
	private String dbURL = "jdbc:mysql://localhost:3306/"+dbName; 
	private String dbUser = "root";
	private String dbPass = "root";
    
    public AddTitleController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String title=request.getParameter("title");
		
		HashCodeGenerator hash=new HashCodeGenerator();
		String code=hash.generate(title);
		
		TitleBean bean=new TitleBean();
		bean.setTitle(title);
		
		Connection conn = null;
        String message = null;
        
		 try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			PreparedStatement ps;
			
			
			String sql="insert into tbl_title(title,hashcode) values(?,?)";
			Connection con=DBConnection.getConnection();
			
				ps=con.prepareStatement(sql);
			
				ps.setString(1, bean.getTitle());
				ps.setString(2, code);
				
				int index=ps.executeUpdate();
				
				
				if(index>0)
				{
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Upload Title Successfully');");
					out.println("location='UploadImage.jsp';");
					out.println("</script>");
				}
		 } catch (SQLException e) {
				
				e.printStackTrace();
			}
				
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

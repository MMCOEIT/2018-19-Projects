package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAccessLayer;
import com.model.expert;

/**
 * Servlet implementation class sportstest
 */
@WebServlet("/sportstest")
public class sportstest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sportstest() {
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
	
int count=0;
		
		String username = request.getParameter("username");
		
		System.out.println("username--->"+username);
		
		
		
		
		String password = request.getParameter("password");
		
		System.out.println("password--->"+password);
		
		
		
		String email = request.getParameter("email");
		
		System.out.println("email--->"+email);
		
		
		String Community = request.getParameter("Community");
		
		int  cid = Integer.parseInt(Community);
		
		System.out.println("Community--->"+Community);
		
		String cpassword = request.getParameter("cpassword");
        
		System.out.println("cpassword--->"+cpassword);
		
		
		System.out.println("cpassword--->"+cpassword);
		
		
		
		
		
		int qestion1 =Integer.parseInt(request.getParameter("question-1-answers"));
		
		int qestion2 =Integer.parseInt(request.getParameter("question-2-answers"));
		
		int qestion3 =Integer.parseInt(request.getParameter("question-3-answers"));
		
		int qestion4 =Integer.parseInt(request.getParameter("question-4-answers"));
		
		int qestion5 =Integer.parseInt(request.getParameter("question-5-answers"));
		
		
		System.out.println("qestion1---->"+qestion1);
		
		System.out.println("qestion2---->"+qestion2);
		
		System.out.println("qestion3---->"+qestion3);
		
		System.out.println("qestion4---->"+qestion4);
		
		System.out.println("qestion5---->"+qestion5);

//id, cid, username, password, email, cpassword, testresult		
		
		try 
		{
			if(qestion1==1)
			{
				count++;
			}
			
			if(qestion2==2)
			{
				count++;
			}
			if(qestion3==3)
			{
				count++;
			}
			if(qestion4==4)
			{
				count++;
			}
			if(qestion5==4)
			{
				count++;
			}
			
		}
		
		catch (Exception e) 
		{

         e.getMessage();
         System.out.println(e.getMessage());
         
		}
		
		finally 
		{
			
			if(count==4||count==5)
			{
				
			    expert expert= new expert();
				
				expert.setCid(cid);
				expert.setUsername(username);
				expert.setEmail(email);
				expert.setPassword(password);
				expert.setCpassword(cpassword);
				expert.setTestresult(count);
				
			    DataAccessLayer.addexpert(expert);
				
			    System.out.println("count----->"+count);
			    
			    
			    
			  response.sendRedirect("ExpertConform.jsp?message=Congratulations...You did it! So proud of you!!!!Welcome To Sports Expert Team!!!");
				
	
			}
			
			else
				
			{
				response.sendRedirect("ExpertConform.jsp?errormsg=Score Not Match...Better Luck Next Time");
				
			}
			
		}
		}
	}



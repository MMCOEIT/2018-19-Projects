package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Methods.Database;
import com.project.Methods.TKU_Algorithms_MainMethods;
import com.project.Methods.UpGrowth;
import com.project.beans.UserSearchBookBeans;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;
import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * Servlet implementation class TkuImplementationAlgorithmController
 */
@WebServlet("/TkuImplementationAlgorithmController")
public class TkuImplementationAlgorithmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TkuImplementationAlgorithmController() {
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
		
		HttpSession session=request.getSession(),session1=request.getSession(),session2=request.getSession(),session3=request.getSession(),session4=request.getSession(),session5=request.getSession(),session6=request.getSession();
		
		UserSearchBookBeans userSearchBookBeans= new UserSearchBookBeans();
		
		TKU_Algorithms_MainMethods tkuObject=new TKU_Algorithms_MainMethods();
		
		Database database=new Database();
		
		UserDao userDao=DaoFactory.getInstances();
		
        String tableName=null,category="category";
        
        ResultSet rs=null,rs1=null,rs2=null;
        	
        UpGrowth upGrowthObject=new UpGrowth();
						
		
		// logic
		
		userSearchBookBeans=(UserSearchBookBeans)session.getAttribute("userSearchBookBeansSession");
		
		System.out.println("Table Name "+userSearchBookBeans.getUser_category());
		
		System.out.println("Tok K Value "+userSearchBookBeans.getUser_top_k_value());
		
		tableName=category+"_"+userSearchBookBeans.getUser_category();
		
		System.out.println("final table is "+tableName);
		
		userSearchBookBeans.setTable_name(tableName);
		
		session2.setAttribute("userTopkValueSession", userSearchBookBeans);
		
		rs2=upGrowthObject.table_exits(userSearchBookBeans.getTable_name());
		
		try {
			if(!rs2.next()){
				System.out.println("table nOt present!");
				
				request.setAttribute("errorMsg","sorry! Result are Present ");
				
				
                RequestDispatcher rd=request.getRequestDispatcher("userErrorMsg.jsp");
			    
				rd.forward(request, response);
			}
			
			else
			{
				
			rs=userDao.userGetTKOValue(userSearchBookBeans);
					
			session1.setAttribute("ResultFinalTKUBuySession", rs);
			
			rs1=userDao.userGetTKUValueHit(userSearchBookBeans);
			
			session3.setAttribute("ResultFinalTKUHitSession", rs1);
			
			
			/*while(rs1.next()){
				
				System.out.println("Product Is is ............ "+rs1.getInt(2));
				
				
				
				
			}*/
			
			// TKO Time 
			
			long timeTko2=System.currentTimeMillis();
			
			System.out.println("time 2 is "+timeTko2);
			
				
			long time1tko=(Long)session4.getAttribute("tkoTime1Session");
			
			System.out.println("time1tko is "+time1tko);
			
			long totalTko=timeTko2-time1tko;
			
			System.out.println("total time is "+totalTko);
			
			// TKO Time End
			
			
			
			
			System.out.println("UserParamtre is "+userSearchBookBeans.getUser_paramertre());
			
			if(userSearchBookBeans.getUser_paramertre().equals("Hit")){
				
				RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByHit.jsp");
				rd.forward(request, response);
				
				// TKO Time Start
				
				long time2Tku=System.currentTimeMillis();
					
				System.out.println("time 2 of TKU .. is "+time2Tku);
				
				long time1Tku=(Long)session5.getAttribute("TKUTimeSession");
				
				System.out.println("time 1 of TKU is "+time1Tku);
				
				long totalTKU=time2Tku-time1Tku;
				
				System.out.println("total Time is TKU  "+totalTKU);
					
				// TKU Time End 
				
				
				// TKO with TKU 
				
				long timeFinal2=System.currentTimeMillis();
				
				System.out.println("timeFinal2 of TKUWITHTKO algortihms is "+timeFinal2);
				
				long timeFinal1=(Long)session6.getAttribute("finalTime1Session");
				
				System.out.println("timeFinal1 of TKUWITHTKO algortihms is "+timeFinal1);
				
				long totalTimeMain=timeFinal2-timeFinal1;
				
				System.out.println("totalTimeMain of TKUWITHTKO algortihms is "+totalTimeMain);
				
				int n=userDao.userInsertGraphTable(userSearchBookBeans.getUser_top_k_value(), totalTko, totalTKU, totalTimeMain,userSearchBookBeans.getUser_category());
				
				System.out.println("Value of n is"+n);
				
                /*RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByHitUsingTKO.jsp");
			    
				rd.forward(request, response);*/
				
				
			}
			
			else
				
			{
				System.out.println("Buy is "+userSearchBookBeans.getUser_paramertre());
				
				
				// TKO Time Start
				
				long time2Tku=System.currentTimeMillis();
					
				System.out.println("time 2 of TKU .. is "+time2Tku);
				
				long time1Tku=(Long)session5.getAttribute("TKUTimeSession");
				
				System.out.println("time 1 of TKU is "+time1Tku);
				
				long totalTKU=time2Tku-time1Tku;
				
				System.out.println("total Time is TKU  "+totalTKU);
					
				// TKU Time End 
				
				
				// TKO with TKU 
				
				long timeFinal2=System.currentTimeMillis();
				
				System.out.println("timeFinal2 of TKUWITHTKO algortihms is "+timeFinal2);
				
				long timeFinal1=(Long)session6.getAttribute("finalTime1Session");
				
				System.out.println("timeFinal1 of TKUWITHTKO algortihms is "+timeFinal1);
				
				long totalTimeMain=timeFinal2-timeFinal1;
				
				System.out.println("totalTimeMain of TKUWITHTKO algortihms is "+totalTimeMain);
				
				int n=userDao.userInsertGraphTable(userSearchBookBeans.getUser_top_k_value(), totalTko, totalTKU, totalTimeMain,userSearchBookBeans.getUser_category());
				
				System.out.println("Value of n is"+n);
				
				RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByBuy.jsp");
			    
				rd.forward(request, response);
				
			}
			
			
			//RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResult.jsp");
			
			//rd.forward(request, response);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}

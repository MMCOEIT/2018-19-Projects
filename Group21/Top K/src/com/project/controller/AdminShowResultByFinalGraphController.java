package com.project.controller;

import java.awt.image.RescaleOp;
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

import org.apache.catalina.connector.Request;

import com.project.dao.AdminDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class AdminShowResultByFinalGraphController
 */
@WebServlet("/AdminShowResultByFinalGraphController")
public class AdminShowResultByFinalGraphController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowResultByFinalGraphController() {
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
		
		
		// objects 
		
		AdminDao adminDao=DaoFactory.getInstanceAdmin();
		
		ResultSet rs=null,rs1=null,rs2=null;
		
		long totalTKO = 0,totalTKU=0,totalFinal=0;
		
		int n=1,n1=0;
		
		HttpSession session=request.getSession();
		
		
		// logic
		
		rs=adminDao.adminGetResult();
		
		try {
			while(rs.next()){
				
				//id, top_k_value, tko_value, tku_value, tkowithtku_value, book_category
				
				System.out.println("value is  "+rs.getLong(3));
				
				totalTKO+=rs.getLong(3);
				
				totalTKU+=rs.getLong(4);
				
				totalFinal+=rs.getLong(5);
				
				/*System.out.println("total Tko time is "+totalTKO);*/
				
			}
			
			System.out.println("total Tko time is "+totalTKO);
			
			System.out.println("total TkU time is "+totalTKU);
			
			System.out.println("total Tko with tkU time is "+totalFinal);
			
 			rs1=adminDao.adminCheckRecords();
			
			if(rs1.next()){
			
				System.out.println("rs1 have records");
				
				n=adminDao.adminTruncateTable();
				
				System.out.println("turncate table n is"+n);
				
				n1=adminDao.adminInsertRecords(totalTKO, totalTKU, totalFinal);
				
				
			}
			
			else
			{
				
				n1=adminDao.adminInsertRecords(totalTKO, totalTKU, totalFinal);
				
				
			}
			
			
			rs2=adminDao.adminCheckRecords();
			
			session.setAttribute("finalTimeGraph",rs2);
			
			RequestDispatcher rd=request.getRequestDispatcher("graphFinal.jsp");
			rd.forward(request, response);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

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
import com.project.beans.UserProductBeans;
import com.project.beans.UserSearchBookBeans;
import com.project.dao.UserDao;
import com.project.daoFactory.DaoFactory;

/**
 * Servlet implementation class TkuImplementationAlgorithmMainResutlController
 */
@WebServlet("/TkuImplementationAlgorithmMainResutlController")
public class TkuImplementationAlgorithmMainResutlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TkuImplementationAlgorithmMainResutlController() {
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
		
long timeFinal1=System.currentTimeMillis();
		
		System.out.println("timeFinal1 of TKUWITHTKO algortihms is "+timeFinal1);
		
		HttpSession sessionF=request.getSession();
		
		sessionF.setAttribute("finalTime1Session",timeFinal1);
		
		
		
				HttpSession session=request.getSession(),session1=request.getSession(),session2=request.getSession(),session3=request.getSession(),session4=request.getSession(),session5=request.getSession(),session6=request.getSession(),session7=request.getSession();
				
				UserSearchBookBeans userSearchBookBeans= new UserSearchBookBeans();
				
				TKU_Algorithms_MainMethods tkuObject=new TKU_Algorithms_MainMethods();
				
				Database database=new Database();
				
				UserDao userDao=DaoFactory.getInstances();
				
		        String tableName=null,category="category";
		        
		        ResultSet rs=null,rs1=null,rs2=null,rs3=null;
		        	
		        UpGrowth upGrowthObject=new UpGrowth();
		        
		        HashSet<Integer> hashSetObject=new HashSet<Integer>();
		        
		        ResultSet rsF=null;
		        
		        ArrayList<UserProductBeans> ArruserProductBeansList=new ArrayList<UserProductBeans>();
								
				
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
					
					
					
					
				
					
					
					System.out.println("UserParamtre is "+userSearchBookBeans.getUser_paramertre());
					
					if(userSearchBookBeans.getUser_paramertre().equals("Hit")){
						
						/*RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByHit.jsp");
						rd.forward(request, response);*/
						
						while(rs1.next()){
							
							System.out.println("Product Is is ............ "+rs1.getInt(2));
							
						
							UserProductBeans userProductBeans=new UserProductBeans();
							
							rsF=userDao.userGetInfomationFinal(rs1.getInt(2));
							 
							 //id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, product_hit, product_Buy
							
							while(rsF.next())
							{
								
								//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, product_price
								
								
								
								userProductBeans.setId(rsF.getInt(1));
								
								String s1=String.valueOf(rsF.getInt(2));
								
								userProductBeans.setProduct_id(s1);
								
								userProductBeans.setProduct_name(rsF.getString(4));
								
								userProductBeans.setProduct_Brand(rsF.getString(3));
								
								userProductBeans.setProduct_SKU(rsF.getString(5));	
								
								userProductBeans.setProduct_SRP(rsF.getString(6));
								
								userProductBeans.setGross_weight(rsF.getString(7));
								
								userProductBeans.setNet_weight(rsF.getString(8));
								
								userProductBeans.setRecyclable_package(rsF.getString(9));
								
								userProductBeans.setLow_fat(rsF.getString(10));
								
								userProductBeans.setUnits_per_case(rsF.getString(11));
								
								userProductBeans.setCases_per_pallet(rsF.getString(12));
								
								userProductBeans.setShelf_width(rsF.getString(13));
								
								userProductBeans.setShelf_height(rsF.getString(14));
								
								userProductBeans.setShelf_depth(rsF.getString(15));

								userProductBeans.setProduct_price(rsF.getString(16));
								
							}
							
							ArruserProductBeansList.add(userProductBeans);
							
							
						}
						
						
						
						session7.setAttribute("ArruserProductBeansList", ArruserProductBeansList);
						
						// TKO Time 
						
						
						
						long timeTko2=System.currentTimeMillis();
						
						System.out.println("time 2 is "+timeTko2);
						
						
							
						long time1tko=(Long)session4.getAttribute("tkoTime1Session");
						
						System.out.println("time1tko is "+time1tko);
						
						long totalTko=timeTko2-time1tko;
						
						System.out.println("total time is  TKO ..........................."+totalTko);
						
						// TKO Time End
					
						// TKO Time Start
						
						long time2Tku=System.currentTimeMillis();
							
						System.out.println("time 2 of TKU .. is "+time2Tku);
						
						long time1Tku=(Long)session5.getAttribute("TKUTimeSession");
						
						System.out.println("time 1 of TKU is "+time1Tku);
						
						long totalTKU=time2Tku-time1Tku;
						
						System.out.println("total Time is TKU ...................  "+totalTKU);
							
						// TKU Time End 
						
						
						// TKO with TKU 
						
						long timeFinal2=System.currentTimeMillis();
						
						System.out.println("timeFinal2 of TKUWITHTKO algortihms is "+timeFinal2);
						
						long timeFinal11=(Long)session6.getAttribute("finalTime1Session");
						
						System.out.println("timeFinal1 of TKUWITHTKO algortihms is "+timeFinal1);
						
						long totalTimeMain=timeFinal2-timeFinal11;
						
						System.out.println("totalTimeMain of TKUWITHTKO algortihms is .................................... "+totalTimeMain);
						
						/*int n=userDao.userInsertGraphTable(userSearchBookBeans.getUser_top_k_value(), totalTko, totalTKU, totalTimeMain,userSearchBookBeans.getUser_category());
						
						System.out.println("Value of n is"+n);*/
						
						
						rs3=userDao.userGetTKUValueHit(userSearchBookBeans);
						
						session3.setAttribute("ResultFinalTKUHitSession", rs3);
						
						System.out.println("In Main Values ...");
						
                       int n=userDao.userMainResult(userSearchBookBeans.getUser_category(), userSearchBookBeans.getUser_top_k_value(), totalTimeMain);
						
                        System.out.println("Value og n is "+n);
						
		               RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByHitFinal.jsp");
					    
						rd.forward(request, response);
						
						
					}
					
					else
						
					{
						System.out.println("Buy is "+userSearchBookBeans.getUser_paramertre());
						
// TKO Time Start
						
	long timeFinal2=System.currentTimeMillis();
						
						System.out.println("timeFinal2 of TKUWITHTKO algortihms is "+timeFinal2);
						
						long timeFinal11=(Long)session6.getAttribute("finalTime1Session");
						
						System.out.println("timeFinal1 of TKUWITHTKO algortihms is "+timeFinal1);
						
						long totalTimeMain=timeFinal2-timeFinal11;
						
						System.out.println("total Time is TKU ...................  "+totalTimeMain);
						
						 int n=userDao.userMainResult(userSearchBookBeans.getUser_category(), userSearchBookBeans.getUser_top_k_value(), totalTimeMain);
							
	                        System.out.println("Value og n is "+n);
						
						
							
						// TKU Time End 
						
						
						RequestDispatcher rd=request.getRequestDispatcher("userAlgorithmTopkResultByBuyFinal.jsp");
					    
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

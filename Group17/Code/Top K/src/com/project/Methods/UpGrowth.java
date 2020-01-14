package com.project.Methods;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.beans.BookBeans;
import com.project.beans.UserBeans;
import com.project.connectionManger.ConnnectionUtil;

public class UpGrowth {

	
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";
	   
	   static String url;

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	
	
	   
	   
	
	   public int create_table_method(String table_name){
		   
		  int m=1;
		   Connection conn = null;
		   Statement stmt=null;
			
		   
		   String dataBase=ConnnectionUtil.DBName;
			
		   
		   System.out.println("In DataBAse Name is "+dataBase);
		   
		   url=DB_URL+dataBase;
		   
		   
			
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(url, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();
		      
		      ////id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, book_buy, book_hit
		      String sql = "CREATE TABLE "+ table_name  +
		                   "(id INTEGER not NULL AUTO_INCREMENT, " +
		    		       " product_id INTEGER(10)," + 
		                   " brand_name VARCHAR(100), " + 
		                   " product_name VARCHAR(100), " + 
		                   " SKU VARCHAR(500), " + 
		                   " SRP VARCHAR(100), " + 
		                   " gross_weirth VARCHAR(100), " + 
		                   " net_weigth VARCHAR(500), " + 
		                   " recylared VARCHAR(500), " + 
		                   " low_fat VARCHAR(500), " + 
		                   " units_pre VARCHAR(500), " + 
		                   " Case_pre VARCHAR(500), " + 
		                   " shelf_heigth VARCHAR(500), " + 
		                   " shelf_width VARCHAR(500), " + 
		                   " shelf_depth VARCHAR(500), " + 
		                   " product_hit INTEGER(10), " + 
		                   " product_Buy INTEGER(10), " + 
		                    " PRIMARY KEY ( id ))"; 

		      m=stmt.executeUpdate(sql);
		      System.out.println("Created table in given database...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return m;
	   }
		   
	public int upGrowthInsert(BookBeans bookBeans,int book_hit_count,String tableName)
	
	//id, product_id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth, book_hit
	{
		int m=1;
		
		Connection con=null;
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      con = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
			
			String sql="insert into"+tableName+"values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);

			ps.setInt(2, bookBeans.getBook_id());
			
			ps.setString(3, bookBeans.getBrand_name());
			
			ps.setString(4, bookBeans.getProduct_name());
			
			ps.setString(5, bookBeans.getSKU());
			
			ps.setString(6, bookBeans.getSRP());
			
			ps.setString(7, bookBeans.getGross_weirth());
			
			ps.setString(8, bookBeans.getNet_weigth());
			
			ps.setString(9, bookBeans.getRecylared());
			
			ps.setString(10, bookBeans.getLow_fat());
			
			ps.setString(11, bookBeans.getUnits_pre());
			
			ps.setString(12, bookBeans.getCase_pre());
			
			ps.setString(13, bookBeans.getUnits_pre());
			
			ps.setString(14, bookBeans.getShelf_heigth());
			
			ps.setString(15, bookBeans.getShelf_width());
			
			ps.setString(16, bookBeans.getShelf_depth());
			
            ps.setInt(17, 1);
            
            ps.setInt(18, 0);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      
		
		
		return m;
		
	}
	
	public ResultSet table_exits(String tableName)
	
	{
       ResultSet rs=null;	
		
       Connection con=ConnnectionUtil.getConnection();
       DatabaseMetaData dbm;
	   
			try {
			dbm = con.getMetaData();
			 rs = dbm.getTables(null, null, tableName, null);
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		return rs;
		
	}
	
	
}

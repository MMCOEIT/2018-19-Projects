package com.project.load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataSetLoad {

	
static String url="jdbc:mysql://localhost:3306/testgauri";
	
	static String username="root";
	
	static String password="root";
	
   public static void main(String[] argv) throws Exception {
	  
	  System.out.println("main_sites");
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement stmt = connection.createStatement();
    
    // Load the data
    String filename = "E:/TopK.txt";
    String tablename = "final_product_data_set ";
   stmt.executeUpdate("LOAD DATA INFILE \"" + filename + "\" INTO TABLE " + tablename);
   
//id, brand_name, product_name, SKU, SRP, gross_weirth, net_weigth, recylared, low_fat, units_pre, Case_pre, shelf_heigth, shelf_width, shelf_depth

   }
	
}

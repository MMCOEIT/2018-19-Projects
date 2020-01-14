package com.project.Methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
public class UpGrowthAlgorithms {

	
	// id, book_id, book_author, book_name, book_prices, book_buy, book_hit, book_cat
	
	String tableName=null;
	
	String Orcategory="category";
	
	UpGrowth upGrowth=new UpGrowth();
	
	public int UpGrowthMethods(String category,HashSet<String> hashset){
		
		int m=0;
		
		ResultSet rs=null;
		
		for(String al:hashset)
		{
		
		
		if(category.equalsIgnoreCase(al))
		{
			
			System.out.println("Found category is "+category);
			
			tableName=Orcategory+"_"+category;
			
			System.out.println("table name is "+tableName);
			
			rs=upGrowth.table_exits(tableName);
			
			try {
				if(rs.next()){
					
					System.out.println("rs value is not null");
					
					m=100;
					
					System.out.println("m value is 100"+m);
					
					break;
					
				}
				
				else
				{
					int h=upGrowth.create_table_method(tableName);
					
					System.out.println("Value of h"+h);
					
					m=200;
					
					break;
					
					
							
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
			m=1;
			
			break;
			
			
		} // end for if loop 
		
		
		else
		{
			System.out.println("Not Found!!!!!");
			
			m=0;
			
			
		}
		
		
		} // end for loop 
		return m;
		
		
		
	}
	
	
}

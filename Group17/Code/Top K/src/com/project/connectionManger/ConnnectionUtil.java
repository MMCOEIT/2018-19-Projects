package com.project.connectionManger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnnectionUtil {

	public static String DBName="topkfinal2018";
	
	public static String userName="root";
	
	public static String userPassword="root";
	
	public static String url="jdbc:mysql://localhost:3306/"+DBName;
	
	 static Connection con;
	
	public static Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(url, userName, userPassword);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}
	
	public String getDataBase()
	{
		return DBName;
		
	}
	
	
	
	
}

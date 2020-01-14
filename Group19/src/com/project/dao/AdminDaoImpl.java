package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.beans.AdminBeans;
import com.project.connectionManger.ConnnectionUtil;

public class AdminDaoImpl implements AdminDao {
	
	Connection con=ConnnectionUtil.getConnection();

	@Override
	public ResultSet adminLogin(AdminBeans adminBeans) {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from admin_reg where admin_name=? and  admin_password=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, adminBeans.getAdmin_name());
			
			ps.setString(2, adminBeans.getAdmin_password());
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return rs;
	}

	@Override
	public ResultSet adminSelectBookCategory() {
		// book_title, book_category, book_author, book_price, id
		
				ResultSet rs=null;
				
				String sql="Select * from book_data_set";
				
				try {
					PreparedStatement ps= con.prepareStatement(sql);
					
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				return rs;
	}

	@Override
	public ResultSet adminGetResult() {
		ResultSet rs=null;
		
		String sql="select * from tko_result LIMIT 5";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet adminCheckRecords() {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		
		String sql="Select * from final_result_table";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rs;
	}

	@Override
	public int adminTruncateTable() {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="Truncate table final_result_table";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			n=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public int adminInsertRecords(long tkoTime, long tkuTime,
			long tkoWithTkuTime) {
		// TODO Auto-generated method stub
		
		int n=1;
		
		String sql="insert into final_result_table values(?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			
			ps.setLong(2, tkoTime);
			
			ps.setLong(3, tkuTime);
			
			ps.setLong(4, tkoWithTkuTime);
			
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return n;
	}

	@Override
	public ResultSet adminGetResultTKU() {
        ResultSet rs=null;
		
		String sql="select * from tku_result LIMIT 5";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

	@Override
	public ResultSet adminGetResultmain() {
ResultSet rs=null;
		
		String sql="select * from main_result LIMIT 5";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}

}

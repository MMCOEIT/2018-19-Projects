package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.AddLocationBean;
import com.bean.UserBean;
import com.connection.DBConnection;

public class AdminDao {
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    boolean flag = false;
	public ArrayList<UserBean> getFriend(String friendname) throws SQLException
	{
		
		String sql="select * from tbl_user where name=?";
		connection=DBConnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setString(1, friendname);
		ArrayList<UserBean> friendList=new ArrayList<UserBean>();
		rs=ps.executeQuery();
		while(rs.next())
		{
			UserBean bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setMobileno(rs.getString(5));
			bean.setImage(rs.getBinaryStream(8));
		friendList.add(bean);
		}
		return friendList;
		
	}
	
	
	public boolean InsertLocationData(AddLocationBean userbean) {
		 
		String sql = "insert into tbl_location(location,name,type,address,city,country,image,image_name,rank,lat,log) values(?,?,?,?,?,?,?,?,?,?,?) ";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, userbean.getLocation());
			ps.setString(2, userbean.getLoc_name());
			ps.setString(3, userbean.getLoc_type());
			ps.setString(4, userbean.getLoc_address());
			ps.setString(5, userbean.getCity());
			ps.setString(6, userbean.getCountry());
			ps.setBlob(7, userbean.getImage());
			ps.setString(8, userbean.getImage_name());
			ps.setString(9, userbean.getRank());
			ps.setString(10, userbean.getLat());
			ps.setString(11, userbean.getLog());
			
			int index = ps.executeUpdate();

			if (index > 0) {
				resultStatus = true;
			} else {
				resultStatus = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return resultStatus;
	}
	
	 public boolean UpdateAdminPassword(String oldpass,String newpass) {
			
			String sql="update tbl_admin set password=? where password='"+oldpass+"'";
			
			Connection con = DBConnection.getConnection();
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, newpass);
				
				int index=ps.executeUpdate();
				
				if(index>0)
				{
					flag=true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return flag;
		}
	 
	 public UserBean SelectAdminPassword(String email) {
			
			UserBean bean=new UserBean();
			
			String sql = "select * from tbl_admin where email='" + email + "'";

			Connection con = DBConnection.getConnection();

			try {
				ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					
					bean.setPassword(rs.getString(3));
					
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return bean;
			
		}
}

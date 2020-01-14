package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.Part;

import com.bean.TitleBean;
import com.bean.UserBean;
import com.connection.DBConnection;

public class UserDao {
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    String sql;
    boolean flag = false;
    
	 public String extractFileName(Part part) {
			String contentDisp = part.getHeader("content-disposition");
	        System.out.println("contentDisp:"+contentDisp);
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
		}
	 
	 public boolean InsertUserData(UserBean userbean) {
			sql = "insert into tbl_user(name,address,email,mobileno,dob,password,status,image,imagename) values(?,?,?,?,?,?,?,?,?)";

			Connection con = DBConnection.getConnection();

			try {
				ps = con.prepareStatement(sql);

				ps.setString(1, userbean.getName());
				ps.setString(2, userbean.getAddress());
				ps.setString(3, userbean.getEmail());
				ps.setString(4, userbean.getMobileno());
				ps.setString(5, userbean.getDob());
				ps.setString(6, userbean.getPassword());
				ps.setString(7, userbean.getStatus());
				ps.setBlob(8, userbean.getImage());
				ps.setString(9, userbean.getImage_name());

				int index = ps.executeUpdate();

				if (index > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return flag;
		}
	 
	 public boolean alreadyUser(String email) throws SQLException {
			String sql="select * from tbl_user where email=?";
			connection=DBConnection.getConnection();
			ps=connection.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				resultStatus=true;
			}
			return resultStatus;
		}
		
	 public UserBean CheckUser(String email, String password) {
			
			UserBean bean=new UserBean();
			sql = "select * from tbl_user where email='" + email + "' and password='" + password + "' ";
			try {
				Statement stmt = DBConnection.getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				if (rs.next()) {
					
					bean.setName(rs.getString(2));
					bean.setAddress(rs.getString(3));
					bean.setEmail(rs.getString(4));
					bean.setMobileno(rs.getString(5));
					bean.setDob(rs.getString(6));
					bean.setPassword(rs.getString(7));
					bean.setStatus(rs.getString(8));
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

			return bean;
		}
	 
	 public boolean UpdateUserPassword(String oldpass,String newpass) {
			
			sql="update tbl_user set password=? where password='"+oldpass+"'";
			
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
	 
	 public boolean UpdateUserStatus(int userId, String status) {
			if(status.equalsIgnoreCase("Inactive"))
				status="Active";
			else
				status="Inactive";
			
			String sql="update tbl_user set status=? where id=?";
			
			try {
				ps=DBConnection.getConnection().prepareStatement(sql);
				ps.setString(1, status);
				ps.setInt(2, userId);
				
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
	 
	 public ResultSet SelectUser() {
			
			ResultSet rs= null;
			String sql ="Select * from tbl_user";
			try {
				PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
	 
	 public boolean DeleteUser(int id) {
			
			String sql="delete from tbl_user where id='"+id+"'";
			 Connection con=DBConnection.getConnection();
			 try {
				ps=con.prepareStatement(sql);
				int index =ps.executeUpdate();
				if(index>0)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
				return flag;
		}
	 
	 public UserBean SelectUserPassword(String email) {
			
			UserBean bean=new UserBean();
			
			sql = "select * from tbl_user where email='" + email + "'";

			Connection con = DBConnection.getConnection();

			try {
				ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					bean.setName(rs.getString(2));
					bean.setAddress(rs.getString(3));
					bean.setEmail(rs.getString(4));
					bean.setMobileno(rs.getString(5));
					bean.setDob(rs.getString(6));
					bean.setPassword(rs.getString(7));
					bean.setStatus(rs.getString(8));
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return bean;
			
		}
	 
	 public boolean alreadyImage(String image_name) throws SQLException {
			String sql="select * from tbl_images where image_name=?";
			connection=DBConnection.getConnection();
			ps=connection.prepareStatement(sql);
			ps.setString(1, image_name);
			rs=ps.executeQuery();
			if(rs.next())
			{
				resultStatus=true;
			}
			return resultStatus;
		}
	 
	 public ArrayList<TitleBean> getCategory() throws SQLException{
			
			String sql="select * from tbl_title";
			Connection con=DBConnection.getConnection();
			
			ArrayList<TitleBean> titleList=new ArrayList<TitleBean>();
			
			Statement st=con.createStatement();
			
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				TitleBean bean=new TitleBean();
				
				bean.setId(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				
				titleList.add(bean);
			}
			
			
			return titleList;
		}
	
	 public static ResultSet getfile(String filename) 
		{
			ResultSet rs = null;
		try
		{
			Connection conn=DBConnection.getConnection();
				Statement stmt=conn.createStatement();
				rs=stmt.executeQuery("select * from query_images where image_name='"+filename+"'");	
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
}

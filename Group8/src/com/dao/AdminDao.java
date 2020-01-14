package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.bean.UserBean;
import com.connection.DBConnection;

public class AdminDao {
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
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
	
	public int getFriendId(String friendEmail) throws SQLException {
		String sql="select * from tbl_user where email=?";
		connection=DBConnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setString(1, friendEmail);
		int friendId=0;
		rs=ps.executeQuery();
		if(rs.next())
		{
			friendId=rs.getInt(1);
		}
		connection.close();
		return friendId;
	}
	
	public ArrayList<UserBean> getRequestedFriends(int useridl,
			String status) throws SQLException {
		String sql="SELECT * FROM tbl_user inner join tbl_friendrequest on tbl_friendrequest.friendid=tbl_user.id where  tbl_friendrequest.userid=? and tbl_friendrequest.status=?";
		ArrayList<UserBean> friendList=new ArrayList<UserBean>();
		connection=DBConnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setInt(1, useridl);
		ps.setString(2, status);
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
			bean.setImage_name(rs.getString(9));
			friendList.add(bean);
		}
		connection.close();
		return friendList;
	}
	
	public ArrayList<UserBean> getAllFriend(int userid, String status) throws SQLException {
		String sql="SELECT * FROM tbl_user inner join tbl_friendrequest on tbl_friendrequest.friendid=tbl_user.id where  tbl_friendrequest.userid=? and tbl_friendrequest.status=?";
		ArrayList<UserBean> friendList=new ArrayList<UserBean>();
		connection=DBConnection.getConnection();
		ps=connection.prepareStatement(sql);
		ps.setInt(1, userid);
		ps.setString(2, status);
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
			bean.setImage_name(rs.getString(9));
			friendList.add(bean);
		}
		connection.close();
		return friendList;
	}
	
	
	
	
}

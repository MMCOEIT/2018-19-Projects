package com.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.mail.Flags.Flag;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.chainsaw.Main;

import com.model.AllAnswerData;
import com.model.FtachSpecificCommunityAnswerdata;
import com.model.Notifiedqestion;
import com.model.Qestionstoredatabase;
import com.model.RealQestion;
import com.model.addkeyworddata;
import com.model.adduserdata;
import com.model.admindata;
import com.model.answernounmodel;
import com.model.checkqestion;
import com.model.checkqestiondata;
import com.model.expert;
import com.model.findnoun;
import com.model.likewordnoun;
import com.model.finalcomunity;
import com.model.findBestAnswer;
import com.model.ratingadd;
import com.model.topexpert;

public class DataAccessLayer
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/tusharnemade?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	public static Connection makeConnection()
	{
		Connection con = null;
		try 
		{
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void qestion(String word, String pos)
	{
		
		int flag = 0;
		Connection con = makeConnection();
		PreparedStatement pstm = null;
		try
		{
			
			String sql = "insert  into qestion (word,pos) values(?,?)"; 
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, word);
			pstm.setString(2, pos);
			
		    int i = pstm.executeUpdate();
			if (i == 1)
			flag = 1;
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally 
		{
			if (con != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pstm != null)
			{
				try
				{
					pstm.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void realqestion(RealQestion rq)
	{
		
		//SELECT * FROM qestion WHERE pos LIKE 'NN%';
		int flag = 0;
		Connection con = makeConnection();
		PreparedStatement pstm = null;
		try 
		{
			
			String sql = "insert  into realqestion(qestion)values(?)"; 
			pstm = con.prepareStatement(sql);	
			pstm.setString(1, rq.getQestion());
			
		    int i = pstm.executeUpdate();
			if (i == 1)
			flag = 1;
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally 
		{
			if (con != null) 
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pstm != null) 
			{
				try
				{
					pstm.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static List<findnoun> fatchnounkeyword() throws IOException
	{
		List<findnoun> list=new ArrayList<findnoun>();
		int flag = 0;
		BufferedImage image = null;
		Connection con = makeConnection();
		HttpServletRequest request = null;
			PreparedStatement pstm = null;
		
			try 
			{
			
				String sql = "SELECT * FROM qestion WHERE pos LIKE 'NN%'";
				
				java.sql.Statement stmt = null;
				ResultSet rs = con.createStatement().executeQuery(sql);
				
				
				while(rs.next())
				{
					findnoun findnoun = new findnoun();
					
					findnoun.setWord(rs.getString("word"));
					findnoun.setNoun(rs.getString("pos"));
					
					list.add(findnoun);
				}
				int i = findnoun.executeUpdate();
				if (i == 1)
					flag = 1;

		} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
		finally 
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pstm != null)
			{
				try
				{
					pstm.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return list;
	}

      public static void  finalkeyword(likewordnoun fn)
      {
		//id, word, noun
		//SELECT * FROM qestion WHERE pos LIKE 'NN%';
		int flag = 0;
		Connection con = makeConnection();
		PreparedStatement pstm = null;
		try
		{
			
			String sql = "insert  into likewordnoun(word)values(?)"; 
			pstm = con.prepareStatement(sql);
			
		
			
			pstm.setString(1, fn.getFinalkeywordword());
			//pstm.setString(2, fn.getNoun());
			
		    int i = pstm.executeUpdate();
			if (i == 1)
			flag = 1;
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if (pstm != null)
			{
				try 
				{
					pstm.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
      
      public static finalcomunity finalcomunitymethod(String val) throws IOException
      {
    	  finalcomunity f = new finalcomunity();
  		int flag = 0 ;
  		int value =0;
  		BufferedImage image = null;
  		Connection con = makeConnection();
  		HttpServletRequest request = null;
  			PreparedStatement pstm = null;
  		
  			try
  			{
  			
	  			String sql = "SELECT * FROM comunity WHERE keyword LIKE  '%" + val + "%'";
	  			
	  			java.sql.Statement stmt = null;
	  			ResultSet rs = con.createStatement().executeQuery(sql);
	  			while(rs.next())
	  			{
	  			      f.setOutputid(rs.getInt("cid"));
	  			      
	  			       f.setCkeyword(rs.getString("keyword"));
	  			     value = f.getOutputid();
	  			     System.out.println(" op cid---->"+value);
	  			   System.out.println(" op Ckeyword---->"+f.getCkeyword());
	  			     
	  			}
	  			int i = finalcomunity.executeUpdate();
	  			
	  			
	  			if (i == 1)
	  				flag = value ;
	
  			}
  			catch (SQLException e) 
  			{
  				e.printStackTrace();
  			}
  		
  		finally 
  		{
  			if (con != null)
  			{
  				try
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  			if (pstm != null) {
  				try 
  				{
  					pstm.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  		}
  		return f;
  	} 
      
      
      public static void deleteqestion()
      {
  		
  		
  		int flag = 0;
  		Connection con = makeConnection();
  		PreparedStatement pstm = null;
  		try 
  		{
  			
  			String sql = "delete FROM qestion";

  			pstm = con.prepareStatement(sql);
  			
  		    int i = pstm.executeUpdate();
  			if (i == 1)
  			flag = 1;
  			
  		}
  		catch (SQLException e) 
  		{
  			e.printStackTrace();
  		}
  		
  		finally 
  		{
  			if (con != null)
  			{
  				try 
  				{
  					con.close();
  				} catch (SQLException e) 
  				{
  					e.printStackTrace();
  				}
  			}
  			if (pstm != null) 
  			{
  				try
  				{
  					pstm.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  		}
  		
  	}
   
      public static void adduser(adduserdata ad)
      {
    		
  		int i = 0;
  		Connection con = makeConnection();
  		PreparedStatement pstm = null;
  		try
  		{
  			//id, name, email, password, cpassword
  			String sql = "insert  into adduser (community) values(?)"; 
  			pstm = con.prepareStatement(sql);
  			
  			/*pstm.setString(1, ad.getName());
  			pstm.setString(2, ad.getEmail());
  			pstm.setString(3, ad.getPassword());
  			pstm.setString(4, ad.getCpassword());*/
  			pstm.setInt(1, ad.getCommunity());
  			
  			i = pstm.executeUpdate();
  			if (i == 1)
  				System.out.println("Added");
  			
  			
  		}
  		catch (SQLException e)
  		{
  			e.printStackTrace();
  		}
  		
  		finally
  		{
  			if (con != null)
  			{
  				try
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  			if (pstm != null)
  			{
  				try
  				{
  					pstm.close();
  				} 
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  		}
  		
  	}
     
      public static int authenticateAdmin(adduserdata adduser) 
      {
    		int AdminID = 0;
    		int communityid =0;
    	//id, name, email, password, cpassword
    		String sql = "select * from adduser where name=? and password=?";
    		
    		Connection con = makeConnection();
    		
    		PreparedStatement pstm = null;
    		ResultSet rs = null;
    		try
    		//id, name, email, password, cpassword, community
    		{
    			pstm = con.prepareStatement(sql);
    			pstm.setString(1, adduser.getName());
    			pstm.setString(2, adduser.getPassword());
    		
    			rs = pstm.executeQuery();
    			
    			while (rs.next())
    				
    			{
    				AdminID = rs.getInt("id");
    				communityid = rs.getInt("community");
    				
    			}
    		} 
    		catch (SQLException e)
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		finally
    		{
    			if (con != null)
    			{
    				try
    				{
    					con.close();
    				}
    				catch (SQLException e)
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			if (pstm != null)
    			{
    				try
    				{
    					pstm.close();
    				}
    				catch (SQLException e) 
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			if (rs != null)
    			{
    				try
    				{
    					rs.close();
    				} 
    				catch (SQLException e) 
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    		return communityid;
    	}
      
      
      public static void QestionStoreDatabase(Qestionstoredatabase qd) 
      {
    	  
  		int flag = 0;
  		Connection con = makeConnection();
  		PreparedStatement pstm = null;
  		try
  		{
  			
  			String sql = "insert  into qestionstoredatabase(qestion,qid) values(?,?)"; 
  			pstm = con.prepareStatement(sql);
  			
  		   pstm.setString(1,qd.getQestion());
  		   pstm.setInt(2,qd.getQid());
  			
  			
  		    int i = pstm.executeUpdate();
  			if (i == 1)
  			flag = 1;
  			
  		}
  		catch (SQLException e) 
  		{
  			e.printStackTrace();
  		}
  		
  		finally
  		{
  			if (con != null) 
  			{
  				try
  				{
  					con.close();
  				} 
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  			if (pstm != null)
  			{
  				try
  				{
  					pstm.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  		}
  		
  	}
      
	public static List<Qestionstoredatabase> fatchqestion(int qid)
	{
    	 
    	  
  		List<Qestionstoredatabase> list = new ArrayList<Qestionstoredatabase>();
  	//id, name, email, password, cpassword
  		String sql = "select * from qestionstoredatabase where qid=?";
  		
  		Connection con = makeConnection();
  		
  		PreparedStatement pstm = null;
  		
  		
  		try 
		{

			PreparedStatement pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, qid);
			System.out.println("id : "+qid);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			{
				
				Qestionstoredatabase qa = new Qestionstoredatabase();
				qa.setId(rs.getInt("id"));
				qa.setQestion(rs.getString("qestion"));
				qa.setQid(rs.getInt("qid"));
				
				list.add(qa);	
				
			}
  			
  		} 
  		catch (SQLException e)
  		{
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		finally 
  		{
  			if (con != null)
  			{
  				try 
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		}
		return list;
  		
  	}   
      
	public static List<Qestionstoredatabase> giveanswer(int id)
	{
   	 
		List<Qestionstoredatabase> list = new ArrayList<Qestionstoredatabase>();
  	//id, name, email, password, cpassword
  		String sql = "select * from qestionstoredatabase where id=?";
  		
  		Connection con = makeConnection();
  		
  		PreparedStatement pstm = null;
  		
    	try 
		{

			PreparedStatement pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, id);
			System.out.println("id : "+id);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			
			{
				
				Qestionstoredatabase qa = new Qestionstoredatabase();
				
				qa.setId(rs.getInt("id"));
				qa.setQestion(rs.getString("qestion"));
				qa.setQid(rs.getInt("qid"));
				
				list.add(qa);	
				
			}
  		} 
  		catch (SQLException e)
  		{
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		finally
  		{
  			if (con != null)
  			{
  				try
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		}
		return list;
  		
  	}   
      	
	
public static void AllAnswerdata(AllAnswerData ad)
{
    	  //id, qestion, answer, aid
  		int flag = 0;
  		Connection con = makeConnection();
  		PreparedStatement pstm = null;
  		try 
  		{
  			//expertname
  			String sql = "insert  into allanswerdata(qestion,answer,aid,expertname) values(?,?,?,?)"; 
  			
  			pstm = con.prepareStatement(sql);
  			
  		    pstm.setString(1,ad.getQestion());
  	     	 pstm.setString(2,ad.getAnswer());
  		      pstm.setInt(3,ad.getAid());
  			pstm.setString(4,ad.getExpertname());
  			
  		      
  		      
  		    int i = pstm.executeUpdate();
  			if (i == 1)
  			flag = 1;
  			
  		}
  		catch (SQLException e)
  		{
  			e.printStackTrace();
  		}
  		
  		finally
  		{
  			if (con != null)
  			{
  				try
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					e.printStackTrace();
  				}
  			}
  			if (pstm != null) 
  			{
  				try
  				{
  					pstm.close();
  				}
  				catch (SQLException e) 
  				{
  					e.printStackTrace();
  				}
  			}
  		}
  		
  	}
      
     
public static List<FtachSpecificCommunityAnswerdata> FtachSpecificCommunityAnswer(int aid) 

 {
  	 
 List<FtachSpecificCommunityAnswerdata> list = new ArrayList<FtachSpecificCommunityAnswerdata>();
 	
      String sql = "select * from allanswerdata where aid=? LIMIT 5";
 		
 		Connection con = makeConnection();
 		
 		PreparedStatement pstm = null;
 		
 		try 
		{

			PreparedStatement pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, aid);
			
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			{
				
				FtachSpecificCommunityAnswerdata qa = new FtachSpecificCommunityAnswerdata();
				
				
				qa.setId(rs.getInt("id"));
				qa.setQestion(rs.getString("qestion"));
				qa.setAnswer(rs.getString("answer"));
				qa.setExpertname(rs.getString("expertname"));
				
				
				
				list.add(qa);	
				
			}
			
			//id, qestion, answer, aid, expertname
         }
 		catch (SQLException e)
 		{
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		finally 
 		{
 			if (con != null)
 			{
 				try
 				{
 					con.close();
 				}
 				catch (SQLException e) 
 				{
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
 		}
		return list;
 		
 	}

public static void ratingadd(ratingadd ad)
    
{
	 int flag = 0;
	 Connection con = makeConnection();
	 PreparedStatement pstm = null;
	 try
	 {
		
 String sql = "insert  into addrating(username,rating,qestion,answer,qestionid,answerid,expertgiveratingname) values(?,?,?,?,?,?,?)"; 
		
       //id, username, rating, qestion, answer, qestionid, answerid
	    //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
       
      pstm = con.prepareStatement(sql);
	   
       pstm.setString(1,ad.getUsername());
	   pstm.setInt(2,ad.getRating());
	   pstm.setString(3,ad.getQestion());
	   pstm.setString(4,ad.getAnswer());
	   pstm.setInt(5, ad.getQestionid());
	   pstm.setInt(6, ad.getAnswerid());
	   pstm.setString(7, ad.getExpertrname());
	   
	   
	   int i = pstm.executeUpdate();
		
	   if (i == 1)
		flag = 1;
		
	}
	
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally
	
	{
		if (con != null)
		{
			try 
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
	
public static List<ratingadd> ratingdisplay() 
 {
 
	List<ratingadd> list = new ArrayList<ratingadd>();
	 
	String sql = "SELECT * FROM addrating ORDER BY rating DESC";
		
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		try 
		{

			PreparedStatement pstm1 = con.prepareStatement(sql);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next()) 
			{
				
				ratingadd qa = new ratingadd();
				
				qa.setUsername(rs.getString("username"));
				qa.setQestion(rs.getString("qestion"));
				qa.setAnswer(rs.getString("answer"));
				qa.setRating(rs.getInt("rating"));
				
				
				list.add(qa);	
				
			}
			//id, username, rating, qestion, answer
			
        }
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return list;
		
	}   




public static void addkeyword(addkeyworddata ad)
{
	 
	int flag = 0;
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try
	{
		//id, cid, keyword
		String sql = "insert  into comunity(cid,keyword) values(?,?)"; 
		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, ad.getCid());
	   pstm.setString(2,ad.getKeyword());
	  
	   
	   int i = pstm.executeUpdate();
		if (i == 1)
		flag = 1;
		
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		if (con != null)
		{
			try 
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}
public static int adminLogin(admindata ad) 
{
		int id= 0;
		
		String sql = "select * from admin where name=? and password=?";
		
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		try
		
		{
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ad.getName());
			pstm.setString(2, ad.getPassword());
		
			rs = pstm.executeQuery();
			
			while (rs.next())
				
			{
				id = rs.getInt("id");
	
				
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null)
			{
				try
				{
					pstm.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null)
			{
				try
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return id;
	}
	
public static void answernoun(String word, String pos)
{
	
	int flag = 0;
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try
	
	{
		
		String sql = "insert  into answernoun (word,pos) values(?,?)"; 
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, word);
		pstm.setString(2, pos);
		
	    int i = pstm.executeUpdate();
		if (i == 1)
		flag = 1;
		
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally 
	{
		if (con != null) 
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}


public static List<answernounmodel> answernoundata() throws IOException
{
	List<answernounmodel> list = new ArrayList<answernounmodel>();
	int flag = 0;
	BufferedImage image = null;
	Connection con = makeConnection();
	HttpServletRequest request = null;
		PreparedStatement pstm = null;
	
		try 
		{
		
			String sql = "SELECT * FROM answernoun WHERE pos LIKE 'NN%'";
			
			java.sql.Statement stmt = null;
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next())
			{
				answernounmodel findnoun = new answernounmodel();
				
				findnoun.setWord(rs.getString("word"));
				
				
				list.add(findnoun);
			}
			int i = findnoun.executeUpdate();
			if (i == 1)
				flag = 1;

	} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
	finally 
	{
		if (con != null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	return list;
}

public static void deleteanswernoun()
{
	
	
	int flag = 0;
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try 
	{
		
		String sql = "delete FROM answernoun";

		pstm = con.prepareStatement(sql);
		
	    int i = pstm.executeUpdate();
		if (i == 1)
		flag = 1;
		
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
	finally 
	{
		if (con != null)
		{
			try 
			{
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if (pstm != null) 
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}


public static int checkexpertvalidanswer(String val) throws IOException
{
	int value = 0;
	    Connection con = makeConnection();
	    
		PreparedStatement pstm = null;
	
		try
		{
			
	
		String sql = "SELECT * FROM likewordnoun WHERE word LIKE  '%" + val + "%'";
			
			java.sql.Statement stmt = null;
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next())
			{
				
			      
			int	idvalue = rs.getInt("id");
				
				value++;
			     
			}
			
			//System.out.println("id------>"+value);
			
			}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	finally 
	{
		if (con != null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null) {
			try 
			{
				pstm.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	return value;
} 


  public static void addexpert(expert ex)

  {
	
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try
	
	{
	//cid, username, password, email, cpassword, testresult	
		
		
		
		String sql = "insert  into expert (cid,username,password,email,cpassword,testresult) values(?,?,?,?,?,?)"; 
		pstm = con.prepareStatement(sql);
		
	    pstm.setInt(1, ex.getCid());
	    pstm.setString(2, ex.getUsername());
	    pstm.setString(3, ex.getPassword());
	    pstm.setString(4, ex.getEmail());
	    pstm.setString(5, ex.getCpassword());
	    pstm.setInt(6,ex.getTestresult());
	
         pstm.executeUpdate();
		
		
		
	}
	
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally 
	{
		if (con != null) 
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}

  
	public static int authenticateexpert(expert expert) {
		
		int expertid = 0;
		
		//id, cid, username, password, email, cpassword, testresult
		
		String sql = "select * from expert where username=? and password=?";
		
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try 
		{
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, expert.getUsername());
			pstm.setString(2, expert.getPassword());
			
			
			rs = pstm.executeQuery();
			
			
			while (rs.next()) 
			{
				expertid = rs.getInt("cid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return expertid;
}

  public static List<checkqestion> checkqestionavailableornot(String qestion) {
    		
	      List<checkqestion> list = new ArrayList<checkqestion>();
	      
      String sql = "select * from allanswerdata where qestion=?";
    		
    		Connection con = makeConnection();
    		
    		PreparedStatement pstm = null;
    		ResultSet rs = null;
    		
    		try
    		//id, name, email, password, cpassword, community
    		{
    			pstm = con.prepareStatement(sql);
    			
    			pstm.setString(1, qestion);
    			
                 rs = pstm.executeQuery();
    			
    			while (rs.next())
    				
    			{
    				//id, qestion, answer, aid
    				//id, qestion, answer, aid, expertname
    				
    				checkqestion ch = new checkqestion();
    				
    				ch.setId(rs.getInt("id"));
    				ch.setAid(rs.getInt("aid"));
    				ch.setQestion(rs.getString("qestion"));
    				ch.setAnswer(rs.getString("answer"));
    				ch.setExpertname(rs.getString("expertname"));
    				
    				list.add(ch);
    				System.out.println("id-->"+ch.getId());
    				System.out.println("qestion-->"+ch.getQestion());
    				System.out.println("answer--->"+ch.getAnswer());
    				
    			}
    		} 
    		
    		catch (SQLException e)
    		
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		finally
    		{
    			if (con != null)
    			{
    				try
    				{
    					con.close();
    				}
    				catch (SQLException e)
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			if (pstm != null)
    			{
    				try
    				{
    					pstm.close();
    				}
    				catch (SQLException e) 
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			if (rs != null)
    			{
    				try
    				{
    					rs.close();
    				} 
    				catch (SQLException e) 
    				{
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    		return list;
    	}
      
  
public static void allreadyavailableqestion(checkqestiondata cdata) 

{
	//id, qestion, answer
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try
	{
		String sql = "insert  into insertcheckqestion (qestion,answer, expert) values(?,?,?)"; 
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, cdata.getQestion());
	    pstm.setString(2, cdata.getAnswer());
	    pstm.setString(3, cdata.getExpert());
	    
	    pstm.executeUpdate();
		
	}
	
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	finally 
	{
		if (con != null) 
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (pstm != null)
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	
	}
	
}

public static List<checkqestiondata> fatchallreadyavailableqestion() {
	
    List<checkqestiondata> list = new ArrayList<checkqestiondata>();
    
     String sql = "select * from insertcheckqestion";
		
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			pstm = con.prepareStatement(sql);
			
			
			
           rs = pstm.executeQuery();
			
			while (rs.next())
				
			{
				//id, qestion, answer//id, qestion, answer, expert
				checkqestiondata ch = new checkqestiondata();
				
				ch.setQestion(rs.getString("qestion"));
				ch.setAnswer(rs.getString("answer"));
				ch.setExpert(rs.getString("expert"));
				
				list.add(ch);
				
				
			}
		} 
		
		catch (SQLException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null)
			{
				try
				{
					pstm.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null)
			{
				try
				{
					rs.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

public static void deleteinsertcheckqestion()
{
	int flag = 0;
	Connection con = makeConnection();
	PreparedStatement pstm = null;
	try 
	{
		
   String sql = "delete FROM insertcheckqestion";
   pstm = con.prepareStatement(sql);
	int i = pstm.executeUpdate();
		if (i == 1)
		flag = 1;
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
	finally 
	{
		if (con != null)
		{
			try 
			{
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		if (pstm != null) 
		{
			try
			{
				pstm.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}

   public static String getqestioninsertcheckqestion() {
	
	String avialableqestion = null;
	Connection con = makeConnection();
	
	try {
		//id, qestion, answer
		ResultSet rs2 = con.createStatement()
				.executeQuery("SELECT DISTINCT qestion FROM insertcheckqestion");
		while (rs2.next()) {
			
		avialableqestion = rs2.getString("qestion");
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return avialableqestion;

}
	public static List<expert> fatchexpert(int cid)
	{
   	 List<expert> list = new ArrayList<expert>();
 	String sql = "select * from expert where cid=?";
       Connection con = makeConnection();
 		PreparedStatement pstm = null;
 		try 
		{
            //id, cid, username, password, email, cpassword, testresult
			PreparedStatement pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, cid);
			
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			{
				
				expert qa = new expert();
				
				
				qa.setEmail(rs.getString("email"));
				
				list.add(qa);	
				
			}
 			
 		} 
 		catch (SQLException e)
 		{
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		finally 
 		{
 			if (con != null)
 			{
 				try 
 				{
 					con.close();
 				}
 				catch (SQLException e)
 				{
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
 		}
		return list;
 		//
 	}   
     
	public static List<String> gettopexpert() {
		
		List<String>list = new ArrayList<>();
		
		String expert = null;
		Connection con = makeConnection();
		
		try {
			
			ResultSet rs2 = con.createStatement()
					.executeQuery("SELECT DISTINCT username  FROM addrating where rating = 5");
			while (rs2.next()) {
				
				expert = rs2.getString("username");
				
				list.add(expert);
				 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
  }
	
  public static int validexpertaddrating(String expertgiveratingname,int qestionid, int answerid) 
    {
	
   //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname	  
	  
	    int id = 0;
  		
	    String sql = "select * from addrating where expertgiveratingname=? and qestionid=? and answerid=?";
  		Connection con = makeConnection();
  		PreparedStatement pstm = null;
  		ResultSet rs = null;
  		
  		try
  		   
  		{
  			pstm = con.prepareStatement(sql);
  			pstm.setString(1,expertgiveratingname);
  			pstm.setInt(2,qestionid );
  			pstm.setInt(3,answerid);
  		
  			rs = pstm.executeQuery();
  			
  			while (rs.next())
  				
  			{
  				id = rs.getInt("id");
  				
  				System.out.println("id-->"+id);
  				
  			}
  		}
  		
  		catch (SQLException e)
  		
  		{
  			// TODO Auto-generated catch block
  			
  			e.printStackTrace();
  		}
  		
  		finally
  		{
  			if (con != null)
  			{
  				try
  				{
  					con.close();
  				}
  				catch (SQLException e)
  				{
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  			
  			if (pstm != null)
  			
  			{
  				try
  				{
  					pstm.close();
  				}
  				catch (SQLException e) 
  				{
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  			if (rs != null)
  			{
  				try
  				{
  					rs.close();
  				} 
  				catch (SQLException e) 
  				{
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		}
  		
  		return id;
  	}
	
  public static int updateRating(int id, int rating) 
  
  {
	  //id, username, rating, qestion, answer, qestionid, answerid
	   
	    int i=0;
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		
		String sql = "Update addrating set rating=? where id="+id;
		
		try {
			
		 pstm = con.prepareStatement(sql);
		
		 pstm.setInt(1,rating);
			
	
		i = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	} 
 
 public static List<String> disexpert() {
		//id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
		
	 List<String>list = new ArrayList<>();
		
		String expert = null;
		Connection con = makeConnection();
		
		try {
			
			ResultSet rs2 = con.createStatement()
					.executeQuery("SELECT  DISTINCT answer FROM addrating");
			while (rs2.next()) {
				
				System.out.println("answer-->"+rs2.getString("answer"));
				System.out.println("username-->"+rs2.getString("username"));
				//list.add(expert);
				 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
   }
  
 public static String Notifiyadmin(int id)
{
	 String question = null;
 	String sql = "select * from qestionstoredatabase where id=?";
    
	    Connection con = makeConnection();
		PreparedStatement pstm = null;
		try 
		
		{
			//id, qestion, qid
			
			PreparedStatement pstm1 = con.prepareStatement(sql);
			pstm1.setInt(1, id);
			
			ResultSet rs = pstm1.executeQuery();
              while (rs.next())
			
              {
				
            question = rs.getString("qestion");
				
				
				
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if (con != null)
			{
				try 
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return question;
		
}   
  
 public static void qestionsendtonotifiyadmin(String notifiyqestion) 
   {
 	//id, qestion, answerid, question
 	Connection con = makeConnection();
 	PreparedStatement pstm = null;
 	try
 	{
 		String sql = "insert  into notifiyadmin (question) values(?)"; 
 		
 		pstm = con.prepareStatement(sql);
 		
 		pstm.setString(1,notifiyqestion);
 		
 	    pstm.executeUpdate();
 		
 	}
 	
 	catch (SQLException e)
 	{
 		e.printStackTrace();
 	}
 	
 	finally 
 	{
 		if (con != null) 
 		{
 			try
 			{
 				con.close();
 			}
 			catch (SQLException e)
 			{
 				e.printStackTrace();
 			}
 		}
 		
 		if (pstm != null)
 		
 		{
 			try
 			{
 				pstm.close();
 			}
 			catch (SQLException e) 
 			{
 				e.printStackTrace();
 			}
 		}
 	
 	}
 	
 }
 
 public static List<Notifiedqestion> fatchnotifiyadmin()
	
 {
	 String question = null;
	 
	 List<Notifiedqestion> list = new ArrayList<Notifiedqestion>();
	
	 String sql = "select * from notifiyadmin";
      
	  Connection con = makeConnection();
		
	   PreparedStatement pstm = null;
		
	   try 
		
		{
		   //id, question
			
			PreparedStatement pstm1 = con.prepareStatement(sql);
			
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			
			{
			
				Notifiedqestion Notifiedqestion = new Notifiedqestion();	
				
				
				Notifiedqestion.setId(rs.getInt("id"));
				Notifiedqestion.setQestion(rs.getString("question"));
				
				list.add(Notifiedqestion);	
				
			}
			
		}
	   
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if (con != null)
			{
				try 
				{
					con.close();
				}
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
		//
	}   
  
 public static String GetExpertEmail(String expertname) {

	 //id, cid, username, password, email, cpassword, testresult
	 String expertemail = null; 
	 
	 String sql = "select * from expert where username=?";
		
		Connection con = makeConnection();
		
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try 
		
		{
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,expertname );
			rs = pstm.executeQuery();
			
			
			while (rs.next()) 
			{
				expertemail = rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return expertemail;
}
 
 public static List<findBestAnswer> findBestAnswer1()
  {
	 //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
	
	 List<findBestAnswer> list = new ArrayList<findBestAnswer>();
	
	 String sql = "SELECT DISTINCT qestion FROM addrating";
	
	Connection con = makeConnection();
	PreparedStatement pstm = null;
		
	try 
		{

			PreparedStatement pstm1 = con.prepareStatement(sql);
			ResultSet rs = pstm1.executeQuery();

			while (rs.next())
			
			{
				findBestAnswer findBestAnswer = new findBestAnswer();
				
				
				 findBestAnswer.setQestion(rs.getString("qestion"));
					
				
		    	list.add(findBestAnswer);
		    	
	
			
			}
			
			
       } 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if (con != null)
			{
				try 
				{
					con.close();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	
		return list;
		
	}
 
 public static List<String> answer(String qestion) {
 //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
	 String output = null;
	 
	 List<String>list = new ArrayList<String>();
	 
	 String sql = "select DISTINCT answer from addrating where qestion=?";
	 Connection con = makeConnection();
	 PreparedStatement pstm = null;
	 ResultSet rs = null;
			
	try 
			
	{
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1,qestion );
				rs = pstm.executeQuery();
				
				
				while (rs.next()) 
				{
					
		          output = rs.getString("answer");
			 
		          
				  list.add(output);  
	                
	                
				}
				
			} 
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	
			return list;
	   }
		
 public static List<findBestAnswer> avgrating(String answer) {
		
	 //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
	     
	    String output = null;
		 
		 List<findBestAnswer>list = new ArrayList<findBestAnswer>();
		 
		 String sql = "select * from addrating where answer=?";
		 
		 Connection con = makeConnection();
		 PreparedStatement pstm = null;
		 ResultSet rs = null;
				
		try 
				
		{
					pstm = con.prepareStatement(sql);
					
					pstm.setString(1,answer );
					rs = pstm.executeQuery();
					
					
					while (rs.next()) 
					{
					
				   findBestAnswer findBestAnswer = new findBestAnswer();
						
				   findBestAnswer.setId(rs.getInt("id"));
				   findBestAnswer.setExpertname(rs.getString("username"));
				   findBestAnswer.setRating(rs.getInt("rating"));
				   findBestAnswer.setQestion(rs.getString("qestion"));
				   findBestAnswer.setAnswer(rs.getString("answer"));
				   
				   
				   System.out.println("rating-->"+findBestAnswer.getRating());
				   
				   
				      list.add(findBestAnswer);  
		                
		               
					}
					
				} 
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (pstm != null) {
						try {
							pstm.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		
				return list;
		   }
		
 public static List<topexpert> topexpertname(int ratingid) {
		
	 //id, username, rating, qestion, answer, qestionid, answerid, expertgiveratingname
	     
	      String output = null;
		 
		 List<topexpert>list = new ArrayList<topexpert>();
		 
		 String sql = "select * from addrating where rating=?";
		 
		 Connection con = makeConnection();
		 PreparedStatement pstm = null;
		 ResultSet rs = null;
				
		try 
				
		      {
					pstm = con.prepareStatement(sql);
					
					pstm.setInt(1,ratingid );
					rs = pstm.executeQuery();
					
					
					while (rs.next()) 
					{
					
						topexpert topexpert = new topexpert();
					
						
						topexpert.setUsername(rs.getString("username"));	
						topexpert.setQestion(rs.getString("qestion"));
						topexpert.setAnswer(rs.getString("answer"));
						
						
				  
				   
				   
				  
				   
				   
				      list.add(topexpert);  
		                
		               
					}
					
				} 
				
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (pstm != null) {
						try {
							pstm.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		
				return list;
		   }
 
 
		
}
 


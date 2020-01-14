package com.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.algorithms.Retrieval;
import com.bean.Image;
import com.dao.UserDao;


@WebServlet("/ImageSearchController")
@MultipartConfig(maxFileSize=1024*1024*50)
public class ImageSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> imglist=new ArrayList<String>();
	
    public ImageSearchController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		imglist.clear();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Part partfile=request.getPart("file");
		InputStream iss;
		
		iss=partfile.getInputStream();
        String filename=extractFileName(partfile);
        //GraphDao dao=new GraphDao();
        ResultSet rm=UserDao.getfile(filename);
       
        try {
				if(rm.next())
				{
					
					 System.out.println("image list:"+imglist);
			         ArrayList<Integer> relevent=new ArrayList<Integer>();
			         relevent.clear();
			         
			         String filename1=filename.replaceAll(".jpg", "");
			        
			          for(int j=0;j<4;j++)
			     	{
			     		Retrieval.process(filename1 +"_"+j+".jpg");
			     	} 
			         
			         
			         Map<String,Integer> map=new HashMap<String,Integer>();
			         ArrayList<Image> imagelist=new ArrayList<Image>();
			         for (String temp : imglist) 
			     	{
			     		
			     		Integer count = map.get(temp);
			     		map.put(temp, (count == null) ? 1 : count + 1);
			     	}
			         System.out.println("Unsorted List");
			     	for (Map.Entry<String, Integer> entry : map.entrySet()) 
			     	{
			     		System.out.println("Key : " + entry.getKey() + " Value : " +entry.getValue());
			     		imagelist.add(new Image(entry.getKey(), entry.getValue()));
			     	}
			     	System.out.println("Sorted List");
			       
			     	Iterator itr=imagelist.iterator(); 
			     	int n=0;
			     	while(n<5)
			     	{  
			     		
			     		Image st=(Image) itr.next();  
			     		relevent.add(Integer.parseInt(st.name));
			     		System.out.println(st.name+" "+" "+st.count);
			     		n++;
			     		
			     		
			     	} 
			     	Iterator itr2=imagelist.iterator(); 
			     	int m=0;
			     	float relevant=0;
			     	while(m<imagelist.size())
			     	{  
			     		
			     		Image st=(Image)itr2.next();  
			     		System.out.println(st.name+" "+" "+st.count);
			     		if(st.count>1)
			     		{
			     			relevant++;
			     		}
			     		m++;
			     		
			     	} 
			     	System.out.println("relevent Images:"+relevent);
			     	session.setAttribute("imagelist", imglist);
			     	
			     	response.sendRedirect("ImageSearchView.jsp");
				}
				else {
			
					System.out.println("File Name Exists. Please Change File Name");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Invalid Image.........');");  
					out.println("</script>");    
					request.getRequestDispatcher("ImageSearch.jsp").include(request, response);
       
         
	}
			}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	}
private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
        if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}
}

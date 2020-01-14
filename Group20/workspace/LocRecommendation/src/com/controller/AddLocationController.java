package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.AddLocationBean;
import com.dao.AdminDao;
import com.dao.UserDao;
import com.mail.RegisterMail;

@MultipartConfig(maxFileSize = 10485760)
@WebServlet("/AddLocationController")
public class AddLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream image=null;		
	String imageName="";
	String path=null;
	File upload=null;
    public AddLocationController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          PrintWriter out=response.getWriter();
		
          UserDao db=new UserDao();
          
		String loc=request.getParameter("loc");
		String loc_name=request.getParameter("loc_name");
		String loc_type=request.getParameter("loc_type");
		String loc_address=request.getParameter("loc_address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
        Part part=request.getPart("file");
        String lat=request.getParameter("lat");
        String log=request.getParameter("long");
        String rank="0";
		
		if(part!=null)
		{
			image=part.getInputStream();
			System.out.println("is size:"+image.available());
			imageName=db.extractFileName(part);
			System.out.println("name:"+imageName);
		}
		AddLocationBean bean=new AddLocationBean();
		
		bean.setLocation(loc);
		bean.setLoc_name(loc_name);
		bean.setLoc_type(loc_type);
		bean.setLoc_address(loc_address);
		bean.setCity(city);
		bean.setCountry(country);
		bean.setImage(image);
		bean.setImage_name(imageName);
		bean.setRank(rank);
		bean.setLat(lat);
		bean.setLog(log);
		
		AdminDao dao=new AdminDao();
		
		/*upload=new File("D://upload/");
		if (!upload.isDirectory()) {
			upload.mkdir();
		}
		part.write(upload.getAbsolutePath()+"/"+imageName);
		path=new File(upload.getAbsoluteFile()+"/"+imageName).getAbsolutePath();*/
		
		
		if(dao.InsertLocationData(bean))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Add Successful')");
			out.println("location='AddLocation.jsp';");
			out.println("</script>");
		
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Fail..............')");
			out.println("location='AddLocation.jsp';");
			out.println("</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

<%@page import="com.connection.DBConnection"%>
<%@page import="java.io.InputStream,java.sql.*"%>

<%
try
{ 
    int byteRead;
    byte[] buffer = new byte[1024*1024*50];
    DBConnection db=new DBConnection();
    Connection connection=db.getConnection();
    
    int id=Integer.parseInt(request.getParameter("id"));
    System.out.println("Id== "+id);
   	  
    PreparedStatement pst=connection.prepareStatement("select image from tbl_location where locationid='"+id+"'");
    
    ResultSet rs=pst.executeQuery();
    //int id=request.getAttribute(arg0);
	if(rs.next())
	{	
	  InputStream is =  rs.getBinaryStream(1);
	  if(is!=null)
	  {
		  while ((byteRead =is.read(buffer)) != -1)
	  
		{
	    	response.reset();
			response.setContentType("image/jpg");
			response.setHeader("Content-disposition","attachment; filename=" );
	        response.getOutputStream().write(buffer, 0, byteRead);
	        response.getOutputStream().flush(); 
	        response.getOutputStream().close();
	        out.clear();
			out = pageContext.pushBody();
	 	}
		 
	  }
	}
  
}
catch(Exception e)
{
	e.printStackTrace();
}
%>





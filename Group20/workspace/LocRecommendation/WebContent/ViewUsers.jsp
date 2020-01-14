<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Content-Aware Collaborative Filtering
for Location Recommendation</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    

</head>

<body>

    <div id="wrapper">
<center><h2>Content-Aware Collaborative Filtering
for Location Recommendation</h2></center>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
            </div>
            
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                     <ul class="nav" id="side-menu">
                       
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                       
                        <li>
                            <a href="AdminHome.jsp"><i class="fa fa-table fa-fw"></i>Home</a>
                        </li>
                        
                        <li>
                            <a href="ViewUsers.jsp"><i class="fa fa-table fa-fw"></i>View Users</a>
                        </li>
                        
                        <li>
                            <a href="AddLocation.jsp"><i class="fa fa-table fa-fw"></i>Add Location</a>
                        </li>
                         <li>
                            <a href="AddReviews.jsp"><i class="fa fa-table fa-fw"></i>Add Location Reviews</a>
                        </li>
                         <li>
                            <a href="LocationDetails.jsp"><i class="fa fa-table fa-fw"></i>View All Location Details</a>
                        </li>
                        
                        <li>
                            <a href="LogoutController"><i class="fa fa-table fa-fw"></i>Logout</a>
                        </li>
                        
                    </ul>
                </div>
                
            </div>
        </nav>
        
         <div id="page-wrapper">
            <div class="row">
               <section class="colorlib-contact" data-section="contact">
				  <h4 class="text-upper col-md-offset-0" ><center><b>User Details Table</b></center></h4><br>
                   <form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                    <table class="table table-bordered" style="color:black">
                    <tr  class="danger" style="color:black">
                     <th>Profile Pic</th>
                    <th> Name   </th>
                     <th>Address</th>
                     <th>Email</th>
                     <th>Mobile No</th>
                     <th>DOB</th>
                     <th>Status</th>
                     <th>Action</th>
                     </tr>
                     <%
                     Connection con=DBConnection.getConnection();
                     Statement st=con.createStatement();
                     ResultSet rs=st.executeQuery("select * from tbl_user");
                     while(rs.next())
                     {
                    	 %>
                    	 <TR>
                    	<td><img alt="Profile Pic" class="img-circle" src="profilepic.jsp?id=<%=rs.getInt(1) %>"  width="100px" height="80px"/></td>
                    	 <td><%=rs.getString(2) %></td>
                    	 <td><%=rs.getString(3) %></td>
                    	 <td><%=rs.getString(4) %></td>
                    	 <td><%=rs.getString(5) %></td>
                    	 <td><%=rs.getString(6) %></td>
          
                    	 <th><a href="UserStatusController?id=<%=rs.getInt(1)%>&status=<%=rs.getString(8)%>"><%=rs.getString(8)%></a></th>
                    	 <td><a href="UserDeleteController?id=<%=rs.getInt(1)%>"><b>Delete</b></a></td>
                    	 </TR>
                    	 
                    <%} %> 
                   
                    </table>
                    
                            
                  </form>
                </div>
            
        </div>

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>

<!DOCTYPE html>
<%@page import="com.bean.AddLocationBean"%>
<%@page import="com.dao.UserDao"%>
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
                            <a href="UserHome.jsp"><i class="fa fa-table fa-fw"></i>Home</a>
                        </li>
                        
                         <li>
                            <a href="SearchLocation.jsp"><i class="fa fa-table fa-fw"></i>Search Location</a>
                        </li>
                       
                          <li>
                            <a href="FacebookToken.jsp"><i class="fa fa-table fa-fw"></i>Fetch Facebook Location</a>
                        </li>
                        <li>
                            <a href="FBLocation.jsp"><i class="fa fa-table fa-fw"></i>Current Location From FB</a>
                        </li>
                        <li>
                            <a href="LogoutController"><i class="fa fa-table fa-fw"></i>Logout</a>
                        </li>
                        
                    </ul>
                </div>
                
            </div>
           
        </nav>

         <div class="container">
         <%
         String id=request.getParameter("locationid");
         session.setAttribute("locationid", id);
         String name=request.getParameter("locationname");
         UserDao dao=new UserDao();
         AddLocationBean bean=dao.SelectLocationName(id);
			
         %>
         
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Give Reviews</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="GiveReviewController" method="post">
                            <fieldset>
                            <div class="form-group">
                             <label>Location Name:  <%=bean.getLoc_name()%></label>
                            </div>
                                <div class="form-group">
                                <label>Enter Review</label>
                                    <textarea class="form-control" name="review" rows=5 cols=5></textarea>
                                </div>
                                  <div class="form-group">
                                  <label>Enter Rating</label>
                                <input id="input-21d" class="form-control" name="star"  type="number" class="rating" min=0 max=5 step=0.5 data-size="sm">
                                </div> 	
                                <button type="submit" class="btn btn-lg btn-success btn-block">Submit</button><br>
                                <br>
                                
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
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

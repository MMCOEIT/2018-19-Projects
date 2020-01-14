 <%@page import="com.project.beans.UserProductBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.daoFactory.DaoFactory"%>
<%@page import="com.project.dao.UserDao"%>
<%@page import="com.project.beans.UserSearchBookBeans"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.project.beans.UserBeans"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Mining Algorithm to archive High utility item set using TKO with TKU | User Algorithms Top K Result    </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<script src="js/simpleCart.min.js"> </script>
<script src="js/amcharts.js"></script>	
<script src="js/serial.js"></script>	
<script src="js/light.js"></script>	
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
   <!--pie-chart--->
<script src="js/pie-chart.js" type="text/javascript"></script>
<%

int userId=0;

String userName=null;

UserBeans userBeans=(UserBeans)session.getAttribute("userSessionInfomation");

userName=userBeans.getUser_name();

userId=userBeans.getId();

%>




<%

// for hit session 

   ArrayList<UserProductBeans> ArruserProductBeansList=new ArrayList<UserProductBeans>();
		
  ArruserProductBeansList=(ArrayList<UserProductBeans>)session.getAttribute("ArruserProductBeansList");
		
		

%>

<%
String userCategory=null;

int topKValue=0;

UserSearchBookBeans userSearchBookBeans=(UserSearchBookBeans)session.getAttribute("userTopkValueSession");

userCategory=userSearchBookBeans.getUser_category();

topKValue=userSearchBookBeans.getUser_top_k_value();

System.out.println("Top k Value is" +topKValue);

%>
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
		<!-- header-starts -->
			
			 	<div class="header_bg">
							<div class="header">
								<div class="head-t">
									<div class="logo">
										<a href="index.jsp"><img src="images/logo.png" class="img-responsive" alt=""> </a>
									</div>
										
								<div class="clearfix"> </div>
							</div>
						</div>
				</div> 
					<!-- //header-ends -->
				<!--content-->
			<div class="content">
<div class="women_main">
	<!-- start content -->
      <div class="clearfix"></div>
   
      <div class="w_content">
		<div class="women">
			<a href="#"><h4><%=userCategory %> - for Hits Using TKO   <span></span> </h4></a>
		
		    <div class="clearfix"> </div>
		</div>
		<!-- grids_of_4 -->
		
		<div class="grids_of_4">
		
		<%
					
		UserProductBeans userProductBeans=new UserProductBeans();
					
					if(topKValue>ArruserProductBeansList.size()){
						
						System.out.println("Top k Value is" +topKValue);
						
						System.out.println("Top k Value is Array List " +ArruserProductBeansList.size());
					
						%>
						  <h4>Sorry ! Top k Value is High  </h4>
				    
						
						<%
						
						
						
					}
					
					else
						
					{
					for(int i=0;i<topKValue;i++){
						
						userProductBeans=ArruserProductBeansList.get(i);
						
						System.out.println("Only JSP"+userProductBeans.getProduct_id());
						
						System.out.println("Only JSP"+userProductBeans.getProduct_Brand());
						
						//id, product_id, product_name, product_Brand, product_SKU, product_SRP, gross_weight, net_weight, recyclable_package, low_fat, units_per_case, cases_per_pallet, shelf_width, shelf_height, shelf_depth, product_price
		
				%>
				
		
		
		 <div class="grid1_of_4">
				<div class="content_box"><a href="#">
			   	   	<a href=""><img src="books/<%=userProductBeans.getProduct_id() %>.jpg"  alt="No Images " height="200px" width="200px"/></a> 
				   	  </a>
				    <h4> Product Name  <a href="UserViewProductDetailsController?book_id=<%=userProductBeans.getProduct_id()%>"> <%=userProductBeans.getProduct_name() %></a></h4>
				    
				       <h4>Product Brand name  <a href="UserViewProductDetailsController?book_id=<%=userProductBeans.getProduct_id()%>"> <%=userProductBeans.getProduct_Brand() %></a></h4>
				     
				<h4> Product SRP <a href="#" ><%=userProductBeans.getProduct_SRP()%> 	</a>  </h4>
				
				<h4> Product SKU <%=userProductBeans.getProduct_SKU()%> </h4>	 
				    
					<h4> Product Gross Weight <%=userProductBeans.getGross_weight() %> </h4> 
				
					<h4> Product Net Weight	 <%=userProductBeans.getNet_weight() %> </h4> 
					
					<h4> Product recyclable_package	 <%=userProductBeans.getRecyclable_package()%> </h4> 
					
						<h4> Product Low Fat 	 <%=userProductBeans.getLow_fat()%> </h4> 
						
						<h4> Product Unit Per 	 <%=userProductBeans.getUnits_per_case()%> </h4> 
						
						<h4> Product Cases per 	 <%=userProductBeans.getCases_per_pallet()%> </h4>
						
						<h4> Product Height  	 <%=userProductBeans.getShelf_height()%> </h4>
						
						<h4> Product width 	 <%=userProductBeans.getShelf_width()%> </h4>
						
						<h4> Product Depth 	 <%=userProductBeans.getShelf_depth()%> </h4>
						
							<h4> Product Prices 	 <%=userProductBeans.getProduct_price()%> </h4>
					
					
					
						 
					
				
					 </div>
			   	</div>
			</div>
		
			
			
	<% } 
					
					}
					%>
			
			
			
			
		<%-- 	<% 
		count1++;
			if(count1==topKValue)     		   
         		           
         	   break;
	n1++;
			if(n1==3){
				System.out.println("value of n is "+n1);
				
				n1=0;
			
				%>
				 <div class="clearfix"> </div> 
				 
				 
				
				
				<%
			}
		
		
		} // end for  outer while loop
		
		
						
			%>
			 --%>
			 
			<%--  <%
			 
			 }
			 
			 %>
		 --%>
		
		
			
			
			
		</div>
			
			
	

		
		
		
		<!-- end grids_of_4 -->
		
		
	</div>
   
	<!-- end content -->
	<!-- <div class="foot-top">
	
		<div class="col-md-6 s-c">
			<li>
				<div class="fooll">
					<h1>follow us on</h1>
				</div>
			</li>
			<li>
				<div class="social-ic">
					<ul>
						<li><a href="#"><i class="facebok"> </i></a></li>
						<li><a href="#"><i class="twiter"> </i></a></li>
						<li><a href="#"><i class="goog"> </i></a></li>
						<li><a href="#"><i class="be"> </i></a></li>
							<div class="clearfix"></div>	
					</ul>
				</div>
			</li>
				<div class="clearfix"> </div>
		</div>
		<div class="col-md-6 s-c">
			<div class="stay">
						<div class="stay-left">
							<form>
								<input type="text" placeholder="Enter your email" required="">
							</form>
						</div>
						<div class="btn-1">
							<form>
								<input type="submit" value="join">
							</form>
						</div>
							<div class="clearfix"> </div>
			</div>
		</div>
			<div class="clearfix"> </div>
</div> -->
<!-- <div class="footer">
					<div class="col-md-3 cust">
						<h4>CUSTOMER CARE</h4>
							<li><a href="contact.html">Help Center</a></li>
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="details.html">How To Buy</a></li>
							<li><a href="checkout.html">Delivery</a></li>
					</div>
					<div class="col-md-2 abt">
						<h4>ABOUT US</h4>
							<li><a href="products.html">Our Stories</a></li>
							<li><a href="products.html">Press</a></li>
							<li><a href="faq.html">Career</a></li>
							<li><a href="contact.html">Contact</a></li>
					</div>
					<div class="col-md-2 myac">
						<h4>MY ACCOUNT</h4>
							<li><a href="register.html">Register</a></li>
							<li><a href="checkout.html">My Cart</a></li>
							<li><a href="checkout.html">Order History</a></li>
							<li><a href="details.html">Payment</a></li>
					</div>
					<div class="col-md-5 our-st">
						<div class="our-left">
							<h4>OUR STORES</h4>
						</div>
						
							<li><i class="add"> </i>Mark peter</li>
							<li><i class="phone"> </i>012-586987</li>
							<li><a href="mailto:info@example.com"><i class="mail"> </i>info@sitename.com </a></li>
					</div>
					<div class="clearfix"> </div>
						<p>© 2016 Gretong. All Rights Reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
			</div> -->
			
			<jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
			<!--content-->
		</div>
</div>
				<!--//content-inner-->
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                                <div class="menu">
									<ul id="menu" >
										<li><a href="UserCheckSessionController"><i class="fa fa-tachometer"></i> <span>Home</span></a></li>
										
										<li><a href="UserViewProfileController?userId=<%=userId%>"><i class="fa fa-tachometer"></i> <span><%=userName %></span></a></li>
										 <li id="menu-academico" ><a href="#"><i class="fa fa-table"></i> <span>Select Brands </span> <span class="fa fa-angle-right" style="float: right"></span></a>
										   <ul id="menu-academico-sub" >
										   
											<li id="menu-academico-avaliacoes" ><a href="userSelectProductByCategoryController">By Brands </a></li>
											
																					
										  </ul>
										</li>
										
										<li><a href="UserSelectProductForSearchingController"><i class="fa fa-tachometer"></i> <span>Search Brands </span></a></li>
										
									<li><a href="userChangePassword.jsp"><i class="fa fa-tachometer"></i> <span>Change Password</span></a></li>
									
								    <li><a href="UserLogoutController"><i class="fa fa-tachometer"></i> <span>Logout</span></a></li>
							       
									
								  </ul>
									
								</div>
							  </div>
							  <div class="clearfix"></div>	
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->
   <!-- real-time -->
<script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
	<script type="text/javascript">

	$(function() {

		// We use an inline data source in the example, usually data would
		// be fetched from a server

		var data = [],
			totalPoints = 300;

		function getRandomData() {

			if (data.length > 0)
				data = data.slice(1);

			// Do a random walk

			while (data.length < totalPoints) {

				var prev = data.length > 0 ? data[data.length - 1] : 50,
					y = prev + Math.random() * 10 - 5;

				if (y < 0) {
					y = 0;
				} else if (y > 100) {
					y = 100;
				}

				data.push(y);
			}

			// Zip the generated y values with the x values

			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]])
			}

			return res;
		}

		// Set up the control widget

		var updateInterval = 30;
		$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 2000) {
					updateInterval = 2000;
				}
				$(this).val("" + updateInterval);
			}
		});

		var plot = $.plot("#placeholder", [ getRandomData() ], {
			series: {
				shadowSize: 0	// Drawing is faster without shadows
			},
			yaxis: {
				min: 0,
				max: 100
			},
			xaxis: {
				show: false
			}
		});

		function update() {

			plot.setData([getRandomData()]);

			// Since the axes don't change, we don't need to call plot.setupGrid()

			plot.draw();
			setTimeout(update, updateInterval);
		}

		update();

		// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});

	</script>
<!-- /real-time -->
<script src="js/jquery.fn.gantt.js"></script>
    <script>

		$(function() {

			"use strict";

			$(".gantt").gantt({
				source: [{
					name: "Sprint 0",
					desc: "Analysis",
					values: [{
						from: "/Date(1320192000000)/",
						to: "/Date(1322401600000)/",
						label: "Requirement Gathering", 
						customClass: "ganttRed"
					}]
				},{
					name: " ",
					desc: "Scoping",
					values: [{
						from: "/Date(1322611200000)/",
						to: "/Date(1323302400000)/",
						label: "Scoping", 
						customClass: "ganttRed"
					}]
				},{
					name: "Sprint 1",
					desc: "Development",
					values: [{
						from: "/Date(1323802400000)/",
						to: "/Date(1325685200000)/",
						label: "Development", 
						customClass: "ganttGreen"
					}]
				},{
					name: " ",
					desc: "Showcasing",
					values: [{
						from: "/Date(1325685200000)/",
						to: "/Date(1325695200000)/",
						label: "Showcasing", 
						customClass: "ganttBlue"
					}]
				},{
					name: "Sprint 2",
					desc: "Development",
					values: [{
						from: "/Date(1326785200000)/",
						to: "/Date(1325785200000)/",
						label: "Development", 
						customClass: "ganttGreen"
					}]
				},{
					name: " ",
					desc: "Showcasing",
					values: [{
						from: "/Date(1328785200000)/",
						to: "/Date(1328905200000)/",
						label: "Showcasing", 
						customClass: "ganttBlue"
					}]
				},{
					name: "Release Stage",
					desc: "Training",
					values: [{
						from: "/Date(1330011200000)/",
						to: "/Date(1336611200000)/",
						label: "Training", 
						customClass: "ganttOrange"
					}]
				},{
					name: " ",
					desc: "Deployment",
					values: [{
						from: "/Date(1336611200000)/",
						to: "/Date(1338711200000)/",
						label: "Deployment", 
						customClass: "ganttOrange"
					}]
				},{
					name: " ",
					desc: "Warranty Period",
					values: [{
						from: "/Date(1336611200000)/",
						to: "/Date(1349711200000)/",
						label: "Warranty Period", 
						customClass: "ganttOrange"
					}]
				}],
				navigate: "scroll",
				scale: "weeks",
				maxScale: "months",
				minScale: "days",
				itemsPerPage: 10,
				onItemClick: function(data) {
					alert("Item clicked - show some details");
				},
				onAddClick: function(dt, rowId) {
					alert("Empty space clicked - add an item!");
				},
				onRender: function() {
					if (window.console && typeof console.log === "function") {
						console.log("chart rendered");
					}
				}
			});

			$(".gantt").popover({
				selector: ".bar",
				title: "I'm a popover",
				content: "And I'm the content of said popover.",
				trigger: "hover"
			});

			prettyPrint();

		});

    </script>
		   <script src="js/menu_jquery.js"></script>
</body>
</html> 

<%@page import="com.project.beans.AdminBeans"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<!DOCTYPE HTML>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Graphs - TKO Time Graph</title>

		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
${demo.css}
		</style>
<%!ResultSet rs=null; %>
		
<%
long tkuValue=0;

rs=(ResultSet)session.getAttribute("ResultTKOSession");
System.out.println("Session Start ");


%>

<%
String adminName=null;

AdminBeans adminBeans=(AdminBeans)session.getAttribute("adminSessionInfomation");

adminName=adminBeans.getAdmin_name();

%> 
<script type="text/javascript">
var tkoTime=[];
var tkoKValue=[];
var i=0;



//id, user_Category, user_ToK, user_tkoTime
<% while(rs.next()){%>

	/* System.out.println("Tko Values times is "+rs.getLong(3));
	
	System.out.println("top k values "+rs.getInt(2)); */
	
	/*  int topkValue=rs.getInt(2);
	
	 tkuValue=rs.getLong(3); */
	 

	 tkoTime[i]='<%=rs.getLong(4)%>';
	 
	 tkoKValue[i]=<%=rs.getInt(3)%>;
	 
	 alert("values are"+<%=rs.getLong(4)%>);
	 
	 i++;
	 
<%}%>
</script>
		
	
	</head>
	<body>
	
<!-- <script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script> -->
<script type="text/javascript" src="js/highcharts.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
	$(function() {
		$('#container')
				.highcharts(
						{
							chart : {
								type : 'column'
							},
							title : {
								text : 'Top K with TKO Algorithms '
							},
							
							subtitle : {
								text : ''
							},
							xAxis : {
								min : 0,
								title : {
									text : ' Search Index'
								},
								
								crosshair : true
							},
							yAxis : {
								min : 0,
								title : {
									text : 'Time In Mili Seconds '
								}
							},
							tooltip : {
								headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
								pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
										+ '<td style="padding:0"><b>{point.y:0f}</b></td></tr>',
								footerFormat : '</table>',
								shared : true,
								useHTML : true
							},
							plotOptions : {
								column : {
									pointPadding : 0,
									borderWidth :50
								}
							}, 
							
							series : [ {
								 name :tkoTime,
								data :tkoKValue 

							}]
						});
	});
	
</script>


	
	<a href="welcomeToAdmin.jsp">Go Next </a>
	
	<br>
	
		<a href="UserLogoutController">Logout  </a>
	
	</body>
	
	
</html>

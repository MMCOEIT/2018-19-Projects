<!DOCTYPE HTML>
<%@page import="java.sql.ResultSet"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Top k High Ultity mining </title>

		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="assest/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
${demo.css}
		</style>
		
		<%
		
		long tkoTime=0;
		
		long tkuTime=0;
		
		long totalTime=0;
		
		ResultSet rs=(ResultSet)session.getAttribute("finalTimeGraph");
		
		//id, tko_time, tku_time, tkowithtku_time
		
		while(rs.next()){
		
		tkoTime=rs.getLong(2);
		
		tkuTime=rs.getLong(3);
		
		totalTime=rs.getLong(4);
		
		}
		
		%>
	
		<script type="text/javascript">
$(function () {
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Top k in High utitily Mining '
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                'Algorithms  ',
             
               
             
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Time in Mili  Seconds '
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },      plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'TKO',
            data: [<%=tkoTime%>]

        }, {
            name: 'TKU',
            data: [<%=tkuTime%>]

        },
        {
            name: 'TKO WITH TKU ',
            data: [<%=totalTime%>]

        }]
    });
});
		</script>
	</head>
	<body>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<a href="welcomeToAdmin.jsp">Go Next </a>
	
	<br>
	
		<a href="UserLogoutController">Logout  </a>
	
	</body>
</html>

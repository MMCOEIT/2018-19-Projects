/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2019-05-29 08:49:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddLocation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>Content-Aware Collaborative Filtering for Location\r\n");
      out.write("\tRecommendation</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core CSS -->\r\n");
      out.write("<link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- MetisMenu CSS -->\r\n");
      out.write("<link href=\"vendor/metisMenu/metisMenu.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom CSS -->\r\n");
      out.write("<link href=\"dist/css/sb-admin-2.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Morris Charts CSS -->\r\n");
      out.write("<link href=\"vendor/morrisjs/morris.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Custom Fonts -->\r\n");
      out.write("<link href=\"vendor/font-awesome/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<h2>Content-Aware Collaborative Filtering for Location\r\n");
      out.write("\t\t\t\tRecommendation</h2>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t<!-- Navigation -->\r\n");
      out.write("\t\t<nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\"\r\n");
      out.write("\t\t\tstyle=\"margin-bottom: 0\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("\t\t\t\t\tdata-target=\".navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"navbar-default sidebar\" role=\"navigation\">\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-nav navbar-collapse\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav\" id=\"side-menu\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-dashboard fa-fw\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\tDashboard</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AdminHome.jsp\"><i class=\"fa fa-table fa-fw\"></i>Home</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"ViewUsers.jsp\"><i class=\"fa fa-table fa-fw\"></i>View\r\n");
      out.write("\t\t\t\t\t\t\t\tUsers</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"AddLocation.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"fa fa-table fa-fw\"></i>Add Location</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t <li>\r\n");
      out.write("                            <a href=\"AddReviews.jsp\"><i class=\"fa fa-table fa-fw\"></i>Add Location Reviews</a>\r\n");
      out.write("                        </li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"LocationDetails.jsp\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"fa fa-table fa-fw\"></i>View All Location Details</a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"LogoutController\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"fa fa-table fa-fw\"></i>Logout</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-4 col-md-offset-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"login-panel panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t<h3 class=\"panel-title\">Add Location</h3>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<form role=\"form\" action=\"AddLocationController\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" name=\"loc\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>Hotel</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>Place</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"Location Name\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"loc_name\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"Location Type\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"loc_type\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"Location Address\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"loc_address\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"City\" name=\"city\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"Country\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"country\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" name=\"file\" type=\"file\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"latitude\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"lat\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\" placeholder=\"longitude\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"long\" type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-lg btn-success btn-block\">Add\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tLocation</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /#wrapper -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- jQuery -->\r\n");
      out.write("\t<script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap Core JavaScript -->\r\n");
      out.write("\t<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Metis Menu Plugin JavaScript -->\r\n");
      out.write("\t<script src=\"vendor/metisMenu/metisMenu.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Morris Charts JavaScript -->\r\n");
      out.write("\t<script src=\"vendor/raphael/raphael.min.js\"></script>\r\n");
      out.write("\t<script src=\"vendor/morrisjs/morris.min.js\"></script>\r\n");
      out.write("\t<script src=\"data/morris-data.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Custom Theme JavaScript -->\r\n");
      out.write("\t<script src=\"dist/js/sb-admin-2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.GetUserResponse;
import service.UserService;
import model.GetUserRequest;

public final class Update_005fuserForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Registration</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String id = request.getParameter("id");
            int tele = Integer.parseInt(id);
            GetUserRequest user = new GetUserRequest();
            user.setTelephone(tele);
            
            GetUserResponse userList = UserService.getUser(user);
            
        
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <form class=\"form-horizontal\" action=\"UpdateUserServlet\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\">Full Name :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value=\"");
      out.print( userList.getFname() );
      out.write("\"  name=\"fname\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\">NIC :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">          \r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value=\"");
      out.print( userList.getNic());
      out.write("\" name=\"nic\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\" >Staff ID :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">          \r\n");
      out.write("                        <input type=\"number\" class=\"form-control\" value=\"");
      out.print( userList.getStaffid());
      out.write("\" name=\"staffid\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\" >Email :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">          \r\n");
      out.write("                        <input type=\"email\" class=\"form-control\" value=\"");
      out.print( userList.getEmail());
      out.write("\" name=\"email\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\">Vehicle No. :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">          \r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value=\"");
      out.print( userList.getVehicalno());
      out.write("\" name=\"vehicleno\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label class=\"control-label col-sm-2\" >Telephone no. :</label>\r\n");
      out.write("                    <div class=\"col-sm-10\">          \r\n");
      out.write("                        <input type=\"number\" class=\"form-control\" value=\"");
      out.print( userList.getTelephone());
      out.write("\" readonly name=\"telephone\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">        \r\n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

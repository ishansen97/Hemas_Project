package org.apache.jsp.UserRegistration;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import service.UserService;
import model.GetUserResponse;
import java.util.List;

public final class View_005fall_005fusers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Css/view_allcss.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 List<GetUserResponse> userList = UserService.getUserResponses();
      out.write("\r\n");
      out.write("        <table border=\"1\" cellspacing=\"5\" cellpadding=\"4\" class=\"qlist\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>Full Name</th>\r\n");
      out.write("                <th>Staff ID</th>\r\n");
      out.write("                <th>NIC</th>\r\n");
      out.write("                <th>Vehicle no.</th>\r\n");
      out.write("                <th>Telephone no.</th>\r\n");
      out.write("                <th colspan=\"2\">Actions</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                ");
 for (GetUserResponse res: userList) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <td>");
      out.print(res.getFname() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(res.getStaffid() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(res.getNic() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(res.getVehicalno() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(res.getTelephone() );
      out.write("</td>\r\n");
      out.write("                <td><a href=\"Update_userForm.jsp?id=");
      out.print(res.getTelephone() );
      out.write("\">update</a></td>\r\n");
      out.write("                <td><a href=\"DeleteReg_User.jsp?id=");
      out.print(res.getTelephone() );
      out.write("\" onclick=\"return confirm('Are you Sure?')\">delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("        </table>\r\n");
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

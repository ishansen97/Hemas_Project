package org.apache.jsp.SlotAllocation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import service.ParkingService;
import entity.Park;
import model.GetParkingResponse;

public final class SlotAllocation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Slot Allocation Page</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../External/Bootstrap/css/bootstrap.css\">\n");
      out.write("        <script src=\"../External/Jquery/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var selected_slot_count = 0;\n");
      out.write("            var min_value = 0;\n");
      out.write("            var max_value = 0;\n");
      out.write("            var park;\n");
      out.write("            \n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $(\"#p_name\").change(function () {\n");
      out.write("                    park = $(this).val();\n");
      out.write("                    var slot_count = $(\"option:selected\", this).attr(\"data-count\");\n");
      out.write("                    \n");
      out.write("                    if (park !== \"\") {\n");
      out.write("                        selected_slot_count = slot_count;\n");
      out.write("                        $(\"#no_of_slots\").val(slot_count);\n");
      out.write("                        $(\"#min\").attr(\"disabled\", false);\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        $(\"#min\").attr(\"disabled\", true);\n");
      out.write("                        $(\"#max\").attr(\"disabled\", true);\n");
      out.write("                        $(\"#no_of_slots\").val(\"\");\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#min\").change(function () {\n");
      out.write("                    var min = $(this).val();\n");
      out.write("                    min_value = min;\n");
      out.write("                    min_value = Number(min_value);\n");
      out.write("                    selected_slot_count = Number(selected_slot_count);\n");
      out.write("                    if (selected_slot_count > 0 && min_value < selected_slot_count) {\n");
      out.write("                        $(\"#max\").attr(\"disabled\", false);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#max\").change(function () {\n");
      out.write("                    var max = $(this).val();\n");
      out.write("                    max_value = max;\n");
      out.write("                    max_value = Number(max_value);\n");
      out.write("                    min_value = Number(min_value);\n");
      out.write("                    if (selected_slot_count > 0 && max_value < selected_slot_count && min_value > 0) {\n");
      out.write("                                           }\n");
      out.write("                    \n");
      out.write("                    if (max_value > selected_slot_count) {\n");
      out.write("                        alert(\"maximum value cannot be greater than the slot count\");\n");
      out.write("                        $(this).val(\"\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            })\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        ");
 List<GetParkingResponse> parkList = ParkingService.getAllParkings();
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header bg-dark\">\n");
      out.write("                            <h1 class=\"modal-header text-white\">Slot Allocation</h1>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <div class=\"form-group text-center\">\n");
      out.write("                                <h2 class=\"modal-header\">For Registered Users</h2>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <form action=\"");
      out.print(request.getContextPath() );
      out.write("/InsertParkingSlotAllocationServlet\" method=\"POST\" class=\"was-invalidated\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Park Name</label>\n");
      out.write("                                    <select name=\"p_name\" id=\"p_name\" class=\"col-md-6 form-control\" onchange=\"displaySlotCount()\" required>\n");
      out.write("                                        <option value=\"\">--------------</option>\n");
      out.write("                                        ");
 for (GetParkingResponse res: parkList) { 
      out.write("\n");
      out.write("                                        <option value =\"");
      out.print(res.getP_name() );
      out.write("\" data-count=\"");
      out.print(res.getSlot_count());
      out.write('"');
      out.write('>');
      out.print(res.getP_name() );
      out.write("</option>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group mb-2\">\n");
      out.write("                                      <label for=\"no_of_slots\" class=\"form-label\">No. of Slots</label>\n");
      out.write("                                      <input type=\"text\" readonly class=\"form-control-plaintext\" id=\"no_of_slots\" value=\"\">\n");
      out.write("                                </div>    \n");
      out.write("\n");
      out.write("                                <div class=\"form-group mb-2\">\n");
      out.write("                                      <label for=\"staticEmail2\" class=\"form-label\">Weekday/Weekend</label>\n");
      out.write("                                      <select class=\"form-control col-4\" name=\"day_type\" id=\"day_type\" required>\n");
      out.write("                                          <option value =\"\">---------------</option>\n");
      out.write("                                          <option value=\"weekday\">weekday</option>\n");
      out.write("                                          <option value=\"weekend\">weekend</option>\n");
      out.write("                                      </select>\n");
      out.write("                                </div>      \n");
      out.write("\n");
      out.write("                                <div class=\"form-inline\">\n");
      out.write("                                    <div class=\"form-group mb-2\">\n");
      out.write("                                      <input type=\"text\" readonly class=\"form-control-plaintext\" id=\"staticEmail2\" value=\"Allocate From\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group mx-sm-1 mb-1\">\n");
      out.write("                                      <label for=\"min\" class=\"sr-only\">Min</label>\n");
      out.write("                                      <input type=\"number\" class=\"form-control col-4\" id=\"min\" disabled>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                      <label for=\"staticEmail2\" class=\"sr-only\">Email</label>\n");
      out.write("                                      <input type=\"text\" readonly class=\"form-control-plaintext\" id=\"staticEmail2\" value=\"To\">\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group mx-sm-1 mb-1\">\n");
      out.write("                                      <label for=\"max\" class=\"sr-only\">Max</label>\n");
      out.write("                                      <input type=\"number\" class=\"form-control col-4\" id=\"max\" disabled>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <button type=\"submit\" class=\"btn btn-primary mb-2\">Reserve</button>\n");
      out.write("                                    </div>   \n");
      out.write("                            </form>                       \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"../External/Bootstrap/js/bootstrap.js\"></script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

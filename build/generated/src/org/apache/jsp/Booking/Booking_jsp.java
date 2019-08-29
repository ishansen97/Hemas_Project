package org.apache.jsp.Booking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.GetParkingSlotResponse;
import model.GetParkingResponse;
import service.ParkingSlotService;
import service.ParkingService;

public final class Booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../External/Bootstrap/css/bootstrap.css\">\n");
      out.write("        <script src=\"../External/Jquery/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 List<GetParkingSlotResponse> parkingSlotResponse = ParkingSlotService.getAllParkingSlots();
        List<GetParkingResponse> parkingResponse = ParkingService.getAllParkings();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var selected_p_name;\n");
      out.write("            \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#p_name\").change(function () {\n");
      out.write("                    selected_p_name = $(this).val();\n");
      out.write("                    \n");
      out.write("                    $(\".parking_slot_no\").each(function () {\n");
      out.write("                        var p_name = $(this).attr(\"data-park\");\n");
      out.write("                        \n");
      out.write("                        if (p_name === selected_p_name) {\n");
      out.write("                            $(this).attr(\"hidden\", false);\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            $(this).attr(\"hidden\", true);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(function() {\n");
      out.write("                    var dtToday = new Date();\n");
      out.write("    \n");
      out.write("                    var month = dtToday.getMonth() + 1;\n");
      out.write("                    var day = dtToday.getDate();\n");
      out.write("                    var year = dtToday.getFullYear();\n");
      out.write("                    if(month < 10)\n");
      out.write("                        month = '0' + month.toString();\n");
      out.write("                    if(day < 10)\n");
      out.write("                        day = '0' + day.toString();\n");
      out.write("\n");
      out.write("                    var maxDate = year + '-' + month + '-' + day;\n");
      out.write("                    $('#arrival_date').attr('min', maxDate);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header bg-dark text-white\">\n");
      out.write("                            <h1 class=\"modal-header\">Park Slot Booking</h1>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form action=\"");
      out.print(request.getContextPath() );
      out.write("/InsertParkingReservationServlet\" method=\"POST\" class=\"was-invalidated\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Telephone No.</label>\n");
      out.write("                                    <input type=\"number\" class=\"form-control col-5\" name=\"telephone_no\" id=\"telephone_no\" required>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Arrival Date</label>\n");
      out.write("                                    <input type=\"date\" class=\"form-control col-5\" name=\"arrival_date\" id=\"arrival_date\" min=\"\" required>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Arrival Time</label>\n");
      out.write("                                    <input type=\"time\" class=\"form-control col-5\" name=\"arrival_time\" id=\"arrival_time\" required>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Park Name</label>\n");
      out.write("                                    <select class=\"form-control col-4\" name=\"p_name\" id=\"p_name\" required>\n");
      out.write("                                        <option value=\"\">---------------</option>\n");
      out.write("                                        ");
 for (GetParkingResponse park: parkingResponse) { 
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(park.getP_name() );
      out.write('"');
      out.write('>');
      out.print(park.getP_name() );
      out.write("</option>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                    <label>Parking Slot No.</label>\n");
      out.write("                                    <select class=\"form-control col-4\"  name=\"parking_slot_no\" id=\"parking_slot_no\">\n");
      out.write("                                        <option value=\"\">----------------------</option>\n");
      out.write("                                        ");
 for (GetParkingSlotResponse parkingSlot: parkingSlotResponse) { 
      out.write("\n");
      out.write("                                        <option class=\"parking_slot_no\" value=\"");
      out.print(parkingSlot.getParking_slot_no() );
      out.write("\" data-park=\"");
      out.print(parkingSlot.getP_name());
      out.write("\" hidden=false>");
      out.print(parkingSlot.getParking_slot_no() );
      out.write("</option>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-success\">Submit</button>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

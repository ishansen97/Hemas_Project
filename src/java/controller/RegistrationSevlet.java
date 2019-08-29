/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InsertUserRequest;
import service.UserService;

/**
 *
 * @author Sandeepa Fernando
 */
public class RegistrationSevlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationSevlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationSevlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            //            This is a sample for inserting a user
            String fname = request.getParameter("fname");
            String nic = request.getParameter("nic");
            int staffid = Integer.parseInt(request.getParameter("staffid"));
            String email = request.getParameter("email");
            String vno = request.getParameter("vehicleno");
            int tele = Integer.parseInt(request.getParameter("telephone"));

            //create a request based on the inputs
            InsertUserRequest newUserRequest = new InsertUserRequest();

            //set values to the request
            newUserRequest.setFname(fname);
            newUserRequest.setNic(nic);
            newUserRequest.setStaffid(staffid);
            newUserRequest.setEmail(email);
            newUserRequest.setVehicalno(vno);
            newUserRequest.setTelephone(tele);

            //call the logic class
            boolean isUserInserted = UserService.insertUser(newUserRequest);

            if (isUserInserted) {
                response.sendRedirect("RegistrationPage.jsp");
            } else {
                //error message
                out.println("error");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

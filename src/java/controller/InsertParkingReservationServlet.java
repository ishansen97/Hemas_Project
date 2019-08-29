/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InsertParkingReservationRequest;
import service.ParkingReservationService;

/**
 *
 * @author Ishan
 */
@WebServlet(name = "InsertParkingReservationServlet", urlPatterns = {"/InsertParkingReservationServlet"})
public class InsertParkingReservationServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertParkingReservationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertParkingReservationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String telephone_no = request.getParameter("telephone_no");
            String arrival_date = request.getParameter("arrival_date");
            String arrival_time = request.getParameter("arrival_time");
            String p_name = request.getParameter("p_name");
            int parking_slot_no = Integer.parseInt(request.getParameter("parking_slot_no"));
            
            out.println("tel_no: " + telephone_no);
            out.println("arrival_date: " + arrival_date);
            out.println("time: " + arrival_time);
            out.println("p_name: " + p_name);
            out.println("parking_slot_no: " + parking_slot_no);
            
            InsertParkingReservationRequest parkingReservationRequest = new InsertParkingReservationRequest();
            
            parkingReservationRequest.setTelephone_no(telephone_no);
            parkingReservationRequest.setDate(arrival_date);
            parkingReservationRequest.setTime_to_arrive(arrival_time + ":00");
            parkingReservationRequest.setP_name(p_name);
            parkingReservationRequest.setParking_slot_no(parking_slot_no);
            
            boolean isInserted = ParkingReservationService.insertParkingReservation(parkingReservationRequest);
            
            if (isInserted) {
                response.sendRedirect(request.getContextPath() + "/Booking/Booking.jsp");
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

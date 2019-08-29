<%-- 
    Document   : Booking
    Created on : Aug 28, 2019, 5:58:24 PM
    Author     : Ishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, model.GetParkingSlotResponse, model.GetParkingResponse ,service.ParkingSlotService, service.ParkingService" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="../External/Bootstrap/css/bootstrap.css">
        <script src="../External/Jquery/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <% List<GetParkingSlotResponse> parkingSlotResponse = ParkingSlotService.getAllParkingSlots();
        List<GetParkingResponse> parkingResponse = ParkingService.getAllParkings();
        %>
        
        <script>
            var selected_p_name;
            
            $(document).ready(function () {
                $("#p_name").change(function () {
                    selected_p_name = $(this).val();
                    
                    $(".parking_slot_no").each(function () {
                        var p_name = $(this).attr("data-park");
                        
                        if (p_name === selected_p_name) {
                            $(this).attr("hidden", false);
                        }
                        else {
                            $(this).attr("hidden", true);
                        }
                    });
                });
                
                $(function() {
                    var dtToday = new Date();
    
                    var month = dtToday.getMonth() + 1;
                    var day = dtToday.getDate();
                    var year = dtToday.getFullYear();
                    if(month < 10)
                        month = '0' + month.toString();
                    if(day < 10)
                        day = '0' + day.toString();

                    var maxDate = year + '-' + month + '-' + day;
                    $('#arrival_date').attr('min', maxDate);
                });
            });
        </script>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header bg-dark text-white">
                            <h1 class="modal-header">Park Slot Booking</h1>
                        </div>

                        <div class="card-body">
                            <form action="<%=request.getContextPath() %>/InsertParkingReservationServlet" method="POST" class="was-invalidated">
                                <div class="form-group">
                                    <label>Telephone No.</label>
                                    <input type="number" class="form-control col-5" name="telephone_no" id="telephone_no" required>
                                </div>
                                
                                <div class="form-group">
                                    <label>Arrival Date</label>
                                    <input type="date" class="form-control col-5" name="arrival_date" id="arrival_date" min="" required>
                                </div>

                                <div class="form-group">
                                    <label>Arrival Time</label>
                                    <input type="time" class="form-control col-5" name="arrival_time" id="arrival_time" required>
                                </div>

                                <div class="form-group">
                                    <label>Park Name</label>
                                    <select class="form-control col-4" name="p_name" id="p_name" required>
                                        <option value="">---------------</option>
                                        <% for (GetParkingResponse park: parkingResponse) { %>
                                        <option value="<%=park.getP_name() %>"><%=park.getP_name() %></option>
                                        <% } %>
                                    </select>
                                </div>

                                    <div class="form-group">
                                    <label>Parking Slot No.</label>
                                    <select class="form-control col-4"  name="parking_slot_no" id="parking_slot_no">
                                        <option value="">----------------------</option>
                                        <% for (GetParkingSlotResponse parkingSlot: parkingSlotResponse) { %>
                                        <option class="parking_slot_no" value="<%=parkingSlot.getParking_slot_no() %>" data-park="<%=parkingSlot.getP_name()%>" hidden=false><%=parkingSlot.getParking_slot_no() %></option>
                                        <% } %>
                                    </select>
                                </div>
                                    
                                    

                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Submit</button>
                                </div>
                                
                            </form>
                        </div>
                    </div>
                </div>
                    
            </div>
        </div>
    </body>
</html>

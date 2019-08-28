<%-- 
    Document   : SlotAllocation
    Created on : Aug 27, 2019, 8:46:09 AM
    Author     : Ishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, service.ParkingService, entity.Park, model.GetParkingResponse" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Slot Allocation Page</title>
        
        <link rel="stylesheet" href="../External/Bootstrap/css/bootstrap.css">
        <script src="../External/Jquery/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <script>
            var selected_slot_count = 0;
            var min_value = 0;
            var max_value = 0;
            var park;
            
            $(document).ready(function() {
                $("#p_name").change(function () {
                    park = $(this).val();
                    var slot_count = $("option:selected", this).attr("data-count");
                    
                    if (park !== "") {
                        selected_slot_count = slot_count;
                        $("#no_of_slots").val(slot_count);
                        $("#min").attr("disabled", false);
                    }
                    else {
                        $("#min").attr("disabled", true);
                        $("#max").attr("disabled", true);
                        $("#no_of_slots").val("");
                    }
                    
                });
                
                $("#min").change(function () {
                    var min = $(this).val();
                    min_value = min;
                    min_value = Number(min_value);
                    selected_slot_count = Number(selected_slot_count);
                    if (selected_slot_count > 0 && min_value < selected_slot_count) {
                        $("#max").attr("disabled", false);
                    }
                });
                
                $("#max").change(function () {
                    var max = $(this).val();
                    max_value = max;
                    max_value = Number(max_value);
                    min_value = Number(min_value);
                    if (selected_slot_count > 0 && max_value < selected_slot_count && min_value > 0) {
                                           }
                    
                    if (max_value > selected_slot_count) {
                        alert("maximum value cannot be greater than the slot count");
                        $(this).val("");
                    }
                });
            })
        </script>
        
        <% List<GetParkingResponse> parkList = ParkingService.getAllParkings();%>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-dark">
                            <h1 class="modal-header text-white">Slot Allocation</h1>
                        </div>

                        <div class="card-body">
                            <div class="form-group text-center">
                                <h2 class="modal-header">For Registered Users</h2>
                            </div>
                            
                            <form action="<%=request.getContextPath() %>/InsertParkingSlotAllocationServlet" method="POST" class="was-invalidated">
                                <div class="form-group">
                                    <label>Park Name</label>
                                    <select name="p_name" id="p_name" class="col-md-6 form-control" onchange="displaySlotCount()" required>
                                        <option value="">--------------</option>
                                        <% for (GetParkingResponse res: parkList) { %>
                                        <option value ="<%=res.getP_name() %>" data-count="<%=res.getSlot_count()%>"><%=res.getP_name() %></option>
                                        <% } %>
                                    </select>
                                </div>

                                <div class="form-group mb-2">
                                      <label for="no_of_slots" class="form-label">No. of Slots</label>
                                      <input type="text" readonly class="form-control-plaintext" id="no_of_slots" value="">
                                </div>    

                                <div class="form-group mb-2">
                                      <label for="staticEmail2" class="form-label">Weekday/Weekend</label>
                                      <select class="form-control col-4" name="day_type" id="day_type" required>
                                          <option value ="">---------------</option>
                                          <option value="weekday">weekday</option>
                                          <option value="weekend">weekend</option>
                                      </select>
                                </div>      

                                <div class="form-inline">
                                    <div class="form-group mb-2">
                                      <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Allocate From">
                                    </div>

                                    <div class="form-group mx-sm-1 mb-1">
                                      <label for="min" class="sr-only">Min</label>
                                      <input type="number" class="form-control col-4" id="min" disabled>
                                    </div>

                                    <div class="form-group">
                                      <label for="staticEmail2" class="sr-only">Email</label>
                                      <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="To">
                                    </div>

                                    <div class="form-group mx-sm-1 mb-1">
                                      <label for="max" class="sr-only">Max</label>
                                      <input type="number" class="form-control col-4" id="max" disabled>
                                    </div>

                                </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary mb-2">Reserve</button>
                                    </div>   
                            </form>                       
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="../External/Bootstrap/js/bootstrap.js"></script>
        
    </body>
</html>

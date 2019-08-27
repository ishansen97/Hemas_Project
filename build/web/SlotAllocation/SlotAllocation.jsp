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
            
            $(document).ready(function() {
                $("#p_name").change(function () {
                    var slot_count = $("option:selected", this).attr("data-count");
                    selected_slot_count = slot_count;
                    $("#no_of_slots").val(slot_count);
                });
                
                $("#min").change(function () {
                    var min = $(this).val();
                    if (selected_slot_count > 0 && min < selected_slot_count) {
                        alert("Good value");
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
                                  <label for="staticEmail2" class="form-label">No. of Slots</label>
                                  <input type="text" readonly class="form-control-plaintext" id="no_of_slots" value="">
                            </div>    
                            
                            <form class="form-inline">
                                <div class="form-group mb-2">
                                  <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Allocate From">
                                </div>
                                
                                <div class="form-group mx-sm-1 mb-1">
                                  <label for="min" class="sr-only">Min</label>
                                  <input type="number" class="form-control col-4" id="min">
                                </div>
                                
                                <div class="form-group">
                                  <label for="staticEmail2" class="sr-only">Email</label>
                                  <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="To">
                                </div>
                                
                                <div class="form-group mx-sm-1 mb-1">
                                  <label for="max" class="sr-only">Max</label>
                                  <input type="number" class="form-control col-4" id="max">
                                </div>
                                <button type="submit" class="btn btn-primary mb-2">Reserve</button>
                            </form>
                            
                                                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="../External/Bootstrap/js/bootstrap.js"></script>
        
    </body>
</html>

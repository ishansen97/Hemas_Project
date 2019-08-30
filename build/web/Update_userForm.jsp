<%-- 
    Document   : Update_userForm
    Created on : Aug 27, 2019, 4:46:30 PM
    Author     : Sandeepa Fernando
--%>

<%@page import="java.util.List"%>
<%@page import="model.GetUserResponse"%>
<%@page import="service.UserService"%>
<%@page import="model.GetUserRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./External/Bootstrap/css/bootstrap.css">
        <script src="./External/Jquery/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            int tele = Integer.parseInt(id);
            GetUserRequest user = new GetUserRequest();
            user.setTelephone(tele);
            
            GetUserResponse userList = UserService.getUser(user);
            
        %>
        <div class="container">
            <form class="form-horizontal" action="UpdateUserServlet" method="POST">

                <div class="form-group">
                    <label class="control-label col-sm-2">Full Name :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" value="<%= userList.getFname() %>"  name="fname">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">NIC :</label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" value="<%= userList.getNic()%>" name="nic">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Staff ID :</label>
                    <div class="col-sm-10">          
                        <input type="number" class="form-control" value="<%= userList.getStaffid()%>" name="staffid">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Email :</label>
                    <div class="col-sm-10">          
                        <input type="email" class="form-control" value="<%= userList.getEmail()%>" name="email">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">Vehicle No. :</label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" value="<%= userList.getVehicalno()%>" name="vehicleno">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Telephone no. :</label>
                    <div class="col-sm-10">          
                        <input type="number" class="form-control" value="<%= userList.getTelephone()%>" readonly name="telephone">
                    </div>
                </div>

                <div class="form-group">        
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

            </form>
        </div>
    </body>
</html>

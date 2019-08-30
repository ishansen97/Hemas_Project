<%-- 
    Document   : registrationPage
    Created on : Aug 26, 2019, 12:43:56 PM
    Author     : Sandeepa Fernando
--%>

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

        <div class="container">
            <form class="form-horizontal" action="RegistrationSevlet" method="POST">

                <div class="form-group">
                    <label class="control-label col-sm-2">Full Name :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Enter Full Name" name="fname">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">NIC :</label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" placeholder="Enter NIC" name="nic">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Staff ID :</label>
                    <div class="col-sm-10">          
                        <input type="number" class="form-control" placeholder="Enter Staff ID" name="staffid">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Email :</label>
                    <div class="col-sm-10">          
                        <input type="email" class="form-control" placeholder="Enter Email" name="email">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">Vehicle No. :</label>
                    <div class="col-sm-10">          
                        <input type="text" class="form-control" placeholder="Enter Vehicle No." name="vehicleno">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" >Telephone no. :</label>
                    <div class="col-sm-10">          
                        <input type="number" class="form-control" placeholder="Enter telephone no." name="telephone">
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

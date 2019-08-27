<%-- 
    Document   : Feedback
    Created on : Aug 26, 2019, 9:47:58 PM
    Author     : Ishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback Page</title>
        
        <link rel="stylesheet" href="../External/Bootstrap/css/bootstrap.css">
    </head>
    <body>
        <% try { %>
        <% if (session.getAttribute("IsSuccess").equals(true)) { %>
        <script>
            alert("feedback is successfully inserted");
        </script>
        <% session.setAttribute("IsSuccess", false); %>
        <% }%>
        <% } catch (Exception ex) { %>
        <% } %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h1 class="modal-header">Feedback Form</h1>
                        </div>

                        <div class="card-body">
                            <form action="<%=request.getContextPath() %>/FeedbackServlet" method="POST" class="was-invalidated">
                                <div class="form-group">
                                    <label for="telephone_no">Telephone No</label>
                                    <input type="number" class="form-control" name="telephone_no" min="0" maxlength="10" required />
                                </div>

                                <div class="form-group">
                                    <label for="fb_type">Feedback Type</label>
                                    <select name="fb_type" id="fb_type" class="form-control" required>
                                        <option value="">----------</option>
                                        <option value="complaint">complaint</option>
                                        <option value="suggestion">suggestion</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="fb_desc">Feedback Description</label>
                                    <textarea cols="10" rows="15" class="form-control" name="fb_desc" required></textarea>
                                </div>
                                
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Submit</button>
                                    <button type="reset" class="btn btn-danger">Reset</button>
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

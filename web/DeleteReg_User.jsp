<%-- 
    Document   : DeleteUser
    Created on : Aug 27, 2019, 11:49:47 PM
    Author     : Sandeepa Fernando
--%>

<%@page import="model.DeleteUserRequest"%>
<%@page import="service.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            int tele = Integer.parseInt(id);
            DeleteUserRequest user = new DeleteUserRequest();
            user.setTelephone(tele);

            boolean result = UserService.deleteUser(user);
            
            if (result == false) {
                response.sendRedirect("View_all_users.jsp");
            } else {
                out.println("Error");
            }

        %>
    </body>
</html>

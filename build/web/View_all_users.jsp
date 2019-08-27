<%-- 
    Document   : View_all_users
    Created on : Aug 27, 2019, 4:11:39 PM
    Author     : Sandeepa Fernando
--%>

<%@page import="service.UserService"%>
<%@page import="model.GetUserResponse"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Css/view_allcss.css">
    </head>
    <body>
        <% List<GetUserResponse> userList = UserService.getUserResponses();%>
        <table border="1" cellspacing="5" cellpadding="4" class="qlist">
            <tr>
                <th>Full Name</th>
                <th>Staff ID</th>
                <th>NIC</th>
                <th>Vehicle no.</th>
                <th>Telephone no.</th>
                <th colspan="2">Actions</th>
            </tr>

            <tr>



            <tr>
                <% for (GetUserResponse res: userList) { %>

                <td><%=res.getFname() %></td>
                <td><%=res.getStaffid() %></td>
                <td><%=res.getNic() %></td>
                <td><%=res.getVehicalno() %></td>
                <td><%=res.getTelephone() %></td>
                <td><a href="Update_userForm.jsp?id=<%=res.getTelephone() %>">update</a></td>
                <td><a href="DeleteReg_User.jsp?id=<%=res.getTelephone() %>" onclick="return confirm('Are you Sure?')">delete</a></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>

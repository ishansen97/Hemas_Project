<%-- 
    Document   : index
    Created on : Aug 26, 2019, 9:19:05 AM
    Author     : Ishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="<%=request.getContextPath() %>/InsertFeedbackServlet">
            <input type="text" name="test">
            <button type="submit">submit</button>
        </form>
    </body>
</html>

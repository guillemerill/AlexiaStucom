<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Done</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            String msg = (String) request.getAttribute("msg");
            
            if (status.equals("Ok")) { 
        %> 
            <p><%=msg %></p> 
        <% } else if (status.equals("Error")) { %>
            <p><%=msg %></p> 
        <% } %>
        <a href="index.jsp">Main menu</a>
    </body>
</html>
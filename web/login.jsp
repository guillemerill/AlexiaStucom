<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Iniciar sesión</h1>
        <%
            String status = "";
            
        if (request.getAttribute("status") != null) {
            status = (String) request.getAttribute("status"); 
        }
        %>
        <form action="UsuarioServlet" method="POST">
            <p>Nombre de usuario: <input type="text" name="nombre_usu"></p>
            <p>Password: <input type="text" name="password"></p>
            <p><input type="submit" value="Login" name="action"></p>
            <% if (status.equals("Error")) { %>
            <p style="color: red">Los datos son incorrectos</p>
            <% } %>
        </form>
    </body>
</html>

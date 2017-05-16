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
            <div><input type="submit" value="Login" name="action"></div>
            <% if (status.equals("Error")) { %>
            <div style="color: red">Los datos son incorrectos</div>
            <% } %>
        </form>
    </body>
</html>

<style>
    html {
        width: 100%;
        height: 100%;
        text-align: center;
    }
    
    body {
        width: 300px;
        display: block;
        margin: 0 auto;
        text-align: left;
    }
    
    h1 {
        width: 100%;
        text-align: center;
    }
    
    div {
        width: 100%;
        text-align: right;
    }
</style>
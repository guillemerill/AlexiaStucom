<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Nuevo alumno</h1>
        <form action="UsuarioServlet" method="POST">
            <p>Nombre de usuario: <input type="text" name="nombre_usu"></p>
            <p>Password: <input type="text" name="password"></p>
            <p><input type="submit" value="Login" name="action"></p>
        </form>
    </body>
</html>

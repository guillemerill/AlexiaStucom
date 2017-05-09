<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo profesor</title>
    </head>
    <body>
        <h1>Nuevo profesor</h1>
        <form action="UsuarioServlet" method="POST">
            <p>Nombre: <input type="text" name="nombre"></p>
            <p>Apellidos: <input type="text" name="apellidos"></p>
            <p>Nombre de usuario: <input type="text" name="nombre_usu"></p>
            <p>Password: <input type="text" name="password"></p>
            <p><input type="submit" value="Nuevo profesor" name="action"></p>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo alumno</title>
    </head>
    <body>
        <h1>Nuevo Alumno</h1>
        <form action="UsuarioServlet" method="POST">
            <p>Nombre: <input required="true" type="text" name="nombre"></p>
            <p>Apellidos: <input required="true" type="text" name="apellidos"></p>
            <p>Nombre de usuario: <input required="true" type="text" name="nombre_usu"></p>
            <p>Password: <input required="true" type="password" name="password"></p>
            <p>Curso: <input required="true" type="text" name="curso"></p>
            <p><input type="submit" value="Nuevo alumno" name="action"></p>
        </form>
                <form action="UsuarioServlet">
            <input type="submit" value="Volver al menu" name="action">
        </form>
    </body>
</html>

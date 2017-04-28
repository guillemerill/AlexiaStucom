<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alexia Stucom</title>
    </head>
    <body>
        <h1>Menú Principal</h1>
        <form action="nuevoAlumno.jsp">
            <input type="submit" value="Crear alumno">
        </form>
        <form action="AlumnoServlet">
            <input type="submit" value="Ver notas" name="action">
        </form>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva asignatura</title>
    </head>
    <body>
        <h1>Nueva asignatura</h1>
        <form action="AdminServlet" method="POST">
            <p>Nombre asignatura: <input required="true" type="text" name="nombre"></p>
            <p><input type="submit" value="Nueva asignatura" name="action"></p>
        </form>
    </body>
</html>

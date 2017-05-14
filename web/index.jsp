<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alexia Stucom</title>
    </head>
    <body>
        <h1>Menú Principal</h1>
        <%
            String tipo = (String) request.getAttribute("tipo");
        %> 
            <p>Hola, <%=request.getSession(true).getAttribute("user") %>!</p> 
        <% if (tipo.equals("ALUMNO")) { %>
        <form action="AlumnoServlet">
                <input type="submit" value="Apuntarse a una asignatura" name="action">
            </form>
            <form action="AlumnoServlet">
                <input type="submit" value="Ver notas" name="action">
            </form>
            <form action="AlumnoServlet">
                <input type="submit" value="Ver faltas" name="action">
            </form>
        <% } else if (tipo.equals("PROFESOR")) { %>
            <form action="ProfesorServlet">
                <input type="submit" value="Apuntarse a una asignatura" name="action">
            </form>
            <form action="ProfesorServlet">
                <input type="submit" value="Ver alumnos" name="action">
            </form>
            <form action="ProfesorServlet">
                <input type="submit" value="Introducir notas" name="action">
            </form>
            <form action="ProfesorServlet">
                <input type="submit" value="Introducir faltas" name="action">
            </form>
        <% } else if (tipo.equals("ADMIN")) {%>
            <form action="nuevoAlumno.jsp">
                <input type="submit" value="Crear alumno">
            </form>
             <form action="nuevoProfesor.jsp">
                <input type="submit" value="Crear profesor">
            </form>
             <form action="AdminServlet">
                <input type="submit" value="Eliminar alumno" name="action">
            </form>
            <form action="AdminServlet">
                <input type="submit" value="Eliminar profesor" name="action">
            </form>
        <% } %>
    </body>
</html>
<%@page import="entidades.Alumno"%>
<%@page import="entidades.Asignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar alumnos</title>
    </head>
    <body>
        <p>Selecciona un alumno</p>
        <form action="AdminServlet" method="POST">
            <div>Selecciona el alumno</div>
            <select name="alumno">
                <%
                List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");
                    if (alumnos.size() > 0) {
                       for (Alumno a : alumnos) { 
                %> 
                        <option value="<%=a.getIdalumno()%>"><%=a.getNombre()%> <%=a.getApellidos()%></option>
                    <% }        
                    } else { %>
                        <option value="0">No hay alumnos</option>
                <% } %>
            </select>
             <p><input type="submit" value="Eliminar este alumno" name="action"></p>
        </form>
        <form action="UsuarioServlet">
            <input type="submit" value="Volver al menu" name="action">
        </form>
    </body>
</html>

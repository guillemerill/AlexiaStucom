<%@page import="entidades.Alumno"%>
<%@page import="entidades.Asignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar asignaturas</title>
    </head>
    <body>
        <p>Selecciona un asignatura</p>
        <form action="AdminServlet" method="POST">
            <%
            List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");
            if (asignaturas.size() > 0) { %>
                <select name="asignatura">
                    <% for (Asignatura a : asignaturas) { %> 
                        <option value="<%=a.getIdasignatura()%>"><%=a.getNombre()%></option>
                    <% } %>  
                </select>
                <p><input type="submit" value="Eliminar este profesor" name="action"></p>
            <% } else { %>
                <div>No hay profesores.</div>
            <% } %>
        </form>
        <form action="UsuarioServlet">
            <input type="submit" value="Volver al menu" name="action">
        </form>
    </body>
</html>

<%@page import="entidades.Profesor"%>
<%@page import="entidades.Alumno"%>
<%@page import="entidades.Asignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar profesores</title>
    </head>
    <body>
        <p>Selecciona un profesor</p>
        <form action="AdminServlet" method="POST">
            <%
            List<Profesor> profesores = (List<Profesor>) request.getAttribute("profesores");
            if (profesores.size() > 0) { %>
                <select name="profesor">
                   <% for (Profesor p : profesores) { %> 
                        <option value="<%=p.getIdprofesor()%>"><%=p.getNombre()%> <%=p.getApellidos()%></option>
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

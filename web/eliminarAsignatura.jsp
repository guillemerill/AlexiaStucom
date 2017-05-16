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
            <div>Selecciona la asignatura</div>
            <select name="asignatura">
                <%
                List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");
                    if (asignaturas.size() == 0) {
                       for (Asignatura a : asignaturas) { 
                %> 
                        <option value="<%=a.getIdasignatura()%>"><%=a.getNombre()%></option>
                    <% }        
                    } else { %>
                        <option value="0">No hay asignaturas</option>
                <% } %>
            </select>
             <p><input type="submit" value="Eliminar esta asignatura" name="action"></p>
        </form>
        <a href="index.jsp">Main menu</a>
    </body>
</html>

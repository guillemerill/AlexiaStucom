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
            <div>Selecciona el profesor</div>
            <select name="profesor">
                <%
                List<Profesor> profesores = (List<Profesor>) request.getAttribute("profesores");
                    if (profesores.size() == 0) {
                       for (Profesor p : profesores) { 
                %> 
                        <option value="<%=p.getIdprofesor()%>"><%=p.getNombre()%> <%=p.getApellidos()%></option>
                    <% }        
                    } else { %>
                        <option value="0">No hay profesores</option>
                <% } %>
            </select>
             <p><input type="submit" value="Eliminar este profesor" name="action"></p>
        </form>
        <a href="index.jsp">Main menu</a>
    </body>
</html>

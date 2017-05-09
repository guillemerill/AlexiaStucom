<%@page import="entidades.Alumno"%>
<%@page import="entidades.Asignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introducr notas</title>
    </head>
    <body>
        <p>Selecciona una asignatura</p>
        <%
           if (request.getAttribute("alumnos") == null) {
        %>
         <form action="ProfesorServlet" method="POST">
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
            <p><input type="submit" value="Seleccionar asignatura" name="action"></p>
        </form>
        <% } else { %>
        <form action="ProfesorServlet" method="POST">
        <div>Selecciona el alumno</div>
            <%
            List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumno");
                if (alumnos.size() == 0) {
                   for (Alumno a : alumnos) { 
            %> 
                    <option value="<%=a.getIdalumno()%>"><%=a.getNombre()%> <%=a.getApellidos()%></option>
                <% }        
                } else { %>
                    <option value="0">No hay alumnos</option>
            <% } %>
             <p>Nota <input type="number" name="nota"></p>
             <p><input type="submit" value="Poner nota" name="action"></p>
        </form>
        <% } %>
        <a href="index.jsp">Main menu</a>
    </body>
</html>

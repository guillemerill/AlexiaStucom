<%@page import="entidades.Profesor"%>
<%@page import="entidades.Alumno"%>
<%@page import="entidades.Asignatura"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apuntate a una asignatura</title>
    </head>
    <body>
        <p>Selecciona una asignatura</p>
        <%
           if (request.getAttribute("profesores") == null) {
        %>
         <form action="UsuarioServlet" method="POST">
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
        <form action="UsuarioServlet" method="POST">
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
                        <option value="0">No hay alumnos</option>
                <% } %>
            </select>
             <input type="hidden" name="asignatura" value="<%=request.getAttribute("asignatura")%>"/>
             <p><input type="submit" value="Poner nota" name="action"></p>
        </form>
        <% } %>
        <a href="index.jsp">Main menu</a>
    </body>
</html>

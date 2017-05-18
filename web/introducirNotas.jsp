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
        <%
           if (request.getAttribute("alumnos") == null) {
        %>
         <form action="ProfesorServlet" method="POST">
            <div>Selecciona la asignatura</div>
            
             <%
                List<Asignatura> asignaturas = (List<Asignatura>) request.getAttribute("asignaturas");
                if (asignaturas.size() > 0) { %>
                <select name="asignatura">
                  <% for (Asignatura a : asignaturas) { 
            %> 
                    <option value="<%=a.getIdasignatura()%>"><%=a.getNombre()%></option>
                <% }    %>
                </select>
            <p><input type="submit" value="Seleccionar asignatura" name="action"></p>
               <% } else { %>
                <div> No hay asignaturas.</div>
            <% } %>
            
        </form>
        <% } else { %>
        <form action="ProfesorServlet" method="POST">
        
            <%
            List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");
                if (alumnos.size() == 0) { %>
                        <div>Selecciona el alumno</div>
                        <select name="alumno">
                         <%  for (Alumno a : alumnos) { 
                    %> 
                            <option value="<%=a.getIdalumno()%>"><%=a.getNombre()%> <%=a.getApellidos()%></option>
                        <% }   %>
                        </select>
                     <p>Nota <input type="number" name="nota"></p>
                     <input type="hidden" name="asignatura" value="<%=request.getAttribute("asignatura")%>"/>
                     <p><input type="submit" value="Poner nota" name="action"></p>
                <% } else { %>
                    <div>No hay alumnos</div>
                <% } %>
        </form>
        <% } %>
        <form action="UsuarioServlet">
            <input type="submit" value="Volver al menu" name="action">
        </form>   
    </body>
</html>

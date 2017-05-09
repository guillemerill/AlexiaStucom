<%@page import="entidades.NotasDTO"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Nota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis notas</title>
    </head>
    
        <p>Hola, <%=request.getSession(true).getAttribute("user") %>!</p> 
        <h1>Mis notas</h1>
       
        <%
            List<NotasDTO> notas = (List<NotasDTO>) request.getAttribute("notas");
            if (notas.size() == 0) {
        %> 
            <p>No se han encontrado notas.</p>
        <% 
            } else {
        %>
            <table border="1">
                <thead>
                    <tr>
                        <th>Asignatura</th>
                        <th>Profesor</th>
                        <th>Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(DAONotas n : notas) {%>
                        <tr>
                            <td><%=n.getAsignatura() %></td>
                            <td><%=n.getProfesor() %></td>
                            <td><%=n.getNota() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

        
        <% } %>
   >
</html>

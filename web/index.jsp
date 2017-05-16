<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alexia Stucom</title>
    </head>
    <body>
        <div id="header"><p style="margin-right: 20px;">Hola, <%=request.getSession(true).getAttribute("user") %>!</p></div>
        <div id="menu">
            <h1>Menú Principal</h1>
            <%
                String tipo = (String) request.getAttribute("tipo");
            %> 
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
             <form action="nuevaAsignatura.jsp">
                    <input type="submit" value="Crear asignatura">
                </form>
                <form action="nuevoAlumno.jsp">
                    <input type="submit" value="Crear alumno">
                </form>
                 <form action="nuevoProfesor.jsp">
                    <input type="submit" value="Crear profesor">
                </form>
                <form action="AdminServlet">
                    <input type="submit" value="Eliminar asignatura" name="action">
                </form>
                 <form action="AdminServlet">
                    <input type="submit" value="Eliminar alumno" name="action">
                </form>
                <form action="AdminServlet">
                    <input type="submit" value="Eliminar profesor" name="action">
                </form>
            <% } %>
        </div>
    </body>
</html>


<style>
    html, body {
        top: 0;
        left: 0;    
        width: 100%;
        height: 100%;
    }
    
    #header {
        margin-top: 0%;
        width: 100%;
        height: 30px;   
        text-align: right;
    }
    
    #menu {
        width: 300px;
        display: block;
        margin: 0 auto;
        text-align: left;
    }
    
    h1 {
        width: 100%;
        text-align: center;
    }
    
    input {
        margin-top: 10px;
    }
    
</style>
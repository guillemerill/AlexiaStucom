package servlets;

import beans.AlexiaEJB;
import entidades.Alumno;
import entidades.Asignatura;
import entidades.Profesor;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    @EJB AlexiaEJB ejb;
    public static final String STATUS_OK = "Ok";
    public static final String STATUS_ERROR = "Error";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if ("Eliminar asignatura".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            List<Asignatura> asignaturas = ejb.getAllAsignaturas();

            String msg;
            if (!asignaturas.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("asignaturas", asignaturas);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No hay asignaturas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/eliminarAsignatura.jsp").forward(request, response);
        } else if ("Eliminar esta asignatura".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idAsignatura = Integer.parseInt(request.getParameter("asignatura"));
// TODO: id 0
            String msg;
            if (ejb.eliminarAsignatura(idAsignatura)) {
                request.setAttribute("status", STATUS_OK);
                msg = "La asignatura se ha eliminado correctamente.";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al eliminar la asignatura.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }
        
        if ("Eliminar alumno".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            List<Alumno> alumnos = ejb.getAllAlumnos();

            String msg;
            if (!alumnos.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("alumnos", alumnos);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No hay alumnos.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/eliminarAlumno.jsp").forward(request, response);
        } else if ("Eliminar este alumno".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idAlumno = Integer.parseInt(request.getParameter("alumno"));

            String msg;
            if (ejb.eliminarAlumno(idAlumno)) {
                request.setAttribute("status", STATUS_OK);
                msg = "El alumno se ha eliminado correctamente.";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al eliminar el alumno.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }
        
        if ("Eliminar profesor".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            List<Profesor> profesores = ejb.getAllProfesor();

            String msg;
            if (!profesores.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("profesores", profesores);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No hay profesores.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/eliminarProfesor.jsp").forward(request, response);
        } else if ("Eliminar este profesor".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idProfesor = Integer.parseInt(request.getParameter("profesor"));

            String msg;
            if (ejb.eliminarProfesor(idProfesor)) {
                request.setAttribute("status", STATUS_OK);
                msg = "El profesor se ha eliminado correctamente.";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al eliminar el profesor.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }
        
        if ("Nueva asignatura".equals(request.getParameter("action"))) {
            Asignatura asignatura = new Asignatura(request.getParameter("nombre"));
            String msg;
            if (ejb.insertAsignatura(asignatura)) {
                request.setAttribute("status", STATUS_OK);
                msg = "La asignatura se ha creado correctamente";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al crear la asignatura.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

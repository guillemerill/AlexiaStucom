package servlets;

import beans.AlexiaEJB;
import entidades.Asignatura;
import entidades.NotasDTO;
import entidades.Profesor;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAM
 */
@WebServlet(name = "AlumnoServlet", urlPatterns = {"/AlumnoServlet"})
public class AlumnoServlet extends HttpServlet {

    @EJB AlexiaEJB ejb;
    public static final String STATUS_OK = "Ok";
    public static final String STATUS_ERROR = "Error";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("Apuntarse a una asignatura".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            List<Asignatura> asignaturas = ejb.getAllAsignaturas();
            // TODO: controlar las asignaturas a las que ya se ha apuntado

            String msg;
            if (!asignaturas.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("asignaturas", asignaturas);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No hay asignaturas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/apuntarAlumnoAsignatura.jsp").forward(request, response);
        } else if ("Seleccionar asignatura".equals(request.getParameter("action"))) {
             String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idAsignatura = Integer.parseInt(request.getParameter("asignatura"));
            
            List<Profesor> profesores = ejb.getProfesoresByAsignatura(idAsignatura);
            
            String msg;
            if (!profesores.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("profesores", profesores);
                request.setAttribute("asignatura", idAsignatura);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No se han introducido notas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/apuntarAlumnoAsignatura.jsp").forward(request, response);
        } else if ("Apuntarse".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idAsignatura = Integer.parseInt(request.getParameter("asignatura"));
            int idProfesor = Integer.parseInt(request.getParameter("profesor"));

            String msg;
            if (ejb.apuntarAlumnoAsignatura(idAsignatura, idProfesor, user)) {
                request.setAttribute("status", STATUS_OK);
                msg = "Te has apuntado correctamente.";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al apuntarte.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        }
        
        if ("Ver notas".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");

            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            List<NotasDTO> notas = ejb.getNotasByAlumno(user);
            
            String msg;
            if (!notas.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("notas", notas);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No se han introducido notas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/notas.jsp").forward(request, response);
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

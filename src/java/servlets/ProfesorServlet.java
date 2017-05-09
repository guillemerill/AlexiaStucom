/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AlexiaEJB;
import entidades.Alumno;
import entidades.Asignatura;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/AlumnoServlet"})
public class ProfesorServlet extends HttpServlet {

    @EJB AlexiaEJB ejb;
    public static final String STATUS_OK = "Ok";
    public static final String STATUS_ERROR = "Error";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("Introducir notas".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");

            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            List<Asignatura> asignaturas = ejb.getAsignaturasByProfesor(user);
            
            String msg;
            if (!asignaturas.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("asignaturas", asignaturas);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No se han introducido notas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/introducirNotas.jsp").forward(request, response);
        } else if ("Seleccionar asignatura".equals(request.getParameter("action"))) {
             String user = (String) request.getSession(true).getAttribute("user");

            if (user.equals("")) {
                request.setAttribute("msg", "Debes iniciar sesión.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            
            int idAsignatura = Integer.parseInt(request.getParameter("asignatura"));
            
            List<Alumno> alumnos = ejb.getAlumnosByProfesorAsignatura(idAsignatura, user);
            
            String msg;
            if (!asignaturas.isEmpty()) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("asignaturas", asignaturas);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "No se han introducido notas.";
                request.setAttribute("msg", msg);
            }
            
            request.getRequestDispatcher("/introducirNotas.jsp").forward(request, response);
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

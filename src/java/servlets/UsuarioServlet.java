package servlets;

import Util.MD5;
import beans.AlexiaEJB;
import entidades.Alumno;
import entidades.Profesor;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @EJB AlexiaEJB ejb;
    public static final String STATUS_OK = "Ok";
    public static final String STATUS_ERROR = "Error";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("Login".equals(request.getParameter("action"))) {
            String user = request.getParameter("nombre_usu");
            String pwd = MD5.getMD5(request.getParameter("password"));
            if (ejb.login(user, pwd)) {
                request.setAttribute("status", STATUS_OK);
                request.getSession(true).setAttribute("user", user);
                request.setAttribute("tipo", ejb.getTipoUsuario(user));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("Volver al menu".equals(request.getParameter("action"))) {
            String user = (String) request.getSession(true).getAttribute("user");
            if (request.getSession(true).getAttribute("user") != null) {
                request.setAttribute("status", STATUS_OK);
                request.setAttribute("tipo", ejb.getTipoUsuario(user));
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("status", STATUS_ERROR);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("Nuevo alumno".equals(request.getParameter("action"))) {
            String pwd = MD5.getMD5(request.getParameter("password"));
            Alumno nuevo = new Alumno(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("nombre_usu"), pwd, request.getParameter("curso"));
            String msg;
            if (ejb.insertAlumno(nuevo)) {
                request.setAttribute("status", STATUS_OK);
                msg = "El alumno se ha creado correctamente";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al crear el alumno.";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/final.jsp").forward(request, response);
        } else if ("Nuevo profesor".equals(request.getParameter("action"))) {
            String pwd = MD5.getMD5(request.getParameter("password"));
            Profesor nuevo = new Profesor(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("nombre_usu"), pwd);
            String msg;
            if (ejb.insertProfesor(nuevo)) {
                request.setAttribute("status", STATUS_OK);
                msg = "El profesor se ha creado correctamente";
            } else {
                request.setAttribute("status", STATUS_ERROR);
                msg = "Ha ocurrido un error al crear el profesor.";
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

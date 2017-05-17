package beans;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Matricula;
import entidades.NotasDTO;
import entidades.Nota;
import entidades.Profesor;
import entidades.ProfesorAsignatura;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class AlexiaEJB {
    @PersistenceUnit
    EntityManagerFactory emf;
    
    // Funciones internas para encontrar usuarios
    private Usuario getUsuarioBynombreUsu(String nombre_usu) {
        Usuario a = new Usuario();
        List<Usuario> usuarios = emf.createEntityManager().createNamedQuery("Usuario.findByNombreUsu").setParameter("nombre_usu", nombre_usu).getResultList();
        if (!usuarios.isEmpty()) {
            a = usuarios.get(0);
        }
           
        return a;
    }
    
    private Alumno getAlumnoBynombreUsu(String nombre_usu) {
        Alumno a = new Alumno();
        List<Alumno> alumnos = emf.createEntityManager().createNamedQuery("Alumno.findByNombreUsu").setParameter("nombre_usu", nombre_usu).getResultList();
        if (!alumnos.isEmpty()) {
            a = alumnos.get(0);
        }
           
        return a;
    }
    
    private Profesor getProfesorBynombreUsu(String nombre_usu) {
        Profesor p = new Profesor();
        List<Profesor> profesores = emf.createEntityManager().createNamedQuery("Profesor.findByNombreUsu").setParameter("nombre_usu", nombre_usu).getResultList();
        if (!profesores.isEmpty()) {
            p = profesores.get(0);
        }
        return p;
    }
    
    private boolean existeUsuario(String nombre_usu) {
        return (emf.createEntityManager().find(Usuario.class, nombre_usu)) != null;
    }

    private boolean existeAlumno(Alumno a) {
        return !emf.createEntityManager().createNamedQuery("Alumno.findByNombreUsu").setParameter("nombre_usu", a.getNombreUsu()).getResultList().isEmpty();
    }
    
    private boolean existeProfesor(Profesor p) {
        return !emf.createEntityManager().createNamedQuery("Profesor.findByNombreUsu").setParameter("nombreUsu", p.getNombreUsu()).getResultList().isEmpty();
    }
    
    private boolean existeAsignatura(Asignatura a) {
        return !emf.createEntityManager().createNamedQuery("Asignatura.findByNombre").setParameter("nombre", a.getNombre()).getResultList().isEmpty();
    }
    
    private String getAsignaturaById(int idasignatura) {
        return emf.createEntityManager().find(Asignatura.class, idasignatura).getNombre();
    }
    
    private String getProfesorById(int idprofesor) {
        return emf.createEntityManager().find(Profesor.class, idprofesor).getNombre();
    }
    
    private String getAlumnoById(int idAlumno) {
        return emf.createEntityManager().find(Alumno.class, idAlumno).getNombre();
    }
       
    
    // UsuarioServlet
    public boolean login(String nombre_usu, String pwd) {
        Usuario usu = emf.createEntityManager().find(Usuario.class, nombre_usu);
        if (usu != null) {
            if (usu.getPassword().equals(pwd))
                return true;
        }
        return false;
    }
    
    public String getTipoUsuario(String nombre_usu) {
        Usuario usu = emf.createEntityManager().find(Usuario.class, nombre_usu);
        return usu.getTipo();
    }

    public boolean insertAlumno(Alumno a) {
        EntityManager em = emf.createEntityManager();
        boolean ok = false;
        if (!existeAlumno(a)) {
            if (!existeUsuario(a.getNombreUsu())) {
                em.persist(new Usuario(a.getNombreUsu(), a.getPass(), "ALUMNO"));
                em.persist(a);
                ok = true;
            }
        }
        em.close();
        return ok;
    }
    
    public boolean insertProfesor(Profesor p) {
        EntityManager em = emf.createEntityManager();
        boolean ok = false;
        if (!existeProfesor(p)) {
            if (!existeUsuario(p.getNombreUsu())) {
                em.persist(new Usuario(p.getNombreUsu(), p.getPass(), "PROFESOR"));
                em.persist(p);
                ok = true;
            }
        }
        em.close();
        return ok;
    }
    
    
    // AdminServlet
    public boolean insertAsignatura(Asignatura a) {
        EntityManager em = emf.createEntityManager();
        boolean ok = false;
        System.out.println(a.toString());
        if (!existeAsignatura(a)) {
            em.persist(a);
            ok = true;
        }
        System.out.println(existeAsignatura(a));
        em.close();
        return ok;
    }
    
    public List<Alumno> getAllAlumnos() {
        return emf.createEntityManager().createNamedQuery("Alumno.findAll").getResultList();
    }
    
    public boolean eliminarAlumno(int idAlumno) {
        EntityManager em = emf.createEntityManager();
        Alumno alumno = getAlumnoBynombreUsu(getAlumnoById(idAlumno));
        boolean ok = false;
        if (alumno != null) {
            Usuario u = getUsuarioBynombreUsu(alumno.getNombreUsu());
            if (u != null) {
                em.remove(u);
            }

            em.remove(alumno);
            ok = true;
        } 
        em.close();
        return ok;
    }
        
    public List<Profesor> getAllProfesor() {
        return emf.createEntityManager().createNamedQuery("Profesor.findAll").getResultList();
    }
    
     public boolean eliminarProfesor(int idProfesor) {
        EntityManager em = emf.createEntityManager();
        Profesor profesor = getProfesorBynombreUsu(getProfesorById(idProfesor));
        boolean ok = false;
        if (profesor != null) {
            Usuario u = getUsuarioBynombreUsu(profesor.getNombreUsu());
            if (u != null) {
                em.remove(u);
            }

            em.remove(profesor);
            ok = true;
        } 
        em.close();
        return ok;
    }
    
     
    // AlumnoServlet
    public List<Asignatura> getAllAsignaturas() {
        return emf.createEntityManager().createNamedQuery("Asignatura.findAll").getResultList();
    }
    
    public List<Profesor> getProfesoresByAsignatura(int idAsignatura) {
        List<ProfesorAsignatura> idProfesores = emf.createEntityManager().createNamedQuery("ProfesorAsignatura.findByIdasignatura").setParameter("idasignatura", idAsignatura).getResultList();
        ArrayList<Integer> profesores = new ArrayList<>();
        
        for (ProfesorAsignatura p : idProfesores) {
            profesores.add(p.getIdprofesor());
        }
        List<Profesor> profesoresList = emf.createEntityManager().createNamedQuery("Profesor.findByidIn").setParameter("id", profesores).getResultList();

        return profesoresList;
    }
    
    public boolean apuntarAlumnoAsignatura(int idAsignatura, int idProfesor, String alumno) {
        Alumno a = getAlumnoBynombreUsu(alumno);
        EntityManager em = emf.createEntityManager();
        em.persist(new Matricula(idAsignatura, a.getIdalumno(), idProfesor));
        em.close();
        return true;
    }
     
    public List<NotasDTO> getNotasByAlumno(String nombre_usu) {
        Alumno a = getAlumnoBynombreUsu(nombre_usu);
       
        List<Nota> notas = emf.createEntityManager().createNamedQuery("Nota.findByIdalumno").setParameter("idalumno", a.getIdalumno()).getResultList();
        List<NotasDTO> nfinal = new ArrayList();
        
        for (Nota n : notas) {
            nfinal.add(new NotasDTO(getAsignaturaById(n.getIdasignatura()), getProfesorById(n.getIdprofesor()), n.getNota()));
        }
        
        return nfinal;
    }
    
    
    // ProfesorServlet    
    public boolean apuntarProfesorAsignatura(int idAsignatura, String profesor) {
        Profesor p = getProfesorBynombreUsu(profesor);
        EntityManager em = emf.createEntityManager();
        em.persist(new ProfesorAsignatura(idAsignatura, p.getIdprofesor()));
        em.close();
        return true;
    }
    
    public List<Asignatura> getAsignaturasByProfesor(String nombre_usu) {
        Profesor p = getProfesorBynombreUsu(nombre_usu);
        List<ProfesorAsignatura> idAsignaturas = emf.createEntityManager().createNamedQuery("Asignatura.findByIdprofesor").setParameter("idprofesor", p.getIdprofesor()).getResultList();
        ArrayList<Integer> asign = new ArrayList<>();
        
        for (ProfesorAsignatura a : idAsignaturas) {
            asign.add(a.getIdasignatura());
        }
        return emf.createEntityManager().createNamedQuery("Asignatura.findByIdasignaturaIn").setParameter("idasignatura", asign).getResultList();
    }
    
    public List<Alumno> getAlumnosByProfesorAsignatura(int idAsignatura, String nombre_usu) {
        Profesor p = getProfesorBynombreUsu(nombre_usu);
        List<Matricula> idAlumnos = emf.createEntityManager().createNamedQuery("Matricula.findByIdProfesorIdAlumno").setParameter("idProfesor", p.getIdprofesor()).setParameter("idAsignatura", idAsignatura).getResultList();
        ArrayList<Integer> alumnos = new ArrayList<>();
        
        for (Matricula m : idAlumnos) {
            alumnos.add(m.getIdAlumno());
        }
        List<Alumno> alumnosList = emf.createEntityManager().createNamedQuery("Alumno.findByidIn").setParameter("id", alumnos).getResultList();

        return alumnosList;
    }    
    
    public boolean insertNota(Double nota, int idAlumno, int idAsignatura, String profesor) {
        Profesor p = getProfesorBynombreUsu(profesor);
        EntityManager em = emf.createEntityManager();
        em.persist(new Nota(nota, idAlumno, idAsignatura, p.getIdprofesor()));
        em.close();
        return true;
    }    
}

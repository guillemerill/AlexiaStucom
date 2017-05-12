package beans;

import entidades.Alumno;
import entidades.Asignatura;
import entidades.Matricula;
import entidades.NotasDTO;
import entidades.Nota;
import entidades.Profesor;
import entidades.ProfesorAsignatura;
import entidades.Usuario;
import java.lang.reflect.Array;
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
    
    public boolean login(String nombre_usu, String pwd) {
        Usuario usu = emf.createEntityManager().find(Usuario.class, nombre_usu);
        if (usu != null) {
            if (usu.getPassword().equals(pwd))
                return true;
        }
        return false;
    }
    
    private boolean existeUsuario(String nombre_usu) {
        return (emf.createEntityManager().find(Usuario.class, nombre_usu)) != null;
    }

    private boolean existeAlumno(Alumno a) {
        return (emf.createEntityManager().createNamedQuery("Alumno.findByNombreUsu").setParameter("nombreUsu", a.getNombreUsu())) != null;
    }
    
    private boolean existeProfesor(Profesor p) {
        return (emf.createEntityManager().createNamedQuery("Alumno.findByNombreUsu").setParameter("nombreUsu", p.getNombreUsu())) != null;
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
    
    public List<NotasDTO> getNotasByAlumno(String nombre_usu) {
        Alumno a = getAlumnoBynombreUsu(nombre_usu);
       
        List<Nota> notas = emf.createEntityManager().createNamedQuery("Nota.findByIdalumno").setParameter("idalumno", a.getIdalumno()).getResultList();
        List<NotasDTO> nfinal = new ArrayList();
        
        for (Nota n : notas) {
            nfinal.add(new NotasDTO(getAsignaturaById(n.getIdasignatura()), getProfesorById(n.getIdprofesor()), n.getNota()));
        }
        
        return nfinal;
    }
    
    public List<Asignatura> getAsignaturasByProfesor(String nombre_usu) {
        Profesor p = getProfesorBynombreUsu(nombre_usu);
        List<ProfesorAsignatura> idAsignaturas = emf.createEntityManager().createNamedQuery("findByIdprofesor").setParameter("idprofesor", p.getIdprofesor()).getResultList();
        ArrayList<Integer> asign = new ArrayList<>();
        
        for (ProfesorAsignatura a : idAsignaturas) {
            asign.add(a.getIdasignatura());
        }
        List<Asignatura> asignaturas = emf.createEntityManager().createNamedQuery("Asignatura.findByIdasignaturaIn").setParameter("idasignatura", asign).getResultList();

        return asignaturas;
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
    
    public String getTipoUsuario(String nombre_usu) {
        Usuario usu = emf.createEntityManager().find(Usuario.class, nombre_usu);
        return usu.getTipo();
    }
    
    private String getAsignaturaById(int idasignatura) {
        return emf.createEntityManager().find(Asignatura.class, idasignatura).getNombre();
    }
    
    private String getProfesorById(int idprofesor) {
        return emf.createEntityManager().find(Profesor.class, idprofesor).getNombre();
    }
}

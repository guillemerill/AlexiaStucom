package beans;

import entidades.Alumno;
import entidades.Nota;
import entidades.Profesor;
import entidades.Usuario;
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

        if (usu==null) {
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
    
    public List<Nota> getNotasByAlumno(String nombre_usu) {
        Alumno a = getAlumnoBynombreUsu(nombre_usu);
       
        return emf.createEntityManager().createNamedQuery("Nota.findByIdalumno").setParameter("idalumno", a.getIdalumno()).getResultList();
    }
}
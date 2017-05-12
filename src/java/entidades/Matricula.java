/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAM
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id")
    , @NamedQuery(name = "Matricula.findByIdAsignatura", query = "SELECT m FROM Matricula m WHERE m.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Matricula.findByIdAlumno", query = "SELECT m FROM Matricula m WHERE m.idAlumno = :idAlumno")
    , @NamedQuery(name = "Matricula.findByIdProfesorIdAlumno", query = "SELECT m FROM Matricula m WHERE m.idProfesor = :idProfesor AND m.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Matricula.findByIdProfesor", query = "SELECT m FROM Matricula m WHERE m.idProfesor = :idProfesor")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAsignatura")
    private int idAsignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlumno")
    private int idAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProfesor")
    private int idProfesor;

    public Matricula() {
    }

    public Matricula(Integer id) {
        this.id = id;
    }

    public Matricula(Integer id, int idAsignatura, int idAlumno, int idProfesor) {
        this.id = id;
        this.idAsignatura = idAsignatura;
        this.idAlumno = idAlumno;
        this.idProfesor = idProfesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Matricula[ id=" + id + " ]";
    }
    
}

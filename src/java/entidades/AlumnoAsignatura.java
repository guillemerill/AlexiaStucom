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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAM
 */
@Entity
@Table(name = "alumno_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoAsignatura.findAll", query = "SELECT a FROM AlumnoAsignatura a")
    , @NamedQuery(name = "AlumnoAsignatura.findByIdalumnoAsignatura", query = "SELECT a FROM AlumnoAsignatura a WHERE a.idalumnoAsignatura = :idalumnoAsignatura")
    , @NamedQuery(name = "AlumnoAsignatura.findByIdalumno", query = "SELECT a FROM AlumnoAsignatura a WHERE a.idalumno = :idalumno")
    , @NamedQuery(name = "AlumnoAsignatura.findByIdasignatura", query = "SELECT a FROM AlumnoAsignatura a WHERE a.idasignatura = :idasignatura")})
public class AlumnoAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalumno_asignatura")
    private Integer idalumnoAsignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private int idalumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idasignatura")
    private String idasignatura;

    public AlumnoAsignatura() {
    }

    public AlumnoAsignatura(Integer idalumnoAsignatura) {
        this.idalumnoAsignatura = idalumnoAsignatura;
    }

    public AlumnoAsignatura(Integer idalumnoAsignatura, int idalumno, String idasignatura) {
        this.idalumnoAsignatura = idalumnoAsignatura;
        this.idalumno = idalumno;
        this.idasignatura = idasignatura;
    }

    public Integer getIdalumnoAsignatura() {
        return idalumnoAsignatura;
    }

    public void setIdalumnoAsignatura(Integer idalumnoAsignatura) {
        this.idalumnoAsignatura = idalumnoAsignatura;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(String idasignatura) {
        this.idasignatura = idasignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumnoAsignatura != null ? idalumnoAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoAsignatura)) {
            return false;
        }
        AlumnoAsignatura other = (AlumnoAsignatura) object;
        if ((this.idalumnoAsignatura == null && other.idalumnoAsignatura != null) || (this.idalumnoAsignatura != null && !this.idalumnoAsignatura.equals(other.idalumnoAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AlumnoAsignatura[ idalumnoAsignatura=" + idalumnoAsignatura + " ]";
    }
    
}

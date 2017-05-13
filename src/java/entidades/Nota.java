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
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")
    , @NamedQuery(name = "Nota.findByIdnota", query = "SELECT n FROM Nota n WHERE n.idnota = :idnota")
    , @NamedQuery(name = "Nota.findByNota", query = "SELECT n FROM Nota n WHERE n.nota = :nota")
    , @NamedQuery(name = "Nota.findByIdasignatura", query = "SELECT n FROM Nota n WHERE n.idasignatura = :idasignatura")
    , @NamedQuery(name = "Nota.findByIdalumno", query = "SELECT n FROM Nota n WHERE n.idalumno = :idalumno")
    , @NamedQuery(name = "Nota.findByIdprofesor", query = "SELECT n FROM Nota n WHERE n.idprofesor = :idprofesor")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnota")
    private Integer idnota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private double nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignatura")
    private int idasignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private int idalumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofesor")
    private int idprofesor;

    public Nota() {
    }

    public Nota(Integer idnota) {
        this.idnota = idnota;
    }

    public Nota(double nota, int idasignatura, int idalumno, int idprofesor) {
        this.nota = nota;
        this.idasignatura = idasignatura;
        this.idalumno = idalumno;
        this.idprofesor = idprofesor;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Nota[ idnota=" + idnota + " ]";
    }
    
}

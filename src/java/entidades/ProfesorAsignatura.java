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
@Table(name = "profesor_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesorAsignatura.findAll", query = "SELECT p FROM ProfesorAsignatura p")
    , @NamedQuery(name = "ProfesorAsignatura.findByIdprofesorAsignatura", query = "SELECT p FROM ProfesorAsignatura p WHERE p.idprofesorAsignatura = :idprofesorAsignatura")
    , @NamedQuery(name = "ProfesorAsignatura.findByIdprofesor", query = "SELECT p FROM ProfesorAsignatura p WHERE p.idprofesor = :idprofesor")
    , @NamedQuery(name = "ProfesorAsignatura.findByIdasignatura", query = "SELECT p FROM ProfesorAsignatura p WHERE p.idasignatura = :idasignatura")})
public class ProfesorAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor_asignatura")
    private Integer idprofesorAsignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofesor")
    private int idprofesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignatura")
    private int idasignatura;

    public ProfesorAsignatura() {
    }

    public ProfesorAsignatura(Integer idprofesorAsignatura) {
        this.idprofesorAsignatura = idprofesorAsignatura;
    }

    public ProfesorAsignatura(Integer idprofesorAsignatura, int idprofesor, int idasignatura) {
        this.idprofesorAsignatura = idprofesorAsignatura;
        this.idprofesor = idprofesor;
        this.idasignatura = idasignatura;
    }

    public Integer getIdprofesorAsignatura() {
        return idprofesorAsignatura;
    }

    public void setIdprofesorAsignatura(Integer idprofesorAsignatura) {
        this.idprofesorAsignatura = idprofesorAsignatura;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesorAsignatura != null ? idprofesorAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorAsignatura)) {
            return false;
        }
        ProfesorAsignatura other = (ProfesorAsignatura) object;
        if ((this.idprofesorAsignatura == null && other.idprofesorAsignatura != null) || (this.idprofesorAsignatura != null && !this.idprofesorAsignatura.equals(other.idprofesorAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProfesorAsignatura[ idprofesorAsignatura=" + idprofesorAsignatura + " ]";
    }
    
}

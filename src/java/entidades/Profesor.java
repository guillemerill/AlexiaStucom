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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
    , @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor")
    , @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesor.findByApellidos", query = "SELECT p FROM Profesor p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Profesor.findByNombreUsu", query = "SELECT p FROM Profesor p WHERE p.nombre_usu = :nombre_usu")
    , @NamedQuery(name = "Profesor.findByPass", query = "SELECT p FROM Profesor p WHERE p.pass = :pass")
    , @NamedQuery(name = "Profesor.findByIdIn", query = "SELECT p FROM Profesor p WHERE p.idprofesor IN :id")
})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Integer idprofesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_usu")
    private String nombre_usu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pass")
    private String pass;

    public Profesor() {
    }

    public Profesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Profesor(Integer idprofesor, String nombre, String apellidos, String nombre_usu, String pass) {
        this.idprofesor = idprofesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usu = nombre_usu;
        this.pass = pass;
    }
    
    public Profesor(String nombre, String apellidos, String nombre_usu, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombre_usu = nombre_usu;
        this.pass = pass;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsu() {
        return nombre_usu;
    }

    public void setNombreUsu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Profesor[ idprofesor=" + idprofesor + " ]";
    }
    
}

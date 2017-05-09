/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author DAM
 */
public class NotasDTO {
    private String asignatura;
    private String profesor;
    private Double nota;

    public NotasDTO() {
    }

    public NotasDTO(String asignatura, String profesor, Double nota) {
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

/**
 *
 * @author Usuario
 */
public class Estudiante {
    
    private String matricula;
    private String nombreCompleto;
    private Integer[] calificaciones;
    private Contacto contacto;

    public Estudiante(String matricula, String nombreCompleto, Integer[] calificaciones, Contacto contacto) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.calificaciones = calificaciones;
        this.contacto = contacto;
    }

    public Estudiante() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Integer[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    
    
    
}

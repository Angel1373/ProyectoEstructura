/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Curso {
    
    private String nombreCurso;
    private List<Estudiante> estudiantes;

    public Curso(String nombreCurso, List<Estudiante> estudiantes) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = estudiantes;
    }

    public Curso() {
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}

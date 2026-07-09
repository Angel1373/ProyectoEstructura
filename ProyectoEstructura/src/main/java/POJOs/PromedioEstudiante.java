/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

/**
 *Clase para meter al AVL y ordenar a los estudiantes por promedio usando el Comparable
 * Por que la clase estudiante ya lo implementa y se compara por matricula
 */
public class PromedioEstudiante implements Comparable<PromedioEstudiante> {
    
    private double promedio;
    private Estudiante estudiante;

    public PromedioEstudiante(double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    //Metodo para comparar promedios
    @Override
    public int compareTo(PromedioEstudiante o) {
        return Double.compare(this.promedio, o.promedio);
    }

    @Override
    public String toString() {
        return "PromedioEstudiante{" + "promedio=" + promedio + ", estudiante=" + estudiante + '}';
    }
    
    
}

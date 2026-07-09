/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

/**
 *
 * @author Gael Galaviz
 */
public class SolicitudCalificacion {
    private Estudiante estudiante;
    private Curso curso;
    private double calificacion;
    
    public SolicitudCalificacion(Estudiante estudiante, Curso curso, double calificacion) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.calificacion = calificacion;
    }
    /**
     * Asigna una calificacion a un estudiante y 
     * guarda el historial de la accion
     */
    public void procesarSolicitud(Acciones acciones){
        if (estudiante == null) {
            System.out.println("No hay un estudiante asignado");
            return;
            
        }
        // Si el estudiante no tiene lista de notas, se crea una nueva.
        if (estudiante.getCalificaciones() == null) {
            estudiante.setCalificaciones(new java.util.ArrayList<>());
            
        }
        // Agrega la calificacion a la lista del estudiante
        estudiante.getCalificaciones().add(calificacion) ;
        // se Crea un objeto de tipo Accion
        Accion accionCalificar = new Accion("CALIFICACION", this.estudiante);
        // Envia la accion a la pila
        acciones.agregarAccion(accionCalificar);
        
        System.out.println("Solicitud procesada: Calificacion de " + calificacion
                + " agregada correctamente a " + estudiante.getNombreCompleto());
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}

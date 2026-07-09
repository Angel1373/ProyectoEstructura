/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import Implementaciones.BinarySearchTree;

/**
 *
 * @author Gael Galaviz
 */
public class Accion {
    private String tipo;
    private Object dato;

    public Accion(String tipo, Object dato) {
        this.tipo = tipo;
        this.dato = dato;
    }
    
    // Metodo para revertir la operacion de la pila
    public void deshacer(BinarySearchTree<Estudiante> arbolEstudiantes) {
        if (tipo == null) {
            return;
        
        }
        // Evalua que tipo de accion debe revertir
        switch(tipo.toUpperCase()){
            // Obtiene al estudiante guardado en dato y lo borra del arbol
            case "REGISTRO":
                Estudiante registro = (Estudiante) dato;
                if (registro != null && arbolEstudiantes != null) {
                    arbolEstudiantes.eliminar(registro);
                    System.out.println("Deshacer Registro: " + registro.getNombreCompleto());
                    
                }
                break;
                // Saca al estudiante de la lista de inscritos del curso
            case "INSCRIPCION":
                Inscripcion inscripcion = (Inscripcion) dato;
                if (inscripcion != null && inscripcion.getCurso() != null) {
                    Curso curso = inscripcion.getCurso();
                    Estudiante estudiante = inscripcion.getEstudiante();
                    curso.getInscritos().eliminar(estudiante);
                    curso.setTotalInscritos(curso.getTotalInscritos() - 1);
                    
                    System.out.println("Deshacer Inscripcion: " + estudiante.getNombreCompleto()
                    + " fue removido de " + curso.getNombreCurso());
                    // Si el curso tiene lista de espera, mueve al primero hacia al curso principal
                    if (curso.getListaEspera() != null && !curso.getListaEspera().empty()) {
                        Estudiante siguiente = curso.getListaEspera().peek();
                        
                        curso.getListaEspera().eliminarInicio();
                        curso.inscribir(siguiente);
                        
                        System.out.println("El estudiante " + siguiente.getNombreCompleto()
                                + " paso de la lista de espera al curso principal. ");
                    }
                }
                break;
                // Reinscribe al estudiante en el curso
            case "BAJA":
                Inscripcion baja = (Inscripcion) dato;
                if (baja != null && baja.getCurso() != null) {
                    baja.getCurso().inscribir(baja.getEstudiante());
                    System.out.println("Deshacer Baja: " + baja.getEstudiante().getNombreCompleto()
                     + " en " + baja.getCurso().getNombreCurso() );
                    
                }
                break;
                //Busca al estudiante, accede a su lista de notas y elimina la ultima agregada
            case "CALIFICACION":
                Estudiante estudiante = (Estudiante) dato;
                if (estudiante != null && estudiante.getCalificaciones() != null) {
                    int ultimaPosicion = estudiante.getCalificaciones().size() - 1;
                    if (ultimaPosicion >= 0) {
                        estudiante.getCalificaciones().remove(ultimaPosicion);
                        System.out.println("Deshacer Calificacion: Ultima nota de "
                         + estudiante.getNombreCompleto() + " Eliminado");
                    }
                }
                break;
            default:
                System.out.println("Operacion no reconocible.");
                break;
                
                       
        }
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Accion{" + "tipo=" + tipo + ", dato=" + dato + '}';
    }
}

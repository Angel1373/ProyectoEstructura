/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.util.ArrayList;


/**
 *
 * Clase estudiante que implementa comparable para poder comparar las matriculas en el arbol binario de busqueda
 */
public class Estudiante implements Comparable<Estudiante>{
    
    private String matricula;
    private String nombreCompleto;
    private ArrayList<Double>  calificaciones;
    private Contacto contacto;

    public Estudiante(String matricula, String nombreCompleto, ArrayList calificaciones, Contacto contacto) {
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

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

  

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public int compareTo(Estudiante o) {
        return this.matricula.compareTo(o.matricula);
       
    }
    
    //Metodo para generar una matricula entre 100 y 1000
    public String generarMatricula(){
        return "A" + (100 + (int)(Math.random()*1000));
    }

    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", calificaciones=" + calificaciones + ", contacto=" + contacto + '}';
    }
 
    public double calcularPromedioRecursivo(){
        if(calificaciones == null || calificaciones.isEmpty()){
            return 0.0;
        }
        return sumarRecursivo(0) / calificaciones.size(); 
    }
    
    private double sumarRecursivo(int indice){
        if(indice == calificaciones.size()){
            return 0.0;
        }
        return calificaciones.get(indice) + sumarRecursivo(indice + 1);
    }
    
}

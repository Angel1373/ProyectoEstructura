/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;


import Implementaciones.DoubleCircularLinkedList;
import Implementaciones.LinkedList;

/**
 *
 * @author Usuario
 */
public class Curso {
    
    private String nombreCurso;
    private Integer capacidadMaxima = 30;
    private LinkedList<Estudiante> inscritos;
    private DoubleCircularLinkedList<Estudiante> listaEspera;
    private int totalInscritos = 0;

    public Curso(String nombreCurso, int capacidadMaxima ) {
        this.nombreCurso = nombreCurso;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new LinkedList<>();
        this.listaEspera = new DoubleCircularLinkedList<>();
        
    }

    public Curso() {
        this.inscritos = new LinkedList<>();
        this.listaEspera = new DoubleCircularLinkedList<>();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
    /**
     * Metodo para inscribir un estudiante en un curso y 
     * si esta lleno lo manda a la lista de espera
     */
    public void inscribir(Estudiante estudiante){
        if (totalInscritos < capacidadMaxima) {
            inscritos.agregarFinal(estudiante);
            totalInscritos++;
            System.out.println("Estudiante inscrito en la lista principal");
            
        }else{
            listaEspera.agregarFinal(estudiante);
            System.out.println("Curso lleno. Estudiante enviado a la lista de espera");
        }
    }
    
    
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public LinkedList<Estudiante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(LinkedList<Estudiante> inscritos) {
        this.inscritos = inscritos;
    }

    public DoubleCircularLinkedList<Estudiante> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(DoubleCircularLinkedList<Estudiante> listaEspera) {
        this.listaEspera = listaEspera;
    }
    public int getTotalInscritos() {
        return totalInscritos;
    }

    public void setTotalInscritos(int totalInscritos) {
        this.totalInscritos = totalInscritos;
    }

    @Override
    public String toString() {
        return "Curso{" + "inscritos=" + inscritos + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import POJOs.Estudiante;

/**
 *
 * @author Usuario
 */
public class CircularLinkedList<T> {
    
    private Nodo<T> cabeza;
    private Nodo<T> puntero;

    public String rotarRol(){
        if(cabeza == null){
            return "No hay estudiantes con rol";
        }
        //Se le asigna el rol al primer estudiante 
        if(puntero == null){
            puntero = cabeza;
        }else{
            puntero = puntero.getSiguiente();          
        }
        //Obtenemos al estudiante
        Estudiante alumno = (Estudiante) puntero.getDato();
        //Lo mostramos
        return "Nuevo tutor o lider " + alumno.getNombreCompleto();
    }
    // Metodo para regresar el puntero hacia atras para deshacer que esta actualmente
    public String rotalRolAtras(){
        // Si no hay una lista o un rol
        if (cabeza == null || puntero == null) {
            return "No hay roles para deshacer.";
            
        }
        // Si solo hay un estudiante
        if (cabeza.getSiguiente() == cabeza) {
            puntero = null;
            return "Se quito el rol";
        
        }
        
        Nodo<T> aux = cabeza;
        // Buscamos el nodo que esta atras el puntero
        while(aux.getSiguiente() != puntero){
            aux = aux.getSiguiente();
        }
        // Hacemos que el puntero tome el nodo anterior
        puntero = aux;
        Estudiante alumno = (Estudiante) puntero.getDato();
        return "El rol se regreso a " + alumno.getNombreCompleto();
    }
    
    public T getActual(){
        if(puntero == null){
            return null;
        }
        return puntero.getDato();
    }
    
    /**
     * Metodo para agregar un nodo u objeto a una lista enlazada ciruclar
     */
    public void agregar(T o){
        Nodo<T> nuevo = new Nodo<T>(o);
        if(cabeza == null){
            cabeza = nuevo;
            nuevo.setSiguiente(nuevo);
        }else{
            Nodo<T> ultimoNodo = cabeza;
            //Mientras el nodo no siguiente no sea la cabeza avanza por que es circular
            while(ultimoNodo.getSiguiente() != cabeza){
                ultimoNodo = ultimoNodo.getSiguiente();
            }
            //El nuevo apunta a la cabeza y el ultimo apunta al nuevo por que es el inicio
            nuevo.setSiguiente(cabeza);
            ultimoNodo.setSiguiente(nuevo);
        }
        
    }
}


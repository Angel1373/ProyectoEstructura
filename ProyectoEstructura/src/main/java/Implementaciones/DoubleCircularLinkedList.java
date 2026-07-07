/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import excepciones.ListException;

/**
 * Clase que representa un nodo generico para una lista doblemente enlazada circular
 * @author Gael Galaviz
 */
public class DoubleCircularLinkedList<T> {
    private Nodo<T> inicio;

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    
    public boolean empty(){
        return inicio == null;
    }
    
    public T peek() {
        if (empty()) {
            throw new ListException("La lista esta vacia");           
        }
        return inicio.getDato();
    }
    public boolean contains(T dato) {
        if (inicio == null) {
            return false;
        }
        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        if (aux.getDato().equals(dato)) {
            return true;
        }
        return false;
    }
    public void agregarInicio(T dato){
            Nodo<T> nuevo = new Nodo<>(dato);
        if (empty()) {
            inicio = nuevo;
            inicio.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
            return;
        }

        Nodo<T> aux = inicio;
        while (aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(inicio);
        nuevo.setAnterior(aux);
        inicio.setAnterior(nuevo);
        aux.setSiguiente(nuevo);
        inicio = nuevo;
    }
    public void agregarMedio(int posicion, T dato) {
        if (posicion < 0) {
            throw new ListException("Posicion invalida");
        }
        if (posicion == 0) {
            agregarInicio(dato);
            return;
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < posicion - 1 && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != posicion - 1) {
            throw new ListException("Posicion fuera de rango");
        }
        Nodo<T> nuevo = new Nodo<>(dato);

        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);
        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);
        
    }
    public void agregarFinal(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
            return;
        }
        Nodo<T> aux = inicio.getAnterior();
        nuevo.setSiguiente(inicio);
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        inicio.setAnterior(nuevo);
    }
    public void eliminarInicio() {
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }
        Nodo<T> aux = inicio.getAnterior();
        inicio = inicio.getSiguiente();
        aux.setSiguiente(inicio);
        inicio.setAnterior(aux);
    }
    public void eliminarMedio(int posicion) {
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        if (posicion < 0) {
            throw new ListException("Posicion invalida");
        }
        if (posicion == 0) {
            eliminarInicio();
            return;
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < posicion && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != posicion) {
            throw new ListException("Posicion fuera de rango");
        }
        aux.getAnterior().setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(aux.getAnterior());
        
    }
    public void eliminarFinal() {
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        if (inicio.getSiguiente() == inicio) {
            inicio = null;
            return;
        }

        Nodo<T> ultimo = inicio.getAnterior();
        Nodo<T> penultimo = ultimo.getAnterior();
        penultimo.setSiguiente(inicio);
        inicio.setAnterior(penultimo);
        
    }
    public void actualizarInicio(T dato){
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        inicio.setDato(dato);
        
    }
    
    public void actualizarMedio(int posicion, T dato){
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        if (posicion < 0) {
            throw new ListException("Posicion invalida");
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < posicion && aux.getSiguiente() != inicio) {
            aux = aux.getSiguiente();
            i++;
        }
        if (i != posicion) {
            throw new ListException("Posicion fuera de rango");
        }
        aux.setDato(dato);
    }
    public void actualizarFinal(T dato){
        if (inicio == null) {
            throw new ListException("La lista esta vacia");
        }
        inicio.getAnterior().setDato(dato);
    }
    // Mostrar la lista de espera para el punto 6
    public void mostrarListaEspera(int mostrar, int direccion) {
        if (empty()) {
            System.out.println("La lista esta vacia");
            return;
        }
        Nodo<T> aux = inicio;
        int i = 0;
        while (i < mostrar && aux != null) {    
            System.out.println("[" + aux.getDato().toString() + "]");
            
            if (direccion == 1) {
                aux = aux.getSiguiente();
               
            }else{
                aux = aux.getAnterior();
            }
            i++;
            
        }

    }
    
}

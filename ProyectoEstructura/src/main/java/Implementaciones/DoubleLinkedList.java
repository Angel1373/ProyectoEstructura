/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * Clase que representa un nodo generico para una lista doblemente enlazada
 * @author Gael Galaviz
 */
public class DoubleLinkedList<T> {
    private Nodo<T> cabeza;

    public DoubleLinkedList(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        cabeza = nodoNuevo;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        nodoNuevo.setSiguiente(cabeza);

        if (cabeza != null) {
            cabeza.setAnterior(nodoNuevo);

        }
        cabeza = nodoNuevo;

    }

    public void agregarMedio(int posicion, T dato) {
        if (posicion < 0) {
            System.out.println("Posicion no valida");
            return;
        }
        if (posicion == 0) {
            agregarInicio(dato);
            return;
        }

        Nodo<T> nodoNuevo = new Nodo<>(dato);
        Nodo<T> Aux = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (Aux != null) {
                Aux = Aux.getSiguiente();

            }

        }
        if (Aux == null) {
            System.out.println("Fuera de rango");
            return;
        }

        nodoNuevo.setSiguiente(Aux.getSiguiente());
        nodoNuevo.setAnterior(Aux);
        if (Aux.getSiguiente() != null) {
            Aux.getSiguiente().setAnterior(nodoNuevo);

        }
        Aux.setSiguiente(nodoNuevo);
    }

    public void agregarFinal(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nodoNuevo;
            return;

        }
        Nodo<T> Aux = cabeza;
        while (Aux.getSiguiente() != null) {
            Aux = Aux.getSiguiente();

        }
        Aux.setSiguiente(nodoNuevo);
        nodoNuevo.setAnterior(Aux);
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("Lista vacia.");
            return;

        }
        cabeza = cabeza.getSiguiente();
        if (cabeza != null) {
            cabeza.setAnterior(null);

        }
    }

    public void eliminarMedio(int posicion) {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        if (posicion < 0) {
            System.out.println("Posicion no valida");
            return;
        }
        if (posicion == 0) {
            eliminarInicio();
            return;
        }

        Nodo<T> Aux = cabeza;
        for (int i = 0; i < posicion; i++) {
            if (Aux != null) {
                Aux = Aux.getSiguiente();

            }

        }
        if (Aux == null) {
            System.out.println("Fuera de rango");
            return;
        }

        if (Aux.getAnterior() != null) {
            Aux.getAnterior().setSiguiente(Aux.getSiguiente());
        }
        if (Aux.getSiguiente() != null) {
            Aux.getSiguiente().setAnterior(Aux.getAnterior());

        }

    }

    public void eliminarFinal() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;

        }
        if (cabeza.getSiguiente() == null) {
            cabeza = null;
            return;

        }
        Nodo<T> Aux = cabeza;
        while (Aux.getSiguiente() != null) {
            Aux = Aux.getSiguiente();
        }
        Aux.getAnterior().setSiguiente(null);
    }

    public void editar(int posicion, T dato) {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        if (posicion < 0) {
            System.out.println("Posicion no valida");
            return;
        }
        Nodo<T> Aux = cabeza;
        for (int i = 0; i < posicion; i++) {
            if (Aux != null) {
                Aux = Aux.getSiguiente();
            }
        }
        if (Aux == null) {
            System.out.println("Fuera de rango");
            return;
        }
        Aux.setDato(dato);

    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;

        }

        Nodo<T> Aux = cabeza;
        while (Aux != null) {
            System.out.print("[" + Aux.getDato() + "]");
            if (Aux.getSiguiente() != null) {
                System.out.print(" <-> ");

            }
            Aux = Aux.getSiguiente();
        }
        System.out.println("-> Null");

    }
    
}

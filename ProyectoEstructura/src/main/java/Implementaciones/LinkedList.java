/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 * Clase que representa una lista enlazada simple generica
 *
 * @author Gael Galaviz
 */
public class LinkedList<T> {
    private Nodo<T> cabeza;

    public LinkedList() {
    }
    
    

    public LinkedList(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        cabeza = nodoNuevo;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        nodoNuevo.setSiguiente(cabeza);
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
        if (Aux == null || Aux.getSiguiente() == null) {
            System.out.println("Fuera de rango");
            return;
        }

        nodoNuevo.setSiguiente(Aux.getSiguiente());
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
    }
    /**
     * Buscar un dato especifico en la lista y 
     * eliminando llamando los metodos eliminar de cada tipo de eliminar
     */
    public void eliminar(T dato) {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }

        Nodo<T> aux = cabeza;
        int posicion = 0;
        boolean encontrado = false;

        // Recorremos la lista 
        while (aux != null) {
            // Checamos el dato actual con el que buscamos
            if (aux.getDato().equals(dato)) {
                encontrado = true;
                break; 
            }
            aux = aux.getSiguiente();
            posicion++;
        }

        // Si lo encontramos mandamos a llamar a los metodos
        if (encontrado) {
            if (posicion == 0) {
                eliminarInicio();
            } else if (aux.getSiguiente() == null) {
                eliminarFinal();
            } else {
                eliminarMedio(posicion);
            }
        } else {
            System.out.println("Elemento no encontrado en la lista");
        }
    }
    public void eliminarInicio() {
        if (cabeza == null) {
            System.out.println("Lista vacia.");
            return;

        }
        cabeza = cabeza.getSiguiente();
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
        for (int i = 0; i < posicion - 1; i++) {
            if (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();

            }

        }
        if (Aux == null || Aux.getSiguiente() == null) {
            System.out.println("Fuera de rango");
            return;
        }

        Aux.setSiguiente(Aux.getSiguiente().getSiguiente());

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
        while (Aux.getSiguiente().getSiguiente() != null) {
            Aux = Aux.getSiguiente();
        }
        Aux.setSiguiente(null);
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
            System.out.print(Aux.getDato() + " - ");
            Aux = Aux.getSiguiente();
        }

    }
    
}

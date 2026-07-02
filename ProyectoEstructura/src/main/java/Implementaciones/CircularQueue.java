/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import excepciones.QueueException;
import interfaces.IQueue;

/**
 * Implementacion de una cola circular utilizando un arreglo generico
 * @author Gael Galaviz
 */
public class CircularQueue<T> implements IQueue<T>{
    private T[] elementos;
    private int inicio;
    private int fin;
    private int tamCola;

    /**
     * Constructor que inicializa la cola
     */
    public CircularQueue(int tamCola) {
        this.tamCola = tamCola;
        this.elementos = (T[]) new Object[tamCola];
        this.inicio = -1;
        this.fin = -1;
    }

    /**
     * Agrega un nuevo elemento al final de la cola circular
     */
    @Override
    public void enqueue(T o) throws QueueException {
        if (full()) {
            throw new QueueException("La cola esta llena");

        }
        if (empty()) {
            inicio = 0;

        }
        fin = (fin + 1) % tamCola;
        elementos[fin] = o;

    }

    /**
     * Remueve el elemento que esta inicio de la cola
     */
    @Override
    public T dequeue() throws QueueException {
        if (empty()) {
            throw new QueueException("Cola vacia");

        }
        T dato = elementos[inicio];
        elementos[inicio] = null;
        if (inicio == fin) {
            inicio = -1;
            fin = -1;
        } else {
            inicio = (inicio + 1) % tamCola;

        }
        return dato;
    }

    /**
     * Consulta el elemento del inicio de la cola sin removerlo
     */
    @Override
    public T peek() throws QueueException {
        if (empty()) {
            throw new QueueException("Cola vacia");

        }
        return elementos[inicio];
    }

    /**
     * Verifica si la cola esta vacia
     */
    @Override
    public boolean empty() {
        return inicio == -1;
    }

    /**
     * Verifica si la cola esta llena
     */
    private boolean full() {
        return (fin + 1) % tamCola == inicio;

    }

    /**
     * Representa el texto de los elementos de la cola
     */
    @Override
    public String toString() {
        if (empty()) {
            return "Cola vacia";
        }
        String resultado = "Elementos: ";
        int i = inicio;
        while (true) {
            resultado += elementos[i];
            if (i == fin) {
                break;
            }
            resultado += ", ";
            i = (i + 1) % tamCola;
        }
        return resultado;
    }

}

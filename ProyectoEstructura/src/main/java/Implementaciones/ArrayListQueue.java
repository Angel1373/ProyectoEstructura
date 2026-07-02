/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import excepciones.ListException;
import excepciones.QueueException;
import interfaces.IQueue;

/**
 * Implementacion de una cola usando un arreglo generico
 * @author Gael Galaviz
 */
public class ArrayListQueue<T> extends ArrayList<T> implements IQueue<T>{
    
    public ArrayListQueue(Class<T> tipoDato, int tamLista) {
        super(tipoDato, tamLista);
    }
    /**
     * Agregar un elemento al final de la cola
     */
    @Override
    public void enqueue(T o) throws QueueException {
        try {
            append(o);
        } catch (ListException le) {
            throw new QueueException("Cola llena");
        
        }
    }
    /**
     * Remueve el elemento que esta inicio de la cola
     */
    @Override
    public T dequeue() throws QueueException {
        T o = null;
        try {
            o = get(0);
            remove(0);
            return o;
        } catch (ListException le) {
            throw new QueueException("Cola vacia");
        }
    }
    /**
     * Consulta el elemento del inicio de la cola sin removerlo
     */
    @Override
    public T peek() throws QueueException {
        T o = null;
        try {
            o = get(0);
            return o;
        } catch (ListException le) {
            throw new QueueException("Cola vacia");
        }
    }
    /**
     * Verifica si la cola esta vacia
     */
    @Override
    public boolean empty() {
        return super.empty();    
    }
    
}

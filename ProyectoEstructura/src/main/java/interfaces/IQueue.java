/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.QueueException;

/**
 *
 * @author Gael Galaviz
 */
public interface IQueue<T> {
    
    // Agrega un elemento al final de la cola
    public void enqueue(T o) throws QueueException;
    
    // Extrae el elemento al incio de la cola
    public T dequeue() throws QueueException;
    
    // Inspecciona el elemento del inicio de la cola
    public T peek() throws QueueException;

    // Determina si la cola esta vacia
    public boolean empty();

    
}

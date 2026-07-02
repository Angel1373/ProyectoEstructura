/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.StackException;

/**
 *
 * @author Gael Galaviz
 */
public interface IStack<T> {
    // Inserta un elemento en el tope de la pila
    public void push(T o) throws StackException;  
    // Extrae el elemento del tope de la pila
    public T pop() throws StackException;
    
    // Inspecciona el elemento del tope de la pila sin extraerlo
    public T peek() throws StackException;
    
    // Determina si la pila se encuentra vacia
    public boolean empty();



    
}

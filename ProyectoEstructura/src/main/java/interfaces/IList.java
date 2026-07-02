/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.ListException;
import java.util.Iterator;

/**
 *
 * @author Gael Galaviz
 */
public interface IList<T> {
    
    // Inserta un elemento al final de la lista
    public void append(T o) throws ListException;
    
    // Inserta un elemento en la posición i de la lista
    public void insert(T o, int i) throws ListException;
    
    // Inspecciona el elemento en la posición i de la lista sin extraerlo
    public T get(int i) throws ListException;

    // Extrae el elemento de la posición i de la lista
    public T remove(int i) throws ListException;

    // Determina si la lista se encuentra vacia
    public boolean empty();
    
    // Regresa el numero de elementos en la lista
    public int size();
    
    // Regresa un iterador esta lista
    public Iterator<T> iterator();

    // Establece un elemento en el indice dado dentro de la lista
    public void set(T o, int i) throws ListException;
    
    // Elimina cierto elemento dentro de la lista
    public boolean remove(T o) throws ListException;

    // Regresa el indice de dado elemento dentro de la lista
    public int indexOf(T o);
    
    // Eliminar todos los elementos de la lista
    public void clear();
    
    // Determinar si el elemento dado existe en la lista
    public boolean contains(T o);

    
   
    

    
}

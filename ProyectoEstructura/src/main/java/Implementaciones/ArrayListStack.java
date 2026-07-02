/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import excepciones.ListException;
import excepciones.StackException;
import interfaces.IStack;

/**
 * Clase que implementa una pila generica
 * @author Gael Galaviz
 */
public class ArrayListStack<T> extends ArrayList<T> implements IStack<T> {

    public ArrayListStack(Class<T> tipoDato, int tamLista) {
        super(tipoDato, tamLista);
    }
    /**
     * Inserta un elemento en el tope de la pila
     */
    @Override
    public void push(T o) throws StackException {
        try {
            append(o);
        } catch (ListException le) {
            throw new StackException("Pila llena");
        }
    }
    
    /**
     * Extrae el elemento en el tope de la pila
     */
    @Override
    public T pop() throws StackException {
        T o = null;
        try {
            o = remove(nElementos - 1);
        } catch (ListException le) {
            throw new StackException("Pila Vacia");
        }
        return o;
    }

    /**
     * Inspecciona el elemento en el tope de la pila
     */
    @Override
    public T peek() throws StackException {
        T o = null;
        try {
            o = get(nElementos - 1);
        } catch (ListException le) {
            throw new StackException("Pila Vacia");
        }
        return o;
    }   
    /**
     * Verifica si la pila esta vacia
     */
    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    
    
}
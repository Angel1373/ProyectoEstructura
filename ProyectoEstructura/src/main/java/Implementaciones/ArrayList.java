/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import excepciones.ListException;
import interfaces.IList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase generica implementa una lista sobre un arreglo
 * @author Gael Galaviz
 */
public class ArrayList<T> implements IList<T>, Iterable<T>{
    protected int nElementos;
    private int tamLista;
    private T lista[];
    
    public ArrayList(Class<T> tipoDato, int tamLista) {
        this.tamLista = tamLista;
        nElementos = 0;
        lista = (T[]) java.lang.reflect.Array.newInstance(tipoDato, tamLista);
    }
    /**
     * Esta clase representa un iterador para esta lista
     */
    private class ListIterator<T> implements Iterator<T> {

        private int actual = 0;

        @Override
        public boolean hasNext() {
            return actual < nElementos;

        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();

                
            }
            return (T) lista[actual++];
        }
    }
    /**
     * Inserta un elemento al final de la lista
     */
    @Override
    public void append(T o) throws ListException {
        if (nElementos >= tamLista) {
            throw new ListException("Lista llena");

            
        }
        lista[nElementos] = o;
        nElementos++;
    }
    /**
     * Inserta un elemento en la posicion i de la lista
     */
    @Override
    public void insert(T o, int i) throws ListException {
        if (nElementos >= tamLista){
            throw new ListException("Lista llena");
        }
        if (i < 0 || i > nElementos) {
            throw new ListException("Indice fuera de limites");
            
        }
        for (int j = nElementos; j > i; j--) {
            lista[j] = lista[j - 1];
              
        }
        lista[i] = o;
        nElementos++;
        
    }
    /**
     * Inspecciona el elemento en la posición i de la lista sin extraerlo
     */
    @Override
    public T get(int i) throws ListException {
        if (empty()) {
            throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }
        return lista[i];

    }
    /**
     * Extrae el elemento de la posición i de la lista
     */
    @Override
    public T remove(int i) throws ListException {
        T o = get(i);
        for (int j = i; j < nElementos - 1; j++) {
            lista[j] = lista[j + 1];

        }
        nElementos--;
        return o;
    }
    /**
     * Verifica si la lista esta vacia
     */
    @Override
    public boolean empty() {
        return nElementos == 0;
        
    }
    /**
     * Regresa el numero de elementos en la lista
     */
    @Override
    public int size() {
        return nElementos;

    }
    /**
     * Regresa un iterador para esta lista
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();

    }
    /**
     * Establece el elemento dado en el indice dado
     */
    @Override
    public void set(T o, int i) throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Remueve la primera ocurrencia del elemento de la lista
     */
    @Override
    public boolean remove(T o) throws ListException {
        int indice = indexOf(o);
        if (indice != -1) {
            remove(indice);
            return true;
            
        }
        return false;
    }
    /**
     * Regresa el indice del elemento
     */
    @Override
    public int indexOf(T o) {
        if (o == null) {
            for (int j = 0; j < nElementos; j++) {
                if (lista[j] == null) {
                    return j;
                }
            }
        } else {
            for (int j = 0; j < nElementos; j++) {
                if (o.equals(lista[j])) {
                    return j;
                }
            }
        }
        return -1;
    }
    /**
     * vacia la lista
     */
    @Override
    public void clear() {
        nElementos = 0;

    }
    /**
     * Verificar si la lista contiene el elemento dado
     */
    @Override
    public boolean contains(T o) {
        for (int i = 0; i < nElementos; i++) {
            if (o == null) {
                if (lista[i] == null) {
                    return true;
                    
                }
            }else{
                if (o.equals(lista[i])) {
                    return true;
                    
                }
            }
        }
        return false;

    }
    /**
     * Representa el texto de los elementos de la lista
     */
    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < nElementos; i++) {
            s += lista[i];
            if (i < nElementos - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * Arbol AVL
 */
public class AVLTree<T extends Comparable<T>> {
    
    private NodoArbolAVL<T> raiz;

    public AVLTree() {
    }

    public void agregar(T dato) {
        raiz = agregarRecursivo(dato, raiz);
    }
    
    /**
     * En los compare to se usa el comparable de la clase la cual estamos comparando y en lo que lo utilizo
     * para esta clase es en el promedio de la clase PromedioEstudiante
     */

    //Para estos metodos me guie del documento Ejemplo de una Implementación de un Árbol AVL
     private NodoArbolAVL<T> agregarRecursivo(T dato, NodoArbolAVL<T> actual) {
        // Caso base: el subarbol es vacio, se agrega el nodo aqui
        if (actual == null) {
            return new NodoArbolAVL<T>(dato);
        }
        // Casos recursivos: se determina a que subarbol se agrega
        if (dato.compareTo(actual.getElemento()) < 0) {
            actual.setHijoIzquierdo(agregarRecursivo(dato, actual.getHijoIzquierdo()));
        } else {
            actual.setHijoDerecho(agregarRecursivo(dato, actual.getHijoDerecho()));
        }
        actualizarAltura(actual);
        return rebalance(actual);
    }
    
    private NodoArbolAVL<T> rebalance(NodoArbolAVL<T> actual) {
        int factorBalance = balanceFactor(actual);
        if (factorBalance < -1) {
            if (balanceFactor(actual.getHijoIzquierdo()) < 0) {
                actual = rotateRight(actual);
            } else {
                actual = rotateLeftRight(actual);
            }
        } else if (factorBalance > 1) {
            if (balanceFactor(actual.getHijoDerecho()) > 0) {
                actual = rotateLeft(actual);
            } else {
                actual = rotateRightLeft(actual);
            }
        }
        return actual;
    }
    
    // factor de balance = altura del derecho - altura del izquierdo
    private int balanceFactor(NodoArbolAVL<T> nodo) {
        if (nodo == null) return 0;
        return obtenerAltura(nodo.getHijoDerecho()) - obtenerAltura(nodo.getHijoIzquierdo());
    }
    
    private int obtenerAltura(NodoArbolAVL<T> nodo) {
        return (nodo == null) ? -1 : nodo.getAltura();
    }
    
    private void actualizarAltura(NodoArbolAVL<T> nodo) {
        int alturaIzq = obtenerAltura(nodo.getHijoIzquierdo());
        int alturaDer = obtenerAltura(nodo.getHijoDerecho());
        nodo.setAltura(1 + Math.max(alturaIzq, alturaDer));
    }
    
    // Rotacion simple derecha caso de Izquierda-Izquierda
    private NodoArbolAVL<T> rotateRight(NodoArbolAVL<T> actual) {
        NodoArbolAVL<T> nodoT = actual.getHijoIzquierdo();
        actual.setHijoIzquierdo(nodoT.getHijoDerecho());
        nodoT.setHijoDerecho(actual);
        actualizarAltura(actual);
        actualizarAltura(nodoT);
        return nodoT;
    }
    
    // Rotacion simple izquierda caso de Derecha-Derecha
    private NodoArbolAVL<T> rotateLeft(NodoArbolAVL<T> actual) {
        NodoArbolAVL<T> nodoT = actual.getHijoDerecho();
        actual.setHijoDerecho(nodoT.getHijoIzquierdo());
        nodoT.setHijoIzquierdo(actual);
        actualizarAltura(actual);
        actualizarAltura(nodoT);
        return nodoT;
    }
    
    // Rotacion doble caso de Izquierda-Derecha
    private NodoArbolAVL<T> rotateLeftRight(NodoArbolAVL<T> actual) {
        actual.setHijoIzquierdo(rotateLeft(actual.getHijoIzquierdo()));
        return rotateRight(actual);
    }
    
    // Rotacion doble caso de Derecha-Izquierda
    private NodoArbolAVL<T> rotateRightLeft(NodoArbolAVL<T> actual) {
        actual.setHijoDerecho(rotateRight(actual.getHijoDerecho()));
        return rotateLeft(actual);
    }
    
    public void imprimirEnOrdenPorPromedio(){
        imprimirEnOrdenPorPromedioRecursivo(raiz);
    }
    
    //Metodo para imprimir en orden de promedio 
    private void imprimirEnOrdenPorPromedioRecursivo(NodoArbolAVL<T> actual){
        if(actual !=null){
            imprimirEnOrdenPorPromedioRecursivo(actual.getHijoIzquierdo());
            System.out.println(actual.getElemento());
            imprimirEnOrdenPorPromedioRecursivo(actual.getHijoDerecho());
        }
    }
    
    @Override
    public String toString() {
        String s = "[";
        s += toStringInOrder(raiz);
        s += "]";
        return s;
    }
    
    private String toStringInOrder(NodoArbolAVL<T> nodo) {
        String s = "";
        if (nodo == null) {
            return s;
        }
        s += toStringInOrder(nodo.getHijoIzquierdo());
        s += "(" + nodo.getElemento() + ", "
                + obtenerAltura(nodo) + ", "
                + balanceFactor(nodo) + "), ";
        s += toStringInOrder(nodo.getHijoDerecho());
        return s;
    }
}

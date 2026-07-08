/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Usuario
 */
public class NodoArbolAVL<T> {
    
    private T elemento;
    private NodoArbolAVL hijoIzquierdo;
    private NodoArbolAVL hijoDerecho;
    private int altura;

    public NodoArbolAVL(T elemento){
        this.elemento = elemento;
        this.altura = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbolAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbolAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbolAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbolAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "elemento=" + elemento +
                '}';
    }
    
}

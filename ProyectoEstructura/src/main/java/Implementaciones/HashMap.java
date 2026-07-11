/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;
import java.util.ArrayList;
/**
 *Clase que crea un hashMap a partir de un ArrayList
 */
public class HashMap<T,K> {
    
    //arreglo de "baldes" que contiene varias entradas 
    //java.util para no usar la implementacion que tenemos y usar el de java
    private java.util.ArrayList<Entrada<T,K>>[] arreglo;
    private int objetosActuales;
    private int tamaño;
    
    //Esta clase es para guardar cada llave y valor y son los elementos que estan dentro del balde
    private class Entrada<T,K>{
        T llave;
        K valor;

        public Entrada(T llave, K valor) {
            this.llave = llave;
            this.valor = valor;
        }      
    }

    public HashMap(int tamaño) {
        this.tamaño = tamaño;
        this.objetosActuales = 0;
        arreglo = new java.util.ArrayList[tamaño];
        //Se crean los baldes dependiendo del tamaño del arreglo
        for(int i = 0; i<tamaño; i++){
            arreglo[i] = new java.util.ArrayList<>();
        }
    }
    
    //Metodo para convertir la llave a un numero entero hash
    private int hash(T llave){
        return Math.abs(llave.hashCode()) % tamaño;
    }
    
    //Metodo que agrega o actualiza si existe
    public void put(T llave, K valor){
        //Tomamos el valor de la llave
        int indice = hash(llave);
        //Tomamos el array list o el balde especifico de esa posición
        java.util.ArrayList<Entrada<T,K>> balde = arreglo[indice];
        //Este for es para recorrer el balde no todo el arreglo completo 
        for(Entrada<T,K> entrada : balde){
        if(entrada.llave.equals(llave)){
            //Si ya existe lo reemplaza
            entrada.valor = valor;
            return;
          } 
        }
        //Creamos una nueva entrada y se guarda al final del arreglo
        balde.add(new Entrada<>(llave,valor));
        objetosActuales++;
    }
    
    //Metodo para eliminar una entrada
    public K remove(T llave){
        //Tomamos el valor de la llave
        int indice = hash(llave);
        //Igua que el de agregar tomamos el arreglo especifico de esa llave
        java.util.ArrayList<Entrada<T,K>> balde = arreglo[indice];
        //Iteramos hasta encontrarlo dentro del balde
        for(int i = 0; i < balde.size();i ++){
            if(balde.get(i).llave.equals(llave)){
                //Lo eliminamos
                K eliminado = balde.get(i).valor;
                balde.remove(i);
                objetosActuales --;
                return eliminado;
            }
        }
        return null;
    }
    
    //Metodo para obtener el valor mediante la llave
    //Es casi lo mismo que el de eliminar pero aqui no lo elimina
    public K obtenerValor(T llave){
        int indice = hash(llave);
        java.util.ArrayList<Entrada<T,K>> balde = arreglo[indice];
        for(Entrada<T,K> entrada : balde){
            if(entrada.llave.equals(llave)){
                return entrada.valor;
            }
        }
        return null;
    }
    
    //Metodo que imprime cada valor de cada balde
    public void mostrarTodos(){
        for(java.util.ArrayList<Entrada<T,K>> baldes : arreglo){
            for(Entrada<T,K> entrada : baldes){
            System.out.println(entrada.valor);
        }
      }
    }
    
    //Metodo para saber si esta vacio, este lo hice para usarlo en el main
    public boolean isEmpty(){
        return objetosActuales == 0;
    }
    
}


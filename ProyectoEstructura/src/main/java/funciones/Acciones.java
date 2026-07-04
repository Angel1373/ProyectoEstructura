/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import Implementaciones.ArrayListStack;
import POJOs.Accion;

/**
 *
 * @author Gael Galaviz
 */
public class Acciones {
    private ArrayListStack<Accion> acciones;
    public Acciones() {
        //inicializamos la pila
        this.acciones = new ArrayListStack<>(Accion.class, 50);
        
        
    }
    // Agregar la accion a la pila
    public void agregarAccion(Accion accion){
        if (accion == null) {
            System.out.println("Esa accion no existe");
            return;
            
        }
        
        acciones.push(accion);
        System.out.println("Accion agregada correctamente");

        
    }
    // Eliminar y regresar la ultima accion
    public Accion deshacerAccion() {
        if (acciones.empty()) {
            System.out.println("La lista de acciones esta vacia");
            return null;
        }
        return acciones.pop();
    }
    // Regresar la ultima accion registrada
    public Accion verUltimaAccion() {
        if (acciones.empty()) {
            System.out.println("La lista de acciones esta vacia");
            
        }
        return acciones.peek();
    }
    public ArrayListStack<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayListStack<Accion> acciones) {
        this.acciones = acciones;
    }

    
}

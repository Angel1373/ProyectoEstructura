/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

/**
 *
 * @author Usuario
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    public NodoArbol<T> raiz;

    public void agregar(T dato){
        raiz = agregarNodo(raiz,dato);
    }

    private NodoArbol<T> agregarNodo(NodoArbol<T> actual,T dato){
        if(actual == null){
            return new NodoArbol<T>(dato);
        }

        if(dato.compareTo(actual.getElemento())<0){
            actual.setHijoIzquierdo(agregarNodo(actual.getHijoIzquierdo(),dato));
        }else{
            if(dato.compareTo(actual.getElemento())>0){
                actual.setHijoDerecho(agregarNodo(actual.getHijoDerecho(),dato));
            }
        }
        return actual;
    }

    public void buscarNodo(T dato){
        NodoArbol<T> buscar = buscarNodoRecursivo(dato,raiz);

        if(buscar != null){
            System.out.println("Nodo encontrado");
        }else{
            System.out.println("Nodo no encontrado");
        }
    }

    private NodoArbol<T> buscarNodoRecursivo(T dato,NodoArbol<T> actual){
        if(raiz == null){
            System.out.println("Arbol vacío");
            return null;
        }
        if (actual == null){
            return null;
        }
        if(dato.compareTo(actual.getElemento())<0){
           return buscarNodoRecursivo(dato,actual.getHijoIzquierdo());
        }else if(dato.compareTo(actual.getElemento())>0){
               return buscarNodoRecursivo(dato,actual.getHijoDerecho());
            }
            return actual;
        }


    public void eliminar(T dato){
        raiz = eliminarRecursivo(dato,raiz);
    }

    private NodoArbol<T> eliminarRecursivo(T dato, NodoArbol<T> actual){
        if(actual == null){
            return null;
        }
        if(dato.compareTo(actual.getElemento())<0){
            actual.setHijoIzquierdo(eliminarRecursivo(dato,actual.getHijoIzquierdo()));
        }else if (dato.compareTo(actual.getElemento())>0){
                actual.setHijoDerecho(eliminarRecursivo(dato,actual.getHijoDerecho()));
            }else {
            //Caso hoja
            if (actual.getHijoDerecho() == null && actual.getHijoIzquierdo() == null) {
                return null;
                //Caso 1 hijo
                /*
                De la llamada del padre del que queremos eliminar entra el que queremos eliminar en el metodo
                regresamos el hijo que tenga el que queremos eliminar y lo seteamos a la anterior llamada del padre
                 */
            }else if(actual.getHijoIzquierdo() == null){
                return actual.getHijoDerecho();
            }else if(actual.getHijoDerecho()==null){
                return actual.getHijoIzquierdo();
            }else{
                //Caso 2 hijos
                NodoArbol<T> auxiliar = actual.getHijoDerecho();
                while(auxiliar.getHijoIzquierdo() != null){
                    auxiliar = auxiliar.getHijoIzquierdo();
                }

                //El nodo que vamos a eliminar toma el valor de su hijo a la derecha y del todo a la izquierda
                actual.setElemento(auxiliar.getElemento());
                //Aqui buscamos el valor del nodo que queremos eliminar ya que quedo duplicado el de todo a la izquierda
                //Usamos la misma logica para eliminarlo igual que cualquier otro nodo empezando desde el hijo derecho del que queremos eliminar
                actual.setHijoDerecho(eliminarRecursivo(auxiliar.getElemento(),actual.getHijoDerecho()));
            }
        }
        return actual;
    }

    public void imprimirOrden(NodoArbol<T> actual){
        if(actual != null){
            imprimirOrden(actual.getHijoIzquierdo());
            System.out.println(actual);
            imprimirOrden(actual.getHijoDerecho());
        }
    }
    
}

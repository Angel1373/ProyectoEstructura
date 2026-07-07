/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

import Implementaciones.BinarySearchTree;
import Implementaciones.CircularLinkedList;
import POJOs.Contacto;
import POJOs.Curso;
import POJOs.Direccion;
import POJOs.Estudiante;
import excepciones.BinarySearchTreeException;
import java.util.Scanner;

/**
 * MENU DEL PROYECTO
 */
public class Menu {
    public static void main(String[] args) {
        
        BinarySearchTree arbol = new BinarySearchTree();
        CircularLinkedList listaCircular = new CircularLinkedList();
       
        while(true){             
        Scanner sc = new Scanner(System.in);
       
        System.out.println("MENU DEL SISTEMA");
        System.out.println("ESCRIBA UN NUMERO PARA ACCEDER");
        System.out.println("ESTUDIANTES------------------------------");
        System.out.println("1. Registrar estudiantes");
        System.out.println("2. Buscar estudiantes por matricula");
        System.out.println("CURSOS-----------------------------------");
        System.out.println("3. Agregar curso");
        System.out.println("4. Eliminar curso");
        System.out.println("5. Listar cursos");
        System.out.println("INSCRIPCIONES---------------------------");
        System.out.println("6. Inscribir estudiante en curso");
        System.out.println("7. Mostrar lista de inscritos de un curso");
        System.out.println("8. Mostrar lista de espera de un curso");
        System.out.println("CALIFICAIONES---------------------------");
        System.out.println("9. Enviar solicitud de calificación");
        System.out.println("10. Procesar siguiente solicitud");
        System.out.println("REPORTES--------------------------------");
        System.out.println("11. Listar estudiantes ordenados por promedio");
        System.out.println("12. Rotar roles");
        
        int respuesta = sc.nextInt();
        sc.nextLine();
        
        switch(respuesta){
            case 1:
                System.out.println("Escriba el nombre completo del estudiante");
                String nombre = sc.nextLine();
                System.out.println("Escriba el telefono del estudiante");
                String telefono = sc.nextLine();
                System.out.println("Escriba el correo del estudiante");
                String correo = sc.nextLine();
                System.out.println("Escriba la calle del estudiante");
                String calle = sc.nextLine();
                System.out.println("Escriba el numero de la casa del estudiante");
                String numero = sc.nextLine();
                System.out.println("Escriba la colonia del estudiante");
                String colonia = sc.nextLine();
                System.out.println("Escriba la ciudad del estudiante");
                String ciudad = sc.nextLine();
                Direccion direccion = new Direccion(calle,numero,colonia,ciudad);
                Contacto contacto = new Contacto(telefono,correo,direccion);
                Estudiante estudiante = new Estudiante();
                String matricula = estudiante.generarMatricula();
                estudiante.setNombreCompleto(nombre);
                estudiante.setContacto(contacto);
                estudiante.setMatricula(matricula);
                try{
                    arbol.agregar(estudiante);
                    listaCircular.agregar(estudiante);
                }catch(BinarySearchTreeException e){
                    System.out.println("Error al intentar agregar al estudiante");
                }    
                arbol.imprimir();
                break;
            case 2:
                System.out.println("Escriba la matricula del estudiante");
                String matriculaBuscar = sc.nextLine();
                Estudiante buscar = new Estudiante();
                buscar.setMatricula(matriculaBuscar);
                arbol.buscarNodo(buscar);
                break;
                
            case 3:
                break;
                
            case 4:
                break;   
            
            case 5:
                break;
                
            case 6:
                System.out.println("Escriba la matricula del estudiante");
                String matInsc = sc.nextLine();
                System.out.println("Escriba el nombre completo del estudiante");
                String nomInsc = sc.nextLine();

                Estudiante alumno = new Estudiante();
                alumno.setMatricula(matInsc);
                alumno.setNombreCompleto(nomInsc);

                System.out.println("Escriba el nombre del curso");
                String nomCurso = sc.nextLine();
                
                Curso cursoSeleccionado = new Curso();
                cursoSeleccionado.setNombreCurso(nomCurso);
                cursoSeleccionado.inscribir(alumno);
                break;    
                
            case 7:
                System.out.println("Escriba el nombre del curso");
                String cursoMostrar = sc.nextLine();

                Curso cursoM = new Curso();
                cursoM.setNombreCurso(cursoMostrar);

                System.out.println("Alumnos Inscritos:");
                cursoM.getInscritos().mostrar();
                break;
                
            case 8:
                System.out.println("Escriba el nombre del curso");
                String cursoEspera = sc.nextLine();

                System.out.println("Cuantos estudiantes de la lista de espera desea mostrar?");
                int Mostrar = sc.nextInt();
                sc.nextLine();
           
                System.out.println("Seleccione el sentido del recorrido:");
                System.out.println("1. Hacia adelante (Siguiente)");
                System.out.println("2. Hacia atras (Anterior)");
                int Direccion = sc.nextInt();
                sc.nextLine();
                
                Curso cursoE = new Curso();
                cursoE.setNombreCurso(cursoEspera);
                cursoE.getListaEspera().mostrarListaEspera(Mostrar, Direccion);
               
                break;    
                
            case 9:
                break;    
                
            case 10:
                break;
                
            case 11:
                break;  
                
            case 12:
                System.out.println("Desea rotar roles, escriba SI/NO");
                String res = sc.nextLine();
                if(res.equalsIgnoreCase("SI")){
                    String mensaje =listaCircular.rotarRol();
                    System.out.println(mensaje);
                }else{
                  break;  
                }
                
                break;
                
            default:
                System.out.println("Escriba un numero valido");
                
        }     
    }
  }
    
}

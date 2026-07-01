/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

import java.util.Scanner;

/**
 * MENU DEL PROYECTO
 */
public class Menu {
    public static void main(String[] args) {
       
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
        
        int respuesta = sc.nextInt();
        
        switch(respuesta){
            case 1:
                break;
                
            case 2:
                break;
                
            case 3:
                break;
                
            case 4:
                break;   
            
            case 5:
                break;
                
            case 6:
                break;    
                
            case 7:
                break;    
                
            case 8:
                break;    
                
            case 9:
                break;    
                
            case 10:
                break;
                
            case 11:
                break;    
                
            default:
                System.out.println("Escriba un numero valido");
                
        }     
    }
    
}

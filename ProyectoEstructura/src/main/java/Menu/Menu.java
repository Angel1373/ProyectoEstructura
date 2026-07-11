/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

import Implementaciones.ArrayListQueue;
import Implementaciones.AVLTree;
import Implementaciones.BinarySearchTree;
import Implementaciones.CircularLinkedList;
import Implementaciones.HashMap;
import POJOs.Accion;
import POJOs.Acciones;
import POJOs.Contacto;
import POJOs.Curso;
import POJOs.Direccion;
import POJOs.Estudiante;
import POJOs.Inscripcion;
import POJOs.SolicitudCalificacion;
import POJOs.PromedioEstudiante;
import excepciones.BinarySearchTreeException;
import excepciones.MainException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * MENU DEL PROYECTO
 */
public class Menu {
    public static void main(String[] args) {
        
        BinarySearchTree<Estudiante> arbol = new BinarySearchTree();
        CircularLinkedList listaCircular = new CircularLinkedList();
        ArrayListQueue<SolicitudCalificacion> colaSolicitudes = new ArrayListQueue<>(SolicitudCalificacion.class, 50);
        Acciones historial = new Acciones();
        HashMap<String,Curso> catalogoDeCursos = new HashMap<>(20);
        Scanner sc = new Scanner(System.in);

        while(true){             
       
        System.out.println("\n");
        System.out.println("MENU DEL SISTEMA");
        System.out.println("ESCRIBA UN NUMERO PARA ACCEDER O ESCRIBA atras/ATRAS si desea salir");
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
        System.out.println("CALIFICACIONES---------------------------");
        System.out.println("9. Enviar solicitud de calificacion");
        System.out.println("10. Procesar siguiente solicitud");
        System.out.println("REPORTES--------------------------------");
        System.out.println("11. Listar estudiantes ordenados por promedio");
        System.out.println("12. Rotar roles");
        System.out.println("ACCIONES--------------------------------");
        System.out.println("13. Deshacer ultima accion \n");
        
             
        int respuesta = sc.nextInt();
        sc.nextLine();
        
        switch(respuesta){
            case 1:
                System.out.println("Escriba el nombre completo del estudiante o atras para salir");
                String nombre = sc.nextLine();
                if(nombre.equalsIgnoreCase("atras")){
                    break;
                }
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
                System.out.println("Desea agregar las calificaciones al estudiante? SI/NO");
                String respuestasc = sc.nextLine();
                ArrayList<Double> calificaciones = new ArrayList<>();
                while(respuestasc.equalsIgnoreCase("SI")){
                    try{
                    System.out.println("Escriba la calificacion del alumno");
                    double calificacion = sc.nextInt();
                    sc.nextLine();
                    calificaciones.add(calificacion);
                    System.out.println("Desea agregar otra calificacion? SI/NO");
                    respuestasc = sc.nextLine();
                    //Excepcion del scanner por si el usuario usa un formato invalido o en este caso letras
                    }catch(InputMismatchException e){
                       System.out.println("Escriba un numero valido");
                       sc.nextLine();
                    } 
                }
                
                Direccion direccion = new Direccion(calle,numero,colonia,ciudad);
                Contacto contacto = new Contacto(telefono,correo,direccion);
                Estudiante estudiante = new Estudiante();
                String matricula = estudiante.generarMatricula();
                estudiante.setNombreCompleto(nombre);
                estudiante.setContacto(contacto);
                estudiante.setMatricula(matricula);
                estudiante.setCalificaciones(calificaciones);
                try{
                    arbol.agregar(estudiante);
                    listaCircular.agregar(estudiante);
                    historial.agregarAccion(new Accion("REGISTRO",estudiante));
                }catch(MainException e){
                    throw new MainException("Error al intentar agregar al estudiante");
                }    
                arbol.imprimir();
                break;
            case 2:
                System.out.println("Escriba la matricula del estudiante o atras para salir");
                String matriculaBuscar = sc.nextLine();
                if(matriculaBuscar.equalsIgnoreCase("atras")){
                    break;
                }
                Estudiante buscar = new Estudiante();
                buscar.setMatricula(matriculaBuscar);
                try{
                   arbol.buscarNodo(buscar);
                }catch(MainException e){
                    throw new MainException("Estudiante no encontrado");
                }  
                break;
            case 3:     
                System.out.println("Escriba la clave del curso o atras para salir");
                String clave = sc.nextLine();
                if(clave.equalsIgnoreCase("atras")){
                    break;
                }
                System.out.println("Escriba el nombre del curso");
                String nombreCurso = sc.nextLine();
                if(nombreCurso.equalsIgnoreCase("atras")){
                    break;
                }
                System.out.println("Escriba el cupo maximo del curso");
                int cupo = sc.nextInt();
                              
                //Creamos el curso
                Curso nuevoCurso = new Curso(clave,nombreCurso,cupo);
                try{
                    //Lo mandamos al hashMap
                    catalogoDeCursos.put(clave, nuevoCurso);
                    System.out.println("Curso agregado correctamente");
                    historial.agregarAccion(new Accion("AGREGAR_CURSO", clave));
                }catch(MainException e){
                    throw new MainException("Error al intentar agregar el curso");
                }                           
                break;
                
            case 4:
                System.out.println("Escriba el nombre del curso que desea eliminar o atras para salir");
                String claveEliminar = sc.nextLine();
                if(claveEliminar.equalsIgnoreCase("atras")){
                    break;
                }
                Curso cursoEliminado = catalogoDeCursos.remove(claveEliminar);
                if(cursoEliminado != null){
                    System.out.println("Curso eliminado correctamente: " + cursoEliminado);
                    historial.agregarAccion(new Accion("ELIMINAR_CURSO", new Object[]{claveEliminar, cursoEliminado}));
                }else{
                    System.out.println("El curso no existe");
                }
                break;   
            
            case 5:
                if(catalogoDeCursos.isEmpty()){
                    System.out.println("No hay cursos registrados");
                }else{
                    catalogoDeCursos.mostrarTodos();
                }             
                break;
                
            case 6:              
                System.out.println("Escriba la matricula del estudiante o atras para salir");
                String matInsc = sc.nextLine();
                if(matInsc.equalsIgnoreCase("atras")){
                    break;
                }
                Estudiante buscar2 = new Estudiante();
                buscar2.setMatricula(matInsc);
                Estudiante estudianteBuscado = arbol.buscar(buscar2);
                if(estudianteBuscado != null){            
                    System.out.println("Escriba la clave del curso a inscribir");
                    String claveCurso = sc.nextLine();
                    Curso cursoSelec = catalogoDeCursos.obtenerValor(claveCurso);
                    if(cursoSelec != null){
                        cursoSelec.inscribir(estudianteBuscado);
                        Inscripcion inscripcion = new Inscripcion(estudianteBuscado, cursoSelec);
                        if (cursoSelec.getTotalInscritos() <= cursoSelec.getCapacidadMaxima()) {
                            historial.agregarAccion(new Accion("INSCRIPCION",inscripcion));
                            
                        }else{
                            historial.agregarAccion(new Accion("INSCRIPCION_ESPERA",inscripcion));
                        }
                    }else{
    
                        System.out.println("No se encontro el curso seleccionado");
                    }
                }else{
                    System.out.println("No se encontro al estudiante");
                }
                break;    
            case 7:
                System.out.println("Escriba la clave del curso o atras para salir");   
                String claveCurso = sc.nextLine();
                if(claveCurso.equalsIgnoreCase("atras")){
                    break;
                }
                Curso cursoBuscado = catalogoDeCursos.obtenerValor(claveCurso);
                if(cursoBuscado!=null){
                    System.out.println("Alumnos del curso: " + cursoBuscado.getNombreCurso());
                    cursoBuscado.getInscritos().mostrar();
                }else{
                    System.out.println("No se encontro el curso");
                }
                break;
            case 8:    
                 System.out.println("Escriba la clave del curso o atras para salir");   
                String claveC = sc.nextLine();
                if(claveC.equalsIgnoreCase("atras")){
                    break;
                }
                Curso cursoS = catalogoDeCursos.obtenerValor(claveC);
                if(cursoS == null){
                    System.out.println("No se encontro el curso seleccionado");
                    break;
                }
                //Esto es para que el usuario controle cuantas veces se va a recorrer
                System.out.println("Cuantos en la lista de estudiantes desea mostrar?");
                int opcion = sc.nextInt();
                
                System.out.println("Seleccione el sentido del recorrido");
                System.out.println("1 para ir hacia adelante (siguiente)");
                System.out.println("2 para ir hacia atras (anterior)");
                int lado = sc.nextInt();
                cursoS.getListaEspera().mostrarListaEspera(opcion, lado);         
                break;    
                
            case 9:
                System.out.println("Matricula del estudiante o atras para salir");
                String mat = sc.nextLine();
                if(mat.equalsIgnoreCase("atras")){
                    break;
                }
                Estudiante est = new Estudiante();
                est.setMatricula(mat);
                
                Estudiante encontrado = arbol.buscar(est);
                if (encontrado != null) {
                    System.out.println("Escriba la clave del curso");
                    String cursoClave =  sc.nextLine();
                    Curso cursoSelec = catalogoDeCursos.obtenerValor(cursoClave);
                    if(cursoSelec != null){
                        System.out.println("Escriba la calificacion a asignar");
                        double calificacion = sc.nextDouble();
                        //Enviamos la solicitud a la cola
                        colaSolicitudes.enqueue(new SolicitudCalificacion(encontrado,cursoSelec,calificacion));
                        System.out.println("Solicitud en cola");
                    }else{
                        System.out.println("No se encontro el curso");
                    }
                }else{
                    System.out.println("No se encontro el alumno");
                }               
              break;    
                
            case 10:
                //Obtenemos la ultima solicitud de la cola
                SolicitudCalificacion solicitud = colaSolicitudes.dequeue();
                if(solicitud != null){
                    Estudiante estudianteNuevaCalificacion = solicitud.getEstudiante();
                    double nuevaCalif = solicitud.getCalificacion();
                    //Le agregamos la nueva calificacion
                    estudianteNuevaCalificacion.getCalificaciones().add(nuevaCalif);
                    //Enviamos la accion para poder deshacerla
                    historial.agregarAccion(new Accion("CALIFICACION",estudianteNuevaCalificacion));
                    System.out.println("Calficacion procesada");
                }else{
                    System.out.println("No hay solicitudes pendientes");
                }            
                break;           
            case 11:           
                //Obtenemos a los estudiantes del arbol binario
                ArrayList<Estudiante> estudiantes = arbol.obtenerListaEstudiantesOrdenados();        
                if(estudiantes.isEmpty()){
                    System.out.println("No hay estudiantes registrados");
                }
                AVLTree<PromedioEstudiante> avl = new AVLTree<>();
                //Para cada estudiante calculamos y creamos un PromedioEstudiante para mandarlo al AVL
                for(Estudiante e : estudiantes){
                    double promedio = e.calcularPromedioRecursivo();
                    PromedioEstudiante promedioEstudiante = new PromedioEstudiante(promedio,e);
                    avl.agregar(promedioEstudiante);
                }
                avl.imprimirEnOrdenPorPromedio();                
                break; 
                
            case 12: 
                System.out.println("Desea rotar roles, escriba SI/NO o atras para salir");
                String res = sc.nextLine();
                if(res.equalsIgnoreCase("atras")){
                    break;
                }
                if(res.equalsIgnoreCase("SI")){
                    String mensaje =listaCircular.rotarRol();
                    System.out.println(mensaje);
                    historial.agregarAccion(new Accion("ROTAR_ROLES", null));
                } 
                break;
                
            case 13:
                Accion ultima = historial.deshacerAccion();
                if (ultima != null) {
                    ultima.deshacer(arbol, catalogoDeCursos, listaCircular);
                }
                break;
                           
            default:
                System.out.println("Escriba un numero valido");
                
        }     
    }
  }
    
}

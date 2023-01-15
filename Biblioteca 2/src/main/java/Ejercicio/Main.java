package Ejercicio;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        byte menu;
        Biblioteca biblio = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        String respuesta, isbn, titulo, dni;
        Publicacion publi = null;
        boolean prestado;
        
        System.out.println(biblio.leerDeFicheroTXT());
        
        
        do {

            System.out.println("\n\n----------------------------------"
                    + "\n1.-Isertar libro o investigación"
                    + "\n2.-Borrar por ISBN"
                    + "\n3.-Buscar por ISBN"
                    + "\n4.-Listar por orden de ISBN"
                    + "\n5.-Insertar 10 y mostrar"
                    + "\n6.-Salir"
                    + "\n----------------------------------");
            menu = sc.nextByte();
            sc.nextLine();

            switch (menu) {
                // ------------------------------------ CASE 1 ------------------------------------  
                case 1:
                    System.out.println("1.- Insertar libro / 2.- Insertar investigación");
                    respuesta = sc.nextLine();
                    
                    if (respuesta.equalsIgnoreCase("1")) { // Si es libro
                        
                        System.out.println("¿Está prestado? Si o no");
                        respuesta = sc.nextLine();
                        if (respuesta.equalsIgnoreCase("Si")) prestado = true; 
                        else prestado = false;
                        System.out.println("Dame un ISBN");
                        isbn = sc.nextLine();
                        System.out.println("Dame un título");
                        titulo = sc.nextLine();
                        System.out.println("La publicación por defecto es hoy.");
                        System.out.println("Por último, dame DNI");
                        dni = sc.nextLine();
                        while (!Util.validarDni(dni)) {
                            System.out.println("DNI no válido, vuelva a insertar otro: ");
                            dni = sc.nextLine();
                        }
                        publi = new Libro(prestado, isbn, titulo, LocalDate.now(), dni);
                        System.out.println(biblio.insertar(publi)?
                                "Se insertó correctamente el libro.":"No se pudo insertar");
                        
                    } else if (respuesta.equalsIgnoreCase("2")) { // Si es investigación
                        
                        System.out.println("¿Está revisado? Si o no");
                        respuesta = sc.nextLine();
                        String revisor = "";
                        if (respuesta.equalsIgnoreCase("Si")) {
                            prestado = true;
                            System.out.println("Nombre revisor");
                            revisor = sc.nextLine();
                        } 
                        else prestado = false;
                        System.out.println("¿Número de revista?");
                        int numero = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Dame un ISBN");
                        isbn = sc.nextLine();
                        System.out.println("Dame un título");
                        titulo = sc.nextLine();
                        System.out.println("La publicación por defecto es hoy.");
                        System.out.println("¿En qué mes se publicó?");
                        String mes = sc.nextLine();
                        System.out.println("Finalmente ¿Cuál es la temática?");
                        String tematica = sc.nextLine();
                        
                        publi = new Investigacion(prestado, revisor, numero, isbn, titulo, LocalDate.now(), mes, tematica);
                        System.out.println(biblio.insertar(publi)?
                                "Se insertó correctamente la investigación.":
                                "No se pudo insertar la investigación");
                        
                    } else {
                        System.out.println("Opción no válida, seleccione 1 o 2.");
                    }
                    break;
                // ------------------------------------ CASE 2 ------------------------------------ 
                case 2:
                    System.out.println("Inserte el ISBN de la publicación que quiera eliminar");
                    isbn = sc.nextLine();
                    System.out.println(biblio.eliminar(isbn)?"Se eliminó correctamente":
                            "No se encontró ninguna publicación de ISBN: "+isbn);
                    break;
                // ------------------------------------ CASE 3 ------------------------------------ 
                case 3:
                    System.out.println("Inserte el ISBN de la publicación que quieras buscar");
                    isbn = sc.nextLine();
                    publi = biblio.buscar(isbn);
                    if (publi != null) System.out.println(publi.toString());
                    else System.out.println("No se encontró ningúna publicación de ISBN:"+isbn);
                    break;
                // ------------------------------------ CASE 3 ------------------------------------ 
                case 4:
                    System.out.println("\n ------------ Lista de publicaciones --------------");
                    System.out.println(biblio.listar());
                    System.out.println("--------------------------------------------------");
                    break;
                // ------------------------------------ CASE 3 ------------------------------------ 
                case 5:
                    boolean pruebaInsertar = biblio.insertar10();
                    System.out.println(pruebaInsertar?"Se insertaron correctamente 10 publicaciones":
                            "Esta opción solo es válida 1 vez.");
                    if (pruebaInsertar) System.out.println(biblio.listar());
                    break;
                // ------------------------------------ CASE 0 ------------------------------------ 
                case 0:
                    break;
                // ------------------------------------ CASE DEF ------------------------------------ 
                default:
                    break;
            } // FIN SWITCH
        } while (menu != 6); // FIN DO WHILE
        
        System.out.println(biblio.escribirEnTXT());
        
    } // FIN MAIN
} // FIN CLASS

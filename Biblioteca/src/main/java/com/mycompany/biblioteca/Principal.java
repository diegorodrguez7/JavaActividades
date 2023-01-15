/**
 *
 */
package com.mycompany.biblioteca;

import java.util.Scanner;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Principal
 */
public class Principal {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int menu;
        //Variables de libro.
        String codigoISBN, titulo, dniAutor;
        int anioPublicacion = 0;
        boolean prestado = false;
        //Variables Investigacion.
        String mes;
        int numero;
        String tematica;
        boolean revisado = false;
        String revisor;
        do {
            Menu.MenuOpciones();
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("Que quieres insertar?(libro o inv)");
                    String tipo = sc.nextLine();
                    if (tipo.equalsIgnoreCase("libro")) {
                        System.out.println("Inserta el codigo: ");
                        codigoISBN = sc.nextLine();
                        System.out.println("Inserta el titulo: ");
                        titulo = sc.nextLine();
                        System.out.println("Inserta el dni del autor: ");
                        dniAutor = sc.nextLine();
                        while (!ValidarDni.validarDni(dniAutor)) {
                            System.out.println("El dni no es valido. Vuelva a introducirlo.");
                            dniAutor = sc.nextLine();
                        }
                        System.out.println("Inserta el ano de publicacion: ");
                        anioPublicacion = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Esta prestado?(si o no)");
                        String estaPrestadoLibro = sc.nextLine();
                        if (estaPrestadoLibro.equalsIgnoreCase("si")) {
                            prestado = true;
                        } else if (estaPrestadoLibro.equalsIgnoreCase("no")) {
                            prestado = false;
                        }
                        Libro libro1 = new Libro(codigoISBN, titulo, anioPublicacion, prestado, dniAutor);
                        if (biblioteca.insertar(libro1)) {
                            System.out.println("Se inserto el libro.");
                        } else {
                            System.out.println("No se pudo.");
                        }
                    } else if (tipo.equalsIgnoreCase("inv")) {
                        System.out.println("Inserta el codigo: ");
                        codigoISBN = sc.nextLine();
                        System.out.println("Inserta el titulo: ");
                        titulo = sc.nextLine();
                        System.out.println("Inserta el dni: ");
                        dniAutor = sc.nextLine();
                        System.out.println("Inserta el mes: ");
                        mes = sc.nextLine();
                        System.out.println("Inserta el numero: ");
                        numero = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Inserta la tematica: ");
                        tematica = sc.nextLine();
                        System.out.println("Inserta el revisor: ");
                        revisor = sc.nextLine();
                        System.out.println("Esta revisado?(si o no)");
                        String revisadoInv = sc.nextLine();
                        if(revisadoInv.equalsIgnoreCase("si")){
                            revisado = true;
                        }else if(revisadoInv.equalsIgnoreCase("no")){
                            revisado = false;
                        }
                        Investigacion investigacion1 = new Investigacion(codigoISBN, titulo, anioPublicacion, mes, numero, tematica, revisado, revisor);
                        if(biblioteca.insertar(investigacion1)){
                            System.out.println("Se inserto la investigacion.");
                        }else{
                            System.out.println("No se pudo insertar.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("-Metodo borrar publicacion-");
                    System.out.println("Inserta el codigo isbn de la publicacion que quieres borrar: ");
                    codigoISBN = sc.nextLine();
                    if(biblioteca.borrar(codigoISBN)){
                        System.out.println("Se borro la publicacion.");
                    }else{
                        System.out.println("No se pudo borrar.");
                    }
                    break;
                case 3:
                    System.out.println("Metodo de buscar.");
                    System.out.println("Inserta el codigo isbn de la publicacion que quieres buscar: ");
                    codigoISBN = sc.nextLine();
                    Publicacion publicacionAux = biblioteca.buscarPublicacion(codigoISBN);
                    if(publicacionAux!=null){
                        System.out.println(publicacionAux.toString());
                    }else{
                        System.out.println("No existe esa publicacion.");
                    }
                    break;
                case 4:
                    System.out.println("Metodo listar todo.");
                    biblioteca.listarTodo();
                    break;
                case 5:
                    System.out.println("Insertar 10 diez publicaciones.");
                    biblioteca.insertarDiez();
                    break;
                case 6:
                    System.out.println("Ficheros");
                    biblioteca.cargarArchivo();
                    break;
                case 7:
                    System.out.println("Ficheros");
                    biblioteca.escribirFichero();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
            }
        } while (menu != 0);
    }

}

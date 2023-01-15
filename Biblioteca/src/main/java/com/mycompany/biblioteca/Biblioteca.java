/**
 *
 */
package com.mycompany.biblioteca;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Biblioteca
 */
public class Biblioteca {

    TreeMap<String, Publicacion> biblioteca;

    public Biblioteca() {
        this.biblioteca = new TreeMap<>();
    }

    //Comprobar si es repetido no, insertando Libro, sin tener que mirar con bucle For.
    public boolean insertar(Publicacion publicacionLibro) {
        if (biblioteca.containsKey(publicacionLibro.getCodigoISBN())) {
            return false;
        } else if (biblioteca.put(publicacionLibro.getCodigoISBN(), publicacionLibro) == null) {
            return true;
        }
        return false;
    }

    //Borrar Publicacion.
    public boolean borrar(String isbn) {
        if (biblioteca.containsKey(isbn)) {
            if (biblioteca.remove(isbn) != null) {
                return true;
            }
        }
        return false;
    }

    //--------------------------------------------------
    //Buscar Publicacion Carmen
    public Publicacion buscarPublicacion(String isbn) {
        for (Map.Entry<String, Publicacion> entry : biblioteca.entrySet()) {
            String key = entry.getKey();
            Publicacion value = entry.getValue();
            if (isbn.equalsIgnoreCase(key)) {
                return value;
            }
        }
        return null;
    }

    //Buscar PublicacionDos Aram
    public Publicacion buscarPublicacionDos(String isbn) {
        if (biblioteca.containsKey(isbn)) {
            System.out.println(biblioteca.values());
        }
        return null;
    }
    //-----------------------------------------------------

    //Listar todas las publicaciones desde un SystemOut.
    public void listarTodo() {
        for (Map.Entry<String, Publicacion> entry : biblioteca.entrySet()) {
            String key = entry.getKey();
            Publicacion value = entry.getValue();
            System.out.println(value);
        }
    }

    public void insertarDiez() {
        //Libros.
        biblioteca.put("1234", new Libro("1234", "titulo8", 2011, true, "42417636R"));
        biblioteca.put("1232", new Libro("1232", "titulo2", 2011, true, "42417636R"));
        biblioteca.put("1237", new Libro("1237", "titulo9", 2011, true, "42417636R"));
        biblioteca.put("1235", new Libro("1235", "titulo4", 2011, true, "42417636R"));
        biblioteca.put("1233", new Libro("1233", "titulo65", 2011, true, "42417636R"));
        //Investigaciones.
        biblioteca.put("2221", new Investigacion("2221", "titulo33", 2011, "Febrero", 1, "dinero", true, "Diego"));
        biblioteca.put("2222", new Investigacion("2222", "titulo223", 2011, "Febrero", 1, "dinero", true, "Diego"));
        biblioteca.put("2223", new Investigacion("2223", "titulo24", 2011, "Febrero", 1, "dinero", true, "Diego"));
        biblioteca.put("2224", new Investigacion("2224", "titulo255", 2011, "Febrero", 1, "dinero", true, "Diego"));
        biblioteca.put("2225", new Investigacion("2225", "titulo223", 2011, "Febrero", 1, "dinero", true, "Diego"));
        listarTodo();
    }

    //Leer/cargar publicacion.
    public void cargarArchivo() {
        FileReader fileIS = null;
        BufferedReader bufer = null;
        try {
            fileIS = new FileReader("publicaciones.txt");
            bufer = new BufferedReader(fileIS);

            //Variable para cada linea.
            String leerLinea = "";

            //Variables para leer el fichero.
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

            //Array para guardar cada parte de la linea del fichero.
            String[] leerPartes = new String[9];

            while (leerLinea != null) {
                try {
                    leerLinea = bufer.readLine();
                    if (leerLinea != null) {
                        leerPartes = leerLinea.split("\\*\\*\\*\\*");
                        if (leerPartes.length >= 6) {
                            codigoISBN = leerPartes[0];
                            titulo = leerPartes[1];
                            anioPublicacion = parseInt(leerPartes[2]);
                            int tipoPublicacion = parseInt(leerPartes[3]);
                            switch (tipoPublicacion) {
                                case 1:
                                    dniAutor = leerPartes[4];
                                    String prestadoAux = leerPartes[5];
                                    if (prestadoAux.equalsIgnoreCase("true")) {
                                        prestado = true;
                                    } else if (prestadoAux.equalsIgnoreCase("false")) {
                                        prestado = false;
                                    }
                                    Libro libro1 = new Libro(codigoISBN, titulo, anioPublicacion, prestado, dniAutor);
                                    insertar(libro1);
                                    break;
                                case 2:
                                    tematica = leerPartes[4];
                                    numero = parseInt(leerPartes[5]);
                                    mes = leerPartes[6];
                                    String variableAux = leerPartes[7];
                                    if (variableAux.equalsIgnoreCase("true")) {
                                        revisado = true;
                                    } else if (variableAux.equalsIgnoreCase("false")) {
                                        revisado = false;
                                    }
                                    revisor = leerPartes[8];
                                    Investigacion investigacion1 = new Investigacion(codigoISBN, titulo, anioPublicacion, mes, numero, tematica, revisado, revisor);
                                    insertar(investigacion1);
                                    break;

                            }
                        }
                    }
                } catch (EOFException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (fileIS != null) {
                    fileIS.close();
                }
                if (bufer != null) {
                    bufer.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    //metodo escribir fichero ordenado por txt.
    public void escribirFichero() {
        Comparator<Publicacion>compararTitulo = new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion o1, Publicacion o2) {
                return o1.getTitulo().compareTo(o2.getTitulo());
            }
        };
        ArrayList<Publicacion>listaTitulo = new ArrayList<>();
        listaTitulo.addAll(biblioteca.values());
        listaTitulo.sort(compararTitulo);
        FileWriter fileW = null;
        String separador = "****";
        try {
            fileW = new FileWriter("publicaciones.txt");
            for (Publicacion publicacion : listaTitulo) {
                if (publicacion instanceof Libro) {
                    String lineaFichero = publicacion.getCodigoISBN() + separador + publicacion.getTitulo() + separador + publicacion.getAnioPublicacion()
                            + separador + 1 + separador + ((Libro) publicacion).getDniAutor() + separador + ((Libro) publicacion).estaPrestado() + "\n";
                    fileW.write(lineaFichero);
                } else if (publicacion instanceof Investigacion) {
                    String lineaFichero = publicacion.getCodigoISBN() + separador + publicacion.getTitulo() + separador + publicacion.getAnioPublicacion()
                            + separador + 2 + separador + ((Investigacion) publicacion).getTematica() + separador + ((Investigacion) publicacion).getNumero()
                            + separador + ((Investigacion) publicacion).getMes() + separador + ((Investigacion) publicacion).isRevisado() + separador
                            + ((Investigacion) publicacion).getRevisor() + "\n";
                    fileW.write(lineaFichero);
                }
            }
        } catch (FileNotFoundException ex){
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally { 
            try{
                if(fileW != null){
                    fileW.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}

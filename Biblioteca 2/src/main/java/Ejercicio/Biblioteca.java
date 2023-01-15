package Ejercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Biblioteca {

    private Set<Publicacion> biblioteca = new TreeSet<>();

    // -- CONSTRUCTORES --
    public Biblioteca() {
    }

    // -- GETTERS --
    public Set<Publicacion> getBiblioteca() {
        return biblioteca;
    }

    // -- SETTERS --
    private void setBiblioteca(Set<Publicacion> pub) {
        biblioteca = pub;
    }

    // -- MÉTODOS --
    public boolean insertar(Publicacion publ) {
        return biblioteca.add(publ);
    }

    // ELIMINAR POR PUBLICACIÓN
    public boolean eliminar(Publicacion publ) {
        return biblioteca.remove(publ);
    }

    // ELIMINAR POR ISBN
    public boolean eliminar(String isbn) {
        for (Publicacion pub : biblioteca) {
            if (pub.getIsbn().equalsIgnoreCase(isbn)) {
                return eliminar(pub);
            }
        }
        return false;
    }

    public Publicacion buscar(String isbn) {
        for (Publicacion pub : biblioteca) {
            if (pub.getIsbn().equalsIgnoreCase(isbn)) {
                return pub;
            }
        }
        return null;
    }

    public String listar() {
        String cadena = "";
        for (Publicacion pub : biblioteca) {
            cadena = cadena + pub.toString() + "\n\n";
        }
        return cadena;
    }

    public boolean insertar10() {
        int auxiliar = biblioteca.size();
        for (int i = 3500; i < 3510; i++) {
            String dni = i + "" + i + "B";
            insertar(new Libro(true, i + "", "Random" + i, LocalDate.now(), dni));
        }
        // Devuelve true si se insertaron elementos
        return (auxiliar < biblioteca.size());
    }

    public boolean escribirEnTXT() {
        FileWriter fw = null;
        PrintWriter pw = null;
        boolean prueba = false;
        try {
            fw = new FileWriter("Publicaciones.txt");
            pw = new PrintWriter(fw);
            for (Publicacion publ : biblioteca) {
                pw.write(publ.getIsbn() + "****"
                        + publ.getTitulo() + "****"
                        + publ.getAnoPublicado() + "****");
                if (publ instanceof Libro) {
                    Libro lib = (Libro) publ;
                    String prestamo;
                    if (lib.isPrestado()) {
                        prestamo = "1";
                    } else {
                        prestamo = "0";
                    }
                    pw.write("1" + "****"
                            + lib.getAutorDNI() + "****"
                            + prestamo + "****"
                    );
                } else {
                    Investigacion inv = (Investigacion) publ;
                    String revision;
                    if (inv.isRevisado()) {
                        revision = "1";
                    } else {
                        revision = "0";
                    }
                    pw.write("2" + "****"
                            + inv.getTematica() + "****"
                            + inv.getNumero() + "****"
                            + inv.getMes() + "****"
                            + revision + "****"
                            + inv.getRevisor());

                }
                prueba = true;
                pw.write("****" + "\n");
            } // FIN FOR-EACH
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
            }
        }
        return prueba;
    }

    public boolean leerDeFicheroTXT() {
        FileReader fr = null;
        BufferedReader br = null;
        boolean prueba = false;
        String cad;
        String[] cadena;
        try {
            fr = new FileReader("Publicaciones.txt");
            br = new BufferedReader(fr);
            while (true) {
                cad = br.readLine();
                cadena = cad.split("\\*\\*\\*\\*");
                
                if (cadena.length < 3) {
                    break;
                }
                
                String isbn = cadena[0]; // pos 0
                String titulo = cadena[1]; // pos 1
                String[] cadenaAnoPub = cadena[2].split("-"); // pos 2
                LocalDate anoPublicacion = LocalDate.of(Integer.parseInt(cadenaAnoPub[0]), Integer.parseInt(cadenaAnoPub[1]),
                        Integer.parseInt(cadenaAnoPub[2]));

         
                if (cadena[3].equalsIgnoreCase("1")) { // pos 3  
                    String autorDni = cadena[4]; // pos 4
                    boolean prestado = false;
                    if (cadena[5].equalsIgnoreCase("1")) prestado = true; // pos 5
                    insertar(new Libro(prestado, isbn, titulo, anoPublicacion, autorDni));
    
                } else { // pos 3
                    String tematica = cadena[4]; // pos 4
                    int numero = Integer.parseInt(cadena[5]); // pos 5
                    String mes = cadena[6]; // pos 6
                    boolean revisado = false;
                    String revisor = "";
                    if (cadena[7].equalsIgnoreCase("1")) { // pos 7
                        revisado = true;
                        revisor = cadena[8];
                    }
                    insertar(new Investigacion(revisado, revisor, numero, isbn, titulo, anoPublicacion, mes, tematica));
                    prueba = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
            }
        }
        return prueba;
    }
} // FIN CLASS

package Ejercicio;

import java.time.LocalDate;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Libro extends Publicacion implements Prestable{
    private boolean prestado;
    private String autorDNI;
    // -- CONSTRUCTORES --
    public Libro(boolean prestado, String isbn, String titulo, LocalDate anoPublicado, String dni) {
        super(isbn, titulo, anoPublicado);
        this.prestado = prestado;
        // El DNI se valida desde fuera antes de ser insertado.
        autorDNI = dni;
    }
    // -- GETTERS --
    public boolean isPrestado() {
        return prestado;
    }
    public String getAutorDNI() {
        return autorDNI;
    }
    
    // -- SETTERS --
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void setAutorDNI(String autorDNI) {
        this.autorDNI = autorDNI;
    }
    // -- MÉTODOS --
    @Override
    public void presta(boolean pre) {
        prestado = pre;
    }
    @Override
    public void devuelve(boolean dev) {
        prestado = dev;
    }
    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return "Libro{" + 
                "\nisbn=" + getIsbn() + 
                "\ntitulo=" + getTitulo() + 
                "\nanoPublicado=" + getAnoPublicado() +
                "\nprestado=" + prestado + 
                "\nautorDNI=" + autorDNI + '}';
    }

    

} // FIN CLASS

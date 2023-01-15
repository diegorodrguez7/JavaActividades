package Ejercicio;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public abstract class Publicacion implements Comparable<Publicacion> {
    private String isbn;
    private String titulo;
    private LocalDate anoPublicado;  
    // -- CONSTRUCTORES --
    public Publicacion(String isbn, String titulo, LocalDate anoPublicado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicado = anoPublicado;
    }
    // -- GETTERS --
    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public LocalDate getAnoPublicado() {
        return anoPublicado;
    }
    // -- SETTERS --
    
    // -- MÉTODOS --

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicado(LocalDate anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }
    @Override
    public int compareTo(Publicacion o) {
        return this.isbn.compareToIgnoreCase(o.isbn);
    }

    @Override
    public String toString() {
        return "Publicacion{" + 
                "\nisbn=" + isbn + 
                "\ntitulo=" + titulo + 
                "\nanoPublicado=" + anoPublicado + '}';
    }
    
    

    

} // FIN CLASS

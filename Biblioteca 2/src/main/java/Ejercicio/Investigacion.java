package Ejercicio;

import java.time.LocalDate;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Investigacion extends Revista {
    private boolean revisado;
    private String revisor;
    // -- CONSTRUCTORES --
    public Investigacion(boolean revisado, String revisor, int numero, String isbn, String titulo, LocalDate anoPublicado, String mes, String tematica) {
        super(numero, isbn, titulo, anoPublicado, mes, tematica);
        if (revisado) {
            this.revisor = revisor;
        }
        this.revisado = revisado;
        
    }
    // -- GETTERS --
    public boolean isRevisado() {
        return revisado;
    }
    public String getRevisor() {
        return revisor;
    }
    // -- SETTERS --
    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    // -- MÉTODOS --

    
    @Override
    public String toString() {
        return "Libro{" + 
                "\nisbn=" + getIsbn() + 
                "\ntitulo=" + getTitulo() + 
                "\nanoPublicado=" + getAnoPublicado() +
                "\nrevisado=" + revisado + 
                "\nrevisor=" + revisor + '}';
    }
    

    

} // FIN CLASS

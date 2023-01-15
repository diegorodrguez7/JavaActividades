package Ejercicio;

import java.time.LocalDate;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Periodico extends Publicacion {
    private String frecuencia;
    // -- CONSTRUCTORES --
    public Periodico(String frecuencia, String isbn, String titulo, LocalDate anoPublicado) {
        super(isbn, titulo, anoPublicado);
        this.frecuencia = frecuencia;
    }
    // -- GETTERS --
    public String getFrecuencia() {
        return frecuencia;
    }
    // -- SETTERS --
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
    // -- MÉTODOS --
    

} // FIN CLASS

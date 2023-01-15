package Ejercicio;

import java.time.LocalDate;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Revista extends Publicacion {
    private int numero;
    private String mes;
    private String tematica;
    // -- CONSTRUCTORES --
    public Revista(int numero, String isbn, String titulo, LocalDate anoPublicado, String mes, String tematica) {
        super(isbn, titulo, anoPublicado);
        this.numero = numero;
        this.mes = mes;
        this.tematica = tematica;
    }
    // -- GETTERS --
    public int getNumero() {
        return numero;
    }
    public String getMes() {
        return mes;
    }
    public String getTematica() {
        return tematica;
    }
    // -- SETTERS --
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    // -- MÉTODOS --

    

    

    

    

} // FIN CLASS

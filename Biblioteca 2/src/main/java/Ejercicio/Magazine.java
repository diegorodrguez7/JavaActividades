package Ejercicio;

import java.time.LocalDate;

/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Magazine extends Revista {
    private int semana;
    // -- CONSTRUCTORES --
    public Magazine(int semana, int numero, String isbn, String titulo, LocalDate anoPublicado, String mes, String tematica) {
        super(numero, isbn, titulo, anoPublicado, mes, tematica);
        this.semana = semana;
    }
    // -- GETTERS --
    public int getSemana() {
        return semana;
    }
    // -- SETTERS --
    public void setSemana(int semana) {
        this.semana = semana;
    }
    // -- MÉTODOS --

    

    

    

} // FIN CLASS

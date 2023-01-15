/**
 *
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Magazine
 */
public class Magazine extends Revista {

    private int semana;

    public Magazine(String codigoISBN, String titulo, int anioPublicacion, String mes, int numero, String tematica, int semana) {
        super(codigoISBN, titulo, anioPublicacion, mes, numero, tematica);
        this.semana = semana;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    @Override
    public String toString() {
        return "Magazine{" + "semana=" + semana + '}';
    }

    
}

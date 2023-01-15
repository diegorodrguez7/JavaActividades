/**
 * 
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0
 * Nombre de la Clase: Periodico
 */
public class Periodico extends Publicacion{

    private String frecuencia;

    public Periodico(String codigoISBN, String titulo, int anioPublicacion, String frecuencia) {
        super(codigoISBN, titulo, anioPublicacion);
        this.frecuencia = frecuencia;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Periodico{" + "frecuencia=" + frecuencia + '}';
    }
    
    
}

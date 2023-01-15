/**
 *
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Revista
 */
public abstract class Revista extends Publicacion {

    private String mes;
    private int numero;
    private String tematica;

    public Revista(String codigoISBN, String titulo, int anioPublicacion, String mes, int numero, String tematica) {
        super(codigoISBN, titulo, anioPublicacion);
        this.mes = mes;
        this.numero = numero;
        this.tematica = tematica;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return super.toString() + "Revista{" + "mes=" + mes + ", numero=" + numero + ", tematica=" + tematica + '}';
    }

    
}

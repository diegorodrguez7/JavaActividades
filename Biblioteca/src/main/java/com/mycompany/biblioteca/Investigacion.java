/**
 * 
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0
 * Nombre de la Clase: Investigacion
 */
public class Investigacion extends Revista{

    private boolean revisado;
    private String revisor;

    public Investigacion(String codigoISBN, String titulo, int anioPublicacion, String mes, int numero, String tematica, boolean revisado, String revisor)
    {
        super(codigoISBN, titulo, anioPublicacion, mes, numero, tematica);
        this.revisado = revisado;
        this.revisor = revisor;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return super.toString() + "Investigacion{" + "revisado=" + revisado + ", revisor=" + revisor + '}';
    }
    
    
    
}

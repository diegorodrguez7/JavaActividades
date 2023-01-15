/**
 *
 */
package com.mycompany.biblioteca;

import java.util.Objects;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Publicacion
 */
public abstract class Publicacion extends Biblioteca implements Comparable<Publicacion> {

    private String codigoISBN;
    private String titulo;
    private int anioPublicacion;

    public Publicacion(String codigoISBN, String titulo, int anioPublicacion) {
        this.codigoISBN = codigoISBN;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Publicacion: " + "codigoISBN=" + codigoISBN + ", titulo=" + titulo + ", anioPublicacion=" + anioPublicacion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoISBN);
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
        if (this.codigoISBN.equalsIgnoreCase(other.codigoISBN)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Publicacion o) {
        return codigoISBN.compareTo(o.codigoISBN);
    }

}

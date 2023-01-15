/**
 *
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: Libro
 */
public class Libro extends Publicacion implements Prestable {

    private boolean prestado;
    private String dniAutor;

    public Libro(String codigoISBN, String titulo, int anioPublicacion, boolean prestado, String dniAutor) {
        super(codigoISBN, titulo, anioPublicacion);
        this.prestado = prestado;
        this.dniAutor = dniAutor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    @Override
    public String toString() {
        return super.toString() + "Libro{" + "prestado=" + prestado + ", dniAutor=" + dniAutor + '}';
    }

    @Override
    public boolean presta() {
        if (!prestado) {
            setPrestado(true);
            return true;//Se cumplio.
        }
        return false;
    }

    @Override
    public boolean devuelve() {
        if (prestado) {
            setPrestado(false);
            return true;//Se cumplio.
        }
        return false;
    }

    @Override
    public boolean estaPrestado() {
        return isPrestado();
    }

}

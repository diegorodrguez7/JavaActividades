/**
 *
 */
package com.mycompany.biblioteca;

/**
 * @date 16 jun 2022
 * @author Diego Rodríguez Jacinto <drplaybasketball@gmail.com> 1DAW Número 26.
 * @version 1.0 Nombre de la Clase: ValidarDni
 */
public class ValidarDni {

    public static boolean validarDni(String dni) {
        return dni.matches("[A-Z]?[0-9]{8}[A-Z]{1}");//Para NIF y DNI.
    }
}

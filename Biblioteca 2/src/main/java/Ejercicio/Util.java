package Ejercicio;
/**
 * @author Brian Alvarez Bermúdez
 * @date 10 jun. 2022
 * @version 1.0
 */
public class Util {

    // -- CONSTRUCTORES --
    
    // -- GETTERS --
    public static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[A-Za-z]$");
    }
    // -- SETTERS --

    // -- MÉTODOS --

} // FIN CLASS

package exceptions;

/**
 * Excepci�n programada para que se ejecute cuando se instancia un objeto de
 * tipo personaje con un nombre que no se encuentre en la base de datos
 * 
 * @author toled
 *
 */
public class PersonajeNoExisteException extends Exception {
	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrar� cuando
	 * surja la excepci�n
	 * 
	 * @param message mensaje que se muestra cuando surje la excepci�n.
	 */
	public PersonajeNoExisteException(String message) {
		super(message);
	}

}

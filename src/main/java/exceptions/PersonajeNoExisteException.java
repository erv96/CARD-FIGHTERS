package exceptions;

/**
 * Excepción programada para que se ejecute cuando se instancia un objeto de
 * tipo personaje con un nombre que no se encuentre en la base de datos
 * 
 * @author toled
 *
 */
public class PersonajeNoExisteException extends Exception {
	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrará cuando
	 * surja la excepción
	 * 
	 * @param message mensaje que se muestra cuando surje la excepción.
	 */
	public PersonajeNoExisteException(String message) {
		super(message);
	}

}
